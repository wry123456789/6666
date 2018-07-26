<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--  <tr><td>商品名称</td><td><input type="text"name="name" value="${cate.name}"/></td></tr>
	  <tr><td>商品描述</td><td><input type="text"name="desc" value="${cate.desc}"/></td></tr> --%>
<form action="category?id=${cate.id}" method="post">
	<input type="hidden" name="option" value="7">
	<table>
	    <tr><td>商品名称</td><td><input type="text"name="name" value="${cate.name}"/></td></tr>
	    <tr><td>商品描述</td><td><input type="text"name="desc" value="${cate.desc}"/></td></tr>
	    <tr><td><input type="submit" value="提交"/></td></tr>
	</table>
</form>
</body>
</html>