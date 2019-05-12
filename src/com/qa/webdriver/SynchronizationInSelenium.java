package com.qa.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SynchronizationInSelenium {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "E:/My Backups/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
		
		WebElement lastname = driver.findElement(By.name("lastname"));
		
		WebElement mobileno = driver.findElement(By.name("reg_email__"));
		
		WebElement password = driver.findElement(By.name("reg_passwd__"));
		
	    WebElement gender = driver.findElement(By.xpath("//input[@name = 'sex' and @value = 2]"));
		
        WebElement signupbtn = driver.findElement(By.name("websubmit"));
        
        send(driver, firstname, 10, "Tom");
        
        send(driver, lastname, 5, "Jerry");
        
        send(driver, mobileno, 10, "7897894654");
        
        send(driver, password, 5, "murugan");
        
        Clickon(driver, gender, 15);
        
        Clickon(driver, signupbtn, 10);
	}
	
		public static void send(WebDriver driver, WebElement element, int timeout, String value) {
			
			new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(element));
			
			element.sendKeys(value);
			
		}
	
	
		public static void Clickon(WebDriver driver, WebElement element, int timeout) {
			
			new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();
			
		}

}
