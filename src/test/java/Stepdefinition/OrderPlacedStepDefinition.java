package Stepdefinition;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import BaseTest.Tests.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageOjectModle.CartPage;
import pageOjectModle.CheckoutPage;
import pageOjectModle.LandingPage;
import pageOjectModle.PlaceOrderPage;
import pageOjectModle.ProductCataloguePage;

public class OrderPlacedStepDefinition extends Base{
	public LandingPage page;
	public ProductCataloguePage page2;
	public 	CartPage cart;
	public 	PlaceOrderPage po;
	@Given("I landed on the Ecommerce Page")
	public void I_landed_on_the_Ecommerce_Page() throws IOException {
		page=launchAppication();
	}
	
	@Given("^Logged in with the UserName(.+)and Password(.+)$")
	public void Logged_in_with_the_UserName_and_Password(String UserName, String Password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9));
		 page2 = page.Login(UserName,Password);
	}
	
	@When("^I add the product (.+)to the cart$")
	public void I_add_the_product_to_the_cart(String prodName) throws InterruptedException {
		List<WebElement> products = page2.productsLoaded();
		System.out.println(products.size());
		WebElement prod = page2.productName(prodName);
		page2.addToCart(prodName);
		cart = page2.Addtocart();
	}
	 @And("^checkout(.+)and submit the order$")//we used(.+)it will take any kind of data coming from examples that is we called as regular expression it will startwith^symbol and end with $symbol
	 public void checkout_and_submit_the_order(String prodName) throws InterruptedException {
		 boolean tru = cart.ItemsDisplay(prodName);
			Assert.assertTrue(tru);
			CheckoutPage check = cart.checkout();
			check.selectcountry("ind");
			check.click("India");
			 po = check.placeOrder();
	 }
	@Then("{string} message is displayed on the confirmation page")
	public void message_is_displayed_on_the_confirmation_page(String string) {
		String confirmation = po.displayconfirmationText();
		Assert.assertEquals(confirmation, "THANKYOU FOR THE ORDER.");
	}

	@Then("user should see this error message{string}")
	public void Then_user_should_see_this_error_message(String string) {
		Assert.assertEquals(string, page.displayerror());
		driver.close();	}
}
