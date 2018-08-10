package stepDefinition;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Common.Case1Action;
import com.Common.Common;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.Case1PO;

public class Case1Scenario extends Case1Action{
	
	public String Email;
	public String UpdatePhoneNo;
	
	@Given("^Create An Account page$")
	public void create_An_Account_page() throws IOException, InterruptedException{
	    
		PageFactory.initElements(Common.driver, Case1PO.class);
		Common.scenarioName("Case1Action", "1.1 Register Account We need you to register an account on nisnass through automation");
		Case1Action.clickSignUpLink();
	    
	}

	@When("^Enter all mandatory fields$")
	public void enter_all_mandatory_fields() throws IOException{
		
		String fName = Common.getValue("FirstName")+RandomStringUtils.randomAlphabetic(2);
		String lName = Common.getValue("LastName")+RandomStringUtils.randomAlphabetic(2);
	           Email = RandomStringUtils.randomAlphabetic(2)+Common.getValue("Email");
		String Phone = Common.getValue("PhoneNumber")+RandomStringUtils.randomNumeric(5);
	    
		Case1Action.enterField(fName, lName, Email, Phone, Common.getValue("Password"));
	    
	}

	@When("^Click on Create An Account button$")
	public void click_on_Create_An_Account_button() throws InterruptedException{
		
	    Case1Action.clickProfileSignUpButton();
	    
	}

	@Then("^User redirect to Home page and Account icon display$")
	public void user_redirect_to_Home_page_and_Account_icon_display() throws IOException{
	   
	    String getCurrentURL = driver.getCurrentUrl();
	    System.out.println(getCurrentURL);
	    Assert.assertTrue(getCurrentURL.equals(Common.getValue("Case1URL")), "URL does not matched. Assertion fail");
	    
	}

	@When("^I click on My Account option$")
	public void i_click_on_My_Account_option() throws IOException, InterruptedException{
	    
	    Case1Action.clickMyAccount();
		
	}

	@When("^Click on Edit link under your detail section$")
	public void click_on_Edit_link_under_your_detail_section(){
	    
		Case1Action.clickEditLink();
		extentTest.log(LogStatus.INFO, "Clicked on edit link");
		
		System.out.println("Clicked on edit link");
		
	    
	}

	@Then("^Email address display in non-editable mode$")
	public void email_address_display_in_non_editable_mode(){
	    
		
		boolean checkEmailStatus = Case1Action.verifyForNonEditEmailField();
		Assert.assertFalse(checkEmailStatus, "Email is enable. Assertion fail :(");
	    
	}

	@Then("^it is the same email with which you registered the account$")
	public void it_is_the_same_email_with_which_you_registered_the_account(){
		
		String getExistingEmail = Case1Action.verifySameEmailExist();
		System.out.println(getExistingEmail);
		Assert.assertTrue(getExistingEmail.contains(Email), "Email id does not matched. Assertion failed");
	    
	    
	}

	@When("^Update the phone number and click on Update details button$")
	public void update_the_phone_number_and_click_on_Update_details_button() throws InterruptedException, IOException{
		
		UpdatePhoneNo = Common.getValue("PhoneNumber")+RandomStringUtils.randomNumeric(5);
		Case1Action.updatePhoneNumber(UpdatePhoneNo);
		System.out.println(UpdatePhoneNo);
	    
	}

	@Then("^Phone number is updated successfully$")
	public void phone_number_is_updated_successfully(){
		
		driver.navigate().back();
		String getUpdatedPhoneNo = driver.findElement(By.xpath(".//*[contains(text(),' "+UpdatePhoneNo+"')]")).getText();
		System.out.println(getUpdatedPhoneNo);
		
		System.out.println("Done");
	    
	    
	}

}
