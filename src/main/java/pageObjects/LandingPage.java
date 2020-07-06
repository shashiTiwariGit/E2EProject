package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	By login=By.cssSelector("a[href*='sign_in']");
	By title=By.cssSelector("div [class='text-center'] h2");
	By contact=By.xpath("//a[text()='Contact']");
	By noThanksButton= By.xpath("//button[text()='NO THANKS']");
	
	
	
	public WebElement getLogin(){
		WebElement loginlink=driver.findElement(login);
		return loginlink;
		
	}
	public WebElement getTitle(){
		WebElement titleValue=driver.findElement(title);
		return titleValue;
		
	}
	public WebElement getContact(){
		WebElement contact=driver.findElement(this.contact);
		return contact;
		
	}
	public LoginPage clickOnLogin(){
		driver.findElement(this.login).click();;
		LoginPage lp=new LoginPage(driver);
		return lp;
		
	}
	public List<WebElement> getPopUp(){
		return driver.findElements(noThanksButton);
	}
	public WebElement getPopUpButton(){
		return driver.findElement(noThanksButton);
	}

}
