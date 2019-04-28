package com.qa.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectCalendarByJS {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver","E:/My Backups/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.makemytrip.com/");
		
		Thread.sleep(2000);
		
		WebElement date = driver.findElement(By.xpath("//input[@id='departure']"));	
		
		String dateval = "Friday, 22 Mar 2019";
		
		SelectDateByJS (driver, date, dateval);

	}
	
	
	//input[@id='ctl00_mainContent_txt_Todate']
	
	////input[@id='ctl00_mainContent_view_date1']//input[@id='ctl00_mainContent_txt_Fromdate']//button[@type='button']//span
	
	
	public static void SelectDateByJS(WebDriver driver, WebElement element, String dateval) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].setAttribute('value','"+dateval+"');", element);
				
	}
	
}
