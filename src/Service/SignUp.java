package Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Model.User;
import Utility.ConnectionManager;

public class SignUp {
	ConnectionManager cm=new ConnectionManager();
	Connection con=null;
	public void register() throws SQLException
	{
		
		Scanner sc1=new Scanner(System.in);
		User user=new User();
		con =cm.getConnection();
		Statement st=con.createStatement();
		String insert_value="Insert INTO USERDATA VALUES('"+ user.getName()+"','"+user.getEmail()+ "','"+user.getPhoneNumber()+"','"+user.getUserName()+"','"+user.getPassword()+"','"+user.getCityName()+"','"+user.getStreetName()+"','"+user.getDoorNo()+"')";
		st.executeUpdate(insert_value);
		System.out.println("Hi "+user.getName()+" Your account had created successfully");
		System.out.println("If you want to login now---Press 3 ");
		user.setChoice(sc1.nextInt());
		if(user.getChoice()==3)
		{
			LogIn.Signin();
		}
		else
		{
			System.out.println("Invalid input");	
		}
		
	}

}
