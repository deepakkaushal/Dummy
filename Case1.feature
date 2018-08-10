Feature: Case 1: Front-end Automation 

    @Register
	Scenario: Register Account
	
	
	Given Create An Account page
	When Enter all mandatory fields
	And Click on Create An Account button
	Then User redirect to Home page and Account icon display
	When I click on My Account option
	And Click on Edit link under your detail section
	Then Email address display in non-editable mode
	And it is the same email with which you registered the account 
	When Update the phone number and click on Update details button
	Then Phone number is updated successfully
	
	
	@AddBag
	Scenario: Add to bag
	
	Given Items to be add
	When Open the One Size item in browser
	And Click on ADD TO BAG button
	And Click on BAG icon at top-right corner
	Then One Size item display in My Bag section
	And Remove One Size item from bag
	
	When Open the Pink Color with 9.5 sized item in browser
	And Select "Pink" color and "9.5" size
	And Click on ADD TO BAG button
	And Click on BAG icon at top-right corner
	Then Selected item display in My Bag section
	And Remove selected item from bag
	
	When Open the Size 39 item in browser
	And Select Size "39"
	And Click on ADD TO BAG button
	And Click on BAG icon at top-right corner
	Then Choosed item display in My Bag section
	And Remove choosed item from bag
	