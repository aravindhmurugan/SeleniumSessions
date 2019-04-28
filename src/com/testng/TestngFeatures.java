package com.testng;

import org.testng.annotations.Test;

public class TestngFeatures {
	
	@Test()
	public void login() {
		System.out.println("Login page");
		int i = 9/0;
	}
	
	@Test(dependsOnMethods="login")
	public void homepage() {
		System.out.println("home page");
	}
	
	@Test(dependsOnMethods="login")
	public void searchpage() {
		System.out.println("search page");
	}
	
}

