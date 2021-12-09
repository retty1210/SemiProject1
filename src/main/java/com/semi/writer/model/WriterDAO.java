package com.semi.writer.model;
import java.sql.*;
import java.util.*;

import com.db.conn.OracleConnect;
import com.semi.model.*;

public class WriterDAO {
	OracleConnect oc = null;
	String query = "";
	ResultSet res = null;
	int rs = 0;
	
	public WriterDAO() {
		this.oc = new OracleConnect(true);
	}
	
<<<<<<< HEAD
	public boolean insert(WriterDTO dto) {
			this.query = "INSERT INTO WRITER VALUES("
=======
	public boolean insert(WriterDTO dto) { 
				query = "INSERT INTO WRITER VALUES("
>>>>>>> refs/remotes/origin/조정현
				+ "WRITER_SEQ.NEXTVAL, "
				+ "'" + dto.getPkid() + "', "
				+ "'" + dto.getTitle() + "', "
				+ "'" + dto.getContents() + "', "
				+ "'" + dto.getPlace() + "', "
				+ "'" + dto.getPhonenumber() + "', "
				+ "'" + dto.getPhotopath() + "', "
				+ "SYSDATE)";
		
<<<<<<< HEAD
	this.rs = oc.insert(query);
=======
			int res = oc.insert(query);
>>>>>>> refs/remotes/origin/조정현
	
<<<<<<< HEAD
	return this.rs == 1 ? true : false;
=======
			return res == 1 ? true : false;
>>>>>>> refs/remotes/origin/조정현
	}
	
<<<<<<< HEAD
	public List<WriterDTO> select(String id){
		this.query = "SELECT * FROM WRITER WHERE ID = '" + id + "'";
		System.out.println("writerdao select:" + query); //테스트용 println : 나중에 제출할때 지우기
=======
	public List<WriterDTO> select(String id){ 
		query = "SELECT * FROM WRITER WHERE ID = '" +id +"'";
>>>>>>> refs/remotes/origin/조정현
		
		List<WriterDTO> datas = new ArrayList<WriterDTO>();
		this.res = oc.select(query);
		System.out.println("writerdao res:" +res); //테스트용 println : 나중에 제출할때 지우기
		
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
	
	public boolean delete(WriterDTO dto) {
		this.query = "DELETE FROM WRITER"
				+ "WHERE ID = '" + dto.getId() + "'";
		
		this.rs = oc.delete(query);
		
		return this.rs == 1 ? true : false;
	}

	public List<WriterDTO> selectAll(){
		this.query = "SELECT * FROM WRITER";
		List<WriterDTO> datas = new ArrayList<WriterDTO>();
		this.res = oc.select(query);
		System.out.println("writerdao select all res:" + res); //테스트용 println : 제출 전엔 삭제해주세요
		
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
			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}
	
	public boolean update(WriterDTO dto) {
		this.query = "UPDATE WRITER SET TITLE = '" + dto.getTitle() + "', CONTENTS ='" + dto.getContents() + "', PLACE = '" + dto.getPlace() +"',"
				+"PHONENUMBER = '" + dto.getPhonenumber() + "' WHERE ID ='" + dto.getId() +"'";
		
		this.rs = oc.update(query);
		if(rs == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	//내 정보->본인이 쓴 게시글 확인하는 로직에 있는 select 메서드 다 select_userid로 바꿔주세요
	public List<WriterDTO> select_userid(String userid){
		SignDAO sdao = new SignDAO();
		List<SignDTO> sdto = sdao.select(userid);
		int pk = 0;
		if(sdto.size() == 1) {
			for(SignDTO sdata: sdto) {
				pk = sdata.getPkid();
			}
		}
		
		this.query = "SELECT * FROM(SELECT * FROM WRITER WHERE PKID = '"+userid+"' ORDER BY ID) WHERE ROWNUM <= 6";
		
		this.res = oc.select(query);
		
		List<WriterDTO> datas = new ArrayList<WriterDTO>();
		
		try {
			while(this.res.next()) {
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
