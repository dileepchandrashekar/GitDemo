package JavaMavenProject.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjectClass.LandingPageClass;
import resourcesJava.baseClass;

public class NavigateBarTest extends baseClass {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(baseClass.class.getName());
	
	@BeforeTest
	public void initilizeDrivers() throws IOException {
		
		driver = initilizeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.qaclickacademy.com//index.php");
			
	}

	@Test
	public void NavigateBar() throws IOException {


		LandingPageClass lp = new LandingPageClass(driver);
		Assert.assertTrue(lp.navigateBar().isDisplayed());

	}

	@AfterTest
	public void tearDown() {

		driver.close();
	}

}
