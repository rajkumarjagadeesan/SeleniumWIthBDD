Feature: Online shopping website

  @order_tshirt
  Scenario Outline: Order a Tshirt and verify order history
		Given the user is on the home page
		When the user logs in with <UserName> <Password>
		And the user orders a tshirt
		Then the order should be available in the order history table.

    Examples: 
      | UserName  							| Password 	|
      | rajkumar@qualitest.com 	| Test123 	|
      
  @update_firstname
  Scenario Outline: Update first name in personal information screen
		Given the user is on the home page
		When the user logs in with <UserName> <Password>
		And the user updates the first name as <UpdatedFirstName>
		Then the information should be updated successfully.

    Examples: 
      | UserName  							| Password 	| UpdatedFirstName 	|
      | rajkumar@qualitest.com 	| Test123 	| Raj Updated				|