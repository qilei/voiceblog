<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
		<div class="span10">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>标题</th>
						<th>作者</th>
						<th>日期</th>
						<th>浏览</th>
						<th>评论</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="entry" items="${entries }">
						<tr>
							<td>${entry.subject }</td>
							<td></td>
							<td>${entry.postDate }</td>
							<td>${entry.viewCount }</td>
							<td>${entry.commentCount }</td>
							<td>
								<a href="${ctx }/admin/entry/edit?id=${entry.id}">编辑</a>&nbsp;
								<a href="${ctx }/admin/entry/trash?id=${entry.id}">移至回收站</a>&nbsp;
								<a href="${ctx }/entry/item?id=${entry.id}" target="_blank">查看</a>
							</td>
						</tr>				
					</c:forEach>
				</tbody>
			</table>
			<div class="pagination pagination-right">
				<ul>
					<li><a href="#"><<</a></li>
					<li class="active"><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">>></a></li>
				</ul>
			</div>
		</div>
		</div>
	</div>
</body>
</html>