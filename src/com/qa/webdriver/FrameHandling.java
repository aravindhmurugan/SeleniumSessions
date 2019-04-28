package com.qa.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameHandling {

	public static void main(String[] args) throws InterruptedException {
		
			System.setProperty("webdriver.chrome.driver","E:/My Backups/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
		
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			driver.get("https://classic.crmpro.com");
			
			driver.findElement(By.name("username")).sendKeys("aravindhmurugan");
			driver.findElement(By.name("password")).sendKeys("welcome1");
			
//			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			Thread.sleep(5000);
			
			driver.switchTo().frame("intercom-borderless-frame");
			
			Actions action = new Actions(driver);
			
			action.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'intercom-chat-card-author')]"))).build().perform();
			
			driver.findElement(By.xpath("//div[contains(@class,'intercom-borderless-dismiss-button')]//span")).click();
			
//			Thread.sleep(2000);
				
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
//			WebElement loginbtn = driver.findElement(By.xpath("//input[@type='submit']"));
			
//			JavascriptExecutor js = (JavascriptExecutor)driver;
			
//			js.executeScript("arguments[0].click", loginbtn);
			
			Thread.sleep(3000);
					
			driver.switchTo().frame("mainpanel");
			
			driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
			
			
	}

}
