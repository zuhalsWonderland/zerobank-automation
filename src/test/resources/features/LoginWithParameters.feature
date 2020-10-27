Feature:Login with valid and invalid credentials

@wip
  Scenario: login with valid credentials
    When the user logs in with valid credentials
    Then the "Account Summary" page should be displayed
  @wip
  Scenario: login with invalid credentials
    When the user logs in using "user" and "pass"
    Then "Login and/or password are wrong." should be displayed

  @wip
  Scenario: login with no credentials
    When the user tries to log in with no credentials
    Then "Login and/or password are wrong." should be displayed

