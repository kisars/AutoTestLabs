Feature: Home page
  Scenario: Message sent
    Given Home Page is open
    When Send message
    Then Message has been sent successfully
  Scenario: Status changed
      Given Home Page is open
      When Change status
      Then Status has been changed successfully
