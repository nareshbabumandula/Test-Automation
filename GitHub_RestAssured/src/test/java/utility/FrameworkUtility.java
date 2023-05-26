package utility;

import java.io.FileInputStream;
import java.util.Properties;

import resources.LinkConstants;

public class FrameworkUtility {
	
	public static Properties properties;

	public static String readConfigurationFile(String key) {
		try{
			properties = new Properties();
			properties.load(new FileInputStream(LinkConstants.PropertiesFilePath));
		} catch (Exception e){
			System.out.println("Cannot find key: "+key+" in Config file due to exception : "+e);
		}
		return properties.getProperty(key).trim();	
	}
		
	
}
