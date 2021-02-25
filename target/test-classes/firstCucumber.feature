Feature: Fried egg
  Scenario Outline: Frying an egg
    Given I have <starting number> of eggs
    And I have had <consumed> eggs
    When I count the eggs
    Then I should have <final number> more eggs
    """
    THIS IS A QUOTE
    """
    Examples:
    | starting number | consumed | final number
    | 12              | 2        | 10


