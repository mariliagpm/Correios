package selenium.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import selenium.SeleniumTestWrapper;
import selenium.interactions.SearchZipAZipCode;


public class StepsSearchAZipCode {

	Logger log = Logger.getLogger(StepsSearchAZipCode.class); // Classse de Log
	String browserName = "";
	SearchZipAZipCode searchZipCodeInteraction;// Classe responsável
									// pelos steps de
									// entrada na home
									// page do sistema

	String pathLogFinal = "";


	@And("^I send the zipcode  as \"([^\"]*)\"$")
	public void i_send_the_zipcode_as(String zipCode) throws Throwable {
		searchZipCodeInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), SearchZipAZipCode.class);
		searchZipCodeInteraction.sendZipCode(zipCode);
	}

	@And("^I click to the search button$")
	public void i_click_to_the_search_button() throws Throwable {
	   searchZipCodeInteraction.clickSearchButton();
	}

	
	@And("^I check the results of my search$")
	public void i_check_the_results_of_my_search() throws Throwable {
	    searchZipCodeInteraction.checkResults();
	}
	
	
	@And("^I check that there were found any results$")
	public void i_check_that_there_were_found_any_results() throws Throwable {
	    searchZipCodeInteraction.checkResultsNotFound();
	}
}