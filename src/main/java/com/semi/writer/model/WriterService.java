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
//		System.out.println("writerservice select datas:" + datas); //테스트용 println
		
		if(datas.size() != 0) {
			wdao.close();
			return datas;
		}else {
			wdao.close();
			return wdao.select(id);
		}
	}
	
	public boolean delete(WriterDTO dto) {
		WriterDAO dao = new WriterDAO();
		boolean res = dao.delete(dto);
		if(res) {
			dao.commit();
		} else {
			dao.rollback();
		}
		dao.close();
		return res;
	}
	
	public List<WriterDTO> selectAll(){
		WriterDAO wdao = new WriterDAO();
	
		List<WriterDTO> datas = wdao.selectAll();
//		System.out.println("writerservice selectAll datas:" + datas); //테스트용 println
		
		if(datas.size() != 0) {
			wdao.close();
			return datas;
		}else {
			wdao.close();
			return wdao.selectAll();
		}
		
	}
	public boolean updateContent(WriterDTO dto) {
		WriterDAO dao = new WriterDAO();
		
		boolean res = dao.update(dto);
		
		if(res) {
			dao.commit();
			dao.close();
		}else {
			dao.rollback();
			dao.close();
		}
		return res;
	}
	
	public List<WriterDTO> select_userid(String userid) {
		WriterDAO wdao = new WriterDAO();
		List<WriterDTO> datas = wdao.select_userid(userid);
		
		if(datas.size() != 0) {
			wdao.close();
			return datas;
		}else {
			wdao.close();
			return wdao.select_userid(userid);
		}
	}
	
}
