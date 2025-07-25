@webApp
Feature: Products Page Tests

  @buy
  Scenario: Add and Remove Products to Edit chart Than Complete Payment
    When Scenario Started "Add and Remove Products to Edit chart"
    Given User logs in to "sauceLabs"
    Then Add Product to Chart
    And Open Chart Page
    And Verify Items Added
    And Remove All Items
    And Open Products Page
    Then Add Product to Chart
    And Open Chart Page
    And Verify Items Added
    And Open Payments
    And Fill "Hasan" as Name "Ay" as Lastname "06000" as ZipCode
    And Buy Products
    And User Logs OUT
