Feature: Transfer Funds

Scenario: Transfer money between accounts

Given User is logged into ParaBank for transfer
When User clicks Transfer Funds link
And User enters transfer amount "500"
And User selects source account
And User selects destination account
And User clicks Transfer button
Then Funds should be transferred successfully

Scenario: Transfer money to same account

Given User is logged into ParaBank for transfer
When User clicks Transfer Funds link
And User enters transfer amount "400"
And User selects same account for transfer
And User clicks Transfer button
Then System should not allow transfer to same account