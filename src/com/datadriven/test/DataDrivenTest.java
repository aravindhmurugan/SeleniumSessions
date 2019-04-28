package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader1;

public class DataDrivenTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","E:/My Backups/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.yahoo.com/account/create?authMechanism=primary&done=https%3A%2F%2Fin.yahoo.com%2F&eid=100&add=1&src=fpctx&intl=in&lang=en-IN&specId=yidReg");
		driver.manage().window().maximize();
		
		Xls_Reader1 reader = new Xls_Reader1("E:\\Selenium\\Workspace\\SeleniumSessions\\src\\com\\testdata\\Yahootestdata.xlsx");
		
		int rowCount = reader.getRowCount("Testdata");
		
		reader.addColumn("TestData", "Status");
		
		for(int rownum = 2; rownum <= rowCount; rownum++) {
			
			System.out.println("============"); 
			
			String firstname = reader.getCellData("Testdata", "Firstname", rownum);
			System.out.println(firstname); 
			
			String Lastname = reader.getCellData("Testdata", "Lastname", rownum);
			System.out.println(Lastname); 
			
			String emailaddress = reader.getCellData("Testdata", "emailaddress", rownum);
			System.out.println(emailaddress); 
			
			String Password = reader.getCellData("Testdata", "Password", rownum);
			System.out.println(Password); 
			
			String Mobileno = reader.getCellData("Testdata", "Mobileno", rownum);
			System.out.println(Mobileno); 
			
			String BirthMonth = reader.getCellData("Testdata", "BirthMonth", rownum);
			System.out.println(BirthMonth); 
			
			String Day = reader.getCellData("Testdata", "Day", rownum);
			System.out.println(Day); 
			
			String Year = reader.getCellData("Testdata", "Year", rownum);
			System.out.println(Year); 
			
			String Gender = reader.getCellData("Testdata", "Gender", rownum);
			System.out.println(Gender); 
			
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
			
			reader.setCellData("TestData", "Status", rownum, "Pass");
			
		}
		
	}

}
