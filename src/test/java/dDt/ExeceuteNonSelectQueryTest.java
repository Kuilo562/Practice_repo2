package dDt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExeceuteNonSelectQueryTest {
	public static void main(String[] args) throws Throwable {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "root");
		Statement stat = conn.createStatement();
		int set = stat.executeUpdate("insert into Student values('5','tony','hyderabad');");
		System.out.println(set);
		
//		System.out.println("dpne");
		conn.close();
	
	}
}


