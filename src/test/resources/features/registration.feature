Feature: User Registration
	
	@BeforeAll @AfterAll
  @RegistrationTest 
  Scenario: User registers with valid details
    Given I navigate to "https://www.demoblaze.com/"
    When I enter registration details
      | Username   | Password   |
      | Matvitast1 | Pass@12345 |
    And I click the signup button
    Then I should see the successful registration message "Sign up successful."
