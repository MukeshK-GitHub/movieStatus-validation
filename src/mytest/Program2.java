package mytest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program2 {
String movie_name="pushpa"	;
WebDriver driver,driver1;

	@BeforeTest
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver1=new ChromeDriver();
		driver.get("https://www.imdb.com");
		driver1.get("https://www.wikipedia.org");
	    driver.manage().window().maximize();
	    driver1.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	public void verifymoviestatusByIMDB() {
		driver.findElement(By.xpath("//input[@id='suggestion-search']")).sendKeys(movie_name);
		driver.findElement(By.xpath("//button[@id='suggestion-search-button']//*[name()='svg']")).click();
		driver.findElement(By.xpath("//a[@role='button'][normalize-space()='Pushpa: The Rise - Part 1']")).click();
	    
	
	
	}
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		driver1.quit();
	}

}
