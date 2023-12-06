Feature: search flights

  Scenario: user should be able to search the flights when user entered the details
    Given EdgeDriver must be opened
    Then User need to enter into the MakeMyTrip page
    Then user need to click on flights
    Then user need to select from and to details
    Then user need to select the departure and return date
    Then user need to click search button
    Then user should be able to see the search results
