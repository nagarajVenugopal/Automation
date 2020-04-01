package library;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;;

public class Waits extends TestBase{

	//AndroidDriver<AndroidElement> driver;
	
	public Waits() throws IOException {
	
		// TODO Auto-generated constructor stub
		//It gets you instance of existing class
		//log = new Log(Waits.class);
		
		  //driver = DriverManagement.getInstance(propertyObj.getProperty("PlatForm"),propertyObj.getProperty("App_Path"));
		//driver = DriverManagement.getInstance(propertyObj.getProperty("PlatForm"),propertyObj.getProperty("App_Path"));
	}
	
	
	public void waitForGivenTime(int time)
	{
		//it will wait for given time
		//Time unit will be in seconds only
		log.info("waiting for "+ time+"  seconds");
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	/*
	 * Dynammic waits
	 */
	
	public void waitForGivenElement(int time,AndroidElement androidElement)
	{
		try {
		log.info("waiting till next element is visible");
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(androidElement));
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
