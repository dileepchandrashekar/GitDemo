package pageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPageClass {
	
	public WebDriver driver;
	
	
    public LandingPageClass(WebDriver driver) {
    	
    	this.driver = driver;
		
	}

   //click login
   //By login = By.xpath("//span[contains(text(),'Login')]");
	
    By login = By.cssSelector("a[href*='sign_in']");
    By title = By.cssSelector("div[class='text-center']>h2");
    By navigateBar = By.xpath("//a[contains(text(),'Contact')]");
    
    
    public WebElement login() {
    	
    	return driver.findElement(login);
    }
    
    public WebElement title() {
    	
    	return driver.findElement(title);
    }
    
    public WebElement navigateBar() {
    	
    	return driver.findElement(navigateBar);
    }
}
