package resourcesJava;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterClass {
	
    static ExtentReports extent;
	
	public static ExtentReports config() {
		
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter spark = new ExtentSparkReporter(path);
		spark.config().setReportName("web automation results");
		spark.config().setDocumentTitle("Test Results");
		
	    extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("QA", "ABC");
		return extent;
	}

}
