package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


//feature file
// Test Runner file
@RunWith(Cucumber.class)
@CucumberOptions(		
		features="src/test/java/features",
		glue="stepDefinations"
		)
public class TestRunner {

}
