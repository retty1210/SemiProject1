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
		String query = "INSERT INTO WRITER VALUES("
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
	public List<WriterDTO> select(String id){
		query = "SELECT * FROM WRITER WHERE ID = '" +id +"'";
		
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
	public boolean update(WriterDTO dto) {
		query = "UPDATE WRITER SET TITLE = '" + dto.getTitle() + "', CONTENTS ='" + dto.getContents() + "', PLACE = '" + dto.getPlace() +"',"
				+"PHONENUMBER = '" + dto.getPhonenumber() + "' WHERE ID ='" + dto.getId() +"'";
		
		int res = oc.update(query);
		if(res == 1) {
			return true;
		}else {
			return false;
		}
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
