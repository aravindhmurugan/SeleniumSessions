package com.qa.webdriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopup {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver","E:/My Backups/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://www.popuptest.com/goodpopups.html");
		
		driver.findElement(By.linkText("Good PopUp #3")).click();
		
		Thread.sleep(2000);
		
		Set<String> Handler = driver.getWindowHandles();
		
		Iterator<String> it = Handler.iterator();
		
		String Parentwindowid = it.next();
		
		System.out.println("Parent window id is " + Parentwindowid);
		
		String Childwindowid = it.next();
		
		System.out.println("Child window id is " + Childwindowid);
		
		driver.switchTo().window(Childwindowid);
		
		Thread.sleep(2000);
		
	    System.out.println("Child window title: " + driver.getTitle());
	    
	    driver.close();
	    
	    driver.switchTo().window(Parentwindowid);
	    
	    Thread.sleep(2000);
	    
	    System.out.println("Parent window title: " + driver.getTitle());		

	}

}
