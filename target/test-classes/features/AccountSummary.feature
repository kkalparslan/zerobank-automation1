Feature: Account Summary


  Scenario: User should be able to see the account details
    Given User should be on the login page
    When User should input username "username" and password "password"
    And "Account Summary" page should be displayed
    Then User should be see the following Accounts Types

      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

    Then Credit Account table should have following columns

      | Account     |
      | Credit Card |
      | Balance     |