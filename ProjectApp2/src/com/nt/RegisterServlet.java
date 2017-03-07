//UplSrv1.java
package com.nt;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadParameters;

public class RegisterServlet extends HttpServlet
{
	public void doPost (HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException
	{
		
		String resumePath="c:/store/resumes";
		String photoPath="c:/store/photoes";
		PrintWriter out = res.getWriter();
		try
			{
           // get special request obj given by Java zoom api
			MultipartFormDataRequest nreq = new MultipartFormDataRequest(req);
		   //read text data from the form page
			int eId=Integer.parseInt(nreq.getParameter("tid"));
			String eName=nreq.getParameter("tname");
			String eAdd=nreq.getParameter("tadd");
			/*String ePhoto=nreq.getParameter("tphoto");  shows Null
			String eResume=nreq.getParameter("tresume"); shows Null */
	
			// settings related to Resume uploading
			UploadBean upb = new UploadBean();
			upb.setFolderstore(resumePath);
			upb.setOverwrite(false);
			upb.store(nreq,"tresume");		// complets files uploding
			
			// setting related photo uploading
			upb.setFolderstore(photoPath);
			upb.setOverwrite(false);
			upb.store(nreq,"tphoto");		// complets files uploding
			
              // get the file names of the uploaded files			
			Vector history = upb.getHistory();
			
			ArrayList <String> fileNames=new ArrayList<String>(); 
			for (int i=0;i<history.size();i++)
			  {
			      UploadParameters up = (UploadParameters) history.elementAt(i);
			      fileNames.add(up.getFilename());
			   
              }
			System.out.println("resume"+fileNames.get(0));
			System.out.println("photo"+fileNames.get(1));
			// store the paths of the uploaded files to c:\store folder
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			PreparedStatement ps=con.prepareStatement("insert into EmployeeReg values(?,?,?,?,?)");
			ps.setInt(1,eId);
			ps.setString(2, eName);
			ps.setString(3, eAdd);
			ps.setString(4,resumePath+"/"+fileNames.get(0));
			ps.setString(5,photoPath+"/"+fileNames.get(1));
			
			int i=ps.executeUpdate();
					if(i==1)
						out.println("<h1>Successfully uploaded and Stored in DataBase</h1>");
			        else
						out.println("<h1>Failed in uploading</h1>");
				out.println("<br> <a href='Home.html'>home</a>");
		        
			}//try
			catch(Exception e)
			{
				out.println(e);
			}//catch
	}//doPost ()
}//class
