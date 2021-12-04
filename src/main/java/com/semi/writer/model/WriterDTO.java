package com.semi.writer.model;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class WriterDTO {
	private int id;
	private int pkid;
	private String title;
	private String contents;
	private String place;
	private String phonenumber;
	private String photopath;
	private Date writerDate;
	
	
	public Date getWriterDate() {
		return writerDate;
	}

	public void setWriterDate(Date writerDate) {
		this.writerDate = writerDate;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getPkid() {
		return pkid;
	}
	
	public void setPkid(int pkid) {
		this.pkid = pkid;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	public String getPhotopath() {
		return photopath;
	}
	
	public void setPhotopath(String photopath) {
		this.photopath = photopath;

	}
}
