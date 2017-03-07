package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowCookiesServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		Cookie ck[]=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read cookies
		ck=req.getCookies();
		pw.println("<table>");
		pw.println("<tr><th>Cookie name</th><th>Cookie Value</th></tr>");
		for(Cookie cookie:ck){
			pw.println("<tr><td>"+cookie.getName()+"</td><td>"+cookie.getValue()+"</td></tr>");
		}//for
		pw.println("</table>");
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)
}//class
