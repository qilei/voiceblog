<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布文字</title>
<script src="${ctx}/resources/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#entry-create-tab").addClass("active");
});
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<form id="mainForm" name="mainForm" method="post" action="${ctx }/admin/entry/create">
				<input type="hidden" id="id" name="id" value="${entry.id }" />
				<input type="hidden" id="postDate" name="postDate" value="${entry.postDateString }" />
				<input type="hidden" id="postStatus" name="postStatus" value="publish" />
				<div class="span9">
					<fieldset>
						<legend>发布文字</legend>
						<label for="subject">标题</label> 
						<input type="text" id="subject" name="subject" value="${entry.subject }" class="input-block-level" />
						<label for="body">内容</label>
						<textarea rows="15" id="body" name="body" class="input-block-level" >${entry.body }</textarea>
						<span class="pull-right">
							<button type="submit" class="btn btn-primary">发布</button>
						</span>
						<button type="button" class="btn">取消</button>
					</fieldset>
				</div>
				<div class="span3">
					<select id="visibility" name="visibility">
						<c:forEach var="entry" items="${visibility }">
							<option value="${entry.key}">${entry.value }</option>
						</c:forEach>
					</select> 
					<label>类别</label> 
					<select id="category" name="category.id">
						<c:forEach var="category" items="${categories }">
							<option value="${category.id }">${category.categoryName }</option>
						</c:forEach>
					</select>
				</div>
			</form>
		</div>
	</div>
	<!--<ckeditor:replace replace="body" basePath="${ctx }/resources/ckeditor/" />-->
	<script type="text/javascript">
		CKEDITOR.replace('body',
						{
							filebrowserUploadUrl : '${ctx }/admin/entry/uploadimg?Type=File',
							filebrowserImageUploadUrl : '${ctx }/admin/entry/uploadimg?Type=Image',
							filebrowserFlashUploadUrl : '${ctx }/admin/entry/uploadimg?Type=Flash'
						});
	</script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#mainForm").validate({
				rules:{
					subject:"required"
				},
				messages:{
					subject:{
						required:"^_^忘记标题啦"
					}
				}
			});	
		});
	</script>
</body>
</html>