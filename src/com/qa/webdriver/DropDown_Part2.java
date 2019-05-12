package com.qa.webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class DropDown_Part2 {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "E:/Selenium/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));
		
		Select select = new Select(day);
		
		select.selectByIndex(10);
		
		System.out.println(select.isMultiple());
		
		List<WebElement> listdays = select.getOptions();
		
		System.out.println(listdays.size());
		
		int totaldays = listdays.size()-1;
		
		System.out.println(totaldays);
		
		for(int i = 0; i<totaldays; i++) {
			
			String dayval = listdays.get(i).getText();
			System.out.println(dayval);
			if(dayval.equals("19")) {
				listdays.get(i).click();
				break;
			}
			
		}

	}

}
