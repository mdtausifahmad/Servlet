package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;

public class UploadServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		MultipartFormDataRequest nreq=null;
		UploadBean upb=null;
		Hashtable<String,UploadFile> files=null;
		UploadFile file=null;
		Enumeration e=null;
			//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		try{
		//create Special request obj
		nreq=new MultipartFormDataRequest(req);
		//perform uploading settings
		upb=new UploadBean();
		upb.setFolderstore("c:/store");
		upb.setFilesizelimit(4000);
		upb.setOverwrite(false);
		upb.setMaxfiles(5);
		//complete file upload
		upb.store(nreq);
		//display the names of the uploaded files
		files=nreq.getFiles();
		e=files.elements();
		pw.println("<h1>The files that are uploaed </h1><br>");
		while(e.hasMoreElements()){
			 file=(UploadFile)e.nextElement();
			 pw.println(file.getFileName()+" ------>"+file.getFileSize());
		}
		pw.println("<a href='upload.html'>home</a>");
		}//try
		catch(UploadException upe){
			pw.println("<h1 style='color:red'> File size, files limit is reached</h1>");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}

}//class
