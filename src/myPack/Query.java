package myPack;
public class Query {
	//public static final String createDb="CREATE DATABASE EMPOPERATIONS";
	//public static final String createTable = "CREATE TABLE Employee(eid INT(5), ename VARCHAR(20), emailid VARCHAR(20), phno BIGINT)";
	public static final String insertData = "INSERT INTO Employee(eid, ename, emailid, phno) VALUES (?, ?, ?, ?)";
	public static final String readData = "SELECT * FROM Employee";
	public static final String updateData = "UPDATE Employee SET emailid = ?, phno = ? WHERE eid = ?";
	public static final String deleteData = "DELETE FROM Employee WHERE eid = ?";
}
