package pageOjectModle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableCodes.DumpReusableCodes;

public class PlaceOrderPage extends DumpReusableCodes{
	WebDriver driver;
	public PlaceOrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//String actualId=driver.findElement(By.cssSelector("label[class*='inserted']")).getText();
	@FindBy(css=".hero-primary")
	WebElement confirmation;
	
	public String displayconfirmationText() {
		String confirm = confirmation.getText();
		return confirm;
	}
}

