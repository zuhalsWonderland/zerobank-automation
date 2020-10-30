Feature:	Navigating	to	specific	accounts	in	Accounts	Activity

  Scenario Outline: Account activity navigation
    Given the user logs in with valid credentials
    When the user clicks on	the <"accountTypeLinkName"> on the	Account	Summary	page and account dropdown should have "<accountTypeLinkName>" selected on the account activity page

    Examples:
      | accountTypeLinkName |
      | Savings             |
      | Brokerage           |
      | Checking            |
      | Credit Card         |
      | Loan                |