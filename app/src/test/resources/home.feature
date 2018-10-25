Feature: User browse activities issues and pull request
  Scenario: As a user I should see recent activities
    When I launch the application
    Then I should be able to see recent activities
  Scenario: As a user I should see recent issues
    When I click on issues
    Then I should be able to see issues
