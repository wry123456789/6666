package com.neuedu.dao.impl.jdbc;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import com.neuedu.dao.ILoginDao;
import com.neuedu.entity.Account;

import com.neuedu.utils.DBUtils;
import com.neuedu.utils.MD5Utils;

public class LoginDaoImpl implements ILoginDao {

	@Override
	public Account doLogin(String _username, String _password) {
		// TODO Auto-generated method stub
		
		Account account=null;
		
		Connection conn=null;
		PreparedStatement st=null; 
		
		try {
			conn=DBUtils.getConnection();
			//st=conn.createStatement();
			
			String  sql="select * from  account where username=? and password=? ";
			 st=conn.prepareStatement(sql);
			//给占位符赋值
			 st.setString(1, _username);
			 st.setString(2, _password);
			
			// asfksadfsdf'  or 1=1 -- ''
			System.out.println(sql);
			ResultSet rs=st.executeQuery();
			if(rs.first()) {
				 int  accountid= rs.getInt("accountid");	
				 String  name=rs.getString("username");
				 String password=rs.getString("password");
				 String ip=rs.getString("ip");
				 String sex=rs.getString("sex");
				 account=new Account(accountid,name,password,ip,sex);
			}	
			return account;
			
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
	public boolean register(Account c) {
		// TODO Auto-generated method stub\
		String ip =null;
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into account values(null,?,?,?,?,null)";
		try {
			conn =DBUtils.getConnection();
			ps=conn.prepareStatement(sql);
			System.out.println("注册的sql语句"+sql);
			System.out.println("本机的ip地址"+ip);
			ps.setString(1,c.getUsername());
			String password = c.getPassword();
			String pw=MD5Utils.GetMD5Code(password);
			System.out.println(pw);
			ps.setString(2, pw);
			ps.setString(3, ip);
			ps.setString(4, c.getSex());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void addToken(Account c, String token) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update account set token=? where accountid=?";
		try {
			conn =DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, token);
			ps.setInt(2, c.getAccountId());
			ps.executeUpdate();
			System.out.println(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}

	//查询一个token需要根据accountid查询对应的token然后比较两个token
    public String findTokenByAccountId(int accountid) {
    	Connection conn =null;
    	PreparedStatement st  = null;
    	ResultSet rs = null;
    	String token = null;
    	String sql ="select token from account where accountid=?";
    	try {
			conn=DBUtils.getConnection();
			st=conn.prepareStatement(sql);
			
			st.setInt(1, accountid);
			System.out.println(sql);
			rs=st.executeQuery();
			if(rs.first()) {
				 token= rs.getString("token");
				 System.out.println("token的值是:"+token);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	return token;
    	
    	
    }
	

}
