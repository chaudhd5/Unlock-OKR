package pageObjects;

import static org.junit.Assert.assertTrue;

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

public class CreateOKRPage extends DriverManager {

	// WebDriver driver;

	public CreateOKRPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//================ Create OKR Page Web Elements ====================================================================	
	@FindBy(xpath = "//div[@class='global-head-action']//child::button[2]")
	private WebElement btn_newOKR;

	@FindBy(xpath = "//a[text()='My Goals']")
	private WebElement lnk_MyGoals;

	@FindBy(xpath = "//li[contains(@class,'set-new-goal')]")
	private static WebElement btn_CreateNewObjective;

	@FindBy(xpath = "//li[contains(@class,'align-to-colleague')]")
	private static WebElement btn_AlignToObjective;

	@FindBy(xpath = "//li[text()='Edit Goal']")
	private static WebElement btn_editObjective;

	@FindBy(xpath = "//li[text()='Add Key Result']")
	private static WebElement btn_addKeyResult;

	@FindBy(xpath = "//li[text()='Request Feedback']")
	private static WebElement btn_RequestFeedback;

	@FindBy(xpath = "//div[@class='MuiFormControl-root feedback-employee-search']//input[@class='rbt-input-main form-control rbt-input']")
	private static WebElement edt_SearchAtAlignToObj;

	@FindBy(xpath = "//input[@id='obj-name']")
	private static WebElement edt_AddAnObjective;

	@FindBy(xpath = "//textarea[@id='obj-description']")
	private static WebElement edt_Shortdescription;

	@FindBy(xpath = "//input[@id='private']")
	private static WebElement chb_private;

	@FindBy(xpath = "//label[text()='Start Date']//parent::div//button[@aria-label='change date']")
	private static WebElement Cal_StartDate;

	@FindBy(xpath = "//label[text()='End Date']//parent::div//button[@aria-label='change date']")
	private static WebElement Cal_EndDate;

	@FindBy(xpath = "//label[text()='Assign Contributor(s)']//following::input[@placeholder='Search People']")
	private static WebElement sel_contributor;

	@FindBy(id = "async-pagination-item-0")
	private static WebElement sel_contributorName;

	@FindBy(xpath = "//input[@type='checkbox']")
	private List<WebElement> chb_SlectObjective;

	@FindBy(xpath = "//div[@class='okr-drawer-content']")
	private static WebElement drawer;

	@FindBy(xpath = "//div[@class='add-kr-btn']")
	private List<WebElement> btn_AddKeyResults;

	@FindBy(id = "kr-name")
	private static WebElement edt_keyResults;

	@FindBy(xpath = "//div[@class='contributors-chip']")
	private static WebElement chip_Contributor;

	@FindBy(xpath = "//button[@aria-label='change date']")
	private static WebElement edt_DueDate;

	@FindBy(xpath = "//span[text()='Save & Exit']")
	private static WebElement btn_Save;

	@FindBy(xpath = "//span[text()='Save & Add New']")
	private static WebElement btn_SaveAddNew;

	@FindBy(xpath = "//div[@class='okr-listing-content']")
	private static List<WebElement> okr_list;

	@FindBy(xpath = "//div[@aria-labelledby='alert-dialog-slide-title']")
	private static WebElement confirmation_box;

	@FindBy(xpath = "//div[@aria-labelledby='alert-dialog-slide-title']//child::span[text()='Yes']")
	private static WebElement confirmation_box_Yes;

	@FindBy(xpath = "//div[@aria-labelledby='alert-dialog-slide-title']//child::span[text()='No']")
	private static WebElement confirmation_box_No;

	@FindBy(xpath = "//div[@class='contributors-chip']//following::button[@class='MuiButtonBase-root MuiButton-root MuiButton-text cancel-btn']")
	private static List<WebElement> Contributor_chip_Removal;

	@FindBy(xpath = "//*[@placeholder='Type your message here']")
	private static WebElement edt_messageBox;

	@FindBy(xpath = "//span[text()='Send']")
	private static WebElement btn_Send;

	@FindBy(xpath = "//button[@aria-label='open notification']")
	private static WebElement btn_notification;

	@FindBy(xpath = "//li[@class='MuiListItem-root unread-message MuiListItem-gutters']")
	private static List<WebElement> unreadNotifications;

	@FindBy(xpath = "//div[@class='feedback-comments']")
	private static List<WebElement> commentOnFeedback;

	@FindBy(xpath = "//span[text()='Reply']")
	private static WebElement btn_Reply;

	@FindBy(xpath = "//*[text()='Expand All']")
	private static WebElement btn_expandAll;

	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root']")
	private static List<WebElement> btn_kbabIcon;

	@FindBy(xpath = "//p[text()='Objectives ']")
	private static WebElement lnk_OKRCount;

	@FindBy(xpath = "//p[text()='Key Results ']")
	private static WebElement lnk_KRCount;

	@FindBy(xpath = "//h2[text()='Organizations']")
	private static List<WebElement> pge_Org;

	@FindBy(xpath = "//div[@class='user-tab']")
	private static WebElement btn_profile;

	@FindBy(xpath = "//*[text()='Switch to User']")
	private static WebElement btn_SwitchToProfile;

	@FindBy(xpath = "//*[text()='Switch to Admin']")
	private static WebElement btn_SwitchToAdmin;

	@FindBy(xpath = "//div[@class='okr-objective']//following::input[@type='hidden']")
	private static List<WebElement> val_Progress;

	@FindBy(xpath = "//div[@class='okr-objective']//following::li[@class='MuiListItem-root okr-col3 MuiListItem-gutters']//p[@class='MuiTypography-root MuiTypography-body1']")
	private static List<WebElement> val_EndDate;

	@FindBy(xpath = "//div[@class='okr-objective']//following::span[@class='MuiSlider-root MuiSlider-colorPrimary Mui-disabled' or  @class='MuiSlider-root MuiSlider-colorPrimary']")
	private static List<WebElement> val_Color;

	// =====================================================================================
	public void click_NewOKRTab() throws InterruptedException {
		//lnk_MyGoals.click();
		//Thread.sleep(3000);
		btn_newOKR.click();
		System.out.println("");
	}

	public void click_MyGaolsTab() throws InterruptedException {
		lnk_MyGoals.click();
		Thread.sleep(5000);
	}

	public void switchToProfile() throws InterruptedException {
		Thread.sleep(2000);
		if (pge_Org.size() > 0) {
			btn_profile.click();
			btn_SwitchToProfile.click();
			Thread.sleep(5000);
		}
	}

	public void click_CreateNewObjective() {
		try {
			Thread.sleep(2000);
			Actions acn = new Actions(driver);
			acn.moveToElement(btn_CreateNewObjective).build().perform();
			btn_CreateNewObjective.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void set_Objective(String Objective) {
		edt_AddAnObjective.sendKeys(Objective);
	}

	public void set_ShortDescrption(String Descrption) {
		edt_Shortdescription.sendKeys(Descrption);
	}

	public void set_ObjectiveStartDate(String ObjectiveStartDate) {
		Cal_StartDate.click();
		// String dte = ObjectiveStartDate.split("-")[0];
		LocalDateTime now = LocalDateTime.now();
		Date date = new Date();
		String dateFormatString = "d, MMM EEE, ''yy";
		DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
		String currentDate = dateFormat.format(date);
		String dte2 = currentDate.split(",")[0];
		
		List<WebElement> ele  =driver.findElements(
				By.xpath("//div[@class='MuiPickersCalendar-week']//following::p[text()='" + dte2 + "']//parent::span"));
		for(WebElement el:ele) {
			if (el.isDisplayed()) {
				el.click();
				System.out.println("Objective start date has been entered");
				break;
			}
		}

	}

	public void set_ObjectiveEndDate(String ObjectiveEndDate) throws InterruptedException {
		Thread.sleep(4000);
		Cal_EndDate.click();
		Thread.sleep(5000);
		String dteEnd = ObjectiveEndDate.split("-")[0];
		List<WebElement> ele  =driver.findElements(By
				.xpath("//div[@class='MuiPickersCalendar-week']//following::p[text()='" + dteEnd + "']//parent::span"));
		for(WebElement el:ele) {
			if (el.isDisplayed()) {
				el.click();
				break;
			}
			
		}
		System.out.println("Objective end date has been enetered");

	}

	public void select_Contributor(String Contributor) throws InterruptedException {
		if (Contributor.contains(",")) {
			Thread.sleep(10000);
			String[] words = Contributor.split(",");
			for (String wrd : words) {
				//sel_contributor.sendKeys("");
				
				sel_contributor.sendKeys(wrd);
				Thread.sleep(5000);
				sel_contributorName.click();
				Thread.sleep(5000);
			}
		} else {
			sel_contributor.sendKeys(Contributor);
			Thread.sleep(5000);
			sel_contributorName.click();
		}

	}

	public void click_addKeyResult() throws InterruptedException {
		// btn_Save.sendKeys("");
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		int total = btn_AddKeyResults.size();
		btn_AddKeyResults.get(total - 1).click();
		Thread.sleep(4000);
	}

	public void set_Keys(String keyName) throws InterruptedException {
		// btn_AddKeyResults.click();
		// if (KeyValue.contains(",")) {
		// String[] words = KeyValue.split(",");
		// edt_keyResults.sendKeys(words[0]);
		// } else {
		edt_keyResults.sendKeys("");
		edt_keyResults.sendKeys(keyName);
		// }
	}

	public void set_DueDate(String dueDate) throws InterruptedException {
		Thread.sleep(3000);
		edt_DueDate.click();
		String dteEnd = dueDate.split("-")[0];
		List<WebElement> ele  =driver.findElements(By.xpath("//div[@class='MuiPickersCalendar-week']//following::p[text()='" + dteEnd + "']"));
		for(WebElement el:ele) {
			if (el.isDisplayed()) {
				el.click();				
				System.out.println("Due date has been enetered");
				break;
			}
		}


		Thread.sleep(3000);
	}

	public void Click_SaveButton() throws InterruptedException {
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		 //js.executeScript("window.scrollBy(0,1000)");
		 Thread.sleep(3000);
		btn_Save.click();
	}

	public void Click_SaveAndAddNewButton() {
		btn_SaveAddNew.click();
	}

	public boolean verify_OKRCreation(String Objective) throws InterruptedException {
		Thread.sleep(20000);
		String val = Objective;

		boolean flag = false;
		if (driver.findElements(By.xpath("//p[text()= '" + Objective + "']")).size() > 0) {
			flag = true;
		}
		return flag;
	}

	public boolean verify_OKRCreation_MultipleKeys(String Objective) throws InterruptedException {
		Thread.sleep(20000);

		boolean flag = false;
		if (driver
				.findElement(By.xpath("//h5[@title= '" + Objective
						+ "']//following::div[@class='objective-summary']//child::p[2][text()='3 Key Results']"))
				.isDisplayed()) {
			flag = true;
		}
		return flag;
	}

	public void Verify_editObjective(String Objective) throws InterruptedException {
		if (driver.findElement(By.xpath("//h5[@title= '" + Objective + "']")).isDisplayed()) {
			driver.findElement(By.xpath("//h5[@title= '" + Objective
					+ "']/../preceding-sibling::div[@class='okr-card-top']//child::span[@class='MuiTouchRipple-root']//parent::button"))
					.click();
			Thread.sleep(20000);

		}

	}

	public void click_alignToObjective() {
		btn_AlignToObjective.click();
		System.out.println("User clicked  align to objective link");
	}

	public boolean verify_AlignToObjectivesPage() {
		boolean flag = false;
		if (edt_SearchAtAlignToObj.isDisplayed()) {
			flag = true;
		}

		return flag;
	}

	public void search_user(String PeopleName) throws InterruptedException {
		// edt_SearchAtAlignToObj.sendKeys(" ");
		// edt_SearchAtAlignToObj.sendKeys(" ");
		edt_SearchAtAlignToObj.sendKeys(PeopleName);
		Thread.sleep(6000);
		sel_contributorName.click();
		Thread.sleep(6000);

	}

	public void select_objectiveToImport(String Objective) throws InterruptedException {
		//Actions actions = new Actions(driver);
		//actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(4000);
		//chb_SlectObjective.get(0).click()
		driver.findElement(By.xpath("//*[text()='" + Objective + "']//preceding::input[@type='checkbox']")).click();
		System.out.println("Objective has been selected to import");
	}

	public void select_KababIcon(String Objective) throws InterruptedException {
		if (driver.findElements(By.xpath("//p[text()= '" + Objective + "']")).size() > 0) {
			// lnk_MyGoals.click();
			Thread.sleep(8000);
			driver.findElement(By.xpath("//*[text()='" + Objective + "']//ancestor::ul//li[4]//div[2]//button"))
					.click();
		} else {
			System.out.println("Objective '" + Objective + "' is not there in the list");
		}
	}

	public void Click_DeleteObjective() throws InterruptedException {
		driver.findElement(By.xpath("//li[text()='Delete']")).click();
		Thread.sleep(3000);

	}

	public void Click_AssignTo() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='Assign to']")).click();
		Thread.sleep(3000);
	}

	public void confirmMessage() {
		if (confirmation_box.isDisplayed()) {
			confirmation_box_Yes.click();
			System.out.println("Confirmation message has been accepted");

		} else {
			System.out.println("Confirmation message not displayed");
		}
	}

	public boolean verify_AssignTojectivesPage() throws InterruptedException {
		boolean flag = false;
		if (driver.findElement(By.xpath("//h4[text()='Assign Contributor(s)']")).isDisplayed()) {
			Thread.sleep(5000);
			flag = true;
		}
		return flag;
	}

	public static boolean verify_contributorAdded(String Contributor, String Objective) {
		boolean flag = false;

		if (Contributor.contains(",")) {
			String[] words = Contributor.split(",");
			for (String wrd : words) {
				List<WebElement> contributorlist = driver.findElements(By.xpath("//p[text()='" + Objective
						+ "']//ancestor::div[@class='okr-listing-content']//following::img[@alt='" + wrd + "']"));
				String name = wrd;
				char ch1= name.split(" ")[0].charAt(0);
				char ch2= name.split(" ")[1].charAt(0);
				String wrd2 = String.valueOf(ch1) + String.valueOf(ch2); 
				
				List<WebElement> contributorlist2 = driver.findElements(By.xpath("//p[text()='" + Objective
						+ "']//ancestor::div[@class='okr-listing-content']//following::div[text()='" + wrd2 + "']"));
				if ((contributorlist.size() > 0)||(contributorlist2.size() > 0)) {
					flag = true;
				}
			}
		} else {
			List<WebElement> contributorlist = driver.findElements(By.xpath("//p[text()='" + Objective
					+ "']//ancestor::div[@class='okr-listing-content']//child::span[text()='" + Contributor + "']"));
			String name = Contributor;
			char ch1= name.split(" ")[0].charAt(0);
			char ch2= name.split(" ")[1].charAt(0);
			String wrd2 = String.valueOf(ch1) + String.valueOf(ch2); 
			
			List<WebElement> contributorlist2 = driver.findElements(By.xpath("//p[text()='" + Objective
					+ "']//ancestor::div[@class='okr-listing-content']//following::div[text()='" + wrd2 + "']"));
			if ((contributorlist.size() > 0)||(contributorlist2.size() > 0)) {
				flag = true;
			}
		}

		return flag;

	}

	public void click_EditObjective() throws InterruptedException {
		Thread.sleep(2000);
		btn_editObjective.click();
		System.out.println("User clicked  edit objective link");
		Thread.sleep(3000);
	}

	public boolean verify_EditObjectivesPage() {
		boolean flag = false;
		if (driver.findElement(By.xpath("//h4[text()='Edit Goal']")).isDisplayed()) {
			flag = true;
		}

		return flag;
	}

	public void edit_Objective(String NewObjName) {
		try {
			edt_AddAnObjective.clear();
			edt_AddAnObjective.sendKeys(NewObjName);
			System.out.println("Objective name has been changed");

			for (WebElement ele : Contributor_chip_Removal) {
				ele.click();
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			System.out.println("Edit objective failed beacuse of exeception error " + e.getMessage());
		}
	}

	public boolean verify_Updated_Objective(String Objective, String NewObjName) throws InterruptedException {
		Thread.sleep(20000);
		String val = Objective;

		boolean flag = false;
		if (driver.findElements(By.xpath("//p[text()= '" + NewObjName + "']")).size() > 0) {
			flag = true;
		}
		if (driver.findElements(By.xpath("//p[text()= '" + Objective + "']")).size() > 0) {
			flag = false;
		}
		List<WebElement> contributorlist = driver.findElements(By.xpath("//p[text()='" + NewObjName
				+ "']//ancestor::div[@class='okr-listing-content']//child::div[@class='contributors-avatar-group']//child::div[@class='MuiAvatarGroup-root contributor-list']"));
		if (contributorlist.size() > 0) {
			flag = false;
		}

		return flag;
	}

	public void click_AddKeyResult() throws InterruptedException {
		Thread.sleep(2000);
		btn_addKeyResult.click();
		System.out.println("User clicked add key result link");
		Thread.sleep(3000);
	}

	public boolean verify_AddKeyResultPage() {
		boolean flag = false;
		if (driver.findElement(By.xpath("//h4[text()='Add Key Result']")).isDisplayed()) {
			flag = true;
		}

		return flag;
	}

	public boolean verify_KeyResultAddedToObjective(String keyName, String Objective) throws InterruptedException {
		Thread.sleep(20000);
		String val = Objective;

		boolean flag = false;
		List<WebElement> keyResultList = driver
				.findElements(By.xpath("//p[text()='" + Objective + "']//following::p[text()='" + keyName + "']"));

		if (keyResultList.size() > 0) {
			flag = true;
		}
		return flag;
	}

	public void click_RequestFeedback() throws InterruptedException {
		Thread.sleep(2000);
		btn_RequestFeedback.click();
		System.out.println("User clicked add key result link");
		Thread.sleep(3000);
	}

	public boolean verify_RequestFeedbackPage() {
		boolean flag = false;
		if (driver.findElement(By.xpath("//h4[text()='Request feedback']")).isDisplayed()) {
			flag = true;
		}

		return flag;
	}

	public void enter_FeedbackRequestMessage() {
		String messagecontent = edt_messageBox.getText();
		edt_messageBox.sendKeys(messagecontent + ".... Please provide feedback");
		System.out.println("Request message has been provided");

	}

	public void click_NotificationIcon() throws InterruptedException {
		btn_notification.click();
		Thread.sleep(3000);
	}

	public void click_UnreadFeedbackNotifications(String UnreadMMessage) throws InterruptedException {
		for (WebElement ele : unreadNotifications) {
			if (ele.getText().contains(UnreadMMessage)) {
				ele.click();
				Thread.sleep(6000);
				break;
			}
		}
	}

	public boolean verify_GiveFeedbackPage() throws InterruptedException {
		boolean flag = false;
		Thread.sleep(3000);
		if (driver.findElement(By.xpath("//h4[text()='Give Feedback']")).isDisplayed()) {
			flag = true;
		}
		return flag;
	}

	public void enter_FeedbackMessage(String messagecontent) {
		edt_messageBox.clear();
		edt_messageBox.sendKeys(messagecontent);
		System.out.println("Request message has been provided");

	}

	public void click_SendButton() {
		btn_Send.click();
		System.out.println("Send button has been clicked");
	}

	public void click_ReplyButton() {
		btn_Reply.click();
		System.out.println("Send button has been clicked");
	}

	public boolean Verify_ReceivedReadFeedback() throws InterruptedException {
		boolean flag = false;
		Thread.sleep(3000);
		if (driver.findElement(By.xpath("//h4[text()='Received/Read Feedback']")).isDisplayed()) {
			flag = true;
		}
		return flag;
	}

	public void openFeedbackComment() throws InterruptedException {
		int count = commentOnFeedback.size();
		if (count >= 0) {
			commentOnFeedback.get(0).click();
			Thread.sleep(1000);
		} else {
			System.out.println("No recorded feedback");
		}
	}

	public void clickExpandAll() {
		try {
			Thread.sleep(3000);
			btn_expandAll.click();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean verifyOKRCount() {
		boolean flag = false;
		int OKRcountinList = okr_list.size();
		String totalcount = lnk_OKRCount.getText();
		if (totalcount.contains(String.valueOf(OKRcountinList))) {
			flag = true;
			System.out.println("Total OKR count for the user is  " + String.valueOf(OKRcountinList));
		}

		return flag;
	}

	public boolean verifyKRCount() {
		boolean flag = false;
		int OKRcountinList = okr_list.size();
		int kababIcons = btn_kbabIcon.size();
		int KRcountinList = kababIcons - OKRcountinList;
		String totalcount = lnk_KRCount.getText();
		if (totalcount.contains(String.valueOf(KRcountinList))) {
			flag = true;
			System.out.println("Total OKR count for the user is  " + String.valueOf(KRcountinList));
		}
		return flag;
	}

	public List<Integer> getStatus() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (WebElement ele : val_Progress) {
			String str = ele.getAttribute("value");
			int progress = Integer.valueOf(str);
			arr.add(progress);
		}
		System.out.println("Progress displayed at my goal page " + arr );
		return arr;
	}

	public List<Integer> getDateDifference() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Date date = new Date();
		String dateFormatString = "d, MMM EEE, ''yy";
		DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
		String currentDate = dateFormat.format(date);
		String dte2 = currentDate.split(",")[0];
		int dateCurrent = Integer.valueOf(dte2);


		for (WebElement ele : val_EndDate) {
			if (ele.getText()!= null && !ele.getText().isEmpty()) {
				String str = ele.getText().split(" ")[1].trim();
				int dateEnd = Integer.valueOf(str);
				int difference = dateEnd - dateCurrent;
				String difference1 = Integer.toString(difference);
						if (difference1.contains("-")) {
							String diff2 = difference1.replace("-", "");
							 difference =  Integer.valueOf(diff2);
						}
						
				arr.add(difference);
			}
		}
		return arr;
	}

	public List<String> ReturnStatusColor() {
		ArrayList<String> arr = new ArrayList<String>();
		String CC = null;
		for (WebElement ele : val_Color) {
			String str = ele.getAttribute("style");
			String colorcode = str.split("rgb")[1].split(",")[1].trim();
			if (Integer.valueOf(colorcode) == 169) {
				CC = "Green";
			} else if (Integer.valueOf(colorcode) == 34) {
				CC = "Red";
			} else if (Integer.valueOf(colorcode) == 194) {
				CC = "Yellow";
			} else if (Integer.valueOf(colorcode) == 189) {
				CC = "Grey";
			}

			arr.add(CC);
		}
		System.out.println("Progress displayed at my goal page " + arr );
		return arr;
	}

	public boolean verifyProgress() {
		List<Integer> percentage = getStatus();
		List<Integer> endDate = getDateDifference();
		List<String> colorCode = ReturnStatusColor();
		String colUpdate = null;
		boolean flag = false;

		for (int i = 0; i <= percentage.size()-1; i++) {
			Integer targetNotAchieved = 100 - percentage.get(i);
			Integer timeLeft = (endDate.get(i) / 90) * 100;
			Integer deviation = targetNotAchieved - timeLeft;

			if (deviation >= 20 && deviation <= 30) {
				colUpdate = "Yellow";
			} else if (deviation == 100) {
				colUpdate = "Grey";
			} else if (deviation > 30) {
				colUpdate = "Red";
			} else if (deviation < 20) {
				colUpdate = "Green";
			} 	

			if (colorCode.get(i).equalsIgnoreCase(colUpdate)) {
				System.out.println("Progress Validated and colour displayed " + colUpdate);
				flag = true;
			}

		}
		
		return flag;

	}

}
