package com.neuedu.dao.impl.jdbc;

import java.util.List;

import com.neuedu.dao.ProductDao;
import com.neuedu.entity.Product;

public class ProductTest {
	public static void main(String[]args) {
		ProductDao pd  =new ProductDaoImpl();
		List<Product> list=pd.findByName("Ãæ");
		if(list==null) {
			System.out.println("Îª¿Õ");
		}else{for(Product product:list) {
			System.out.println(product.getName());
		}
	}
	}
}
