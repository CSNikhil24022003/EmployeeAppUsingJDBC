package myPack;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmpDAO {
	//DAO :- Data Access Object 
	public void insertEmployee(Employee emp)  {
		//Creating db connection 
		Db db=new Db();
		Connection con=db.getConnection();
		try
		{
			//Prepared Statement with Query-class insert-Data
			PreparedStatement pstm=con.prepareStatement(Query.insertData);
			//setting values
			pstm.setInt(1,emp.getEid());
			pstm.setString(2,emp.getEname());
			pstm.setString(3, emp.getEmailid());
			pstm.setLong(4, emp.getPhno());
			//Execute and check results
			int rows=pstm.executeUpdate();
			if(rows>0)
			{
				System.out.println("Data Inserted Successfully");
			}
			else
			{
				System.out.println("Insertion Failed");
			}
		}catch(Exception e)
		{
			//catch db errors
			e.printStackTrace();
		}finally {
			//always close connection
			db.closeConnection();
		}
	}

	public void readEmployees()
	{
		//Connecting to Db
		Db db=new Db();
		Connection con=db.getConnection();
		try
		{
			//obtain statement to read data 
			Statement smt=con.createStatement();
			//Result set is used to read and hold data in rs obj
			ResultSet rs=smt.executeQuery(Query.readData);
			System.out.println("Employee Details :");
			while(rs.next())
			{
				int eid=rs.getInt("eid");
				String ename=rs.getString("ename");
				String emailid=rs.getString("emailid");
				long phno=rs.getLong("phno");
				System.out.println("Eid :"+eid+" ,Ename:"+ename+" ,EmailId:"+emailid+" ,Phno:"+phno);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			db.closeConnection();
		}
	}

	public void updateEmployee(int eid,String emailid,long phno)
	{
		Db db=new Db();
		Connection con=db.getConnection();
		try
		{
			PreparedStatement pstm=con.prepareStatement(Query.updateData);
			pstm.setString(1,emailid);
			pstm.setLong(2,phno);
			pstm.setInt(3, eid);
			int rows=pstm.executeUpdate();
			if(rows>0)
			{
				System.out.println("Data Updated Successfully");
			}else
			{
				System.out.println("Error in Data Updation");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			db.closeConnection();
		}
	}

	public void deleteEmployee(int eid)
	{
		Db db=new Db();
		Connection con=db.getConnection();
		try
		{
			PreparedStatement pstm=con.prepareStatement(Query.deleteData);
			pstm.setInt(1, eid);
			int rows=pstm.executeUpdate();
			if(rows>0)
			{
				System.out.println("Row Deleted Successfully");
			}else
			{
				System.out.println("Failed to delete row");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			db.closeConnection();
		}
	}

	public void exportEmpDetailsToFiles()
	{
		Db db=new Db();
		Connection con=db.getConnection();
		try
		(
			Statement smt=con.createStatement();
			ResultSet rs=smt.executeQuery(Query.readData);
			PrintWriter writer=new PrintWriter(new FileWriter("Employee.csv"));
		){
			//Header
			writer.println("Id,Name,Email,Phone");
			//Data rows
			while(rs.next())
			{
				int eid=rs.getInt("eid");
				String ename=rs.getString("ename");
				String emailid=rs.getString("emailid");
				long phno=rs.getLong("phno");
				writer.println(eid+","+ename+","+emailid+","+phno);
			}
			System.out.println("Employee Data Exported To Employee.csv");
		}catch(Exception e){
			e.printStackTrace();
		}finally
		{
			db.closeConnection();			
		}
	}
	
	
}
