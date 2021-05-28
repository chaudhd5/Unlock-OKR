package stepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;
import dataProvider.Utility;
import manager.DriverManager;
import manager.PageObjectManager;
import pageObjects.AdminPage;
import pageObjects.CreateOKRPage;
import pageObjects.HomePage;

public class AdminDefinition extends DriverManager {
	private static final String String = null;
	// ====== Class Variables ============================
	// WebDriver driver;
	HomePage homePage;
	ConfigFileReader configsFileReader;
	PageObjectManager pageObjectManager;
	CreateOKRPage createOKRpage;
	AdminPage adminpage;
	

	@Given("^User is at admin page$")
	public void user_is_at_admin_page() throws Throwable {
				pageObjectManager = new PageObjectManager(driver);
				adminpage = pageObjectManager.getAdminPage();
				createOKRpage = pageObjectManager.getCreateOKRPage();
				boolean flag = false;
				flag = adminpage.verify_CreateOrganizationPage();
	 
	}

	@When("^User click on CreateOrganization icon$")
	public void user_click_on_CreateOrganization_icon() throws Throwable {    
		adminpage.click_NewIcon();
		Thread.sleep(2000);
	}

	@When("^User enter \"([^\"]*)\" in Organization Name field$")
	public void user_enter_in_Organization_Name_field(String OrganizationName) throws Throwable {    
		adminpage.enter_OrgName(OrganizationName);
	}

	@When("^User enter \"([^\"]*)\" in Leader Name field$")
	public void user_enter_in_Leader_Name_field(String Leader) throws Throwable {
	    adminpage.select_Leader(Leader);
	 
	}
	

	@When("^User upload \"([^\"]*)\" in logo field$")
	public void user_upload_in_logo_field(String LogoPath) throws Throwable {
	   boolean flag= false;
	   flag = adminpage.uploadLogo(LogoPath);
	   assertTrue(flag);
	   System.out.println("Organization logo has been uploaded");
	 
	}

	@When("^User enter current date in Start date field$")
	public void user_enter_current_date_in_Start_date_field() throws Throwable {
	    adminpage.set_CycleStartDate();
	    Thread.sleep(2000);
	 
	}

	@When("^User select \"([^\"]*)\" in Organization Cycle field$")
	public void user_select_in_Organization_Cycle_field(String OrganizationCycle) throws Throwable {
	    adminpage.select_OrgCycle(OrganizationCycle);
	 
	}

	@When("^User select private OKR \"([^\"]*)\" option for the organization$")
	public void user_select_private_OKR_option_for_the_organization(String Private) throws Throwable {
	    adminpage.select_PrivateCheckBox(Private);
	 
	}

	@When("^User clicks on Save and Exit button$")
	public void user_clicks_on_Save_and_Exit_button() throws Throwable {
		createOKRpage.Click_SaveButton();
		 Thread.sleep(3000);
	}

	@Then("^\"([^\"]*)\" should be created successfully$")
	public void should_be_created_successfully(String OrganizationName) throws Throwable {
	    Boolean flag = false;
	    Thread.sleep(3000);
	    flag = adminpage.verify_Organization(OrganizationName);
	    assertTrue(flag);
	}
	

	@Given("^User click on User Tab$")
	public void user_click_on_User_Tab() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		adminpage.Click_UsersTab();
		Thread.sleep(2000);	  
		boolean flag = false;
	    flag = adminpage.verify_CreateUserPage();
	    assertTrue(flag);
	}

	@When("^User click on CreateUser icon$")
	public void user_click_on_CreateUser_icon() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		adminpage.click_NewIcon();
		Thread.sleep(2000);	    
	}

	@When("^User enter \"([^\"]*)\" in First Name field$")
	public void user_enter_in_First_Name_field(String FirstName) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		adminpage.set_UserFirstName(FirstName);
	}

	@When("^User enter \"([^\"]*)\" in last Name field$")
	public void user_enter_in_last_Name_field(String LastName) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		adminpage.set_UserLastName(LastName);
	}

	@When("^User enter \"([^\"]*)\" in Emp Id field$")
	public void user_enter_in_Emp_Id_field(String EmpID) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		adminpage.set_UserEmpCode(EmpID);
	}

	@When("^User enter \"([^\"]*)\" in Email Id field$")
	public void user_enter_in_Email_Id_field(String EmailID) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		adminpage.set_UserEmailId(EmailID);
	}

	@When("^User enter \"([^\"]*)\" in Designation field$")
	public void user_enter_in_Designation_field(String Designation) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		adminpage.set_Designation(Designation);
	}

	@When("^User select \"([^\"]*)\" in Role field$")
	public void user_select_in_Role_field(String Role) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		adminpage.set_Role(Role); 
	}

	@When("^User select \"([^\"]*)\" in organization field$")
	public void user_select_in_organization_field(String Organization) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		adminpage.set_Organization(Organization);
	}

	@Then("^User \"([^\"]*)\" should be created successfully$")
	public void user_should_be_created_successfully(String Role) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Boolean flag = false;
	    Thread.sleep(3000);
	    flag = adminpage.verify_RoleCreated(Role);
	    assertTrue(flag);
	}
	


}

