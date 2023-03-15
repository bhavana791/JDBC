package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class JDBC {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		// TODO Auto-generated method stub
		JDBC obj=new JDBC();
		int choice = 0;
		do {
			
			System.out.println("Enter Your choice \n 1]create database 2]create table 3]insert 4]delete 5]update ");
			 choice = scanner.nextInt();
			switch(choice) {
			case 1:
				obj.db_create();
			break;
			
			case 2:
				obj.table_create();
			break;
			case 3:
				obj.insert();
			break;
			case 4:
				obj.delete_data();
			break;
			case 5:
				obj.update();
			break;
			
			
			}
			}while(choice!=0);
		
		
	}
	
	public void db_create()
	{
		try
		{
			String qur="create database JDBC6 ";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","Bhavana@7888");
			PreparedStatement ps=con.prepareStatement(qur);
			ps.execute();
			System.out.println("Database is created.");
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void table_create()
	{
		try 
		{
			String qur="create table stud_data (Stud_id integer,first_name varchar(20),middle_name varchar(20),last_name varchar(20),state varchar(20),dob date)";
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc6","root","Bhavana@7888");
			PreparedStatement ps=con.prepareStatement(qur);
			ps.execute();
			System.out.println("Table is Created");
			con.close();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void insert()
	{
		String qur="insert into stud_data(Stud_id,first_name,middle_name,last_name,state,dob)value(?,?,?,?,?,?)";
		String id,fn,mn,ln,st,dob;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student ID");
		id=sc.next();
		System.out.println("Enter First Name");
		fn=sc.next();
		System.out.println("Enter  middle Name");
		mn=sc.next();
		System.out.println("Enter last Name ");
		ln=sc.next();
		System.out.println("Enter State ");
		st=sc.next();
		System.out.println("Enter DOB ");
		dob=sc.next();
		
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc6","root","Bhavana@7888");
			PreparedStatement ps=con.prepareStatement(qur);
			ps.setString(1, id);
			ps.setString(2, fn);
			ps.setString(3, mn);
			ps.setString(4, ln);
			ps.setString(5, st);
			ps.setString(6, dob);
			int count=ps.executeUpdate();
			if(count>0)
			{
				System.out.println("Data is inserted");
			}
			else
			{
				System.out.println("Error");
				
				}
			ps.close();
			con.close();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete_data()
	{
		String qur="delete from stud_data where Stud_id=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student ID");
		String id=sc.next();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc6","root","Bhavana@7888");
			PreparedStatement ps=con.prepareStatement(qur);
			ps.setString(1, id);
			int count=ps.executeUpdate();
			if(count>0)
			{
				System.out.println("Data is Deleted");
			}
			else
			{
				System.out.println("Error");
				
				}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update()
	{
		String qur="update stud_data set Stud_id=?,first_name=?,middle_name=?,last_name=?,state=?,dob=?";
		String id,fn,mn,ln,st,dob;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student ID");
		id=sc.next();
		System.out.println("Enter First Name");
		fn=sc.next();
		System.out.println("Enter  middle Name");
		mn=sc.next();
		System.out.println("Enter last Name ");
		ln=sc.next();
		System.out.println("Enter State ");
		st=sc.next();
		System.out.println("Enter DOB ");
		dob=sc.next();
		
		System.out.println("Enter your  new Student ID");
		id=sc.next();
		System.out.println("Enter your new First Name");
		fn=sc.next();
		System.out.println("Enter your new  middle Name");
		mn=sc.next();
		System.out.println("Enter your new  last Name ");
		ln=sc.next();
		System.out.println("Enter your new  State ");
		st=sc.next();
		System.out.println("Enter your new  DOB ");
		dob=sc.next();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc6","root","Bhavana@7888");
			PreparedStatement ps=con.prepareStatement(qur);
			ps.setString(1, id);
			ps.setString(2, fn);
			ps.setString(3, mn);
			ps.setString(4, ln);
			ps.setString(5, st);
			ps.setString(6, dob);
			int count=ps.executeUpdate();
			if(count>0)
			{
				System.out.println("Data is Updated");
			}
			else
			{
				System.out.println("Error");
				
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
