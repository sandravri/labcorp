package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ExternalAdpPage {
	WebDriver driver;

	public ExternalAdpPage(WebDriver driver) {
		this.driver = driver;
	}

	// Handle Alert
	By closeButton = By.xpath("//button[@class='close closebutton ae-button']");
	// Job Title - Step 5
	By jobTitle = By.xpath("//span[@class='jobTitle job-detail-title']");
	// Job Location - Step 5
	By jobLocation = By.className("resultfootervalue");
	// Job ID - Step 5
	By jobId = By.xpath("//span[@class='jobnum']");
	// Text Search - Step 6
	By textSearchFirstSentThirdPara = By.xpath("//span[contains(text(),'The right candidate')]");
	// Return to Job Search
	By linkReturnToJobSearch = By.xpath("//button[@class='btn btn-secondary ae-button']");
//			By.className("btn btn-secondary ae-button");

	public void handlePageAlertsIfAny() {
		try {
			isAlertPresent();
			driver.findElement(closeButton).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Close Button Clicked");
	}

	public boolean isAlertPresent() throws InterruptedException {
		Thread.sleep(5000);
		if (driver.findElement(closeButton).isDisplayed())
			return true;
		else
			return false;
	}

	public boolean validateJobTitleLocationId(String jobtitle, String jobloc, String jobid) throws InterruptedException {
		
//		handlePageAlertsIfAny();
		
//		driver.findElement(jobTitle).click();
//		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(jobTitle);
		actions.doubleClick(elementLocator).perform();
		Thread.sleep(2000);
		if (driver.findElement(jobTitle).getText().contentEquals(jobtitle)
				&& driver.findElement(jobLocation).getText().contentEquals(jobloc)
				&& driver.findElement(jobId).getText().contentEquals(jobid))
			return true;
		else
			return false;
	}

	public boolean isjobTitleLocIdMatching() {
		return false;
	}

	public boolean confirmJobDescOnExtPage(String jobDescr) {
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(closeButton);
		actions.doubleClick(elementLocator).perform();
		
		if (driver.findElement(textSearchFirstSentThirdPara).getText().contains(jobDescr))
			return true;
		else
			return false;
	}

	public void clickReturnJobSearch() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println(linkReturnToJobSearch);
		driver.findElement(linkReturnToJobSearch).click();
	}

}
