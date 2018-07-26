package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.entity.Account;
import com.neuedu.entity.Address;
import com.neuedu.entity.UserOrder;
import com.neuedu.service.AddressService;
import com.neuedu.service.CartService;
import com.neuedu.service.OrderService;
import com.neuedu.service.impl.AddressServiceImpl;
import com.neuedu.service.impl.CartServiceImpl;
import com.neuedu.service.impl.OrderServiceImpl;

@WebServlet("/order")
public class OrderController extends HttpServlet{
	CartController cc = new CartController();
	CartService cartService=new CartServiceImpl();
	private static final long serialVersionUID = 1L;
	OrderService os = new OrderServiceImpl();
	AddressService  aService=new AddressServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String option=req.getParameter("option");
		 if("1".equals(option)) {
			 createOrder(req,resp);
			}else if("2".equals(option)) {
				findAll(req,resp);
		 } 
}


	/**
	 * 
	 */

	
	public  void  createOrder(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session1 = req.getSession();
		Account account=(Account)(session1.getAttribute("acc"));
		
//		HttpSession session2 = req.getSession();
//		double a1=(double)session2.getAttribute("p");
		if(account!=null) {
	        //,,payment,payment_type,,status
			 UserOrder uo  = new UserOrder();
			 int accid =account.getAccountId();
			 uo.setUser_id(accid);
			 
			 //运费不需要填写根据地址自动显示
			 Address a = new Address();
			 int id=aService.findIdByName(req.getParameter("addressname"));
			
			 
			 a.setId(id);
			 
			Address ad= aService.findById(id);
			double postage=ad.getFreight();
			 a.setFreight(postage);
			 uo.setA(a);
			 
			 
			 uo.setPayment_type(Integer.parseInt(req.getParameter("payType")));
			 
			 double a1= cc.getTotalPrice(req, resp);
			 double a2 = a1+postage;
			 uo.setPayment(a2);
			 
//			boolean adss=os.addOrderItems(accid, a2);
//			System.out.println(adss);


			 if(os.createOrder(uo)) {
				 System.out.println("增加成功");
				 //清空购物车
				 cartService.cartService();
			 }else {
				 System.out.println("增加失败");
			 }
		}
		
	}
	
	 public  void findAll(HttpServletRequest request,HttpServletResponse response){
	    	List<Address> list= aService.findAll();
	    	request.setAttribute("address", list);
	    	//因为需要将数据显示在页面上所以需要调用显示信息的jsp
	    	try {
	         request.getRequestDispatcher("order.jsp").forward(request, response);
			System.out.println("跳转成功");
	    	} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				System.out.println("跳转失败");
			}
	    }
	
}
