package in.co.rays.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PstmtInsert {
	
	public static void main(String[] args) throws Exception {
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
		
		PreparedStatement ps=conn.prepareStatement("insert into marksheet values(17,117,'asd',74,54,65)");
		
		int i=ps.executeUpdate();
		
		System.out.println("data inserted ="+i);
		
	}

}
