@search
Feature: website search feature

  Scenario: search feature

    Given user is on the website
    And   the user should be able to login
    When  user search in website
    Then  user should be able to see results
