Feature: Register
  Scenario: Register Failed
    Given Register Page is open
    When Enter Registration Login "test1"
    And Enter Registration Email "test"
    And Enter Registration Password "asghgfhjds"
    And Enter Confirm Password "asghgfhjds"
    Then Registration is Failed
  Scenario: Register Successful
    Given Register Page is open
    When Enter Registration Login "test1"
    And Enter Registration Email "test1@test.com"
    And Enter Registration Password "asghgfhjds"
    And Enter Confirm Password "asghgfhjds"
    Then Registration is Successful