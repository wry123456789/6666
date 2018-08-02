<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
#containers{

border:1px solid yellow;
 overflow: scroll;
width:500px;

}
::-webkit-scrollbar{
        display:none;
    }
 .item{
        text-align:center;
        
    }
    .l{
    width:450px;
    }
 #sort{
 background-color:transparent;
 opacity:0.5;
 border:none;
 }
</style>
<body>
商品名称<input type="text" id="add"/><br/>
商品价格<input type="text" id="add1"/><br/>
商品描述<input type="text" id="add2"/><br/>
<input type="submit" id="sub"/>

<table class="l" id="containers">
<thead><tr> <th>商品名称</th><th>商品价格 <button id="sort">↓</button></th><th>商品描述</th></tr></thead>
<tbody id="container"></tbody>
</table>
</body>
<script src="../js/jquery-3.3.1.min.js"></script>
<script>



$(function(){
        //添加信息......
        $("#sub").click(function(){
         //该方法通过get方法传递参数
            var name= $("#add").val();
            var price = $("#add1").val();
            var detail = $("#add2").val();
            $.ajax({
                type : 'get' ,
                url : 'http://localhost:8080/www/ProductsCon?option='+2+'&name='+name+'&price='+price+'&desc='+detail,
                dateType:"json",
                		success : function(data){
               			 var item = $("<tr>"+"<td>"+name+"</td>"+"<td>"+detail+"</td>"+"<td>"+price+"</td><td><button id="+name+">删除</button></td></tr>").addClass("item");
                			 $("#container").append(item)
                              $("#add").val("");//成功之后直接调用下面
                              $("#add1").val("");
                              $("#add2").val("");
                			 //现在要做的是如何删除如果根据名字去删除的方法
                			 $("#"+name).click(function(){
                			   $.ajax({
		                            type:'post',
		                            url:'http://localhost:8080/www/ProductsCon?option='+5+'&name='+name,
		                            dateType:'json',
		                        	success:function(w){
		                        		var pid =w;
		                        		$.ajax({
		                                    type : 'get' ,
		                                    url : 'http://localhost:8080/www/ProductsCon?option='+4+'&id='+pid,
		                                    		success : function(){
		                                    			//成功之后从方框里面移除对应的一行
		                                    			item.remove();
		                                    }
		                                })
		                        	}
                			})		
                		})		 
                }
            })
           
        })
})
	$.ajax({
		type:'post',
		url:'http://localhost:8080/www/ProductsCon?option='+1,
		dateType:'json',
		success:function(s){
		  //通过$.parseJson(s)将数据反序列化为对象
		    $.each($.parseJSON(s),function(i,e){
		    	var ids = e.id;
                    var item = $("<tr >"+"<td>"+e.name+"</td>"+"<td>"+e.desc+"</td>"+"<td>"+e.price+"</td><td><button id="+ids+">删除</button></td></tr>").addClass("item");
                    $("#container").append(item)
                    $("#"+ids).click(function(){
                    	//如何循环不再继续
                    	$.ajax({
                            type : 'get' ,
                            url : 'http://localhost:8080/www/ProductsCon?option='+4+'&id='+ids,
                            		success : function(){
                            			//成功之后从方框里面移除对应的一行
                            			item.remove();
                            }
                        })
                    })
                })
		}
	})

	$("#sort").click(function(){
		 $("#container").empty();
		$.ajax({
			type:'post',
			url:'http://localhost:8080/www/ProductsCon?option='+3,
			dateType:'json',
			success:function(s){
			  //通过$.parseJson(s)将数据反序列化为对象
			    $.each($.parseJSON(s),function(i,e){
			    	var ids = e.id;
	                    var item = $("<tr >"+"<td>"+e.name+"</td>"+"<td>"+e.desc+"</td>"+"<td>"+e.price+"</td><td><button id="+ids+">删除</button></td></tr>").addClass("item");
	                    $("#container").append(item)
	                    $("#"+ids).click(function(){
	                    	//如何循环不再继续
	                    	$.ajax({
	                            type : 'get' ,
	                            url : 'http://localhost:8080/www/ProductsCon?option='+4+'&id='+ids,
	                            		success : function(){
	                            			//成功之后从方框里面移除对应的一行
	                            			item.remove();
	                            }
	                        })
	                    })
	                })
			}
		})

		
		
	})

//JSON.parse(json)
</script>
</html>