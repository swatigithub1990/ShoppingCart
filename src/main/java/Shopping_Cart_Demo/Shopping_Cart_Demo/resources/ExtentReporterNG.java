package Shopping_Cart_Demo.Shopping_Cart_Demo.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
public static ExtentReports getReportObject()
{
	//ExtentReports, ExtentSparkReporter
			String path=System.getProperty("user.dir")+"\\reports\\index.html";
			ExtentSparkReporter reporter= new ExtentSparkReporter(path);
			reporter.config().setReportName("Automation Test Result");
			reporter.config().setDocumentTitle("Test Results");
			
			ExtentReports extent=new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Swati Mishra");
			return extent;
}
}
