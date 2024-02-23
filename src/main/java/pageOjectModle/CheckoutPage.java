package pageOjectModle;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableCodes.DumpReusableCodes;

public class CheckoutPage extends DumpReusableCodes{
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
//	driver.findElement(By.xpath("//*[@placeholder='Select Country']")).click();
//	driver.findElement(By.xpath("//*[@placeholder='Select Country']")).sendKeys("ind");
//	List<WebElement> dropDown=driver.findElements(By.xpath("//span[@class='ng-star-inserted']"));
//	dropDown.stream().filter(d->d.getText().equalsIgnoreCase("India")).forEach(d->d.click());
	//driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
	@FindBy(xpath="//*[@placeholder='Select Country']")
    WebElement clickonselectcountry;
	@FindBy(xpath="//span[@class='ng-star-inserted']")
	List<WebElement> dropdowncountry;
	@FindBy(xpath="//a[text()='Place Order ']")
	WebElement OrderPlaced;
	
	public void selectcountry(String country) throws InterruptedException
	{
		clickonselectcountry.sendKeys(country);
		Thread.sleep(2000);
	}
	public void click(String country) {
		for(int i=0;i<dropdowncountry.size();i++) {
		String CountryName=dropdowncountry.get(i).getText();
		if(CountryName.equalsIgnoreCase(country)) {
			dropdowncountry.get(i).click();
			break;
		}
	}
		
}
	public PlaceOrderPage placeOrder() {
		OrderPlaced.click();
		return new PlaceOrderPage(driver);
	}}
	
