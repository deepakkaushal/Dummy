package com.Common;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import pageObject.Case1PO;
import stepDefinition.TestRunner;


public class Common extends TestRunner {
	

	/*public static WebDriver driver = new FirefoxDriver();
	static DesiredCapabilities caps = DesiredCapabilities.firefox();*/
	
	public static DesiredCapabilities capabilities;
	
	static WebDriverWait wait = null;
	public static WebDriver driver;
	
	
	
	
	
	
	

	public static void open_URL(String URL) {

		System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\Cucumber_Selenium\\drivers\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("start-maximized");
    	options.addArguments("--disable-extensions");
    	options.addArguments("--disable-infobars");
    	Map<String, Object> prefs = new HashMap<String, Object>();
    	prefs.put("credentials_enable_service", false);
    	prefs.put("profile.password_manager_enabled", false);
    	prefs.put("excludeSwitches", "enable-automation");
    	options.setExperimentalOption("prefs", prefs);
    	capabilities = DesiredCapabilities.chrome();
    	capabilities.setCapability("version", "latest");
    	capabilities.setCapability("browserName", "chrome");
    	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		 driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//caps.setBrowserName("firefox");
		driver.get(URL);

	}

	public static String getValue(String input) throws IOException {

		FileReader reader = new FileReader("D:\\Workspace\\Cucumber_Selenium\\src\\test\\java\\resources\\config.properties");
		Properties prop = new Properties();
		prop.load(reader);
		String getProp = prop.getProperty(input);

		return getProp;
	}


	public static void exitBrowser() {
		driver.quit();
	}


	public static void scenarioName(String testName, String description) {

		extentTest = extentReports.startTest(testName, description);

	}

	public static WebElement waitForElement(WebElement element) {

		try {

			wait = new WebDriverWait(driver, 40000);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception

			System.err.println(e.getStackTrace());

		}
		return element;

	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	

}
