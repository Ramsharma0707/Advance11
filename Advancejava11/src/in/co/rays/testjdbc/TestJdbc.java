package in.co.rays.testjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.co.rays.util.JDBCDataSource;

public class TestJdbc {
	public static void main(String[] args) throws Exception {
		for (int i = 1; i < 50; i++) {
			
		System.out.println("connection..."+i);	
			testRead();
			
		}
	}

	private static void testRead() throws Exception {
		Connection conn=JDBCDataSource.getConnection();
		
		PreparedStatement ps=conn.prepareStatement("select * from marksheet where id=10");
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			
			System.out.print( rs.getInt(1));
			System.out.print("\t"+rs.getInt(2));
			System.out.print("\t"+rs.getString(3));
			System.out.print("\t"+rs.getInt(4));
			System.out.print("\t"+rs.getInt(5));
			System.out.println("\t"+rs.getInt(6));
			
			
		}
	}

}
