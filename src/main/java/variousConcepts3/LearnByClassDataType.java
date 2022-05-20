package variousConcepts3;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnByClassDataType {
WebDriver driver;
	
	

	@Before
	 public void init() {
	  
	  System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().deleteAllCookies();
	  driver.get("https://techfios.com/billing/?ng=dashboard/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  
	 }

	@Test
	public void loginTest() {
		//driver.findElement(By.xpath("//input[@id='username'])")).sendKeys("demo@techfios.com");
		//Storing Data wiht WebElement----DataType  Name = Value; 
		
		WebElement UserNameElement = driver.findElement(By.xpath("//input[@id='username']"));
		UserNameElement.sendKeys("demo@techfios.com");
		
		//Storing data with Using By class datatype 
		
		By PassWordField = By.xpath("//input[@id='password']");
		driver.findElement(PassWordField).sendKeys("abc123");
		
	    By SignInField = By.xpath("//button[@type='submit']");
	    driver.findElement(SignInField).click();
	}
	
}
	
	
	
	
	
	
	
	
	

