package com.neuedu.entity;

import java.io.Serializable;

public class Products implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6185202905228190806L;
	private  int  id; //商品id
	private  String  name;//商品名称
	private  String  desc;//商品描述
	private  double  price;//商品价格
	
	
	private  int  stock=100;//库存
	
	
	public Products() {
		super();
	}
	public Products(int id ,String name) {
		this.id=id;
		this.name=name;
	}
	public Products( String name, String desc, double price) {
		super();
		
		this.name = name;
		this.desc = desc;
		this.price = price;
	
	}
	public Products(int id, String name, String desc, double price) {
		super();
		this.id=id;
		this.name = name;
		this.desc = desc;
		this.price = price;
		
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", desc=" + desc + ", price=" + price + ", ]";
	}
	
	
	
	
	
	
	
	
	
	
	
}

