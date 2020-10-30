
Feature:Pay Bills page features
  Background:
    Given the user logs in with valid credentials
    When the user navigates to Pay Bills page

  Scenario:Pay Bills Page should have the title Zero - Pay Bills
    Then the title should be like "Zero - Pay Bills"

  Scenario: User completes a successful Pay operation
    Then the user enter "30" and "2020-10-01" to input fields
    And the user should see the success warning after clicking Pay
      | The payment was successfully submitted. |

  Scenario: User should not make a payment without entering the amount or date
    Then the user should see the following alert after clicking Pay
      | Please fill in this field. |


  Scenario: Amount field should not accept alphabetical or special characters
    Then the user should not be able to make a payment using "abc"

  @wip
  Scenario: Amount field should not accept alphabetical or special characters
    Then the user should not be able to make a payment with "@#"

  @wip
  Scenario: Date field should not accept alphabetical characters
    Then date field should not accept "abc"




