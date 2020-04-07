Feature: Login
  Scenario: Login Failed
    Given Login Page is open
    When Enter Login "test"
    And Enter Password and Log in "asghgfhjds"
    Then Login is Failed
  Scenario: Login Successfull
    Given Login Page is open
    When Enter Login "test"
    And Enter Password and Log in "uniquepass"
    Then Login is Successful
