package com.utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Utility {
	
	public static String ReadProperty(String key) throws IOException {
		FileReader fr = new FileReader("config.properties");
		Properties p = new Properties();
		p.load(fr);
		return p.getProperty(key);
	}
	
	
}
