package com.qa.webdriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewPropFile {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = null;
		
		Properties prop = new Properties();
		
		FileInputStream ip = new FileInputStream("E:\\Selenium\\Workspace\\SeleniumSessions\\src\\com\\qa\\webdriver\\Config.properties");
		
		prop.load(ip);
		
		System.out.println(prop.getProperty("name"));
		
		String URL1 = prop.getProperty("url");
		
		System.out.println(URL1);
		
		String age1 = prop.getProperty("age");
		
		System.out.println(age1);
		
		String BROWSER = prop.getProperty("browser");
		
		if(BROWSER.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","E:/My Backups/chromedriver.exe");
			driver = new ChromeDriver();
		} else if(BROWSER.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver","E:/My Backups/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(URL1);
		
		driver.findElement(By.xpath(prop.getProperty("Fullname_xpath"))).sendKeys(prop.getProperty("name"));
		
		driver.findElement(By.xpath(prop.getProperty("Rediffmail_xpath"))).sendKeys(prop.getProperty("Rediffmail"));
		
	}

}
