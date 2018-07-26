package com.neuedu.service.impl;

import java.util.List;

import com.neuedu.dao.AddressDao;
import com.neuedu.dao.impl.jdbc.AddressDaoImpl;
import com.neuedu.entity.Address;
import com.neuedu.service.AddressService;

public class AddressServiceImpl implements AddressService {
AddressDao adao = new AddressDaoImpl();
	@Override
	public boolean addAddress(Address address) {
		// TODO Auto-generated method stub
		return adao.addAddress(address);
	}

	@Override
	public List<Address> findAll() {
		// TODO Auto-generated method stub
		return adao.findAll();
	}

	@Override
	public boolean updateAddress(int id, Double freight) {
		// TODO Auto-generated method stub
		return adao.updateAddress(id,freight);
	}
	@Override
	public int findIdByName(String name) {
		return adao.findIdByName(name);
	}

	@Override
	public boolean deleteAddress(int id) {
		// TODO Auto-generated method stub
		return adao.deleteAddress(id);
	}

	@Override
	public Address findById(int id) {
		// TODO Auto-generated method stub
		return adao.findById(id);
	}

}
