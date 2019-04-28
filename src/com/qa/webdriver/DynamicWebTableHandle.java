package com.qa.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DynamicWebTableHandle {

	private static int i;

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
		
		Thread.sleep(7000);
		
		driver.switchTo().frame("intercom-borderless-frame");
		
		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'intercom-chat-card-author')]"))).build().perform();
		
		Thread.sleep(1000);
	
		driver.findElement(By.xpath("//div[contains(@class,'intercom-borderless-dismiss-button')]//span")).click();
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.switchTo().frame("mainpanel");
		
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		
		////*[@id='vContactsForm']/table/tbody/tr[5]/td[2]/a
		
//		String Before_xpath="//*[@id='vContactsForm']/table/tbody/tr[";
//		String After_xpath="]/td[2]/a";
		
//		for (i=5; i<=7; i++) {
			
//			String name = driver.findElement(By.xpath(Before_xpath+i+After_xpath)).getText();
			
//			System.out.println(name);
		
//		if(name.equals("vetri vel")) {
			
//			driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr["+i+"]/td[1]/input[@type='checkbox']")).click();
//		}
//	}
		
		driver.findElement(By.xpath("//a[contains(text(),'Marvel studio')]/parent::td//preceding-sibling::td//input[@type='checkbox']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'vetri vel')]/parent::td//preceding-sibling::td//input[@type='checkbox']")).click();
		
	}
}
