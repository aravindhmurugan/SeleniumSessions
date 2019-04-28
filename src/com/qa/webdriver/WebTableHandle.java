package com.qa.webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader1;


public class WebTableHandle {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","E:/My Backups/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		//Company
		
		//div//table[@id='customers']//tbody//tr[2]//td[1]
		//div//table[@id='customers']//tbody//tr[3]//td[1]
		//div//table[@id='customers']//tbody//tr[4]//td[1]
		
		//Contact
		
		//div//table[@id='customers']//tbody//tr[2]//td[2]
		//div//table[@id='customers']//tbody//tr[3]//td[2]
		//div//table[@id='customers']//tbody//tr[4]//td[2]
		
		//Country
		//div//table[@id='customers']//tbody//tr[2]//td[3]
		//div//table[@id='customers']//tbody//tr[3]//td[3]
		//div//table[@id='customers']//tbody//tr[4]//td[3]
		
		
		String Before_Xpath_Company="//div//table[@id='customers']//tbody//tr[";
		String After_Xpath_Company="]//td[1]";
		
		String Before_Xpath_Contact="//div//table[@id='customers']//tbody//tr[";
		String After_Xpath_Contact="]//td[2]";
		
		String Before_Xpath_Country="//div//table[@id='customers']//tbody//tr[";
		String After_Xpath_Country="]//td[3]";
		
		List<WebElement> rows = driver.findElements(By.xpath("//div//table[@id='customers']//tbody//tr"));
		
		System.out.println("Number of rows: " + (rows.size()-1));
		
		int rowcount = rows.size();		
		
		Xls_Reader1 reader = new Xls_Reader1("E:\\Selenium\\Workspace\\SeleniumSessions\\src\\com\\testdata\\FreeCrmTestData.xlsx");
		
		if(!reader.isSheetExist("TableData")) {
			
			reader.addSheet("TableData");
			reader.addColumn("TableData", "CompanyName");
			reader.addColumn("TableData", "ContactName");
			reader.addColumn("TableData", "CountryName");
		}
		
		for (int i = 2; i <=rowcount; i++) {
			
			String actual_xpath_Company = Before_Xpath_Company+i+After_Xpath_Company;
			
			String companyName = driver.findElement(By.xpath(actual_xpath_Company)).getText();
			
			System.out.println(companyName);
			
			reader.setCellData("TableData", "CompanyName", i, companyName);
			
			String actual_xpath_Contact = Before_Xpath_Contact+i+After_Xpath_Contact;
			
			String contactName = driver.findElement(By.xpath(actual_xpath_Contact)).getText();
			
			System.out.println(contactName);
			
			reader.setCellData("TableData", "ContactName", i, contactName);
			
			String actual_xpath_Country = Before_Xpath_Country+i+After_Xpath_Country;
			
			String countryName = driver.findElement(By.xpath(actual_xpath_Country)).getText();
			
			System.out.println(countryName);
			
			reader.setCellData("TableData", "CountryName", i, countryName);
			
		}
			
	}

}
