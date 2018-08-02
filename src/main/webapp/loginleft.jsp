<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
    *margin{
        margin:0;
        padding:0;
    }

li{
list-style:none;
}
a{
text-decoration:none;
}

</style>
<script src="js/jquery-3.3.1.min.js"></script>
<script>

</script>
<body>
<ul id="t1">
<li>商品管理
    <ul >
        <li><a href="add.jsp" target="s"> 商品增加</a></li>
        <li><a href="product?option=7"target="s">商品查询</a></li>
        <li><a href="findProductById.jsp"target="s">查询单个商品</a></li>
    </ul>
</li>

<%-- <li><a href="deleteproduct.jsp"target="s"></a> </li>--%>
<%-- <li><a href="updateproduct.jsp"target="s">淇敼鍟嗗搧</a></li>--%>
    <li>商品分类管理
    <ul>
         <li><a href="category?option=1"target="s">商品分类管理</a></li>
         <li><a href="addBigCategory.jsp" target="s">商品大分类添加</a></li>
         <li><a href="category?option=5"target="s">商品子分类添加</a></li>
    </ul>
    </li>
<li>购物车管理
    <ul>
        <li> <a href="cart?option=1"target="s">添加购物车</a></li>
        <li> <a href="cart?option=2"target="s">查看购物车</a></li>
    </ul>
</li>

<li>
    送货地址管理
    <ul>
    <li><a href="address?option=2"target="s">送货地址管理</a></li>
        <li><a href="addAddress.jsp"target="s">添加地址</a></li>

    </ul>

</li>
<li>订单管理
    <ul>
        <li><a href="order?option=2"target="s">生成订单</a></li>
        <li><a href="order?option=3"target="s"target="s">查看订单</a></li>
    </ul>
</li>

</ul>
<body>







<br/>
</body>
<br/>
</ul>
</body>
</html>