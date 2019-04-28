package com.qa.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CalendarSelect {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver","E:/My Backups/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://classic.crmpro.com");
		
		driver.findElement(By.name("username")).sendKeys("aravindhmurugan");
		driver.findElement(By.name("password")).sendKeys("welcome1");
		
		Thread.sleep(7000);
		
		driver.switchTo().frame("intercom-borderless-frame");
		
		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'intercom-chat-card-author')]"))).build().perform();
		
		Thread.sleep(1000);
	
		driver.findElement(By.xpath("//div[contains(@class,'intercom-borderless-dismiss-button')]//span")).click();
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.switchTo().frame("mainpanel");
		
		Thread.sleep(1000);
		
		String date = "May-24-2020";
		String[] DateArr = date.split("-");
		
		String month = DateArr[0];
		String day = DateArr[1];
		String year = DateArr[2];
		
		Select select = new Select(driver.findElement(By.name("slctYear")));
		
		select.selectByVisibleText(year);
		
		Select select1 = new Select(driver.findElement(By.name("slctMonth")));
		
		select1.selectByVisibleText(month);
		
		////div[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[4]/td[5]
		
		final int totalweekdays = 7;
		boolean flag = false;
		
		String Before_Xpath="//div[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String After_Xpath="]/td[";
		
		String dateval = null;
		
		for (int rownum=2; rownum<=7; rownum++) {
			for (int colnum=1; colnum<=totalweekdays; colnum++) {
		
			try{		
						
						dateval = driver.findElement(By.xpath(Before_Xpath+rownum+After_Xpath+colnum+"]")).getText();				
				
			}
			catch(NoSuchElementException e){
				
				System.out.println("Please enter a valid date");
				flag = false;
				break;
				
			}
			System.out.println(dateval);
			if(dateval.equals(day)) {
				
				driver.findElement(By.xpath(Before_Xpath+rownum+After_Xpath+colnum+"]")).click();
				flag = true;
				break;
			}
			
			if(flag) {
				break;
			}
			
		}
		

	}

}
}
