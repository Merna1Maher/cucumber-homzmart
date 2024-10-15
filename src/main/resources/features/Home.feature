Feature: Shopping cart functionality
  Scenario: Adding products to the cart and verifying cart details
    Given User will be in Homezmart homepage
    When User hover on Storage
    Then User can see the Kitchen Storage subcategory in the dropdown menu
    When User click on Kitchen Storage
    And  add two random products to the cart
    And  open the cart preview
    Then User can see all added products in the cart
    When User verify that the product names and prices match the details of the selected products
    Then User can find that the total price in the cart is calculated correctly
