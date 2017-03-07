package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet4 extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		HttpSession ses=null;
		ServletContext sc=null;
		//General settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read and display request attribute value
		pw.println("<br>Servlet4: request attribute value"+req.getAttribute("attr1"));
		//read and display session attribute value
		ses=req.getSession();
		pw.println("<br>Servlet4: session attribute vlaue"+ses.getAttribute("attr2"));
		//read and display ServletContext attribute vlaue
		sc=getServletContext();
		pw.println("<br>Servlet4:ServletContext attribute vlaue::"+sc.getAttribute("attr3"));

	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}

}
