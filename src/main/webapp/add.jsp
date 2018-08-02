<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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

<h1 >商品增加</h1>
<form action="product" method="post">
<input type="hidden"name="option"value="1"/>
<table>

	<tr>
		<td>商品类别:<td>
		<td><input type="text"name="category"/></td>
	</tr>
	<tr>
		<td>商品名称:<td>
		<td><input type="text"name="name"/></td>
	</tr>

	
	<tr>
		<td>商品描述:<td>
	   <td><input type="text" name="desc"/></td></tr>
<tr>
<td>商品价格:<td>
<td><input type="text" name="price"></td>
</tr>
<tr>
<td>商品规格:<td>
<td><input type="text" name="rule"/></td>
</tr>
<tr>
<td>商品图片:<td>
<td><input type="text" name="image"></td></tr>
<tr>
<td>商品库存:<td>
<td><input type="text" name="stock"></td></tr>
<tr>
    <td colspan="2"><input id="s" type="submit"value="提交"></td>
</tr>
</table>
</form>
</body>
</html>