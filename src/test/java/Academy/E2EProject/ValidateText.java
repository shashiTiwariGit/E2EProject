package Academy.E2EProject;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import utilities.Base;

public class ValidateText extends Base {
	public WebDriver driver;
	Logger logs=LogManager.getLogger(ValidateText.class.getClass());
	@AfterMethod
	public void tearDown() {
		
	}

	@BeforeTest
	public void browserInstantiation() throws IOException {
		logs.info("Browser is Initialize");
		driver = initializeDriver();
	}


	@Test
	public void getTextValue() throws IOException {
		
		
		LandingPage lp = new LandingPage(driver);
		AssertJUnit.assertEquals(lp.getTitle().getText(), prop.getProperty("TextValue"));
		logs.info("Test Case Passed");
		driver.close();
		logs.info("Browser is Teared Down");

	}

}
