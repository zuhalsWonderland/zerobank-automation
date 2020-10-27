Feature:Login as different users

  Scenario: login as a driver user
    Given the user is on the login page
    When the user logs in using "username" and "password"
    Then the user should be able to login
    And the "Account Summary" page should be displayed

  Scenario: login with invalid username and password
    Given the user is on the login page
    When the user logs in using "user" and "pass"
    Then the user should not be able to login
    And "Login and/or password are wrong." should be displayed


