package com.qa.webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	private static int i;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","E:/My Backups/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("murugan");
		
		List <WebElement> list = driver.findElements(By.xpath("//div//ul[@role='listbox']//li/descendant::div[@role='option']"));
		
		System.out.println("Total items in list: "+list.size());
		
		for(i=0; i<list.size(); i++) {
			
			String name = list.get(i).getText();
			
			System.out.println(name);
			
			if(name.equals("murugan padam")) {
				
				list.get(i).click();
				
				break;
			}
		}

	}

}
