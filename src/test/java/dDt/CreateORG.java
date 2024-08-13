package dDt;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateORG {
	@Test
	public void CreateOrgTest() throws Exception {
		
		//getting data from cmd
		String url=System.getProperty("url");
		String browser=System.getProperty("browser");
		String username=System.getProperty("username");
		String password=System.getProperty("password");
		
		//selecting browser to  open
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}else {
			driver=new ChromeDriver();
		}
		
		//maximize browser and enter url
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//login into application
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		//click on organization and create new organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//fetch data from excel file
		FileInputStream fis=new FileInputStream("C:\\Users\\ATUL SHARMA\\Desktop\\CreateOrganisation\\Tek3.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String orgname = wb.getSheet("sheet1").getRow(1).getCell(2).getStringCellValue();
		Random r=new Random();
		int r_n=r.nextInt(100);
		
		//filling details in create org form
		driver.findElement(By.name("accountname")).sendKeys(orgname+r_n);
		
		//click on save button
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
//		WebElement deletebtn = driver.findElement(By.name("Delete"));
//		WebDriverWait exw=new WebDriverWait(driver, Duration.ofSeconds(10));
//		exw.until(ExpectedConditions.visibilityOf(deletebtn));
		Thread.sleep(1000);
		//deleting the organization created
//		driver.findElement(By.name("Delete")).click();
//		driver.switchTo().alert().accept();
//		
		//logging out from account
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).build().perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();
		
		
		

	}
}
