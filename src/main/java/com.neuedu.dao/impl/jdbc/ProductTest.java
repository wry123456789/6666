package com.neuedu.dao.impl.jdbc;

import java.util.List;

import com.neuedu.dao.ProductDao;
import com.neuedu.entity.Product;

public class ProductTest {
	public static void main(String[]args) {
		ProductDao pd  =new ProductDaoImpl();
		List<Product> list=pd.findByName("��");
		if(list==null) {
			System.out.println("Ϊ��");
		}else{for(Product product:list) {
			System.out.println(product.getName());
		}
	}
	}
}
