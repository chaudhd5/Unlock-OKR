package runners;


import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features"
		,glue={"stepDefinition"}
		,tags={"@Admin2,@Admin3"}
		,dryRun=false
		,monochrome=true
		,plugin = {"json:target/cucumber.json","html:target/site/cucumber-pretty"})
		//plugin = {"pretty", "html:Reports"})
		        
	//{"pretty", "html:Reports"})

public class TestCreateOKRRunner  {
	
	
}