package com.nt.servlet;

import java.io.* ;
import javax.servlet.* ;
import javax.servlet.http.* ;

public class FirstServlet extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,  IOException 
	{
    	//General settings
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
        //read form1/req1 data
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String age=req.getParameter("age");
        //create HttpSession obj for current Browser
		HttpSession session = req.getSession(true);
		//Keep form1/req1 data in HttpSession obj as session attribute values
		session.setAttribute("name", name);
		session.setAttribute("Addr", address);
		session.setAttribute("age", age);
		
			
       //Generate form2 dynamically
		pw.println("<BODY BGCOLOR=cyan>");
		pw.println("<CENTER><H1><FONT COLOR=red>Provide Your Exp & Skils</FONT></H1></CENTER>");
		pw.println("<FORM  ACTION="+res.encodeURL("surl")+" METHOD=POST>");
		pw.println("<TABLE ALIGN=CENTER>");
		pw.println("<TR>");             
		pw.println("<TD>");             
		pw.println("<H2><FONT COLOR=BLUE>Enter Number of Years Exp :");
		pw.println("<INPUT TYPE=TEXT NAME=exp SIZE=6>");
		pw.println("</TD></TR>");
		pw.println("<TR>");     
		pw.println("<TD>");     
		pw.println(" <H2><FONT COLOR=blue><B>Select Skils:</B>");
		pw.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		pw.print("<SELECT NAME=skils>");
		pw.print("<OPTION VALUE=JAVA>JAVA/J2EE </OPTION>");
		pw.print("<OPTION VALUE=.NET>.Net </OPTION>");
		pw.print("<OPTION VALUE=ORACLE>ORACLE 10G </OPTION>");
		pw.print("<OPTION VALUE=XML>XML & Web Services </OPTION>");
		pw.print("</SELECT>"); 
		pw.println("</TD></TR>");
		pw.println("<TR><TD>");
		pw.println("<INPUT TYPe=Submit value=Continue>");
		pw.println("</TABLE></BODY>");
		pw.println("</FORM>");
	    pw.println("<br><br>session Id"+session.getId());
	    pw.println("<br><br> Request count:::"+req.getServletContext().getAttribute("ReqCounter"));
		
		
	} // service()
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    		throws ServletException, IOException {
      doGet(req,res);
    }
} // class