package dDt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExeceuteSelectQueryTest {
	public static void main(String[] args) throws Throwable {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "root");
		Statement stat = conn.createStatement();
		ResultSet set = stat.executeQuery("select *from Student");
		while(set.next()) {
			System.out.println(set.getString(1)+"\t"+set.getString(2)+"\t"+set.getString(3));
		}
//		System.out.println("dpne");
		conn.close();
	}
	}


