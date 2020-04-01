#Search Product
@loginTest

Feature: Search Scenario
  
  Scenario: Search Product in  Amazon App
  Given User already login to Amazon app
  Then enter "65 inch TV" Product name in Search Box
  Then click on Search in Search page
  Then check User is in Product detail page
  
  
  @MidProduct
  Scenario: Scroll to the product
  Given User already login to Amazon app
  Then enter "65 inch TV" Product name in Search Box
  Then click on Search in Search page
  Then user scroll to the mid of the product 
  
  
  
  
  
  