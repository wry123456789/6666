package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Cart;

public interface CartService {


	public boolean addCart(int productid, int productnum, int accountid);

	boolean  deleteCart(int id);

	boolean  updataeCart(Cart cart);

	List<Cart> findAllCart(int acc);
	

	int  getCartNum();
	boolean  updateCart(int id, int num);
	public void cartService();
	public Cart findById(int id);

}
