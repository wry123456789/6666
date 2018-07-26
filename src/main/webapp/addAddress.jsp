<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="address" method="post">
<input type="hidden"name="option"value="1"/>
<table>
	<tr>
		<td>送货地址:<td>
		<td><input type="text" name="address"/></td>
	</tr>

	
	<tr>
		<td>运费:<td>
	   <td><input type="text" name="freight"/></td>
	 </tr>
 <tr>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit"value="提交"></td>
 
</tr>
</table>
</form>
</body>
</html>