Feature: eService Registration Feature

  Scenario Outline: Registration scenario with different set of data
    Given user navigates to eService Registration page
    When Enter Registration details from sheetname "<SheetName>" and rownumber <RowNumber>
    And user clicks on Register button
    Then it shows a successful message as "Registration process completed successfully."

    Examples:
      | SheetName    | RowNumber |
      | Registration | 1         |

