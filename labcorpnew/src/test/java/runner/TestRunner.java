package runner;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features"
	  , glue = { "stepDefinitions" }
	  , tags = "@lc1"
	  , monochrome = true
	  , plugin = {
		"pretty"
		, "json:target/cucumber-reports/Cucumber.json"
		, "junit:target/cucumber-reports/Cucumber.xml",
		"html:target/cucumber-reports/Cucumber.html" })

public class TestRunner {	

}
