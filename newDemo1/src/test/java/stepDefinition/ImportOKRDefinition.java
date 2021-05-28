package stepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;
import manager.DriverManager;
import manager.PageObjectManager;
import pageObjects.CreateOKRPage;
import pageObjects.HomePage;
import pageObjects.ImportOKRPage;

public class ImportOKRDefinition extends DriverManager {
	private static final String String = null;
	// ====== Class Variables ============================
	// WebDriver driver;
	HomePage homePage;
	ConfigFileReader configsFileReader;
	PageObjectManager pageObjectManager;
	ImportOKRPage importOKRpage;

	//@Given("^User is at OKR Home page$")
	/*public void user_is_at_OKR_Home_page() {
		// Write code here that turns the phrase above into concrete actions
		// driver = new ChromeDriver();
		pageObjectManager = new PageObjectManager(driver);
		importOKRpage = pageObjectManager.getImportOKRPage();
		System.out.println("User is navigated to Home Page sucessfully.");

	}*/
	

@When("^User clicks on Import Previous Objective$")
public void user_clicks_on_Import_Previous_Objective() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	pageObjectManager = new PageObjectManager(driver);
	importOKRpage = pageObjectManager.getImportOKRPage();
	importOKRpage.click_ImportOKRLink();
}

@When("^User should have last quarter \"([^\"]*)\"$")
public void user_should_have_last_quarter_OKRs(String Objective ) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   boolean flag = false;
   flag = importOKRpage.verify_PreviousOKR(Objective);
   assertTrue(flag);
}

@When("^User pick \"([^\"]*)\" from last quarter$")
public void user_pick_from_last_quarter(String Objective) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	importOKRpage.add_PreviousOKR(Objective );
}

@When("^User click on add button$")
public void user_click_on_add_button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	importOKRpage.click_addButton();
}

@Then("^user should be at create OKR page with previous imported \"([^\"]*)\" deatils$")
public void user_should_be_at_create_OKR_page_with_previous_imported_deatils(String Objective) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	boolean flag = false;
	flag = importOKRpage.import_previousOKR(Objective);
	 assertTrue(flag);
}


@When("^User clicks on Import Team Objective$")
public void user_clicks_on_Import_Team_Objective() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	pageObjectManager = new PageObjectManager(driver);
	importOKRpage = pageObjectManager.getImportOKRPage();
	Thread.sleep(3000);
	importOKRpage.click_ImportTeamOKRLink();
	Thread.sleep(2000);
}


@When("^User pick objective \"([^\"]*)\" and key \"([^\"]*)\" from his team manager objective$")
public void user_pick_from_his_team_manager_objective(String Objective, String KeyImported) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Thread.sleep(4000);
	importOKRpage.check_ManagerOKR(Objective,KeyImported);
	Thread.sleep(2000);
}


@Then("^user enter \"([^\"]*)\" results for the objective$")
public void user_enter_Key_results_for_the_objective(String Keys) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	importOKRpage.set_KeyValues(Keys);
}


@When("^User pick \"([^\"]*)\" and key \"([^\"]*)\" from \"([^\"]*)\" objective$")
public void user_pick_from_objective(String Objective, String KeyImported,String EmployeeName) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	importOKRpage.check_EmployeeOKR(Objective,EmployeeName,KeyImported);
	Thread.sleep(2000);
}

}