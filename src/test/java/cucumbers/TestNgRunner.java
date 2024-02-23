package cucumbers;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= "src\\test\\java\\cucumbers", glue="Stepdefinition",monochrome =true,tags="@error", plugin = {"html:target/cucmber.html"})//features-in this we need give features file path and in glue we need to give stepdefinition pacakge name and monochrom-by default cucmber will not be in readble format so will set monochrome as true after that we can read and what kind of report we want that will give in plugin in the keyvalue pair foe exxample if we want HTML reportin the we mention HTML and value pair will mention format
//by default cucumber will not support testng related code so will extend one class called AbstractTestNGCucmber
public class TestNgRunner extends AbstractTestNGCucumberTests {

}
