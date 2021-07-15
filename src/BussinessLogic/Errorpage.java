package BussinessLogic;

import java.sql.SQLException;
import java.util.Scanner;

import Model.User;

public class Errorpage {
	void error() throws SQLException
	{
		User users =new User();
		UserPage userpage=new UserPage();
		Scanner sc1=new Scanner(System.in);
		System.out.println("You Did n't enter the data");
		System.out.println("PLEASE ENTER THE DATA");
		System.out.println("To attempt SIGNUP Again---Press---9");
		users.setChoice(sc1.nextInt());
		if(users.getChoice()==9)
		{
			userpage.user();
		}
	}
}
