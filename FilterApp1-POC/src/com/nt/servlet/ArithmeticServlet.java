package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArithmeticServlet extends  HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("From ArithmeticServlet: doGet(-,-) method");
		 PrintWriter pw=null;
		 int val1=0,val2=0;
		//general Settings
		 pw=res.getWriter();
		 res.setContentType("text/html");
		 //read form data
		 val1=Integer.parseInt(req.getParameter("t1"));
		 val2=Integer.parseInt(req.getParameter("t2"));
		 //Perform addition
		 pw.println("<h1><center> Sum is "+(val1+val2)+"</center></h1>");
		 //close stream
		 pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)
}//class
