package com.semi.model;

import java.sql.Date;

public class SignDTO {
	
	private int pkid;
	private String userid;
	private String password;
	private String username;
	private String phoneNumber;
	private String email;
	private Date signDate;
	
	public SignDTO() {}
	
	public SignDTO(String userid, String password, String username, String userphone, String useremail) {
		this.userid = userid;
		this.password = password;
		this.username = username;
		this.phoneNumber = userphone;
		this.email = useremail;
	}
	
	

	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public int getPkid() {
		return pkid;
	}
	public void setPkid(int pkid) {
		this.pkid = pkid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean equalsPassword(SignDTO dto) {
		return this.password.equals(dto.getPassword());
	}
	
}


