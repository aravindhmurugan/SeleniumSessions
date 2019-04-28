package com.qa.webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapDropHandlebox {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","E:/My Backups/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		
		driver.findElement(By.xpath("//button[contains(@type,'button')]")).click();
		
		List <WebElement> lists =  driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']//li//a//label"));
		
//		driver.findElement(By.xpath("//button[@type='button']")).click();
		
//		List <WebElement> lists =  driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']//li//label[@class='checkbox']//input[@type='checkbox']"));
		
		System.out.println(lists.size());
		
//		for(int i = 0;i<lists.size();i++) {
//			System.out.println(lists.get(i).getText());
//			lists.get(i).click();
			
//		}
		 
		for (int i = 0;i<lists.size();i++) {
			System.out.println(lists.get(i).getText());
			if(lists.get(i).getText().contains("Angular")) {
				lists.get(i).click();
				break;
			}
			}
			
		}
	}


