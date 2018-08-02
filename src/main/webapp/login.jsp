<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<style>

 /**/
    *{
     margin: 0px;
     padding:0px;
    }
    body{
     background-color: white;
    }
    #top{
     width: 100%;
     height: 100px;
     background-color: white;
    }
    #top div{
     width: 243px;
     height: 81px;
     margin-left: 50px;
     margin-top: 0px;
    }
    #form{
     width: 411px;
     height: 500px;
     margin: 40px auto;

     background-color: white;
    }
    #form table{
     width: 411px;
     height: 500px;
     text-align: center;
    }
    #login{
     font-size: 20px;
     text-align: center;
     color: #F56600;
    }
    .text{
     width: 335px;
     height: 40px;
    }
    .submit{
     width: 343px;
     height: 40px;
     color: white;
     background-color: #F56600;
    }
    .a1{
     text-decoration: none;
     color: #EF5B00;
    }
    .a2{
     text-decoration: none;
     color: #999999;
    }
    #a2:hover{
     color: #EF5B00;
    }

</style>
<body>
<%--<div id="d1">--%>
 <%--<div id="d1_head">管理员登录</div>--%>
<%--&lt;%&ndash;<form action="http://localhost:8080/project/login?option=1"method="post">&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;<input type="hidden"name="option" value="1"/>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;<table id="d1_content">&ndash;%&gt;--%>
<%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;<td>用户名:</td><td ><input type="text" name="username" /></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;<tr>&ndash;%&gt;--%>

<%--&lt;%&ndash;<td>密码:</td><td id="s"><input type="password" name="password"/></td></tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;<td></td><td align="center"><input type="submit"value="提交"></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;</table>&ndash;%&gt;--%>
<%--&lt;%&ndash;</form>&ndash;%&gt;--%>



 <%----%>

 <div id="form">
  <form action="http://localhost:8080/project/login?option=1"method="post">
   <table border="0" cellspacing="0">
    <tr><td colspan="4" id="login">账户密码登录</td></tr>
    <tr><td colspan="4" height="60px"><input type="text" placeholder="用户名" required="required" name="username"class="text" /></td></tr>
    <tr><td colspan="4" height="60px"><input type="password" placeholder="密码" required="required" class="text" name="password"/></td></tr>
    <tr><td colspan="4" height="60px"><input type="submit" value="登录" class="submit"/></td></tr>
    <tr><td colspan="2" height="30px"><a href="#" class="a1">手机短信登录/注册</a></td><td width="70px"><a href="register.jsp" class="a2">立即注册</a></td><td width="123px"><a href="#" class="a2">忘记密码？</a></td></tr>
    <tr><td></td><td></td><td></td><td></td></tr>
    <tr><td></td><td></td><td></td><td></td></tr>


   </table>
  </form>
 </div>
</div>
</body>
</html>