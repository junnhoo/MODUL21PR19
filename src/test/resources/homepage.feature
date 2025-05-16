@home
Feature: Homepage

Background: Login
    Given user is on login page
    And user input username with "standard_user"
    And user input password with "secret_sauce"
    When user click login button
    Then user is on homepage

    @filter-product
    Scenario: Filter Products
        Then user click filter dropdown
        And user select "Price (low to high)" from the filter dropdown
        Then user see the products by low price to higher price

    @boundary-test
    Scenario: First and last product prices are correct as sorted low to high
        Then user click filter dropdown
        And user select "Price (low to high)" from the filter dropdown
        Then first product price should be the lowest
        And last product price should be the highest


    @negative-test
    Scenario: Products not sorted by low price to high price
        Then user click filter dropdown
        And user select "Price (low to high)" from the filter dropdown
        Then user see the products are not sorted correctly






