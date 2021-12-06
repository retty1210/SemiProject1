package com.semi.model;

import java.util.List;

public class JoinService {

	public boolean isValid(JoinDTO dto) {
		if(isEmpty(dto.getUserName()) || isEmpty(dto.getUserPassword())
				|| isEmpty(dto.getUserEmail())) {
			return false;
		}
		return true;
	}
	private boolean isEmpty(String str) {
		return str.isEmpty();
	}
	public boolean add(JoinDTO dto) {
		JoinDAO dao = new JoinDAO();
		int count = dao.select(dto.getUserName()).size();
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

	public boolean login(JoinDTO dto) {
		JoinDTO dao = new JoinDTO();
		List<JoinDTO> data = dao.select(dto.getUserID());
		if(data.size() == 1) {
			JoinDTO userData = data.get(0);
			if(dto.equalsPassword(userData)) {
				dto.setUserID(userData.getUserID());
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}