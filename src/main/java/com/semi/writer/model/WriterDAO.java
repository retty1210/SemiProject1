package com.semi.writer.model;
import com.db.conn.OracleConnect;

public class WriterDAO {
	OracleConnect oc = null;
	
	public WriterDAO() {
		this.oc = new OracleConnect(true);
	}
	
	public boolean insert(WriterDTO dto) {
		String query = "INSERT INTO WRITER VALUES("
				+ "WRITER_SEQ.NEXTVAL, "
				+ "'" + dto.getPkid() + "', "
				+ "'" + dto.getTitle() + "', "
				+ "'" + dto.getContents() + "', "
				+ "'" + dto.getPlace() + "', "
				+ "'" + dto.getPhonenumber() + "', "
				+ "'" + dto.getPhotopath() + "'";
		
	int res = oc.insert(query);
	
	return res == 1 ? true : false;
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
