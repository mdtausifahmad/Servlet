package com.nt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RequestCountFilter implements Filter {
  int count;
	@Override
	public void destroy() {
	
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		ServletContext sc=null; 
		count++;
		//place count in application scope
		sc=req.getServletContext();
		sc.setAttribute("ReqCounter",count);
		chain.doFilter(req,res);
	}//doFilter

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		count=0;
	}

}
