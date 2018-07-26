package com.neuedu.service.impl;

import java.util.List;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.impl.jdbc.CartDaoImpl;
import com.neuedu.entity.Cart;
import com.neuedu.service.CartService;

public class CartServiceImpl implements CartService {

	CartDao cartDao=new CartDaoImpl();
	
	@Override
	public boolean addCart(int productid, int productnum, int accountid) {
		// TODO Auto-generated method stub
		return cartDao.addCart( productid,  productnum,accountid);
	}

	@Override
	public boolean deleteCart(int id) {
		// TODO Auto-generated method stub
		return cartDao.deleteCart(id);
	}

	@Override
	public boolean updataeCart(Cart cart) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Cart> findAllCart(int acc) {
		// TODO Auto-generated method stub
		return cartDao.findAllCart(acc);
	}

	@Override
	public int getCartNum() {
		// TODO Auto-generated method stub
		return cartDao.getCartNum();
	}

	@Override
	public boolean updateCart(int id, int num) {
		// TODO Auto-generated method stub
		return cartDao.updateCart(id, num);
	}
	@Override
	public void cartService() {
		 cartDao.clearCart();
	}

	@Override
	public Cart findById(int id) {
		// TODO Auto-generated method stub
		return cartDao.findById(id);
	}


}
