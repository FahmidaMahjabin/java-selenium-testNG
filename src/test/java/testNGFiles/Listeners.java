package testNGFiles;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
	@Override
	public void onStart(ITestContext contextStart) {
		System.out.print("Test starts");
	}
	@Override
	public void onTestSuccess(ITestResult result) {
	System.out.println("Method passed"+ result.getName());

	}
	@Override
	public void onTestFailure(ITestResult result) {
	System.out.println("Method failed"+ result.getName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
	System.out.println("Method skipped"+ result.getName());

	}

	@Override
	public void onTestStart(ITestResult result) {
	System.out.println("Method started"+ result.getName());

}
	
}
