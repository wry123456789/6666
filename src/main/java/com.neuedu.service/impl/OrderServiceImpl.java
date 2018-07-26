package com.neuedu.service.impl;

import com.neuedu.dao.OrderDao;
import com.neuedu.dao.OrderItemDao;
import com.neuedu.dao.impl.jdbc.OrderDaoImpl;
import com.neuedu.dao.impl.jdbc.OrderItemDaoImpl;
import com.neuedu.entity.UserOrder;
import com.neuedu.service.OrderService;

public class OrderServiceImpl implements OrderService {
	OrderDao od = new OrderDaoImpl();
	OrderItemDao oid = new OrderItemDaoImpl();
	@Override
	public boolean createOrder(UserOrder userOrder) {
		// TODO Auto-generated method stub
	
		return od.createOrder(userOrder);
	}
	@Override
	public boolean  addOrderItems(int id,double totalprice) {
		return oid.addOrderItems(id, totalprice);
	}

}
