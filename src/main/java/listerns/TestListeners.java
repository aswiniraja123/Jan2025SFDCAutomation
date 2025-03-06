package listerns;

import org.testng.ITestListener;
import org.testng.ITestResult;

import tests.BaseTest;
import utils.CommonUtils;

public class TestListeners implements ITestListener {
	
	public void onTestSuccess(ITestResult result) {
		BaseTest.threadLocalTest.get().pass(result.getName() + " PASSED");
		
	}
	
	public void onTestFailure(ITestResult result) {
		BaseTest.threadLocalTest.get().fail(result.getName() + " FAILED");
		BaseTest.threadLocalTest.get()
				.addScreenCaptureFromPath(CommonUtils
						.captureScreenshot(BaseTest.threadLocalDriver.get(), null));
		    
		  }
	
	public void onTestStart(ITestResult result) {
		//BaseTest.test = BaseTest.report.createTest(result.getName());
	   
	  }

}
