package com.TS;

import org.testng.annotations.Test;

import com.Test.TestData;

public class ExcelDemo {
	
	
	@Test(dataProvider= "pincodes_data", dataProviderClass = TestData.class)
	public void myTestCase(String pincodes) {
		System.out.println(pincodes);
	}

}
