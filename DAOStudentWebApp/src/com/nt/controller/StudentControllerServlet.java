package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
import com.nt.vo.StudentVO;

public class StudentControllerServlet extends HttpServlet {
	
@Override
public void doGet(HttpServletRequest req, 
		                        HttpServletResponse res) throws ServletException, IOException {
	String sno=null,sname=null,m1=null,m2=null,m3=null;
	StudentVO  vo=null;
	StudentDTO dto=null;
	StudentService service=null;
	String resultMsg=null;
	PrintWriter pw=null;
	//general settings
	pw=res.getWriter();
	res.setContentType("text/html");
	
	
	//read form data
	sno=req.getParameter("no");
	sname=req.getParameter("name");
	m1=req.getParameter("m1");
	m2=req.getParameter("m2");
	m3=req.getParameter("m3");
	//prepare VO class object having form data
	vo=new StudentVO();
	vo.setSno(sno); vo.setSname(sname); vo.setM1(m1);
	vo.setM2(m2); vo.setM3(m3);
	//convert VO class obj to DTO class obj
	dto=new StudentDTO();
	dto.setSno(Integer.parseInt(vo.getSno()));
	dto.setSname(vo.getSname());
	dto.setM1(Integer.parseInt(vo.getM1()));
	dto.setM2(Integer.parseInt(vo.getM2()));
	dto.setM3(Integer.parseInt(vo.getM3()));
	//use Service class
	 service=new StudentService();
	 try{
	 resultMsg=service.register(dto);
	 }
	 catch(Exception e){
		 pw.println("<h1 style='color:red'>Unique constraint problem</h1>");
		 return;
	 }
	 //display results
	 pw.println("<h1 style='color:red'> "+resultMsg+"</h1>");
	 //add hyperlink
	 pw.println("<a href='input.html'>home</a>");
	 //close stream
	 pw.close();
}//doGet(-,-)

@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  doGet(req,res);
	}//doPost(-,-)
}//class
