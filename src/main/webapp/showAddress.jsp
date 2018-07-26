<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
	a{
	text-decoration: none;
	}
</style>
<body>
<table>
<tr>
<th>地址</th>
<th>运费</th>
<th>地址管理</th>
</tr>
<c:forEach items="${addressl}" var="address">
<tr>
    <td>${address.address}</td>
    <td>${address. freight}</td>
<td><a href="address?option=3&id=${address.id }">删除</a>
    <a href="address?option=4&id=${address.id}">修改</a>
    </td>
</tr>
</c:forEach>



</table>
</body>
</html>