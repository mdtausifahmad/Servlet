package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String ss=null;
		String url=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		ss=req.getParameter("ss").replace(' ','+');
		// prepare google Search url
		url="https://www.google.co.in/search?q="+ss;
		//generate hyperlink to support send Redirection
		pw.println("<a href="+url+">go to Google</a>");
		//close stream
		pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)
}//class

