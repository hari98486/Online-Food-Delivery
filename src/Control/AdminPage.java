package Control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Model.User;
import Utility.ConnectionManager;

public class AdminPage 
{
	ConnectionManager cm=new ConnectionManager();
	Connection con=null;

	void admin() throws SQLException
	{
		Scanner sc1=new Scanner(System.in);
		System.out.println("Wecome to admin page"+"\nPlease Enter login details");
		User user=new User();
		System.out.println("Enter your username");
		 user.setUserName(sc1.next());
		 System.out.println("Now enter your password");
		user.setPassword(sc1.next());
		con =cm.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select username,pass from admin");
		while(rs.next())
		{
			if(rs.getString("username").equals(user.getUserName())?rs.getString("pass").equals(user.getPassword())?true:false:false)
			{
			System.out.println("Successfully logged in");
			}
		}
		System.out.println("------------------HELLO! ADMIN------YOU CAN DO ANYTHING  WITH USERDATABSE----------------------------");
		System.out.println("1.TO delete the database of user"+"\n2.TO see full info about user"+"\n3.To know the count of customers using this online food protal");
	}
}