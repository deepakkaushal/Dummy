package com.Common;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import pageObject.Case1PO;

public class Case1Action extends Common{
	
	public Case1PO PO = new Case1PO();
	
	
	
	
	public static void clickSignUpLink() throws IOException, InterruptedException{
		
		PageFactory.initElements(Common.driver, Case1PO.class);
		
		open_URL(getValue("Case1URL"));
		extentTest.log(LogStatus.INFO, "URL opened");

		driver.findElement(By.cssSelector(Case1PO.css_AccountLink)).click();
		driver.findElement(By.cssSelector(Case1PO.css_SignUpButton)).click();
	}
	
	
	public static void enterField(String Fname, String Lname, String Email, String Phone, String Changepwd){
		
		
		
		driver.findElement(By.cssSelector(Case1PO.css_FirstNameTextField)).sendKeys(Fname);
		
		driver.findElement(By.cssSelector(Case1PO.css_LastNameTextField)).sendKeys(Lname);
		
		driver.findElement(By.cssSelector(Case1PO.css_EmailTextField)).sendKeys(Email);
		
		driver.findElement(By.cssSelector(Case1PO.css_PhoneNumber)).sendKeys(Phone);
		
		driver.findElement(By.cssSelector(Case1PO.css_PasswordTextField)).sendKeys(Changepwd);
		
		driver.findElement(By.cssSelector(Case1PO.css_SubscribeCheckBox)).click();

		
	}
	
	
	public static void clickProfileSignUpButton() throws InterruptedException{
		
		driver.findElement(By.cssSelector(Case1PO.css_ProfileSignUpButton)).click();
		Thread.sleep(10000);
	}
	
	
public static void clickMyAccount() throws IOException, InterruptedException{
		
		
	driver.findElement(By.cssSelector(Case1PO.css_AccountLink)).click();
	//driver.findElement(By.xpath(Case1PO.xpath_MyAccountLink)).click();
	
	}
	
	public static void clickEditLink(){
		
		driver.findElement(By.linkText(Case1PO.linkText_YourDetailEditLink)).click();
		
		
	}
	
	public static boolean verifyForNonEditEmailField(){
		
		boolean getStatusOfEmailField = driver.findElement(By.cssSelector(Case1PO.css_EmailTextField)).isEnabled();
		return getStatusOfEmailField;
	}
	
        public static String verifySameEmailExist(){
		
       String getEmailId = driver.findElement(By.cssSelector(Case1PO.css_EmailTextField)).getAttribute("value");
	   return getEmailId;

	
	
	}
        
        
        public static void updatePhoneNumber(String updatephone) throws InterruptedException{
        	
        	
        	driver.findElement(By.cssSelector(Case1PO.css_PhoneNumber)).clear();        	
        	driver.findElement(By.cssSelector(Case1PO.css_PhoneNumber)).sendKeys(updatephone);
        	driver.findElement(By.cssSelector(Case1PO.css_UpdateDetailButton)).click();
        	Thread.sleep(2000);
        }
        
	
        
	}


