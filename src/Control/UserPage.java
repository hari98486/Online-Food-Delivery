package Control;

import java.sql.SQLException;
import java.util.Scanner;

import Model.User;
import Service.LogIn;
import Service.SignUp;

public class UserPage 
{
	void user() throws SQLException
	{
		
		System.out.println("Signup -1"+"\nLogin -2");
		Scanner sc1=new Scanner(System.in);
		User user=new User();
		SignUp signup=new SignUp();
		user.setChoice(sc1.nextInt());
		LogIn login=new LogIn();
		switch(user.getChoice())
		{
		case 1:
			System.out.println("-------------------New User--------------------------");
			System.out.println("Kindly Enter your name");
			 user.setName(sc1.next());
			 System.out.println("Enter your Mobile number");
			 user.setPhoneNumber(sc1.next());
			 System.out.println("Enter yoyr city name");
			 user.setCityName(sc1.next());
			 System.out.println("enter your Street name");
			 user.setStreetName(sc1.next());
			 System.out.println("Enter your Door no");
			 user.setDoorNo(sc1.next());
			 System.out.println("Now enter your username");
			 user.setUserName(sc1.next());
			 System.out.println("Now enter your password");
			user.setPassword(sc1.next());
			System.out.println("Hi "+user.getName()+ " welocome to our page");
			signup.register();
			break;
		case 2:	
			System.out.println("Now enter your username");
			 user.setUserName(sc1.next());
			 System.out.println("Now enter your password");
			user.setPassword(sc1.next());
			login.Signin();
		break;
		default:
			System.out.println("invalid input");
		}
	}
}
