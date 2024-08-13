package dDt;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
//import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganisation {
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		FileInputStream file = new FileInputStream("C:\\Users\\ATUL SHARMA\\Desktop\\CreateOrganisation\\commondata.properties");
		Properties obj = new Properties();
		obj.load(file);
		String URL = obj.getProperty("url");
		String BROWSER = obj.getProperty("browser");
		String UN = obj.getProperty("username");
		String PWD = obj.getProperty("password");
		
		//Read the data from excel file
		FileInputStream file1 = new FileInputStream("C:\\Users\\ATUL SHARMA\\Desktop\\CreateOrganisation\\Tek3.xlsx");
		Workbook Wb = WorkbookFactory.create(file1);
		Sheet sheet = Wb.getSheet("sheet1");
		Row row = sheet.getRow(1);
		String orgname = row.getCell(2).toString();
		Wb.close();
		
	

		WebDriver driver=null;
		
		if(BROWSER.equals("chrome")) 
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("edge"))
		{
			driver=new EdgeDriver();
			
		}
		//step1:login to app
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).submit();
		//step2: Navigate to Organisation module 
		driver.findElement(By.linkText("Organizations")).click();
		//step3: click on Create Organisation button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		//step3: Enter the values to the Organisation name textfield
		
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		//step3: click on save button
		driver.findElement(By.name("button")).click();
		//step4:logout from the application
//		Thread.sleep(5000);
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
//		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
		driver.quit();
		
		
		
		

		
		
		
	}
}

