package pageObjects;

import java.util.Iterator;
import java.util.Set;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareersPage {
	WebDriver driver;

	public CareersPage(WebDriver driver) {
		this.driver = driver;
	}

	// Job Title From Search List
	By jobTitleFromList = By.xpath("//*[@id=\"search-results-list\"]/ul/li[1]/a/h2");
	// By linksss = By.linkText("")
	By jobTitleLinkFromList = By
			.cssSelector("a[href=\"/job/durham/senior-qa-test-automation-developer-engineer/668/3090755200\"]");
	// Job Location From Search List
	By jobLocationFromList = By.xpath("//*[@id=\"search-results-list\"]/ul/li[1]/a/span[1]");
	// Job PostedDate From Search List
	By jobPostedDateFromList = By.xpath("//*[@id=\"search-results-list\"]/ul/li[1]/a/span[2]");
	// Job Search Input
	// By jobKeyWordInput = By.id("search-keyword-ccf9697d38");
	By jobKeyWordInput = By.className("search-keyword");
	// Job Location Input
	By jobLocationInput = By.className("search-location");
	// Job Search button
	// By jobSearchSubmitBtn = By.id("search-submit-ccf9697d38");
	By jobSearchSubmitBtn = By.className("search-form__submit");
	// Job ID
	By jobId = By.xpath("//div[@class='job-description__info-items']/span[@class='job-id job-info']");
	// Accept cookies
	By acceptButton = By.id("gdpr-button");
	// Job location after clicking on job link
	By jobLocation = By.xpath("//span[@class='job-location job-info']");
	// Job title
	By jobTitle = By.className("job-description__heading");
	// Apply Now
	By applyNow = By.className("button job-apply top");
	// Text Search - Step 6
	By textSearchFirstSentThirdPara = By.xpath("//span[contains(text(),'The right candidate')]");
	// Text Search - Step 7
	By textSearchScndBltMgmtSprt = By.xpath("//*[@id=\"content\"]/div[3]/section[2]/div[2]/div[1]/ul[3]/li[2]/span");
	// Text Search - Step 7
	By textSearchThirdReq = By
			.xpath("//*[@id=\"content\"]/div[3]/section[2]/div[2]/div[2]/span/div[1]/ul[1]/li[3]/span");
	// familiar tool location
	// *[@id="content"]/div[3]/section[2]/div[2]/div[2]/span/div[1]/ul[1]/li[12]/span
	// Text Search - Step 7
	By textSearchFirstSgstAutoTool = By
			.xpath("//*[@id=\"content\"]/div[3]/section[2]/div[2]/div[2]/span/div[1]/ul[2]/li[1]/span/span[2]");
	// Apply Now link
	By linkClickApplyNow = By.xpath("//a[@class='button job-apply top']");
	// *[@id="content"]/div[3]/section[2]/div[2]/div[2]/span/div[4]/span/a/

	public boolean onRightPage() throws InterruptedException {
		Thread.sleep(2000);
		switchWindows();
		String newurl = driver.getCurrentUrl();
		if (newurl.contentEquals("https://jobs.labcorp.com/"))
			return true;
		else
			return false;
	}

	private void switchWindows() {
		int numberOfWins = driver.getWindowHandles().size();
		System.out.println(numberOfWins + " - window handles total ");

		String mainWinHandle = driver.getWindowHandle();
		System.out.println(mainWinHandle + " -  main win handle ");

		String mainPageTitle = driver.getTitle();
		System.out.println(mainPageTitle + " -- main page title ");

		Set<String> allWinHans = driver.getWindowHandles();
		Iterator<String> iter = allWinHans.iterator();
		System.out.println(iter + " - - - should be 2 window handles ---- ");

		while (iter.hasNext()) {
			String newWindow = iter.next();
			if (!mainWinHandle.equalsIgnoreCase(newWindow)) {
				driver.switchTo().window(newWindow);
				System.out.println("Heading of new window is  - " + driver.getTitle());
			}
		}
	}

	public void searchJob(String jobSearchText) throws InterruptedException {
		handlePageAlertsIfAny();
		driver.findElement(jobKeyWordInput).sendKeys(jobSearchText);
		Thread.sleep(1000);
		driver.findElement(jobLocationInput).clear();
		Thread.sleep(1000);
		driver.findElement(jobSearchSubmitBtn).click();
		Thread.sleep(3000);
	}

	public void handlePageAlertsIfAny() {
		try {
			isAlertPresent();
			driver.findElement(acceptButton).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Accept Button Clicked");
	}

	public boolean isAlertPresent() throws InterruptedException {
		Thread.sleep(1000);
		if (driver.findElement(acceptButton).isDisplayed())
			return true;
		else
			return false;
	}

	public void checkListForRequiredDetails(String jobTitle, String locationOfJob, String dateOfPosting) {
		String jobTitleFromCareersPage = driver.findElement(jobTitleFromList).getText();
		Assert.assertEquals(jobTitle, jobTitleFromCareersPage);

		String jobLocationFromCareersPage = driver.findElement(jobLocationFromList).getText();
		Assert.assertEquals(locationOfJob, jobLocationFromCareersPage);

		String jobDateFromCareersPage = driver.findElement(jobPostedDateFromList).getText();
		Assert.assertEquals(dateOfPosting, jobDateFromCareersPage);
	}

	public String getJobIdForTitleLocation() throws InterruptedException {
		driver.findElement(jobTitleLinkFromList).click();
		Thread.sleep(3000);
		return driver.findElement(jobId).getText();
	}

	public String getFirstSentThirdPara() {
		return driver.findElement(textSearchFirstSentThirdPara).getText();
	}

	public String getScndBltMgmtSprt() {
		return driver.findElement(textSearchScndBltMgmtSprt).getText();
	}

	public String getThirdReq() {
		return driver.findElement(textSearchThirdReq).getText();
	}

	public String getFirstSgstAutoTool() {
		return driver.findElement(textSearchFirstSgstAutoTool).getText();
	}

	public void clickApplyNow() {
		driver.findElement(linkClickApplyNow).click();
		System.out.println("Going to next page after ... " + driver.getTitle());
	}
}
