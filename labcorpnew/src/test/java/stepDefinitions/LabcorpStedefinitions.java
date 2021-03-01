package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.core.runner.Runner;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CareersPage;
import pageObjects.ExternalAdpPage;
import pageObjects.Mainpage;


public class LabcorpStedefinitions {
	static WebDriver driver;
	public static Mainpage mainpage;
	public static CareersPage careersPage;
	public static ExternalAdpPage externalAdpPage;
	///*** added for Before class
	
	
	
	@Given("^I open the website \"([^\"]*)\" using a chrome browser$")
	public void i_open_the_website_using_a_chrome_browser(String url_lc) throws Throwable {
		
		//String path="/labcorpnew/drivers/chromedriver.exe"
		System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
		driver = new ChromeDriver();
		Thread.sleep(1000);
		mainpage = new Mainpage(driver);
		mainpage.openPage(url_lc);
		Thread.sleep(2000);
		Assert.assertTrue(mainpage.checkRightPageisOpen());
	}

	@Given("^I find the Careers link$")
	public void i_find_the_Careers_link() throws Throwable {
		Assert.assertTrue(mainpage.findCareersLink());
	}

	@When("^I click the Careers link$")
	public void i_click_the_Careers_link() throws Throwable {
		mainpage.clickCareersLink();
		careersPage = new CareersPage(driver);
		Assert.assertTrue(careersPage.onRightPage());
	}

	@When("^Search for \"([^\"]*)\"$")
	public void search_for(String jobSearchText) throws Throwable {
		careersPage.searchJob(jobSearchText);
	}

	@When("^I get a list of options that has \"([^\"]*)\" with \"([^\"]*)\" posted on \"([^\"]*)\"$")
	public void i_get_a_list_of_options_that_has_with_posted_on(String jobTitle, String locationOfJob,
			String dateOfPosting) throws Throwable {
		careersPage.checkListForRequiredDetails(jobTitle, locationOfJob, dateOfPosting);
	}

	@Then("^I validate the job title, location and job id \"([^\"]*)\"$")
	public void i_validate_the_job_title_location_and_job_id(String jobId) throws Throwable {
		String jobIdFromSearch = careersPage.getJobIdForTitleLocation();
		Assert.assertEquals("Job ID " + jobId, jobIdFromSearch);
	}

	@Then("^I confirm first sentence of third paragraph under Description/Intro as \"([^\"]*)\"$")
	public void i_confirm_first_sentence_of_third_paragraph_under_Description_Intro_as(String firstSentThirdPara)
			throws Throwable {
		Assert.assertTrue(careersPage.getFirstSentThirdPara().contains(firstSentThirdPara));
	}

	@Then("^I confirm second bullet point under Management Support as \"([^\"]*)\"$")
	public void i_confirm_second_bullet_point_under_Management_Support_as(String scndBltMgmtSprt) throws Throwable {
		Assert.assertTrue(careersPage.getScndBltMgmtSprt().contains(scndBltMgmtSprt));
	}

	@Then("^I confirm third requirement as \"([^\"]*)\"$")
	public void i_confirm_third_requirement_as(String thirdReq) throws Throwable {
		Assert.assertTrue(careersPage.getThirdReq().contains(thirdReq));
	}

	@Then("^I confirm first suggested automation tool to be familiar with contains \"([^\"]*)\"$")
	public void i_confirm_first_suggested_automation_tool_to_be_familiar_with_contains(String firstSgstAutoTool)
			throws Throwable {
		Assert.assertTrue(careersPage.getFirstSgstAutoTool().contains(firstSgstAutoTool));
	}

	@When("^I click Apply Now$")
	public void i_click_Apply_Now() throws Throwable {
		careersPage.clickApplyNow();
	}

	@Then("I validate on External Page that the job title is \"([^\"]*)\", location is \"([^\"]*)\" and job id is \"([^\"]*)\"$")
	public void i_validate_on_external_page_that_the_job_title_location_and_job_id(String jobtitle, String jobloc, String jobid) throws Throwable {
		externalAdpPage = new ExternalAdpPage(driver);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		Assert.assertTrue(externalAdpPage.validateJobTitleLocationId(jobtitle, jobloc, "#" + jobid));
//		Assert.assertTrue(externalAdpPage.isjobTitleLocIdMatching());
//		String jobIdFromExtPage = externalAdpPage.getJobIdFromExtPage();
//		Assert.assertEquals("Job ID" + jobid, jobIdFromExtPage);
	}

	@Then("I confirm on External Page first sentence of third paragraph under Description\\/Intro as \"([^\"]*)\"$")
	public void i_confirm_on_external_page_first_sentence_of_third_paragraph_under_description_intro_as(String descr) {
		Assert.assertTrue(externalAdpPage.confirmJobDescOnExtPage(descr));
	}

	@Then("^I click to return to Job Search$")
	public void i_click_to_return_to_Job_Search() throws Throwable {
		externalAdpPage.clickReturnJobSearch();
//		driver.quit();
		driver.close();
	}

}
