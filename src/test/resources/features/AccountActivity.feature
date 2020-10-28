
Feature:Account Activity page features

  Scenario:Account Activity Page should have the title Zero - Account Activity
    Given the user logs in with valid credentials
    When the user navigates to Account Activity page
    Then the title should be "Zero - Account Activity"

  Scenario: In the account dropdown default option should be Savings
    Given the user logs in with valid credentials
    When the user navigates to Account Activity page
    Then the dropdown default option should be "Savings"

    Scenario: Account Dropdown should have five options
      Given the user logs in with valid credentials
      When the user navigates to Account Activity page
      Then Account Dropdown should have following options
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |
  @wip
    Scenario: Transactions table should have four column names
      Given the user logs in with valid credentials
      When the user navigates to Account Activity page
      Then Transactions table should haave the following column names
        | Date |
        | Description |
        | Deposit |
        | Withdrawal |