package com.qa.webdriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BrokenLinkList {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {

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
		
		List<WebElement> Linklist = driver.findElements(By.tagName("a"));
		
		Linklist.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("Full links and images " + Linklist.size());
		
		List<WebElement> activelinks = new ArrayList<WebElement>();
		
		//Iterating for active links 
		
		for(int i = 0;i<Linklist.size();i++) {
			if(Linklist.get(i).getAttribute("href")!=null && (!Linklist.get(i).getAttribute("href").contains("javascript"))){
				activelinks.add(Linklist.get(i));
				
			}
			
		}
		
		System.out.println("Total number of active links: " +activelinks.size());
		
		for(int j = 0;j<activelinks.size();j++) {
			 
			HttpURLConnection connection = (HttpURLConnection)new URL(activelinks.get(j).getAttribute("href")).openConnection();
			
			connection.connect();
			
			String response = connection.getResponseMessage();
			
			System.out.println(activelinks.get(j).getAttribute("href") + "------>" + response);
			
		}
		

	}

}
