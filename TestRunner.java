package stepDefinition;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.Common.Common;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/java/features", glue = "stepDefinition", plugin = {
				"com.cucumber.listener.ExtentCucumberFormatter:Result/report.html" }, 
		
		tags = { "@Register" })

public class TestRunner extends AbstractTestNGCucumberTests {

	public static ExtentReports extentReports = null;
	public static ExtentTest extentTest = null;

	@BeforeClass

	public static void extent() throws IOException {

		extentReports = new ExtentReports("D:\\Workspace\\Cucumber_Selenium\\LogsAndReports\\Report.html");

	}

	@AfterClass

	public static void flush() {

		extentReports.flush();

		//extentReports.close();

		Common.driver.quit();

	}

}