package com.neuedu.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;
import com.neuedu.service.impl.LoginServiceImpl;
import com.neuedu.utils.MD5Utils;


/**
 * ��������û��û���������
 * */
@WebServlet("/login")
public class LoginController extends HttpServlet{

	ILoginService  loginService=new LoginServiceImpl();
	/**
	 * 
	 */
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
		 try {
			login(req,resp);
			System.out.println("��¼���ʵ���");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }else if("2".equals(option)) {
		 resgiter(req,resp);
	 } 
		
	}

	/**
	 * @return boolean true:��¼�ɹ� false����¼ʧ��
	 * @throws Exception 
	 * @throws ServletException 
	 * */
	//ע��
	public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, Exception {
		String username=null;
		String password=null;
		 username=req.getParameter("username");
		 password=req.getParameter("password");
		Account a=loginService.doLogin(username, MD5Utils.GetMD5Code(password));
		System.out.println(a);
		if(a!=null) {
			Cookie c = new Cookie("username",username);
			c.setMaxAge(7*24*3600);
			resp.addCookie(c);
			Cookie pw  = new Cookie("password",MD5Utils.GetMD5Code(password));
			pw.setMaxAge(7*24*3600);
			resp.addCookie(pw);
			//��¼�ɹ�֮�����ݲ������ݿ�
			String token=MD5Utils.GetMD5Code(username+password+System.currentTimeMillis());
			HttpSession session1 = req.getSession();
			session1.setAttribute("tk",token);
			session1.setAttribute("acc",a);

			Account s =(Account)session1.getAttribute("acc");

		    System.out.println("����"+s.accountId);
			//�����ݲ������ݿ�
			loginService.addToken(token, a);
			System.out.println(token);
			//��¼�ɹ�
			req.getRequestDispatcher("loginsucess.jsp").forward(req, resp);
		}else {
			//��¼ʧ��
			req.getRequestDispatcher("loginfail.jsp").forward(req, resp);
		}
	}
	//ע��
	public void resgiter(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String sex = req.getParameter("sex");
		Account c = new Account(username,password,sex);
		boolean flag=loginService.register(c);
		if(flag) {
			System.out.println("ע��ɹ�");
			try {
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("ע��ʧ��");
		}
		
	}
	
}
