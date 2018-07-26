package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.UserOrderItem;

public interface OrderItemDao {

	/**
	 * �������µĶ�����ϸ��ӵ�������ϸ������
	 * */
	 boolean  addOrderItems(int id, double totalprice);
	
	 /**
	  * ���ɶ�����ϸid
	  * */
	 
	 int  generateOrderItemId();
}
