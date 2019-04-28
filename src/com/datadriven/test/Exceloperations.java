package com.datadriven.test;

import com.excel.utility.Xls_Reader1;

public class Exceloperations {

	public static void main(String[] args) {

		Xls_Reader1 reader=new Xls_Reader1("E:\\Selenium\\Workspace\\SeleniumSessions\\src\\com\\testdata\\Yahootestdata.xlsx");
		
		if(!reader.isSheetExist("Secondsheet")) {
		
		reader.addSheet("Secondsheet");
		
		}
		
		int colcount = reader.getColumnCount("TestData");
		
		System.out.println("Number of colums count is ======>" + colcount);
		
		System.out.println(reader.getCellRowNum("TestData", "Firstname", "vettrivel"));

	}

}
