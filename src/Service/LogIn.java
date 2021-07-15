package Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import BussinessLogic.foodstore;
import Model.User;
import Utility.ConnectionManager;

public class LogIn 
{
	public static void Signin() throws SQLException
	{
			System.out.println("---------------Successfully logged in-----------");
			foodstore store=new foodstore();
			store.foodmaterial();
	}
}