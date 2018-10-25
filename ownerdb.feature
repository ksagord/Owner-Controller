Feature: Owner Rest Controller

Scenario: Testing the get function
 Given a owner exists in the database
 When the owner retrieves data on the owners
 Then check get function

Scenario: Testing the post function
 Given a new Owner is to be added
 When the parametes for the new Owner are added
 Then check post function

Scenario: Testing the get function using parameters
 Given a owner exists with the last name Coleman
 When the manager retrives the owner with the last name Coleman
 Then check get paramater function

Scenario: Testing the delete function
 Given a owner exists
 When the manage deletes a owner with a specific id
 Then check delete function

Scenario: Testing the get function using parameters
 Given a owner exists with the id
 When the manager retrives the owner with the id
 Then check get by id function

Scenario Outline: Testing the put function
 Given a owner already exists
 When the parametes for the Owner are updated
 Then check put function 


    

