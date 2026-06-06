Feature: Open New Account

Scenario: Create Savings Account

Given User logs into ParaBank with valid credentials
When User clicks Open New Account link
And User selects account type "SAVINGS"
And User selects existing account
And User clicks Open New Account button
Then New account should be created successfully