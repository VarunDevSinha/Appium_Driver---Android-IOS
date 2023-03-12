package com.test.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportUtilities {

	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports reports;
	// helps to generate the logs in the test report.
	public static ExtentTest test;

	public static void reports(String reportPath, String testName) {

		htmlReporter = new ExtentSparkReporter(
				reportPath + "extentReport_" + testName + System.currentTimeMillis() + ".html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		htmlReporter.config().setDocumentTitle("Simple Automation Report");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

	}

	public static void startTest(String testName) {
		test = reports.createTest(testName);
	}

	public static void logTest() {

		String testStatus = test.getStatus().toString();

		switch (testStatus) {
		case "PASS":
			test.log(Status.PASS, "Test case passed");
			break;
		case "FAIL":
			test.log(Status.FAIL, "Test case failed");
			break;
		case "INFO":
			test.log(Status.INFO, "Error in test case execution");
			break;
		case "WARNING":
			test.log(Status.WARNING, "Warning in test case execution");
			break;
		case "SKIP":
			test.log(Status.SKIP, "Test case execution interupted");
			break;
		default:
			System.out.println("Give \"statuc\" as - PASS / FAIL / ERROR / WARNING / FATAL.");
		}

	}

	public static void endTest() {

		reports.flush();
	}
}