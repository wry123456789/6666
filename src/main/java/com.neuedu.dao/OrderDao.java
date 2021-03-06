package com.neuedu.dao;

import com.neuedu.entity.UserOrder;

import java.util.List;

public interface OrderDao {

	/**
	 * 创建订单
	 * */
	
   boolean  createOrder(UserOrder userOrder);
   
   /**
    * 生成订单id
    * */
   int  generateOrderId();
   List<UserOrder> selectOrder(int userId);
}
