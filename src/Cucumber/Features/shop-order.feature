@Order
Feature: Shop place order

  Scenario: User can make shop order

    Given I go to shop page
    When I click sign in
    And I fill email "fynlivdgdzchqhnjfv@bvhrs.com" and password "123AB!"

    When I click on clothes category and on Hummingbird Printed Sweater
    And I choose size and quantity and I add product
    Then I confirm order

    When I confirm address
    And I choose PrestaShop and Pay by check
    Then I take screenshot