package Shopping_Cart_Demo.Shopping_Cart_Demo.TestComponents;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Shopping_Cart_Demo.Shopping_Cart_Demo.resources.ExtentReporterNG;

public class Listners extends BaseTest implements ITestListener {
	
	ExtentReports extent= ExtentReporterNG.getReportObject();
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result)
	{
		test= extent.createTest(result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS, "Test passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		test.fail(result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context)
	{
		extent.flush(); //to generate the report
	}
}
