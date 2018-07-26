package com.neuedu.entity;

public class Category {
private int id;
private String name;
private String pdesc;
private int pid;
private boolean leaf;
private int grade;
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
	return pdesc;
}
public void setDesc(String desc) {
	this.pdesc = desc;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public boolean isLeaf() {
	return leaf;
}
public void setLeaf(boolean leaf) {
	this.leaf = leaf;
}
public int getGrade() {
	return grade;
}
public void setGrade(int grade) {
	this.grade = grade;
}
public Category(int id,String name, String pdesc, int pid, boolean leaf, int grade) {
	super();
	this.id=id;
	this.name = name;
	this.pdesc = pdesc;
	this.pid = pid;
	this.leaf = leaf;
	this.grade = grade;
}
public Category()
{
	
}
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("id"+id+"pid"+pid+"pdesc"+pdesc+"leaf"+leaf+"grade"+grade);
	}
}
