package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  PrintWriter pw=null;
		  String pVal=null;
		  Locale locales[]=null;
		  //general settigs
		  pw=res.getWriter();
		  res.setContentType("text/html");
		  //read s1 request param value
		  pVal=req.getParameter("s1");
		  //write request processng logic based on the hyperlink that is clicked
		  // get all locales
		  locales=Locale.getAvailableLocales();
		  if(pVal.equalsIgnoreCase("link1")){
			  pw.println("<h1>All countries</h1>");
			  for(Locale locale:locales){
				  pw.println("<br>"+locale.getDisplayCountry());
			  }//for
		  }//if
		  else if(pVal.equalsIgnoreCase("link2")){
			  pw.println("<h1>All Languages</h1>");
			  for(Locale locale:locales){
				  pw.println("<br>"+locale.getDisplayLanguage());
			  }//for
		  }//else
		  else{
			pw.println("<h1>Date and Time:::"+new java.util.Date()+"</h1>");
		  }//else
		  //add hyperlink
		  pw.println("<br><a href='links.html'>home</a>");
		  //close stream
		  pw.close();
	}//doGet(-,-)

}
