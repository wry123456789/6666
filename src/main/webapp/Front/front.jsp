<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>


<script src="../js/jquery-3.3.1.min.js"></script>
<script>

$(function(){
	$.ajax({
		type: "post",
		url: "http://localhost:8080/www/pagew",
		data:{
			"option":"1"
		},
		dateType:"json",
		success:function(e){
			alert(e)
			$.each($.parseJSON(e),function(i,d){
				var item =$("<div>"+d.desc+"</div>");
				$("#container").append(item);
			})
		},
		beforeSend: function(){
			$("#container").css("background-color","red")
		}
	   //成功之后移除这个方法判断是否已经存在
	})
})



</script>
<body>
<div id="container">
</div>
</body>
</html>