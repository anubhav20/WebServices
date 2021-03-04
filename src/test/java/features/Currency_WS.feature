Feature: Validating all API endpoints of Web Services

Background: Validating Currency WS
    Given I am validating Currency WS

@GetAll  @Regression
Scenario: Verify GET of Currency WS
    When I use GET API to fetch currency details
    Then API call returns success with 200 status code
    
    
@GetSpecificCurrency  @Regression
Scenario Outline: Verify GET call to get a list of currencies where the code starts with specific letter
    When I use GET API to fetch list of currencies where the code starts with "<Letter>"
    Then API call returns success with 200 status code
    
Examples:
	| Letter 	|
	| c			|
	| d			|
	
