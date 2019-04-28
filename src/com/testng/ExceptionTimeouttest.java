package com.testng;

import org.testng.annotations.Test;

public class ExceptionTimeouttest {
	
	
	@Test(invocationTimeOut=1000)
	public void infiniteloop() {
			int i =1;
			while(i==1) {
				System.out.println(i);
			}
	}
	
	@Test(expectedExceptions=NumberFormatException.class)	
	public void test1(){
		String x = "100A";
		Integer.parseInt(x);
		System.out.println(x);
	}
	
	
	

}
