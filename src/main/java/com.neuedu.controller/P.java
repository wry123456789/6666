package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.neuedu.entity.Page;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.ProductServiceImpl;
@WebServlet("/pagew")
public class P extends HttpServlet{
	private static final long serialVersionUID = 1L;
	ProductService  pService=new ProductServiceImpl();
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s = arg0.getParameter("option");
		if("1".equals(s)) {
			findProductByPage(arg0,arg1);
		}
		System.out.println("±ª∑√Œ ¡À");
		
	}
	 public void findProductByPage(HttpServletRequest request,HttpServletResponse response) {
		  
		   String pageNo=request.getParameter("pageNo");
		   System.out.println("====="+pageNo);
		  
		   List<Product> p =pService.findAll();
		  String s= JSON.toJSONString(p);
		  try {
			response.getWriter().print(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	 }	   
}
