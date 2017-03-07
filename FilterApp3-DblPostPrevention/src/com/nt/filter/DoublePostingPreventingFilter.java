package com.nt.filter;

import java.io.IOException;
import java.util.Random;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class DoublePostingPreventingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
	    HttpSession ses=null;
	    String method=null;
	    int serverToken=0;
	    int clientToken=0;
	    RequestDispatcher rd=null;
	  
	    //get request method
	    method=((HttpServletRequest)req).getMethod();
	    if(method.equalsIgnoreCase("GET")){
			//create or locate Session
	    	  ses=((HttpServletRequest)req).getSession();
	    	//create Server side token
	    	 ses.setAttribute("serverToken", new Random().nextInt(1000));
	    	 System.out.println("Generated Server token"+ses.getAttribute("serverToken"));
	    	 chain.doFilter(req,res);
	    }
	    else{  //POST
	    	//Access Session obj
	    	ses=((HttpServletRequest)req).getSession(false);
	    	//read client token and Server token
	    	serverToken=(Integer)ses.getAttribute("serverToken");
	    	clientToken=Integer.parseInt(req.getParameter("cToken"));
	    	System.out.println(serverToken+"<------>"+clientToken);
	    	//compare Client and Server Tokens
	    	if(serverToken==clientToken){
	    		//change Server token value 
	    		ses.setAttribute("serverToken",new Random().nextInt(1000));
	    		System.out.println("changed token value"+ses.getAttribute("serverToken"));
	    		chain.doFilter(req,res); //send request to Servlet comp
	    	}
	    	else{
	    		rd=req.getRequestDispatcher("/dbl_post_err.html");
	    		rd.forward(req,res);
	    	}//else
	    }//else
	}//doFiter(-,-)
	@Override
	public void destroy() {
	
	}

}
