Feature: Login to Sauce Demo

  Scenario: Successful login
    Given I am on the Sauce Demo login page
    When I login with username "standard_user" and password "secret_sauce"
    Then I should be logged in
