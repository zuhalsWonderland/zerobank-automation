
Feature: Find Transactions in	Account	Activity
  Background:
    Given the user logs in with valid credentials
    And the user accesses the Find Transactions tab


  Scenario:	Search date range
    When the user enters date range from "2012-09-01" to "2012-09-06"
    And clicks search
    Then results table should only show the dates "2012-09-01" to "2012-09-06"
    And the	results	should be sorted by	most recent	date "2012-09-06"
    When the user enters date range from "2012-09-02" to "2012-09-06"
    And clicks search
    Then results table should only show the dates "2012-09-02" to "2012-09-06"
    And the	results	table should only not contain transactions dated "2012-09-01"


  Scenario:	Search description
    When the user enters description "ONLINE" and clicks search
    Then results table should only show	descriptions containing	"ONLINE"
    When the user enters description "OFFICE" and clicks search
    Then results table should only show	descriptions containing	"OFFICE"

  Scenario:	Search	description	case insensitive
    When the user enters description "ONLINE" and clicks search
    Then results table should only show	descriptions containing	"ONLINE"
    When the user enters description "online" and clicks search
    Then results table should only show	descriptions containing	"ONLINE"

@wip
  Scenario:	Type
    When clicks search
    Then results table should show at least one result under "Deposit"
    Then results table should show at least one result under "Withdrawal"
    When user selects type "DEPOSIT"
    Then results table should show at least one result under "Deposit"
    And results table should show no result under "Withdrawal"
    When user selects type "WITHDRAWAL"
    Then results table should show at least one result under "Withdrawal"
    And results table should show no result under "Deposit"

