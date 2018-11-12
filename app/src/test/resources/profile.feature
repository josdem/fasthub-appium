@FeatureTest
@Feature/5
Feature: User browse his profile
  Scenario: As a user I should be able to see my profile
    When I click on menu to access profile
      And I click on profile
    Then I should be able to see avatar
      And I should be able to see name
      And I should be able to see username
      And I should be able to see description
      And I should be able to see following
      And I should be able to see followers
      And I should be able to see organization
      And I should be able to see location
      And I should be able to see email
      And I should be able to see link
      And I should be able to see joined
      And I should be able to go back from profile
