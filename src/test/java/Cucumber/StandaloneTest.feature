
@tag
Feature: Purchase the order from an Ecommerce website
  I want to use this template for my feature file
  
  Background:
  Given User is in the Ecommerce login page

  @Regression
  Scenario Outline: Positive test of submitting an order
    Given Login with <username> and <password>
    When I add product <productname> to Cart
    And Checkout <productname> and submit the order
    Then "THANK YOU FOR THE ORDER." message is displayed in Confirmation Page

    Examples: 
      | username                | password       | productname |
      | pavanpractise@gmail.com | Password@1 		 | ZARA COAT 3 |
