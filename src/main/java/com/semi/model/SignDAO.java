package com.semi.model;

import java.sql.*;
import java.util.*;

import com.db.conn.OracleConnect;

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
