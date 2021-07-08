package Control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import Model.User;
import Utility.ConnectionManager;

public class foodstore
{
	ConnectionManager cm=new ConnectionManager();
	Connection con=null;
	public void foodmaterial() throws SQLException
	{
		Scanner sc1=new Scanner(System.in);
		User user=new User();
		con =cm.getConnection();
		Statement st=con.createStatement();
		System.out.println("To order food material and tracking---PRESS 1"+"\nSee your profile details-----PRESS 2");
		int Choose=sc1.nextInt();
		ResultSet rs1=st.executeQuery("select name,Username,Password from userdata");
		switch(Choose)
		{
		case 1:
			System.out.println("-----------------Available items---------");
			System.out.println("1.Pasta----------------- 500rs ----- 1kg\r\n"
					+ "2.Rice------------------ 300rs ----- 1KG\r\n"
					+ "3.Bread----------------- 400rs ----- 1kg\r\n");
			break;
		case 2:
			System.out.println("To see InFo about u------PRESS 1");
			System.out.println("To change password ------PRESS 2");
			user.setChoice(sc1.nextInt());
			switch(user.getChoice())
			{
			case 1:
				while(rs1.next())
				{
		        System.out.println("----------------THIS IS YOUR PROFILE----------------");
				//System.out.println("Your name is --- "+rs1.getString(name)+" "\nYour Username is --- "+rs1.getString(Username)+);
				}
				break;
			case 2:	
			System.out.println("Enter your old to change password");
			user.setPassword(sc1.next());
			while(rs1.next())
			{
			if(rs1.getString("Password").equals(user.getPassword()))
			{
				System.out.println("Enter your NEW password");
				String password=sc1.next();
				String updatepassword="update userdata Set Password ='" +password+"' where Username='mani123'";
				st.executeUpdate(updatepassword);
			    System.out.println("Your password had been updated successfully");
			}
			else
		      System.out.println("Password not match with old password");
			}
			}
		}

	}

}
