package Demo1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver = null;
  @BeforeClass
  public void OpenPage() {
	  driver = new ChromeDriver();
	  driver.get("https://techpub-connect-demo.netlify.app/html/contactus.html");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
  
  @Test(priority= 1)
  public void VerifyLogo()
  {
	  WebElement l = driver.findElement(By.xpath("//div[@class='logo']//a"));
	  boolean flag = l.isDisplayed();
	  Assert.assertTrue(flag);
	  
  }
  
  @Test(priority= 2)
  public void VerifyContactUS()
  {
	  WebElement c = driver.findElement(By.xpath("//section[@class='page-title-area d-flex align-items-end']"));
	  boolean flag = c.isDisplayed();
	  Assert.assertTrue(flag);
	  
  }
  @Test(priority= 3)
  public void InquaryForm()
  {
	   driver.findElement(By.xpath("//input[@placeholder='John Doe']")).sendKeys("john");
	   driver.findElement(By.xpath("//input[@placeholder='(406) 555-0120']")).sendKeys("12345");
	   driver.findElement(By.xpath("//input[@placeholder='info@domain.com']")).sendKeys("john@123");
	   driver.findElement(By.xpath("//input[@placeholder='Subject line']")).sendKeys("Registration issue");
	   driver.findElement(By.xpath("//textarea[@id='commnent']")).sendKeys("Please check Registration issue");
	   driver.findElement(By.xpath("//input[@placeholder='Subject line']")).sendKeys("Registration issue");
  }
  @Test(priority= 4)
  public void Submit()
  {
	  driver.findElement(By.xpath("//button[normalize-space()='SUBMIT NOW']")).click();
	  
  }
  @Test(priority= 5)
  public void Subscribe()
  {
	  driver.findElement(By.xpath("//input[@placeholder='Write Your E-mail']")).sendKeys("john@123");
	  driver.findElement(By.xpath("//button[normalize-space()='Subscribe Now']")).click();
  }
  
 
  
  @AfterClass
  public void ClosePage() {
	  driver.quit();
	  
  }
}
