package com.qa.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandle {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "E:/Selenium/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));
		
//		Select select = new Select(day);
//		select.selectByVisibleText("24");
		
//		Select select1 = new Select(month);
//		select1.selectByVisibleText("Jun");
		
//		Select select2 = new Select(year);
//		select2.selectByVisibleText("2019");
		
		String date = "19-Nov-2019";
		
		String dobArr[] =  date.split("-");	
		
		dropdownhandle(day, dobArr[0]);
		dropdownhandle(month, dobArr[1]);
		dropdownhandle(year, dobArr[2]);
		
		
	}
	
	public static void dropdownhandle(WebElement Element, String value) {
		Select select = new Select(Element);
		select.selectByVisibleText(value);
	}

}
