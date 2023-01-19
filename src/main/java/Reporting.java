import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporting {
	ExtentReports reports;
	ExtentHtmlReporter htmlReporter;
	ExtentTest test;

	public void extentReport() { 

		reports = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "extentReport.html");
		reports.attachReporter(htmlReporter);

	}

	@Test
	public void testPass() {
		test = reports.createTest("test case passed");
		System.out.println("passed successfully");
		test.pass("Passed");
	}

	@Test
	public void testFail() {
		test = reports.createTest("Fail test case");
		System.out.println("failed intentionally");
		System.out.println("Just to see github actions");
		test.pass("failed");
	}

	@AfterTest
	public void afterTesting(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println(result.getTestName());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println(result.getTestName());
		}

	}
}
