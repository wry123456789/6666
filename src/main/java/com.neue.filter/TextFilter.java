//package com.neue.filter;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.lang.reflect.Proxy;
//
//public class TextFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        //对表单get方式提交的数据进行编码
//        HttpServletRequest request= (HttpServletRequest)servletRequest;
//        request.setCharacterEncoding("UTF-8");
//        HttpServletResponse response = (HttpServletResponse)servletResponse;
//        response.setContentType("text/html;charset=utf-8");
//       //使用匿名处理对象对接口中某一个方法进行重写
//        Proxy.newProxyInstance(
//                request.getClass().getClassLoader(),
//                new  Class[]{HttpServletRequest.class}
//
//        )
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
