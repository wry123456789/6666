<<%@ page language="java" contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<style>
    a{
        text-decoration: none;
    }
   table{
       border:1px solid black;
       width:500px;
       height:500px;
   }
</style>
<body>
<table>
    <tr>
        <th>订单号</th>
        <th>支付金额</th>
        <th>支付时间</th>
    </tr>
    <c:forEach items="${userorder}" var="order">
        <tr>
            <td>${order.order_no}</td>
            <td>${order. payment}</td>
            <td>${order. payment_time}</td>
        </tr>
    </c:forEach>



</table>
</body>
</html>