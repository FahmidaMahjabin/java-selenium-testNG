package testNGFiles;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManage implements ITestListener{
	
	public ExtentSparkReporter sparkReporter;   
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext context) {
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/extentReport.html");
		sparkReporter.config().setDocumentTitle("Automation title");
		sparkReporter.config().setReportName("ligin testing");
		
		extent  = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("domain", "localhost");
		extent.setSystemInfo("Tester name", "Fahmida");
		extent.setSystemInfo("OS", "Windows10");
	
	}
	
	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "the test passedis:"+ result.getName());
		
	}
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "The test failed:" + result.getName());
		test.log(Status.FAIL, "The test failure cause is:" + result.getThrowable());
	}
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "The test skipped is:"+ result.getName());
		
	}
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
