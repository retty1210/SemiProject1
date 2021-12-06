package com.semi.writer.model;

import java.util.*;

public class WriterService {
	
	public List<WriterDTO> onePickSelect(int id){
		WriterDAO wdao = new WriterDAO();
		
		return wdao.onePickSelect(id);
	}

}
