package com.qa.webdriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver","E:/My Backups/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://classic.crmpro.com");
		
		driver.findElement(By.name("username")).sendKeys("aravindhmurugan");
		driver.findElement(By.name("password")).sendKeys("welcome11");
		
		Thread.sleep(7000);
		
		driver.switchTo().frame("intercom-borderless-frame");
		
		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'intercom-chat-card-author')]"))).build().perform();
		
		Thread.sleep(1000);
	
		driver.findElement(By.xpath("//div[contains(@class,'intercom-borderless-dismiss-button')]//span")).click();
		
		WebElement loginbtn = driver.findElement(By.xpath("//input[@type='submit']"));
		
//		flash(loginbtn, driver);
		
//		drawBorder(loginbtn, driver);
		
//		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);	
		
//		FileUtils.copyFile(src, new File("\\E:\\Selenium\\Workspace\\SeleniumSessions\\freecrm.png"));
		
//		generateAlert(driver,"There is an issue in login page");
		
		clickElementByJS(loginbtn, driver);
		
//		refreshBrowserByJS(driver);
		
//		System.out.println(getTitleByJS(driver));
		
//		System.out.println(getPageInnerText(driver));
		
//		scrollPageDown(driver);
		
//		WebElement Forgotfwdlink = driver.findElement(By.xpath("//a[contains(text(),'Forgot Password?')]"));
		
//		scrollIntoView(Forgotfwdlink, driver);
	}

	public static void flash(WebElement element, WebDriver driver) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		String bgcolor = element.getCssValue("backgroundColor");
		
		for(int i = 0; i<100; i++) {
			changecolor("rgb(0,200,0)",element,driver);
			changecolor(bgcolor,element,driver);
		}
	}
		
		public static void changecolor(String color,WebElement element, WebDriver driver) {
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
			js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
	}
	
		public static void drawBorder(WebElement element, WebDriver driver) {
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
			js.executeScript("arguments[0].style.border = '3px solid red'", element);
			
		}
	
		public static void generateAlert(WebDriver driver, String message) {
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
			js.executeScript("alert('"+message+"')");
			
		}
		
		public static void clickElementByJS(WebElement element, WebDriver driver) {
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
			js.executeScript("arguments[0].click();", element);
		}
		
		public static void refreshBrowserByJS(WebDriver driver) {
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
			js.executeScript("history.go(0)");
		}
		
		public static String getTitleByJS(WebDriver driver) {
	
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
			String title = js.executeScript("return document.title;").toString();
			
			return title;
}
		public static String getPageInnerText(WebDriver driver) {
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
			String pageText = js.executeScript("return document.documentElement.innerText;").toString();
			
			return pageText;
			
		}
		
		public static void scrollPageDown(WebDriver driver) {
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		}
		
		public static void scrollIntoView(WebElement element, WebDriver driver) {
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		}
	
		}
		
		
