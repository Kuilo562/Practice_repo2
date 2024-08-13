package dDt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class SeleniumTestReadDataFromRuntime
{

@Test
public void seleniumTest() throws IOException {
	//read coomon data from cmdline
	String url = System.getProperty("url");
	String Browser = System.getProperty("browser");
	String Username = System.getProperty("username");
	String Pwd = System.getProperty("password");;
	
	//Read the data from excel file
	FileInputStream file1 = new FileInputStream("C:\\Users\\ATUL SHARMA\\Desktop\\CreateOrganisation\\Tek3.xlsx");
	Workbook Wb = WorkbookFactory.create(file1);
	Sheet sheet = Wb.getSheet("sheet1");
	Row row = sheet.getRow(1);
	String orgname = row.getCell(2).toString();
	Wb.close();
	


	WebDriver driver=null;
	
	if(Browser.equals("chrome")) 
	{
		driver=new ChromeDriver();
	}
	else if(Browser.equals("edge"))
	{
		driver=new EdgeDriver();
		
	}
	//step1:login to app
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys(Username);
	driver.findElement(By.name("user_password")).sendKeys(Pwd);
	driver.findElement(By.id("submitButton")).submit();
	Actions act=new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
//	Thread.sleep(3000);
	driver.findElement(By.linkText("Sign Out")).click();
	driver.quit();
		
	}
}


