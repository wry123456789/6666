package com.neuedu.service;

import com.neuedu.entity.UserOrder;

public interface OrderService {

	   boolean  createOrder(UserOrder userOrder);
	   boolean  addOrderItems(int id, double totalprice);
}
