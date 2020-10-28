
Feature: Account summary page should have the title	"Zero – Account	summary" and different account types

  Scenario: Account Summary page should have the Zero - Account Summary title
    Given the user logs in with valid credentials
    Then the "Zero - Account Summary" title should be displayed


  Scenario: Account Summary Page should have the following options
    Given the user logs in with valid credentials
    Then the user should see following options
      | Cash Accounts |
      | Investment Accounts |
      | Credit Accounts |
      | Loan Accounts |

 Scenario: Credit Accounts Table must have three columns
   Given the user logs in with valid credentials
   Then the Credit Accounts table must have following columns
       |   Account   |
       | Credit Card |
       |   Balance   |