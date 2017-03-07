package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

public class StudentService {
	
	public String register(StudentDTO dto)throws Exception{
		int total=0;
		float avg=0.0f;
		String result=null;
		StudentBO bo=null;
		StudentDAO  dao=null;
		int count=0;
		//write b.logic (cal total,avg,result)
		total=dto.getM1()+dto.getM2()+dto.getM3();
		avg=total/3.0f;
		if(avg<35)
			result="fail";
		else
			result="pass";
		//prepare BO
		bo=new StudentBO();
		bo.setSno(dto.getSno());
		bo.setSname(dto.getSname());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		//use DAO  class
		dao=new StudentDAO();
		count=dao.insert(bo);
		if(count==0)
			return "Registration failed::: Result---->"+result;
		else
			return "Registration succeded:::Reuslt----->"+result;
	}//method
}//class
