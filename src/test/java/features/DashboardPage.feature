@tag
Feature: Dashboard Page scenarios

Background:
    Given User is on the Spectool Login Page
    When user enters username
    And user enters password
    And click on login button

    @SmokeTest
    Scenario: User Logout
    Given user is on Dashboard
    And click on the profile icon
    When Click Logout
    Then User logout
    
    @SmokeTest
    Scenario: Update Job title User Preference Setting
    Given user is on Dashboard
    And click on the profile icon
    When Click Logout
    Then User logout
    
    @SmokeTest
    Scenario: Select Projects from the side Menu
    Given user is on Dashboard
    When  user click on side bar Menu Projects
    Then  use sees list of the Projects
 

 