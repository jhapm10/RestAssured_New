package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	public Properties prop;

	public TestBase() {

		try {

			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "src/main/java/com/qa/configuration/GlobalConfig.properties");

			prop = new Properties();
			prop.load(file);
			System.out.println(prop.getProperty("systemURL"));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
