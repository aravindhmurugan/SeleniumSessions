package com.qa.webdriver;

import org.openqa.selenium.By;

public class XpathGen {

	public static void main(String[] args) {
		
		String x1 = CreateXpath("//input[@id='{0}']","test");
		System.out.println(x1);
		
		String x2 = CreateXpath("//input[@id='{0}'] and //input[@name='{1}']","email","username");
		System.out.println(x2);
		
		String x3 = CreateXpath("//input[@id='{0}'] and //input[@name='{1}'] and //input[@type='{2}']","email","username","text");
		System.out.println(x3);
		
		System.out.println(email.toString().substring(email.toString().indexOf("//")));
		
	}
	
	public static By email = By.xpath(CreateXpath("//input[@name='{0}']", "murugan"));	
	
	public static String CreateXpath(String xpathExp, Object...args) {
		for(int i = 0; i<args.length; i++) {
		xpathExp = xpathExp.replace("{" + i + "}", (CharSequence) args[i]);
	}
	return xpathExp;
}
}
