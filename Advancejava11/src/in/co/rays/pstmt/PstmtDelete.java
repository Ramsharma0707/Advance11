package in.co.rays.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PstmtDelete {
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
		
		PreparedStatement ps=conn.prepareStatement("delete from marksheet where id=17");
		
		int i=ps.executeUpdate();
		
		System.out.println("data deleted="+i);
	}

}
