package resources;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import io.cucumber.java.Before;

public class AppHooks {

	FileReader reader;
	public static Properties prop;

	@Before(order = 0)
	public void getProperty() throws IOException {
		String userDirPath = System.getProperty("user.dir");
		reader=new FileReader(userDirPath + "\\src\\test\\java\\resources\\GlobalProperties.properties");  	      
		prop=new Properties();  
		prop.load(reader);  
	}


}
