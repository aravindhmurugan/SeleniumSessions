package com.qa.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuth {

	public static void main(String[] args) {
		
	WebDriver driver;		
		
	System.setProperty("webdriver.chrome.driver", "E:/My Backups/chromedriver.exe");
	
	driver = new ChromeDriver();
	
	driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
	
	String pagemessage = driver.findElement(By.cssSelector("p")).getText();
	
	System.out.println(pagemessage);

	}

}
