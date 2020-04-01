package library;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsActions;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;



public class Scrolling extends TestBase {
	
	//public AndroidDriver<AndroidElement> driver ;
	private Waits wait;
	private Log log;
	public Scrolling() throws IOException {
		// TODO Auto-generated constructor stub
		//driver = DriverManagement.getInstance(propertyObj.getProperty("PlatForm"),propertyObj.getProperty("App_Path"));
		  //driver = DriverManagement.getInstance(propertyObj.getProperty("PlatForm"),propertyObj.getProperty("App_Path"));
		wait = new Waits();
		log = new Log(Scrolling.class);
	}
	
	
	
	

    /*
     * To work it, addinng static method for scroll which will scroll to specific amount
     */
    
    public void verticalScroll()
    {
    	    log.info("This is static scroll,it will scroll till given cordinates");
    	    Dimension dimensions = driver.manage().window().getSize();
    	    int height = dimensions.getHeight();
    	    int width = dimensions.getWidth();
    	    // x will be same 
    	    int x = width/2;
    	    int startY = (int)(height*0.80);
    	    int endY = (int)(height*0.20);
    	    
    	    TouchAction action = new TouchAction(driver);
    	    action.press(PointOption.point(x, startY)).waitAction().moveTo(PointOption.point(x, endY)).release().perform();
     }
    
    
    
    public void scrollUp()
    {

	    Dimension dimensions = driver.manage().window().getSize();
	    int height = dimensions.getHeight();
	    int width = dimensions.getWidth();
	    // x will be same 
	    int x = width/2;
	    int startY = (int)(height*0.80);
	    int endY = (int)(height*0.20);
	    
	    TouchAction action = new TouchAction(driver);
	    action.press(PointOption.point(x, endY)).waitAction().moveTo(PointOption.point(x, startY)).release().perform();
    	
    }
    
  
//    public void scrollToElement(String elementName, boolean scrollDown){
//    	String listID = ((RemoteWebElement) driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.ListView\")")).getId();
//    	String direction;
//    	if (scrollDown) {
//    		direction = "down";
//    	} else {
//    		direction = "up";
//    	}
//    	HashMap<String, String> scrollObject = new HashMap<String, String>();
//    	scrollObject.put("direction", direction);
//    	scrollObject.put("element", listID);
//    	scrollObject.put("text", elementName);
//    	driver.executeScript("mobile: scrollTo", scrollObject);
//    }
    
    public void singleTap(AndroidElement element)
    {
    	log.info("Single tap on  element");
    	TouchAction action = new TouchAction(driver);
    	action.tap(tapOptions().withElement(element(element))).perform();


    }
    public void longPress(AndroidElement element,int time)
    {
    	log.info("Long press on element");
    	TouchAction action = new TouchAction(driver);
    	action.longPress(longPressOptions().withElement(element(element)).withDuration(ofSeconds(time))).release().perform();
    }
    
    public void swipe(AndroidElement fromElement,AndroidElement toElement)
    {
    	//Use long press first
    	TouchAction action = new TouchAction(driver);
    	log.info("swipping to given element");
    	action.longPress(longPressOptions().withElement(element(fromElement)).withDuration(ofSeconds(2))).moveTo(element(toElement)).release().perform();
    }

}
