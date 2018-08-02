<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索引擎</title>
</head>
<style>
* {
    font-family: 微软雅黑;
    padding: 0px;
    margin: 0px;
}

::-webkit-scrollbar {
    display: none;
}

#container {
    margin: 0px 400px ;
    position:absolute;
}

#name{
    height: 60px; 
    width: 600px;
    font-size: 14px; 
    color: black;
    background-color: 
    green; 
    border: none; 
    text-indent: 10px;
    


}
#result {
    margin-top: 4px;
    max-width: 600px;
    max-height: 600px;
    /*background-color: ;*/

    overflow: scroll;
}

.item {
    text-indent: 10px;
    height: 40px;
    line-height: 20px;
    font-size: 14px;
    font-weight: 100;
}

.selected {

    color: dodgerblue;
    background-color: gainsboro;;
}

.normal {
    color: #3c3c3c;
    background-color: whitesmoke;
}

</style>
<body>
<div id="container">
        <input id="name" autocomplete="off">
        <div id="result"></div>
</div>
</body>
<script src="../js/jquery-3.3.1.min.js"></script>
<script>
var index = 0;
var total = 0;
$(window).keyup(function(e){//按钮被松开发生的事件事件监听键盘根据输入立马显示
   if( e.keyCode == 13) { //回车    判断摁的是什么键如果是回车键的话 
       $("#name").val($(".selected").text());//把选中的文本直接赋值给input
       $("#result").empty();//赋值之后使下面的作用域为空
       index = 0;//为什么要使索引值为空
   } else if(e.keyCode == 38) { //up //如果摁的是向上的键
       if(index == 0) return ;//当到最上面的时候值为0，函数终止
       $(".item").addClass("normal").removeClass("selected")//只有摁的那个是
       $(".item:nth-child("+(--index)+")").addClass("selected").removeClass("normal")
        $("#name").val($(".selected").text())
   } else if(e.keyCode ==40) { //down 如果向下的键
       if(index == total) return ;//到最后一个的话函数结束吗？
       $(".item").addClass("normal").removeClass("selected")
       $(".item:nth-child("+(++index)+")").addClass("selected").removeClass("normal")
        $("#name").val($(".selected").text())//这两句的意思是选中的那一行变色其他的都为普通颜色
   } else {//如果是其他字符键会在下方显示对应的数据随着变化数据下面的值一直在清空和重写
       $("#result").empty();//这句话出现在这里的含义
      $.ajax({
          url : 'http://localhost:8080/www/ProductF?name='+$("#name").val(),
          method : 'get',
          dataType : 'json',
          success : function(data) {

              total = data.length;//数据条数data.sort()对数据进行排序
              $.each(data.sort() , function( i, e ) {
                 var item = $("<div>"+e.name+"</div>").addClass("item").addClass("normal")
				 //增加一个鼠标放上去的情况
				 item.mouseenter(function(){
					 item.addClass("item").addClass("selected").removeClass("normal")
					  $("#name").val($(".selected").text())
				 })
				 item.mouseleave(function(){
					 item.addClass("item").addClass("normal").removeClass("selected")
				 })
                  item.click(function(){
                      $("#name").val(e.name);
                      $("#result").empty();
                  })
                  $("#result").append(item);;
              })
          }
      })
   }
})
</script>
</html>