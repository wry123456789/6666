<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="../js/jquery-3.3.1.min.js">
</script>
<script>
//对该集合进行遍历
	$(function(){
		$.ajax({
			type:"post",
			url : "http://localhost:8080/www/CategoryF",
			data:{
				"option":"1"
			},
			dateType:"json",
			success:function(e){
				alert(e)
				$.each($.parseJSON(e),function(i,d){
					var item =$("<div>"+d.name+d.grade+"</div>")
					$(".container").append(item);
				})
			}
		})
	});
	//实现相似查询
</script>
<body>
<div class="container">1</div>

</body>
</html>