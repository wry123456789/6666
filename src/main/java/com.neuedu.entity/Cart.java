package com.neuedu.entity;

import java.io.Serializable;

/**
 * 购物车实体类
 * */
public class Cart  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5117733379863943502L;
	private  int id;
	private  Product  product;
	private  int  productNum;//商品数量
	private double totalPrice;
	private Account acc;
private int checked;
	public int getChecked() {
		return checked;
	}

	public void setChecked(int checked) {
		this.checked = checked;
	}
    public Cart(Product product,int productNum,Account acc){
            this.product=product;
            this.productNum=productNum;
            this.acc=acc;
	}

	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account acc) {
		this.acc = acc;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Cart(int id, Product product, int productNum) {
		super();
		this.id = id;
		this.product = product;
		this.productNum = productNum;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getProductNum() {
		return productNum;
	}
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", product=" + product + ", productNum=" + productNum + "]";
	}
	public Cart() {
		super();
	}
	
	
	
	
	
	
}
