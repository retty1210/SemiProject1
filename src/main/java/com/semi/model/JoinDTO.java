package com.semi.model;

public class JoinDTO { // 일단 db는 안 만들었다는 가정하에 카톡으로 다이어그램 만든 것 참조해서 정했습니다.
	private int pkId;		 	// Column Name : PKID
	private String id;		 	// Column Name : USERID
	private String password; 	// Column Name : PASSWORD
	private String name;		// Column Name : USERNAME
	private String phonenumber;	// Column Name : PHONENUMBER
	private String email;		// Column Name : EMAIL
	
	
	public JoinDTO() {
		
	}
	
	public JoinDTO(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public int getPkId() {
		return pkId;
	}

	public void setPkId(int pkId) {
		this.pkId = pkId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean equalsPassword(JoinDTO dto) {
		return this.password.equals(dto.getPassword());
	}
	
}
