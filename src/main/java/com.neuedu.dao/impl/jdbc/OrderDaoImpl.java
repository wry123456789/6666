package com.neuedu.dao.impl.jdbc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.OrderDao;
import com.neuedu.entity.Address;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import com.neuedu.entity.UserOrder;
import com.neuedu.utils.DBUtils;
public class OrderDaoImpl implements OrderDao {
	CartDao cd = new CartDaoImpl();
	@Override
	public boolean createOrder(UserOrder userOrder) {
		// TODO Auto-generated method stub
		System.out.println("生成订单的sql语句"); 
            
	
		Connection conn=null;
		Statement st=null;
		ResultSet rs = null;
		try {
			conn=DBUtils.getConnection();
			//状态
			st=conn.createStatement();
			
		    int uid=userOrder.getUser_id();
		    List<Cart> lc=cd.findAllCart(uid);
		    double postage= userOrder.getA().getFreight();
		    long or =System.currentTimeMillis();
			String  sql1="insert into userorder(order_no,user_id,shipping_id,payment,payment_type,postage,status,create_time)"
					+ " values ("+or+","+uid+","+userOrder.getA().getId()+","+userOrder.getPayment()+","+userOrder.getPayment_type()+","+postage+","+0+",now())";
			System.out.println("生成订单的sql语句"+sql1);
			st.executeUpdate(sql1);
			
			for (Cart cart1 : lc) {
				Product p = cart1.getProduct();
				int pid = p.getId();
				String pname=p.getName();
				int stock =p.getStock();
				String pimg = p.getImage();
				double price = p.getPrice();
				int qu = cart1.getProductNum();
				double totalprice=qu*price;
				String sql="insert into userorderitem(order_no,user_id,productid,product_name,product_image,current_unit_price,quantity,total_price,status,create_time) "
				+ "values("+or+","
						+ uid+","+pid+","+pname+","+pimg+"," + price + ","+qu+","+totalprice+","+0+ ",now())";
				System.out.println("增加商品单项的sql语句"+sql);
				st.executeUpdate(sql);
				//加入到购物车之前
				//在将产品增加到购物车之前需要判断库存还有在管理员注册之前需要进行一个验证
//				String sql2 ="update "
				//清空购物车
				int stock1=0;
				String sql3 ="select stock from product where id="+pid;
				System.out.println(sql3);
				rs=st.executeQuery(sql3);
				if(rs.first()) {
					stock1 = rs.getInt("stock");
				}
				int stock3= stock1-stock;
				String sql2 ="update product set stock="+stock3+" where id="+pid;
				System.out.println(sql2);
				st.executeUpdate(sql2);
				System.out.println("修改完了");
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
		//在点击确认的时候修改库存同时删除购物
		
		return false;
	}
	public List<UserOrder> findAll(int userid) {
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs = null;
		List<UserOrder> l = new ArrayList<UserOrder>();
		String sql ="select * from userorder where user_id="+userid;
		try {
			conn=DBUtils.getConnection();
			st=conn.prepareStatement(sql);
			rs=st.executeQuery();

			while(rs.next()) {
				int id=rs.getInt("id");

				long order =rs.getLong("order_no");


//				String pm =rs.getString("product_name");
//				int pid =rs.getInt("productid");
//				double p1 =rs.getDouble("current_unit_price");
  			   double p2 =rs.getDouble("payment");
  			    long time=rs.getLong("payment_time");
//				int p3 =rs.getInt("quantity");
//				int p4 = rs.getInt("postage");
				UserOrder uo = new UserOrder();
				uo.setId(id);
				uo.setOrder_no(order);

				uo.setPayment(p2);
				uo.setPayment_time(time);
				System.out.println(uo.getId());
				l.add(uo);

			}
		}catch(Exception e) {

		}
		return l;
	}


	@Override
	public int generateOrderId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserOrder> selectOrder(int userId) {

		return null;
	}

}
