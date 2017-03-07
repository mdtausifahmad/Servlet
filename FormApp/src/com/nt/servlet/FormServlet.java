package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,addrs=null,gendor=null,qlfy=null,ms=null;
		 int age=0;
		String hobies[]=null,courses[]=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		name=req.getParameter("pname");
		age=Integer.parseInt(req.getParameter("page"));
		addrs=req.getParameter("addrs");
		gendor=req.getParameter("gender");
		ms=req.getParameter("ms");
		qlfy=req.getParameter("qlfy");
		hobies=req.getParameterValues("hb");
		courses=req.getParameterValues("courses");
		pw.println("<h1> Display Form data</h1>");
		pw.println("<br>name==="+name);
		pw.println("<br>age==="+age);
		pw.println("<br>Address==="+addrs);
		pw.println("<br>Gendor==="+gendor);
		pw.println("<br>Marital Status==="+ms);
		pw.println("<br>Qualification==="+qlfy);
		pw.println("<br>Hobies==="+Arrays.toString(hobies));
		pw.println("<br>Courses==="+Arrays.toString(courses));
		
		//set marital status to null when checkbox is not selected
		if(ms==null)
			ms="single";
		//write b.logic
		if(gendor.equalsIgnoreCase("M")){
			if(age<5)
				 pw.println("<h1 style='color:red'> Master."+name+" u  r baby boy</h1>");
			else if(age<13)
				 pw.println("<h1 style='color:red'> Master."+name+" u  r small boy</h1>");
			else if(age<19)
				 pw.println("<h1 style='color:red'> Mr."+name+" u  r teenage boy</h1>");
			else if(age<35)
				 pw.println("<h1 style='color:red'>Mr."+name+" u  r young man</h1>");
			else if(age<50) 
				pw.println("<h1 style='color:red'>Mr."+name+" u  r middle aged man</h1>");
			else
				pw.println("<h1 style='color:red'>Mr."+name+" u  r budda man</h1>");
		}
		else{
			if(age<5)
				 pw.println("<h1 style='color:red'> Master."+name+" u  r baby girl</h1>");
			else if(age<13)
				 pw.println("<h1 style='color:red'> Master."+name+" u  r small girl</h1>");
			else if(age<19)
				if(ms.equalsIgnoreCase("single"))
				 pw.println("<h1 style='color:red'> Miss."+name+" u  r teenage girl</h1>");
				else
				pw.println("<h1 style='color:red'> Mrs."+name+" u  r teenage girl</h1>");
			else if(age<35)
				if(ms.equalsIgnoreCase("single"))
				 pw.println("<h1 style='color:red'>Miss."+name+" u  r young woman</h1>");
				else
					pw.println("<h1 style='color:red'>Mrs."+name+" u  r young woman</h1>");
			else if(age<50) 
				if(ms.equalsIgnoreCase("single"))
					 pw.println("<h1 style='color:red'>Miss."+name+" u  r middle-aged woman</h1>");
				else
				  pw.println("<h1 style='color:red'>Mrs."+name+" u  r middle-age woman</h1>");
			else
				if(ms.equalsIgnoreCase("single"))
					 pw.println("<h1 style='color:red'>Miss."+name+" u  r old woman</h1>");
				else
				  pw.println("<h1 style='color:red'>Mrs."+name+" u  r old woman</h1>");
		}//else
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
