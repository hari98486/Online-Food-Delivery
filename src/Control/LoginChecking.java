package Control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Model.User;
import Utility.ConnectionManager;

public class LoginChecking 
{	
	public static boolean Checking() throws SQLException {
		// TODO Auto-generated method stub
		ConnectionManager cm=new ConnectionManager();
		Connection con=null;
		Scanner sc1=new Scanner(System.in);
		User user=new User();
		System.out.println("Now enter your username");
		 user.setUserName(sc1.next());
		 System.out.println("Now enter your password");
		user.setPassword(sc1.next());
		con =cm.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select name,Username, Password from userdata");
		while(rs.next())
		{
			if(rs.getString("Username").equals(user.getUserName())?rs.getString("Password").equals(user.getPassword())?true:false:false)
			{
			System.out.println("Yaahhhhh Your credentials are Matched  -------" +rs.getString("name"));
			return true;
			}
		}
		return false;
		
	}

}