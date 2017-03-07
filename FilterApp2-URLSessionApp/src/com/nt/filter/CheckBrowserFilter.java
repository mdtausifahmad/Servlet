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

public class CheckBrowserFilter implements Filter {

	

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
	    PrintWriter pw=null;
	    String browser=null;
          //general  settings
        pw=res.getWriter();
        res.setContentType("text/html");
		//get browser name
         browser=((HttpServletRequest)req).getHeader("user-agent");
         System.out.println(browser);
         if(browser.indexOf("Chrome")==-1){
        	 pw.println("<span style='color:red'> browser must be chrome</span>");
        	 return;
         }
         else{
        	 chain.doFilter(req, res);
         }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
