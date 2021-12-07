package com.semi.model;

import java.util.*;

public class SignService {

	public boolean isValid(SignDTO dto) {
		if(isEmpty(dto.getUserid()) && isEmpty(dto.getPassword()) && isEmpty(dto.getUsername())
				&& isEmpty(dto.getPhoneNumber()) && isEmpty(dto.getEmail())) {
			return false;
		}
		return true;
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
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
