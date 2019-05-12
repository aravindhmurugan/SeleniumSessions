package com.qa.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;

public class ExtraLocators {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:/My Backups/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com");
		
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
//		driver.findElement(new ByAll(By.id("u_0_j123"), By.name("firstname123"), By.xpath("//input[@name='firstname']"))).sendKeys("Murugan");
		
//		driver.findElement(new ByIdOrName("u_0_j")).sendKeys("kanthan");
		
		driver.findElement(new ByChained(By.xpath("//div[@id='u_0_i']"),
				
		By.xpath("//div[@class='uiStickyPlaceholderInput uiStickyPlaceholderEmptyInput']"),
		
		By.name("firstname"))).sendKeys("kathirvela");
		

	}

}
