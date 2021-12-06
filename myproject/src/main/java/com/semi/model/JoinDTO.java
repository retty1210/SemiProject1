package com.semi.model;


public class JoinDTO {
	private String userID;
	private String userPassword;
	private String userName;
	private String userPhonenum;
	private String userEmail;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhonenum() {
		return userPhonenum;
	}
	public void setUserPhonenum(String userPhonenum) {
		this.userPhonenum = userPhonenum;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public boolean equalsPassword(JoinDTO dto) {
		return this.userPassword.equals(dto.getUserPassword());
	}
}
