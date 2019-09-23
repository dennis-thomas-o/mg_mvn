package com.smarsh.ccm.testEmployees;

import java.io.IOException;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.smarsh.ccm.pages.AddNewEmpPage;
import com.smarsh.ccm.pages.EmployeesPage;
import com.smarsh.ccm.pages.HomePage;
import com.smarsh.ccm.pages.LoginPage;
import com.smarsh.ccm.pages.TestBase;

public class MGNegativeTestsPostLogin extends TestBase {
	
	protected static Logger
	logger = LogManager.getLogger(MGNegativeTestsPostLogin.class);

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		try {
			init();
			LoginPage loginPage = new LoginPage(driver);
			loginPage.loginMG();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Verify the Feature of Add New Employee with Email Address Blank 
	@Test(enabled = false)
	public void C2128742_addEmpWithEmptyEmail( ) {
		//HomePage homePage = new HomePage(driver);
		homePage.goToEmployees();
		//EmployeesPage empPage = new EmployeesPage(driver);
		empPage.clickToAddEmp();
		AddNewEmpPage addEmp = new AddNewEmpPage(driver);
		boolean isAddEmpErrorDisp = addEmp.addEmpWithoutEmail();
		Assert.assertTrue(isAddEmpErrorDisp);
	}
	
	//C2128743 Verify the Feature of Add New Employee with the Duplicate Email Address
	//C2128744 Verify the Feature of Add New Employee with the Duplicate Associated Device ID
	@Test(enabled = false)
	public void C2128743_addEmpWithDupInfo() throws InterruptedException {
		//HomePage homePage = new HomePage(driver);
		homePage.goToEmployees();
		//EmployeesPage empPage = new EmployeesPage(driver);
		empPage.clickToAddEmp();
		AddNewEmpPage addEmp = new AddNewEmpPage(driver);
		boolean isAddEmpWithDupInfoErrorDisp = addEmp.addEmpWithDuplicateEmailOrDev();
		Assert.assertTrue(isAddEmpWithDupInfoErrorDisp);
	}
	
	//Verify the Cancel Button of Add New Employee
	@Test(enabled = true)
	public void C2128746_cancelEmpCreation() throws InterruptedException {
		homePage.goToEmployees();
		empPage.clickToAddEmp();
		AddNewEmpPage addEmp = new AddNewEmpPage(driver);
		boolean cancelEmpFunction = addEmp.cancelAddEmp();
		Assert.assertTrue(cancelEmpFunction);
 	}
	
	//Verify the Feature of Edit Employee with Email Address Blank 
	@Test(enabled = true)
	public void C2128749_editEmpWithoutEmail() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.goToEmployees();
		EmployeesPage empPage = new EmployeesPage(driver);
		boolean isEmpEditErrorDisp = empPage.editEmpWithEmptyEmail();
		Assert.assertTrue(isEmpEditErrorDisp);
	}
	
	@AfterMethod
    public void tearDown(ITestResult result) {
       if (result.getStatus() == ITestResult.FAILURE) {
          logger.error(result);
       }
       else if (result.getStatus() == ITestResult.SUCCESS) {
              logger.info(result);
           }
       else if (result.getStatus() == ITestResult.SKIP) {
              logger.info(result);
           }
    }
}
