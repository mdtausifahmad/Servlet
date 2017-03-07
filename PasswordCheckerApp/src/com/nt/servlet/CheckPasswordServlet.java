package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckPasswordServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String pwd=null;
		int length=0;
		boolean nonAlphabets=false;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		pwd=req.getParameter("pwd");
		//verify password
		length=pwd.length();
		if(length<5)
			pw.println("<h1 style='color:red'> Weak Password</h1>");
		else {
			for(int i=0;i<=length-1;++i){
				if(!Character.isUpperCase(pwd.charAt(i)) && !Character.isLowerCase(pwd.charAt(i))){
				   nonAlphabets=true;
				}//else
			}//for
			if(nonAlphabets==true)
				pw.println("<h1 style='color:red'> Strong Password</h1>");
			else
				pw.println("<h1 style='color:red'> weak Password</h1>");
			
		}//else
		 //add hperlink
		pw.println("<a href='form.html'>home</a>");
		//close stream
		pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}//class
