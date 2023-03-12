package com.test.stepDefinitions;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.test.utils.ReportUtilities;

public class TestExtentReport extends ReportUtilities {

	@BeforeAll
	public static void setupEnvironment() {
		reports(".//trgt//extentReports", "functionalTest1");
		reports(".//trgt//extentReports", "functionalTest2");
		reports(".//trgt//extentReports", "functionalTest3");
	}

	@BeforeEach
	public static void loginFunction() {

		// Application starts function.
		// User login function.
		// Locating element functions.
	}

	@Test
	public void functionalTest1() {

		// Functions for action.
		startTest("functionalTest1");
		logTest();
	}

	@Test
	public void functionalTest2() {
		// Functions for action.
		startTest("functionalTest2");
		logTest();
	}

	@Test
	public void functionalTest3() {
		// Functions for action.
		startTest("functionalTest3");
		logTest();
	}

	@AfterEach
	public static void validateLogoutFunction() {

		// Application logout function
		endTest();
	}

	@AfterAll
	public static void appResetEnvironmentTeardown() {

		// Functions for application and environment tear down.
	}
}
