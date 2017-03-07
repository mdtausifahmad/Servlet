package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet{
private static final String INSERT_QUERY="INSERT INTO PERSON_TAB VALUES(?,?,?,?,?)";	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,fname=null,ms=null;
		String f2val1=null,f2val2=null;
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		 //general settings		
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form2/req2 data
		f2val1=req.getParameter("f2t1");
		f2val2=req.getParameter("f2t2");
		//read form1/req2 data (Session tracking)
		name=req.getParameter("hname");
		fname=req.getParameter("hfname");
		ms=req.getParameter("hms");
		//write jdbc code to save form1/request1 data
		try{
			//register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create PrpearedStatment object
			ps=con.prepareStatement(INSERT_QUERY);
			ps.setString(1,name);
			ps.setString(2,fname);
			ps.setString(3,ms);
			ps.setString(4,f2val1);
			ps.setString(5,f2val2);
			//execute the Query
			result=ps.executeUpdate();
			//process the reusults
			if(result==0)
				pw.println("<h1> Registrration failed </h1>");
			else
				pw.println("<h1> Registrration success </h1>");
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
		finally{
			//close jdbc objs and streams
			try{
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(con!=null)
					con.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
		
		}//finally
		// display both form1/request1 data on dynamic webpage
		pw.println("<h1>The submitted data </h1>");
		pw.println("<br>Form1/req1 data:::"+name+"...."+fname+"..."+ms);
		pw.println("<br>Form2/req2 data:::"+f2val1+"...."+f2val2);
		//add hypernlink
		pw.println("<a href='details.html'>home</a>");
		//close stream
		pw.close();
		}//doGet(-,-)
	
	@Override
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		   doGet(req,res);
		}//doPost(-,-)
}//class


/*
SQL> create table person_tab(name varchar2(20),fname varchar2(20),
                       ms varchar2(8),f2val1 varchar2(40),f2val2 varchar2(40)); 
*/