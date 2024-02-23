package pageOjectModle;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ReusableCodes.DumpReusableCodes;

public class ProductCataloguePage extends DumpReusableCodes {
	WebDriver driver;

	public ProductCataloguePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
//	List<WebElement> products = driver.findElements(By.xpath("//*[@class='card']"));
//	System.out.println(products.size());
//	WebElement prod = products.stream().filter(p->p.findElement(By.xpath(".//b")).getText().equalsIgnoreCase(prodName)).findFirst().orElseThrow(null);
	@FindBy(xpath="//*[@class='card']")
	List<WebElement> products; //this is find elements plural so we used list<webelement>
	
	By locator=By.cssSelector(".mb-3");//this is we call as By locators and driver.findelement(by.cssSelector))we call as webElement locator
	By prodtext=By.xpath(".//b");
	By confirm=By.id("toast-container");
	By load=By.cssSelector(".ng-animating");
	By Addtocart =By.cssSelector(".card-body button:last-of-type");
	
	public List<WebElement> productsLoaded() {
		waitUntilElementIsVisible(locator);
		return products;
	}

	public WebElement productName(String prodName) {
		
		
		WebElement prod = productsLoaded().stream().filter(p->p.findElement(prodtext).getText().equalsIgnoreCase("ZARA COAT 3")).findFirst().orElseThrow(null);
		return prod;
	}
	
	public void addToCart(String prodName) throws InterruptedException
	{
		WebElement prod = productName(prodName);
	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", prod.findElement(Addtocart));
 	 Thread.sleep(2000);

		prod.findElement(Addtocart).click();
		waitUntilElementIsVisible(confirm);
		waitUntilElementIsInVisible(load);
	}

}
