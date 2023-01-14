Feature: Login

  Background:
    Given User should be on the login page


  Scenario: User should be able to login with valid credentials

    When User should input username "username" and password "password"
    Then "Account Summary" page should be displayed

  @login
  Scenario Outline: User should not able to login with invalid credentials

    When User should input usernameInfo "<usernameInput>" and passwordInfo "<passwordInput>"
    Then Error message "Login and/or password are wrong." should be displayed

    Examples:
      | usernameInput | passwordInput |
      | username      | wrong         |
      | wrong         | password      |
      |               | password      |
      | username      |               |
      |               |               |