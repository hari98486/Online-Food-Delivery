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
	static ConnectionManager cm=new ConnectionManager();
	static Connection con=null;

	static void admin() throws SQLException
	{
		Scanner sc1=new Scanner(System.in);
		System.out.println("Wecome to admin page"+"\nTO go to login page Press--1");
		System.out.println("To GO BACK ------- ------PRESS 9");
		User user=new User();
		user.setChoice(sc1.nextInt());
		if(user.getChoice()==1)
		{
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
			AdminOperations.operation();
			}
			else
			{
				System.out.println("WRONG Username  AND PASSWORD"+"To Login again ----PRESS---9");
				user.setChoice(sc1.nextInt());
				if(user.getChoice()==9)
				{
					admin();
				}
				
			}
		}
		}
		else if(user.getChoice()==9)
		{
			Main.main(null);
		}
		
		}
		
	}