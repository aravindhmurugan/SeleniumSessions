package com.qa.webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDown_Part3 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:/Selenium/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		List<WebElement> month_xpath = driver.findElements(By.xpath("//select[@id='month']//option"));
		
		List<WebElement> day_xpath = driver.findElements(By.xpath("//select[@id='day']//option"));
		
		List<WebElement> year_xpath = driver.findElements(By.xpath("//select[@id='year']//option"));
		
		System.out.println(month_xpath.size());
		
		selectmonthdropdown(month_xpath, "Nov");
		selectmonthdropdown(day_xpath, "19");
		selectmonthdropdown(year_xpath, "2018");
			
		}
			

		public static void selectmonthdropdown(List<WebElement> monthxpath, String value) {
		
			for(int i = 0; i<monthxpath.size(); i++) {
		
		String monthlist = monthxpath.get(i).getText();
		
		System.out.println(monthlist);
		
		if(monthlist.equals(value)) {
			
			monthxpath.get(i).click();
			
			break;
		}
		
			}	
		

	}
}
