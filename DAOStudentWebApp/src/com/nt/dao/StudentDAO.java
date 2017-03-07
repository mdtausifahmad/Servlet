package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.nt.bo.StudentBO;

public class StudentDAO {
	private static final String  INSERT_STUDENT_QUERY="INSERT INTO DAO_STUDENT VALUES(?,?,?,?,?)";
	
	public Connection getConnection()throws Exception{
		Connection con=null;
		InitialContext ic=null;
		DataSource ds=null;
	     //create InitialContext obj
			ic=new InitialContext();
		 //get DataSource obj ref from jndi registry
			ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
			//get Connection obj from jdbc con pool
			con=ds.getConnection();
		return con;
	}//method
	
	public int  insert(StudentBO bo)throws Exception{
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//get jdbc con obj from jdbc con pool
		con=getConnection();
		// perform insert operation(jdbc code)
		ps=con.prepareStatement(INSERT_STUDENT_QUERY);
		//set values to Query params
		ps.setInt(1,bo.getSno());
		ps.setString(2,bo.getSname());
		ps.setInt(3, bo.getTotal());
		ps.setFloat(4,bo.getAvg());
		ps.setString(5,bo.getResult());
		//execute  Query
		result=ps.executeUpdate();
		
		return result;
	}//method
	
}//class
