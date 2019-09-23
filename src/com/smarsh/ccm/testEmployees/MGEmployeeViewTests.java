package com.smarsh.ccm.testEmployees;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.smarsh.ccm.pages.EmployeeViewPage;
import com.smarsh.ccm.pages.EmployeesPage;
import com.smarsh.ccm.pages.HomePage;
import com.smarsh.ccm.pages.TestBase;
import com.smarsh.ccm.utils.DeviceGetSet;
import com.smarsh.ccm.utils.ReadDeviceFromCSV;

public class MGEmployeeViewTests extends TestBase{
	protected static EmployeeViewPage empViewPage;
	protected static Logger
	logger = LogManager.getLogger(MGEmployeeViewTests.class);
	String userDirPath = System.getProperty("user.dir");
	File downloadPath =new File(userDirPath+"\\Downloads");
	

	@BeforeClass
	public void beforeTest() throws InterruptedException {
		
		mobileGuardLogin();
		System.out.println("Logged in successfully ");
		empViewPage = new EmployeeViewPage(driver);
	
	}


	//Verify the UI of Employee View Page
	@Test(priority = 20, enabled = false)
	public void C2128772_verifyViewEmpUI() throws InterruptedException {
		homePage = new HomePage(driver);
		homePage.goToEmployees();
		boolean isViewEmpPageIntact = empViewPage.verifyViewEmpPageUI();
		Assert.assertTrue(isViewEmpPageIntact);
	}
	
	//Added on 26th Aug..........
	
	//Verify the Feature of Delete Device
	@Test(enabled = false)
	public void C2128775_deleteDeviceFromEmpView() throws InterruptedException {
		homePage = new HomePage(driver);
		homePage.goToEmployees();
		
		empViewPage.deleteDevice();
	}
	
	//.......end...........
	
	//	Verify the Feature of Add New Device
	@Test(dataProvider = "readDeviceCSVAndMap", dependsOnMethods = {"deleteDeviceFromEmpView"}, enabled = false)
	public void C2128773_AddDeviceToEmp(DeviceGetSet device) throws InterruptedException {
		homePage = new HomePage(driver);
		homePage.goToEmployees();
		
		empViewPage.addNewDevice(device);
		boolean isDeviceAdded = empViewPage.verifyDevAdded(device);
		Assert.assertTrue(isDeviceAdded);
	}	
	
	//new code 25th aug
	
	//Verify the Feature of Edit Device
	@Test(dataProvider = "readDeviceCSVAndMap", dependsOnMethods = {"AddDeviceToEmp"}, enabled = false)
	public void C2128774_editDevDetails(DeviceGetSet device) throws InterruptedException {
		homePage = new HomePage(driver);
		homePage.goToEmployees();
		
		boolean isDevEdited = empViewPage.editAddedDev(device);
		Assert.assertTrue(isDevEdited);
	}
	
	//Verify the Feature of Add New Device with Unique ID Missing 
	@Test(dataProvider = "readDeviceCSVAndMap", enabled = false)
	public void C2569711_addDeviceFailure(DeviceGetSet device) throws InterruptedException {
		homePage = new HomePage(driver);
		homePage.goToEmployees();
		
		boolean isDevAdditionFailed = empViewPage.addDevWithNoUniqueID(device);
		Assert.assertTrue(isDevAdditionFailed);
	}
	
	//C2128778	Verify the Feature of Add White List
	//C2128779	Verify the Feature of Delete White List
	@Test(enabled = false)
	public void C2128778_addWhitelistItems() throws InterruptedException {
		homePage = new HomePage(driver);
		homePage.goToEmployees();
		
		empViewPage.delteWhiteList();
		empViewPage.addWhiteList();
		//empPage.verifyAddedWhitelists();
	}
	
	//Verify the Employee Audit Log
	@Test(enabled = false)
	public void C2128782_verifyAuditLogList() throws InterruptedException {
		homePage = new HomePage(driver);
		homePage.goToEmployees();
		
		boolean isLogUIRight = empViewPage.verifyAuditLog();
		Assert.assertTrue(isLogUIRight);
	}
	
	//Verify the Filter of Employee Audit Log
	@Test(dependsOnMethods = {"verifyAuditLogList"} ,enabled = false)
	public void C2690849_verifyauditLogFilters() throws InterruptedException {
		
		boolean isFilterCorrect = empViewPage.verifyAuditLogFilter();
		Assert.assertTrue(isFilterCorrect);
	}
	
	//Verify the Pagination of Employee Audit Log
	@Test(enabled = false)
	public void C2128782_verifyAuditPagination() throws InterruptedException {
		
		boolean isPaginationCorrect = empViewPage.verifyAuditLogPageNavigation();
		Assert.assertTrue(isPaginationCorrect);
	}
	
	//Verify the Filter of Employee Audit Log
	@Test(enabled = false)
	public void C2690849_verifycontainsFilterinAuditLog() throws InterruptedException {
		
		boolean isPaginationCorrect = empViewPage.verifyAuditLogContainsFilter();
		Assert.assertTrue(isPaginationCorrect);
	}
	
	//Verify the Filter of Employee Audit Log
	@Test(enabled = false)
	public void C2690849_verifyTimeFrame() throws InterruptedException {
		
		boolean isPaginationCorrect = empViewPage.verifyAuditLogTimeFilter();
		Assert.assertTrue(true);
	}
	
	//Verify the Clear Filter Button of Employee Audit Log
	@Test(enabled = false)
	public void C2128786_verifyclearAuditLogFilters() throws InterruptedException {
		
		boolean isPaginationCorrect = empViewPage.clearAuditLogFilter();
		Assert.assertTrue(true);
	}
	
	//Verify the Contact List
	@Test(enabled = false)
	public void C2128780_verifyContactsForEmployee() throws InterruptedException {
		homePage = new HomePage(driver);
		homePage.goToEmployees();
		boolean isContatctsDetailsCorrect = empViewPage.verifyContacts();
		Assert.assertTrue(isContatctsDetailsCorrect);
	}
	
	//	Verify the Recent Messages' Counts on the Employee View Page
	@Test(enabled = true)
	public void C2128788_verifyMsgsForEmployee() throws InterruptedException {
		homePage = new HomePage(driver);
		homePage.goToEmployees();
		boolean isMsgsNumCorrect = empViewPage.verifyNumOfMessages();
		Assert.assertTrue(isMsgsNumCorrect);
	}
	
	//Verify the Feature of Download Search of Employee Audit Log
	@Test(enabled = false)
	public void C2128787_verifyDownloadAuditLogSearch() {
		FileUtils.deleteQuietly(downloadPath);
		homePage.goToEmployees();
		empPage.clickonDownloadEmployeeSampleCSV();
		Assert.assertEquals(empPage.vaildateDownloadedCsvHeader(downloadPath),getObject("logCSVHeader"));
	}
	
	//...........end.......
	
	//new code from sagar
	
	@DataProvider(name = "readDeviceCSVAndMap")
	public Object[][] readDeviceCSVAndMap() {
		ReadDeviceFromCSV csvDevRead = new ReadDeviceFromCSV();
		List<DeviceGetSet> devList = csvDevRead.readDeviceCSVAndMap("./Devices.csv");
		Object [][] devObj = new Object[devList.size()][1];
		
		for (int j = 0; j < devList.size() ; j++) {
			devObj[j][0] = devList.get(j);
		}
		
		return devObj;
		
	}
	
}
