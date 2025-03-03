@tag
Feature: Error Validation
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: To check if the added product is present in Cart
    Given User is in the Ecommerce login page
    When Login with <username> and <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | username  			| password   |
      | pavan@gmail.com | Password   |
