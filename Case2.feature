Feature: Case 2: Front-end Automation. 

    @FacebookLogin
	Scenario: Login through Facebook Path:
	
	
	Given URL https://www.ounass.ae/
	When Click on to User icon in top left
	And Click Amber button 
	And Click Facebook connect 
	Then A new window opens with facebook login
	When Enter valid email and password
	And Click on Login button
	And Click on continue button
	Then Come back to website and verify user is successfully logged in


@ProductListing
Scenario: Product Listing Page 

Given URL https://www.ounass.ae/clothing/
When Scroll down the page until 72 items display


