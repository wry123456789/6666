package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Address;

public interface AddressService {

	boolean  addAddress(Address address);
	
	List<Address> findAll();
	
	public boolean updateAddress(int id, Double freight);
	
	public boolean deleteAddress(int id);
	public int findIdByName(String name);
	
	Address  findById(int id);
}
