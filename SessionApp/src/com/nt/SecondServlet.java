package com.nt;
import java.io.* ;

import javax.servlet.* ;
import javax.servlet.http.* ;

public class SecondServlet extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,  IOException 
	{
    	//General Settings
		res.setContentType( "text/html" ) ;
		PrintWriter pw = res.getWriter( ) ;
        //read form2/req2 data
		String exp=req.getParameter("exp");
		String skils=req.getParameter("skils");
		
		//Access HttpSession obj
		HttpSession session = req.getSession(false) ;
		//Keep form2/req2 data in Session obj as session attribute values
		session.setAttribute("exp", exp );
		session.setAttribute("skils", skils );
		
		System.out.println("request url"+req.getRequestURI());
		//Generate form3 dynamically from here
		pw.println("<BODY BGCOLOR=cyan>");
		pw.println("<CENTER><H1><FONT COLOR=red>Provide City & Salary</FONT></H1></CENTER>");
		pw.println("<FORM  ACTION='turl' METHOD=POST>");
		pw.println("<TABLE ALIGN=CENTER>");
		pw.println("<TR>");               
		pw.println("<TD>");               
		pw.println("<H2><FONT COLOR=BLUE>Enter Preference City :");
		pw.println("<INPUT TYPE=TEXT NAME=city SIZE=6>");
		pw.println("</TD></TR>");         
		pw.println("<TR>");               
		pw.println("<TD>");               
		pw.println("<H2><FONT COLOR=BLUE>Enter Expected Salary :");
		pw.println("<INPUT TYPE=TEXT NAME=sal SIZE=16>");
		pw.println("</TD></TR>");         
		pw.println("<TR><TD>");           
		pw.println("<INPUT TYPE=SUBMIT VALUE=Submit >");
		pw.println("</TABLE></BODY>"); 
		pw.println("</FORM>");
		pw.println("<br><br>session Id"+session.getId());
	} // doGet(-,-)
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
    		throws ServletException, IOException {
    	doGet(req,res);
    }
    
} // class