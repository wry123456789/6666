package com.neue.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;
import com.neuedu.service.impl.LoginServiceImpl;

/**
 * Servlet Filter implementation class ProtectedFilter
 */

public class ProtectedFilter implements Filter {
	ILoginService  loginService=new LoginServiceImpl();
    /**
     * Default constructor. 
     */
    public ProtectedFilter() {
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
        //���session
		System.out.println("����������������");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session1 = req.getSession();
		String token = (String) session1.getAttribute("tk");
		System.out.println(session1.getMaxInactiveInterval());
		System.out.println("����������token��ֵ"+token);
		Account s = (Account) session1.getAttribute("acc");
		System.out.println("���������е�sֵ"+s);
		if(token!=null&&s!=null) {
		String token1 = loginService.findTokenByAccountId(s.getAccountId());
		   if(token.equals(token1)) {
			   chain.doFilter(request, response);
			   return;
		}
		// pass the request along the filter chain
	}
		resp.sendRedirect("http://localhost:8080/www/login.jsp");

	}/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
