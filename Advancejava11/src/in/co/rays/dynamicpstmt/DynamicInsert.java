package in.co.rays.dynamicpstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DynamicInsert {

	public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
		
		PreparedStatement ps=conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
	
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the marksheet id :");
		 int id=sc.nextInt();
	
		 System.out.println("Enter the marksheet roll_no:");
		int roll_no=sc.nextInt();
		
		System.out.println("Enter the name");
		String name=sc.next();
		
		System.out.println("Enter the marksheet physics:");
		int physics=sc.nextInt();
		
		System.out.println("Enter the marksheet chemistry:");
		int chemistry=sc.nextInt();
		
		System.out.println("Enter the marksheet maths:");
		int maths=sc.nextInt();
		
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		
//		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
//		
//		PreparedStatement ps=conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
//	
		ps.setInt(1, id);
		ps.setInt(2, roll_no);
		ps.setString(3, name);
		ps.setInt(4, physics);
		ps.setInt(5, chemistry);
		ps.setInt(6, maths);
		
		int i=ps.executeUpdate();
		System.out.println("data inserted="+i);
		
	}
}
