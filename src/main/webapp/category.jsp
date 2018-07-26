<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cd" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
  td{
  text-align:center;
  }
  
</style>
<body>
<h1 align="center">商品分类管理</h1>
<table align="center">

<tr>
    <th>商品id</th>
    <th>商品名称</th>
    <th>商品描述</th>
    <th>商品父节点</th>
    <th>商品是否还有下一级</th>
    <th>商品级别</th>
    <th>商品分类操作</th>
</tr>
<cd:forEach items="${categorys}" var="category">
<tr> 
<td>${category.id}</td>
<td>${category.name}</td>
<td>${category.desc}</td>
<td>${category.pid}</td>

	<cd:choose >
		<cd:when test="${category.leaf==true}"><td>没有</td></cd:when>
		<cd:when test="${category.leaf==false}"><td>有</td></cd:when>
 	</cd:choose>
<td>${category.grade}</td>
<td ><a href="category?option=2&id=${category.id }&pid=${category.pid}">删除</a>
<a href="category?option=6&id=${category.id}">修改</a></td>
</tr>
</cd:forEach>

</table>
</body>
</html>