package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.neuedu.dao.impl.jdbc.ProductsImpl;
import com.neuedu.entity.Category;
import com.neuedu.entity.Product;
import com.neuedu.entity.Products;

/**
 * Servlet implementation class ProductsCon
 */
@WebServlet("/ProductsCon")
public class ProductsCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductsImpl p = new ProductsImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsCon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String option = request.getParameter("option");
		if("1".equals(option)) {
			findAll(request,response);//显示的时候找出一个然后在找出下一个
		}else if("2".equals(option)) {
			add(request,response);
		}else if("3".equals(option)) {
			findAllBy(request,response);
		}else if("4".equals(option)) {
			delte(request,response);
		}else if("5".equals(option)) {
			find(request,response);
		}
		
	}
	public void add(HttpServletRequest req,HttpServletResponse reps){
		System.out.println("被调用了");
		String name=req.getParameter("name");
		String desc=req.getParameter("desc");
		Double price=0.0;
		try {
			 price=Double.parseDouble(req.getParameter("price"));
			}catch(Exception e) {
				throw new RuntimeException();	
	}
		Products p1 = new Products(name,desc,price);
		boolean ss=p.addProduct(p1);	
		if(ss) {
			try {
				PrintWriter pw = reps.getWriter();
				pw.print("1");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
	public void findAll(HttpServletRequest req,HttpServletResponse reps) {
		List<Products>list = p.findAll();
		String s=JSON.toJSONString(list);
		
		try {
			PrintWriter pw = reps.getWriter();
			pw.print(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public void findAllBy(HttpServletRequest req,HttpServletResponse reps) {
		List<Products>list = p.findAllByDesc();
		String s=JSON.toJSONString(list);
		
		try {
			PrintWriter pw = reps.getWriter();
			pw.print(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public void delte(HttpServletRequest req,HttpServletResponse reps) {
		
		String pp = req.getParameter("id");
		p.deleteProduct(Integer.parseInt(pp));
		
	}
	public void find(HttpServletRequest req,HttpServletResponse reps) {
		
		String pp = req.getParameter("name");
		System.out.println(pp);
		int id=p.findId(pp);
		String s=JSON.toJSONString(id);
		try {
			PrintWriter pw = reps.getWriter();
			pw.print(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	
