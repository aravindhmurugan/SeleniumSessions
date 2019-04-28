package com.qa.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class webdriverff {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver","E:\\Selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.spicejet.com/");
	
		System.out.println(driver.getTitle());
	}

}
