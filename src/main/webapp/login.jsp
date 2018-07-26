<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<style>
	#d1{
		width:500px;
		height:300px;
		background-color: #64C0FF;
		margin:auto;
		
		
	}
	#d1_head{
		font-size:50px;
		background-color: gray;
		text-align:center;
	}
	td{
	 font-size:20px;
	
	}
	#d1_content{
		width:300px;	
		margin:auto;
		margin-top:65px;    
	}
	#s input{
	width:200px;
	}
	
</style>
<body>
<div id="d1">
 <div id="d1_head">管理员登录</div>
<form action="http://localhost:8080/project/login?option=1"method="post">
<%--<input type="hidden"name="option" value="1"/>--%>
<table id="d1_content">
<tr>
<td>用户名:</td><td ><input type="text" name="username" /></td>
</tr>
<tr>

<td>密码:</td><td id="s"><input type="password" name="password"/></td></tr>
<tr>
<td></td><td align="center"><input type="submit"value="提交"></td>
</tr>
</table>
</form>
</div>
</body>
</html>