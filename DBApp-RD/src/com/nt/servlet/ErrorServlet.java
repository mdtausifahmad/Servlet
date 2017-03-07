package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("ErrorServlet: doGet(-,-)");
		PrintWriter pw=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//display Error message
		pw.println("<h3 style='color:red'> Internal problem Try Again </h3>");
		
		//close stream 
		pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)
}//class
