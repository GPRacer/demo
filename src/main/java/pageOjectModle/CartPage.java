package pageOjectModle;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableCodes.DumpReusableCodes;

public class CartPage extends DumpReusableCodes{
WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".cartSection h3")
	List<WebElement> Itemsaddedtocart;
	@FindBy(css=".totalRow button")
	WebElement checkout;
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	
	
	public boolean ItemsDisplay(String prodName) {
	boolean tru = Itemsaddedtocart.stream().anyMatch(c->c.getText().equalsIgnoreCase(prodName));
	return tru;
	}
	public CheckoutPage checkout() {
		checkout.click();
		return new CheckoutPage(driver);
		
	}
	
	

}
