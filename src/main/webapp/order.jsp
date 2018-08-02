<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>商品增加</title>
<style>
	table{
	margin:auto;
	width:250px;
	height:200px;
	}
	h1{
	text-align:center;
	}
</style>

</head>
<body>

<p>支付</p>
<form action="order" method="post">
<input type="hidden"name="option"value="1"/>
<table>
<tr>
	<td>地址：<td>
<td >
<select name="addressname" >
<c:forEach items="${address}" var="add" >

<option >${add.address }</option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td> 支付类型:<td>
<td><input type="text" name="payType"/></td>
</tr>
<tr>
<tr>
    <td colspan="2"><input id="s" type="submit"value="提交"></td>
</tr>
    <tr></tr>
</table>
</form>
</body>
</html>