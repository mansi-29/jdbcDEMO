import java.sql.*;
public class ConnectMe
{
public static void main(String[] args) {
	// TODO Auto-generated method stub
	try 
    {
      Class.forName("oracle.jdbc.driver.OracleDriver");  // Load  Driver
      //Establishing connection with database
      Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","Man","123");

      Statement stmt=con.createStatement(); // Creating a SQL Statement

      ResultSet rs=stmt.executeQuery("select * from Employee");

      while(rs.next())
      {
          System.out.println(rs.getString(1) +" "+rs.getString(2) +" "+rs.getString(3));
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
