Feature: FeedBack Functionality
This feature verify send feedback functionality

Background:
Given User is at OKR login page
When User Enter "abiral.gupta@infoprolearning.com" in Email field
And User Enter "Abcd@1234" in Password field
And user click on Sign In Button
Then login should be sucessful
 
 @Feedback
Scenario Outline: Check Request feedback functionality
Given User is at OKR Home page
When User click kabab icon of  "<Objective>" from objective list
And User select Request Feedback option from kabab icon
And user navigated to Request Feedback page
And User enter "<PeopleName>" in search people field
And user enter the request feedback message
And Click on Send Button
Then verify feedback request should be send successfully
Examples:
| Objective | PeopleName |
| Automation Framework Implementation_Updated |Abiral Gupta |

@RegressionDScope
Scenario: Validate total OKR and KR count at my goal page
Given User is at OKR Home page
When your expand all the OKRs
Then OKR count should be diaplyes correctly
And KR count should be displayed correctly

 
@Feedback
Scenario Outline: Check Give feedback functionality
Given User is at OKR Home page
When user click on notifications bell icon
And User click on requested feedback notification
And user navigated to Give Feedback page
And user enter the feedback message "<messagecontent>"
And Click on Send Button
Then verify feedback  should be send successfully
Examples:
| messagecontent |
| Great work.Well Done.Keep it Up |


@Feedback
Scenario Outline: Check comment on feedback functionality
Given User is at OKR Home page
When user click on notifications bell icon
And User click on given feedback notification
And user navigated to view Feedback page
And user open the feedback provided
And click on reply button and open the feedback
And user enter the comment message "<messagecontent>"
And Click on Send Button
Then verify feedback  message should be provided successfully
Examples:
| messagecontent |
| Thank you so much |
