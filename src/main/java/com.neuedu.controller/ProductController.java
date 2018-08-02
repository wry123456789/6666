package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.neuedu.entity.Page;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.ProductServiceImpl;
@WebServlet("/product")
public class ProductController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ProductService  pService=new ProductServiceImpl();
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
	System.out.println(option);
	   if("1".equals(option)) { 
		//�������ӵķ���
		add(req,resp);
	}else if("2".equals(option)) {
		findAll(req, resp);
		
	}else if("3".equals(option)) {
		deleteProduct(req,resp);
	}else if("4".equals(option)) {
		updateProduct(req,resp);
	}else if("5".equals(option)) {
		findProductById(req,resp);
	}else if("6".equals(option)) {
		findById(req,resp);
	}else if("7".equals(option)) {
	    findProductByPage(req,resp);
	}else if("8".equals(option)) {
		   findAll(req, resp);
	   }else if("9".equals(option)) {
		   findProductByIds(req,resp);
	   }
	}
	public void add(HttpServletRequest req,HttpServletResponse reps) {
		String name=req.getParameter("name");
		String desc=req.getParameter("desc");
		Integer stock=0;
		Double price=0.0;
		int id =0;
		String rule=req.getParameter("rule");
		String image=req.getParameter("image");
		try {
		 stock=Integer.parseInt(req.getParameter("stock"));
		 price=Double.parseDouble(req.getParameter("price"));
		 id =Integer.parseInt(req.getParameter("category"));
		}catch(Exception e) {
			throw new RuntimeException();
		}
		Product product = new Product();
		product.setName(name);
		product.setDesc(desc);
		product.setPrice(price);
		product.setRule(rule);
		product.setImage(image);
		product.setStock(stock);
		product.setId(id);
		System.out.println(product);
		boolean flag=pService.addProduct(product);
		if(flag) {
			System.out.println("��ӳɹ�");
			findProductByPage(req, reps);
		}else {
			System.out.println("���ʧ��");
		}
	}
			
	public Product findById(HttpServletRequest req,HttpServletResponse reps) {
		int id=Integer.parseInt(req.getParameter("id"));
    	Product product =pService.findProductById(id);
    	req.setAttribute("product",product);
    	try {
			req.getRequestDispatcher("updateproduct.jsp").forward(req, reps);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product ;
	}

    /**��ѯ��Ʒ*/
    public  void findAll(HttpServletRequest request,HttpServletResponse response){
response.setHeader("Access-Control-Allow-Origin" ,
		"*");
    	List<Product> list= pService.findAll();
    	System.out.println("����ǰ̨�����");

    Gson s = new Gson();
    String s1=s.toJson(list);
    PrintWriter pw=null;
		try {
			pw=response.getWriter();
			pw.write(s1);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
    /**�޸���Ʒ*/
    public void updateProduct(HttpServletRequest request,HttpServletResponse response) {
    	Product p= new Product();
        String name=request.getParameter("name");
        int  id=Integer.parseInt(request.getParameter("id"));
        String desc=request.getParameter("desc");
		Integer stock=0;
		Double price=0.0;
		try {
			 stock=Integer.parseInt(request.getParameter("stock"));
			 price=Double.parseDouble(request.getParameter("price"));
			}catch(Exception e) {
				throw new RuntimeException();
			}
		String rule=request.getParameter("rule");
		String image=request.getParameter("image");
		 p.setId(id);
	     p.setName(name);
	     p.setDesc(desc);
		 p.setPrice(price);
		 p.setRule(rule);
		 p.setImage(image);
		 p.setStock(stock);
        	Boolean flag=pService.updateProduct(p);
        	if(flag) {
        	
        	System.out.println("�޸ĳɹ�");
				findProductByPage(request, response);
        	return ;
        	}else {
        		System.out.println("�޸�ʧ��");
        	}
        }
      
    	
   
   
    /**ɾ����Ʒ*/
    public void deleteProduct(HttpServletRequest request,HttpServletResponse response) {
    	boolean flag=pService.deleteProduct(Integer.parseInt(request.getParameter("id")));
    	if(flag) {
    		System.out.println("ɾ���ɹ�");
			findProductByPage(request, response);
    	}else {
    		System.out.println("ɾ��ʧ��");
    	}
    }
  /*��������ʾ��ҳ������Ҫ�õ�������
   * ��Ϊ��Ҫ��������ʾ��ҳ���ϴ�ҳ���ȡ���ݣ�����ҳ�洫����������
   * 1.�Ƚ�������ʾ������̨
  */ 
    public void findProductByIds(HttpServletRequest request,HttpServletResponse response) {
    	//��ȡidҲ����ͨ����ν�������ʾ��ҳ����
		response.setHeader("Access-Control-Allow-Origin" ,"*");
    	int id=Integer.parseInt(request.getParameter("id"));
    	Product product =pService.findProductById(id);
        Gson gson = new Gson();
        String s= gson.toJson(product);
        PrintWriter pw = null;
		try {
			pw=response.getWriter();
			pw.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
   public void findProductByPage(HttpServletRequest request,HttpServletResponse response) {
	  
	   String pageNo=request.getParameter("pageNo");
	   if(pageNo==null) {
		   pageNo="1";
	   }
	   Page<Product> p =pService.findProductByPage(Integer.parseInt(pageNo),5);
	   request.setAttribute("p", p);
	   //���÷���
	   try {
		request.getRequestDispatcher("page.jsp").forward(request, response);
	} catch (ServletException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
	public void findProductById(HttpServletRequest request,HttpServletResponse response) {
		//��ȡidҲ����ͨ����ν�������ʾ��ҳ����
		response.setHeader("Access-Control-Allow-Origin" ,
				"*");
		int id=Integer.parseInt(request.getParameter("id"));
		Product product =pService.findProductById(id);
		System.out.println(product.getStock());
		if(product.getName()!=null) {
			request.setAttribute("product", product);
		}else {
			request.getRequestDispatcher("showfail.jsp");
		}
		try {
			request.getRequestDispatcher("showproductById.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
