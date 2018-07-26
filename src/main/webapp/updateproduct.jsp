<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="product" method="post">
<input type="hidden"name="option"value="4"/>
<table>
<tr><td>商品id</td><td><input type="text"name="id" value="${product.id}"/></td></tr>
<tr><td>商品名称</td><td><input type="text"name="name" value="${product.name}"/></td></tr>
<tr><td>商品描述</td><td><input type="text"name="desc" value="${product.desc}"/></td></tr>
<tr><td>商品价格</td><td><input type="text"name="price" value="${product.price}"/></td></tr>
<tr><td>商品规则</td><td><input type="text"name="rule" value="${product.rule}"/></td></tr>
<tr><td>商品图片</td><td><input type="text"name="image" value="${product.image}"/></td></tr>
<tr><td>商品库存</td><td><input type="text"name="stock" value="${product.stock}"/></td></tr>
<tr>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit"value="商品修改"></td>
</tr>

</table>
</form>
</body>
</html>