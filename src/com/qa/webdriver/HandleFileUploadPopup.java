package com.qa.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFileUploadPopup {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:/My Backups/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://html.com/input-type-file/");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//div[@class='pm-footer']//a[@class='pm-cta']")).click();
		
		driver.findElement(By.xpath("//input[contains(@value,'fileupload')]")).sendKeys("E:/Folders/Others-Project/Waterquenching/hardness.xlsx");

	}

}
