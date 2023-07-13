Feature: Validate create new account and place an order

Background:
		Given User launches Chrome browser 
    When User opens url "https://automationteststore.com/"

  
    Scenario: Crete new account by using signIn button 
    When clicks on signIn 
    And User registers as new customer by entering personal details "frst_name12" "last_name12" "first_name12@test.in"
    And enters address details "church street" "United Kingdom" " Aberdeen" "Bangalore" "560000"
    And enters Login detais "automation_test12" "test@123" "test@123"
    And accepts the privacy policy 
    And Clicks on continue
    Then User Would see Account created successfully message
 
    Scenario: Place an order as returning customer
   	When User logs in as returned customer by entering username "automation_test12" and password "test@123"
   	And adds item to the cart
   	Then Added item should reflect in the cart
   	 
      
   
   
   
   
   
   
      
