package com.neuedu.dao.impl.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.neuedu.entity.Category;
import com.neuedu.utils.DBUtils;
public class CategoryDaoImpl {	
	//添加根类别
	private boolean  add(Category c) {
		Connection conn = null;
		PreparedStatement ps =null;
		String sql = "insert into category values(null,?,?,?,?,?)";
		System.out.println(sql);
		try {
			conn =DBUtils.getConnection();
			ps=conn.prepareStatement(sql);
		    ps.setString(1, c.getName());
			ps.setString(2,c.getDesc());
			ps.setInt(3, c.getPid());
			ps.setInt(4, c.isLeaf()?1:0);
			ps.setInt(5,c.getGrade());
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			DBUtils.close(conn, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
public boolean addCategory(String name,String pdesc) {
	Category c = new Category();
	c.setDesc(pdesc);
	c.setName(name);
	c.setGrade(1);
	c.setLeaf(true);//
	c.setPid(0);
    return add(c);
}


//添加子节点
public boolean addCategory(String name,String pdesc,int pid) {
	Category c = new Category();
	c.setDesc(pdesc);
	c.setName(name);
	c.setPid(pid);
	System.out.println("增加子类别的时候的pid"+pid);
	c.setLeaf(true);//通过这一次的pid找到对应的上一级的数据进行修改leaf
	
	Connection conn =null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	int grade =0;
	try {
		conn =DBUtils.getConnection();
		String sql = "select * from category where id = "+pid;
		System.out.println(sql);
		ps = conn.prepareStatement(sql);
		rs=ps.executeQuery();
		if(rs.next()) {
		    grade=rs.getInt("grade");
		}
		 System.out.println("级别"+grade);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String sql1 = "update category set leaf ="+0+" where id ="+pid;
	try {
		ps =conn.prepareStatement(sql1);
		ps.executeUpdate();
		System.out.println(sql1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	c.setGrade(grade+1);
	System.out.println("传入的数据是"+c);
	
	return 	add(c);
}

public List<Category> findAll(){
	List<Category>list= new ArrayList<Category> ();
	findAll(list,0);
	return list;
}
//树状列表显示
public void findAll(List<Category> list,int pid) {
	//如何查询语句
	Connection conn=null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	try {
		conn =DBUtils.getConnection();
		String sql = "select * from category where pid ="+pid;
		ps = conn.prepareStatement(sql);
		rs =ps.executeQuery();
		while(rs.next()) {
			int leaf =rs.getInt("leaf");
			int id = rs.getInt("id");
			Category c = new Category(id,rs.getString("name"),rs.getString("pdesc"),rs.getInt("pid"),(leaf==1)?true:false,rs.getInt("grade"));
			list.add(c);
		    if(leaf==0) {
		    	findAll(list,id);
		    }
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public boolean update(String name,String pdesc,int id) {
		Connection conn=null;
		PreparedStatement ps = null;
		String sql ="update category set name=?,pdesc=? where id=?";
		
		try {
			conn=DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pdesc);
			ps.setInt(3, id);
			ps.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			DBUtils.close(conn, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	private boolean delete(int id) {
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn =DBUtils.getConnection();
			String sql = "select * from category where pid ="+id;
			ps = conn.prepareStatement(sql);
			
			rs =ps.executeQuery();
			if(rs.next()) {
				delete(rs.getInt("id"));
			}
			String sql2 = "delete from category where id="+id;
			ps=conn.prepareStatement(sql2);
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return false;
	}
	 
 public boolean delete(int id,int pid) {
	 delete(id);
	 Connection conn=null;
	 PreparedStatement ps = null;
	 ResultSet rs = null;
	 try {
		conn =DBUtils.getConnection();
				String sql = "select count(*) from category where pid ="+pid;
				ps = conn.prepareStatement(sql);
				
				rs =ps.executeQuery();
				rs.next();
				int count = rs.getInt("count(*)");
				if(count<=0) {
					String sql2 ="update category set leaf=1 where id ="+pid;
					ps = conn.prepareStatement(sql2);
					ps.executeUpdate();
				}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return false;
 }
 
 public int findId(String name) {
	 
	Connection conn =null;
 	PreparedStatement st  = null;
 	ResultSet rs = null;
 	int id=0;
 	String sql ="select id from category where name=?";
 	try {
			conn=DBUtils.getConnection();
			st=conn.prepareStatement(sql);
			st.setString(1, name);
			System.out.println("名字是"+name);
			System.out.println(sql);
			rs=st.executeQuery();
			if(rs.first()) {
				 id= rs.getInt("id");
				 System.out.println("id的值是:"+id);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
 	return id;
 }
 //根据id查询具体信息
 public Category findById(int id) {
	 Category c = new Category();
	 Connection conn = null;
	 PreparedStatement ps = null;
	 ResultSet rs = null;
	 String sql ="select *from category where id=?";
	try {
		conn= DBUtils.getConnection();
		ps=conn.prepareStatement(sql);
		ps.setInt(1,id);
		rs =ps.executeQuery();
		if(rs.first()) {
			c.setId(rs.getInt("id"));
			c.setName(rs.getString("name"));
			c.setDesc(rs.getString("pdesc"));
			c.setPid(rs.getInt("pid"));
			c.setLeaf(((rs.getInt("leaf")==1)?true:false));
			c.setGrade(rs.getInt("grade"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return c;
 }
 
 }

