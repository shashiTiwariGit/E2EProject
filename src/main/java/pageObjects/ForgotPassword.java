package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPassword {
	WebDriver driver;
	@FindBy(xpath="//input[@id='user_email']")
	private WebElement emailAddress;
	@FindBy(xpath="//input[@type='submit']")
	private WebElement sendInstructionButton;

	public ForgotPassword(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	

}
