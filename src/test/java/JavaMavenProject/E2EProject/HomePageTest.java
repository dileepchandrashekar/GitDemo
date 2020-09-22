package JavaMavenProject.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectClass.ForgotPasswordPage;
import pageObjectClass.LandingPageClass;
import pageObjectClass.LoginPageClass;
import resourcesJava.baseClass;

public class HomePageTest extends baseClass{
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(baseClass.class.getName());
	
	@BeforeTest
	public void initilizeDrivers() throws IOException {
		
		driver = initilizeDriver();
		driver.manage().window().maximize();
		
		
	}
	
	@Test(dataProvider="getData")
	
	public void basePageNavigation(String UserName, String Password, String text) throws IOException {
		
		driver.get("http://www.qaclickacademy.com//index.php");		
		log.info("driver is initialized");
		
		LandingPageClass lp = new LandingPageClass(driver);
		lp.login().click();
		
		log.info("home page is initialized");
		
		LoginPageClass lpc = new LoginPageClass(driver);
		lpc.EmailID().sendKeys(UserName);
		lpc.Password().sendKeys(Password);
		System.out.println(text);
		lpc.SignIn().click();
		ForgotPasswordPage fp = lpc.forgotPassword();
        fp.email().sendKeys("abc123");
        fp.sendMeInstructions().click();
		
		log.info("validated");
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[2][3];
		
		data[0][0] = "nonrestricteduser@gmail.com";
		data[0][1] = "abc@123";
		data[0][2] = "nonrestricteduser";
		
		data[1][0] = "restricteduser@gmail.com";
		data[1][1] = "abc@123";
		data[1][2] = "restricteduser";
		
		return data;
	}	
	
	@AfterTest
	public void tearDown() {
		
		driver.close();
	}

}
