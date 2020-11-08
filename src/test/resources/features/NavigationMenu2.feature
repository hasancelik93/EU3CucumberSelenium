@navigateFeature
Feature: Navigating menu

  Scenario:navigate to fleet->vehicles
    Given the user is on the login page
    And the user enters the sales manager information
    When user navigating by using top menu
    Then user should be able to see expected page


  Scenario:navigate to Marketing->Campaigns
    Given the user is on the login page
    And the user enters the sales manager information
    When user navigating by using top menu
    Then user should be able to see expected page



  Scenario:navigate to Activities->Calender Events
    Given the user is on the login page
    And the user enters the sales manager information
    When user navigating by using top menu
    Then user should be able to see expected page
