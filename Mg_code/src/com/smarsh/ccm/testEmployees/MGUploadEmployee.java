package com.smarsh.ccm.testEmployees;

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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
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


public class MGUploadEmployee extends TestBase {
	protected static EmployeeViewPage empViewPage;
	Date currentdate = new Date();
	DateFormat HrMinSec = new SimpleDateFormat("HHmmss");
	String HMS = HrMinSec.format(currentdate);
	protected static Logger
	logger = LogManager.getLogger(MGUploadEmployee.class);
	
	
	String userDirPath = System.getProperty("user.dir");
	File uploadedPath = new File(userDirPath + "\\Upload");
	File downloadPath =new File(userDirPath+"\\Downloads");
	String UploadFilePath = uploadedPath + File.separator + "csvupload.csv";

	@BeforeClass
	public void beforeTest() throws InterruptedException {
		mobileGuardLogin();
		System.out.println("Logined successfully ");
		System.out.println(userDirPath);
		System.out.println(downloadPath);
	}

	//Verify the Template CSV Link
	@Test(priority = 1, enabled = true)
	public void C3700238_DownloadandValidateEmployeeUploadFile() {
		
		FileUtils.deleteQuietly(downloadPath);
		homePage.goToEmployees();
		empPage.clickonDownloadEmployeeSampleCSV();
		Assert.assertEquals(empPage.vaildateDownloadedCsvHeader(downloadPath),getObject("EmpCsvHeader"));
		
		
	}
	//Verify the Feature of Upload Employees
	@Test(priority = 2, enabled = false)
	public void C3700238_UploadAllCarrierData_Validate_UI() {
		(new File("Upload")).mkdir();
		String userDirPath = System.getProperty("user.dir");
		File uploadedPath = new File(userDirPath + "\\Upload");
		String empCSVUploadedtype = "Created";
		String UploadFilePath = uploadedPath + File.separator + "csvupload.csv";
		homePage.goToEmployees();
		List<String> Empdeatils = new ArrayList();
		Empdeatils = empPage.csvWriteAllcarriersDetails(UploadFilePath, HMS);
		empPage.chooseEmployeeCSV_UploadFile(UploadFilePath);
		Assert.assertTrue(empPage.validateMsgDisplayed(empCSVUploadedtype));
		empPage.search_EmailAddressContains(Empdeatils.get(2));
		empPage.click_ViewEmpOverviewIcon();
		empViewPage = new EmployeeViewPage(driver);
		Assert.assertTrue(empViewPage.vaidateAllCarrierPhoneNumber(Empdeatils));

	}
	
	//@Test(dependsOnMethods = { "C3700238_UploadAllCarrierData_Validate_UI" },priority = 3)
	@Test(priority = 3, enabled = false)
	public void MGCSV003_UpdateExisitingEmp_WithTMO() {
		String empCSVUploadedtype = "Update";
		homePage.goToEmployees();
		List<String> Empdeatils = new ArrayList();
		Empdeatils = empPage.csvWriteTMOcarriersDetails(UploadFilePath, HMS);
		empPage.chooseEmployeeCSV_UploadFile(UploadFilePath);
		Assert.assertTrue(empPage.validateMsgDisplayed(empCSVUploadedtype));
		System.out.println(Empdeatils.get(2));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		empPage.search_EmailAddressContains(Empdeatils.get(2));
		empPage.click_ViewEmpOverviewIcon();
		empViewPage = new EmployeeViewPage(driver);
		Assert.assertTrue(empViewPage.vaidateTMOCarrierPhoneNumber(Empdeatils));

		
	}
	
	//Verify the Downloaded CSV File of Upload Results
	@Test(priority = 4, enabled = false)
	public void C3700242_UploadWrongDataData_Validate_UI() {
		String empCSVUploadedtype = "Failed";
		homePage.goToEmployees();
		List<String> Empdeatils = new ArrayList();
		Empdeatils = empPage.csvWriteWrongDetails(UploadFilePath, HMS);
		empPage.chooseEmployeeCSV_UploadFile(UploadFilePath);
		Assert.assertTrue(empPage.validateMsgDisplayed(empCSVUploadedtype));
		FileUtils.deleteQuietly(downloadPath);
		Assert.assertTrue(empPage.validateDownloadNowCsv(downloadPath).contains(empCSVUploadedtype.toLowerCase()));
		
	}
	
	@Test(priority = 4, enabled = false)
	public void C3700243_UploadWrongDataData_Validate_UI() {
		
		 logger.info("This is info message");
		 System.out.println("hey whts up");
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
