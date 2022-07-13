Feature: Shop add my account address

  Scenario Outline: User can add account address
    Given I go to shop main page
    When I click to sign in
    And I enter email "fynlivdgdzchqhnjfv@bvhrs.com" and password "123AB!"
    And I go to my account page
    And I click on create new address
    And I enter new address data alias <alias>, address <address>, city <city>, postal <postal>, country <country>, phone <phone>
    Then I verify created address alias <alias>, address <address>, city <city>, postal <postal>, country <country>, phone <phone>


#    And I close browser

    Examples:
      | alias  | address | city    | postal | country        | phone     |
      | ABuser | Qwerty  | Zxcvbnm | 11111  | United Kingdom | 111222333 |
