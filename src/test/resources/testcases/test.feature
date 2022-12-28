Feature: As a developer
  I want to login to the system to place an order

  Background:
    Given I open the web base

  Scenario Outline: I want to login to the system successfully
    Given I input username is "standard_user"
    And I input password is "secret_sauce"
    When I click on the login button
    Then I am on the home page
    When I add "Sauce Labs Backpack" product to cart
    And I add "Sauce Labs Fleece Jacket" product to cart
    And I click on cart icon
    When I click on checkout button
    Then I am on the check out page
    And I input first name is "<firstName>"
    And I input last name is "<lastName>"
    And I input pose code is "<postCode>"
    And I click on continue button
    When I click on finish button
    Then I am on the thank you page

    Examples:
      | firstName | lastName | postCode |
      | Dan       | Brown    | 123456   |