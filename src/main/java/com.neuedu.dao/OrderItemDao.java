package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.UserOrderItem;

public interface OrderItemDao {

	/**
	 * �������µĶ�����ϸ��ӵ�������ϸ������
	 * */
	 boolean  addOrderItems(int id, double totalprice);
	boolean addOrderItems(UserOrderItem userOrderItem);
	 /**
	  * ���ɶ�����ϸid
	  * */
	 List<UserOrderItem> selectItem(long order);
	 int  generateOrderItemId();
}
