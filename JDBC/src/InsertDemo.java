import java.sql.*;
import java.util.Scanner;
public class InsertDemo {
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter ProductDetails");
		System.out.print("ProdID:");
		int pid=sc.nextInt();
		System.out.print("Name:");
		String pname = sc.next();
		System.out.print("Price:");
		int price=sc.nextInt();
		System.out.print("Category:");
		String cat=sc.next();

		try 
	    {
	      Class.forName("oracle.jdbc.driver.OracleDriver");  // Load  Driver
	      Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","Man","123");
	       //Statement stmt=con.createStatement(); // Creating a SQL Statement
	       //String qry="insert into ProductInfo values("+pid+",' "+pname+"',"+price+",'"+cat+"')";
           //stmt.executeUpdate(qry);
	       PreparedStatement ps=con.prepareStatement("insert into ProductInfo values (?, ?, ?, ?)");
	       ps.setInt (1, pid);

	       ps.setString(2, pname);

	       ps.setInt (3, price);

	       ps.setString(4, cat);

	       ps.executeUpdate();

           System.out.print("Data saved!");

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