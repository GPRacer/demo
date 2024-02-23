package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public  class ExtentReportNg {
public static ExtentReports getReport() {
	String path="D:\\Javaselenium_Practise\\SeleniumFrameWorkDesign"+"\\Rep\\index.html";
	ExtentSparkReporter ex=new ExtentSparkReporter(path);
	ex.config().setReportName("Automation Report");
	ex.config().setDocumentTitle("SeleniumFrameWOrk");
	ExtentReports ext=new ExtentReports();
	ext.attachReporter(ex);
	ext.setSystemInfo("Tester", "GP");
	return ext;
}
}
