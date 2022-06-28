Feature: demo testing

    Background:
      Given I open the web base

    Scenario: I want to login to the system successfully
      Given I input username is "standard_user"
      And I input password is "secret_sauce"
      When I click on the login button
      Then I am on the home page