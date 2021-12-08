package com.semi.writer.model;

import java.util.*;

public class WriterService {
	
	public boolean insert(WriterDTO dto) {
		WriterDAO dao = new WriterDAO();
		boolean res = dao.insert(dto);
		if(res) {
			dao.commit();
		} else {
			dao.rollback();
		}
		dao.close();
		return res;
	}
	public List<WriterDTO> select(String id){
		WriterDAO wdao = new WriterDAO();
	
		List<WriterDTO> datas = wdao.select(id);
		
		if(datas.size() != 0) {
			return datas;
		}else {
			return null;
		}
		
	}
	
	public List<WriterDTO> selectAll(){
		WriterDAO wdao = new WriterDAO();
	
		List<WriterDTO> datas = wdao.selectAll();
		
		if(datas.size() != 0) {
			return datas;
		}else {
			return wdao.selectAll();
		}
		
	}
	public boolean updateContent(WriterDTO dto) {
		WriterDAO dao = new WriterDAO();
		boolean res = dao.update(dto);
		
		if(res) {
			dao.commit();
			dao.close();
			return true;
		}else {
			dao.rollback();
			dao.close();
			return false;
		}
	}
	
	public List<WriterDTO> select(String userid) {
		WriterDAO wdao = new WriterDAO();
		List<WriterDTO> datas = wdao.select(userid);
		
		if(datas.size() != 0) {
			return datas;
		}else {
			return wdao.select(userid);
		}
	}
	

}
