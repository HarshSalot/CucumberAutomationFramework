@tag
Feature: Create a Projects UI validation
  
  As a QA Automation Engineer  
  I want to verify project creation and deletion using the UI

  Background: 
    Given User is on the Spectool Login Page
    When user enters username
    And user enters password
    And click on login button
    
    Given user is on Dashboard
    When  user click on side bar Menu Projects
    Then  user sees list of the Projects

  @ProjectPageTest @SmokeTest
  Scenario: Create a new Project with blank spec via UI
    Given User is on the Projects page
    When User clicks on Create New Project
    And User enters Project details from "projectPayload.json"
    And click Next button
    And select building class Education
    And select building type college
    And click Next button on project page
    And click Next button on project page
    When click finish button
    Then A new project is created and visible on the project list
    And The displayed project name should be "Test Project UI"

  @ProjectPageTest @SmokeTest
  Scenario: Delete a project using the UI
    Given User is on the Projects page
    When User search the project "Test Project UI"
    And User clicks on Actions
    And User clicks on Delete options
    And User confirms the deletion
    Then The project "Test Project UI" should no longer be visible in the project list
