@Login
Feature: Spectool Authentication Scenarios

  As a user of Spectool
  I want to perform authentication-related actions
  So that I can access the system securely

  @LoginPageTest @SpecialTest
  Scenario: Login with multiple credentials
    Given User is on the Spectool Login Page
    When User logs in with data from excel "loginData.xlsx"

    
  @LoginPageTest @SmokeTest
    Scenario: User to Reset Password
    Given User is on the Spectool Login Page
    When user clicks forget password
    And user enters emailaddress "qa+st_ss@atsspec.com"
    And click on rest password button
    Then check your email page appears
    
  @LoginPageTest @SmokeTest
    Scenario: User SignUp
    Given User is on the Spectool Login Page
    When user clicks sign up tab 
    And user enters account details
    |Email     |dedfeo@gmail.com|
    |First Name|Tiaoj|
    |Last Name |Pipa |
    |Password  |Password123|
    |Confirm Password|Password123|
    And click Continue button
    And user enters company details
    |Company Name|
    |Company Address|
    |Canada|
    |Ontario|
    |Toronto|
    |M3N2Ln|
    |Organization type|
    And click Next button
    And select your role "Owner/Partner"
    And click Next button
    And click Sign Up button
    Then check your email for account activation
    
    