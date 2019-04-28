package com.qa.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;

public class Locators {

	public static void main(String[] args) throws InterruptedException {	
	
		System.setProperty("webdriver.chrome.driver","E:/My Backups/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.yahoo.com/account/"
				+ "create?authMechanism=primary&done=https%3A%2F%2Fin.yahoo.com"
				+ "%2F&eid=100&add=1&src=fpctx&intl=in&lang=en-IN&specId=yidReg");

//1.	xpath
		
//		driver.findElement(By.xpath("//*[@id='usernamereg-firstName']")).sendKeys("Murugan");
//		driver.findElement(By.xpath("//*[@id='usernamereg-lastName']")).sendKeys("Vetrivel");
		driver.findElement(By.xpath("//input[contains(@placeholder,'Day')]")).sendKeys("27");
		driver.findElement(By.xpath("//input[@id='usernamereg-year']")).sendKeys("1989");
			
		
//2. id
		
	driver.findElement(By.id("usernamereg-firstName")).sendKeys("jeyam");
//	driver.findElement(By.id("usernamereg-lastName")).sendKeys("Akash");
	
//3. name
	
	driver.findElement(By.name("yid")).sendKeys("aravindh.cts");
	
//4. class name
	
	driver.findElement(By.className("phone-no")).sendKeys("7894651231");
	
//5. css selector
	
	driver.findElement(By.cssSelector(".ureg-lname")).sendKeys("Akash");
	driver.findElement(By.cssSelector("#usernamereg-password")).sendKeys("test@123");
	driver.findElement(By.xpath("//input[@type='button']")).click();
	
//6. select
	
	Select select = new Select(driver.findElement(By.id("usernamereg-month")));
	select.selectByVisibleText("February");
	
//7. linktext:
	
	driver.findElement(By.linkText("Sign in")).click();
	Thread.sleep(2000);
	
//8. Partial linktext
	
	driver.findElement(By.partialLinkText("Difficulty")).click();
	Thread.sleep(2000);
		
	}

}
