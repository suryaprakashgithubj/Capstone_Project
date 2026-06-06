Feature: ParaBank Login

Scenario: Login with valid credentials

Given User is on ParaBank home page
When User enters login username "SuryaPrakashJ"
And User enters login password "12345678"
And User clicks Login button
Then User should be logged in successfully