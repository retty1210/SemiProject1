package com.semi.model;

import java.sql.*;
import java.util.*;

import com.db.conn.OracleConnect;

public class JoinDAO {
	
	OracleConnect oc = null;
	
	public JoinDAO() {
		this.oc = new OracleConnect(true);
	}
	
	public boolean insert(JoinDTO dto) {
	String query = "INSERT INTO USER VALUES('"
			+ dto.getId() + "', '"
			+ dto.getPassword() + "', '"
			+ dto.getName() + "', '"
			+ dto.getPhonenumber() + "', '" 
			+ dto.getEmail() + "', '" 
			+ "'";
	
	int res = oc.insert(query);
	
	return res == 1 ? true : false;
	
	}	

	
	public List<JoinDTO> select(String username) {
		String query = "SELECT * FROM WRITER WHERE USERNAME = '" + username + "'";
		ResultSet res = oc.select(query);

		List<JoinDTO> datas = new ArrayList<JoinDTO>();
		try {
			while(res.next()) {
				JoinDTO dto = new JoinDTO();
				dto.setPkId(res.getInt("PKID"));
				dto.setId(res.getString("USERID"));
				dto.setPassword(res.getString("PASSWORD"));
				dto.setName(res.getString("USERNAME"));
				dto.setPhonenumber(res.getString("PHONENUMBER"));
				dto.setEmail(res.getString("EMAIL"));
				dto.setSignDate(res.getDate("SIGNUP"));
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
