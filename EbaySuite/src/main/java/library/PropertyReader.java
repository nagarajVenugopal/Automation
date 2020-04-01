package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.springframework.util.SystemPropertyUtils;

import com.google.j2objc.annotations.Property;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class PropertyReader {
	
	
	private Properties propertyObj;
	AndroidDriver<AndroidElement> driver;
	private Log log;
	
    public PropertyReader() throws IOException {
		// TODO Auto-generated constructor stub
    	 propertyObj = new Properties();
    	 log = new Log(PropertyReader.class);
    	 //driver = DriverManagement.getInstance("real","");
    	 //loadPropertyFile(Path);
    
	}
    
    public void loadPropertyFile(String path) throws IOException
    {
    
     File ApplicationFile = new File(path);
   	 FileInputStream inputstream = new FileInputStream(ApplicationFile);
   	 propertyObj.load(inputstream);
    }
    
    public String getProperty(String key)
    {
    	/*
    	 * This will get propery file from given file
    	 */
    	log.info("Return property File path");
    	return getSystemPath() + String.valueOf(propertyObj.get(key));
    	
    	
    }
    
    public String getObjectPropertyValue(String objectName)
    {
    	return String.valueOf(propertyObj.get(objectName));
    	
    }
   
        
    public String getSystemPath()
    {
    	
    	return System.getProperty("user.dir");
    }
    
	
}
