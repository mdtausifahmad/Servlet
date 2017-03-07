package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.BookBO;

public class BookSearchDAO {
	private static final String GET_BOOKS_BY_QUERY="SELECT BOOKID,BOOKNAME,AUTHOR,STATUS,CATEGORY FROM BOOK_DETAILS1  WHERE CATEGORY=?";
	private Connection  getConnection()throws Exception{
		Connection con=null;
		InitialContext ic=null;
		DataSource ds=null;
		//get PooledConnection obj
		ic=new InitialContext();
		ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
		con=ds.getConnection();
		return con;
	}//getConnection()
	
	public List<BookBO>  findBooks(String category)throws Exception
	{  Connection con=null;
	    PreparedStatement ps=null;
	    ResultSet rs=null;
	    List<BookBO> listBO=null;
	    BookBO  bo=null;
		//get Connection form conn pool
	    con=getConnection();
	    //create PreparedStatement obj
	    ps=con.prepareStatement(GET_BOOKS_BY_QUERY);
	    //set param values
	    ps.setString(1,category);
	    //excute the Query
		rs=ps.executeQuery();
		//copy ReultSet obj records ListBO
		listBO=new ArrayList<BookBO>();
		while(rs.next()){
			//copy record fo RS to BO class obj
			bo=new BookBO();
			bo.setBookId(rs.getInt(1));
			bo.setBookName(rs.getString(2));
			bo.setAuthor(rs.getString(3));
			bo.setStatus(rs.getString(4));
			bo.setCategory(rs.getString(5));
			//add BookBO objs to ListBO
			listBO.add(bo);
		}//while
		return listBO;
	}//method
}//class
