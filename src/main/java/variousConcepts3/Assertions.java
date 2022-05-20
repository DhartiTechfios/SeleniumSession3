package variousConcepts3;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert;

public class Assertions {
	private static final boolean True = false;
	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@Test
	public void loginTest() {

		// Storing Data with WebElement & By Class----DataType Name = Value;

		By UserNameField = By.xpath("//input[@id='username']");
		By PassWordField = By.xpath("//input[@id='password']");
		By SignInField = By.xpath("//button[@type='submit']");
		By DashBoardField = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");

		driver.findElement(UserNameField).clear();
		driver.findElement(UserNameField).sendKeys("demo@techfios.com");
		driver.findElement(PassWordField).sendKeys("abc123");
		driver.findElement(SignInField).click();

		/*
		 * Boolean PageTitleDisplay; try {WebElement DashBoard_Element =
		 * driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div/h2"));
		 * PageTitleDisplay = True;} catch(Exception e) { PageTitleDisplay = false;
		 * e.printStackTrace();}
		 */

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(DashBoardField));

		// Assertion Validating that a page is exists
		Assert.assertTrue("Wrong page!", driver.findElement(DashBoardField).isDisplayed());

		
		// Assert.assertTrue("Wrong Page!", PageTitleDisplay);
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
