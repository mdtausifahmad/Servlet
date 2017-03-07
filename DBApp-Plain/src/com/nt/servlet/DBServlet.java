//DBServlet.java
package com.nt.servlet;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class DBServlet extends HttpServlet
{  private static final String QUERY="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private Connection con;
   private PreparedStatement ps;
	public void init(){
		ServletContext sc=null;
		String driver=null,url=null,dbuser=null,dbpwd=null;
		
		try{
			
			//get Access to ServletContext obj
			sc=getServletContext();
			//read init param values
			driver=sc.getInitParameter("driver");
			url=sc.getInitParameter("url");
			dbuser=sc.getInitParameter("dbuser");
			dbpwd=sc.getInitParameter("dbpwd");
			//register jdbc driver s/w
			Class.forName(driver);
			//estblish the connection
			con=DriverManager.getConnection(url,dbuser,dbpwd);
			//create PreparedStatement obj
			ps=con.prepareStatement(QUERY);
			
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}//init()
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{	 PrintWriter pw=null;
	     int no=0;
		 ResultSet rs=null;
		//general settings
         pw=res.getWriter();
         res.setContentType("text/html");
		 //read form data
        no=Integer.parseInt(req.getParameter("empno"));
		try{
		//set value to query param
		ps.setInt(1,no);
		//execute the Query
		rs=ps.executeQuery();
		//prcoss the ReusltSet
		if(rs.next()){
			pw.println("<h1><center> Emp Details </center></h1>");
			pw.println("<br>Emp no:"+rs.getInt(1));
			pw.println("<br>Emp name:"+rs.getString(2));
			pw.println("<br>Emp JOB:"+rs.getString(3));
            pw.println("<br>Emp Salary:"+rs.getInt(4));
		}//if
		else{
           	pw.println("<h1><center> Emp not Found </center></h1>");
		}
		//close ResultSet 
		rs.close();
		//add hyperlink
		pw.println("<br><a href='input.html'>home</a>");
		//close stream
		pw.close();
	}//try
	catch(SQLException se){
		se.printStackTrace();
	}
	catch(Exception e){
		 e.printStackTrace();
	}
  }//doGet(-,-)

  public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{	 
	  doGet(req,res);
	}

	public void destroy(){
       try{
		   ps.close();
	   }
	   catch(SQLException se){
		   se.printStackTrace();
	   }
         try{
		   con.close();
	   }
	   catch(Exception e){
		   e.printStackTrace();
	   }
	}//destroy
}//class