package com.test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader1;

public class TestUtil {
	
	static Xls_Reader1 reader;
	
	public static ArrayList<Object[]> getdatafromexcel(){
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try {
			
			reader = new Xls_Reader1("E:\\Selenium\\Workspace\\SeleniumSessions\\src\\com\\testdata\\Yahootestdata.xlsx");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		for (int rownum = 2; rownum<=reader.getRowCount("TestData"); rownum++){
			
			String firstname = reader.getCellData("Testdata", "Firstname", rownum);
			
			String Lastname = reader.getCellData("Testdata", "Lastname", rownum);
			
			String emailaddress = reader.getCellData("Testdata", "emailaddress", rownum);
			
			String Password = reader.getCellData("Testdata", "Password", rownum);
			
			String Mobileno = reader.getCellData("Testdata", "Mobileno", rownum);
			
			String BirthMonth = reader.getCellData("Testdata", "BirthMonth", rownum);
			
			String Day = reader.getCellData("Testdata", "Day", rownum);
			
			String Year = reader.getCellData("Testdata", "Year", rownum);

			String Gender = reader.getCellData("Testdata", "Gender", rownum);
			
			Object ob[] = {firstname,Lastname,emailaddress,Password,Mobileno,BirthMonth,Day,Year,Gender};
			
			myData.add(ob);
		}
		
		return myData;
			
		}
		
	}
	
	
	
	
