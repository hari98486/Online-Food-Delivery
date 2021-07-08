package Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Control.foodstore;
import Model.User;
import Utility.ConnectionManager;

public class LogIn 
{
	ConnectionManager cm=new ConnectionManager();
	Connection con=null;
	public void Signin() throws SQLException
	{
		Scanner sc1=new Scanner(System.in);
		User user=new User();
		con =cm.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select name,Username, Password from userdata");
		while(rs.next())
		{
			if(rs.getString("Username").equals(user.getUserName())?rs.getString("Password").equals(user.getPassword())?true:false:false)
			{
			System.out.println("Successfully logged in" +rs.getString("name"));
			foodstore store=new foodstore();
			store.foodmaterial();
			}
		}
	}
}
