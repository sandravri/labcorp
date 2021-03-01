#Author: SR
@lc_interview
Feature: Browse LabCorp Careers 

  @lc1
  Scenario Outline: Search labcorp careers options
    Given I open the website "https://www.labcorp.com/" using a chrome browser
    And I find the Careers link 
    When I click the Careers link
    And Search for "QA Test Automation Developer"
    And I get a list of options that has "<jobtitle>" with "<joblocation>" posted on "<posteddate>"
    Then I validate the job title, location and job id "<jobid>"
    And I confirm first sentence of third paragraph under Description/Intro as "<descrsample>"
    And I confirm second bullet point under Management Support as "Prepare test plans, budgets, and schedules."
    And I confirm third requirement as "5+ years of experience in QA automation development and scripting."
    And I confirm first suggested automation tool to be familiar with contains "Selenium"
    When I click Apply Now 
    Then I validate on External Page that the job title is "<jobtitle>", location is "<joblocationstcode>" and job id is "<jobid>"
    And I confirm on External Page first sentence of third paragraph under Description/Intro as "<descrsample>" 
    And I click to return to Job Search 
    Examples: 
      | jobtitle  |  joblocation | joblocationstcode | posteddate | jobid | descrsample | 
      | Senior QA Test Automation Developer / Engineer | Durham, North Carolina | Durham, NC | 12/10/2020 | 20-85412 | The right candidate for this role will participate in the test automation technology development and best practice models. |
