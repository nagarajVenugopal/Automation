package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.By;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import library.Log;
import library.PropertyReader;
import library.TestBase;
import library.Waits;

public class Login extends TestBase{
	
	//private AndroidDriver<AndroidElement> driver;
	private Waits wait;
	private Log log;
	
	
	
	
	
 public Login() throws IOException {
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
	 * User launches into  Sign Page  
	 *
	 */
	
	

@Given("^User login to Amazon app$")
public void user_login_to_Amazon_app() throws Throwable {
  
	
	wait.waitForGivenTime(30);
	log.info("User is log into application");
	if (driver.findElement(By.xpath(objectRepository.getObjectPropertyValue("Sign_In_Button"))).isDisplayed())
	{
		driver.findElement(By.xpath(objectRepository.getObjectPropertyValue("Sign_In_Button"))).click();
	}
	wait.waitForGivenTime(30);
	
	

}



/*
 * User enter Username and password in  Sign Page  
 *
 */


@When("^User enter username and password$")
public void user_enter_username_and_password() throws Throwable {

	log.info("Enter UserName and Password into application");
	driver.findElement(By.id(objectRepository.getObjectPropertyValue("Username_TextBox"))).sendKeys(objectRepository.getObjectPropertyValue("Username_Value"));// Enter Username
	wait.waitForGivenTime(15);
	
	driver.findElement(By.xpath(objectRepository.getObjectPropertyValue("Username_Button"))).click();
	
	wait.waitForGivenTime(10);
	driver.findElement(By.xpath(objectRepository.getObjectPropertyValue("Password_TextBox"))).sendKeys(objectRepository.getObjectPropertyValue("Password_Value"));// Enter Password
	driver.findElement(By.xpath(objectRepository.getObjectPropertyValue("Password_Button"))).click();
	wait.waitForGivenTime(30);
	log.info("User log in into application Sucessfully");
}


/*
 * User Navigates to Home Page after SignIn  
 *
 */


@Then("^user navigate to Home page$")
public void user_navigate_to_Home_page() throws Throwable {
	
	if (driver.findElement(By.id(objectRepository.getObjectPropertyValue("HomePage_Label"))).isDisplayed())
	{
		
		log.info("User is in Home page");
	}
	else
		throw new Exception("User is not navigated to home page");
	
}




}
   
