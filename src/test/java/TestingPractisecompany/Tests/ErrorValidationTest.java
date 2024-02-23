package TestingPractisecompany.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseTest.Tests.Base;
import pageOjectModle.CartPage;
import pageOjectModle.ProductCataloguePage;

public class ErrorValidationTest extends Base {
	@Test(groups = {"Error Handling"},retryAnalyzer = retry.class)
	public void loginPagerrorValidation() {

		ProductCataloguePage page2 = page.Login("anshika@gmail.com", "Iamking@00");
		Assert.assertEquals("Incorrect d			password.", page.displayerror());

	}
	@Test(dataProvider = "getData", groups = {"data"})
	public void cataloguepagPagerrorValidation(HashMap<String,String> input) throws InterruptedException {

		//String prodName = "ZARA COAT 3";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9));
		ProductCataloguePage page2 = page.Login(input.get("Email"), input.get("pass"));
		List<WebElement> products = page2.productsLoaded();
		System.out.println(products.size());
		WebElement prod = page2.productName(input.get("prod"));
		Assert.assertFalse(prod.getText().contains("ring"));
		
		
		
	}
//	@DataProvider
//	public Object[][] getData() {
//		Object[][] data = new Object[2][3];//this is one type data provider using two dimensional array
//		data[0][0]="anshika@gmail.com";
//		data[0][1]="Iamking@000";
//		data[0][2]="ZARA COAT 3";
//		
//		data[1][0]="devil@gmail.com";
//		data[1][1]="Iamking@000";
//		data[1][2]="adi";
//		return data;
//	}
//	@DataProvider
// public Object[][] getData() {
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("Email", "anshika@gmail.com");
//		map.put("pass", "Iamking@000");
//		map.put("prod", "ZARA COAT 3");
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("Email", "devil@gmail.com");
//		map1.put("pass", "Iamking@000");
//		map1.put("prod", "ZARA COAT 3");
//		return new Object[][] {{map},{map1}};
//		getJsonData
//	}
	@DataProvider
	 public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData("D:\\Javaselenium_Practise\\SeleniumFrameWorkDesign\\src\\test\\java\\dataReader\\data.json");
			return new Object[][] {{data.get(0)},{data.get(1)}};
			
		}
}
