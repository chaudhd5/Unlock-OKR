Feature: OKR Login
This feature verify the Login Functionality

Scenario: Check Login Functionality with correct credentials
Given User is at OKR login page
When User Enter "deepanjali.chaudhary@infoprolearning.com" in Email field
And User Enter "abcd@1234" in Password field
And user click on Sign In Button
Then login should be sucessful


Scenario: Check Login Functionality with Wrong credentials
Given User is at OKR login page
When User Enter "deepanjali@infoprolearning.com" in Email field
And User Enter "abcd@1234" in Password field
And user click on Sign In Button
Then login should not be sucessful


