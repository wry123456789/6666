package com.neuedu.entity;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable{
	private static final long serialVersionUID = 1L;
//首先需要一个集合显示一个页面的数据
//需要在页面上显示多少页
	private List<T> page;
	private int totalPage;
	private int current;
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	public List<T> getPage() {
		return page;
	}
	public void setPage(List<T> page) {
		this.page = page;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
	
}
