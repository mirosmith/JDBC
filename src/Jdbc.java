import java.sql.*;

public class Jdbc {
    
    public static void main(String[] args) throws SQLException {

	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;	
	PreparedStatement preStm = null;
	
	try {
		// Get a connection to database
		myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "student" , "student");
		
		//System.out.println("Database connection successful!\n");
		
		// Create a statement
		myStmt = myConn.createStatement();
		
		//**** INSERT data into employees****
		//myStmt.executeUpdate("insert into employees (last_name, first_name, email, department, salary) values ('Smith','Edgar','chuligan@seznam.cz', 'HR', 60000.00)");
		
		//**** UPDATE data in employees****
		//myStmt.executeUpdate("update employees set email='john.doe@hracholusky.com' where last_name='Doe' and first_name='John'");
		
		//**** DELETE data from employees****
		//myStmt.executeUpdate("delete from employees where last_name = 'Doe'");
		
		// **** SELECT Execute SQL query ****
		myRs = myStmt.executeQuery("SELECT MIN(salary), department "
					 + "FROM employees "
					 + "GROUP BY department");
		
		/* **** PREPARED STATEMENT ****
		preStm = myConn.prepareStatement("select * from employees where salary > ? and department = ?");
		
		preStm.setInt(1, 80000);
		preStm.setString(2, "Legal");
		
		myRs = preStm.executeQuery();
		
		// Process the result set
		while (myRs.next()) {
		    
			System.out.format("%-10s %-10s %-25s %-15s %s \n", myRs.getString(2), myRs.getString(3), myRs.getString(4), myRs.getString(5), myRs.getString(6));
		}
		*/
		
		while (myRs.next()) {
		    
			System.out.format("%-10d %-10s \n", myRs.getInt(1), myRs.getString(2));
		}
	}
	catch (Exception exc) {
		exc.printStackTrace();
	}
	finally {
		if (myRs != null) {
			myRs.close();
		}
		
		if (myStmt != null) {
			myStmt.close();
		}
		
		if (preStm != null) {
			preStm.close();
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


}
