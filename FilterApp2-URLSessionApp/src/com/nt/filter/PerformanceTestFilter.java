package com.nt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class PerformanceTestFilter implements Filter {
  private long start=0,end=0;
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		ServletContext sc=null;
		//get request trapping time
		 start=System.currentTimeMillis();
		 chain.doFilter(req, res);
		 end=System.currentTimeMillis();
		 System.out.println( ((HttpServletRequest)req).getRequestURI()+"has taken "+(end-start)+" ms to process the request");
		 //write to log file
		 req.getServletContext().log( ((HttpServletRequest)req).getRequestURI()+"has taken "+(end-start)+" ms to process the request");
	}//doFilter(-,-)
}//class
