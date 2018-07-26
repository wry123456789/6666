package com.neuedu.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.AddressDao;
import com.neuedu.entity.Address;
import com.neuedu.utils.DBUtils;

public class AddressDaoImpl implements AddressDao {

	@Override
	public boolean addAddress(Address address) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			String  sql="insert into address values (null,?,?)";
			st=conn.prepareStatement(sql);
			//Õ¼Î»·û¸³Öµ
			st.setString(1, address.getAddress());
			st.setDouble(2, address.getFreight());
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

	@Override
	public List<Address> findAll() {
		// TODO Auto-generated method stub
      List<Address> addressl=new ArrayList<Address>();
		
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			
			String  sql="select*from address";
			st=conn.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
			 int  id= rs.getInt("id");	
			 String  address=rs.getString("address");
			 double freight=rs.getDouble(3);
			Address adds=new Address(id,address,freight);
			 addressl.add(adds); 
			}
			return addressl;
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
	public boolean updateAddress(int id,Double freight) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement p =null;
		String sql ="update address set pay=? where id=? ";
		
		 try {
			conn =DBUtils.getConnection();
			p=conn.prepareStatement(sql);
			p.setDouble(1,freight);
		    p.setInt(2,id);
			p.execute();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, p);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			return false;
	}

	@Override
	public boolean deleteAddress(int id) {
		// TODO Auto-generated method stub
		try {
			Connection conn = DBUtils.getConnection();
			String sql = "delete from address where id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			System.out.println(sql);
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Address findById(int id) {
		// TODO Auto-generated method stub
		Address adds=null;
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			
			String  sql="select * from  address where id=?";
			st=conn.prepareStatement(sql);
			st.setInt(1, id);
			System.out.println(sql);
			ResultSet rs=st.executeQuery();
			
			if(rs.first()) {
				
				 String  address=rs.getString("address");
				 double freight=rs.getDouble(3);
				adds=new Address(id,address,freight);
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
		return adds;
	}
	@Override
	public int findIdByName(String name) {
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		int id =0;
		String sql = "select id from address where address=?";
		try {
			conn = DBUtils.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			rs=ps.executeQuery();
			if(rs.first()) {
				id=rs.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    
	   
		return id;
		
	}
}



