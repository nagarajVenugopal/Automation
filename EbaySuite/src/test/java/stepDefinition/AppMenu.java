package stepDefinition;

import java.awt.Menu;
import java.net.MalformedURLException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import cucumber.api.java.da.Men;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidElement;
import library.TestBase;

public class AppMenu extends TestBase {

	public AppMenu() throws MalformedURLException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@When("^User open App Menu$")
    public void user_open_app_menu() throws Throwable {
        
			findMobileElement("xpath", "HamburgerMenu").click();
			if(findMobileElement("xpath", "MyHangarMenu").isDisplayed())
			{
				log.info("App menu opened");
			}

		}
		
    
	 @And("^User verifies Mobile Application Support Number is (.+)$")
	    public void verifyMobileApplicationSupport(String mobileappsupportnumber) throws Throwable {
	        
		String actual_MobileSupportNumber= findMobileElement("xpath", "MobileApplicationSupport").getText();
		log.info(actual_MobileSupportNumber);
		Assert.assertTrue("Verify Mobile Application support is done", actual_MobileSupportNumber.equals(mobileappsupportnumber));
	
		 
	    }
	 @And("^User verifies Application Support Number is (.+)$")
	    public void verifyApplicationSupportNumber(String applicationsupportnumber) throws Throwable {
	        String actualApplicationSupportNumber = findMobileElement("xpath", "AppSuportNumber").getText();
	        //log.info(actualApplicationSupportNumber);
	        Assert.assertTrue("", actualApplicationSupportNumber.equals(applicationsupportnumber));
	        //findMobileElement("xpath", "HamburgerMenu").click();
	        }
	 @And("^Username \"([^\"]*)\" should be displayed with profile picture$")
	    public void verifyUsernameDisplayedOnAppMenu(String username) throws Throwable {
	        try {
	        	findMobileElement("xpath", "AppMenu_UserName").isDisplayed();
	        	
	        }catch (Exception e) {
				// TODO: handle exception
	        	findMobileElement("xpath", "HamburgerMenu").click();
	        	
			}
	        String actual_Username=findMobileElement("xpath", "AppMenu_UserName").getText().trim();
        	Assert.assertTrue(actual_Username.equalsIgnoreCase(username.trim()));
		    //log.info(actual_Username);
		    
		    findMobileElement("xpath", "HamburgerMenu").click();
	    }


	    @Then("^App menus should be in sequence$")
	    public void verifyAppMenuSequence() throws Throwable {
	       
	    	//List<AndroidElement> Menus = driver.findElements(By.xpath("//androidx.appcompat.widget.LinearLayoutCompat"));
	    	List<AndroidElement> Menus 	 = driver.findElements(By.xpath("//android.widget.CheckedTextView"));
	    	log.info(String.valueOf(Menus.size()));
	    	
	    	log.info(Menus.get(0).getText());
	    	if(Menus.get(0).getText().equalsIgnoreCase("My Hangar"))
	    		log.info("First Menu is My Hangar");
	    	if(Menus.get(1).getText().equalsIgnoreCase("Manage Additional Users"))
	    	   log.info("Second Menu is Manage Additional Users");
	    	if(Menus.get(2).getText().equalsIgnoreCase("My Profile"));
	    		log.info("Third Menu is My Profile");
	    	if(Menus.get(3).getText().equalsIgnoreCase("Mobile Application Support"));
	    	log.info("Fourth menu is Mobile Application Support");
	    	if(Menus.get(4).getText().equalsIgnoreCase("Log Out"));
	    	log.info("Fifth menu is Log out");
	    	
	    }
}
