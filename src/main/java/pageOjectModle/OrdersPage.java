package pageOjectModle;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableCodes.DumpReusableCodes;

public class OrdersPage extends DumpReusableCodes{
	WebDriver driver;
	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//tr/td[2]")
	List<WebElement> orderText;
	
	public boolean displayOrderName(String productName) {
		return orderText.stream().anyMatch(o->o.getText().equalsIgnoreCase(productName));
	}
}
