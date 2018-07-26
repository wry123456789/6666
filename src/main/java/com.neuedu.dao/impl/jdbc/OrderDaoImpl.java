package com.neuedu.dao.impl.jdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		System.out.println("���ɶ�����sql���"); 
            
	
		Connection conn=null;
		Statement st=null;
		ResultSet rs = null;
		try {
			conn=DBUtils.getConnection();
			//״̬
			st=conn.createStatement();
			
		    int uid=userOrder.getUser_id();
		    List<Cart> lc=cd.findAllCart(uid);
		    double postage= userOrder.getA().getFreight();
		    long or =System.currentTimeMillis();
			String  sql1="insert into userorder(order_no,user_id,shipping_id,payment,payment_type,postage,status,create_time)"
					+ " values ("+or+","+uid+","+userOrder.getA().getId()+","+userOrder.getPayment()+","+userOrder.getPayment_type()+","+postage+","+0+",now())";
			System.out.println("���ɶ�����sql���"+sql1);
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
				System.out.println("������Ʒ�����sql���"+sql);
				st.executeUpdate(sql);
				//���뵽���ﳵ֮ǰ
				//�ڽ���Ʒ���ӵ����ﳵ֮ǰ��Ҫ�жϿ�滹���ڹ���Աע��֮ǰ��Ҫ����һ����֤
//				String sql2 ="update "
				//��չ��ﳵ
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
				System.out.println("�޸�����");
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
		//�ڵ��ȷ�ϵ�ʱ���޸Ŀ��ͬʱɾ������
		
		return false;
	}

	@Override
	public int generateOrderId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
