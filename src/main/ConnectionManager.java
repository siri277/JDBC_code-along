package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		//Register the driver class
		Class.forName("oracle.jdbc.OracleDriver");
		
		//create the connection object
		Connection con = null;
		con = DriverManager. getConnection("jdbc:Oracle:thin:@localhost:1521:xe","SYSTEM","siri1703");
		
		if(con != null) {
			System.out.println("Established");
		}
		return con;
	}
}
