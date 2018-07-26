package com.neuedu.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.entity.Products;
import com.neuedu.utils.DBUtils;

public class ProductsImpl {

	
	//增加
	public boolean addProduct(Products product) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			
			String  sql="insert into products(pname,detail,price) values (?,?,?)";
			st=conn.prepareStatement(sql);
			//占位符赋值
			st.setString(1, product.getName());
			st.setString(2, product.getDesc());
			st.setDouble(3, product.getPrice());
			System.out.println(sql);
			st.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	public boolean deleteProduct(int pid) {
		// TODO Auto-generated method stub
		//删除数据
		int count=0;
		try {
			Connection conn = DBUtils.getConnection();
			String sql = "delete from products where pid=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, pid);
			System.out.println(sql);
			//创建preparement
			count = pst.executeUpdate();
//			System.out.println(pst.executeUpdate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count!=0) {
			return true;
		}
		return false;
	}
	public List<Products> findAll() {
		// TODO Auto-generated method stub
		List<Products> products=new ArrayList<Products>();
		
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			
			String  sql="select pid,pname,detail,price from products";
			st=conn.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
			 int  id= rs.getInt("pid");	
			 String  name=rs.getString("pname");
			 String pdesc=rs.getString("detail");
			 double price=rs.getDouble("price");
			 Products product=new Products(id,name,pdesc,price);
			 products.add(product); 
			}
			return products;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	






public List<Products> findAllByDesc() {
	// TODO Auto-generated method stub
	List<Products> products=new ArrayList<Products>();
	
	Connection conn=null;
	PreparedStatement st=null;
	try {
		conn=DBUtils.getConnection();
		
		String  sql="select pid,pname,detail,price from products order by price desc";
		st=conn.prepareStatement(sql);
		System.out.println(sql);
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
		 int  id= rs.getInt("pid");	
		 String  name=rs.getString("pname");
		 String pdesc=rs.getString("detail");
		 double price=rs.getDouble("price");
		 Products product=new Products(id,name,pdesc,price);
		 products.add(product); 
		}
		return products;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			DBUtils.close(conn, st);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return null;
}

public int findId(String pname) {
	 
	Connection conn =null;
 	PreparedStatement st  = null;
 	ResultSet rs = null;
 	int pid=0;
 	String sql ="select pid from products where pname=?";
 	try {
			conn=DBUtils.getConnection();
			st=conn.prepareStatement(sql);
			st.setString(1, pname);
			System.out.println("名字是"+pname);
			System.out.println(sql);
			rs=st.executeQuery();
			if(rs.first()) {
				 pid= rs.getInt("pid");
				 System.out.println("id的值是:"+pid);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
 	return pid;
 }
}
