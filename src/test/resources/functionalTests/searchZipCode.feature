Feature: "Search for a zip code and address"

   @regressao @zipCode	@teste1	@Firefox
  Scenario Outline: Search for a valid zipCode or address
    Given I open the homepage
    And I send the zipcode  as "<zipCode>"
    And I click to the search button
    And I check the results of my search
    Examples: 
      | zipCode        			|
      | 13326050 	    	    | 
      | bruxelas 	    	    | 
      
   
   
    @regressao @zipCode	@teste2	@Firefox
  Scenario Outline: Search for a invalid zipCode
    Given I open the homepage
    And I send the zipcode  as "<zipCode>"
    And I click to the search button
    And I check that there were found any results
    Examples: 
      | zipCode        			|
      | 13326051 	    	    | 
   