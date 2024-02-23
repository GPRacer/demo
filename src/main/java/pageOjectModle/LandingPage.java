package pageOjectModle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableCodes.DumpReusableCodes;
//page object model we will directly assign data we just define webelement and action methods

public class LandingPage extends DumpReusableCodes{
WebDriver driver;
//below is constructor we used here because this is the method first invoes first means constructor wil be invoked first before executing anything for initialization we used this
	public LandingPage(WebDriver driver) {
		super(driver);//sending the driver parameter to super class that dumpreusablecode
		this.driver=driver;
		PageFactory.initElements(driver, this);//using this method we are initializing the driver for page factory init elements take two argument driver and this we used because to reference our global driver in this class.
	}
	
	//driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
	//driver.findElement(By.id("login")).click();
	//WebElement UserId=driver.findElement(By.id("userEmail"));
	@FindBy(id="userEmail")//instead above technique we will use @Find by this is called page factory so here we can ask like in previous technique we used driver.findelement here where is driver so you can see we initialized in the above constructor that is init elements.
	WebElement UserId;
	
	@FindBy(id="userPassword")
	WebElement Pass;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='toast-message']")
	WebElement errortext;
	//this is the action method
	public ProductCataloguePage Login(String id, String password)
	{
		UserId.sendKeys(id);
		Pass.sendKeys(password);
		submit.click();
		return new ProductCataloguePage(driver);
		
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	public String displayerror() {
		waitUntilElementIsVisible(errortext) ;
		return errortext.getText();
	}
}
