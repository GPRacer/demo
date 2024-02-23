package TestingPractisecompany.Tests;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String prodName="ZARA COAT 3";
WebDriverManager.chromedriver().setup();
WebDriver driver= new ChromeDriver();
driver.get("https://rahulshettyacademy.com/client");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
driver.manage().window().maximize();
WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(9));
driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
driver.findElement(By.id("login")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

List<WebElement> products = driver.findElements(By.xpath("//*[@class='card']"));
//wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//*[@class='card']"))));
System.out.println(products.size());
WebElement prod = products.stream().filter(p->p.findElement(By.xpath(".//b")).getText().equalsIgnoreCase(prodName)).findFirst().orElseThrow(null);

 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", prod.findElement(By.cssSelector(".card-body button:last-of-type")));

Thread.sleep(2000);
prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));

((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("button[routerlink*='cart']")));
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[routerlink*='cart']")));
Thread.sleep(2000);
driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
List<WebElement>cartProd=driver.findElements(By.cssSelector(".cartSection h3"));
boolean tru = cartProd.stream().anyMatch(c->c.getText().equalsIgnoreCase(prodName));
Assert.assertTrue(tru);
driver.findElement(By.cssSelector(".totalRow button")).click();
driver.findElement(By.xpath("//*[@placeholder='Select Country']")).click();
driver.findElement(By.xpath("//*[@placeholder='Select Country']")).sendKeys("ind");
List<WebElement> dropDown=driver.findElements(By.xpath("//span[@class='ng-star-inserted']"));
dropDown.stream().filter(d->d.getText().equalsIgnoreCase("India")).forEach(d->d.click());
//Thread.sleep(3000);
wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Place Order ']"))));
driver.findElement(By.xpath("//a[text()='Place Order ']")).click();


String actualId=driver.findElement(By.cssSelector("label[class*='inserted']")).getText();
Assert.assertEquals(actualId, " | 6586beb69fd99c85e8f1babf | ");


	}}






























//for(int i=0;i<products.size();i++)
//{
//	String prod=products.get(i).getText();
//	if(prod.equalsIgnoreCase("qwerty")) {
//	
//	  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElements(By.cssSelector(".card button:last-of-type")).get(i));
//	  Thread.sleep(1000);
//		driver.findElements(By.xpath("//div[@class='card-body'] //button[2]")).get(i).click();
//	}
//}
//driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
//List<WebElement> vegitables=driver.findElements(By.cssSelector(".product-name"));
////for(int i=0;i<vegitables.size();i++) {
////	String veggies=vegitables.get(i).getText();
////	if(veggies.equalsIgnoreCase("Potato - 1 Kg")) {
////		driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
////	}
//= vegitables.stream().filter(v->v.getText().equalsIgnoreCase("Potato - 1 Kg")).
////veg.findElement(By.cssSelector(".product-action button")).click();

	