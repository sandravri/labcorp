package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.CareersPage;
import pageObjects.Mainpage;

public class GoogleSteps {

	WebDriver driver;
	public static Mainpage mainpage;
	public static CareersPage careerspage;

	@Given("I launch application")
	public void i_launch_application() throws InterruptedException {
		String Chromedriver = "C:\\CTS Trainings\\Selenium drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", Chromedriver);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.wait(1000);
	}

	@Then("I open google.com")
	public void i_open_google_com() {
		System.out.println("hello");
	}

}
