package com.qa.webdriver;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Imagedisabledoptions {

	public static void main(String[] args) {
	 
//		System.setProperty("webdriver.chrome.driver", "E:/Selenium/chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		disableImageChrome(options);
//		WebDriver driver = new ChromeDriver(options);
		
		System.setProperty("webdriver.gecko.driver", "E:/My Backups/geckodriver.exe");
		
		FirefoxOptions options = new FirefoxOptions();
		
		disableImagefirefox(options);
		
		WebDriver driver = new FirefoxDriver(options);
	
		driver.get("http://www.amazon.com");
		
		System.out.println(driver.getTitle());

	}
	
	
	
	public static void disableImageChrome(ChromeOptions options) {
		HashMap<String, Object> Images = new HashMap <String, Object>();
		Images.put("images", 2);
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values", Images);
		options.setExperimentalOption("prefs", prefs);
		
	}
	
	public static void disableImagefirefox(FirefoxOptions options) {
		
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("permissions.default.image", 2);
		options.setProfile(profile);
		options.setCapability(FirefoxDriver.PROFILE, profile);
		
	}
	
	

}
