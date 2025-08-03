package myPack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
	public static boolean adminLogin(Scanner sc)
	{
		Map<String,String>adminDetails=new HashMap<>();
		adminDetails.put("admin","1234");
		adminDetails.put("annatator","admin@123");
		adminDetails.put("root","Nikhil@123");
		System.out.println("-----ADMIN LOGIN-----");
		System.out.println("Enter User Name :");
		String user=sc.nextLine();
		System.out.println("Enter Password:");
		String pass=sc.nextLine();
		if(adminDetails.containsKey(user) && adminDetails.get(user).equals(pass))
		{
			System.out.println("Login Successfull, Welcome Admin...!\n");
			return true;
		}else
		{
			System.out.println("Invalid Credentials Access Denied");
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		if(!adminLogin(sc))
		{
			System.out.println("Exiting Program");
			sc.close();
			return;
		}
		EmpDAO dao=new EmpDAO(); 
		int choice;
		do
		{
			System.out.println("----Employee Management Menu----");
			System.out.println("1 - Insert Employee Data");
			System.out.println("2 - Read Employee Details");
			System.out.println("3 - Update Employee Data");
			System.out.println("4 - Delete Employee Data");
			System.out.println("5 - Exporting Employee Data to Employee.csv");
			System.out.println("6 - Exit!");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter ID :");
				int eid=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Name :");
				String ename=sc.nextLine();
				System.out.println("Enter EmailId :");
				String emailid=sc.nextLine();
				System.out.println("Enter Phone:");
				long phno=sc.nextLong();
				Employee emp=new Employee(eid,ename,emailid,phno);
				dao.insertEmployee(emp);
				break;
			
			case 2:
				dao.readEmployees();
				break;
				
			case 3:
				System.out.println("Enter EmpID To Update :");
				int uid=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter New Mail");
				String newEmail=sc.nextLine();
				System.out.println("Enter New Phone:");
				long newPhno=sc.nextLong();
				dao.updateEmployee(uid, newEmail,newPhno);
				break;
				
			case 4:
				System.out.println("Enter EmpId To Delete");
				int did=sc.nextInt();
				sc.nextLine();
				dao.deleteEmployee(did);
				break;
				
			case 5:	
				dao.exportEmpDetailsToFiles();
				break;
				
			case 6:
				System.out.println("Exiting Program");
				break;
				
			default:
				System.out.println("Invalid Choice");
			}
			
		}while(choice!=6);
		sc.close();
	}

}
