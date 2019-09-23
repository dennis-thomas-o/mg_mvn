package com.smarsh.ccm.testEmployees;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.smarsh.ccm.pages.LoginPage;
import com.smarsh.ccm.pages.TestBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.monitor.FileEntry;
import com.opencsv.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.smarsh.ccm.pages.EmployeeViewPage;
import com.smarsh.ccm.pages.EmployeesPage;
import com.smarsh.ccm.pages.HomePage;
import com.smarsh.ccm.pages.LoginPage;
import com.smarsh.ccm.pages.TestBase;



import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MGEditEmployees extends TestBase{
	
	protected static Logger
	logger = LogManager.getLogger(MGEditEmployees.class);
	
	@BeforeClass
	public void beforeTest() throws InterruptedException {
		mobileGuardLogin();
		System.out.println("Logined successfully ");
		
	}
	
	// Verify the Cancel Button of Edit Employee
	@Test(priority =01 , enabled = true)
	public void C2128753_verifyCancleBtnEditEmp() throws InterruptedException, IOException{
		homePage.goToEmployees();
		empPage.verifyCancleBtnEditEmp();
		Assert.assertEquals(driver.getTitle(), "Employees");
	}
	
	//Verify the Feature of Add New Employee with the Duplicate Associated Device ID 
		@Test(priority = 02, enabled = true)
		public void C2128744_verifyEmpDupAssociatedID() throws InterruptedException, IOException{
			homePage.goToEmployees();
			List<String> EmpIdEmail = new ArrayList();
			EmpIdEmail=empPage.getEmpIdEmail();
			System.out.println(EmpIdEmail);
			Assert.assertTrue(empPage.createNewEmpDupAssociatedID(EmpIdEmail));
		}

		//Verify the Feature of Employee Filter and Clear Filter   
		@Test(priority = 03, enabled = true)
		public void C2128766_C2128767_verifyEmpFilter_ClearFilter() throws InterruptedException, IOException{
			homePage.goToEmployees();
			Assert.assertTrue(empPage.verifyAllEmpfilter());
			System.out.println("Employee filter And Clear filter are succefully");
			
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
