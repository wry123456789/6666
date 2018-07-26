<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="category" method="post">
<input type="hidden"name="option"value="3"/>
<table>
	<tr>
		<td>商品名称:<td>
		<td><input type="text" name="name"/></td>
	</tr>

	
	<tr>
		<td>商品描述:<td>
	   <td><input type="text" name="pdesc"/></td>
	 </tr>
 <tr>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit"value="提交"></td>
 
</tr>
</table>
</form>
</body>
</html>