package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet2 extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		RequestDispatcher rd=null;
		HttpSession ses=null;
		ServletContext sc=null;
		//General settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read and display request attribute value
		pw.println("<br>Servle2: request attribute value::"+req.getAttribute("attr1"));
		//read and display session attribute vlaue
		ses=req.getSession();
		pw.println("<br>Servlet2: session attribute vlaue::"+ses.getAttribute("attr2"));
		//read and display Servletcontext attribute vlaue
		sc=getServletContext();
		pw.println("<br>Servlet2:ServletContext attribute vlaue::"+sc.getAttribute("attr3"));

	
		//forward request servlet3
		rd=req.getRequestDispatcher("servlet3");
		rd.forward(req,res);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}

}
