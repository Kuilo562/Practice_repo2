package dDt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class VerifyDataInDatabaseWithGUI {
public static void main(String[] args) throws Throwable  {
	String projectName="Inst_70";
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//	Random random=new Random();
//	int ran = random.nextInt(1000);
	
	driver.get("http://106.51.90.215:8084/");
	driver.findElement(By.id("username")).sendKeys("rmgyantra");
	driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	driver.findElement(By.linkText("Projects")).click();
	driver.findElement(By.xpath("//span[text()='Create Project']")).click();
	driver.findElement(By.name("projectName")).sendKeys(projectName);
	driver.findElement(By.name("createdBy")).sendKeys("Atul01");
	driver.findElement(By.name("status"));
	 Select sel = new Select(driver.findElement(By.name("status")));
	 sel.selectByVisibleText("Created");
	 driver.findElement(By.xpath("//input[@type='submit']")).submit();
	
	//verify the project in Backend [DB] using JDBC
	 boolean flag= false;
		Driver driverRef=new Driver();		
		DriverManager.registerDriver(driverRef);
		Connection conn=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
		Statement stat = conn.createStatement();
		ResultSet set = stat.executeQuery("select *from project;");
		while(set.next()) {
			String actProjectName = set.getString(4);
			if(projectName.equals(actProjectName)) {
				flag=true;
				System.out.println(projectName+"is avaliable");
			}
			
//		System.out.println("dpne");
		//conn.close();
	}
		if(flag==false) {
			System.out.println(projectName+"is  not avaliable");
		}
		conn.close();

	}

}

