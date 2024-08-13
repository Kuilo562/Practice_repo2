package dDt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleunitTestCheckProjectInBackTest {
@Test
public void projectCheckTest() throws Throwable {
	String expectedProjectName ="Sam";
	boolean flag=false;
	Driver driverRef=new Driver();
	DriverManager.registerDriver(driverRef);
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "root");
	Statement stat = conn.createStatement();
	ResultSet set = stat.executeQuery("select *from Student;");
	while(set.next()) {
		String actProjectName = set.getString(1);
		if(expectedProjectName.equals(actProjectName)) {
			flag=true;
			System.out.println(expectedProjectName+"is avaliable");
		}
		
//	System.out.println("dpne");
	//conn.close();
}
	if(flag==false) {
		System.out.println(expectedProjectName+"is  not avaliable");
	}
	conn.close();

}
}
