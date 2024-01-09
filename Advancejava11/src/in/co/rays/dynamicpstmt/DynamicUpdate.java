package in.co.rays.dynamicpstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DynamicUpdate {
 public static void main(String[] args) throws Exception {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 
	 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
	
	 PreparedStatement ps=conn.prepareStatement("update marksheet set roll_no=?,name=?,physics=?,chemistry=?,maths=? where id=?");
	 
	 ps.setInt(1, 118);
	 ps.setString(2, "mahajan");
	 ps.setInt(3, 78);
	 ps.setInt(4, 45);
	 ps.setInt(5, 74);
	 ps.setInt(6, 18);
	 
	int i=ps.executeUpdate();
	 System.out.println("data updated="+i);
}
}
