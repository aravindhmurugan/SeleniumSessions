package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","E:/My Backups/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/"); 
	}
	
	@Test(priority=5,groups="title")
	public void googletitletest() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Google123", "Title not matched");
	}
	
	@Test(priority=6,groups="logo")
	public void googlelogotest() {
		boolean b = driver.findElement(By.id("hplogo")).isDisplayed();
//		Assert.assertTrue(b);
		Assert.assertEquals(b, true);
	}
	
	@Test(priority=3,groups="link")
	public void maillinktest() {
		boolean c = driver.findElement(By.linkText("Gmail")).isDisplayed();
		Assert.assertFalse(c);
	}
	
	@Test(priority=2,groups="Test")
	public void test1() {
		System.out.println("test1");
	}
	
	@Test(priority=1,groups="Test")
	public void test2() {
		System.out.println("test2");
	}
	
	@Test(priority=4,groups="Test")
	public void test3() {
		System.out.println("test3");
	}
	
	@AfterMethod
	public void testDown() {
		driver.quit();
	}
	
}
