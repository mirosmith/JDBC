import java.io.*;
import java.sql.*;
import java.util.Properties;

public class Jdbc_blob_clob {

    public static void main(String[] args) throws Exception {
	
	Connection conn = null;
	PreparedStatement preStm = null;
	//ResultSet rs = null;
	Statement stm = null;
	
	InputStream input = null;
	FileOutputStream output = null;
	
	try {
	    Properties props = new Properties();
	    props.load(new FileInputStream("demo.properties"));
	    
	    String user = props.getProperty("user");
	    String pass = props.getProperty("password");
	    String url = props.getProperty("dburl");
	    
	    conn = DriverManager.getConnection(url, user, pass);
	    
	    System.out.println("Pripojeni k databazi za pomoci souboru demo.properties bylo uspesne.");
	    
	    /*conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "student", "student");
	    
	      **** INSERT blob data into database ****
	    preStm = conn.prepareStatement("UPDATE employees SET resume = ? WHERE last_name = 'Doe'");
	    
	    File file = new File("jjj.jpg");   // soubor na lokalnim disku
	    input = new FileInputStream(file);
	    
	    preStm.setBinaryStream(1, input);
	    
	    preStm.executeUpdate();
	    
	    System.out.println("uspesne vlozeno do databaze");
	    
	    
	    
	    // **** SAVE blob data from database to local disc ****	    
	    stm = conn.createStatement();
	    
	    rs = stm.executeQuery("SELECT resume FROM employees WHERE last_name = 'Doe'");
	    
	    File file = new File("output_jara.jpg");
	    output = new FileOutputStream(file);	    
	    
	    byte[] pole_byte = new byte[1024];
	    
	    if (rs.next()) {
		input = rs.getBinaryStream("resume");		
		
		while (input.read(pole_byte) > 0) {
		    output.write(pole_byte);
		}
		
		System.out.println("uspesne ulozeno do souboru");
	    }
	    */
	    
	} catch (Exception e) {	    
	    e.printStackTrace();
	}
	finally {
	    if (input != null) {
		input.close();;
	    }
	    if (output != null) {
		output.close();;
	    }
	    if (preStm != null) {
		preStm.close();
	    }
	    if (stm != null) {
		stm.close();
	    }
	    if (conn != null) {
		conn.close();
	    }
	}

    }

}
