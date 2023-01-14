Feature: Pay Bills

  Background:
    Given User should be on the login page
    When User should input username "username" and password "password"
    And User should navigate to "Pay Bills"


  Scenario: User should be able to complete pay operation

    And User should input the pay requirements
    Then "The payment was successfully submitted." message should be displayed


  Scenario Outline: User should not be able to complete pay operation with invalid credentials
    And User should not to complete pay operation by using invalid "<Amount>". "<Date>", "<Description>"
    Then "The payment was successfully submitted." message should not be displayed

    Examples:
      | Amount    | Date     | Description  |
      | someMoney | December | Good Payment |
      | ??7777    |          | Good Payment |

  @wip
  Scenario: Add a new payee
    And User should navigate to "Add New Payee"
    And User should create new payee using following information

      | Payee Name    | The Law Offices of Hyde, Price & Sharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001        |
      | Account       | Checking                                |
      | Payee details | XYZ account                             |

    Then "The new payee The Law Offices of Hyde, Price & Sharks was successfully created." message should be displayed
