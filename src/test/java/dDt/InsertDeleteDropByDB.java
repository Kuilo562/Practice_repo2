package dDt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;





import com.mysql.cj.jdbc.Driver;

public class InsertDeleteDropByDB {
	public static void main(String[] args) throws Throwable  {
		


	Driver driverRef=new Driver();		
	DriverManager.registerDriver(driverRef);
	Connection conn=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
	Statement stat = conn.createStatement();
	stat.executeUpdate("insert into Project values('Ty_Proj_07514','Atul05','25/07/2024','Inst_70','Created',0);");
	System.out.println("done");
	conn.close();

}
}
