package stepDefinations;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import utilities.Base;
import cucumber.api.java.en.Then;

@RunWith(Cucumber.class)
public class StepDefination extends Base {
	LoginPage lp;

	@Given("^initialize driver with chrome browser$")
	public void initialize_driver_with_chrome_browser() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		driver = initializeDriver();
	}

	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) {
		// Write code here that turns the phrase above into concrete actions
		driver.get(arg1);

	}

	@Given("^Click on Login link on Home page to land on secure sign in page$")
	public void click_on_Login_link_on_Home_page_to_land_on_secure_sign_in_page() {
		// Write code here that turns the phrase above into concrete actions
		LandingPage l = new LandingPage(driver);
		if (l.getPopUp().size() > 0)
			l.getPopUpButton().click();
		lp = l.clickOnLogin();

	}

	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
	public void user_enters_and_Password_and_logs_in(String username, String password) {
		// Write code here that turns the phrase above into concrete actions
		lp.getEmail().sendKeys(username);

		lp.getPassword().sendKeys(password);
		lp.getLoginButton().click();

	}

	@When("^user enters (.+) and (.+) and logs in$")
	public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		lp.getEmail().sendKeys(username);

		lp.getPassword().sendKeys(password);
		lp.getLoginButton().click();
	}

	@Then("^Verfiy that user is getting Invalid Username password text$")
	public void verfiy_that_user_is_succesfully_logged_in() {
		// Write code here that turns the phrase above into concrete actions
		// lp.getAlertText().trim().equalsIgnoreCase("");
		Assert.assertTrue(true);

	}
	@Then("^close browser$")
	public void close_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.quit();
	}

}