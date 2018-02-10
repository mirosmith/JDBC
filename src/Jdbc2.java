import java.sql.*;

public class Jdbc2 {

    public static void main(String[] args) throws SQLException {
	
	Connection conn = null;
	CallableStatement callStmt = null;
	ResultSet rs = null;
	
	try {
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "student", "student");
	    
	 /* **** IN Stored Procedure ****
	     
	    System.out.println("Before increase");
	    showSalaries(conn, "Engineering");
	    System.out.println();
	    
	    callStmt = conn.prepareCall("{call increase_salaries_for_department(? , ?)}");
	    
	    callStmt.setString(1, "Engineering");
	    callStmt.setDouble(2, 10000.00);
	    
	    callStmt.execute();   
	    
	    
	    System.out.println("After increase");
	    showSalaries(conn, "Engineering");
	 */
	    
	 /* **** INOUT Stored Procedure ****
	    callStmt = conn.prepareCall("{call greet_the_department(?)}");
	    
	    callStmt.registerOutParameter(1, Types.VARCHAR);
	    callStmt.setString(1, "OV Media");
	    
	    callStmt.execute();
	    
	    String result = callStmt.getString(1);
	    System.out.println(result);
	 */
	    
	 /* **** OUT Stored Procedure ****  
	  callStmt = conn.prepareCall("{call get_count_for_department(?,?)}");
	  
	  callStmt.setString(1, "Engineering");
	  callStmt.registerOutParameter(2, Types.INTEGER);
	  
	  callStmt.execute();
	  
	  int a = callStmt.getInt(2);
	  System.out.println("pocet lidi = " + a);
	*/
	// **** RESULT-SET Stored Procedure ****
	    
	  callStmt = conn.prepareCall("{call get_employees_for_department(?)}");
	  
	  callStmt.setString(1, "Engineering");
	  
	  callStmt.execute();
	  
	  rs = callStmt.getResultSet();
	  
	  while (rs.next()) {
	      System.out.println(rs.getString(2) + " " + rs.getString(3));
	  }
	    
	    
	} catch (SQLException e) {	    
	    e.printStackTrace();
	}
	finally {
	    if (conn != null) {
		conn.close();
	    }
	    if (callStmt != null) {
		callStmt.close();
	    }	
	    if (rs != null) {
		rs.close();
	    }	
	}	
	
	
    }
    
    public static void showSalaries(Connection connect, String departm) throws SQLException {
	
	PreparedStatement preStmt = null;
	ResultSet rs = null;
	
	try {
	    preStmt = connect.prepareStatement("select * from employees where department = ?");
	
	    preStmt.setString(1, departm);
	
	    rs = preStmt.executeQuery();
	
	    while (rs.next()) {
		System.out.println(rs.getString(2) + " " + rs.getString(3)+ " " + rs.getString(5) + " " + rs.getString(6));
	    }	
	}
	catch (Exception ex) {
	    ex.printStackTrace();
	}
	finally {
	    
	    if (preStmt != null) {
		preStmt.close();
	    }
	    if (rs != null) {
		rs.close();
	    }
	}	
	
    }

}
