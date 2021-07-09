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
	static ConnectionManager cm=new ConnectionManager();
	static Connection con=null;
	public static void foodmaterial() throws SQLException
	{
		Scanner sc1=new Scanner(System.in);
		User user=new User();
		con =cm.getConnection();
		Statement st=con.createStatement();
		System.out.println("-----------This is Main page------------");
		System.out.println("To order food material and tracking---PRESS 1"+"\nSee your profile details-----PRESS 2");
		int Choose=sc1.nextInt();
		ResultSet rs1=st.executeQuery("select name,Username,Password from userdata");
		switch(Choose)
		{
		case 1:
			Shopping.shop();
			break;
		case 2:
			System.out.println("To see InFo about u------PRESS 1");
			System.out.println("To change password ------PRESS 2");
			System.out.println("To GO BACK ------- ------PRESS 9");
			user.setChoice(sc1.nextInt());
			switch(user.getChoice())
			{
			case 1:
				while(rs1.next())
				{
					if(rs1.getString("Username").equals(user.getUserName()))
					{
		        System.out.println("----------------THIS IS YOUR PROFILE----------------");
				System.out.println("Your name is --- "+rs1.getString("name")+" "+"\nYour Username is --- "+rs1.getString("Username"));
				System.out.println("To GO BACK ------- ------PRESS 9");
				user.setChoice(sc1.nextInt());
				if(user.getChoice()==9)
				{
					foodmaterial();
				}
				}
				}
				break;
			case 2:	
			LoginChecking.Checking();
			System.out.println("-----Enter Your New Password--------");
			user.setPassword(sc1.next());
			String updatepassword="update userdata Set Password ='" +user.getPassword()+"' where Username='+user.getUserName()'";
			st.executeUpdate(updatepassword);
			System.out.println("Your password had been updated successfully");
			break;
			case 9:
				foodmaterial();
				break;
				default:
					System.out.println("Invalid Input");
					foodmaterial();
			}
		}

	}

}
