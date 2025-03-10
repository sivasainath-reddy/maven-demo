package stepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps {
static WebDriver driver;
	
	@BeforeAll
	public static void setup() {
		driver = new ChromeDriver();
	}
	@AfterAll
	public static void teardown() {
		driver.quit();
	}

	@Given("I navigate to {string}")
	public void i_navigate_to(String url) {
		    driver.get(url);
		    driver.findElement(By.id("signin2")).click();
	}
	@When("I enter registration details")
	public void i_enter_registration_details(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        driver.findElement(By.id("sign-username")).sendKeys(data.get(0).get("Username"));
        driver.findElement(By.id("sign-password")).sendKeys(data.get(0).get("Password"));
	}
	@When("I click the signup button")
	public void i_click_the_signup_button() {
		driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")).click();
	}
	@Then("I should see the successful registration message {string}")
	public void i_should_see_the_successful_registration_message(String expectedMessage) throws InterruptedException {
		Thread.sleep(3000);
		Alert alertmsg = driver.switchTo().alert();
        Assert.assertEquals(alertmsg.getText(), expectedMessage);
        alertmsg.accept();
	}

	
}
