Feature: Validating all API endpoints of Web Services

Background: Validating Country WS
    Given I am validating Country WS

@AddCountry  @Regression
Scenario: Verify POST of Country
    When I use POST to add Country
    Then The country is added and API call returns success with 201 status code


@DeleteCountry  @Regression
Scenario: Verify DELETE of country
    When I use DELETE to delete Country
    Then The country is deleted and API call returns success with 204 status code
   
   