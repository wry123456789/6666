package com.neuedu.entity;

public class Address {
	private int id;
	private String address;
	private double freight;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getFreight() {
		return freight;
	}
	public void setFreight(double freight) {
		this.freight = freight;
	}
	public Address(int id, String address, double freight) {
		super();
		this.id = id;
		this.address = address;
		this.freight = freight;
	}
	public Address() {
		super();
	}




}
