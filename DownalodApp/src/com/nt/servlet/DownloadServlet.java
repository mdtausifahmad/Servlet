package com.nt.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    ServletContext sc=null;
	    File file=null;
	    String path=null;
	    long length=0;
	    String mimeType=null;
	    InputStream is=null;
	    ServletOutputStream sos=null;
	    byte[] buffer=new byte[4096];
	    int bytesRead=0;
		//get ServletContext obj
		sc=getServletContext();
		//get path of file to be downloaded
		path=sc.getRealPath("/james.png");
		//get length of the file and make it as the response content length
		file=new File(path);
		length=file.length();
		res.setContentLengthLong(length);
		//get the MIME type of the file and make it as response MIME type
		mimeType=sc.getMimeType("/james.png");
		res.setContentType(mimeType);
		//set content-disposition response header
		res.setHeader("content-disposition", "attachment;fileName=james.png");
		//create InputStream pointing to the file
		is=sc.getResourceAsStream("/james.png");
		//get OupuitStream pointing to response obj
		sos=res.getOutputStream();
		//write buffer based logic to complete file copy activity(file downloading)
		while((bytesRead=is.read(buffer))!=-1){
			sos.write(buffer,0,bytesRead);
		}//while
		PrintWriter pw=res.getWriter();
		
		//close streams
		is.close();
		sos.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 doGet(req,res);
	}
}//class
