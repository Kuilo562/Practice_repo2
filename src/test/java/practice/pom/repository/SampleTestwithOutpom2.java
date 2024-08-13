package practice.pom.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;



public class SampleTestwithOutpom2 {
	
public SampleTestwithOutpom2(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
		@FindBy(name="user_name")
		WebElement ele1;
		
		@FindBy(name="user_password")
		WebElement ele2;
		
		@FindBy(id="submitButton")
		WebElement ele3;
	
	
	
	@Test
	
	public void sampleTest() {
		
	
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		
		SampleTestwithOutpom2 s = PageFactory.initElements(driver, SampleTestwithOutpom2.class);
		   s.ele1.sendKeys("admin");
		   s.ele2.sendKeys("admin");
		   
		   driver.navigate().refresh();
		   
		   s.ele1.sendKeys("admin");
		  s.ele2.sendKeys("admin");
		   s.ele3.click();
		   
}
}

