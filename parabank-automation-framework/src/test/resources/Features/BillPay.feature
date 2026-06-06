Feature: Bill Payment

Scenario: Pay Bill Successfully

Given User is logged into ParaBank for bill payment
When User clicks Bill Pay link
And User enters Bill Payee Name "surya"
And User enters Bill Pay Address "Coimbatore"
And User enters Bill Pay City "Coimbatore"
And User enters Bill Pay State "Tamil Nadu"
And User enters Bill Pay Zip Code "641001"
And User enters Bill Pay Phone Number "9876543210"
And User enters Bill Pay Account Number "12345"
And User enters Verify Bill Pay Account Number "12345"
And User enters Bill Amount "566"
And User selects From Account
And User clicks Send Payment button
Then Bill payment should be successful