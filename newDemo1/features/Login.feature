Feature: OKR Login with Multiple users
This feature verify the Login Functionality

Scenario Outline: Check Login Functionality with correct credentials
Given User is at OKR login page
When User Enter "<UserName>" in Email field And User Enter "<UserPassword>" in Password field
And user click on Sign In Button
Then login should be sucessful

Examples:
| UserName | UserPassword |
| deepanjali.chaudhary@infoprolearning.com| Abcd@1234 |




 
