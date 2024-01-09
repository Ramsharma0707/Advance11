package in.co.rays.pstmt1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PSTMTCrud {
public static void main(String[] args) throws Exception {
	//testAdd(19,119,"gagan",65,74,52);
	//testUpdate(19,120,"binu",70,70,70);
	//testDelete(19);
	//testRead();
	testFindById(10);
}







private static void testAdd(int id,int roll_no,String name,int physics,int chemistry,int maths) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
	
	PreparedStatement ps=conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
	
	ps.setInt(1, id);
	ps.setInt(2, roll_no);
	ps.setString(3, name);
	ps.setInt(4, physics);
	ps.setInt(5, chemistry);
	ps.setInt(6, maths);
	
	int i=ps.executeUpdate();
	System.out.println("data inserted:="+i);
	
}
private static void testUpdate(int id,int roll_no,String name,int physics,int chemistry,int maths) throws Exception {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
	PreparedStatement ps=conn.prepareStatement("update marksheet set roll_no=?,name=?,physics=?,chemistry=?,maths=? where id=?");
	
	ps.setInt(1, roll_no);
	ps.setString(2, name);
	ps.setInt(3, physics);
	ps.setInt(4, chemistry);
	ps.setInt(5, maths);
	ps.setInt(6, id);
	
	int i=ps.executeUpdate();
	System.out.println("data updated:="+i);
}

private static void testDelete(int id) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
	PreparedStatement ps=conn.prepareStatement("delete from marksheet where id=?");
	
	ps.setInt(1, id);
	int i=ps.executeUpdate();
	System.out.println("data deleted="+i);
	
}

private static void testRead() throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
	PreparedStatement ps=conn.prepareStatement("select * from marksheet ");
	
	ResultSet rs=ps.executeQuery();

	while (rs.next()) {
		System.out.print(rs.getInt(1));
		System.out.print("\t" + rs.getInt(2));
		System.out.print("\t" + rs.getString(3));
		System.out.print("\t" + rs.getInt(4));
		System.out.print("\t" + rs.getInt(5));
		System.out.println("\t" + rs.getInt(6));
}
}

 private static void testFindById(int id) throws Exception {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
	
	PreparedStatement ps=conn.prepareStatement("select * from marksheet where id=?");
	ps.setInt(1, id);
	
	ResultSet rs=ps.executeQuery();
	
	while (rs.next()) {
		System.out.print(rs.getInt(1));
		System.out.print("\t" + rs.getInt(2));
		System.out.print("\t" + rs.getString(3));
		System.out.print("\t" + rs.getInt(4));
		System.out.print("\t" + rs.getInt(5));
		System.out.println("\t" + rs.getInt(6));
		
	}
}


}
