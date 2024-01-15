package in.co.rays.procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;

public class TestProcedureOut {
public static void main(String[] args) throws Exception {
	
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
	
	CallableStatement callStmt = conn.prepareCall("{CALL empOUT(?)}");

	callStmt.registerOutParameter(1, Types.INTEGER);

	callStmt.execute();

	int resultValue = callStmt.getInt(1);
	System.out.println("Result from empOut stored procedure: " +resultValue);

} catch (Exception e) {
	e.printStackTrace();
}
}

}