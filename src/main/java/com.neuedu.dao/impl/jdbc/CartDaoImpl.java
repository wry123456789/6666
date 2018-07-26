package com.neuedu.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.ProductDao;
import com.neuedu.entity.Cart;

import com.neuedu.utils.DBUtils;

public class CartDaoImpl implements CartDao {

	ProductDao productDao=new ProductDaoImpl();

	@Override
	public boolean deleteCart(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement st=null;
		try {
			conn=DBUtils.getConnection();
			st=conn.createStatement();
			String  sql="delete from cart where id="+id+"";
			System.out.println(sql);
			st.execute(sql);
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
	@Override
	public Cart findById(int id) {
	Cart cart=new Cart();
	Connection conn=null;
	PreparedStatement st=null;
	try {
		conn=DBUtils.getConnection();
		
		String  sql="select * from  cart where id=?";
		st=conn.prepareStatement(sql);
		st.setInt(1, id);
		
		System.out.println(sql);
		ResultSet rs=st.executeQuery();
		if(rs.first()) {
			  int num= rs.getInt("productnum");
			  int productid=rs.getInt("productid");
			  
			  cart.setId(id);
			  cart.setProductNum(num);
			  cart.setProduct(productDao.findById(productid));
		}
		
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
	 return cart;

	}
	@Override
	public boolean updataeCart(Cart cart) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		Statement st=null;
		try {
			conn=DBUtils.getConnection();
			st=conn.createStatement();
			String  sql="update cart set productnum="+cart.getProductNum()+"where id="+cart.getId()+"";
			System.out.println(sql);
			st.execute(sql);
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

	@Override
	public List<Cart> findAllCart(int accountid) {
		// TODO Auto-generated method stub
		
	List<Cart> carts=new ArrayList<Cart>();
		Connection conn=null;
		Statement st=null;
		try {
			conn=DBUtils.getConnection();
			st=conn.createStatement();
			String  sql="select * from  cart where userid ="+accountid;
			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
			 int  id= rs.getInt("id");	
			 int  productid=rs.getInt("productid");
			 int num=rs.getInt("productnum");
			 Cart cart=new Cart();
			 cart.setId(id);
			 cart.setProductNum(num);
			 
			 cart.setProduct(productDao.findById(productid));
			 //查询
			 carts.add(cart);
			}
			
			
			return carts;
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

	@Override
	public int getCartNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateCart(int id, int num) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement st=null;
		try {
			conn=DBUtils.getConnection();
			st=conn.createStatement();
			String  sql="update cart set productnum="+num+" where id="+id+"";
			System.out.println(sql);
			st.execute(sql);
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

	@Override
	public void clearCart() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement st=null;
		String sql ="delete from cart ";
		try {
			conn=DBUtils.getConnection();
			st=conn.prepareStatement(sql);
			st.executeUpdate();
		} catch (Exception e) {
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
		
		
	}
//购物车增加
	@Override
	public boolean addCart(int productid, int productnum,int accountid) {
		//增加之前先进判断查看增加的商品id是否相同
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement st=null;
		List<Cart> lc=findAllCart(accountid);
		
		for (Cart cart : lc) {
			if(cart.getProduct().getId()==productid) {
				updateCart(cart.getId(), productnum=cart.getProductNum()+productnum);
			    return true;
			}
		}
		String  sql="insert into cart(productid,productnum, userid) values (?,?,?)";
		try {
			conn=DBUtils.getConnection();
			st=conn.prepareStatement(sql);
			st.setInt(1, productid);
			st.setInt(2, productnum);
			st.setInt(3, accountid);
			System.out.println(sql);
			st.execute();
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


}
