package utilities;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	public WebDriver driver;
	private File src = new File("./ConfigurationFiles/config.properties");
	public Properties prop = new Properties();

	public WebDriver initializeDriver() throws IOException {
		FileInputStream fis = new FileInputStream(src);
		prop.load(fis);
		String browser= "chrome";//System.getProperty("xyz");

		// Chrome
		if (browser.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("ChromeDriver"));
			ChromeOptions options= new ChromeOptions();
			if (browser.contains("headless"))
			options.addArguments("headless");
			driver = new ChromeDriver(options);

		}
		// FireFox
		else if (browser.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("ChromeDriver"));
			driver = new FirefoxDriver();
		}
		// IE
		else if (browser.equals("IE")){
			System.setProperty("webdriver.ie.driver", prop.getProperty("ChromeDriver"));
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("BaseUrl"));

		return driver;
	}

	public String getScreenShotPathBase(String testCaseName, WebDriver driver) throws IOException {
		
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Screenshots/"+testCaseName+".png";
		File destinationFile= new File(destination);
		FileUtils.copyFile(source, destinationFile);
		return destination;
	}
}
