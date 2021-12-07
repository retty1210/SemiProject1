package com.semi.model;

import java.sql.*;
import java.util.*;

public class SignService {

	public boolean isValid(SignDTO dto) {
		// 회원가입 시 모든 내용이 작성 해야 한다
		// 다른 유효성 검사 로직에 대해 생각해서 추가하기
		if(isEmpty(dto.getUserid()) && isEmpty(dto.getPassword()) && isEmpty(dto.getUsername())
				&& isEmpty(dto.getPhoneNumber()) && isEmpty(dto.getEmail())) {
			return true;
		}
		return false;
	}
	
	private boolean isEmpty(String str) {
		// 비워있는지 확인
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
			return false;
		}
	}
	public List<SignDTO> select(String userid){
		SignDAO dao = new SignDAO();
		List<SignDTO> datas = dao.select(userid);
		
		if(datas.size() == 1) {
			return datas;			
		}else {
			return null;
		}
	}
	
	public boolean login(SignDTO dto) {
		SignDAO dao = new SignDAO();
		List<SignDTO> data = dao.select(dto.getUserid());
		if(data.size() == 1) {
			SignDTO userData = data.get(0);
			if(dto.equalsPassword(userData)) {
				dto.setUserid(userData.getUserid());
				dto.setPassword("");
				dto.setUsername(userData.getUsername());
				dto.setPhoneNumber(userData.getPhoneNumber());
				dto.setEmail(userData.getEmail());
				dto.setSignDate(userData.getSignDate());
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
