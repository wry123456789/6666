<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="category" method="post">
<input type="hidden"name="option" value="4">
<table>
    <tr><td>商品名称</td><td><input type="text"name="name"/></td></tr>
    <tr><td>商品描述</td><td><input type="text"name="pdesc"/></td></tr>
    <tr><td>商品上一级分类</td>
    <td><select name="pname"><c:forEach items="${categorys}" var="category"><option>${category.name}</option></c:forEach></select></td>
    </tr>
    <tr><td> </td><td align="center"><input type="submit"value="提交"/></td></tr>
</table>
</form>
</body>
</html>