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
<table>
<tr>
<th>商品id</th>
<th>商品名称</th>
<th>商品描述</th>
<th>商品价格</th>
<th>商品规格</th>
<th>商品图片</th>
<th>商品库存</th>
<th>商品操作</th>
</tr>
<c:forEach items="${products}" var="product">
<tr>
    <td>${product.id}</td>
    <td>${product.name}</td>
    <td>${product.desc}</td>
    <td>${product.price}</td>
    <td>${product.rule}</td>
  <td>${product.image}</td>
  <td>${product.stock}</td> 
<td><a href="product?option=3&id=${product.id }">删除</a></td>
<td><a href="product?option=6&id=${product.id }">修改</a></td>
</tr>
</c:forEach>



</table>
</body>
</html>