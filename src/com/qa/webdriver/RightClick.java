package com.qa.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {

	public static void main(String[] args) {
		
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "E:/My Backups/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		Actions action = new Actions(driver);
		
		WebElement rightclickbtn = driver.findElement(By.cssSelector(".context-menu-one"));
		
		action.contextClick(rightclickbtn).build().perform();
		
		WebElement copytbtn = driver.findElement(By.cssSelector(".context-menu-icon-copy"));
		
		String copytext = copytbtn.getText();
		
		System.out.println(copytext);
		
		copytbtn.click();

	}

}
