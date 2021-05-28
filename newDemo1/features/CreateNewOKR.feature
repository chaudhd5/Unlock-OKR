Feature: Verify My Goals functionality
This feature verify all my goals operations

Background:
Given User is at OKR login page
When User Enter "Deepanjali.Chaudhary@infoprolearning.com" in Email field
And User Enter "Delhi@2710" in Password field
And user click on Sign In Button
Then login should be sucessful
 
@smoke
Scenario Outline: Check creating New OKR with Single key functionality
Given User is at OKR Home page
When User click on CreateOKR icon
Then User clicks on Create New Objective
And User enter "<Objective>" in Objective field
And User enter "<ObjectiveShortDeec>" in type of short description for objective field
And User select "<ObjectiveStartDate>" in Start date field
And User select "<ObjectiveEndDate>" in End date field
And user select "<Contributor>" in assign contributors field
And user click on Add Key Result button
And user add "<keyName>" in key Name field
And user select "<dueDate>" in key result due date field
And Click on Save button
Then User should be navigated to home page and "<Objective>" should have been created

Examples:
| Objective | ObjectiveShortDeec | ObjectiveStartDate | ObjectiveEndDate | Contributor | keyName | dueDate |
| Automation Framework Implementation | Lets Start | 04-Dec | 30-Dec |  | POC Complete | 30-Dec|


@OKR
Scenario Outline: Check Align to Objective Functionality
Given User is at OKR Home page
When User click on CreateOKR icon
When User click on Align to Objectives
Then User should be at Align to Objectives page
And User enter "<PeopleName>" in search people field
And User select "<Objective>" from objective list
And Click on Save button
Then User should be navigated to home page and "<Objective>" should have been created

Examples:
| Objective | PeopleName |
| Obj3 | Anurag Chaudhuri |

@OKR
Scenario Outline: Check Assign contributor functionality
Given User is at OKR Home page
When User click kabab icon of  "<Objective>" from objective list
And User select Assign to option from kabab icon
And User navigate to Add contributors page
And user select "<Contributor>" in assign contributors field
And Click on Save button
Then "<Contributor>" should be added to the "<Objective>"
Examples:
| Objective | Contributor |
| Automation Framework Implementation | Anurag Chaudhuri,Himanshu Kumar |


@admin1,@admin2
Scenario Outline: Check Edit objective functionality
Given User is at OKR Home page
When User click kabab icon of  "<Objective>" from objective list
And User select Edit objective option from kabab icon
And user navigated to edit objective page
And user change the objective name to "<NewObjName>" and remove one contributor
And Click on Save button
Then "<Objective>" should be updated with "<NewObjName>" and contributor should be removed
Examples:
| Objective | NewObjName|
| Automation Framework Implementation | Automation Framework Implementation_Updated |


@OKR
Scenario Outline: Check Add Key Result functionality
Given User is at OKR Home page
When User click kabab icon of  "<Objective>" from objective list
And User select Add Key Result option from kabab icon
And user navigated to Add Key Result page
And user add "<keyName>" in key Name field
And user select "<Contributor>" in assign contributors field
And user select "<dueDate>" in key result due date field
And Click on Save button
Then Key result "<keyName>" should be added to "<Objective>"
Examples:
| Objective | keyName | Contributor | dueDate |
| Automation Framework Implementation_Updated | Testing Complete | Anurag Chaudhuri | 30-Dec |


@OKR
Scenario Outline: Check delete objective functionality
Given User is at OKR Home page
When User click kabab icon of  "<Objective>" from objective list
And User select delete option from kabab icon
And User click on Yes button on confirmation message
Then "<Objective>" should not be visible at home page
Examples:
| Objective |
| Automation Framework Implementation_Updated |

@OKR
Scenario: check OKR/KR progress calculation
Given User is at OKR Home page
When user expand all the OKRs
Then OKR KR progress calculation should be as per defined calculation



