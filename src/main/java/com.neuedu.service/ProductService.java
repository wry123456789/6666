package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Page;
import com.neuedu.entity.Product;

public interface ProductService {

	/**添加商品*/
    public  boolean addProduct(Product product);	
    /**查询商品*/
    public  List<Product> findAll();
    /**修改商品*/
    public  boolean  updateProduct(Product product);
    /**删除商品*/
    public  boolean deleteProduct(int id);
    /**根据id查询商品信息*/
    public  Product  findProductById(int id);

	public Page<Product> findProductByPage(int pageNo, int pageSize);
}
