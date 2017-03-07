package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class PoolServlet extends HttpServlet {
	
	private Connection makeConnection(){
		InitialContext ic=null;
		DataSource  ds=null;
		  Connection  con=null;
		try{
			 ic=new InitialContext(); //represent con with jndi registry
			 ds=(DataSource)ic.lookup("java:/comp/env/DsJndi"); //gets DataSoruce obj from jndi registry
			 con=ds.getConnection(); //gets con obj from jdbc con pool
             return con;			 
		}//try
		catch(Exception e){
			return null;
		}
	}//makeConnection
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       PrintWriter pw=null;
       String tabName=null;
       Connection con=null;
       Statement st=null;
       ResultSet rs=null;
       ResultSetMetaData rsmd=null;
       int colCount=0;
       
		//general settings
       pw=res.getWriter();
       res.setContentType("text/html");
      //read form data
       tabName=req.getParameter("table");
       //write jdbc code
       //get con obj from jdbc con pool
       con=makeConnection();
       try{
       //create stateent obj
       st=con.createStatement();
       //send and execute SQL Query in Db s/w
       rs=st.executeQuery("select * from "+tabName);
       //process the ResultSet
       //print col names
       rsmd=rs.getMetaData();
       colCount=rsmd.getColumnCount();
       //Display col names
       pw.println("<table border='1'>");
       pw.println("<tr>");
       for(int i=1;i<=colCount;++i){
    	   pw.println("<th>"+rsmd.getColumnLabel(i)+"</th>");
       }
       pw.println("</tr>");
       //display col values
       while(rs.next()){
    	   pw.println("<tr>");
    	   for(int i=1;i<=colCount;++i){
    		   pw.println("<td>"+rs.getString(i)+"</td>");
    	   }//for
    	   pw.println("</tr>");
       }//while
       pw.println("</table>");
       pw.println("<br><a href='index.html'>View another table</a>");
         //return jdbc con obj back to con pool
         con.close();
       }//try
       catch(Exception  e){
    	pw.println("<b><i> Table does not exist</i></b>");
    	pw.println("<br><a href='index.html'>Try Again</a>");
       }
       
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)

}//class
