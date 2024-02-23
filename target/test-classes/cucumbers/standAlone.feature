@tag
Feature: Placing the Order
#feature contains n nuber scenarios and scenario outline
#scenario is nothing but a testcases and if we want to run multiple time with multiple data of same scenario will use scenario outline
#if you have commom code you can put that in background

Background:
Given I landed on the Ecommerce Page  

  
  @regression
  Scenario Outline: Positive Test of order submitting
    Given Logged in with the UserName<UserName> and Password<Password>
    When I add the product <prodName> to the cart
    And checkout <prodName> and submit the order
    Then  "THANKYOU FOR THE ORDER." message is displayed on the confirmation page

    Examples: 
      | UserName          | Password   | prodName       |
      | anshika@gmail.com |Iamking@000 | ZARA COAT 3   |
     
