package library;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DriverManagement extends TestBase {
	
	public static AndroidDriver<AndroidElement> driver = null;
	private Log log;
	private DriverManagement() throws MalformedURLException {
		// TODO Auto-generated constructor stub
		log = new Log(DriverManagement.class);
	}
	
	
   public static AndroidDriver<AndroidElement> getInstance(String device,String App_Path) throws MalformedURLException
   {
	   
	   if(driver==null)
	   {
		   /*
		    * it will start appium
		    */
		   
		 //  AppiumSetUp setup = new AppiumSetUp();
		 //  setup.startAppiumServer(4723);
		   DesiredCapabilities caps =capabilties(device,App_Path);
		   driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		   
		   //0.0.0.0:4723
	   }
	   
	   return driver;
   }
	

}
