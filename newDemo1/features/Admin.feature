Feature: Verify sorting functionality
This feature verify all admin operations

Background:
Given User is at OKR login page
When User Enter "Deepanjali.Chaudhary@infoprolearning.com" in Email field
And User Enter "Delhi@2710" in Password field
And user click on Sign In Button
Then Admin login should be sucessful

@Admin3 @admin2
Scenario Outline: Check Create new organization functionality
Given User is at admin page
When User click on CreateOrganization icon
And User enter "<OrganizationName>" in Organization Name field
And User enter "<LeaderName>" in Leader Name field
And User upload "<LogoPath>" in logo field
And User enter current date in Start date field
And User select "<OrganizationCycle>" in Organization Cycle field
And User select private OKR "<Private>" option for the organization
And User clicks on Save and Exit button
Then "<OrganizationName>" should be created successfully

Examples:
|OrganizationName|LeaderName|LogoPath|OrganizationCycle|Private|
|Testing Organization|Anurag Chaudhuri|D:\Comp-Deepanjali\Data\Deepanjali\IMG_9722.jpg|Quarter|Yes|

@Admin
Scenario Outline: Create New User functionality
Given User is at admin page
When User click on User Tab
And User click on CreateUser icon
And User enter "<FirstName>" in First Name field
And User enter "<LastName>" in last Name field
And User enter "<EmpID>" in Emp Id field
And User enter "<EmailID>" in Email Id field
And User enter "<Designation>" in Designation field
And User select "<Role>" in Role field
And User select "<Organization>" in organization field
And User clicks on Save and Exit button
Then User "<EmpID>" should be created successfully
Examples:
|FirstName|LastName|EmpID|EmailID|Designation|Role|Organization|
|Test|Test|Test1234|Test@gmail.com|QA Analyst|Default|AmazoneS|



