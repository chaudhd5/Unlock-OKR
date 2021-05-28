package runners;


import java.io.*;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.junit.Cucumber;
	 
	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "features/Login.feature"
			,glue={"stepDefinition"}
			//,tags={"@Regression"}
			,dryRun=false
			,monochrome=true
			,plugin = {"json:target/cucumber.json","html:target/site/cucumber-pretty"})
			//plugin = {"pretty", "html:Reports"})
			        
		//{"pretty", "html:Reports"})

	public class TestRunner {	 


}
	
	

