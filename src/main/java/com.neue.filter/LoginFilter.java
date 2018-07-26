package com.neue.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;
import com.neuedu.service.impl.LoginServiceImpl;


/**
 * Servlet Filter implementation class LoginFilter
 */

public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
       System.out.println("filter��������");
		// pass the request along the filter chain
		ILoginService loginService = new LoginServiceImpl();
		String username =null;
		String password = null;
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		Cookie[]login = req.getCookies();
		if(login!=null) {
		for(Cookie c:login) {
			if("username".equals(c.getName())) {
				username = c.getValue();
			}
			if("password".equals(c.getName())) {
				password = c.getValue();	
			}
		}
		}
		System.out.println("�û���"+username);
		System.out.println("�û���"+password);
		if(username!=null&&password!=null&&username!=""&&password!="") { 
			Account a=loginService.doLogin(username, (password));
			if(a!=null) {
				System.out.println("��¼�ɹ�");
				System.out.println("filter���óɹ�");
				
			
				req.getRequestDispatcher("loginsucess.jsp").forward(req, resp);
				
			}else {
				chain.doFilter(request, response);
				System.out.println("��һ�ε�¼");
		}
	}else {
		chain.doFilter(request, response);
		System.out.println("��һ�ε�¼");
	}
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
