package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null;
		String fname=null;
		String mStatus=null;
		String f2val1=null,f2val2=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form1/req1 data
		name=req.getParameter("name");
		fname=req.getParameter("fname");
		mStatus=req.getParameter("ms");
		//read form2/req1 data
		f2val1=req.getParameter("f2t1");
		f2val2=req.getParameter("f2t2");
		//Display both form1/req1 and form2 request data
		pw.println("form1/req1  data"+name+"...."+fname+"....."+mStatus);
		pw.println("<br>form2/req2  data"+f2val1+"...."+f2val2);
		//add hyperlink
		pw.println("<a href='details.html'>home</a>");
		//close stream 
		pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)
}//class

