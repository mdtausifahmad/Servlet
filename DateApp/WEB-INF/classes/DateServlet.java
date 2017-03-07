//DateServlet.java
package com.nt.servlet;

import javax.servlet.*;
import java.io.*;
import java.util.*;

public class DateServlet extends GenericServlet
{
	public  DateServlet(){
		System.out.println("DateServlet:0-param constructor");
	}
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{	
		 System.out.println("DateServlet: service(-,-) method");
		//set response content Type
		 res.setContentType("text/html");
		 //get PrintWriter 
		 PrintWriter pw=res.getWriter();
		 //write request processing logic
		 Date d=new Date();

		 //write the response
		 pw.println("<h1 style='color:red'><center>Date and time "+d+"</center></h1>");
         pw.println("<br> our servlet class obj hashCode"+ this.hashCode());
		 pw.println("<br> request obj hashCode"+ req.hashCode());
         pw.println("<br> response obj hashCode"+ res.hashCode());
         pw.println("<br> current thread obj hashCode"+ Thread.currentThread().hashCode());

		 pw.println("<br> req object class name"+req.getClass());
		 pw.println("<br> req object class name"+res.getClass());



		 //close stream  (commits the response)
		 pw.close();
	}//service(-,-)
}//class
