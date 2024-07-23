Feature: Place an order on Sauce Demo

  Scenario: Successfully place an order
    Given I am on the Sauce Demo login page
    When I login with username "standard_user" and password "secret_sauce"
    When I add the first item to the cart
    And I proceed to checkout
    And I fill in the checkout information with "Joe", "Bloggs", and "12345"
    And I finish the checkout process
    Then I should see the order confirmation message