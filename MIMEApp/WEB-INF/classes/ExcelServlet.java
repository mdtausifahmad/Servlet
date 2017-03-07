//ExcelServlet.java
package com.nt.servlet;

import javax.servlet.*; //servlet api
import javax.servlet.http.*; //servlet api
import java.io.*;

public class  ExcelServlet extends HttpServlet
{
	protected void  service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
        PrintWriter pw=null;
		//get PrintWriter object
		pw=res.getWriter();
		//set response content type
		res.setContentType("application/vnd.ms-excel");
		//write content
		pw.println("<table border='1'>");
		pw.println("<tr><th>Person </th><th>Black Money</th></tr>");
		pw.println("<tr><td>Maliya </td><td> 2 lac cr</td></tr>");
		pw.println("<tr><td>Gali janadran </td><td> 3 lac cr</td></tr>");
		pw.println("<tr><td>Ambani </td><td> 4 lac cr</td></tr>");
		pw.println("<tr><td>Rahul Gandhi </td><td> 0.5 lac cr</td></tr>");
		pw.println("</table>");
		//close stream
		pw.close();
	}//service(-,-)
}//class
