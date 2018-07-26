<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page import ="javax.servlet.http.HttpServletRequest" %>
    <%@page import=" javax.servlet.http.HttpSession" %>
   <%@page import=" com.neuedu.entity.Account" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
<%
 HttpSession session1 = request.getSession();
   Account account=(Account)session1.getAttribute("acc");
  String username= account.getUsername();
  HttpSession session2 = request.getSession();
  double a=(double)session1.getAttribute("p");
%>

</script>
<style>
	a{
	text-decoration: none;
	}
</style>
<body>
<table>
<tr>
<th>商品名称</th>
<th>商品数量</th>
<th>商品价格</th>
<th>商品操作</th>
<th><a href="cart?option=6">清空购物车</a></th>
</tr>
<c:forEach items="${cartlist}" var="cart">
<tr>
    <td>${cart.product.name}</td>
    <td>${cart. productNum}</td>
    <td>${cart.product.price}</td>
   
<td><a href="cart?option=4&id=${cart.id }">删除</a>
    <a href="cart?option=5&id=${cart.id }">修改</a>
    </td>
</tr>
</c:forEach>
<tr><td>用户名<td><%=username %></td></tr>
<tr><td>总计<td><%=a %></td></tr>
<tr><td><a href="#">结算</a><td></tr>

</table>
</body>
</html>