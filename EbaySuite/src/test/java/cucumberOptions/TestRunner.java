package cucumberOptions;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\java\\features",
		glue="stepDefinition",tags= {"@MidProduct"},
		plugin= {"pretty","html:target/cucumber","json:target/cucumber1","junit:target/cucks.xml"}
	)





public class TestRunner {
	
	/*
	 * This will provide all required information to run feature file
	 * It will provide location details where all features and step definitions are present
	 */
	
	
	}
