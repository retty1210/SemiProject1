package com.semi.model;

import java.sql.*;
import java.util.*;

import com.db.conn.OracleConnect;
import com.semi.writer.model.WriterDTO;

public class SignDAO {
	
	OracleConnect oc = null;
	
	public SignDAO() {
		this.oc = new OracleConnect(true);
	}
	
	String query;
	
	public boolean insert(SignDTO dto) {

		query = "INSERT INTO SIGNUP VALUES("
				+ "SIGNUP_SEQ.NEXTVAL, " 
				+ "'" + dto.getUserid() + "', " 
				+ "'" + dto.getPassword() + "', " 
				+ "'" + dto.getUsername() + "', "
				+ "'" + dto.getPhoneNumber() + "', "
				+ "'" + dto.getEmail() + "', " 
				+ "SYSDATE)";

		
		int res = oc.insert(query);
		if(res == 1) {
			return true;
		}else {
			return false;
		}
		
	}
	public List<SignDTO> select(String userid) {
		query = "SELECT * FROM SIGNUP WHERE USERID = '" + userid + "'";
		ResultSet rs = oc.select(query);
//		System.out.println("signdao select rs:" + rs);
		List<SignDTO> datas = new ArrayList<SignDTO>();
		
		try {
			while(rs.next()) {
				SignDTO dto = new SignDTO();
				dto.setPkid(rs.getInt("PKID"));
				dto.setUserid(rs.getString("USERID"));
				dto.setPassword(rs.getString("PASSWORD"));
				dto.setUsername(rs.getString("USERNAME"));
				dto.setPhoneNumber(rs.getString("PHONENUMBER"));
				dto.setEmail(rs.getString("EMAIL"));
				dto.setSignDate(rs.getDate("SIGNDATE"));
				datas.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}
	public int select_pkid(String id){
		this.query = "SELECT PKID FROM SIGNUP WHERE USERID = '" + id + "'";
		 
		ResultSet res = oc.select(query);
		SignDTO sdto = new SignDTO();
		
		try {
		while(res.next()) {
				sdto.setPkid(res.getInt("PKID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sdto.getPkid();
	}
	public String select_userid(String id){
		this.query = "SELECT USERID FROM SIGNUP WHERE USERID = '" + id + "'";
		 
		ResultSet res = oc.select(query);
		SignDTO sdto = new SignDTO();
		
		try {
		while(res.next()) {
				sdto.setUserid(res.getString("USERID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sdto.getUserid();
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
