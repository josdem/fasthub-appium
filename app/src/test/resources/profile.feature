@SmokeTest
@Feature/5
Feature: User browse his profile
  Scenario: As a user I should be able to see my profile
    When I click on menu
      And I click on profile
    Then I should be able to see avatar
