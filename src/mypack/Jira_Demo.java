package mypack;

import java.awt.AWTException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Jira_Demo {
	WebDriver driver;
  @Test
  public void f() throws AWTException {
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  String parentWindowHandle = driver.getWindowHandle();
	  driver.findElement(By.xpath("//div[@id=\"gadget-11950\"]//div/a[@title=\"Dashboard: Pending Validation: Educator Apps\"]")).click();
	  
	  driver.findElement(By.xpath("//table[@id='issuetable']//th/span[text()='Assignee']")).click();
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  driver.findElement(By.xpath("//table[@id='issuetable']//th[@title='Ascending order - Click to sort in descending order']")).click();
	  try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  /*Date date = new Date();
	  DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	  // Use Madrid's time zone to format the date in
	  df.setTimeZone(TimeZone.getTimeZone(""));

	  System.out.println("Date and time : " + df.format(date));*/
	  
	  List <WebElement> wl = driver.findElements(By.xpath("//em[text()='Unassigned']/parent::td/parent::tr/child::td[2]/a"));
	  
	  for(int i = 0; i< wl.size();i++) {
		  wl.get(i).sendKeys(Keys.CONTROL, Keys.RETURN);
		  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  
	  Set<String> allWindowHandles = driver.getWindowHandles();
	  //System.out.println(allWindowHandles);
	  for(String handle : allWindowHandles )
	  {
		  
		  try {
			  driver.switchTo().window(handle);
			  Thread.sleep(2000);
			  String str = driver.getCurrentUrl();
			  System.out.println(str);
			  Thread.sleep(2000);
			  driver.findElement(By.id("assign-to-me")).click();
			  Thread.sleep(2000);
		  } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			  e.printStackTrace();
		}
	  }		  
}
	  	  
  @BeforeMethod
  public void beforeMethod() {
	  
	  driver.findElement(By.id("login-form-username")).sendKeys("surya.singh");
	  driver.findElement(By.id("login-form-password")).sendKeys("Impactqa@123");
	  driver.findElement(By.id("login")).click();
  }

  @AfterMethod
  public void afterMethod() {
  }

  
  @BeforeClass
  public void beforeClass() {
	  
	  //System.setProperty("webdriver.chrome.driver", "C:\\Users\\ayshwarya.katheria\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\ayshwarya.katheria\\Downloads\\geckodriver-v0.21.0-win64\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get("https://jira.performancematters.com/");
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
 
  }

}
