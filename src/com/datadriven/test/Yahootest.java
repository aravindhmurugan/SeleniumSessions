package com.datadriven.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility .TestUtil;

public class Yahootest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver","E:/My Backups/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://login.yahoo.com/account/create?authMechanism=primary&done=https%3A%2F%2Fin.yahoo.com%2F&eid=100&add=1&src=fpctx&intl=in&lang=en-IN&specId=yidReg");
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData(){
		ArrayList<Object[]> testData = TestUtil.getdatafromexcel();
		return testData.iterator();
		
	}
	
	@Test(dataProvider="getTestData",priority=1)
	public void yahooregpagetest (String firstname,String Lastname,String emailaddress,String Password,String Mobileno,String BirthMonth,String Day,
			String Year,String Gender) {
		
		driver.findElement(By.id("usernamereg-firstName")).clear();
		driver.findElement(By.id("usernamereg-firstName")).sendKeys(firstname);
		
		driver.findElement(By.id("usernamereg-lastName")).clear();
		driver.findElement(By.id("usernamereg-lastName")).sendKeys(Lastname);
		
		driver.findElement(By.id("usernamereg-yid")).clear();
		driver.findElement(By.id("usernamereg-yid")).sendKeys(emailaddress);
		
		driver.findElement(By.id("usernamereg-password")).clear();
		driver.findElement(By.id("usernamereg-password")).sendKeys(Password);
		
		driver.findElement(By.id("usernamereg-phone")).clear();
		driver.findElement(By.id("usernamereg-phone")).sendKeys(Mobileno);
		
		Select select = new Select(driver.findElement(By.id("usernamereg-month")));
		select.selectByVisibleText(BirthMonth);
		
		driver.findElement(By.id("usernamereg-day")).clear();
		driver.findElement(By.id("usernamereg-day")).sendKeys(Day);
		
		driver.findElement(By.id("usernamereg-year")).clear();
		driver.findElement(By.id("usernamereg-year")).sendKeys(Year);
		
		driver.findElement(By.id("usernamereg-freeformGender")).clear();
		driver.findElement(By.id("usernamereg-freeformGender")).sendKeys(Gender);
		
	}
	
	
	@AfterMethod
		public void tearDown() {
		driver.quit();
	}
	
}
