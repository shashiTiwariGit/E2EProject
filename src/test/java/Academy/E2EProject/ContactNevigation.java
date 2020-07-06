package Academy.E2EProject;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import utilities.Base;

public class ContactNevigation extends Base {
	public WebDriver driver;
	Logger logs=LogManager.getLogger(ContactNevigation.class.getClass());
	@AfterMethod
	public void tearDown() {
		driver.close();
		logs.info("Browser is Teared Down");
	}

	@BeforeTest
	public void browserInstantiation() throws IOException {
		logs.info("Browser is Initialize");
		driver = initializeDriver();
	}

	@Test
	public void getHomePage() throws IOException {
		
		LandingPage l = new LandingPage(driver);
		l.getContact().click();
		logs.info("Click on Contacts link");
		AssertJUnit.assertTrue(driver.getTitle().equalsIgnoreCase(prop.getProperty("Title")));
		logs.warn("Checked it with Title");
		AssertJUnit.assertEquals(driver.getCurrentUrl(), prop.getProperty("ContactUrl"));
		logs.warn("Checked contact Url");

	}

}
