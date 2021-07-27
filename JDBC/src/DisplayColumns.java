import java.sql.*;
import java.util.Scanner;
public class DisplayColumns {
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Table Name");
		String tname = sc.next();
		try 
	    {
	      Class.forName("oracle.jdbc.driver.OracleDriver");  // Load  Driver
	      Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","Man","123");

	      Statement st = con.createStatement();

	      String q= "select * from "+ tname; 
	      ResultSet rs = st.executeQuery(q);
	      ResultSetMetaData rst = rs.getMetaData();
	      int colcount = rst.getColumnCount();
	      for (int i = 1; i <=colcount ; i++) 
	      {
	    	  System.out.println(rst.getColumnName(i)+ " ");

	      }
}
	   catch (ClassNotFoundException e) {
	      e.printStackTrace();
	  }
	    catch (SQLException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	  }
	}
} 