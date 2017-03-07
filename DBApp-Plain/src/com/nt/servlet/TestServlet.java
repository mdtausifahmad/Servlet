package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   PrintWriter pw=null;
	   ServletContext sc=null;
		//general settings
	   pw=res.getWriter();
	   res.setContentType("text/html");
	   //get Access to ServletContext obj
	   sc=getServletContext();
	   pw.println("<br> Server name and Version: "+sc.getServerInfo());
	   pw.println("<br> Context path name"+sc.getContextPath());
	   pw.println("<br> Servlet api version:"+sc.getMajorVersion()+"."+sc.getMinorVersion());
	   pw.println("<br> MIME type of input.html"+sc.getMimeType("input.html"));
	   pw.println("<br> Path of web application"+sc.getRealPath("/"));
	   pw.println("<br> path of input.html"+sc.getRealPath("input.html"));
	   pw.println("<br> virtual server name "+sc.getVirtualServerName());
	   //write log message
	   sc.log("Sys Date"+new java.util.Date());
	   //close stream
	   pw.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  doGet(req,res);
	}

}
