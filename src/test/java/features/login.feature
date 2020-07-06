Feature: Login into Application

Scenario Outline:: Login to page using username and password
Given initialize driver with chrome browser
And Navigate to "http://www.qaclickacademy.com/" site
And Click on Login link on Home page to land on secure sign in page
When user enters <username> and <password> and logs in
Then Verfiy that user is getting Invalid Username password text 
And close browser

Examples:
|username	|password	|
|test@123.com|123456	|
|test@12345.com|12345	|