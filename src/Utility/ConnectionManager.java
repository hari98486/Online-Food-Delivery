package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	static final String DB_URL="jdbc:mysql://localhost:3306/onlinefooddelivery";
	static final String USER="root";
	static final String PASS="password";
	
	
	public Connection getConnection() throws SQLException {

		Connection con=null;
		con=DriverManager.getConnection(DB_URL,USER,PASS);
		if(con!=null)
			return con;
		else
			return null;
		
	}

}
