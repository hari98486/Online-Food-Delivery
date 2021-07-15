package Control;

import java.sql.SQLException;
import java.util.Scanner;

import BussinessLogic.AdminPage;
import BussinessLogic.UserPage;
import Model.User;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome! to our portal online food delivery");
		System.out.println("If You are admin Press 1");
		System.out.println("If You are user 2");
		User user=new User();
		user.setChoice(sc.nextInt());
		AdminPage adminpage=new AdminPage();
		UserPage userpage=new UserPage();
		
		if(user.getChoice()==1)
		{
			adminpage.admin();
		}
		else if(user.getChoice()==2)
		{
			userpage.user();
		}
		else	
		{
			System.out.println("Invalid Input"+ "\nKindly Enter Valid Input ");
		}
		

	}

}
