Feature: Api Test

  @api
  Scenario: CREATE data by API
    And POST Data By API

  @api
  Scenario: READ data by API
    And GET Data By API

  @api
  Scenario: UPDATE data by API
    And PUT Data By API

  @api
  Scenario: DELETE data by API
    And DELETE Data By API

  @api
  Scenario: Confirm that data Deleted
    And Verify data Deleted
