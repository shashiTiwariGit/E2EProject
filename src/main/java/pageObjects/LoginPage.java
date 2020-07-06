package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	By email=By.xpath("//input[@type='email']");
	By password=By.xpath("//input[@id='user_password']");
	By login=By.xpath("//input[@name='commit']");
	@FindBy(css="a[href*='/users/password/new']")
	WebElement forgotPassword;
	@FindBy(xpath="//div[@class='alert alert-danger']")
	WebElement alertText;
	
	
	public WebElement getEmail(){
		WebElement enterEmail=driver.findElement(email);
		return enterEmail;
		
	}
	
	public WebElement getPassword(){
		WebElement passwordLink=driver.findElement(password);
		return passwordLink;
		
	}
	public WebElement getLoginButton(){
		WebElement loginButton= driver.findElement(login);
		return loginButton;
	}
	public ForgotPassword clickForgotPassword(){
		forgotPassword.click();
		ForgotPassword fp=new ForgotPassword(driver);
		return fp;
	}
	public String getAlertText(){
		String s= alertText.getText();
		return s;
		
	}

}
