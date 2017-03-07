package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String ss=null,engine=null;
		String url=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		ss=req.getParameter("ss").replace(' ','+');
		engine=req.getParameter("engg");
		//prepare url with query String  for send Redirection
		if(engine.equalsIgnoreCase("google"))
			url="https://www.google.co.in/search?q="+ss;
		else if(engine.equalsIgnoreCase("bing"))
			url="http://www.bing.com/search?q="+ss;
		else 
			url="https://in.search.yahoo.com/search?p="+ss;
		//perform send Redirection
		pw.println("<b>before </b>");
		System.out.println("Before res.sendRedirect(-) method");
		  res.sendRedirect(url);
		  RequestDispatcher rd=req.getRequestDispatcher("/test.html");
		  rd.include(req,res);
		  System.out.println("After res.sendRedirect(-) method");
		  pw.println("<b>after </b>");
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)
}//class

