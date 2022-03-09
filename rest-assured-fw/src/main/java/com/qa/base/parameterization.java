package com.qa.base;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class parameterization {
	public FileInputStream file;
	// public HSSFCell Uname, Password, Email, Telephone, Last_Name, Telephone1;
	public FileInputStream fis;
	public HSSFWorkbook workbook;
	public HSSFSheet sheet;
	public HSSFRow row;
	public String First_Name, LastName, SPassword, SEmail, STelephone, STelephone1;

	@DataProvider()
	public String[][] getData1() throws IOException {

		fis = new FileInputStream("TestData\\file_example_XLS_50.xls");
		workbook = new HSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);
		int Rows = sheet.getLastRowNum() + 1;
		HSSFRow row = sheet.getRow(0);
		int colNum = row.getLastCellNum();
		First_Name = sheet.getRow(1).getCell(0).toString();
		System.out.println("Count of Row" + Rows);
		System.out.println("Count of column" + colNum);

		// Object[][] data = new Object[Rows][colNum]; // iterate 3 times and 2
		// values(id and pass) ...array of 3 rows 2 column multi d array
		int i, j;
		String[][] data = new String[Rows][colNum];

		for (i = 0; i <= Rows - 1; i++) {

			for (j = 0; j <= colNum - 1; j++) {
				data[i][j] = sheet.getRow(i).getCell(j).toString();
//				 First_Name = sheet.getRow(i).getCell(j).toString();
//				 System.out.print(First_Name);
//				 System.out.println();
			}
		}
		return data;
	}

	@Test(enabled = true, dataProvider = "getData1")

	void AddFakeData(String ID, String pas) {
		RestAssured.baseURI = "http://localhost:3000/";
		JSONObject jb = new JSONObject();
		jb.put("name", ID);
		jb.put("id", pas);
		given().header("content-type", "application/json").body(jb.toJSONString()).when().post("employee").then()
				.statusCode(201);
	}
}
