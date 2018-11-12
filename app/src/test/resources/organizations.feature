@FeatureTest
@Feature/6
Feature: User browse organizations
  Scenario: As a user I should be able to see my organizations
    When I click on menu to access organizations
      And I click on organizations
    Then I should be able to see organizations
      And I should be able to go back from organizations

