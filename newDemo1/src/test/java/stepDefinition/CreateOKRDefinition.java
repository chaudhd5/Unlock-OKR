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
import pageObjects.CreateOKRPage;
import pageObjects.HomePage;

public class CreateOKRDefinition extends DriverManager {
	private static final String String = null;
	// ====== Class Variables ============================
	// WebDriver driver;
	HomePage homePage;
	ConfigFileReader configsFileReader;
	PageObjectManager pageObjectManager;
	CreateOKRPage createOKRpage;

	@Given("^User is at OKR Home page$")
	public void user_is_at_OKR_Home_page() {
		// Write code here that turns the phrase above into concrete actions
		// driver = new ChromeDriver();
		pageObjectManager = new PageObjectManager(driver);
		createOKRpage = pageObjectManager.getCreateOKRPage();

		//System.out.println("User is navigated to Home Page sucessfully.");

	}

	@When("^User click on CreateOKR icon$")
	public void user_click_CreateOKR_icon() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(5000);
		createOKRpage.click_NewOKRTab();
		
	}

	@Then("^User clicks on Create New Objective$")
	public void user_clicks_on_Create_New_Objective() {
		// Write code here that turns th phrase above into concrete actions
		createOKRpage.click_CreateNewObjective();
	}

	@Then("^User enter \"([^\"]*)\" in Objective field$")
	public void user_enter_in_Objective_field(String Objective) {
		// Write code here thaturns the phrase above into concrete actions
		createOKRpage.set_Objective(Objective);
	}

	@Then("^User enter \"([^\"]*)\" in type of short description for objective field$")
	public void user_enter_in_type_of_short_description_for_objective_field(String Descrption) {
		// Write code here that turns the phrase above into concrete

		createOKRpage.set_ShortDescrption(Descrption);
	}

	@Then("^User select \"([^\"]*)\" in Start date field$")
	public void user_select_in_Start_date_field(String ObjectiveStartDate) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		createOKRpage.set_ObjectiveStartDate(ObjectiveStartDate);
	}

	@Then("^User select \"([^\"]*)\" in End date field$")
	public void user_select_in_End_date_field(String ObjectiveEndDate) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		createOKRpage.set_ObjectiveEndDate(ObjectiveEndDate);
	}

	@Then("^user select \"([^\"]*)\" in assign contributors field$")
	public void user_select_in_assign_contributors_field(String Contributor) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!(Contributor.equalsIgnoreCase(""))) {
		createOKRpage.select_Contributor(Contributor);
		System.out.println("Contributor has been added");
		}
		else {
			System.out.println("No contributor for this objective");
		}
	}

	@Then("^user click on Add Key Result button$")
	public void user_click_on_Add_Key_Result_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		createOKRpage.click_addKeyResult();
	}

	@Then("^user add \"([^\"]*)\" in key Name field$")
	public void user_add_in_key_name_field(String keyName) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		createOKRpage.set_Keys(keyName);
	}

	@Then("^user add following in key field$")
	public void user_add_following_in_key_field(DataTable keys) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
		List<Map<String, String>> data = keys.asMaps(String.class, String.class);

		String keyval1 = data.get(0).get("keys");
		String keyval2 = data.get(1).get("keys");
		String keyval3 = data.get(2).get("keys");
		String keyval = keyval1 + "," + keyval2 + "," + keyval3;
		createOKRpage.set_Keys(keyval);

	}

	@Then("^user select \"([^\"]*)\" in key result due date field$")
	public void user_select_in_key_result_due_date_field(String dueDate) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		createOKRpage.set_DueDate(dueDate);
	}
	

	
	@Then("^Click on Save button$")
	public void click_on_Save_button() throws InterruptedException { // Write code here that turns the phrase above into concrete actions
		createOKRpage.Click_SaveButton();
		System.out.println("Saved the changes");
	}

	@And("^Click on Save And Add New button$")
	public void click_on_Save_And_Add_button() {

	}

	@Then("^User should be navigated to home page and \"([^\"]*)\" should have been created$")
	public void user_should_be_navigated_to_home_page_and_objective_should_have_been_created(String Objective)
			throws InterruptedException {
		boolean flagTest = false;
		flagTest = createOKRpage.verify_OKRCreation(Objective);
		assertTrue(flagTest);
	}

	@When("^User click on Align to Objectives$")
	public void user_click_on_Align_to_Objectives() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		createOKRpage.click_alignToObjective();
	}

	@Then("^User should be at Align to Objectives page$")
	public void user_should_be_at_Align_to_Objectives_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		boolean flag = false;
		flag = createOKRpage.verify_AlignToObjectivesPage();
		assertTrue(flag);

	}

	@Then("^User enter \"([^\"]*)\" in search people field$")
	public void user_enter_in_search_people_field(String PeopleName) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		createOKRpage.search_user(PeopleName);
	}

	@Then("^User select \"([^\"]*)\" from objective list$")
	public void user_select_from_objective_list(String Objective) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		createOKRpage.select_objectiveToImport(Objective);
	}

	@When("^User click kabab icon of  \"([^\"]*)\" from objective list$")
	public void user_click_kabab_icon_of_from_objective_list(String Objective) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		//createOKRpage.click_MyGaolsTab();
		createOKRpage.select_KababIcon(Objective);
	}

	@When("^User select delete option from kabab icon$")
	public void user_select_delete_option_from_kabab_icon() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		createOKRpage.Click_DeleteObjective();
	}

	@When("^User click on Yes button on confirmation message$")
	public void user_click_on_Yes_button_on_confirmation_message() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		createOKRpage.confirmMessage();
	}



	@Then("^\"([^\"]*)\" should not be visible at home page$")
	public void objective_should_not_be_visible_at_home_page(String Objective) throws Throwable {
		boolean flagTest = false; // flagTest =
		createOKRpage.verify_OKRCreation(Objective);
		assertFalse(flagTest);
	}

	@When("^User select Assign to option from kabab icon$")
	public void user_select_Assign_to_option_from_kabab_icon() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		createOKRpage.Click_AssignTo();
	}

	@When("^User navigate to Add contributors page$")
	public void user_navigate_to_Add_contributors_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		boolean flag = false;
		 flag = createOKRpage.verify_AssignTojectivesPage();
		 assertTrue(flag);
	}

	@Then("^\"([^\"]*)\" should be added to the \"([^\"]*)\"$")
	public void should_be_added_to_the(String Contributor, String Objective) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		boolean flag = false;
		Thread.sleep(5000);
		 flag = createOKRpage.verify_contributorAdded(Contributor,Objective);
		 assertTrue(flag);
	}
	
	
	@When("^User select Edit objective option from kabab icon$")
	public void user_select_Edit_objective_option_from_kabab_icon() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		createOKRpage.click_EditObjective();
	}

	@When("^user navigated to edit objective page$")
	public void user_navigated_to_edit_objective_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		createOKRpage.verify_EditObjectivesPage();
	}

	@When("^user change the objective name to \"([^\"]*)\" and remove one contributor$")
	public void user_change_the_objective_name_to_and_remove_one_contributor(String NewObjName) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		createOKRpage.edit_Objective(NewObjName);
	}

	@Then("^\"([^\"]*)\" should be updated with \"([^\"]*)\" and contributor should be removed$")
	public void should_be_updated_with_and_contributor_should_be_removed(String Objective, String NewObjName) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		boolean flag = false;
		Thread.sleep(5000);
		flag =createOKRpage.verify_Updated_Objective(Objective,NewObjName);
		assertTrue(flag);
	}

	@When("^User select Add Key Result option from kabab icon$")
	public void user_select_Add_Key_Result_option_from_kabab_icon() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		createOKRpage.click_AddKeyResult();
	}

	@When("^user navigated to Add Key Result page$")
	public void user_navigated_to_Add_Key_Result_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		createOKRpage.verify_AddKeyResultPage();
	}

	@Then("^Key result \"([^\"]*)\" should be added to \"([^\"]*)\"$")
	public void key_result_should_be_added_to(String keyName, String Objective) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		boolean flag = false;
		Thread.sleep(5000);
		flag = createOKRpage.verify_KeyResultAddedToObjective(keyName,Objective);
		assertTrue(flag);
	}

	@When("^User select Request Feedback option from kabab icon$")
	public void user_select_Request_Feedback_option_from_kabab_icon() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		createOKRpage.click_RequestFeedback();
	}

	@When("^user navigated to Request Feedback page$")
	public void user_navigated_to_Request_Feedback_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		createOKRpage.verify_RequestFeedbackPage();	
	}


	@When("^user enter the request feedback message$")
	public void user_enter_the_request_feedback_message() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		createOKRpage.enter_FeedbackRequestMessage();
	}

	@When("^Click on Send Button$")
	public void click_on_Send_Button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		createOKRpage.click_SendButton();
	}

	@Then("^verify feedback request should be send successfully$")
	public void verify_feedback_request_should_be_send_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		boolean flag= false;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Feedback has been requested successfully']")));
		if (driver.findElement(By.xpath("//*[text()='Feedback has been requested successfully']")).isDisplayed()) {
			System.out.println("Message has been sent successfully");
			 flag=true;
		}
		assertTrue(flag);
	}

	@When("^user click on notifications bell icon$")
	public void user_click_on_notifications_bell_icon() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		createOKRpage.click_NotificationIcon();
	}

	@When("^User click on requested feedback notification$")
	public void user_click_on_requested_feedback_notification() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		createOKRpage.click_UnreadFeedbackNotifications("requested for your feedback");
	}

	@When("^user navigated to Give Feedback page$")
	public void user_navigated_to_Give_Feedback_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		boolean flag = false;
		Thread.sleep(5000);
		flag = createOKRpage.verify_GiveFeedbackPage();
		assertTrue(flag);
	}

	
	@When("^user enter the feedback message \"([^\"]*)\"$")
	public void user_enter_the_feedback_message(String messagecontent) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		createOKRpage.enter_FeedbackMessage(messagecontent);
		System.out.println("Fedback message has been enetered");
	}
	
	
	@Then("^verify feedback  should be send successfully$")
	public void verify_feedback_should_be_send_successfully() throws Throwable {
		boolean flag= false;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Feedback has been given successfully']")));
		if (driver.findElement(By.xpath("//*[text()='Feedback has been given successfully']")).isDisplayed()) {
			System.out.println("Feedback has been sent successfully");
			 flag=true;
		}
		assertTrue(flag);
	}
	
	
	
	@When("^User click on given feedback notification$")
	public void user_click_on_given_feedback_notification() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		createOKRpage.click_UnreadFeedbackNotifications("responded to your feedback request");
	}

	
	@When("^user navigated to view Feedback page$")
	public void user_navigated_to_view_Feedback_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		boolean flag= false;
		flag = createOKRpage.Verify_ReceivedReadFeedback();
		assertTrue(flag);
	}
	
	@When("^user open the feedback provided$")
	public void user_open_the_feedback_provided() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		createOKRpage.openFeedbackComment();
	}

	@When("^click on reply button and open the feedback$")
	public void click_on_reply_button_and_open_the_feedback() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		createOKRpage.click_ReplyButton();
	}

	@When("^user enter the comment message \"([^\"]*)\"$")
	public void user_enter_the_comment_message(String messagecontent) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		createOKRpage.enter_FeedbackMessage(messagecontent);
		System.out.println("Fedback message has been enetered");
	}
	
	
	@Then("^verify feedback  message should be provided successfully$")
	public void verify_feedback_message_should_be_provided_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		boolean flag= false;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Comment added successfully']")));
		if (driver.findElement(By.xpath("//*[text()='Comment added successfully']")).isDisplayed()) {
			System.out.println("Comment has been added");
			 flag=true;
			 driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root drawer-close-btn']")).click();			
		}
		assertTrue(flag);
	}

	@When("^your expand all the OKRs$")
	public void your_expand_all_the_OKRs() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//createOKRpage.click_MyGaolsTab();
		createOKRpage.clickExpandAll();
	}

	@Then("^OKR count should be diaplyes correctly$")
	public void okr_count_should_be_diaplyes_correctly() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		boolean flag=false;
		flag = createOKRpage.verifyOKRCount();
		assertTrue(flag);
		System.out.println("OKR count is correctly displayed..");
	}

	@Then("^KR count should be displayed correctly$")
	public void kr_count_should_be_displayed_correctly() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		boolean flag=false;
		flag = createOKRpage.verifyKRCount();
		assertTrue(flag);
		System.out.println("KR count is correctly displayed..");
	}


	@When("^user expand all the OKRs$")
	public void user_expand_all_the_OKRs() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//createOKRpage.click_MyGaolsTab();
		createOKRpage.clickExpandAll();
	}

	@Then("^OKR KR progress calculation should be as per defined calculation$")
	public void okr_KR_progress_calculation_should_be_as_per_defined_calculation() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		boolean flag=false;
		flag = createOKRpage.verifyProgress();
		assertTrue(flag);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Before
	public void BeforeScenario(Scenario scenario) {
		// scenario.write("Scenario started");
		System.out.println("STarting..............");
	}

	public void afterScenario(Scenario scenario) throws IOException {
//			Date date = new Date();
//			//String currentDate = (date.toString().trim());
//			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH/mm/ss");  
//			LocalDateTime now = LocalDateTime.now();  
//			   
//			String screenshotGetName = scenario.getName();
//			String screenshot = screenshotGetName + dtf.format(now);
//			String screenshotName1 = screenshot.replaceAll(" ", "_");
//			String screenshotName = screenshotName1.replaceAll("/", "_");
//			
//			// This takes a screenshot from the driver at save it to the specified location
//			TakesScreenshot ts = ((TakesScreenshot) driver);
//			File sourcePath = ts.getScreenshotAs(OutputType.FILE);
//
//			// Building up the destination path for the screenshot to save
//			// Also make sure to create a folder 'screenshots' with in the cucumber-report
//			// folder
//			File destinationPath = new File(System.getProperty("user.dir")
//					+ "/target/site/cucumber-reports/cucumber-html-reports/screenshots/" + screenshotName + ".png");
//
//			// Copy taken screenshot from source location to destination location
//			Files.copy(sourcePath, destinationPath);

			// This attach the specified screenshot to the test
			//Reporter.addScreenCaptureFromPath(destinationPath.toString());
			driver.close();

			// } catch (IOException e) {
			// }


	}
}
