package com.Test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestData {

	@DataProvider(name ="pincodes_data")
	public String[][] pincodesData() throws IOException {
		
       //Code to read excel file using Apache POI
		String baseDir=System.getProperty("user.dir");// Current working directory cwd
		FileInputStream fis=new FileInputStream(baseDir+"/src/test/resources/Pincodes_data.xlsx");
		XSSFWorkbook book=new XSSFWorkbook(fis);
		XSSFSheet sheet=book.getSheet("pins");
		String[][] pincodes = new String[sheet.getLastRowNum()][1];
		for (int i = 1; i <=sheet.getLastRowNum(); i++) {
			XSSFRow row=sheet.getRow(i);
			XSSFCell cell=row.getCell(1);
			int pincode =(int) cell.getNumericCellValue();
			//Insert into an array
			pincodes[i-1][0]=pincode+"";
		}
		
		
		return pincodes;
	}
}
