package com.neuedu.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.dao.impl.jdbc.CategoryDaoImpl;
import com.neuedu.entity.Category;
import com.neuedu.service.CartService;
import com.neuedu.service.impl.CartServiceImpl;
@WebServlet("/category")
public class CategoryController extends HttpServlet{
CategoryDaoImpl cd = new CategoryDaoImpl();
	/**
	 * 
	 */
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
		String option=req.getParameter("option");
		if("1".equals(option)) {
			findAll(req,resp);
		}else if("2".equals(option)) {
			delete(req,resp);
		}else if("3".equals(option)) {
			add(req,resp);
		}else if("4".equals(option)) {
			addSon(req, resp);
		}else if("5".equals(option)) {
			findName(req,resp);
		}else if("6".equals(option)) {
			findById(req,resp);
		}else if("7".equals(option)) {
			update(req,resp);
		}
	}
	public void findAll(HttpServletRequest req, HttpServletResponse resp) {
		List<Category>list = cd.findAll();
		req.setAttribute("categorys", list);
		try {
			req.getRequestDispatcher("category.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void findName(HttpServletRequest req, HttpServletResponse resp) {
		List<Category>list = cd.findAll();
		req.setAttribute("categorys", list);
		try {
			req.getRequestDispatcher("addCategorySon.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void delete(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		String pid= req.getParameter("pid");
		cd.delete(Integer.parseInt(id),Integer.parseInt(pid) );
		findAll(req,resp);
	}
//添加根类别
  public void add(HttpServletRequest req, HttpServletResponse resp) {
	  String name = req.getParameter("name");
	  String pdesc = req.getParameter("pdesc");
	 boolean flag= cd.addCategory(name, pdesc);
	 try {
		req.setCharacterEncoding("UTF-8");
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		resp.setContentType("text/html;charset=UTF-8");
	 if(flag) {
		 System.out.println("添加成功");
	 }else {
		 System.out.println("添加失败");
	 } 
	 findAll(req,resp);
  }
  //添加子类别
  public void addSon(HttpServletRequest req, HttpServletResponse resp) {
	  String pname = req.getParameter("pname");
	  System.out.println(pname);
	  int pid=cd. findId(pname);
	  System.out.println("pid"+pid);
	  String name = req.getParameter("name");
	  String pdesc = req.getParameter("pdesc");
	  cd.addCategory(name, pdesc, pid);
	  findAll(req,resp);
  }
  public void findById(HttpServletRequest req, HttpServletResponse resp) {
	  //获取id参数
	 String ids =req.getParameter("id");
	 int id =Integer.parseInt(ids);
	 Category c=cd.findById(id);
	 req.setAttribute("cate", c);
	 try {
		req.getRequestDispatcher("updateCategory.jsp").forward(req, resp);
	} catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	};
	 
  }
  public void update(HttpServletRequest req, HttpServletResponse resp) {
	  String name = req.getParameter("name");
	  String desc =req.getParameter("desc");
	  String ids =req.getParameter("id");
	  int id =Integer.parseInt(ids);
	  cd.update(name, desc, id);
	  findAll(req,resp);  
	  //修改的时候需要传递一个参数
  }
}
