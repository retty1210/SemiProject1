package com.semi.writer.model;
import java.sql.*;
import java.util.*;

import com.db.conn.OracleConnect;
import com.semi.model.SignDTO;

public class WriterDAO {
	OracleConnect oc = null;
	String query;
	
	public WriterDAO() {
		this.oc = new OracleConnect(true);
	}
	
	public boolean insert(WriterDTO dto) {
				query = "INSERT INTO WRITER VALUES("
				+ "WRITER_SEQ.NEXTVAL, "
				+ "'" + dto.getPkid() + "', "
				+ "'" + dto.getTitle() + "', "
				+ "'" + dto.getContents() + "', "
				+ "'" + dto.getPlace() + "', "
				+ "'" + dto.getPhonenumber() + "', "
				+ "'" + dto.getPhotopath() + "', "
				+ "'" + dto.getWriterDate() + "')";
		
	int res = oc.insert(query);
	
	return res == 1 ? true : false;
	}
	
	public boolean delete(WriterDTO dto) {
		query = "DELETE FROM WRITER"
				+ "WHERE ID = '" + dto.getId() + "'";
		
		int res = oc.insert(query);
		
		return res == 1 ? true : false;
	}
	
	public List<WriterDTO> selectAll(){
		query = "SELECT * FROM WRITER";
		
		List<WriterDTO> datas = new ArrayList<WriterDTO>();
		ResultSet res = oc.select(query);
		
		try {
			while(res.next()) {
				WriterDTO wdto = new WriterDTO();
				wdto.setId(res.getInt("ID"));
				wdto.setPkid(res.getInt("PKID"));
				wdto.setTitle(res.getString("TITLE"));
				wdto.setContents(res.getString("CONTENTS"));
				wdto.setPlace(res.getString("PLACE"));
				wdto.setPhonenumber(res.getString("PHONENUMBER"));
				wdto.setPhotopath(res.getString("PHOTOPATH"));
				wdto.setWriterDate(res.getString("WRITERDATE"));
				datas.add(wdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}
	
	
	public void commit() {
		oc.commit();
	}
	
	public void rollback() {
		oc.rollback();
	}
	
	public void close() {
		oc.close();
		
	}
}
