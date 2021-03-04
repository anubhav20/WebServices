package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Steps_WS {
	private static final String BASE_URL_CURRENCY = "https://ics-qa-ws.azurewebsites.net/currency";
	private static final String BASE_URL_COUNTRY = "https://ics-qa-ws.azurewebsites.net/country";

	private static Response response;
	private static String jsonString;

	
	@Given("I am validating Currency WS")
	public void validating_Currency_WS() {
		RestAssured.baseURI = BASE_URL_CURRENCY;
		RequestSpecification request = RestAssured.given();

	}
	
	
	@When("I use GET API to fetch currency details")
	public void fetch_Currency_details() {
		RestAssured.baseURI = BASE_URL_CURRENCY;
		RequestSpecification request = RestAssured.given();
		response = request.get();
	
		jsonString = response.asString();
		System.out.println(jsonString);

	}
	
	
	@Then("API call returns success with {int} status code")
	public void api_Success(Integer int1) {
		assertEquals(response.getStatusCode(),200);
	
	}
	
	
	@When("I use GET API to fetch list of currencies where the code starts with {string}")
	public void get_currency_specificStart(String string) {
		RestAssured.baseURI = BASE_URL_CURRENCY + "/Fill?Code=+'string'+*&pwd=IcsqAPwd501";
		RequestSpecification request = RestAssured.given();
		response = request.get();

	}
	
	
	@When("I use POST to add Country")
	public void post_add_country() {
		RestAssured.baseURI = BASE_URL_COUNTRY + "/Add";
		RequestSpecification request = RestAssured.given();
		
		// to write code
		
	}
	
	
	@Then("The country is added and API call returns success with 201 status code")
	public void country_Added() {
		Assert.assertEquals(201, response.getStatusCode());
		
	}
	
	
	@When("I use DELETE to delete Country")
	public void delete_Country() {
		RestAssured.baseURI = BASE_URL_COUNTRY + "/delete";
		RequestSpecification request = RestAssured.given();

		// to write code
		
	}
	
	
	@Then("The country is deleted and API call returns success with 204 status code")
	public void countryDeleted() {
		Assert.assertEquals(204, response.getStatusCode());

	}
	
	
}
