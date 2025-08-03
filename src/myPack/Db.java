package myPack;
import java.sql.Connection;
import java.sql.DriverManager;
public class Db {
	//Connection reference
	 Connection con;
	//Db constructor
	public Db(){
		try{
			String url="jdbc:mysql://localhost:3306/EmpOperations";//EmpOperations is db-name
			String userName="root";
			String password="Nikhil@123";
			con=DriverManager.getConnection(url,userName,password);
			//System.out.println(" DataBase Connection Successfully ");
			}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed to Connect with Database :"+e.getMessage());
		}
	}
	//Getters for getting connection
	public Connection getConnection()
	{
		return con;
	}
	//Method to close connection
	public void closeConnection()
	{
		try
		{
			if(con !=null && !con.isClosed())
			{
				con.close();
				//System.out.println("Connection is closed");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
