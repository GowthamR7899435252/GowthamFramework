#Author: your.email@your.domain.com
# Created Date:
# Reviewed By:
#Purpose:
# Description :

@Execute
Feature: Login and Logout functionality
Description: Verify the login and logout functionality

Scenario: Login with valid credentials
Given Launch the application
And Navigate to the url of the application
When Login using valid credentials
|username|password|
|testbams@gmail.com|facegenie|
Then i validated homepage
And i clicked logout
When i clicked ok button
Then i landed on login page and validated it
And i closed the browser




