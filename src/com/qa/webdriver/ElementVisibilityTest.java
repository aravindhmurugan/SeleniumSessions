package com.qa.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilityTest {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver","E:/My Backups/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://classic.crmpro.com/register/");
		
		boolean b = driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed();
		
		System.out.println(b);
		
		boolean b1 = driver.findElement(By.xpath("//button[@type='submit']")).isEnabled();
		
		System.out.println(b1);
		
		driver.findElement(By.name("agreeTerms")).click();
		
		boolean b2 = driver.findElement(By.xpath("//button[@type='submit']")).isEnabled();
		
		System.out.println(b2);
		
		boolean b3 = driver.findElement(By.name("agreeTerms")).isSelected();
		
		System.out.println(b3);
		
		driver.findElement(By.name("agreeTerms")).click();
		
		boolean b4 = driver.findElement(By.name("agreeTerms")).isSelected();
		
		System.out.println(b4);
		
	}

}
