package manager;


import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import cucumber.api.Scenario;
import pageObjects.AdminPage;
import pageObjects.CreateOKRPage;
import pageObjects.HomePage;
import pageObjects.ImportOKRPage;



public class PageObjectManager  {

	public WebDriver driver =null;
	private HomePage homePage;
	private CreateOKRPage createOKRpage;
	private ImportOKRPage importOKRpage;
	private AdminPage adminpage;
	/*
	 * public ExtentReports extent; public static ExtentTest scenarioDef; public
	 * static ExtentTest features; public String reportLocation =
	 * "/TransaviaCucumberTests/Report";
	 */
	
	
	public PageObjectManager(WebDriver driver) {

		this.driver = driver;

	}
	
	
	
	public HomePage getHomePage(){

		return (homePage == null) ? homePage = new HomePage(driver) : homePage;

	}
	
	
	public CreateOKRPage getCreateOKRPage(){

		return (createOKRpage == null) ? createOKRpage = new CreateOKRPage(driver) : createOKRpage;

	}
	
	public ImportOKRPage getImportOKRPage(){

		
		return (importOKRpage == null) ? importOKRpage = new ImportOKRPage(driver) : importOKRpage;

	}
	
	public AdminPage getAdminPage(){

		return (adminpage == null) ? adminpage = new AdminPage(driver) : adminpage;

	}
}
