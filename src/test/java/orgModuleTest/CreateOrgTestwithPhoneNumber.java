package orgModuleTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrgTestwithPhoneNumber {

	public static void main(String[] args) throws Exception {
		
		
		
		
	FileInputStream file = new FileInputStream("C:\\Users\\ATUL SHARMA\\Desktop\\CreateOrganisation\\commondata.properties");
	Properties obj = new Properties();
	obj.load(file);
	String URL = obj.getProperty("url");
	String BROWSER = obj.getProperty("browser");
	String UN = obj.getProperty("username");
	String PWD = obj.getProperty("password");
	
	//Read the data from excel file
	FileInputStream file1 = new FileInputStream("C:\\Users\\ATUL SHARMA\\Desktop\\CreateOrganisation\\Tek3 - Copy.xlsx");
	Workbook Wb = WorkbookFactory.create(file1);
	Sheet sheet = Wb.getSheet("sheet1");
	Row row = sheet.getRow(6);
	String PhoneNumber= row.getCell(3).toString();
	String orgname= row.getCell(2).toString();
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
	
	
	//generate random number
	Random ran= new Random();
	 int randomvalue = ran.nextInt(1000);
	 
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
	
	driver.findElement(By.name("accountname")).sendKeys(orgname+randomvalue);
    driver.findElement(By.id("phone")).sendKeys(PhoneNumber);
	
	//step3: click on save button
	driver.findElement(By.name("button")).click();
	
	//verify  and Type info ExpectedREsult
		String ActPhoneNum = driver.findElement(By.id("dtlview_Phone")).getText();
		if(ActPhoneNum.equals(PhoneNumber)) {
			System.out.println(ActPhoneNum+ "verfied=pass");
		}
		else {
			System.out.println(ActPhoneNum+ "verfied=Fail");
		}
		
		driver.quit();
	
	

	
	
	
}
}

