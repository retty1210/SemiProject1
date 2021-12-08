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
<<<<<<< HEAD
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
=======
			return null;
		}
		
>>>>>>> branch 'main' of git@SemiProject1.github.com:retty1210/SemiProject1.git
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
<<<<<<< HEAD
	
	public List<WriterDTO> select_userid(String userid) {
		WriterDAO wdao = new WriterDAO();
		List<WriterDTO> datas = wdao.select_userid(userid);
		
		if(datas.size() != 0) {
			return datas;
		}else {
			return wdao.select_userid(userid);
		}
	}
=======
>>>>>>> branch 'main' of git@SemiProject1.github.com:retty1210/SemiProject1.git
	

}
