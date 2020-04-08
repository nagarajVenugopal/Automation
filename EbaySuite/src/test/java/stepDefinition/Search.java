package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import library.Log;
import library.PropertyReader;
import library.Scrolling;
import library.TestBase;
import library.Waits;



public class Search extends TestBase{
	
	//private AndroidDriver<AndroidElement> driver;
	private Waits wait;
	private Log log;
	
	
 public Search() throws IOException {
	 
	 //driver = DriverManagement.getInstance(propertyObj.getProperty("PlatForm"),propertyObj.getProperty("App_Path"));
     wait = new Waits();
     log = new Log(Login.class);
     
     /*
  	 * loading login page locators  properties    
  	 */
  	
  	objectRepository = new PropertyReader();
  	log.info("Loading Object Property file");
 	objectRepository.loadPropertyFile(propertyObj.getProperty("Locator_Path"));
 	
}
 
 
 
 /*
	 * User checks if already Logged into an application  
	 *
	 */
	
 
 
 @Given("^User already login to Amazon app$")
 public void user_already_login_to_Amazon_app() throws Throwable {
   
 try
 {
	
if(driver.findElement(By.id(objectRepository.getObjectPropertyValue("HomePage_Label"))).isDisplayed())
	log.info("User already log into an application");
	 
 }
 
 catch(Exception e)
 {
	
	 	
		wait.waitForGivenTime(30);
		log.info("User is log into application");
		if (driver.findElement(By.xpath(objectRepository.getObjectPropertyValue("Sign_In_Button"))).isDisplayed())
		{
			driver.findElement(By.xpath(objectRepository.getObjectPropertyValue("Sign_In_Button"))).click();
		}
		wait.waitForGivenTime(30);
		
		
		log.info("Enter UserName and Password into application");
		driver.findElement(By.id(objectRepository.getObjectPropertyValue("Username_TextBox"))).sendKeys(objectRepository.getObjectPropertyValue("Username_Value"));
		// Enter Username
		wait.waitForGivenTime(15);
		
		driver.findElement(By.xpath(objectRepository.getObjectPropertyValue("Username_Button"))).click();
		
		wait.waitForGivenTime(10);
		driver.findElement(By.xpath(objectRepository.getObjectPropertyValue("Password_TextBox"))).clear();
		wait.waitForGivenTime(3);
		driver.findElement(By.xpath(objectRepository.getObjectPropertyValue("Password_TextBox"))).sendKeys(objectRepository.getObjectPropertyValue("Password_Value"));// Enter Password
		driver.findElement(By.xpath(objectRepository.getObjectPropertyValue("Password_Button"))).click();
		wait.waitForGivenTime(30);
		log.info("User log in into application Sucessfully");
 }
 
 
 }
 
 
 
 
 
 /*
	 * User Search for the Product 
	 * Parameter is Product Name retrieved from Feature Step
	 *
	 */
	

 @Then("^enter \"([^\"]*)\" Product name in Search Box$")
 public void enter_Product_name_in_Search_Box(String arg1) throws Throwable {
   
	 wait.waitForGivenTime(20);
	 if (driver.findElement(By.xpath(objectRepository.getObjectPropertyValue("Close_Popup"))).isDisplayed())
			driver.findElement(By.xpath(objectRepository.getObjectPropertyValue("Close_Popup"))).click();

	 driver.findElement(By.xpath(objectRepository.getObjectPropertyValue("Search_TextBox"))).sendKeys(arg1);
	 wait.waitForGivenTime(7);
		
 }
 
 
 	/*
	 * User Navigates to Product Listing Page  
	 *
	 */
	 
 

 @Then("^click on Search in Search page$")
 public void click_on_Search_in_Search_page() throws Throwable {
  
 
	 ((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		
		wait.waitForGivenTime(20);

 }

 
 
 

	/*
	 * User Navigates to Product Detail Page  
	 *
	 */

 @Then("^check User is in Product detail page$")
 public void check_User_is_in_Product_detail_page() throws Throwable {
  
 
	 wait.waitForGivenTime(20);
	 String Actualtext = driver.findElement(By.xpath(objectRepository.getObjectPropertyValue("ProductName_Title"))).getText();

		System.out.println("Actualtext=" + Actualtext);
		driver.findElement(By.xpath(objectRepository.getObjectPropertyValue("ProductName_Image_Click"))).click();

		wait.waitForGivenTime(40);
		

		if (driver.findElement(By.xpath(objectRepository.getObjectPropertyValue("Close_Popup"))).isDisplayed())
			driver.findElement(By.xpath(objectRepository.getObjectPropertyValue("Close_Popup"))).click();

		String Expectedtext = driver.findElement(By.xpath(objectRepository.getObjectPropertyValue("Product_Title_PDP"))).getText();

		System.out.println("Expectedtext=" + Expectedtext);

		// Assert.assertEquals(Expectedtext, Actualtext);

		System.out.println("Actual subtext=" + Actualtext.substring(0, 8) + "Expected subtext="
				+ Expectedtext.substring(0, 8));

		if (!(Actualtext.substring(0,8)).contains(Expectedtext.substring(0,5)))

			throw new Exception("actual not equal to expected");

 
 }

 
 
	/*
	 * User Scrolls to mid of the product and change Screen Orientation  
	 *
	 */
 
 
 
 @Then("^user scroll to the mid of the product$")
 public void user_scroll_to_the_mid_of_the_product() throws Throwable 
 {
 
	 
	 
	 int i=1;
 while(true)
 {		i++;
 Scrolling scr=new Scrolling();
 scr.verticalScroll();
 wait.waitForGivenTime(3);
 
 if(i>3)
	 break;
 
 
 }
 wait.waitForGivenTime(20);
 driver.findElement(By.xpath(objectRepository.getObjectPropertyValue("Mid_ProductName_Image_Click"))).click();

 wait.waitForGivenTime(20);
 if (driver.findElement(By.xpath(objectRepository.getObjectPropertyValue("Close_Popup"))).isDisplayed())
		driver.findElement(By.xpath(objectRepository.getObjectPropertyValue("Close_Popup"))).click();


 /*
  * Change Screen Orientation
  * 
  */
 wait.waitForGivenTime(20);
 ScreenOrientation sr=driver.getOrientation();
 
 driver.rotate(sr.LANDSCAPE);
 
 wait.waitForGivenTime(20);
 driver.rotate(sr.PORTRAIT);
  
 
 
 }

 
 

}
	

