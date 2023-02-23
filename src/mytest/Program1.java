package mytest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




public class Program1 {
	
	WebDriver driver,driver1;
	
	@BeforeTest
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver1=new ChromeDriver();
		driver.get("https://www.imdb.com/title/tt9389998/");
		driver1.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
	    driver.manage().window().maximize();
	    driver1.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@Test
	public void verifyIMDB() {
		
        String Actual_release_date=driver.findElement(By.xpath("//li[@data-testid='title-details-releasedate']//ul[@role='presentation']")).getText();
	    String Expected_release_date="December 17, 2021 (United States)";
        String Actual_country_of_origin=driver.findElement(By.xpath("//a[normalize-space()='India']")).getText();
		String Expected_country_of_origin="India";
        
        Assert.assertEquals(Actual_release_date, Expected_release_date);
        Assert.assertEquals(Actual_country_of_origin, Expected_country_of_origin);
        
	}
	@Test
	public void verifyWikipedia() {
		String Actual_release_date=driver1.findElement(By.xpath("//tbody/tr[12]/td[1]/div[1]/ul[1]/li[1]")).getText();
		String Expected_release_date="17 December 2021";
		String Actual_country_of_origin=driver1.findElement(By.xpath("//td[normalize-space()='India']")).getText();
		String Expected_country_of_origin="India";
		
		Assert.assertEquals(Actual_release_date, Expected_release_date);
        Assert.assertEquals(Actual_country_of_origin, Expected_country_of_origin);
	    
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		driver1.quit();
	}

}
