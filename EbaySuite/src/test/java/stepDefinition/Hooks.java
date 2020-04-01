package stepDefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import library.AppiumSetUp;
import library.Log;
import library.TestBase;

public class Hooks extends TestBase{
	private Log log;
	private AppiumSetUp appium;
	public Hooks() throws MalformedURLException {
		log = new Log(Hooks.class);
		appium = new AppiumSetUp();
		// TODO Auto-generated constructor stub
	}

	
	
	/*
	 * it will run before all scenarios, we can use appium start stop
	 */
	@Before
	public void setUp(Scenario scenario) throws IOException, Throwable
	{
		log.info("------------->Start of scenario "+scenario.getName()+" <------------");
        log.info("Running appium server if its not running");
		   // login will be first test case so it will check if this is first test case for execution if yes start appium
        //appium.startAppiumServer(4723);
        
				
	}

	
	/*
	 * it will run after all scenarios
	 */
	@After("@EndTest")
	public void tearDown(Scenario scenario) throws FileNotFoundException
	{
		log.info("------------->End of scenario "+scenario.getName()+" <------------");
		//appium.stopService();
	    log.info("Stopping Appium server");
	    	
	}
	

}
