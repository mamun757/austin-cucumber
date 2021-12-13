Feature: Mortgage Calculator

  @calculateApr
  Scenario: Calculate Real Apr Rate
    Given user is on Mortgage Calculator Home page
    And user is navigate to Real Apr Page
    When user clicks on Login Button upon entering the data
      |HomePrice|DownPayment|InterestRate|
      |200000   |15000      |3           |
    Then the Real Apr rate is "3.130%"