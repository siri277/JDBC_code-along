package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {

	public boolean validate(LoginPojo loginpojo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String username = loginpojo.getUsername();
		String password = loginpojo.getPassword();
		
		ConnectionManager con = new ConnectionManager();
		Statement st = con.getConnection().createStatement();
		ResultSet rs =st.executeQuery("SELECT * from USERDETAILS");
		while(rs.next())
		{
			if(username.equals(rs.getString("USERNAME")) && password.equals(rs.getString("PASSWORD"))) {
				con.getConnection().close();
				return true;
			}
			else {
				con.getConnection().close();
				return true;
			}
		}
		return false;
	}

}
