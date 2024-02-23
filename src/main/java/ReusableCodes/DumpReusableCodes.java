package ReusableCodes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageOjectModle.CartPage;
import pageOjectModle.OrdersPage;

public class DumpReusableCodes {
	WebDriver driver;

	public DumpReusableCodes(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "button[routerlink*='cart']")
	WebElement AddToCart;
	@FindBy(css = "button[routerlink*='myorders']")
	WebElement clickOrders;
	

	public void waitUntilElementIsVisible(By byloacator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(byloacator));
	}

	public void waitUntilElementIsInVisible(By byloactor) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(byloactor));
	}

	public void waitUntilElementIsVisible(WebElement byloacator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(byloacator));
	}

	public CartPage Addtocart() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AddToCart);
		Thread.sleep(2000);
		AddToCart.click();
		return new CartPage(driver);
	}
	public OrdersPage ClickOrder() throws InterruptedException {
		
		
		clickOrders.click();
		return new OrdersPage(driver);
	}
	
}
