package pageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageClass {

	public WebDriver driver;

	public LoginPageClass(WebDriver driver) {

		this.driver = driver;

	}

	By EmailID = By.cssSelector("input[id='user_email']");
	By Password = By.cssSelector("input[id='user_password']");
	By SignIn = By.cssSelector("input[value='Log In']");
	By forgotPassword = By.xpath("//a[@class='link-below-button']");

	public ForgotPasswordPage forgotPassword() {

		driver.findElement(forgotPassword).click();
		return new ForgotPasswordPage(driver);

	}

	public WebElement EmailID() {

		return driver.findElement(EmailID);
	}

	public WebElement Password() {

		return driver.findElement(Password);
	}

	public WebElement SignIn() {

		return driver.findElement(SignIn);

	}

}
