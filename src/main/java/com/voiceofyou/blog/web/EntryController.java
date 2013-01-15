package com.voiceofyou.blog.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.voiceofyou.blog.domain.Category;
import com.voiceofyou.blog.domain.Entry;
import com.voiceofyou.blog.domain.Visibility;
import com.voiceofyou.blog.service.CategoryService;
import com.voiceofyou.blog.service.EntryService;

@Controller
public class EntryController {
	private EntryService entryService;
	private CategoryService categoryService;

	@Autowired
	public EntryController(EntryService entryService,
			CategoryService categoryService) {
		super();
		this.entryService = entryService;
		this.categoryService = categoryService;
	}

	@RequestMapping(value={"/index","/"})
	public String list(Model model,@RequestParam(value="p",defaultValue="1") Integer page){
		Sort sort=new Sort(Sort.Direction.DESC,"postDate");
		PageRequest pageRequest=new PageRequest(page-1,10,sort);
		Page<Entry> entries=entryService.findAll(pageRequest);
		model.addAttribute("entries", entries.getContent());
		return "entry/list";
	}

	@RequestMapping(value={"/admin/entry/create","/admin"},method=RequestMethod.GET)
	public String createForm(Model model){
		//下拉菜单数据源
		List<Category> categories=categoryService.findAll();
		
		model.addAttribute("categories", categories);
		model.addAttribute("entry",new Entry());
		model.addAttribute("visibility", Visibility.options());
		
		return "entry/create";
	}
	
	@RequestMapping(value="/admin/entry/create",method=RequestMethod.POST)
	public String save(Entry entry){
		entry.setPostDate(new Date());
		entryService.add(entry);
		return "redirect:/";
	}
	
	@RequestMapping(value="/entry/item")
	public String item(Model model,int id){
		Entry entry=entryService.find(id);
		model.addAttribute("entry", entry);
		return "entry/item";
	}
	
	@RequestMapping(value="/admin/entry/uploadimg",method=RequestMethod.POST)
	public String uploadImg(HttpServletRequest request,HttpServletResponse response, @RequestParam(value="upload", required=false) Part file) throws IOException{
		String uploadDir = request.getServletContext().getInitParameter("uploadDir");
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		
		String sourceFileName=getFileName(file);
		String fileNameExt=sourceFileName.substring(sourceFileName.indexOf("."));
		String destFileName=format.format(new Date())+fileNameExt;
		
		String realPath=request.getServletContext().getRealPath("/")+uploadDir + File.separator;
		String realFileName=realPath+destFileName;
		
		String virtualPath=request.getContextPath()+ "/" + uploadDir+ "/" +destFileName;

		File realDir=new File(realPath);
		if (!realDir.exists()) {
			realDir.mkdir();
		}
		
		File newFile=new File(realPath,destFileName);
		OutputStream outputStream = new FileOutputStream(newFile);
        InputStream filecontent = file.getInputStream();
		
		try {

	        int read = 0;
	        final byte[] bytes = new byte[1024];

	        while ((read = filecontent.read(bytes)) != -1) {
	        	outputStream.write(bytes, 0, read);
	        }
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
            if (outputStream != null) {
            	outputStream.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
		}
		
        PrintWriter out=response.getWriter();
        
		String callback = request.getParameter("CKEditorFuncNum");
		out.println("<script type=\"text/javascript\">");
		out.println("window.parent.CKEDITOR.tools.callFunction(" + callback
				+ ",'" + virtualPath + "',''" + ")");
		out.println("</script>");
		out.flush();
		out.close();
        
		return null;
	}

	private String getFileName(Part part) {
		String partHeader = part.getHeader("content-disposition");
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				return cd.substring(cd.indexOf('=') + 1).trim()
						.replace("\"", "");
			}
		}
		return null;
	}
}
