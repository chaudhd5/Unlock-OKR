package stepDefinition;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;
import manager.DriverManager;
import manager.PageObjectManager;
import pageObjects.CreateOKRPage;
import pageObjects.HomePage;




public class HomePageStepDefinition extends DriverManager {



private static final String String = null;
//====== Class Variables ============================	
 // WebDriver driver;
  HomePage homePage;
  ConfigFileReader configsFileReader;
  PageObjectManager pageObjectManager;
  CreateOKRPage createOKRpage;
//===================================================
  

@Given("^User is at OKR login page$")
	public void invokeApplication() {
		 configsFileReader = new ConfigFileReader();
		  //System.setProperty("webdriver.chrome.driver", configsFileReader.getDriverPath());
		//  driver = new ChromeDriver();
	      WebDriver driver= startdriver();
		  driver.get(configsFileReader.getApplicationUrl());
		  driver.manage().window().maximize();
		  pageObjectManager = new PageObjectManager(driver);
		  homePage = pageObjectManager.getHomePage();
   }
   
   

@When("^User Enter \"([^\"]*)\" in Email field$")
public void user_Enter_in_Email_field(String EmailId){
    homePage.set_userName(EmailId);
   
   
}

@When("^User Enter \"([^\"]*)\" in Password field$")
public void user_Enter_in_Password_field(String Password) {
	homePage.set_userPassword(Password);
   
}

@Then("^User should be able to login successfully$")
public void user_should_be_able_to_login_successfully(){
	homePage.click_signUp();
   
}



@When("^User Enter \"([^\"]*)\" in Email field And User Enter \"([^\"]*)\" in Password field$")
public void user_Enter_in_Email_field_And_User_Enter_in_Password_field(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	homePage.set_userName(arg1);
	homePage.set_userPassword(arg2);
   
}

@When("^user click on Sign In Button$")
public void user_click_on_Sign_In_Button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Thread.sleep(5000);
	HomePage.click_signUp();
	Thread.sleep(2000);
	//driver.quit();
	
	
}

@Then("^login should be sucessful$")
public void login_should_be_sucessful() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Thread.sleep(5000);
	createOKRpage = pageObjectManager.getCreateOKRPage();
	String rTitle = driver.getCurrentUrl();
	boolean flag=false;
    if ((rTitle.contains("/unlock-me"))||(rTitle.contains("/organization"))){
    	flag= true;
    	createOKRpage.switchToProfile();
    }
    assertTrue(flag);
    System.out.println("User is navigated to Home Page sucessfully.");
	//driver.close();
	//driver.quit();
}

@Then("^Admin login should be sucessful$")
public void admin_login_should_be_sucessful() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Thread.sleep(5000);
	createOKRpage = pageObjectManager.getCreateOKRPage();
	String rTitle = driver.getCurrentUrl();
	boolean flag=false;
    if (rTitle.contains("/organization")){
    	flag= true;
    }
    else {
    	System.out.println("User is not an admin");
    }
    assertTrue(flag);
    System.out.println("User is logged in as Admin");
}

@Then("^login should not be sucessful$")
public void login_should_not_be_sucessful() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	 try{
	        String error = driver.findElement(By.className("textError")).getText();
	        assertTrue(error.contains("Invalid Username or Password"));
	        System.out.println("User is not navigated to Home Page sucessfully,as entered wrong credentials.");
	       }catch (NoSuchElementException e){
	         //something else
	       }
		
	//driver.close();
	//driver.quit();
	 
	
	}

	


	


	 
	 
}
/*
@Given("^User is at motomo login page$")
public void user_is_at_motomo_login_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	configsFileReader = new ConfigFileReader();
	  System.setProperty("webdriver.chrome.driver", configsFileReader.getDriverPath());
	  driver = new ChromeDriver();
	  driver.get("https://analytics.uat-hs.com/");
	  driver.manage().window().maximize();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//input[@id='login_form_login']")).sendKeys("anurag");
	  driver.findElement(By.xpath("//input[@id='login_form_password']")).sendKeys("ngA%$v23CD");
	  driver.findElement(By.xpath("//input[@id='login_form_submit']")).click();
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//span[@class='navbar-icon icon-settings']")).click();
 Thread.sleep(5000);
	  
	  driver.findElement(By.xpath("//ul[@class ='navbar hide-on-med-and-down']//following::a[6]")).click();
	  Thread.sleep(2000);
	  
	
	  
}

@When("^user enter data into moto$")
public void user_enter_data_into_moto() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	
	 * File src=new
	 * File("C:\\Users\\ayush\\Desktop\\Deepanjali\\OKR\\Copy of Matomo_test_Insert_Users.xlsx"
	 * ); FileInputStream fis=new FileInputStream(src); XSSFWorkbook wb=new
	 * XSSFWorkbook(fis); XSSFWorkbook workbook = new XSSFWorkbook(fis); XSSFSheet
	 * sh1= wb.getSheetAt(0); int rowCount = sh1.getFirstRowNum(); for (int i = 1; i
	 * < rowCount+1; i++) {
	 * driver.findElement(By.xpath("//a[@class='btn add-new-user ng-binding']")).
	 * click(); Thread.sleep(2000);
	 * driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys(sh1.getRow
	 * (i).getCell(0).getStringCellValue());
	 * driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(sh1.
	 * getRow(i).getCell(1).getStringCellValue());
	 * driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(sh1.getRow
	 * (i).getCell(2).getStringCellValue());
	 * driver.findElement(By.xpath("//input[@value='Create user']")).click();
	 * Thread.sleep(3000);
	 * driver.findElement(By.xpath("//a[text()='Back']")).click();
	 
	 }
	
}

@Then("^user should be added$")
public void user_should_be_added() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
  
}

 */




