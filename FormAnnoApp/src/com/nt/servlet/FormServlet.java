package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet(
		name = "abc", 
		urlPatterns = { "/test1" }, 
		initParams = { 
				@WebInitParam(name = "dbuser", value = "scott"), 
				@WebInitParam(name = "dbpwd", value = "tiger")
		})
public class FormServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		Calendar calendar=null;
		String name=null;
		int hour=0;
		PrintWriter pw=null;
		ServletConfig cg=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		name=req.getParameter("pname");
		//get sys date
		calendar=Calendar.getInstance();
		//get current hour of the day
		hour=calendar.get(Calendar.HOUR_OF_DAY);
		//generate wish message
		if(hour<=12)
			pw.println("<h1>Good Morning::"+name+"</h1>");
		else if(hour<=16)
			pw.println("<h1>Good afternoon::"+name+"</h1>");
		else if(hour<=20)
			pw.println("<h1>Good evening::"+name+"</h1>");
		else
			pw.println("<h1>Good night::"+name+"</h1>");
			//add hyperlink
		pw.println("<a href='form.html'>home</a>");
		//get ServletConfig obj
		cg=getServletConfig();
		pw.println("<br>dbuser init param value"+cg.getInitParameter("dbuser"));
		pw.println("<br>dbpwd init param value"+cg.getInitParameter("dbpwd"));
		//close stream
		pw.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
