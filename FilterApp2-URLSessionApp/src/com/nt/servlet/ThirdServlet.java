package com.nt.servlet;
import java.io.* ;
import javax.servlet.* ;
import javax.servlet.http.* ;
import java.sql.*;

public class ThirdServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,  IOException 
	{
		//general settings
		res.setContentType( "text/html" ) ;
		PrintWriter pw = res.getWriter( ) ;

		 //Read form3/req3 data
		String city=req.getParameter("city");
		String sal=req.getParameter("sal");

		 //Get Access to HttpSession obj
		HttpSession session = req.getSession(false) ;   

          //read form1/req1 and form2/req2 values from HttpSession obj as session attribute values
		  //  (session tracking)
		String name = (String)session.getAttribute("name");
		String addr = (String)session.getAttribute("Addr");
		String age = (String)session.getAttribute("age");
		String exp = (String)session.getAttribute("exp");
		String skils = (String)session.getAttribute("skils");

		//write all the 3 form values/3 requests values to DB table as record (jdbc code)
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
			PreparedStatement pst=con.prepareStatement("INSERT INTO INFO VALUES(?,?,?,?,?,?,?)");
			pst.setString(1,name);
			pst.setString(2,addr);
			pst.setInt(3,Integer.parseInt(age));
			pst.setString(4,skils);
			pst.setInt(5,Integer.parseInt(exp));
			pst.setString(6,city);
			pst.setInt(7,Integer.parseInt(sal));

			int i = pst.executeUpdate();
			 pw.println("<br><br>session Id"+session.getId());
              //invalidate the Session
			session.invalidate();

			 if(i > 0)
			 {
				pw.println("<BODY BGCOLOR=cyan>");
				pw.println("<CENTER><H1><FONT COLOR=red>Registration Successuful </FONT></H1></CENTER>");

				pw.println("<a href= personal.html>Home</a>");
			 }
			 else
			 {
				pw.println("<BODY BGCOLOR=cyan>");
				pw.println("<CENTER><H1><FONT COLOR=red>Try Again</FONT></H1></CENTER>");
				pw.println("<a href=personal.html>Home</a>");
			  }
			 
			 pw.println("<br><br> Request count:::"+req.getServletContext().getAttribute("ReqCounter"));
				
			
		} // try
		catch(Exception e)
		{
			e.printStackTrace();
			pw.println("<BODY BGCOLOR=cyan>");
			pw.println("<CENTER><H1><FONT COLOR=red>Try Again</FONT></H1></CENTER>");
			pw.println("<a href= personal.html>Home</a>");
		}
	} // doGet(-,-)
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,  IOException 
	{
		doGet(req,res);
	}

} // class