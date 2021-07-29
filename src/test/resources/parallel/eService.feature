Feature: eService Login Feature

  Background:
    Given user has already logged in to eService application
      | username | password |
      | Billa    | 123qwe   |

  @Regression
  Scenario: eService page title verification
    Given user is on eService page
    When user gets the Title of the page
    Then page Title should be "SCDeServicesPortal"

