package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.entity.Address;
import com.neuedu.entity.Product;
import com.neuedu.service.AddressService;
import com.neuedu.service.impl.AddressServiceImpl;


@WebServlet("/address")
public class AddressController extends HttpServlet {
	/**
	 * 
	 */
	AddressService  aService=new AddressServiceImpl();
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
			add(req, resp);
		}else if("2".equals(option)){
				findAll(req,resp);
			}
		else if("3".equals(option)) {
			delete(req, resp);
		}else if("4".equals(option)){
			 findById(req, resp);
		}else if("5".equals(option)) {
			updateAddress(req, resp);
		}
		else if("6".equals(option)){
//			clearCart(req,resp);
		}else if("7".equals(option)) {
//			updateCart(req,resp);
		}
	}			
	public void add(HttpServletRequest req, HttpServletResponse resp) {
		String address=req.getParameter("address");
		String freight =req.getParameter("freight");
		int fre =Integer.parseInt(freight);
		Address a = new Address();
		a.setAddress(address);
		a.setFreight(fre);
		aService.addAddress(a);
	}
	 public  void findAll(HttpServletRequest request,HttpServletResponse response){
	    	List<Address> list= aService.findAll();
	    	
	    	request.setAttribute("addressl", list);
	    	//因为需要将数据显示在页面上所以需要调用显示信息的jsp
	    	try {
	         request.getRequestDispatcher("showAddress.jsp").forward(request, response);
			System.out.println("跳转成功");
	    	} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				System.out.println("跳转失败");
			}
	    }
	 public void  delete(HttpServletRequest req, HttpServletResponse resp) {
			String idc = req.getParameter("id");
			int id =Integer.parseInt(idc);
			aService.deleteAddress(id);
			findAll(req,resp);
		}

	 public Address findById(HttpServletRequest req,HttpServletResponse reps) {
			int id=Integer.parseInt(req.getParameter("id"));
	    	Address address =aService.findById(id);
	    	System.out.println("地址"+address.getAddress());
	    	req.setAttribute("address",address);
	    	try {
				req.getRequestDispatcher("updateAddress.jsp").forward(req, reps);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return address ;
		}
		public void updateAddress(HttpServletRequest req, HttpServletResponse resp) {
			String idc = req.getParameter("id");
			int id =Integer.parseInt(idc);
			String s = req.getParameter("freight");
			double num =Integer.parseInt(s);
			aService.updateAddress(id, num);
			findAll(req,resp);
		}
		
}
