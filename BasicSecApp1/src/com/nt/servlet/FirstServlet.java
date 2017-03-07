package com.nt.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class FirstServlet extends HttpServlet
{
public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
{
	//general settings
 PrintWriter pw=resp.getWriter();
 resp.setContentType("text/html");
 //display data
 pw.println("page successfully displayed");
pw.println("<center><b>the user name is "+req.getRemoteUser()+"</center></b>");
pw.println("<center><b>the auth type    is "+req.getAuthType()+"</center></b>");
//close stream
pw.close();
}// service()
}// class
	