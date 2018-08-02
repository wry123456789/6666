package com.neuedu.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.OrderItemDao;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import com.neuedu.entity.UserOrderItem;
import com.neuedu.utils.DBUtils;

public class OrderItemDaoImpl implements OrderItemDao {
	CartDao cd = new CartDaoImpl();
	
	@Override
	public boolean addOrderItems(int uid,double totalprice) {
		List<Cart> lc=cd.findAllCart(uid);
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement  st=null;
		try {
			conn=DBUtils.getConnection();
			st=conn.createStatement();
			
			for (Cart cart1 : lc) {
				Product p = cart1.getProduct();
				int pid = p.getId();
				String pname=p.getName();
				String pimg = p.getImage();
				double price = p.getPrice();
				int qu = cart1.getProductNum();
				String sql1="insert into userorderitem(order_no,user_id,productid,product_name,product_image,current_unit_price,quantity,total_price,status,create_time) "
				+ "values("+System.currentTimeMillis()+","
						+ uid+","+pid+","+pname+","+pimg+"," + price + ","+qu+","+totalprice+","+0+ ",now())";
				System.out.println(""+sql1);
				st.executeUpdate(sql1);
				
			}
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
	public boolean addOrderItems(UserOrderItem userOrderItem) {
		return false;
	}

	@Override
	public List<UserOrderItem> selectItem(long order) {
		return null;
	}

	@Override
	public int generateOrderItemId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
