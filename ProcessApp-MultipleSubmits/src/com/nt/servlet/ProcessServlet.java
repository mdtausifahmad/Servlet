package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		 String pval=null;
		 int val1=0,val2=0;
		 //general settings
		 pw=res.getWriter();
		 res.setContentType("text/html");
		 
		 //read "s1" req param value
		 pval=req.getParameter("s1");
		 //process the request
		 if(pval.equals("link1")){
			 pw.println("<h1>Date and time "+new Date()+"</h1>");
		 }
		 else if(pval.equals("link2")){
			 pw.println("<h1>Sys properties</h1> "+System.getProperties());
		 }
		 else if(pval.equals("add")){
			val1=Integer.parseInt(req.getParameter("t1"));
			val2=Integer.parseInt(req.getParameter("t2"));
			pw.println("<h1>Addition::"+(val1+val2)+"</h1>");
		 }
		 else if(pval.equals("sub")){
				val1=Integer.parseInt(req.getParameter("t1"));
				val2=Integer.parseInt(req.getParameter("t2"));
				pw.println("<h1>subtraction::"+(val1-val2)+"</h1>");
			 }
		 else{
				val1=Integer.parseInt(req.getParameter("t1"));
				val2=Integer.parseInt(req.getParameter("t2"));
				pw.println("<h1>Multiplication::"+(val1*val2)+"</h1>");
		 }
		//add hyperlink
		 pw.println("<a href='form.html'>home</a>");
		 //close stream
		 pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)

}//class
