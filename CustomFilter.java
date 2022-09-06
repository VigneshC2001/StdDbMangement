//package com.maven.Student;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.catalina.connector.Response;
//
//public class CustomFilter implements Filter {
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletResponse response = (HttpServletResponse) res;
//        HttpServletRequest httpRequest = (HttpServletRequest) req;
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
//        if (httpRequest.getMethod().equalsIgnoreCase("OPTIONS")) {
//            response.setStatus(Response.SC_OK);
//        }
//        chain.doFilter(req, res);
//    }
//
//    public void init(FilterConfig filterConfig) {
//        // TODO
//    }
//
//    public void destroy() {
//        // Todo
//    }
//
//}
