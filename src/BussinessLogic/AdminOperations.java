package BussinessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Model.User;
import Utility.ConnectionManager;

public class AdminOperations {
	static ConnectionManager cm=new ConnectionManager();
	static Connection con=null;
	static String sql;
	static Scanner sc1=new Scanner(System.in);
	public static void operation() throws SQLException {
		con =cm.getConnection();
		String delete,userdelete,userdetails;
		User user =new User();
		Statement st=con.createStatement();
		System.out.println("Successfully logged in");
		System.out.println("------------------HELLO! ADMIN------YOU CAN DO ANYTHING  WITH USERDATABSE----------------------------");
		System.out.println("1.TO delete the database of user"+"\n2.TO see full info about user include username and passwword also"+"\n3.To know the count of customers using this online food protal");
		User.setChoice(sc1.nextInt());
		switch(User.getChoice())
		{
		case 1:
			System.out.println("Enter username you want to delete WHOSE WHO DONT HAVE ORDERS");
			userdelete=sc1.next();
//			ResultSet result = st.executeQuery("SELECT Username FROM itemlist");
//			while (result.next())
//			{
//			    if(userdelete.equals(result.getString("Username")))
//			    {
//			    	System.out.println("User had products in his cart i.e user avilable in itemlist table ");
//			    }
//			String check1 = "SELECT Username FROM userdata";
//			ResultSet result1 = st.executeQuery(check1);
//			    while (result1.next())
//			    {
//			    	String username1 = result.getString("Username");
//			    if(userdelete.equals(username1))
//			    {
//			    	System.out.println("User dont hae products in cart , SO DELETING THE USER ");
					sql = "Delete from userdata where  Username=?";
					PreparedStatement statement = con.prepareStatement(sql);
					statement.setString(1, userdelete);
					statement.executeUpdate();
					System.out.println("Deleted data from user table");
					adminbackoperation();
//			    }
			break;
		case 2:
			System.out.println("----here is the full table info--------");
			ResultSet rs=st.executeQuery("select name,phonenumber,Username,Password,CityName,Streetname,door_no from userdata");
			while(rs.next())
			{
				System.out.println("NAME :" +rs.getString("name"));
				System.out.println("USERNAME :" +rs.getString("Username"));
				System.out.println("PASSWORD :" +rs.getString("Password"));
				System.out.println("CITY NAME :" +rs.getString("CityName"));
			}
			adminbackoperation();
			break;
		case 3:
			System.out.println("----here is the Count of records in user table--------");
			ResultSet rs1=st.executeQuery("select count(*) from userdata");
			rs1.next();
			int no_ofrecords=rs1.getInt(1);
			System.out.println(no_ofrecords+"Records are Available Here");
			adminbackoperation();
			break;
			default:
				System.out.println("WRONG INPUT"+"\npls try again");
				adminbackoperation();
		}	
	}
	static void adminbackoperation() throws SQLException
	{System.out.println("To GO BACK ------- ------PRESS 9");
		
		User.setChoice(sc1.nextInt());
		if(User.getChoice()==9)
		{
			operation();
		}
		else
		{
			System.out.println("INVALID INPUT");
		}
	}
	}
