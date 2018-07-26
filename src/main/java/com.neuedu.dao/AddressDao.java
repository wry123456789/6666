package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Address;

public interface AddressDao {

	
		boolean  addAddress(Address address);
		
		List<Address> findAll();
		
		public boolean updateAddress(int id, Double freight);
		
		public boolean deleteAddress(int id);
		
		
		Address  findById(int id);
//		public  Page<Product> findProductByPage(int pageNo,int pageSize);
		public int findIdByName(String name);

	


}
