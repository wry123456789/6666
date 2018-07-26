<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>加入购物车</title>
</head>
<style>
table{
	margin:auto;
	width:250px;
	height:100px;
	}
	h1{
	text-align:center;
	}
 </style> 
<body>
<h1>购物车</h1>
<h1><td>${a.id}</td></h1>
	<form action="cart" method="post">
	<input type="hidden"name="option"value="3"/>
		<table>
		
			<tr><td>商品名称</td>
				 
				 <td><select name="productid">
				 <c:forEach items="${productId}" var="product"><option>${product.id}</option></c:forEach>
				 </select></td>
			</tr>
			<tr><td>商品数量</td><td><input type="text" name="productnum"/></td></tr>
			<tr><td></td><td><input type="submit" value="提交"/></td></tr>
		</table>
	</form>
</body>
</html>