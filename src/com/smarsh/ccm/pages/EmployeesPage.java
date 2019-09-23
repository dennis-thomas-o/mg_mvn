package com.smarsh.ccm.pages;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.swing.plaf.basic.DefaultMenuLayout;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.smarsh.ccm.generalFuncction.GeneralFunction;
import com.smarsh.ccm.testEmployees.MGUploadEmployee;
import com.smarsh.ccm.utils.DeviceGetSet;
import com.smarsh.ccm.utils.EmployeesGetSet;


import com.opencsv.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;





public class EmployeesPage extends TestBase {
	
	protected static Logger
	logger = LogManager.getLogger(EmployeesPage.class);
	protected static GeneralFunction generalFunction;	

	WebDriver driver;
	List<String> exceptedEmpCsvHeader = new ArrayList<String>();

	@FindBy(id = "MainContent_ContentTitle")
	WebElement filterSection;

	@FindBy(xpath = "//i[contains(@class,'fa-filter')]")
	WebElement filterIcon;

	@FindBy(id = "MainContent_EntForm_CancelButton")
	WebElement clearFilterBtn;

	@FindBy(id = "MainContent_EntForm_DoSearchDownload_Click")
	WebElement downloadSrchBtn;

	@FindBy(id = "MainContent_Label4")
	WebElement employeeSection;

	@FindBy(xpath = "//i[contains(@class,'fa-cog')]")
	WebElement employeeSettingsIcon;

	@FindBy(id = "MainContent_EmployeeTotal")
	WebElement empCountBar;

	@FindBy(id = "MainContent_Label1")
	WebElement heartBeatSection;

	@FindBy(xpath = "//i[contains(@class,'fa fa-heartbeat fa-2x fa-fw')]")
	WebElement hearBeatIcon;

	@FindBy(xpath = "//*[@id = 'MainContent_LinkTo_Heartbeat']//i[contains(@class,'external-link-square')]")
	WebElement hearBeatExpandIcon;

	@FindBy(id = "MainContent_Label2")
	WebElement activationsSection;

	@FindBy(xpath = "//i[contains(@class,'bolt')]")
	WebElement activationsIcon;

	@FindBy(xpath = "//*[@id = 'MainContent_LinkTo_Activation']//i[contains(@class,'external-link-square')]")
	WebElement activationsExpandIcon;

	@FindBy(id = "MainContent_Label3")
	WebElement departmentsSection;

	@FindBy(id = "MainContent_Label5")
	WebElement addNewEmpLink;

	@FindBy(xpath = "//input[@id='MainContent_EntForm_Match']")
	WebElement searchEmailTextBox;

	@FindBy(id = "MainContent_DialogTitle")
	WebElement addEmpSection;

	@FindBy(id = "MainContent_GridNow")
	WebElement searchTable;

	@FindBy(id = "MainContent_EntForm_SubmitButton")
	WebElement searchBtn;
	
	@FindBy(id = "MainContent_EntForm_SubmitButton")
	WebElement changedeviceStatusSubmitBtn;
	

	@FindBy(xpath = "//i[contains(@class,'pencil')]")
	WebElement editIcon;

	@FindBy(xpath = "(//i[contains(@class,'pencil')])[1]")
	WebElement firstEmpEditIcon;

	@FindBy(id = "MainContent_EmpForm_EmployeeID")
	WebElement idTextBox;

	@FindBy(id = "MainContent_EmpForm_DeviceAssociatedID")
	WebElement associateDevIdTextBox;

	@FindBy(id = "MainContent_EmpForm_Name")
	WebElement nameTextBox;

	@FindBy(id = "MainContent_EmpForm_Email")
	WebElement emailtextBox;

	@FindBy(id = "MainContent_EmpForm_Department")
	WebElement departmentDropdown;

	@FindBy(id = "MainContent_EmpForm_Status")
	WebElement registrationStatus;

	@FindBy(id = "MainContent_EmpForm_SubmitButton")
	WebElement updateBtn;

	@FindBy(id = "MainContent_EmpForm_CancelButton")
	WebElement cancelBtn;

	@FindBy(id = "MainContent_GridNow")
	WebElement searchResTable;

	@FindBy(xpath = "//table[@id = 'MainContent_GridNow']//tbody//tr[2]//td//p[contains(text(), 'No Results Found')]")
	WebElement emptySearchTable;

	@FindBy(id = "MainContent_EmpForm_ErrMsg")
	WebElement errorBar;

	@FindBy(xpath = "//span[@id = 'MainContent_EmpForm_ErrMsg']//p[contains(text(),'blank')]")
	WebElement errorMsg;

	@FindBy(xpath = "//span[@id = 'MainContent_EmpForm_ErrMsg']//p[contains(text(),'already')]")
	WebElement errorMsg1;

	@FindBy(xpath = "//span[@id = 'MainContent_EmpForm_ErrMsg']//p[contains(text(),'Associated Device ID.')]")
	WebElement errorMsg2;

	@FindBy(xpath = "//a[@id='MainContent_EmployeeUploadButton']")
	WebElement downloadEmployeeUploadTemplate;

	@FindBy(id = "MainContent_EntUploadForm_Filename")
	WebElement uploadEmployees_chooseFile_Btn;

	@FindBy(id = "MainContent_EntUploadForm_SubmitButton")
	WebElement employeeUploadFile_Btn;

	@FindBy(linkText = "see result")
	WebElement empCsvUploadSeeResult;

	@FindBy(xpath = "//span[contains(text(),'Failed')]")
	WebElement empCsvUploaderrormsg;

	@FindBy(xpath = "//span[contains(text(),'Employee created')]")
	WebElement empCsvCreatedSuccessfmsg;

	@FindBy(xpath = "//span[contains(text(),'Employee updated')]")
	WebElement empCsvUploadSuccessfmsg;

	@FindBy(xpath = "(//span[@class='ui-button-text' and contains(text(),'Close')])[4]")
	WebElement closeSeeReultPopUp;

	@FindBy(xpath = "//a[@title='View Employee Overview']")
	WebElement view_Emp_Overview_Icon;

	@FindBy(xpath = "//img[@src='/images/tmobile_enable.png']")
	WebElement tMobileProvision_Img;

	@FindBy(xpath = "//img[@src='/images/tmobile_disable.png']")
	WebElement tMobileDeprovision_Img;

	@FindBy(xpath = "//select[@id='MainContent_EntForm_Division']//option")
	List<WebElement> empDepartmentOption;

	@FindBy(xpath = "//select[@id='MainContent_EntForm_Status']//option")
	List<WebElement> empRegistrationStatusOption;

	@FindBy(xpath = "//select[@id='MainContent_EntForm_Type']//option")
	List<WebElement> empType;

	@FindBy(xpath = "//table[@class='body table-hover table-striped datatable']")
	WebElement eachCarrierDeviceListTable;

	@FindBy(xpath = "//input[@value='Cancel']")
	WebElement deviceCanclebtn;

	@FindBy(xpath = "//a[@title='View AT&T Devices']")
	List<WebElement> resultList;
	
	@FindBy(id="MainContent_UploadResultLinkButton")
	WebElement UploadResultDownloadNowLinkButton;
	
	@FindBy(xpath="//span[contains(text(),'Device')]//..//..//input")
	WebElement deviceID_NumberAddInptextbox;
	
	@FindBy(xpath="//input[@value='Add New']")
	WebElement addNewdeviceBtn;

	@FindBy(xpath="(//a[@title='Change Status'])[last()]")
	WebElement deviceChangeStatus;
	
	@FindBy(xpath="//select[@id='MainContent_EntForm_NewStatus']//option[contains(text(),'Provisioned')]")
	WebElement selectNewStatusAsProvision;
	
	@FindBy(xpath="//select[@id='MainContent_EntForm_NewStatus']//option[contains(text(),'PROVISIONED')]")
	WebElement selectNewStatusAsProvisionTruphone;
	
	@FindBy(xpath="//select[@id='MainContent_VzwForm_VzwSettingId']//option[contains(text(),'UNKNOWN')]")
	WebElement selectVerizonSettingUnknown;
	
	
	//new xpath from sagar

	@FindBy(id = "MainContent_DeviceList_AddNew")
	WebElement addDeviceBtn;
	
	@FindBy(id = "MainContent_EntForm_CountryCode")
	WebElement countryCodeTextBox;
	
	@FindBy(id = "MainContent_EntForm_PhoneNumber")
	WebElement phoneNumTextBox;
	
	@FindBy(id = "MainContent_EntForm_IMEI")
	WebElement imeiTextBox;
	
	@FindBy(id = "MainContent_EntForm_MEID")
	WebElement meidTextBox;
	
	@FindBy(id = "MainContent_EntForm_PIN")
	WebElement pinTextBox;
	
	@FindBy(id = "MainContent_EntForm_Manufacturer")
	WebElement manufacturerTextBox;
	
	@FindBy(id = "MainContent_EntForm_Model")
	WebElement modelTextBox;
	
	@FindBy(id = "MainContent_EntForm_Platform")
	WebElement platformTextBox;
	
	@FindBy(id = "MainContent_EntForm_PVersion")
	WebElement platformVersionTextBox;
	
	@FindBy(id = "MainContent_EntForm_TGVersion")
	WebElement appVersionTextBox;
	
	@FindBy(id = "MainContent_EntForm_FetchMessageHistory")
	WebElement getOldMsgCheckbox;
	
	@FindBy(id = "MainContent_EntForm_Token")
	WebElement tokenTextBox;
	
	@FindBy(id = "MainContent_EntForm_Active")
	WebElement activeCheckBox;
	
	@FindBy(id = "MainContent_EntForm_SubmitButton")
	WebElement deviceSubmitBtn;
	
	@FindBy(id = "MainContent_EntForm_CancelButton")
	WebElement deviceCancelBtn;	
	
	@FindBy(id = "MainContent_Panel10")
    WebElement empListSection;
   
    @FindBy(id = "MainContent_Label4")
    WebElement employeeListSectionHeader;
    
   
    @FindBy(id = "MainContent_Label1")
    WebElement heartBeatSectionHeader;

    @FindBy(id = "MainContent_Label2")
    WebElement activationsSectionHeader;
    
    
    @FindBy(id = "MainContent_Panel9")
    WebElement deptSection;
   
    @FindBy(id = "MainContent_Label3")
    WebElement departmentsSectionHeader;
   
    @FindBy(xpath = "//*[@id = 'MainContent_LinkTo_Department']//i[contains(@class,'external-link-square')]")
    WebElement deptExpandIcon;
    
    @FindBy(id = "MainContent_SectionContainer")
    WebElement dwnldEmpSection;
   
    @FindBy(id = "MainContent_DialogTitle")
    WebElement dwnldEmpSectionHeader;
   
    @FindBy(xpath = "//i[contains(@class,'fa fa-download fa-2x fa-fw')]")
    WebElement dwnldEmpIcon;
   
    @FindBy(id = "MainContent_DownloadForm_SubmitButton")
    WebElement sendviaEmailBtn;
   
    @FindBy(id = "MainContent_DownloadForm_CancelButton")
    WebElement dwnldListBtn;
    
    
    @FindBy(id = "MainContent_Panel13")
    WebElement uploadEmpSection;
   
    @FindBy(id = "MainContent_Label6")
    WebElement uploadEmpSectionHeader;
   
    @FindBy(xpath = "//i[contains(@class,'fa fa-upload fa-2x fa-fw')]")
    WebElement uploadIcon;
   
    @FindBy(xpath = "//span[contains(@class,'fa fa-info fa-stack-1x fa-inverse sampleFile')]")
    WebElement templateCSVLink;
   
    @FindBy(id = "MainContent_EntUploadForm_Filename")
    WebElement browseFileBtn;
   
    @FindBy(id = "MainContent_EntUploadForm_SubmitButton")
    WebElement empUploadBtn;
    
    @FindBy(xpath = "//tr[contains(@class,'pager')]//table//tr")
    WebElement pageNavigation;
   
    @FindBy(xpath = "//i[contains(@class,'fa fa-fast-forward')]")
    WebElement navigateToLastPageBtn;
   
    @FindBy(xpath = "//i[contains(@class,'fa fa-fast-backward')]")
    WebElement navigateToFirstPageBtn;
    
    
    @FindBy(xpath = "//a[@title='View AT&T Devices']")
    WebElement atntIcon;
   
    @FindBy(xpath = "//a[@title='View Verizon Devices']")
    WebElement verizonIcon;
   
    @FindBy(id = "MainContent_DataList_device_id_0")
    WebElement atntNumber;
   
    @FindBy(id = "MainContent_AttForm_CancelButton")
    WebElement cancelAtnTAdditionBtn;
   
    @FindBy(id = "MainContent_VzwForm_CancelButton")
    WebElement cancelVzwAdditionBtn;
    
    @FindBy(id = "MainContent_EmpInfo_SectionContainer")
    WebElement viewEmpInfoSection;
   
    @FindBy(xpath = "//span[contains(@class,'fa fa-pencil-square-o fa-2x')]")
    WebElement editEmpInfoBtn;
   
    @FindBy(id = "MainContent_EmpInfo_Label1")
    WebElement empInfoSectionHeader;
   
    @FindBy(xpath = "//i[contains(@class,'fa fa-info fa-2x fa-fw')]")
    WebElement empInfoIcon;
   
    @FindBy(id = "MainContent_Msgs_MessageContainer")
    WebElement recentMsgsSection;
   
    @FindBy(id = "MainContent_Msgs_PAHTitle")
    WebElement recentMsgsSectionHeader;
   
    @FindBy(xpath = "//a[contains(@id,'MainContent_Msgs_LinkTo')]/i")
    WebElement expandRecentMsgsSec;
   
    @FindBy(id = "MainContent_Calls_MessageContainer")
    WebElement callsSection;
   
    @FindBy(id = "MainContent_Calls_PAHTitle")
    WebElement callsSectionHeader;
   
    @FindBy(xpath = "//a[contains(@id,'MainContent_Calls_LinkTo')]/i")
    WebElement expandCallsSec;
   
    @FindBy(id = "MainContent_White_SectionContainer")
    WebElement whiteListSection;
   
    @FindBy(id = "MainContent_White_Label1")
    WebElement whiteListSectionHeader;
   
    @FindBy(xpath = "//a[contains(@id,'MainContent_White_LinkTo')]/i")
    WebElement expandWhiteListSec;
   
    @FindBy(id = "MainContent_DeviceList_SectionContainer")
    WebElement devicesSection;
   
    @FindBy(id = "MainContent_DeviceList_Label1")
    WebElement devicesSectionHeader;
   
    @FindBy(xpath = "//i[contains(@class,'fa fa-mobile fa-2x fa-fw')]")
    WebElement devicesIcon;
   
    @FindBy(id = "MainContent_EmpCont_SectionContainer")
    WebElement contactListSection;
   
    @FindBy(id = "MainContent_EmpCont_Label1")
    WebElement contactListSectionHeader;
   
    @FindBy(xpath = "//i[contains(@class,'fa fa-address-card fa-2x fa-fw')]")
    WebElement contactIcon;
   
    @FindBy(id = "MainContent_EmpNotes_SectionContainer")
    WebElement auditLogSection;
   
    @FindBy(id = "MainContent_EmpNotes_Label1")
    WebElement auditLogSectionHeader;
   
    @FindBy(xpath = "//a[contains(@id,'MainContent_EmpNotes_LinkTo')]/i")
    WebElement expandAuditLogSec;
    
    
    @FindBy(xpath = "//i[contains(@class,'fa fa-eye fa-2x fa-actionlink')]")
    WebElement viewEmpIcon;    
    
    @FindBy(id = "MainContent_EntForm_CancelButton")
    WebElement searchCancelBtn; 
    
    //added on 26th Aug

    
	//new xpath from sagaradministratorDropdown
	
	public EmployeesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//new sagar function
public boolean verifyEmpUI() {
		
		boolean empPageIntact = false;
		boolean isFilterSecIntact = false;
		if(filterSection.isDisplayed() && filterIcon.isDisplayed() && searchBtn.isEnabled() && searchCancelBtn.isEnabled() && downloadSrchBtn.isEnabled()) {
			System.out.println("Filter section is displayed properly");
			logger.info("Filter section is displayed properly");
			isFilterSecIntact = true;
		}
		
		boolean isEmpListSecIntact = false;
		if(empListSection.isDisplayed() && employeeListSectionHeader.isDisplayed() && employeeSettingsIcon.isDisplayed() 
				&& empCountBar.isDisplayed() && addNewEmpLink.isDisplayed() && employeeListSectionHeader.getText().equals("Employee List")) {
			logger.info("Employee List section is displayed correctly");
			isEmpListSecIntact = true;
		}
		
		boolean isHearBeatSecIntact = false;
		if(heartBeatSection.isDisplayed() && heartBeatSectionHeader.isDisplayed() && hearBeatIcon.isDisplayed() 
				&& hearBeatExpandIcon.isEnabled() && heartBeatSectionHeader.getText().equals("Missed Heartbeats")) {
			
			logger.info("Heartbeat section is displayed correctly");
			isHearBeatSecIntact = true;
		}
		
		boolean isActivationsSecIntact = false;
		if(activationsSection.isDisplayed() && activationsSectionHeader.isDisplayed() && activationsIcon.isDisplayed() && activationsExpandIcon.isEnabled() 
				&& activationsSectionHeader.getText().equals("Activations")) {
			logger.info("Activations section is displayed correctly");
			isActivationsSecIntact = true;
		}
		
		boolean isDeptSecIntact = false;
		if(deptSection.isDisplayed() && departmentsSectionHeader.isDisplayed() && deptExpandIcon.isEnabled() && 
				departmentsSectionHeader.getText().equals("Departments")) {
			logger.info("Department section is displayed correctly");
			isDeptSecIntact = true;
		}
		
		boolean isDwnldEmpSecIntact = false;
		if(dwnldEmpSection.isDisplayed() && dwnldEmpSectionHeader.isDisplayed() && dwnldEmpIcon.isDisplayed() 
				&& dwnldListBtn.isEnabled() && sendviaEmailBtn.isEnabled() && dwnldEmpSectionHeader.getText().equals("Download Employees")) {
			logger.info("Download Employees section is displayed correctly");
			isDwnldEmpSecIntact = true;
		}
		
		boolean isUploadEmpSecIntact = false;
		if(uploadEmpSection.isDisplayed() && uploadEmpSectionHeader.isDisplayed() && uploadIcon.isDisplayed() &&
				templateCSVLink.isEnabled() && browseFileBtn.isEnabled() && empUploadBtn.isEnabled() && uploadEmpSectionHeader.getText().equals("Upload Employees")) {
			logger.info("Upload employee section is displayed correctly");
			isUploadEmpSecIntact = true;
		}
		if(isFilterSecIntact && isEmpListSecIntact && isHearBeatSecIntact && isActivationsSecIntact && isDeptSecIntact && isDwnldEmpSecIntact && isUploadEmpSecIntact) {
			System.out.println("All sections are displayed properly on Employees page");
			logger.info("All sections are displayed properly on Employees page");
			empPageIntact = true;
		}
		return empPageIntact;
	}

public boolean verifyEmpPageNavigation() throws InterruptedException { 
	
	boolean isPaginationCorrect = false;
		String paginationString = empCountBar.getText();
		int size = paginationString.length();
		String split[] = paginationString.split(" ");
		String totalRecords = split[5];
		int numOfPages;
		System.out.println("Total records = " + totalRecords);
		int numberOfEmp = Integer.parseInt(totalRecords);
		if(numberOfEmp % 25 == 0) {
		numOfPages = numberOfEmp/25;
		} else
			numOfPages = (numberOfEmp/25)+1;
		
		if(paginationString.contains("Showing 1 to ")) {
			System.out.println("User is on first page.");
		}
		if(pageNavigation.isEnabled()) {
			driver.findElement(By.xpath("//tr[contains(@class,'pager')]//table//tr/td[2]")).click();
			Thread.sleep(2000);
			paginationString = empCountBar.getText();
			if(paginationString.contains("Showing 26 to 50 of")) {
				System.out.println("User is on second page");
			}
			if(navigateToLastPageBtn.isEnabled()) {
			navigateToLastPageBtn.click();
			Thread.sleep(2000);
			int beginingRecordOnLastPage;
			if(numberOfEmp % 25 == 0) {
		    beginingRecordOnLastPage = numberOfEmp - 24; 
			}
			else
			{
				beginingRecordOnLastPage = (numberOfEmp - (numberOfEmp % 25)) + 1;
			}
			String beginingIndexOnLastPage = Integer.toString(beginingRecordOnLastPage);
			paginationString = empCountBar.getText();
			if(paginationString.contains(beginingIndexOnLastPage) && paginationString.contains(totalRecords)) {
				System.out.println("User is on last page");
				}
			}
			if(navigateToFirstPageBtn.isEnabled()) {
			navigateToFirstPageBtn.click();
			Thread.sleep(2000);
			paginationString = empCountBar.getText();
			if(paginationString.contains("Showing 1 to 25 of")) {
				System.out.println("User is back on first page.");
				}
			}
			System.out.println("Pagination is working correctly");
			isPaginationCorrect = true;	
		}
			return isPaginationCorrect;
}

	
	
	//new sagar function

	public void clickToAddEmp() {
		Assert.assertTrue(addNewEmpLink.isDisplayed());
		addNewEmpLink.click();
		// boolean isAddEmpPageDisplayed = addEmpSection.isDisplayed();

	}

	public void searchAddedEmp(EmployeesGetSet employee) {
		String addedEmpEmails = null;
		addedEmpEmails = employee.getEmail();
		logger.info(addedEmpEmails);
		searchEmailTextBox.clear();
		searchEmailTextBox.sendKeys(addedEmpEmails);
		searchBtn.click();
	}

	//new sagar function
public boolean verifyEmpDetails(EmployeesGetSet employee) throws InterruptedException {
		
		boolean isEmpDetailsCorrect = false;
		boolean isDispDetailsCorrect = false;
		boolean noNetGuard = false;
		boolean isAtnT = false;
		boolean isVerizon = false;
		Thread.sleep(1000);
		
		try {
			
			boolean isSearchTableDisplayed = driver.findElement(By.id("MainContent_GridNow")).isDisplayed();
			Assert.assertTrue(isSearchTableDisplayed);
			
			List<WebElement> searchedEmpDetails = driver.findElements(By.xpath
					("//table[@id = 'MainContent_GridNow']//tbody//tr[2]//td"));
			

				String empID = searchedEmpDetails.get(0).getText();
				String empName = searchedEmpDetails.get(1).getText();
				String empEmail = searchedEmpDetails.get(2).getText();
				String dept = searchedEmpDetails.get(3).getText().trim();
				String status = searchedEmpDetails.get(4).getText().trim();
				String lastPing = searchedEmpDetails.get(5).getText();
				String createdTime = searchedEmpDetails.get(6).getText();
				long crTime = getLongFromUTC(createdTime);
				
				logger.info("Created time is "+ crTime);
				logger.info("System time is " + System.currentTimeMillis());
				logger.info("emp id " + employee.getId());
				logger.info("emp name" + employee.getName());
				logger.info("emp email" + employee.getEmail());
				logger.info("department" + employee.getDepartment());
				logger.info("Status" + employee.getRegStatus());
				
				
				if(crTime < System.currentTimeMillis() && empID.equals(employee.getId()) && empName.equals(employee.getName())
						&& empEmail.equals(employee.getEmail()) && dept.equals(employee.getDepartment()) && status.equals(employee.getRegStatus())) {	
					isDispDetailsCorrect = true;
					logger.info("Emp details are : " + " "+ empID + " "+  empName + " "+  empEmail+ " "+  
							dept+ " "+  status+ " "+  lastPing+ " "+  createdTime);
					
					
/*					Assert.assertEquals(empID, employee.getId());
					Assert.assertEquals(empName, employee.getName());
					Assert.assertEquals(empEmail, employee.getEmail());
					Assert.assertEquals(dept, employee.getDepartment());
					Assert.assertEquals(status, employee.getRegStatus());*/
				}
				if(employee.getNetGuardDev().equals("No")) {
					logger.info("No netguard device associated");
					noNetGuard = true;
				}
				else if(employee.getNetGuardDev().equalsIgnoreCase("AT&T"))
				{
					atntIcon.click();
					Thread.sleep(1000);
					if(atntNumber.getText().substring(1).equals(employee.getAssDevID())) {
						logger.info("Correct ATnT number added");
						isAtnT = true;
						cancelAtnTAdditionBtn.click();
						Thread.sleep(2000);
					}
				}
				
				else if(employee.getNetGuardDev().equalsIgnoreCase("Verizon")) {
					verizonIcon.click();
					Thread.sleep(1000);
					if(driver.getPageSource().contains(employee.getAssDevID())) {
						logger.info("Correct Verizon number");
						isVerizon = true;
						cancelVzwAdditionBtn.click();
						Thread.sleep(2000);
					}
				}				
		}
		catch(Exception e){
			e.printStackTrace();
		}
		if(isDispDetailsCorrect && (noNetGuard || isAtnT || isVerizon)) {
			System.out.println("All employee details are correct");
			logger.info("All employee details are correct");
			isEmpDetailsCorrect = true;
		}
		return isEmpDetailsCorrect;
	}
	//new sagar function
	public boolean verifyEmpPage() {
		return driver.getTitle().contains("Employees");
	}

	public boolean editEmp() throws InterruptedException {
		searchEmailTextBox.clear();
		searchEmailTextBox.sendKeys("addemp74@smarsh.com");
		searchBtn.click();
		Thread.sleep(1000);
		editIcon.click();

		Thread.sleep(1000);
		String empidEdited = "74" + System.currentTimeMillis();
		String devIdEdited = "74" + System.currentTimeMillis();
		String nameEdited = "AddEmp" + System.currentTimeMillis();
		idTextBox.clear();
		idTextBox.sendKeys(empidEdited);
		logger.info("edited ID = " + empidEdited);
		associateDevIdTextBox.clear();
		associateDevIdTextBox.sendKeys(devIdEdited);
		nameTextBox.clear();
		nameTextBox.sendKeys(nameEdited);
		logger.info("edited name = " + nameEdited);
		Select dept = new Select(departmentDropdown);
		dept.selectByVisibleText("HR");
		Select regStatus = new Select(registrationStatus);
		regStatus.selectByVisibleText("Registered");
		updateBtn.click();
		Thread.sleep(1000);
		empPage.searchEmailTextBox.clear();
		empPage.searchEmailTextBox.sendKeys("addemp74@smarsh.com");
		empPage.searchBtn.click();

		boolean empUpdated = false;

		Thread.sleep(1000);

		try {

			boolean isSearchTableDisplayed = searchResTable.isDisplayed();
			Assert.assertTrue(isSearchTableDisplayed);

			List<WebElement> searchedEmpDetails = driver
					.findElements(By.xpath("//table[@id = 'MainContent_GridNow']//tbody//tr[2]//td"));

			// for (WebElement webElement : searchedEmpDetails) {
			// List<WebElement> tdData = webElement.findElements(By.tagName("td"));
			for (WebElement webElement : searchedEmpDetails) {

				logger.info(webElement.getText());

			}
			String empID = searchedEmpDetails.get(0).getText();
			String empName = searchedEmpDetails.get(1).getText();
			String empDept = searchedEmpDetails.get(3).getText();
			String empStatus = searchedEmpDetails.get(4).getText();
			if (!empID.equals(empidEdited)) {
				System.out.println("ID has not been updated");
			}
			if (!empName.equals(nameEdited)) {
				System.out.println("Name has not been updated");
			}
			if (!empDept.trim().equals("HR")) {
				System.out.println("Department has not been updated");
				System.out.println("Expected value = HR");
				System.out.println("Observed value = " + empDept);
			}
			if (!empStatus.trim().equals("Registered")) {
				System.out.println("Employee status has not been updated");
				System.out.println("Expected value = Registered");
				System.out.println("Observed value = " + empStatus);

			}
			if (empID.equals(empidEdited) && empName.equals(nameEdited) && empDept.trim().equals("HR")
					&& empStatus.trim().equals("Registered"))
				empUpdated = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return empUpdated;
	}

	public boolean editEmail() throws InterruptedException {

		boolean emailUpdated = false;
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		searchEmailTextBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_EntForm_Match")));
		searchEmailTextBox.clear();
		searchEmailTextBox.sendKeys("addemp74@smarsh.com");
		searchBtn.click();
		Thread.sleep(1000);
		editIcon.click();
		Thread.sleep(1000);
		String editedEmail = "addemp74" + System.currentTimeMillis() + "@smarsh.com";
		System.out.println("Edited email = " + editedEmail);
		emailtextBox.clear();
		emailtextBox.sendKeys(editedEmail);
		updateBtn.click();
		Thread.sleep(2000);
		searchEmailTextBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_EntForm_Match")));
		//homePage.goToEmployees();
		//empPage.searchEmailTextBox.click();
		searchEmailTextBox.clear();
		searchEmailTextBox.sendKeys(editedEmail);
		searchBtn.click();

		Thread.sleep(1000);

		try {

			boolean isSearchTableDisplayed = searchResTable.isDisplayed();
			Assert.assertTrue(isSearchTableDisplayed);

			List<WebElement> searchedEmpDetails1 = driver
					.findElements(By.xpath("//table[@id = 'MainContent_GridNow']//tbody//tr[2]//td"));

			for (WebElement webElement : searchedEmpDetails1) {

				System.out.println(webElement.getText());

			}

			String updatedEmail = searchedEmpDetails1.get(2).getText();

			if (updatedEmail.trim().equalsIgnoreCase(editedEmail)) {
				emailUpdated = true;
				System.out.println("Email has been updated successfully");
			} else
				System.out.println("Email has not been updated");
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return emailUpdated;
	}

	public boolean oldEmailChanged() {

		boolean oldEmailRemoved = false;
		WebDriverWait wait = new WebDriverWait(driver, 60);
		searchEmailTextBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_EntForm_Match")));
		searchEmailTextBox.clear();
		searchEmailTextBox.sendKeys("addemp74@smarsh.com");
		searchBtn.click();

		if (emptySearchTable.isDisplayed()) {
			oldEmailRemoved = true;
		}

		return oldEmailRemoved;
	}

	public boolean editEmpWithEmptyEmail() throws InterruptedException {
		boolean editFail = false;
		WebDriverWait wait = new WebDriverWait(driver, 60);
		searchEmailTextBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_EntForm_Match")));
		searchEmailTextBox.clear();
		searchEmailTextBox.sendKeys(System.getProperty("username"));
		searchBtn.click();
		Thread.sleep(1000);
		editIcon.click();
		Thread.sleep(1000);
		emailtextBox.clear();
		updateBtn.click();

		if (errorBar.isDisplayed()) {
			String errorText = errorMsg.getText();
			System.out.println(errorText);
			if (errorText.equals("Employee email address cannot be blank.")) {
				System.out.println("Correct error message displayed when editing an employee with empty emailId");
				editFail = true;
			} else {
				System.out.println("Correct error message not displayed when editing an employee with empty emailId");
			}
		} else {
			System.out.println("No error bar displayed");
		}
		return editFail;
	}

	


	
	 public static long getLongFromUTC(String dateTimeUTC) {
		 long timeInlong = 0 ;
         try {
		 if(null == dateTimeUTC || 0 == dateTimeUTC.length()) {
             return System.currentTimeMillis();
         }
         //12 Hr Format - yyyy-MM-dd'T'hh:mm:ss.SSS 6/6/2019 10:45 AM
         DateFormat dfm = new SimpleDateFormat("MM/dd/yyyy HH:mm a");
         Date date = dfm.parse(dateTimeUTC);
         if(date != null){
             timeInlong = date.getTime();
         }
         }
         catch(Exception e) {
        	 logger.info(e);
         }
         return timeInlong;
     }
	
	//new function sagar

	
	// click on DownloadIcon
	public void clickonDownloadEmployeeSampleCSV() {
		downloadEmployeeUploadTemplate.click();
	}

	// vaildating the downloaded CSV Header
	public String vaildateDownloadedCsvHeader(File downloadDir) {
		String[] files = downloadDir.list();
		String downloadedCsvHeaders = "";
		System.out.println("Downloaded Filename:" + files[0]);
		/*
		 * for (String file : files) { System.out.println(file); }
		 */
		FileReader filereader;
		try {
			filereader = new FileReader(
					System.getProperty("user.dir") + File.separator + "Downloads" + File.separator + files[0]);
			CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord;
			// List<String> downloadedCsvHeaders = new ArrayList<String>();

			while ((nextRecord = csvReader.readNext()) != null) {
				for (String cell : nextRecord) {
					// System.out.print(cell + "\t");
					downloadedCsvHeaders += cell + ",";
				}
			}
			downloadedCsvHeaders = downloadedCsvHeaders.substring(0, downloadedCsvHeaders.lastIndexOf(","));

			System.out.println(downloadedCsvHeaders);
			return downloadedCsvHeaders;
			// Assert.assertEquals(downloadedCsvHeaders, emp);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return downloadedCsvHeaders;
	}

	// Write the CSV with all carrier number
	public List<String> csvWriteAllcarriersDetails(String uploadFilePath, String HMS) {
		// System.out.println(exceptedEmpCsvHeader);
		// String UploadFilePath = uploadDir + File.separator + "csvupload.csv";
		List<String> Empdeatils = new ArrayList();

		FileWriter outputfile;
		try {
			outputfile = new FileWriter(uploadFilePath);
			outputfile.append(getObject("EmpCsvHeader"));
			Empdeatils.add("");
			Empdeatils.add("");
			Empdeatils.add("automation" + HMS + "@gmail.com");
			Empdeatils.add("name" + HMS);
			Empdeatils.add("3");
			Empdeatils.add("1" + HMS);
			Empdeatils.add("12" + HMS);
			Empdeatils.add("13" + HMS);
			Empdeatils.add("14" + HMS);
			Empdeatils.add("15" + HMS);
			Empdeatils.add("16" + HMS);
			Empdeatils.add("17" + HMS);
			Empdeatils.add("18" + HMS);
			Empdeatils.add("19" + HMS);
			outputfile.append("\n");

			for (String Data1 : Empdeatils) {
				outputfile.append(Data1);
				outputfile.append(',');
			}

			outputfile.flush();
			outputfile.close();

		} catch (IOException e) {

			e.printStackTrace();
		}
		return Empdeatils;

	}

	// Update the CSV with TMO carrier number
	public List<String> csvWriteTMOcarriersDetails(String uploadFilePath, String HMS) {
		List<String> Empdeatils = new ArrayList();

		FileWriter outputfile;
		try {
			outputfile = new FileWriter(uploadFilePath);
			outputfile.append(getObject("EmpCsvHeader"));
			Empdeatils.add("");
			Empdeatils.add("");
			Empdeatils.add("automation" + HMS + "@gmail.com");
			Empdeatils.add("name" + HMS);
			Empdeatils.add("3");
			Empdeatils.add("1" + HMS);
			Empdeatils.add("");
			Empdeatils.add("");
			Empdeatils.add("");
			Empdeatils.add("");
			Empdeatils.add("");
			Empdeatils.add("");
			Empdeatils.add("");
			Empdeatils.add("20" + HMS);

			outputfile.append("\n");

			for (String Data1 : Empdeatils) {
				outputfile.append(Data1);
				outputfile.append(',');
			}

			outputfile.flush();
			outputfile.close();

		} catch (IOException e) {

			e.printStackTrace();
		}
		return Empdeatils;

	}

	public List<String> csvWriteWrongDetails(String uploadFilePath, String HMS) {
		List<String> Empdeatils = new ArrayList();

		FileWriter outputfile;
		try {
			outputfile = new FileWriter(uploadFilePath);
			outputfile.append(getObject("EmpCsvHeader"));
			Empdeatils.add("");
			Empdeatils.add("");
			outputfile.append("\n");
			for (String Data1 : Empdeatils) {
				outputfile.append(Data1);
				outputfile.append(',');
			}

			outputfile.flush();
			outputfile.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

		return Empdeatils;

	}

	public void chooseEmployeeCSV_UploadFile(String uploadFile) {
		File file = new File(uploadFile);
		uploadEmployees_chooseFile_Btn.sendKeys(file.getAbsolutePath());
		employeeUploadFile_Btn.click();

	}

	public boolean validateMsgDisplayed(String empCSVUploadedtype) {
		boolean MsgDisplayed=false;
		empCsvUploadSeeResult.click();
		try {
		if (empCSVUploadedtype.equalsIgnoreCase("Update")) {

			MsgDisplayed=empCsvUploadSuccessfmsg.isDisplayed();
			

		}
		else if (empCSVUploadedtype.equalsIgnoreCase("Failed")) {

			MsgDisplayed=empCsvUploaderrormsg.isDisplayed();
			
		}
		else if (empCSVUploadedtype.equalsIgnoreCase("Created")) {

			MsgDisplayed=empCsvCreatedSuccessfmsg.isDisplayed();
			
		}
		else {
			System.out.println("Employee CSVUpload type is different than Update/Fail/Created");
		}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		closeSeeReultPopUp.click();
		return MsgDisplayed;
	}

	public void search_EmailAddressContains(String employeeEmailID) {
		searchEmailTextBox.sendKeys(employeeEmailID);
		searchBtn.click();

	}
	
	public void click_ViewEmpOverviewIcon() {
		view_Emp_Overview_Icon.click();
	}

	public void verifyCancleBtnEditEmp() {
		firstEmpEditIcon.click();
		emailtextBox.clear();
		emailtextBox.sendKeys("Edit_Cancle@gmail.com");
		cancelBtn.click();
		System.out.println("Navigating back to Employee page after clickin on Cancle Button");

	}

	// Get existing Associated Device ID and EmailID
	public List<String> getEmpIdEmail() {
		List<String> EmpIdEmail = new ArrayList();
		int i;
		try {
			for (i = 1; i < 5; i++) {
				// List<WebElement> elements=driver.findElements(By.xpath("(//*[@title=\"Edit
				// Employee Details\"])["+ i+ "]")).click;
				driver.findElement(By.xpath(" (//*[@title=\"Edit Employee Details\"])[" + i + "]")).click();
				System.out.println("click on " + i + " emp edit icon ");

				Thread.sleep(1000);

				if (associateDevIdTextBox.getAttribute("value").trim().isEmpty()
						|| associateDevIdTextBox.getAttribute("value") == null) {
					System.out.println("Associated Device ID is empty");

				} else {
					EmpIdEmail.add(associateDevIdTextBox.getAttribute("value"));
					EmpIdEmail.add(emailtextBox.getAttribute("value"));
					homePage.goToEmployees();
					break;
				}

				homePage.goToEmployees();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return EmpIdEmail;

	}

	// Create a new employee and try to enter Duplicate Associated Device ID
	public boolean createNewEmpDupAssociatedID(List<String> EmpIdEmail) {
		boolean notCreated = false;
		try {
		clickToAddEmp();
		associateDevIdTextBox.sendKeys(EmpIdEmail.get(0));
		emailtextBox.sendKeys("1qaw212easd32@gmail.com");
		updateBtn.click();
		if (errorBar.isDisplayed()) {
			String errorText2 = errorMsg2.getText();

			if (errorText2.equalsIgnoreCase("An employee (" + EmpIdEmail.get(1) + ") already exists with "
					+ EmpIdEmail.get(0) + " for the Associated Device ID.")) {
				System.out.println("Correct error message displayed when creating a employee with duplicate deviceId");
				notCreated = true;
			} else {
				System.out.println(
						"Correct error message not displayed when editing an employee with duplicate deviceId");
			}
		} else {
			System.out.println("No error bar displayed");
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return notCreated;
	}

	public boolean verifyAllEmpfilter() throws InterruptedException {
		boolean allEmpFilter = false;
		allEmpFilter = verifyAllDepartmentSearch();
		clearFilterBtn.click();
		allEmpFilter = verifyAllRegistrationStatusSearch();
		clearFilterBtn.click();
		allEmpFilter = verifyAllType();
		clearFilterBtn.click();

		return allEmpFilter;
	}

	public boolean verifyAllDepartmentSearch() throws InterruptedException {
		boolean allDepartment = false;
		try {
		List<String> Department = new ArrayList();

		for (WebElement department : empDepartmentOption) {
			Thread.sleep(1000);
			Department.add(department.getText());

		}
		System.out.println(Department);
		for (String depname : Department) {
			driver.findElement(By.xpath(
					"//select[@id='MainContent_EntForm_Division']//option[contains(text(),'" + depname.trim() + "')]"))
					.click();

			if (depname.equalsIgnoreCase("All")) {
				System.out.println("Ignore All filter");
			} else {
				searchBtn.click();
				Thread.sleep(1000);
				List<WebElement> resultList = driver
						.findElements(By.xpath("//span[contains(@id,'MainContent_GridNow_ShowDep')]//a"));
				if (resultList.size() > 0) {
					System.out.println("**** Department : " + depname + ", Result Size : " + resultList.size());
					for (WebElement webElement : resultList) {
						Assert.assertEquals(webElement.getText(), depname);
						allDepartment = true;
					}
				} else {
					System.out.println("No record Found for Department :" + depname);
				}
			}

		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return allDepartment;

	}

	public boolean verifyAllRegistrationStatusSearch() throws InterruptedException {
		boolean allStatus = false;
		try {
		List<String> registrationstatus = new ArrayList();

		for (WebElement allstatus : empRegistrationStatusOption) {
			Thread.sleep(1000);
			registrationstatus.add(allstatus.getText());

		}
		System.out.println(registrationstatus);
		for (String status : registrationstatus) {
			driver.findElement(By.xpath(
					"//select[@id='MainContent_EntForm_Status']//option[contains(text(),'" + status.trim() + "')]"))
					.click();

			if (status.equalsIgnoreCase("All")) {
				System.out.println("Ignore All filter");
			} else {
				searchBtn.click();
				Thread.sleep(1000);
				List<WebElement> resultList = driver
						.findElements(By.xpath("//span[contains(@id,'MainContent_GridNow_ShowStatus')]"));
				if (resultList.size() > 0) {
					System.out.println("**** Registrationstatus : " + status + ", Result Size : " + resultList.size());
					for (WebElement webElement : resultList) {
						Assert.assertEquals(webElement.getText(), status);
						allStatus = true;
					}
				} else {
					System.out.println("No record Found for Registrationstatus :" + status);
				}
			}

		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return allStatus;

	}

	public boolean verifyAllType() throws InterruptedException {
		boolean allTypes = false;
		int i;
		try {
		List<String> types = new ArrayList();

		for (WebElement type : empType) {
			Thread.sleep(1000);
			types.add(type.getText());

		}
		System.out.println(types);
		for (String carriertype : types) {
			driver.findElement(By.xpath(
					"//select[@id='MainContent_EntForm_Type']//option[contains(text(),'" + carriertype.trim() + "')]"))
					.click();

			if (carriertype.equalsIgnoreCase("All") || carriertype.equalsIgnoreCase("No Carrier Assigned")
					|| carriertype.equalsIgnoreCase("Camera Only")) {
				System.out.println("Ignore All and No Carrier filter");
			}
			/*
			 * else if(carriertype.equalsIgnoreCase("AT&T")||carriertype.equalsIgnoreCase(
			 * "Hutchison")||carriertype.equalsIgnoreCase("Rogers")||carriertype.
			 * equalsIgnoreCase("T-Mobile")|| carriertype.equalsIgnoreCase("Truphone")||
			 * carriertype.equalsIgnoreCase("US Cellular")||
			 * carriertype.equalsIgnoreCase("Verizon")||carriertype.
			 * equalsIgnoreCase("Vodafone UK") ){
			 */
			else {
				searchBtn.click();
				Thread.sleep(1000);
				List<WebElement> resultList = driver
						.findElements(By.xpath("//a[@title='View " + carriertype + " Devices']"));
				// at_tIconList.size()
				if (resultList.size() > 0) {
					System.out.println("**** Carriertype : " + carriertype + ", Result Size : " + resultList.size());
					// System.out.println(resultList);
					// for (WebElement webElement : resultList) {
					for (i = 1; i <= resultList.size(); i++) {
						// System.out.println(driver.getTitle());

						if (i ==1 || i==2 || i==resultList.size() ) {

							Thread.sleep(1000);
							if (carriertype.contentEquals("Vodafone UK")) {
								carriertype = "Vodafone";
							}
							driver.findElement(By.xpath("(//a[@title='View " + carriertype + " Devices'])[" + i + "]"))
									.click();
							// Assert.assertEquals(webElement.getText(), typename);
		 					// webElement.click();
							allTypes = eachCarrierDeviceListTable.isDisplayed();
							deviceCanclebtn.click();
							Thread.sleep(1000);
						}
					}
				} /*
					 * else { System.out.println("No record Found for Type :"+carriertype); }
					 */
			}

		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return allTypes;

	}
	
	public String validateDownloadNowCsv( File downloadFilePath ) {
		UploadResultDownloadNowLinkButton.click();
		String[] files = downloadFilePath.list();
		String downloadedCsvData = "";
		System.out.println("Downloaded Filename:" + files[0]);
		/*
		 * for (String file : files) { System.out.println(file); }
		 */
		FileReader filereader;
		try {
			filereader = new FileReader(
					System.getProperty("user.dir") + File.separator + "Downloads" + File.separator + files[0]);
			CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord;
		

			while ((nextRecord = csvReader.readNext()) != null) {
				for (String cell : nextRecord) {
					downloadedCsvData += cell + ",";
				}
			}
			downloadedCsvData = downloadedCsvData.substring(0, downloadedCsvData.lastIndexOf(","));

			System.out.println(downloadedCsvData);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return downloadedCsvData.toLowerCase();
	}

	//Provision all the carrier by generating unique number
	public String provisionCarrier(String Carriername) {
		String Statusofnewaddednumber="";
		String Number="";
		
		try {
		driver.findElement(By.xpath("(//a[@title='View " + Carriername + " Devices'])[1]")).click();
		Number=getDeviceNumber();
		
		if(Carriername=="Verizon") {
			selectVerizonSettingUnknown.click();
		}
		else {
			logger.info("Verizon Setting Not required because carrier are other than Verizon");
		}
		deviceID_NumberAddInptextbox.sendKeys(Number);
		
		
		addNewdeviceBtn.click();
		logger.info("Click on Add new device for "+ Carriername +" ,thenumber added is"+Number);
		Thread.sleep(5000);
		deviceChangeStatus.click();
		if(Carriername=="Truphone"||Carriername=="Verizon") {
			selectNewStatusAsProvisionTruphone.click();
			
		}else {
			selectNewStatusAsProvision.click();
		}
		changedeviceStatusSubmitBtn.click();
		Statusofnewaddednumber=deviceChangeStatus.getText();
		homePage.goToEmployees();
		
		}
		catch(Exception e) {
			logger.info("Exception"+e);
			//protected static GeneralFunction generalFunction;
			//generalFunction=new GeneralFunction(driver);
			//generalFunctions.takeScreenShot(driver);
		}
		
		return Statusofnewaddednumber.trim().toLowerCase();
			
	}
	
	//validate All the carrier Icon is Enable after provision  
	public boolean vaildateProvisionIconEnable(String Carriername) {
		
		boolean provisionIconEnabled =false;
		try {
		String carrierIconEnabledImg=driver.findElement(By.xpath("(//a[@title='View " + Carriername + " Devices']//img)[1]")).getAttribute("src");
		if(Carriername=="Hutchison") {
			Carriername="ht";
		}
		if(Carriername=="T-Mobile") {
			Carriername="TMobile";
		}if(Carriername=="US Cellular") {
			Carriername="us_cellular";
		}
		if(Carriername=="Verizon") {
			Carriername="vzw";
		}
		if(Carriername=="Vodafone") {
			Carriername="voda";
		}
		 
		provisionIconEnabled=carrierIconEnabledImg.contains("/images/"+Carriername.toLowerCase()+"_enable.png");
		
		}
		catch(Exception e) {
			logger.info("Exception"+e);
		}
		return provisionIconEnabled;
	}
	
	
	//Generate Device number
	public String getDeviceNumber() {
		String devicenumber=" ";
		 Date currentdate = new Date();
		 DateFormat HrMinSec = new SimpleDateFormat("yyMMddmmss");
		 devicenumber = HrMinSec.format(currentdate);
        return devicenumber;
    }
	
	public void getFirstEmpDetailsAcc_Carrier(String Carriername) {
		driver.findElement(By.xpath("//select[@id='MainContent_EntForm_Type']//option[contains(text(),'" + Carriername.trim() + "')]")).click();
		searchBtn.click();
		driver.findElement(By.xpath("(//a[@title='View " + Carriername + " Devices']//img)[1]")).click();;
		
	}
}
