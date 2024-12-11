package TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Reports;

public class Listeners extends BaseTest implements ITestListener {
	ExtentTest test;
	Reports report= new Reports();
	ExtentReports extent=	report.getExtentReports();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
test=extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
	test.log(Status.PASS,"Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
	test.fail(result.getThrowable());
	try {
		driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	}
	catch (Exception e1) {
		e1.printStackTrace();
	}
	String path=null;
	try {
		 path = screenShot(result.getMethod().getMethodName(),driver);}
	catch(IOException e) {
		e.printStackTrace();
	}
	test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		extent.flush();
	}

}
