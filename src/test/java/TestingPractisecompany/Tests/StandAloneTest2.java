package TestingPractisecompany.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.function.Predicate;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.Tests.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageOjectModle.CartPage;
import pageOjectModle.CheckoutPage;
import pageOjectModle.LandingPage;
import pageOjectModle.OrdersPage;
import pageOjectModle.PlaceOrderPage;
import pageOjectModle.ProductCataloguePage;

public class StandAloneTest2 extends Base {
	String prodName = "ZARA COAT 3";
	@Test
	public void submitTest() throws IOException, InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9));
		ProductCataloguePage page2 = page.Login("anshika@gmail.com", "Iamking@000");
		List<WebElement> products = page2.productsLoaded();
		System.out.println(products.size());
		WebElement prod = page2.productName(prodName);
		page2.addToCart(prodName);
		CartPage cart = page2.Addtocart();
		boolean tru = cart.ItemsDisplay(prodName);
		Assert.assertTrue(tru);
		CheckoutPage check = cart.checkout();
		check.selectcountry("ind");
		check.click("India");
		PlaceOrderPage po = check.placeOrder();
		String confirmation = po.displayconfirmationText();
		Assert.assertEquals(confirmation, "THANKYOU FOR THE ORDER.");
		}
	@Test(dependsOnMethods= {"submitTest()"})
	public void odersDisplay() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9));
		ProductCataloguePage page2 = page.Login("anshika@gmail.com", "Iamking@000");
		OrdersPage pag=page.ClickOrder();
		boolean name = pag.displayOrderName(prodName);
		Assert.assertTrue(name, prodName);
		
		
	}
}
