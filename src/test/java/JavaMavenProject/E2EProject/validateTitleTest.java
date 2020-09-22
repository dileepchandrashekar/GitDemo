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

public class validateTitleTest extends baseClass {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(baseClass.class.getName());
	
	@BeforeTest
	public void initilizeDrivers() throws IOException {
		
		driver = initilizeDriver();
		driver.manage().window().maximize();
		log.info("driver is initialized");
		driver.get("http://www.qaclickacademy.com//index.php");		
		log.info("home page is initialized");
	}

	
	@Test
	public void validateTitle() throws IOException {
		
		//driver.get(pro.getProperty("url"));
		
		LandingPageClass lp = new LandingPageClass(driver);
		Assert.assertEquals(lp.title().getText(), "FEATURED COURSES@123");
		log.info("validated");
		
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.close();
	}
	
	
	

}
