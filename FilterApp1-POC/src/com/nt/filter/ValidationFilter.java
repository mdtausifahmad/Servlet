package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class ValidationFilter implements Filter {
	  static{
		  System.out.println("ValidationFilter:static block");
	  }
	  public ValidationFilter() {
		System.out.println("ValidationFilter:0-param constructor");
	}
	  @Override
	public void init(FilterConfig fg) throws ServletException {
	  System.out.println("ValidationFilter:init(-)");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
        System.out.println("ValidationFilter: doFilter(-,-)");
        PrintWriter pw=null;
        int val1=0,val2=0;
          //general  settings
        pw=res.getWriter();
        res.setContentType("text/html");
        //read form data
        val1=Integer.parseInt(req.getParameter("t1"));
        val2=Integer.parseInt(req.getParameter("t2"));
        if(val1<=0 || val2<=0){
        	pw.println("<h1><center> Error page </center></h1>");
        	pw.println("<span style='color:red'>Inputs should be +ve</span>");
        	return;
        }
        else{
        	System.out.println("browser name"+((HttpServletRequest)req).getHeader("user-agent"));
        	System.out.println("before chain.doFilter(-,-)");
        	chain.doFilter(req, res);
        	System.out.println("after chain.doFilter(-,-)");
        }//else
        //close stream
        pw.close();
	}//doFilter(-,-)
	
	@Override
	public void destroy() {
	  System.out.println("ValidationFilter:destroy()");
	}
	

}
