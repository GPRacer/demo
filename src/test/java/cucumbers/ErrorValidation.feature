
@tag
Feature: Error Validation


 
  @error
  Scenario Outline: Title of your scenario outline
Given I landed on the Ecommerce Page  
Given Logged in with the UserName<UserName> and Password<Password>
Then user should see this error message"Incorrect email or password."
 
 Examples: 
      | UserName          | Password   |
      | anshika@gmail.com |Iamking@00 | 
     
