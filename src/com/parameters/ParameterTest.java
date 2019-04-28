package com.parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	
	WebDriver driver;
	
	@Test
	@Parameters({"env","browser","url","emailid"})
	
	public void yahootestlogin(String env,String browser,String url,String emailid) {
		
		if(browser.equals("chrome")) {
				
			System.setProperty("webdriver.chrome.driver","E:/My Backups/chromedriver.exe");
			driver = new ChromeDriver();
			}else if (browser.equals("FireFox")) {
				System.setProperty("webdriver.gecko.driver","E:\\My Backups/geckodriver.exe");
				driver = new FirefoxDriver();				
			}
		
		driver.get(url);
		
		driver.findElement(By.id("login-username")).clear();
		driver.findElement(By.id("login-username")).sendKeys(emailid);
		
		driver.findElement(By.xpath("//div//input[@id='login-signin']")).click();
		
	}
	
}
