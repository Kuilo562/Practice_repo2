package dDt;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ReadTheDatafromProperty {
public static void main(String[] args) throws IOException {
	FileInputStream file = new FileInputStream("C:\\Users\\ATUL SHARMA\\Desktop\\commondata.properties");
	Properties obj = new Properties();
	obj.load(file);
	String URL = obj.getProperty("url");
	String BROWSER = obj.getProperty("browser");
	String UN = obj.getProperty("username");
	String PWD = obj.getProperty("password");
	
	Scanner s=new Scanner(System.in);
	System.out.println("enter the browser");
	String browser=s.next();

	WebDriver driver=null;
	
	if(BROWSER.equals("chrome")) {
		driver=new ChromeDriver();
	}
	else if(BROWSER.equals("edge")) {
		driver=new EdgeDriver();
		
	}
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(UN);
	driver.findElement(By.name("user_password")).sendKeys(PWD);
	driver.findElement(By.id("submitButton")).submit();
	driver.findElement(By.linkText("Organizations")).click();

	
	
	
}
}
