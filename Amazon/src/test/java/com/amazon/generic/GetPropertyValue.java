package com.amazon.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetPropertyValue {
	static String FILE_SEPARATOR = File.separator;
	//static String FILE_PATH = System.getProperty("user.dir")+FILE_SEPARATOR+"config.properties";
	public static String getPropertyValue(String key){
		String value="";
		try{
		Properties prop = new Properties();
		prop.load(GetPropertyValue.class.getResourceAsStream("/config.properties"));
		value= prop.getProperty(key);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
}
