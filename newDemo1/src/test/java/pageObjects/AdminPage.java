package pageObjects;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import manager.DriverManager;

public class AdminPage extends DriverManager {

	// WebDriver driver;

	public AdminPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	//================ Create OKR Page Web Elements ====================================================================	
		@FindBy(xpath = "//h2[text()='Organizations']")
		private WebElement lbl_Organiations;

		@FindBy(xpath = "//div[@class='global-head-action']//child::button")
		private WebElement btn_New;
		
		@FindBy(xpath = "//input[@id='org-name']")
		private WebElement edt_OrgName;
		
		@FindBy(xpath = "//label[text()='Leader']//following::input[@placeholder='Search People']")
		private static WebElement sel_Leader;

		@FindBy(id = "async-pagination-item-0")
		private static WebElement sel_LeaderName;
		
		@FindBy(xpath = "//label[@class='upload-image-label']")
		private WebElement btn_uploadLogo;
		
		@FindBy(xpath = "//img[@class='org-logo']")
		private WebElement img_logo;
		
		@FindBy(xpath = "//button[@aria-label='change date']")
		private static WebElement Cal_CycleStartDate;
		
		@FindBy(xpath = "//input[@name='cycleDuration']")
		private List<WebElement> rdb_CycleType;
		
		@FindBy(xpath = "//input[@id='private']")
		private WebElement chb_private;
		
		@FindBy(xpath = "//div[@class='MuiCardHeader-content']//h4")
		private List<WebElement> organizationHeaders;
		
		@FindBy(xpath = "//a[text()='Users']")
		private WebElement tab_Users;
		
		@FindBy(id = "first-name")
		private WebElement edt_FirstName;
		
		@FindBy(id = "last-name")
		private WebElement edt_LastName;
		
		@FindBy(id = "employee-code")
		private WebElement edt_EmpCode;
		
		@FindBy(id = "email-id")
		private WebElement edt_EmailId;
		
		@FindBy(id = "mui-65077")
		private WebElement edt_Designation;
		
		@FindBy(id = "role-select")
		private WebElement edt_Role;
		
		@FindBy(xpath = "//*[@role= 'listbox']//li")
		private List<WebElement> sel_Role;
		
		@FindBy(xpath = "//*[text()='Bulk User Upload']")
		private WebElement lnk_BulkUpload;
		
		@FindBy(xpath = "//div[@id='org-select']")
		private WebElement edt_Organization;
		
		@FindBy(xpath = "//ul[@aria-labelledby='org-select-label']//li")
		private List<WebElement> sel_Organization;
		
		@FindBy(id = "//img[@class='upload-img']")
		private WebElement UploadImg;
		
		@FindBy(xpath = "//h4[text()='Add Users']")
		private WebElement lbl_Users;
		

		// =====================================================================================
		public void click_NewIcon() throws InterruptedException {
			//lnk_MyGoals.click();
			//Thread.sleep(3000);
			btn_New.click();
			System.out.println("");
		}
		
		public boolean verify_CreateOrganizationPage() {
			boolean flag = false;
			if (lbl_Organiations.isDisplayed()) {
				flag = true;
			}

			return flag;
		}
		
		public void enter_OrgName(String OrganizationName) throws InterruptedException {
			//lnk_MyGoals.click();
			//Thread.sleep(3000);
			edt_OrgName.sendKeys(OrganizationName);
			System.out.println("Organization name has been entered");
		}
		
		public void select_Leader(String Leader) throws InterruptedException {
			sel_Leader.sendKeys(Leader);
				Thread.sleep(8000);
				sel_LeaderName.click();
				System.out.println("Leader has been entered");
	
		}
		
		public boolean uploadLogo(String LogoPath) throws InterruptedException, AWTException {
			boolean flag = false;
			if (btn_uploadLogo.isEnabled()) {
			btn_uploadLogo.click();
			Thread.sleep(5000);
			uploadImage(LogoPath);
			if (img_logo.isDisplayed()) {
				flag = true;
			}
			}
			return flag;
		}
		
		public void uploadImage(String ImagePath) throws InterruptedException, AWTException {
			btn_uploadLogo.click();
			Thread.sleep(2000);
			StringSelection stringSelection = new StringSelection(ImagePath);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, stringSelection);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			driver.findElement(By.xpath("//span[text()='Save & Exit']")).click();
			System.out.println("Image getting uploaded");
		}
		
		
		
		public void set_CycleStartDate() throws InterruptedException {
			Thread.sleep(3000);
			Cal_CycleStartDate.click();
			LocalDateTime now = LocalDateTime.now();
			Date date = new Date();
			String dateFormatString = "d, MMM EEE, ''yy";
			DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
			String currentDate = dateFormat.format(date);
			String dte2 = currentDate.split(",")[0];
			
			List<WebElement> ele  =driver.findElements(By.xpath("//div[@class='MuiPickersCalendar-week']//following::p[text()='" + dte2 + "']"));
			for(WebElement el:ele) {
				if (el.isDisplayed()) {
					el.click();				
					System.out.println("Start date has been enetered");
					break;
				}
			}
			
			Thread.sleep(3000);
		}
		
		public void select_OrgCycle(String OrganizationCycle) {
			if (OrganizationCycle.toLowerCase().contains("quarter")) {
				rdb_CycleType.get(0).click();
			}
			else if(OrganizationCycle.toLowerCase().contains("half year")) {
				rdb_CycleType.get(1).click();
			}
			else if(OrganizationCycle.toLowerCase().contains("year")) {
				rdb_CycleType.get(2).click();
			}
			else if(OrganizationCycle.toLowerCase().contains("3 year")){
				rdb_CycleType.get(3).click();
			}
			else {
				System.out.println("Provided quarter cycle is not valid");
			}
			
		}
		
	public void select_PrivateCheckBox(String Private) {
		if (Private.toLowerCase().contains("yes")) {
			chb_private.click();
		}
		else {
			System.out.println("Private OKR permission has not provided to Org Users");
		}

	}
	
	
	public boolean verify_Organization(String OrganizationName) {
		boolean flag = false;
				if (driver.findElements(By.xpath("//*[text()='" + OrganizationName + "']")).size()>0) {
					flag = true;
					System.out.println(OrganizationName + "  Organization has been created sucessfully");				
				}			
		return flag;
	}
	
	public void Click_UsersTab() throws InterruptedException {
		tab_Users.click();
		Thread.sleep(3000);
	}
		
	
	public boolean verify_CreateUserPage() {
		boolean flag = false;
		if (lbl_Users.isDisplayed()) {
			flag = true;
		}

		return flag;
	}
	
	public void set_UserFirstName(String FirstName) {
		edt_FirstName.sendKeys(FirstName);
	}
	
	public void set_UserLastName(String LastName) {
		edt_LastName.sendKeys(LastName);
	}
	
	public void set_UserEmpCode(String EmpID) {
		edt_EmpCode.sendKeys(EmpID);
	}
	
	public void set_UserEmailId(String EmailID) {
		edt_EmailId.sendKeys(EmailID);
	}
	
	public void set_Designation(String Designation) {
		edt_Designation.sendKeys(Designation);
	}
	
	public void set_Organization(String Organization) throws InterruptedException{
		edt_Organization.sendKeys(Organization);
		Thread.sleep(3000);
		for(WebElement ele : sel_Organization) {
		String str = ele.getText();
		if (str.contains(Organization)) {
			ele.click();
			break;
		}
		}
	}
	
	public void set_Role(String Role) throws InterruptedException{
		edt_Role.sendKeys(Role);
		Thread.sleep(3000);
		for(WebElement ele : sel_Role) {
		String str = ele.getText();
		if (str.contains(Role)) {
			ele.click();
			break;
		}
		}
	}
	
	public boolean verify_RoleCreated(String Role) {
		boolean flag = false;
				if (driver.findElements(By.xpath("//*[text()='" + Role + "']")).size()>0) {
					flag = true;
					System.out.println(Role + "  Organization has been created sucessfully");				
				}			
		return flag;
	}
	
}
