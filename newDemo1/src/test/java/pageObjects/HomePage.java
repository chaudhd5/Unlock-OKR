package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//================ Home Page Web Elements ====================================================================	
	@FindBy(xpath = "//div[@class='MuiFormControl-root']//child::input")
	private WebElement input_UserName;
	
	@FindBy(xpath = "//div[@class='MuiFormControl-root pass-txtbox']//child::input")
	private WebElement input_UserPassword;
	
	@FindBy(xpath = "//span[text()='Log In']")
	private static WebElement link_SignUp;
	

//=====================================================================================	
	
	public void set_userName(String UserName) {
		input_UserName.sendKeys(UserName);
	}
	
	
	public void set_userPassword(String UserPassword) {
		input_UserPassword.sendKeys(UserPassword);
	}
	
	public static   void click_signUp() {
		link_SignUp.click();
		
	}
	
	/*public  static void click_NewOKRTab() {
		btn_newOKR.click();
	System.out.println("");*/

}
	
