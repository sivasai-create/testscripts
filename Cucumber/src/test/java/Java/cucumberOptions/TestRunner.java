package Java.cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
		
		features = "src/test/java/features",
		glue ="src/test/java/stepDefinitions")

public class TestRunner extends AbstractTestNGCucumberTests {

}
