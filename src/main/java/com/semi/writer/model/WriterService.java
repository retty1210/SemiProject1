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
	
	
	public List<WriterDTO> selectAll(){
		WriterDAO wdao = new WriterDAO();
	
		List<WriterDTO> datas = wdao.selectAll();
		
		if(datas.size() != 0) {
			return datas;
		}else {
			return null;
		}
		
	}
	

}
