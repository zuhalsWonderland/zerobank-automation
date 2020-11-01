Feature:	Add	new	payee	under	pay	bills
  Background:
    Given the user logs in with valid credentials
  @wip
  Scenario:	Add	a new payee
    Given the user navigates to Pay Bills page
    And creates	new	payee using following information
      | PayeeName    | The Law Offices of Hyde, Price & Scharks |
      | PayeeAddress | 100 Same st, Anytown, USA, 10001         |
      | Account      | Checking                                 |
      | PayeeDetails | XYZ	account                             |
    Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed