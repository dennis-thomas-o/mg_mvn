package com.smarsh.ccm.testEmployees;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.smarsh.ccm.pages.AddNewEmpPage;
import com.smarsh.ccm.pages.ForgotPasswordPage;
import com.smarsh.ccm.pages.LoginPage;
import com.smarsh.ccm.pages.TestBase;

public class MGNegativeTests extends TestBase {

	protected static Logger logger = LogManager.getLogger(MGNegativeTests.class);

	// ForgotPasswordPage resetPassword = new ForgotPasswordPage(driver);

	// Verify the Link of "Forgot Password" on the Sign In Page
	@Test(enabled = true)
	public void C2128602_verifyForgotPasswordPageTitle() {
		try {
			init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LoginPage loginPage = new LoginPage(driver);
		boolean coorectTitleDisplayed = loginPage.verifyForgotPasswordPage();
		Assert.assertTrue(coorectTitleDisplayed);
	}

	// Verify the Feature of "Forgot Password"
	@Test(enabled = true)
	public void C5617253_resetPasswdEmptyEmail() {
		ForgotPasswordPage resetPassword = new ForgotPasswordPage(driver);
		boolean resetFailed1 = resetPassword.emptyEmail();
		Assert.assertTrue(resetFailed1);
	}

	// Verify the Feature of "Forgot Password"
	@Test(enabled = true)
	public void C5617253_resetPasswdInvalidEmailFormat() {
		ForgotPasswordPage resetPassword = new ForgotPasswordPage(driver);
		boolean resetFailed2 = resetPassword.invalidEmailFormat();
		Assert.assertTrue(resetFailed2);
	}

	/*
	 * @Test(priority = 4, enabled = true) public void resetPasswdInvalidEmail() {
	 * ForgotPasswordPage resetPassword = new ForgotPasswordPage(driver); boolean
	 * resetFailed3 = resetPassword.invalidEmailAddress();
	 * Assert.assertTrue(resetFailed3); }
	 */

	// Verify the Feature of "Forgot Password"
	@Test(enabled = true)
	public void C5617253_resetPasswdSuccess() {
		ForgotPasswordPage resetPassword = new ForgotPasswordPage(driver);
		boolean resetPasswdSuccess = resetPassword.resetPassword();
		Assert.assertTrue(resetPasswdSuccess);
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.error(result);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.info(result);
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.info(result);
		}
	}
}
