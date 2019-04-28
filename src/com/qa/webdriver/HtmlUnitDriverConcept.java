package com.qa.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;

public class HtmlUnitDriverConcept {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new HtmlUnitDriver();
		
//		System.setProperty("webdriver.chrome.driver","E:/My Backups/chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
		
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://classic.crmpro.com");
		
		driver.findElement(By.name("username")).sendKeys("aravindhmurugan");
		driver.findElement(By.name("password")).sendKeys("welcome1");
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("intercom-borderless-frame");
		
		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'intercom-chat-card-author')]"))).build().perform();
		
		driver.findElement(By.xpath("//div[contains(@class,'intercom-borderless-dismiss-button')]//span")).click();
		
		System.out.println("Title before login is: " + driver.getTitle());
		

		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(2000);
		
		System.out.println("Title after login is: " + driver.getTitle());

	}

}
