
Feature:Account Activity page features

  Background:
    Given the user logs in with valid credentials
    When the user navigates to Account Activity page

  Scenario:Account Activity Page should have the title Zero - Account Activity
    Then the title should be "Zero - Account Activity"

  Scenario: In the account dropdown default option should be Savings
    Then the dropdown default option should be "Savings"

    Scenario: Account Dropdown should have five options
      Then Account Dropdown should have following options
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |

    Scenario: Transactions table should have four column names
      Then Transactions table should haave the following column names
        | Date |
        | Description |
        | Deposit |
        | Withdrawal |