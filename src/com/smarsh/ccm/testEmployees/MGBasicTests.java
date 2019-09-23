package com.smarsh.ccm.testEmployees;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.seleniumhq.jetty9.server.HomeBaseWarning;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.smarsh.ccm.pages.AddNewEmpPage;
import com.smarsh.ccm.pages.EmployeesPage;
import com.smarsh.ccm.pages.HomePage;
import com.smarsh.ccm.pages.LoginPage;
import com.smarsh.ccm.pages.TestBase;
import com.smarsh.ccm.utils.DeviceGetSet;
import com.smarsh.ccm.utils.EmployeesGetSet;
import com.smarsh.ccm.utils.ReadDeviceFromCSV;
import com.smarsh.ccm.utils.ReadEmpFromCSV;

public class MGBasicTests extends TestBase {
	protected static Logger logger = LogManager.getLogger(MGBasicTests.class);

	// Verify UI of Sign In Page
	@Test(enabled = true, priority = 1)
	public void C2128595_isLoginPageDispCorrectly() throws IOException, InterruptedException {
		init();
		LoginPage loginPage = new LoginPage(driver);
		boolean uiDispCorrect = loginPage.verifyLoginPage();
		Assert.assertTrue(uiDispCorrect);
	}

	//
	@Test(enabled = false, priority = 2)
	public void C2128595_verifyCopyRightDetailsOnLogin() throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		boolean isCorrectlyDisplayed = loginPage.verifyCopyRightOnLogin();
		logger.debug("11111111111111111111111111111111111111111111111111111111111111222222222222222");
		//logger.info("aszssdsdsdsd");
		Assert.assertTrue(isCorrectlyDisplayed);
	}

	// C2128596 Verify Sign In with the Valid Credential
	// C2128597 Verify Sign In with the Invalid Email Address
	// C2128598 Verify Sign In with Email Address Blank
	// C2128599 Verify Sign In with the Invalid Password
	// C2128600 Verify Sign In with the Password Blank
	// C2128601 Verify Sign In with both Email Address and Password Blank
	@Test(enabled = true, priority = 3)
	public void C2128596_TetsLogin() throws IOException, InterruptedException {

		// init("url");
		LoginPage loginPage = new LoginPage(driver);

		// wrong username
		loginPage.wrongUserID();
		WebElement errorBar = driver.findElement(By.xpath("//span[@id='ErrMsg']"));
		Assert.assertTrue(errorBar.isDisplayed());
		if (errorBar.isDisplayed()) {
			String errorMsg = errorBar.getText();
			logger.info(errorMsg);
			Assert.assertEquals(errorMsg,
					"Invalid email or password used. Please try again or use the Forgot Password function.");
		}

		// wrong password
		driver.get(System.getProperty("url"));
		loginPage.wrongPassword();
		WebElement errorBar1 = driver.findElement(By.xpath("//span[@id='ErrMsg']"));
		Assert.assertTrue(errorBar1.isDisplayed());
		if (errorBar1.isDisplayed()) {
			String errorMsg1 = errorBar1.getText();
			logger.info(errorMsg1);

			Assert.assertEquals(errorMsg1,
					"Invalid email or password used. Please try again or use the Forgot Password function.");
		}

		// empty username
		driver.get(System.getProperty("url"));
		loginPage.emptyUserID();
		WebElement errorBar2 = driver.findElement(By.xpath("//span[@id='ErrMsg']"));
		Assert.assertTrue(errorBar2.isDisplayed());
		if (errorBar2.isDisplayed()) {
			String errorMsg2 = errorBar2.getText();
			logger.info(errorMsg2);

			Assert.assertEquals(errorMsg2, "Username or password cannot be blank. Please enter both.");
		}

		// empty password
		driver.get(System.getProperty("url"));
		loginPage.emptyPassword();
		WebElement errorBar3 = driver.findElement(By.xpath("//span[@id='ErrMsg']"));
		Assert.assertTrue(errorBar3.isDisplayed());
		if (errorBar3.isDisplayed()) {
			String errorMsg3 = errorBar3.getText();
			logger.info(errorMsg3);

			Assert.assertEquals(errorMsg3, "Username or password cannot be blank. Please enter both.");
		}

		// sucecssful login
		driver.get(System.getProperty("url"));
		Thread.sleep(2000);
		boolean successfulLogin = loginPage.loginMG();
		Thread.sleep(2000);
		// String homePageTitle = driver.getTitle();
		// System.out.println(homePageTitle);
		// Thread.sleep(2000);
		Assert.assertTrue(successfulLogin);

	}

	// Verify the Release Notification
	@Test(enabled = true, priority = 4)
	public void C6059217_verifyRelNot() throws InterruptedException {
		boolean isRelNote = homePage.verifyReleaseNotification();
		Assert.assertTrue(isRelNote);
	}

	// Verify UI of Dashboard Page
	@Test(enabled = false, priority = 4)
	public void C2128669_verifyHomePageItems() {
		boolean iscpyRightCorrectlyDisplayedOnHome = homePage.verifyCopyRightDetailsOnDashboard();
		Assert.assertTrue(iscpyRightCorrectlyDisplayedOnHome);
		// code to check existence of all home page elements
	}

	@Test(enabled = false, priority = 5)
	public void C2128669_verifyEmpSearch() throws InterruptedException {
		homePage.empSearch();
		Thread.sleep(1000);

		try {
			boolean searchResultDispl = driver.findElement(By.id("MainContent_GridNow")).isDisplayed();
			Assert.assertTrue(searchResultDispl);

			List<WebElement> results = driver.findElements(By.xpath("//table[@id='MainContent_GridNow']//tbody//tr"));

			for (WebElement webElement : results) {
				String empInfo = webElement.getText();

				String empName = empInfo.substring(0, empInfo.lastIndexOf(" "));
				String empEmail = empInfo.substring(empInfo.lastIndexOf(" ") + 1);

				boolean isPresent = false;
				if (empName.contains("sagar") || empEmail.contains("Sagar")) {
					isPresent = true;
					System.out.println("String is present in the searched result");
				}
				Assert.assertTrue(isPresent);
			}
		}

		catch (Exception e) {
			System.out.println("No search results displayed");
		}
	}

	@Test(enabled = false, priority = 6)
	public void C2128687_navigateToEmployees() {
		homePage = new HomePage(driver);
		homePage.goToEmployees();
		String empPageTitle = driver.getTitle();
		Assert.assertEquals(empPageTitle, "Employees");
	}

	/*
	 * @Test (priority = 4) public void empAdd() { EmployeesPage empPage = new
	 * EmployeesPage(driver); empPage.clickToAddEmp(); }
	 */

	// new code from sagar

	// To be merged 09thAug....................

	// Verify the Link of Add New Employee on Employees Page
	@Test(enabled = false, priority = 7)
	public void C2128740_verifyEmpPageUI() {
		EmployeesPage empPage = new EmployeesPage(driver);
		boolean isEmpPageIntact = empPage.verifyEmpUI();
		Assert.assertTrue(isEmpPageIntact);
	}

	// To be merged 07th Aug...............

	// new code from sagar

	// Verify the Feature of Add New Employee
	@Test(dataProvider = "readCSVAndMapIt", enabled = false, dependsOnMethods = {"C2128687_navigateToEmployees"}, priority = 8)
	public void C2128741_addEmployee(EmployeesGetSet employee) throws InterruptedException {
		// EmployeesPage empPage = new EmployeesPage(driver);
		empPage.clickToAddEmp();
		AddNewEmpPage addEmpPage = new AddNewEmpPage(driver);
		boolean verifyPage = addEmpPage.verifyAddEmpPage();
		Assert.assertTrue(verifyPage);
		/*
		 * boolean additionFailed = addEmpPage.addAnEmp(employee);
		 * Assert.assertFalse(additionFailed);
		 */
		Thread.sleep(1000);
		// EmployeesGetSet employee = null;
		addEmpPage.addAnEmp(employee);
		Assert.assertTrue(empPage.verifyEmpPage());
	}

	@Test(dataProvider = "readCSVAndMapIt", enabled = false, dependsOnMethods = {"C2128741_addEmployee"}, priority = 9)
	public void searchEmp(EmployeesGetSet employee) throws InterruptedException {
		EmployeesPage empPage = new EmployeesPage(driver);
		/* AddNewEmpPage addEmpPage = new AddNewEmpPage(driver); */
		empPage.searchAddedEmp(employee);
		boolean empInfoCorrect = empPage.verifyEmpDetails(employee);
		Assert.assertTrue(empInfoCorrect);
	}

	// C2128747 Verify the Link of Edit Employee on Employees Page
	// C2128748 Verify the Feature of Edit Employee
	@Test(enabled = false, priority = 10)
	public void C2128748_editAddedEmp() throws InterruptedException {

		/*
		 * try { init(); LoginPage loginPage = new LoginPage(driver);
		 * loginPage.loginMG(); } catch (IOException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 */

		homePage.goToEmployees();
		// EmployeesPage empPageSearch = new EmployeesPage(driver);
		empPage.clickToAddEmp();
		AddNewEmpPage addEmpPage = new AddNewEmpPage(driver);
		addEmpPage.addToEditEmp();

		boolean updateSuccess = empPage.editEmp();
		Assert.assertTrue(updateSuccess);
	}

	//// C2128748 Verify the Feature of Edit Employee
	@Test(enabled = false, priority = 11)
	public void C2128748_updateEmpEmail() throws InterruptedException {

		/*
		 * try { init(); LoginPage loginPage = new LoginPage(driver);
		 * loginPage.loginMG(); } catch (IOException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 */

		homePage.goToEmployees();
		// EmployeesPage empPageSearch = new EmployeesPage(driver);
		boolean isUpdateSuccess = empPage.editEmail();
		Assert.assertTrue(isUpdateSuccess);
		boolean oldEmailNotPresent = empPage.oldEmailChanged();
		Assert.assertTrue(oldEmailNotPresent);
	}

	// Verify the Dropdown Menu Inside the Navbar
	@Test(enabled = false, priority = 12)
	public void C2128686_verifySrchNavBar() throws InterruptedException {
		boolean srchSubMenuPagesDisp = homePage.verifySrchWithMouseHovers();
		Assert.assertTrue(srchSubMenuPagesDisp);
	}

	// Verify the Dropdown Menu Inside the Navbar
	@Test(enabled = false, priority = 13)
	public void C2128686_verifyReportsNavBar() throws InterruptedException {
		boolean reportsSubMenuPagesDisp = homePage.verifyRreportsWithmouseHover();
		Assert.assertTrue(reportsSubMenuPagesDisp);
	}

	// Verify the Dropdown Menu Inside the Navbar
	@Test(enabled = false)
	public void C2128686_verifyAlertsNavBar() throws InterruptedException {
		boolean alertsSubMenuPagesDisp = homePage.verifyAlertsWithMouseHover();
		Assert.assertTrue(alertsSubMenuPagesDisp);
	}

	// Verify the Dropdown Menu Inside the Navbar
	@Test(enabled = false)
	public void C2128686_verifySettingsNavBar() throws InterruptedException {
		boolean settingsSubMenuPagesDisp = homePage.verifySettingsWithMouseHover();
		Assert.assertTrue(settingsSubMenuPagesDisp);
	}

	// Verify the Dropdown Menu Inside the Navbar
	@Test(enabled = false)
	public void C2128686_verifyAdminNavBar() throws InterruptedException {
		boolean adminMenuPagesDisp = homePage.verifyAdminWithMouseHover();
		Assert.assertTrue(adminMenuPagesDisp);
	}

	// Verify the Links of Navbar
	@Test(enabled = false, priority = 14)
	public void C2128687_verifyNavigations() throws InterruptedException {
		boolean correctNavigations = homePage.verifyNavBarNavigations();
		Assert.assertTrue(correctNavigations);
	}

	// new code frm sagar

	// Verify Open Source Attribution Page
	@Test(enabled = false, priority = 15)
	public void C5890693_verify3PLinksinFooter() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		boolean thirdPartypPagesDisp = homePage.verifyOpenSrcLinks();
		Assert.assertTrue(thirdPartypPagesDisp);
	}

	// Verify the Pagination of Employee List
	@Test(enabled = false)
	public void C2128784_verifyEmpListPagination() throws InterruptedException {
		homePage = new HomePage(driver);
		homePage.goToEmployees();
		EmployeesPage empPage = new EmployeesPage(driver);
		boolean isPaginationIntact = empPage.verifyEmpPageNavigation();
		Assert.assertTrue(isPaginationIntact);
	}

	@DataProvider(name = "readCSVAndMapIt")
	public Object[][] readCSVAndMapIt() {

		ReadEmpFromCSV csvRead = new ReadEmpFromCSV();
		List<EmployeesGetSet> csvList = csvRead.readCSVAndMapIt("./Employees.csv");
		Object[][] obj = new Object[csvList.size()][1];

		for (int i = 0; i < csvList.size(); i++) {
			obj[i][0] = csvList.get(i);
		}

		return obj;
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
