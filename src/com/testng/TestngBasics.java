package com.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngBasics {
	
	@BeforeSuite
	public void setUp() {
		System.out.println("@BeforeSuite--Set up system property for chrome");
	}
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("@BeforeTest--launchBrowser");
	}
	
	@BeforeClass
	public void login() {
		System.out.println("@BeforeClass--login to app");
	}
	
	@BeforeMethod
	public void enterURL() {
		System.out.println("@BeforeMethod--enterURL");
	}
	
	@Test
	public void googletitletest() {
		System.out.println("@Test--google title test");
	}
	
	@Test(enabled=false)
	public void searchTest() {
		System.out.println("@Test--search Test");
	}
	
	@Test
	public void googlelogotest() {
		System.out.println("@Test--google logo test");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("@AfterMethod--logout from app");
	}
	
	@AfterClass
	public void closebrowser() {
		System.out.println("@AfterClass--close the browser");
	}

	@AfterTest
	public void deleteallcookies() {
		System.out.println("@AfterTest--delete all cookies");
	}

}
