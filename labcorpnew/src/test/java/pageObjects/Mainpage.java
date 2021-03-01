package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mainpage {

	WebDriver driver;

	public Mainpage(WebDriver driver) {
		this.driver = driver;
	}

	// OneTrust cookies - page alert
	By oneTrust = By.xpath("//*[@id=\"onetrust-close-btn-container\"]/a");
	// Career path link
	By cpath = By.xpath("//*[@id=\"block-footer\"]/ul/li[10]");
	// Search 'Careers'
	By careersWord = By.xpath("//*[@id=\"block-footer\"]/ul/li[10]/a");

	public void openPage(String pageUrl) throws InterruptedException {
		driver.get(pageUrl);
		Thread.sleep(2000);
		driver.manage().window().maximize();
	}

	public boolean checkRightPageisOpen() throws InterruptedException {
		Thread.sleep(2000);
		String newurl = driver.getCurrentUrl();
		if (newurl.contentEquals("https://www.labcorp.com/"))
			return true;
		else
			return false;
	}

	public void handlePageAlertsIfAny() {
		try {
			isAlertPresent();
			driver.findElement(oneTrust).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("One trust clicked");
	}

	public boolean isAlertPresent() throws InterruptedException {
		Thread.sleep(1000);
		if (driver.findElement(oneTrust).isDisplayed())
			return true;
		else
			return false;
	}

	public boolean findCareersLink() {
		handlePageAlertsIfAny();
		Boolean crr = driver.findElement(careersWord).getText().contains("Careers");
		return crr;
	}

	public void clickCareersLink() {
		driver.findElement(cpath).click();
	}
}