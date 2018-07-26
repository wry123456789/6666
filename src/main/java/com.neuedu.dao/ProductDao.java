package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Page;
import com.neuedu.entity.Product;

public interface ProductDao {

	 /**
	  * �����Ʒ
	  * */
	boolean  addProduct(Product product);
	/**
	 * �鿴��Ʒ
	 * */
	List<Product> findAll();
	/**
	 * �޸���Ʒ
	 * */
	boolean  updateProduct(Product product);
	/**
	 * ɾ����Ʒ
	 * */
	boolean  deleteProduct(int id);
	
	/**����id��ѯ��Ʒ*/
	Product  findById(int id);
	public  Page<Product> findProductByPage(int pageNo, int pageSize);
	public List<Product> findByName(String name);
	
	
	
}
