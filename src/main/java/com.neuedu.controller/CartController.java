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
import com.neuedu.entity.Cart;

import com.neuedu.entity.Product;
import com.neuedu.service.CartService;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.CartServiceImpl;
import com.neuedu.service.impl.ProductServiceImpl;
@WebServlet("/cart")
public class CartController extends HttpServlet{
	ProductService  pService=new ProductServiceImpl();
	CartService cartService=new CartServiceImpl();
	private static final long serialVersionUID = 1L;
	
@Override
  
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String option =req.getParameter("option");
		if("1".equals(option)) {
			findProductId(req,resp);
		}else if("2".equals(option)){
				findAll(req,resp);
			}
		else if("3".equals(option)) {
			add(req, resp);
		}else if("4".equals(option)){
			deleteCart(req, resp);
		}else if("5".equals(option)) {
			getNum(req,resp);
		}
		else if("6".equals(option)){
			clearCart(req,resp);
		}else if("7".equals(option)) {
			updateCart(req,resp);
		}
	}			
	
   public void findProductId(HttpServletRequest req, HttpServletResponse resp) {
	List<Product>  list= pService.findAll();
	
	req.setAttribute("productId", list);
	try {
		req.getRequestDispatcher("addCart.jsp").forward(req, resp);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("跳转失败");
	} 
   }

	/*
	 * 清空购物车
	 */
  public void clearCart(HttpServletRequest req, HttpServletResponse resp) {
	  cartService.cartService();
	  findAll(req,resp);
  }
	/**
	 * 添加购物车
	 **/
	public void add(HttpServletRequest req, HttpServletResponse resp) {
		String productid=req.getParameter("productid");
		String productNum =req.getParameter("productnum");
		
		int id =Integer.parseInt(productid);
		int num=Integer.parseInt(productNum);
		 HttpSession session1 = req.getSession();
		   Account account=(Account)session1.getAttribute("acc");
		  int accountid= account.getAccountId();
		cartService.addCart(id, num,accountid);
		findAll(req,resp);
	
	}
	public void findAll(HttpServletRequest req, HttpServletResponse resp) {
		 HttpSession session1 = req.getSession();
		 Account account=(Account)session1.getAttribute("acc");
		 int accountid= account.getAccountId();
		List<Cart> lc=cartService.findAllCart(accountid);
	    double totalprice=getTotalPrice(req,resp);
		HttpSession session3 = req.getSession();
		session3.setAttribute("p", totalprice);
		System.out.println("总计"+totalprice);
		req.setAttribute("cartlist", lc);
		try {
			req.getRequestDispatcher("showCart.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 删除
	 * */
	public void  deleteCart(HttpServletRequest req, HttpServletResponse resp) {
		String idc = req.getParameter("id");
		int id =Integer.parseInt(idc);
		cartService.deleteCart(id);
		findAll(req,resp);
	}
	
	public void updateCart(HttpServletRequest req, HttpServletResponse resp) {
		String idc = req.getParameter("id");
		int id =Integer.parseInt(idc);
		String s = req.getParameter("num");
		int num =Integer.parseInt(s);
		cartService.updateCart(id, num);
		findAll(req,resp);
	}
	
	public void getNum(HttpServletRequest req, HttpServletResponse resp) {
		String idc = req.getParameter("id");
		int id =Integer.parseInt(idc);
		Cart cart=cartService.findById(id);
		req.setAttribute("cart",cart);
		try {
			req.getRequestDispatcher("updateCart.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	//获得总计
	public double  getTotalPrice(HttpServletRequest req, HttpServletResponse resp) {
		 HttpSession session1 = req.getSession();
		 Account account=(Account)session1.getAttribute("acc");
		 int accountid= account.getAccountId();
		List<Cart>  lc =cartService.findAllCart(accountid);
		double totalprice = 0;
		for (Cart cart : lc) {
			Product p=cart.getProduct();
			totalprice+=p.getPrice()*cart.getProductNum();
		}
		return totalprice;
	}
	
	
}
