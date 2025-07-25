@webApp
Feature: Login Page Tests

  @login
  Scenario: SauceLab Sample Navigation
    When Scenario Started "SauceLab Sample Navigation"
    Given User logs in to "sauceLabs"
    Then Verify Used Logged
    And User Logs OUT

  @login
  Scenario: SauceLab Unable to Login
    When Scenario Started "SauceLab Sample Navigation"
    Given User logs in to "sauceLabs" as "sauceLabsWrongUser" with "sauceLabsPass" password
    Then Verify User Unable To Login