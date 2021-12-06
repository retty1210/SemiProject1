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
		String query = "INSERT INTO WRITER VALUES('"
				+ "WRITER_SEQ.NEXTVAL, "
				+ "'" + dto.getPkid() + "', "
				+ "'" + dto.getTitle() + "', "
				+ "'" + dto.getContents() + "', "
				+ "'" + dto.getPlace() + "', "
				+ "'" + dto.getPhonenumber() + "', "
				+ "'" + dto.getPhotopath() + "'" +") "
				+ "'" + dto.getPhotopath() + "'"
				+ "'" + dto.getWriterDate() + "'";
		
	int res = oc.insert(query);
	
	return res == 1 ? true : false;
	}
	
	public List<WriterDTO> myselect(int pkid){
		query = "SELECT ID,SIGNUP.USERID ,TITLE, CONTENTS, PLACE, PHONENUMBER, PHOTOPATH, TO_DATE(SYSTIMESTAMP,'YYYY-MM-DD HH:MI:SS)"
				+ " FROM WRITER JOIN SIGNUP ON WRITER.PKID = JOIN.PKID WHERE PKID = '" + pkid +" ' ";
		
		List<WriterDTO> datas = new ArrayList<WriterDTO>();
		ResultSet res = oc.select(query);
		WriterDTO wdto = new WriterDTO();
		
		try {
			if(res.next()) {
				wdto.setId(res.getInt("ID"));
				wdto.setUserId(res.getString("SIGNUP.USERID"));
				wdto.setContents(res.getString("CONTENTS"));
				wdto.setPlace(res.getString("PLACE"));
				wdto.setPhonenumber(res.getString("PHONENUMBER"));
				wdto.setPhotopath(res.getString("PHOTOPATH"));
				wdto.setWriterDate(res.getDate("WRITERDATE"));
				datas.add(wdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}
	public List<WriterDTO> selectAll(){
		query = "SELECT ID,SIGNUP.USERID ,TITLE, CONTENTS, PLACE, PHONENUMBER, PHOTOPATH, TO_DATE(SYSTIMESTAMP,'YYYY-MM-DD HH:MI:SS)"
				+ " FROM WRITER JOIN SIGNUP ON WRITER.PKID = SIGNUP.PKID";
		
		List<WriterDTO> datas = new ArrayList<WriterDTO>();
		ResultSet res = oc.select(query);
		WriterDTO wdto = new WriterDTO();
		
		try {
			if(res.next()) {
				wdto.setId(res.getInt("ID"));
				wdto.setUserId(res.getString("SIGNUP.USERID"));
				wdto.setContents(res.getString("CONTENTS"));
				wdto.setPlace(res.getString("PLACE"));
				wdto.setPhonenumber(res.getString("PHONENUMBER"));
				wdto.setPhotopath(res.getString("PHOTOPATH"));
				wdto.setWriterDate(res.getDate("WRITERDATE"));
				datas.add(wdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}
	public List<WriterDTO> onePickSelect(int id){
		query = "SELECT ID,SIGNUP.USERID ,TITLE, CONTENTS, PLACE, PHONENUMBER, PHOTOPATH, TO_DATE(SYSTIMESTAMP,'YYYY-MM-DD HH:MI:SS)"
				+ " FROM WRITER JOIN SIGNUP ON WRITER.PKID = SIGNUP.PKID WHERE ID= '" + id + "'";
		
		List<WriterDTO> datas = new ArrayList<WriterDTO>();
		ResultSet res = oc.select(query);
		WriterDTO wdto = new WriterDTO();
		
		try {
			if(res.next()) {
				wdto.setId(res.getInt("ID"));
				wdto.setUserId(res.getString("SIGNUP.USERID"));
				wdto.setContents(res.getString("CONTENTS"));
				wdto.setPlace(res.getString("PLACE"));
				wdto.setPhonenumber(res.getString("PHONENUMBER"));
				wdto.setPhotopath(res.getString("PHOTOPATH"));
				wdto.setWriterDate(res.getDate("WRITERDATE"));
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
