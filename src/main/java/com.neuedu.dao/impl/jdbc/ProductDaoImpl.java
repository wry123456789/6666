package com.neuedu.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.ProductDao;
import com.neuedu.entity.Category;
import com.neuedu.entity.Page;
import com.neuedu.entity.Product;
import com.neuedu.utils.DBUtils;

public class ProductDaoImpl implements ProductDao {

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();

			String sql = "insert into product(name,pdesc,price,rule,image,stock,categoryId) values (?,?,?,?,?,?,?)";
			st = conn.prepareStatement(sql);
			//占位符赋值
			st.setString(1, product.getName());
			st.setString(2, product.getDesc());
			st.setDouble(3, product.getPrice());
			st.setString(4, product.getRule());
			st.setString(5, product.getImage());
			st.setInt(6, product.getStock());
			st.setInt(7, product.getId());
			System.out.println(sql);
			st.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<Product>();

		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();

			String sql = "select id,name,pdesc,price,rule ,image,stock from  product";
			st = conn.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String pdesc = rs.getString("pdesc");
				double price = rs.getDouble("price");
				String rule = rs.getString("rule");
				String image = rs.getString("image");
				int stock = rs.getInt("stock");

				Product product = new Product(id, name, pdesc, price, rule, image, stock);
				products.add(product);
			}

			return products;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		//1.连接数据库
		//5.执行sql语句
		Connection conn = null;
		PreparedStatement p = null;

		try {
			conn = DBUtils.getConnection();
			//2.准备sql语句
			String sql = "update product set name=?,pdesc=?,price=?,rule=?, image=?,stock=? where id=? ";
			//3.预编译sql语句
			p = conn.prepareStatement(sql);
			//4.赋值

			p.setString(1, product.getName());
			System.out.println(product.getName());
			p.setString(2, product.getDesc());
			p.setDouble(3, product.getPrice());
			p.setString(4, product.getRule());
			p.setString(5, product.getImage());
			p.setInt(6, product.getStock());
			p.setInt(7, product.getId());
			System.out.println(product.getId());
			System.out.println(sql);
			p.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			DBUtils.close(conn, p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	//删除数据
	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		//删除数据
		int count = 0;
		try {
			Connection conn = DBUtils.getConnection();
			String sql = "delete from product where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			System.out.println(sql);
			//创建preparement
			count = pst.executeUpdate();
//			System.out.println(pst.executeUpdate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (count != 0) {
			return true;
		}
		return false;
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		Product product = new Product();

		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();

			String sql = "select id,name,pdesc,price,rule ,image,stock from  product where id=?";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			if (rs.first()) {
				int _id = rs.getInt("id");
				String name = rs.getString("name");
				String pdesc = rs.getString("pdesc");
				double price = rs.getDouble("price");
				String rule = rs.getString("rule");
				String image = rs.getString("image");
				int stock = rs.getInt("stock");
				product.setId(_id);
				product.setName(name);
				product.setPrice(price);
				product.setDesc(pdesc);
				product.setRule(rule);
				product.setImage(image);
				product.setStock(stock);
			}
			return product;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return product;
	}

	public Page<Product> findProductByPage(int pageNo, int pageSize) {
		//查询数据
		//总的页面总记录条数/每页显示的条
		Page<Product> page = new Page<Product>();

		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();
			String sql1 = "select count(id) from product";
			st = conn.prepareStatement(sql1);
			System.out.println(sql1);
			ResultSet s = st.executeQuery();
			if (s.next()) {
				int count = s.getInt(1);
				int sq = (count % pageSize == 0) ? count / pageSize : (count / pageSize + 1);
				page.setTotalPage(sq);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			conn = DBUtils.getConnection();
			String sql = "select id,name,pdesc,price,rule ,image,stock from  product limit ?,?";
			st = conn.prepareStatement(sql);
			st.setInt(1, (pageNo - 1) * pageSize);
			st.setInt(2, pageSize);
			System.out.println(pageNo);
			System.out.println(pageSize);
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			List<Product> list = new ArrayList<Product>();
			while (rs.next()) {
				int _id = rs.getInt("id");
				String name = rs.getString("name");
				String pdesc = rs.getString("pdesc");
				double price = rs.getDouble("price");
				String rule = rs.getString("rule");
				String image = rs.getString("image");
				int stock = rs.getInt("stock");
				Product product = new Product();
				product.setId(_id);
				product.setName(name);
				product.setPrice(price);
				product.setDesc(pdesc);
				product.setRule(rule);
				product.setImage(image);
				product.setStock(stock);
				System.out.println(product + "2222");
				list.add(product);
			}
			page.setPage(list);


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		page.setCurrent(pageNo);
		return page;
	}

	@Override
	public List<Product> findByName(String name) {
		List<Product> products = new ArrayList<Product>();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from product  where name like " + "\"%" + name + "%\"";
		System.out.println(sql);
		try {
			conn = DBUtils.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String names = rs.getString("name");
				String pdesc = rs.getString("pdesc");
				double price = rs.getDouble("price");
				String rule = rs.getString("rule");
				String image = rs.getString("image");
				int stock = rs.getInt("stock");

				Product product = new Product(id, names, pdesc, price, rule, image, stock);
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products;

	}

	public List<Category> findCategory() {
		//查询所有子节点
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "select * from category where leaf= 1";
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				//获取类别名

			}
		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
			try {
				DBUtils.close(conn, ps, rs);
			} catch (Exception e) {
				throw new RuntimeException();
			}
		}

	        return null;
	}
}
