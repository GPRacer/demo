package BaseTest.Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageOjectModle.LandingPage;


public class Base {
	public WebDriver driver;
	public LandingPage page ;
public WebDriver initializationofDriver() throws IOException {
	Properties prop = new Properties();//properties is the class
	FileInputStream fil=new FileInputStream("D:\\Javaselenium_Practise\\SeleniumFrameWorkDesign\\src\\main\\java\\Resources\\global.properties");//user.dir will get the local name of the project that is in my local system project name->D:\Javaselenium_Practise\SeleniumFrameWorkDesign
	prop.load(fil);//it is asking return type as input stream so initialize so declare input straem and load is used to load the properties file
	String br =System.getProperty("browser")!=null?System.getProperty("browser"): prop.getProperty("browser");//this is ternary operator if any browser detailes coming from CMD it will execute system.getprop other wise it will executes prop.property
	if(br.equalsIgnoreCase("chrome")) {
	 driver=new ChromeDriver();
	}
	else if(br.equalsIgnoreCase("edge")) {
		driver=new EdgeDriver();
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	return driver;
	
	
	

}
@BeforeMethod(alwaysRun = true)//alwaysrun=true-it will run every time without any restriction
public LandingPage launchAppication() throws IOException {
	driver=initializationofDriver();
	page = new LandingPage(driver);
	page.goTo();
	return page;
}
@AfterMethod(alwaysRun = true)
public void teardown() {
	driver.close();
}
public List<HashMap<String,String>> getJsonData(String file) throws IOException {
	String jsoncontent = FileUtils.readFileToString(new File(file),StandardCharsets.UTF_8);//reads the json file
	//convert string to hasmap will use jaksondatabind dependency in pom add it
	ObjectMapper map=new ObjectMapper();//in this class we have one method that will convert string to hashmap
	List<HashMap<String, String>> data = map.readValue(jsoncontent, new TypeReference<List<HashMap<String, String>>>(){
	});//it willconver string to hashmap and hashmap to array list
	return data;
	
	
}
public String takeScreenshot(String TestCaseName, WebDriver driver) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File Source = ts.getScreenshotAs(OutputType.FILE);
	File file=new File("D:\\Javaselenium_Practise\\SeleniumFrameWorkDesign"+"\\Rep\\"+TestCaseName+".png");
	FileUtils.copyFile(Source, file);
	return "D:\\Javaselenium_Practise\\SeleniumFrameWorkDesign"+"\\Rep\\"+TestCaseName+".png";
}

}
