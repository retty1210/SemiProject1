package com.semi.model;

import java.util.List;

public class JoinService {
	public boolean isValid(JoinDTO dto) {
		if(isEmpty(dto.getId()) || isEmpty(dto.getPassword())
				|| isEmpty(dto.getEmail())) {		
			return false;
		}
		return true;
	}

	private boolean isEmpty(String str) {
		return str.isEmpty();
	}

	public boolean add(JoinDTO dto) { // 중복체크 메서드입니다. (에러 뜨는 건 dao 연결 안되서일거에요.)
		JoinDAO dao = new JoinDAO();
		int count = dao.select(dto.getId()).size();
		if(count == 0) {
			boolean res = dao.insert(dto);
			if(res) {
				dao.commit();
				dao.close();
				return true;
			} else {
				dao.rollback();
				dao.close();
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean login(JoinDTO dto) { // 로그인 위해 일치작업 메서드입니다.
		JoinDAO dao = new JoinDAO();
		List<JoinDTO> data = dao.select(dto.getId());
		if(data.size() == 1) {
			JoinDTO userData = data.get(0);
			if(dto.equalsPassword(userData)) {
				dto.setId(userData.getId());
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
