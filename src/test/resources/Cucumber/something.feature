Feature: Is it Added
  User wants to add a review to database
  Scenario: Adding review
    Given I want to add a review
    When I Post a request to add a review
    Then I should see the "save" message

Feature: Is it Updated
  User wants to change a review they added to the database
  Scenario: Updating review
    Given I want to update a review
    When I Put a request to change review
    Then I should see the "Updated" message

Feature: Is it Delete
  User wants to delete a review they added to the database
  Scenario: Deleting review
    Given I want to delete a review
    When I Put a request to change review
    Then I should see the "Updated" message

Feature: Is it Delete
  User wants to delete a review they added to the database
  Scenario: Deleting review
    Given I want to delete a review
    When I Put a request to change review
    Then I should see the "Updated" message