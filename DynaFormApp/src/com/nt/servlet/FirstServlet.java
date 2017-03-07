package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null;
		String fname=null;
		String mStatus=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form1 data
		name=req.getParameter("name");
		fname=req.getParameter("fname");
		mStatus=req.getParameter("ms");
		//set default value in mStatus for checkBox not Selected state
		if(mStatus==null)
			mStatus="single";
		// generate form2 dynamically from here based marital status
		if(mStatus.equalsIgnoreCase("married")){
		  pw.println("<form action='secondurl' method='post'>");
		  pw.println("Spouse name:<input type='text' name='f2t1'><br>");
		  pw.println("No.of Children:<input type='text' name='f2t2'><br>");
		  pw.println("<input type='submit' value='submit'>");
		  pw.println("</form>");
		}//if
		else{
			  pw.println("<form action='secondurl' method='post'>");
			  pw.println("When do u want to marry :<input type='text' name='f2t1'><br>");
			  pw.println("Why do u want to mary:<input type='text' name='f2t2'><br>");
			  pw.println("<input type='submit' value='submit'>");
			  pw.println("</form>");
		}
		  //close stream
		pw.close();
	}//doGet(-,-)
	@Override
	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  doGet(req,res);
	}//doPost(-,-)

}
