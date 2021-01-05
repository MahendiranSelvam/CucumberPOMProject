Feature: Account Page Feature

  Background:
    Given User has already logged in to the Application
    |username|password|
    |sachinvijay@myheros.com|password12345|

    Scenario: Accounts Page Title
      Given User is on Accounts page
      When User gets the Title of the page
      Then Page Title should be "My account - My Store"

    Scenario: Accounts Section Count
      Given User is on Accounts page
      Then User gets Accounts section
      |ORDER HISTORY AND DETAILS|
      |MY CREDIT SLIPS |
      |MY ADDRESSES|
      |MY PERSONAL INFORMATION|
      |MY WISHLISTS           |
      And Accounts section count should be 5






