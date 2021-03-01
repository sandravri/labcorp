package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	
	WebDriver driver;
	 
	 public HomePage(WebDriver driver) {
	          this.driver = driver;
	 }
	 
	 //Locator for OneTrust cookies
	   By oneTrust = By.xpath("//*[@id=\"onetrust-close-btn-container\"]/a");

	//Locator for Carriers link
	   By carriersLink = By.xpath("//*[@id=\"block-footer\"]/ul/li[10]");
	   
	   public void clickCarriersLink(){
		   driver.findElement(carriersLink).click();   
	   }
	   
}
