<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员注册</title>
</head>
<style>
	#form{
		width: 411px;
		height: 500px;
		margin: 100px auto;

		background-color: white;
	}
</style>
<body>
<div id="form">
 <form action="login" method="post">
 	<input type="hidden" name="option" value="2"/>
 	<table>
 		<tr>
 			<td> 用户名</td><td><input type="text" name="username"/></td>
 		</tr>
 		<tr>
 			<td> 密码</td><td><input type="text" name="password"/></td>
 		</tr>
 		<tr>
 			<td> 性别</td>
 			<td><select name="sex"><option>man</option><option>woman</option></select></td>
 		</tr>
 		<tr>
 		<td></td>
 		<td><input type="submit" value="提交"/></td>
 		</tr>
 	</table>
 </form>
</div>
</body>
</html>