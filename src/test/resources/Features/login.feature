@Login_Test
Feature: Test Login Functionalities

 Background:
   Given user is on login page

  @positive_test
  Scenario: Check Login successful with valid credentials
    When user enters username "Edward" and password "12345"
    And click on login button
    Then user is navigate on Homepage

  @dataDriven_test @positive_test
  Scenario Outline: Check Login successful with valid credentials
    When user enters username "<username>" and password "<password>"
    And click on login button
    Then user is navigate on Homepage

    Examples:
    |username|password|
    |Rifat   |12345   |
    |Ashraf  |12345   |
    |John    |12345   |

  @dataDriven_test @positive_test
  Scenario: Check Login successful using Data table
    When user click on Login Button upon entering credentials
      |username|password|
      |Rifat   |12345   |
    Then user is navigate on Homepage

 @negative_test
  Scenario: Check Login fail with wrong credentials
    When user enters username "Edward" and password "44444"
    And click on login button
    Then user is fail to Login