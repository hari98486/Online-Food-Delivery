package BussinessLogic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Model.User;
import Utility.ConnectionManager;

public class Shopping {
	static ConnectionManager cm=new ConnectionManager();
	static Connection con=null;
	public static void shop() throws SQLException
	{
		Scanner sc1=new Scanner(System.in);
		String Itemname;
		int Itemprice,itemquantity,totalprice=0;
		char item;
		con =cm.getConnection();
		Statement st=con.createStatement();
		System.out.println("press 1 to do shoping"+"\npress 2 view cart "+"\nPress 9 to go back to previous page"+"\nPress 0 to exit");
		User.setChoice(sc1.nextInt());
		User user=new User();
		if(User.getChoice()==1)
		{
			do
			{
				int i=1;
			System.out.println("Enter name of item:");
			Itemname=sc1.next();
			System.out.println("Price of item");
			Itemprice=sc1.nextInt();
			System.out.println("Enter Quantity of item:");
			itemquantity=sc1.nextInt();
			totalprice=totalprice+(itemquantity*Itemprice);
			String insert_value="Insert INTO itemlist VALUES('"+ user.getUserName()+"','"+Itemname+ "','"+Itemprice+"','"+itemquantity+"','"+totalprice+"')";
			st.executeUpdate(insert_value);
			System.out.println(" Your have added to product to your cart");
			System.out.println("To continue Shopping-Y/N");
			i++;
			item=sc1.next().charAt(0);
			}
			while(item=='y' || item=='Y');
		}
		else if(User.getChoice()==2)
		{
			String sql="select Username,item1,item1price,item1quantity,totalprice from itemlist where Username= '"+user.getUserName()+"' ";
			ResultSet rs=st.executeQuery(sql);
			int totalbill=0;
			while(rs.next())
			{
				System.out.println("ITEM " +rs.getString("item1"));
				System.out.println("ITEM -PRICE:"+rs.getInt("item1price"));
				System.out.println("ITEM -QUANTITY:"+rs.getInt("item1quantity"));
				System.out.println("TOTAL PRICE :" +rs.getInt("totalprice"));
				totalbill=totalbill+rs.getInt("totalprice");	
				}
			System.out.println("TOTAL BILL----------------"+totalbill);
		}
		else if(User.getChoice()==9)
		{
			foodstore.foodmaterial();
		}
		else if(User.getChoice()==0)
		{
			System.exit(0);
		}
		else
		{
			System.out.println("Invalid Input");
			shop();
		}
		
	}

}
