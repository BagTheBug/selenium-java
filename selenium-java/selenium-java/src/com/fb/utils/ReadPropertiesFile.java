package com.fb.utils;

import java.io.*;
import java.util.*;

public class ReadPropertiesFile {

	static String result = "";
	public static FileInputStream inputStream;

	public static String getPropValue(String wantedPropertyValue) throws IOException {

		try {
			Properties prop = new Properties();
			String propFileName = "TestData.properties";

			inputStream = new FileInputStream(new File(propFileName));
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("Property File '" + propFileName + "' not found in the classpath");
			}

			result = prop.getProperty(wantedPropertyValue);

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
	}

	
}
