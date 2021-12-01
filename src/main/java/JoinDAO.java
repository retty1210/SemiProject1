import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.conn.OracleConnect;

public class JoinDAO {
	OracleConnect oc = null;
	public JoinDAO() {
		this.oc = new OracleConnect(true);
	}
	
	public boolean insert(JoinDTO dto) {
	String query = "INSERT INTO USER VALUES('"
			+ dto.getUserID() + "', '"
			+ dto.getPassword()  
			+ dto.getUserName() + "', '"
			+ dto.getPhonenum() + "', '" 
			+ dto.getEmail() + "', '" 
			+ "'";
	
	int res = oc.insert(query);
	
	return res == 1 ? true : false;
	}	

	
	public List<JoinDTO> select(String username) {
		String query = "SELECT * FROM ACCOUNTS WHERE USERNAME = '" + username + "'";
		ResultSet res = oc.select(query);

		List<JoinDTO> datas = new ArrayList<JoinDTO>();
		try {
			while(res.next()) {
				JoinDTO dto = new JoinDTO();
				dto.setUserID(res.getString("USERID"));
				dto.setUserName(res.getString("USERNAME"));
				dto.setPassword(res.getString("PASSWORD"));
				dto.setEmail(res.getString("EMAIL"));
				dto.setPhonenum(res.getString("PHONENUMBER"));
				datas.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
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
