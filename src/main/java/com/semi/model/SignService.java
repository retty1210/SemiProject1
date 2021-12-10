package com.semi.model;

import java.sql.*;
import java.util.*;

public class SignService {

	public boolean isValid(SignDTO dto) {
		if(isEmpty(dto.getUserid()) || isEmpty(dto.getPassword()) || isEmpty(dto.getUsername())
				|| isEmpty(dto.getPhoneNumber()) || isEmpty(dto.getEmail())) {
			return false;
		}
		return true;
	}
	
	private boolean isEmpty(String str) {
		// 빈칸인 경우
		return str.isEmpty();
	}
	
	public boolean userAdd(SignDTO dto) {
		SignDAO dao = new SignDAO();
		int count = dao.select(dto.getUserid()).size(); // 동일한 아이디가 몇 개 저장 되어 있는지 확인
		if(count == 0) {
			boolean res = dao.insert(dto); // 동일한 아이디가 없으면 데이터 추가
			if(res) {
				dao.commit();
				dao.close();
				return true;
			} else {
				// 아이디 중복 확인 시 문제가 발생 
				dao.rollback();
				dao.close();
				return false;
			}
		} else {
			// res의 리턴값이 true가 아닌 false 일 경우 
			dao.close();
			return false;
		}
	}
	public List<SignDTO> select(String userid){
		SignDAO dao = new SignDAO();
		List<SignDTO> datas = dao.select(userid);
//		System.out.println("signservice select datas:" + datas);
		
		if(datas.size() == 1) {
			dao.close();
			return datas;			
		}else {
			dao.close();
			return dao.select(userid);
		}
	}
	
	public boolean login(SignDTO dto) {
		SignDAO dao = new SignDAO();
		List<SignDTO> data = dao.select(dto.getUserid());
		if(data.size() == 1) {
			SignDTO userData = data.get(0);
			if(dto.equalsPassword(userData)) {
				dto.setUserid(userData.getUserid());
				dto.setUsername(userData.getUsername());
				dto.setPhoneNumber(userData.getPhoneNumber());
				dto.setEmail(userData.getEmail());
				dto.setSignDate(userData.getSignDate());
				dao.close();
				return true;
			} else {
				dao.close();
				return false;
			}
		} else {
			dao.close();
			return false;
		}
	}
	public int select_pkid(String id){
		SignDAO sDao = new SignDAO();
		int res = sDao.select_pkid(id);
		if(res != 0) {
			sDao.close();
			return res;
		}else {
			sDao.close();
			return 0;
		}
	}
	public String select_userid(String id){
		SignDAO sDao = new SignDAO();
		String res = sDao.select_userid(id);
		if(res != null) {
			sDao.close();
			return res;
		}else {
			sDao.close();
			return null;
		}
	}
}
