package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.bo.BookBO;
import com.nt.dao.BookSearchDAO;
import com.nt.dto.BookDTO;

public class BookSearchService {
	
	public List<BookDTO> search(String category)throws Exception{
		BookSearchDAO dao=null;
		List<BookBO> listBO=null;
		List<BookDTO> listDTO=null;
		BookDTO dto=null;
		//use DAO
		dao=new BookSearchDAO();
		listBO=dao.findBooks(category);
		//Convert ListBO to ListDTO
		listDTO=new ArrayList<BookDTO>();
		for(BookBO bo:listBO){
			//copy Each BO obj to each DTO obj
			dto=new BookDTO();
			dto.setBookId(bo.getBookId());
			dto.setBookName(bo.getBookName());
			dto.setAuthor(bo.getAuthor());
			dto.setCategory(bo.getCategory());
			dto.setStatus(bo.getStatus());
			//add DTO class obj to List collection
			listDTO.add(dto);
		}//for
		
		return listDTO;
	}//method
}//class
