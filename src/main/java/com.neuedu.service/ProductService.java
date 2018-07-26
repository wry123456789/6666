package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Page;
import com.neuedu.entity.Product;

public interface ProductService {

	/**�����Ʒ*/
    public  boolean addProduct(Product product);	
    /**��ѯ��Ʒ*/
    public  List<Product> findAll();
    /**�޸���Ʒ*/
    public  boolean  updateProduct(Product product);
    /**ɾ����Ʒ*/
    public  boolean deleteProduct(int id);
    /**����id��ѯ��Ʒ��Ϣ*/
    public  Product  findProductById(int id);

	public Page<Product> findProductByPage(int pageNo, int pageSize);
}
