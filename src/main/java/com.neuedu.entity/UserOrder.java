package com.neuedu.entity;

import java.io.Serializable;

/**
 * 订单实体类
 * */
public class UserOrder  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5144155657522917012L;
	private  int  id;
	private long order_no;
	private int user_id;
	private double  payment;//实际付款金额
	private int payment_type;
	private Address a;
	private int  status;
	private long  payment_time;
	private long  send_time;
	private long  end_time;
	private long close_time;
	private long  create_time;
	private long update_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getOrder_no() {
		return order_no;
	}
	public void setOrder_no(long order_no) {
		this.order_no = order_no;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	public int getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(int payment_type) {
		this.payment_type = payment_type;
	}
	
	public Address getA() {
		return a;
	}
	public void setA(Address a) {
		this.a = a;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getPayment_time() {
		return payment_time;
	}
	public void setPayment_time(long payment_time) {
		this.payment_time = payment_time;
	}
	public long getSend_time() {
		return send_time;
	}
	public void setSend_time(long send_time) {
		this.send_time = send_time;
	}
	public long getEnd_time() {
		return end_time;
	}
	public void setEnd_time(long end_time) {
		this.end_time = end_time;
	}
	public long getClose_time() {
		return close_time;
	}
	public void setClose_time(long close_time) {
		this.close_time = close_time;
	}
	public long getCreate_time() {
		return create_time;
	}
	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}
	public long getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(long update_time) {
		this.update_time = update_time;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public UserOrder() {
		super();
	}

	
	
}
