package Academy.E2EProject;

import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import utilities.Base;

public class HomePage extends Base {
	public WebDriver driver;
	Logger logs = LogManager.getLogger(HomePage.class.getClass());

	@AfterTest
	public void tearDown() {

	}

	@BeforeTest
	public void browserInstantiation() throws IOException {
		logs.info("Browser is Initialize");

	}

	@BeforeTest
	public void loggings() {

	}

	@Test(dataProvider = "getData")
	public void getHomePage(String userName, String password) throws IOException {

		driver = initializeDriver();
		logs.info("Browser is Initialize");
		LandingPage l = new LandingPage(driver);
		LoginPage lp = l.clickOnLogin();
		logs.info("navigated to Login Page");
		lp.getEmail().sendKeys(userName);
		logs.info("Entered Email");
		lp.getPassword().sendKeys(password);
		logs.info("Entered Password");

		lp.getLoginButton().click();
		driver.close();
		logs.info("Browser is Teared Down");
	}

	@DataProvider
	public Object[][] getData() {

		// Row Stands for how many different set of data types should run
		// Column gives number of Data required per Test case
		Object[][] data = new Object[2][2];
		data[0][0] = "nonrestictedUser@user.com";
		data[0][1] = "nonrestictedUser123";

		data[1][0] = "restictedUser@user.com";
		data[1][1] = "restictedUser123";

		return data;
	}

}
