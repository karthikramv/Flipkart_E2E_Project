Feature: To validate the Flipkart Application

  Background: 
    When close the popup
    Then It should navigate to the homepage

  @tc001 @reg
  Scenario: To validate the search functionality
  
    And user enter the search product name
    When click a search button
    Then it should navigate to the search result page and display the relevent details
    And Select Minimum and maximum price
    And Select the Brand
    And Select the Ram
    And Select the batteryCapcity
    Then It should display relevent result

  @tc002 @reg
  Scenario: To validate the Electronic functionality
  
    Given user to move the Electronics link
    When Cursor to move to the Laptop Accessories link
    And Move to Laptop Keyboards and click
    And click the price high to low link
    Then It should display the relevent details and get the title

  @tc003 @reg
  Scenario Outline: To valiadate the search functionality with diffrenet title
    Given Enter the "<searchText>" in the search field
    When click the search button
    Then It should navigate to the next page and display the corresponding page

    Examples: 
      | searchText |
      | mobile     |
      | tv         |
      | speaker    |
      | shirt      |

  @tc004 @reg
  Scenario: To validate upto addcart functionality
  
    Given user can move to the login link
    When user can click the flipkart plus zone
    And mouse move to the sports,Book&More link
    And going to click cricket link
    And scroll down the page and click one particular result
    And Enter delivery pincode and click the check link
    Then pincode should be checked and displayed and verify the titles

  @tc005 @reg
  Scenario: To get the title and price from search result
  
    Given Enter the search text in the search field
    When Click the search icon
    Then it should display the search result and get the title and price

  @tc006 @reg
  Scenario: To test the search fuctionality with excel sheet
  
    Given enter search Text in the search field
    When click search icon
    Then it should display the relevent result
