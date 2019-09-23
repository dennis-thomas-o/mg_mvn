package com.smarsh.ccm.pages;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.smarsh.ccm.utils.DBVerifications;
import com.smarsh.ccm.utils.DeviceGetSet;

import com.opencsv.*;

public class EmployeeViewPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'AT&T')]//..//td[1]")
	WebElement attPhoneNumber;
	
	@FindBy(xpath="//td[contains(text(),'Verizon')]//..//td[1]")
	WebElement verizonPhoneNumber;
	
	@FindBy(xpath="//td[contains(text(),'USCC')]//..//td[1]")
	WebElement uscellularPhoneNumber;
	
	@FindBy(xpath="//td[contains(text(),'Rogers')]//..//td[1]")
	WebElement rogersPhoneNumber;
	
	@FindBy(xpath="//td[contains(text(),'Vodafone')]//..//td[1]")
	WebElement vodafonePhoneNumber;
	
	@FindBy(xpath="//td[contains(text(),'Hutch')]//..//td[1]")
	WebElement hutchPhoneNumber;
	
	@FindBy(xpath="//td[contains(text(),'T-Mobile')]//..//td[1]")
	WebElement tmobilePhoneNumber;
	
	@FindBy(xpath = "//td[contains(text(),'T-Mobile')]//..//td")
	List<WebElement> tmobilePhoneNumber1;
	
	@FindBy(xpath="//td[contains(text(),'Truphone')]//..//td[1]")
	WebElement truphonePhoneNumber;
	
	//Added from Employeepages.java
    @FindBy(xpath = "//div[contains(@id,'MainContent_DeviceList_SectionContent')]//span[contains(@class,'noDataMsg')]")
    WebElement noDevDataMsg;
    
    @FindBy(xpath = "(//a[@title='Delete Device'])[1]")
    WebElement devDeleteIcon;
    
    @FindBy(id = "MainContent_EntForm_SubmitButton")
    WebElement confirmDeleteDevButton;
    
    @FindBy(xpath = "(//a[@title='Edit Device'])[1]")
    WebElement devEditIcon;
    
    @FindBy(id = "MainContent_EntForm_ErrMsg")
    WebElement devAddErrorMsg;
    
    @FindBy(id = "MainContent_EntForm_CancelButton")
    WebElement devCancelbtn;
    
    @FindBy(id = "MainContent_White_DataList_EmptyData")
    WebElement noWhitelIstDataMsg;
    
    @FindBy(xpath = "//a[contains(@title,'Delete White List')]")
    WebElement deleteWhitelistIcon;
    
    @FindBy(id = "MainContent_EntForm_SubmitButton")
    WebElement confirmDeleteWhitelistButton;
    
    @FindBy(id = "MainContent_SectionContainer")
    WebElement addWhitelistSection;
    
    @FindBy(id = "MainContent_Panel10")
    WebElement whiteListItemsSection;
    
    @FindBy(id = "MainContent_WListForm_WListItemReason")
    WebElement reasonDropdown;
    
    @FindBy(id = "MainContent_WListForm_WListItemText")
    WebElement waitlistItemTextBox;
    
    @FindBy(id = "MainContent_WListForm_SubmitButton")
    WebElement submitWhitelistItem;
    
    @FindBy(id = "MainContent_WListForm_CancelButton")
    WebElement cancelWhitelistItem;
    
    @FindBy(xpath = "//span[@id='MainContent_EmpNotes_lblManage']//a")
    WebElement viewAuditLogLink;
    
    @FindBy(id = "MainContent_EmployeeNotePanel")
    WebElement empAuditLogSection;
    
    @FindBy(id = "MainContent_GridNow")
    WebElement logGrid;
    
    @FindBy(id = "MainContent_FilterForm_TimeFrame-selector")
    WebElement timeFrameDropdown;
    
    @FindBy(id = "MainContent_FilterForm_Comment")
    WebElement containsTextBox;
    
    @FindBy(id = "MainContent_FilterForm_User")
    WebElement administratorDropdown;
    
    @FindBy(id = "MainContent_FilterForm_SubmitButton")
    WebElement searchLogButton;
    
    @FindBy(id = "MainContent_FilterForm_CancelButton")
    WebElement clearLogFilter;
    
    @FindBy(id = "MainContent_FilterForm_DoSearchDownload_Click")
    WebElement downloadLogSearch;
    
    @FindBy(xpath = "//tr[contains(@class,'pager')]//table//tr/td[2]")
    WebElement secondPageLink;
    
    @FindBy(xpath = "//tr[contains(@class,'pager')]//table//tr//td[last()]")
    WebElement lastPageLink;
    
    //...................
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
	
    @FindBy(id = "MainContent_EntForm_SubmitButton")
	WebElement searchBtn;
    
	@FindBy(xpath = "//input[@id='MainContent_EntForm_Match']")
	WebElement searchEmailTextBox;
	
	@FindBy(id = "MainContent_EntForm_EmployeePhoneMatch")
	WebElement srchPhoneNumberTextBox;
	
	@FindBy(xpath = "//table[@id='MainContent_EmpCont_DataPoint']//td[contains(@class,'value')]")
	WebElement contactsCount;
	
	@FindBy(xpath = "//span[@id='MainContent_EmpCont_DataList_Actions_0']//span[@class='colorDelete fa-badge fa-badge-bottom-times']")
	WebElement deleteContactbtn;
	
	@FindBy(id = "MainContent_EntForm_SubmitButton")
	WebElement confirmContactDeleteBtn;
	
	@FindBy(id = "MainContent_EntForm_CancelButton")
	WebElement cancelContactDeleteBtn;
	
	@FindBy(xpath = "//td[text()='Total messages']//following-sibling::td")
	WebElement numOfTotalMsgsText;
	
	@FindBy(xpath = "//td[text()='Messages this month']//following-sibling::td")
	WebElement numOfMsgsInThisMonth;
	
	@FindBy(xpath = "//td[text()='Messages today']//following-sibling::td")
	WebElement numOfMsgsToday;
	
	@FindBy(xpath = "//td[text()='Messages in the last hour']//following-sibling::td")
	WebElement numOfMsgsInThisHour;
	
	public boolean vaidateAllCarrierPhoneNumber(List<String> empdeatils) {
		boolean allNumberPresent=false;
		empdeatils.get(0);
		
		if(("+"+empdeatils.get(6)).equals(attPhoneNumber.getText()) &&  (("+"+empdeatils.get(7)).equals(verizonPhoneNumber.getText())) && 
				(("+"+empdeatils.get(8)).equals(uscellularPhoneNumber.getText()))) {
		
		}
		Assert.assertEquals("+"+empdeatils.get(7),verizonPhoneNumber.getText());
		Assert.assertEquals("+"+empdeatils.get(8),uscellularPhoneNumber.getText());
		Assert.assertEquals("+"+empdeatils.get(9),rogersPhoneNumber.getText());
		Assert.assertEquals("+"+empdeatils.get(10),vodafonePhoneNumber.getText());
		Assert.assertEquals("+"+empdeatils.get(11),hutchPhoneNumber.getText());
		Assert.assertEquals("+"+empdeatils.get(12),truphonePhoneNumber.getText());
		Assert.assertEquals("+"+empdeatils.get(13),tmobilePhoneNumber.getText());
		
		
		if(  (("+"+empdeatils.get(6)).equals(attPhoneNumber.getText())) &&  (("+"+empdeatils.get(7)).equals(verizonPhoneNumber.getText())) && 
				(("+"+empdeatils.get(8)).equals(uscellularPhoneNumber.getText())) && (("+"+empdeatils.get(10)).equals (vodafonePhoneNumber.getText()))  && (("+"+empdeatils.get(11)).equals(hutchPhoneNumber.getText())) &&  (("+"+empdeatils.get(12)).equals(truphonePhoneNumber.getText())) && (("+"+empdeatils.get(13)).equals(tmobilePhoneNumber.getText())) ) {
			System.out.println("All the Carrier Phone Number are Populated corretly in MobileGuard UI");
			allNumberPresent=true;
		}
		else {
			System.out.println("Few of the Carrier Phone Number are Not Populated corretly in MobileGuard UI");
		}
		return allNumberPresent;
	
	}
	
	
	public boolean vaidateTMOCarrierPhoneNumber(List<String>empdeatils ) {
		boolean tmoNumber=false;
		Assert.assertTrue(driver.getPageSource().contains("+"+empdeatils.get(13)));
		tmoNumber =driver.getPageSource().contains("+"+empdeatils.get(13));
		return tmoNumber;
	}
	

	
	public EmployeeViewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Code moved from EmployeePages.java
	//new funtion sagar
	public boolean verifyViewEmpPageUI() throws InterruptedException {
		
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		searchEmailTextBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_EntForm_Match")));
		searchEmailTextBox.sendKeys(System.getProperty("username"));
		searchBtn.click();
		Thread.sleep(1000);
		viewEmpIcon.click();
		
		boolean isViewEmpPageIntact = false;
		boolean isEmpInfoSecIntact = false;
		boolean isRecentMsgsSecIntact = false;
		boolean isCallsSecIntact = false;
		boolean isWhiteListSecIntact = false;
		boolean isDevicesSecIntact = false;
		boolean isAuditLogSecIntact = false;
		boolean isContactSecIntact = false;
		if(viewEmpInfoSection.isDisplayed() && editEmpInfoBtn.isEnabled() && empInfoSectionHeader.isDisplayed() &&
				empInfoIcon.isDisplayed() && empInfoSectionHeader.getText().equals("Employee Information")) {
			System.out.println("Employee Info section is displayed properly");
			isEmpInfoSecIntact = true;
		}
		if(recentMsgsSection.isDisplayed() && recentMsgsSectionHeader.isDisplayed() && expandRecentMsgsSec.isEnabled()
				&& recentMsgsSectionHeader.getText().equals("Recent Messages")) {
			logger.info("Recent Messages section is displayed properly");
			isRecentMsgsSecIntact = true;
		}
		if(callsSection.isDisplayed() && callsSectionHeader.isDisplayed() && expandCallsSec.isEnabled()
				&& callsSectionHeader.getText().equals("Voice Calls")) {
			logger.info("Calls Section is displayed properly");
			isCallsSecIntact = true;
		}
		if(whiteListSection.isDisplayed() && whiteListSectionHeader.isDisplayed() && expandWhiteListSec.isEnabled() &&
				whiteListSectionHeader.getText().equals("White List")) {
			logger.info("White List section is displayed properly");
			isWhiteListSecIntact = true;
		}
		if(devicesSection.isDisplayed() && devicesSectionHeader.isDisplayed() && devicesIcon.isDisplayed()
				&& devicesSectionHeader.getText().equals("Devices")) {
			logger.info("Devices section is displayed properly");
			isDevicesSecIntact = true;
		}
		if(auditLogSection.isDisplayed() && auditLogSectionHeader.isDisplayed() && expandAuditLogSec.isEnabled()
				&& auditLogSectionHeader.getText().equals("Employee Audit Log")) {
			logger.info("Employee audit log section is displayed properly");
			isAuditLogSecIntact = true;
		}
		if(contactListSection.isDisplayed() && contactListSectionHeader.isDisplayed() && contactIcon.isDisplayed()
				&& contactListSectionHeader.getText().equals("Contact List")) {
			logger.info("Contact section is displayed properly");
			isContactSecIntact = true;
		}
		if(isEmpInfoSecIntact && isRecentMsgsSecIntact && isCallsSecIntact && isWhiteListSecIntact
				&& isAuditLogSecIntact && isContactSecIntact && isDevicesSecIntact) {
			logger.info("View emp page UI is displayed properly");
			isViewEmpPageIntact = true;
		}
		return isViewEmpPageIntact;
	}
	//New code : 26th Aug....................
	public void deleteDevice() throws InterruptedException {
		Thread.sleep(5000);
		searchEmailTextBox.sendKeys(System.getProperty("username"));
		searchBtn.click();
		Thread.sleep(1000);
		viewEmpIcon.click();

		Thread.sleep(2000);
		try {
			if (noDevDataMsg.isDisplayed()) {
				logger.info(noDevDataMsg.getText());
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
			logger.info("Atleast one device data is present");
			List<WebElement> numOfRows = driver
					.findElements(By.xpath("//div[@id='MainContent_DeviceList_SectionContent']//tr"));
			int numOfDev = numOfRows.size() - 2;
			for (int i = 0; i < numOfDev; i++) {
				devDeleteIcon.click();
				Thread.sleep(2000);
				confirmDeleteDevButton.click();
				Thread.sleep(2000);
			}
		}
	}
	
	public void addNewDevice(DeviceGetSet device) throws InterruptedException {

		Thread.sleep(5000);
		searchEmailTextBox.sendKeys(System.getProperty("username"));
		searchBtn.click();
		Thread.sleep(1000);
		viewEmpIcon.click();

		Thread.sleep(2000);

		addDeviceBtn.click();
		Thread.sleep(2000);
		countryCodeTextBox.sendKeys(device.getCountryCode());
		phoneNumTextBox.sendKeys(device.getPhoneNumber());
		imeiTextBox.sendKeys(device.getImeiNumber());
		meidTextBox.sendKeys(device.getMeid());
		pinTextBox.sendKeys(device.getPin());
		manufacturerTextBox.sendKeys(device.getManufacturer());
		modelTextBox.sendKeys(device.getModel());
		platformTextBox.sendKeys(device.getPlatform());
		platformVersionTextBox.sendKeys(device.getPlatformVersion());
		appVersionTextBox.sendKeys(device.getAppVersion());
		if (device.getGetOldMsgs().equalsIgnoreCase("Yes")) {
			getOldMsgCheckbox.click();
		}
		tokenTextBox.sendKeys(device.getToken());
		if (device.getActive().equalsIgnoreCase("Yes")) {
			activeCheckBox.click();
		}
		deviceSubmitBtn.click();
	}
	
	public boolean verifyDevAdded(DeviceGetSet device) throws InterruptedException {
		
		Thread.sleep(5000);
		
		boolean isDeviceAdded = false;
		
		List<WebElement> searchDevDetails = driver.findElements(By.xpath("(//div[@id='MainContent_DeviceList_SectionContent']//tr)[last()-1]//td"));
		for(int i = 0; i< searchDevDetails.size(); i++) {
			System.out.println("Device details are" + searchDevDetails.get(i).getText());
		}
				
		String number = searchDevDetails.get(0).getText().substring(1).replace(".","");
		String platform = searchDevDetails.get(1).getText();
		String app = searchDevDetails.get(2).getText();
		
		String actualPhoneNumber = device.getCountryCode().concat(device.getPhoneNumber());
		String displayedPlatform = device.getPlatform()+" "+(device.getPlatformVersion());
		
		if(number.equals(actualPhoneNumber) && platform.equals(displayedPlatform)) {
			System.out.println("Correct device details are present.");
			isDeviceAdded = true;
		}
		return isDeviceAdded;
	}
	
	
	public boolean editAddedDev(DeviceGetSet device) throws InterruptedException {
		
		boolean isEditSucessful = false;
		long timeStamp = System.currentTimeMillis();
		System.out.println("timestamp is " + timeStamp);
		String timeToStr = Long.toString(timeStamp);
		System.out.println("Time in String" + timeToStr);
		String partialTime = timeToStr.substring(9);
		System.out.println("Partial timestamp is " + partialTime);
		
		Thread.sleep(5000);
		searchEmailTextBox.sendKeys(System.getProperty("username"));
		searchBtn.click();
		Thread.sleep(1000);
		viewEmpIcon.click();		
		Thread.sleep(2000);
		devEditIcon.click();
		
		countryCodeTextBox.sendKeys(device.getCountryCode());
		phoneNumTextBox.clear();
		String inputPhoneNum = "+" + device.getPhoneNumber() + partialTime;
		phoneNumTextBox.sendKeys(inputPhoneNum);
		imeiTextBox.clear();
		String inputIMEI = device.getImeiNumber() + partialTime;
		imeiTextBox.sendKeys(inputIMEI);
		meidTextBox.clear();
		String inputMEID = device.getMeid() + partialTime;
		meidTextBox.sendKeys(inputMEID);
		pinTextBox.clear();
		String inputPIN = device.getPin() + partialTime;
		pinTextBox.sendKeys(inputPIN);
		manufacturerTextBox.clear();
		String inputManufacturer = device.getManufacturer() + partialTime;
		manufacturerTextBox.sendKeys(inputManufacturer);
		modelTextBox.clear();
		String inputModel = device.getModel() + partialTime;
		modelTextBox.sendKeys(inputModel);
		platformTextBox.clear();
		String inputPlatform = device.getPlatform()+ partialTime;
		platformTextBox.sendKeys(inputPlatform);
		platformVersionTextBox.clear();
		String inputPlatformVer = device.getPlatformVersion() + partialTime;
		platformVersionTextBox.sendKeys(inputPlatformVer);
		appVersionTextBox.clear();
		String inputAppVersion = device.getAppVersion() + partialTime;
		appVersionTextBox.sendKeys(inputAppVersion);
		if (device.getGetOldMsgs().equalsIgnoreCase("Yes")) {
			getOldMsgCheckbox.click();
		}
		tokenTextBox.sendKeys(device.getToken());
		if (device.getActive().equalsIgnoreCase("Yes")) {
			activeCheckBox.click();
		}
		deviceSubmitBtn.click();
		// code to verify editing has been done, click on edit icon again, get the text from all text box and compare it with sendkeys
		Thread.sleep(2000);
		devEditIcon.click();
		logger.info(phoneNumTextBox.getAttribute("value")+ "  " + imeiTextBox.getAttribute("value") + "  " + meidTextBox.getAttribute("value") + "  " +  "  " +  "  " + pinTextBox.getAttribute("value") + "  " + manufacturerTextBox.getAttribute("value") + "  " + modelTextBox.getAttribute("value") + "  " + platformTextBox.getAttribute("value"));
		if(phoneNumTextBox.getAttribute("value").equals(inputPhoneNum) && imeiTextBox.getAttribute("value").equals(inputIMEI)
				&& meidTextBox.getAttribute("value").equals(inputMEID) && pinTextBox.getAttribute("value").equals(inputPIN)
				&& manufacturerTextBox.getAttribute("value").equals(inputManufacturer) && modelTextBox.getAttribute("value").equals(inputModel)
				&& platformTextBox.getAttribute("value").equals(inputPlatform) && platformVersionTextBox.getAttribute("value").equals(inputPlatformVer)) {
			isEditSucessful = true;
			logger.info("Editing of the device parameters is successful");
			
		}
		
		return isEditSucessful;
	}
	
	public boolean addDevWithNoUniqueID(DeviceGetSet device) throws InterruptedException {
		boolean devNotAdded = false;
		boolean isErrorDisp = false;
		
		Thread.sleep(5000);
		searchEmailTextBox.sendKeys(System.getProperty("username"));
		searchBtn.click();
		Thread.sleep(1000);
		viewEmpIcon.click();
		String curURL = driver.getCurrentUrl();

		Thread.sleep(2000);

		addDeviceBtn.click();
		Thread.sleep(2000);
		countryCodeTextBox.sendKeys("1");
		phoneNumTextBox.sendKeys(device.getPhoneNumber());
		imeiTextBox.sendKeys("");
		meidTextBox.sendKeys("");
		pinTextBox.sendKeys("");
		manufacturerTextBox.sendKeys(device.getManufacturer());
		modelTextBox.sendKeys(device.getModel());
		platformTextBox.sendKeys(device.getPlatform());
		platformVersionTextBox.sendKeys(device.getPlatformVersion());
		appVersionTextBox.sendKeys(device.getAppVersion());
		if (device.getGetOldMsgs().equalsIgnoreCase("Yes")) {
			getOldMsgCheckbox.click();
		}
		tokenTextBox.sendKeys(device.getToken());
		if (device.getActive().equalsIgnoreCase("Yes")) {
			activeCheckBox.click();
		}
		deviceSubmitBtn.click();
		
		if(devAddErrorMsg.isDisplayed())
		{
			System.out.println("Device couldn't be added");
			logger.info(devAddErrorMsg.getText());
			isErrorDisp = true;
		}
		devCancelbtn.click();
		Thread.sleep(2000);
		if(driver.getCurrentUrl().equals(curURL) && isErrorDisp) {
			devNotAdded = true;
		}		
		return devNotAdded;
	}
	
	public void delteWhiteList() throws InterruptedException {
		Thread.sleep(5000);
		searchEmailTextBox.sendKeys(System.getProperty("username"));
		searchBtn.click();
		Thread.sleep(1000);
		viewEmpIcon.click();

		Thread.sleep(2000);
		try {
		if(noWhitelIstDataMsg.isDisplayed()) {
			logger.info(noWhitelIstDataMsg.getText());
		}
		} catch (Exception e) {
			logger.info("Atleast one whitelist data is present");
			List<WebElement> whitelists = driver.findElements(By.xpath("//div[contains(@id,'MainContent_White_SectionContent')]//tr"));
			int numOfWhitelists = whitelists.size() - 2;
			for(int i = 0; i<numOfWhitelists; i++) {
				deleteWhitelistIcon.click();
				Thread.sleep(2000);
				confirmDeleteWhitelistButton.click();
				Thread.sleep(2000);
			}
			
		}
	}
	
	public void addWhiteList() throws InterruptedException {
		Thread.sleep(5000);
		int count =0;
		/*searchEmailTextBox.sendKeys(System.getProperty("username"));
		searchBtn.click();
		Thread.sleep(1000);
		viewEmpIcon.click();*/

		Thread.sleep(2000);
		expandWhiteListSec.click();
		Thread.sleep(2000);
		List<WebElement>  empType = driver.findElements(By.xpath("//select[@id='MainContent_WListForm_WListItemReason']//option"));
		List<String> types = new ArrayList();
		for (WebElement type : empType) {
            Thread.sleep(1000);
            System.out.println(type.getText());
            types.add(type.getText());



        }
        System.out.println(types);
        for (String carriertype : types) {
            driver.findElement(By.xpath("//select[@id='MainContent_WListForm_WListItemReason']//option[contains(text(),'"
                    + carriertype.trim() + "')]")).click();
            waitlistItemTextBox.sendKeys("+123");
			submitWhitelistItem.click();
			count++;
			
        }
	/*	Select reasonDropdown = new Select(driver.findElement(By.id("MainContent_WListForm_WListItemReason")));
		List<WebElement> reasons = reasonDropdown.getOptions();
		int numOfReasons = reasons.size();
		for(int i =0; i< numOfReasons; i++) {
			System.out.println("Option index = " + i);
			reasonDropdown.selectByValue(String.valueOf(i));
			
			waitlistItemTextBox.sendKeys("+123");
			submitWhitelistItem.click();
			count++;
		}*/
		
		
		verifyAddedWhitelists(count, types);
	}
	
	public void verifyAddedWhitelists(int count, List<String> types) {
		List<WebElement> whitelists = driver.findElements(By.xpath("//div[contains(@id,'MainContent_Panel12')]//tr"));
		int numOfWhitelistsAdded = whitelists.size() - 2;
		if(numOfWhitelistsAdded == count) {
			System.out.println("Correct number of whitelists has been added");
			int i,j=0;
			for(i=2;i<whitelists.size();i++) {
				String whiteListData = driver.findElement(By.xpath("//div[contains(@id,'MainContent_Panel12')]//tr"+ "["+i+"]")).getText();
				System.out.println(whiteListData);
				
					if(whiteListData.contains("Phone") && whiteListData.contains("+123") && whiteListData.contains(types.get(j++))) {
						System.out.println("Entered details are correct");
					} else {
						System.out.println("Entered details are incorrect");
					}				
			}
			
		}
		
	}
	
	public boolean verifyAuditLog() throws InterruptedException {

		boolean isAuditLogUIDispl = false;
		List<String> tableHeaderTexts = new ArrayList<String>();
		Thread.sleep(5000);
		searchEmailTextBox.sendKeys(System.getProperty("username"));
		//searchEmailTextBox.sendKeys("gordon.lu@smarsh.com");
		searchBtn.click();
		Thread.sleep(1000);
		viewEmpIcon.click();
		Thread.sleep(2000);
		viewAuditLogLink.click();

		Thread.sleep(1000);
		try {
			if (empAuditLogSection.isDisplayed() && logGrid.isDisplayed()) {
				List<WebElement> tableHeaders = driver
						.findElements(By.xpath("//table[@id='MainContent_GridNow']//tr[1]//th"));
				int i = 0;
				for (WebElement headers : tableHeaders) {
					tableHeaderTexts.add(headers.getText());
				}

				/*
				 * for(int i = 0; i< tableHeaders.size(); i++) {
				 * 
				 * tableHeaderTexts.add(i, tableHeaders.get(i).getText());
				 * System.out.println(tableHeaders.get(i).getText());
				 */

				System.out.println(tableHeaderTexts);
				List<String> expectedHeaders = new ArrayList<String>();
				expectedHeaders.add(0, "ID");
				expectedHeaders.add(1, "Time");
				expectedHeaders.add(2, "Administrator Email");
				expectedHeaders.add(3, "Information");

				for (i = 0; i < tableHeaderTexts.size(); i++) {
					if (tableHeaderTexts.get(i).equals(expectedHeaders.get(i))) {
						
						isAuditLogUIDispl = true;
					}
				}
				System.out.println("Correct table headers are displayed");
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			System.out.println("Audit log UI is not correct");
		}
		return isAuditLogUIDispl;
	}
	
	public boolean verifyAuditLogFilter() throws InterruptedException {
		
		boolean correctTimeFrameOptions = false;
		boolean correctSearchResDisp = false;
		boolean isAuditLogFilterCorrect = false;
		Select timeFrame = new Select(timeFrameDropdown);
		Select administrator = new Select(administratorDropdown);
		List<WebElement> timeFrameOptions = timeFrame.getOptions();
		List<String> optionTexts = new ArrayList<String>();
		for(WebElement options : timeFrameOptions) {
			optionTexts.add(options.getText());
		}
		System.out.println(optionTexts);
		List<String> expectedTimeFrames = new ArrayList();
		expectedTimeFrames.add("Any");
		expectedTimeFrames.add("Between");
		expectedTimeFrames.add("Today");
		expectedTimeFrames.add("This week");
		expectedTimeFrames.add("This month");
		expectedTimeFrames.add("This quarter");
		expectedTimeFrames.add("This year");
		expectedTimeFrames.add("Last week");
		expectedTimeFrames.add("Last month");
		expectedTimeFrames.add("Last quarter");
		expectedTimeFrames.add("Last year");
		expectedTimeFrames.add("Past 24 hours");
		expectedTimeFrames.add("Past 3 days");
		expectedTimeFrames.add("Past week");
		expectedTimeFrames.add("Past 2 weeks");
		expectedTimeFrames.add("Past 30 days");
		for(int i =0; i<optionTexts.size(); i++) {
			if(optionTexts.get(i).equals(expectedTimeFrames.get(i))) {
				logger.info("Displayed time frame options are correct");
				correctTimeFrameOptions = true;
			}
		}
		
		//TODO for Administrator dropdown values
		
		timeFrame.selectByIndex(0);
		containsTextBox.sendKeys(" ");
		administrator.selectByVisibleText(System.getProperty("username"));
		
		searchLogButton.click();
		Thread.sleep(1000);
		List<WebElement> adminEmails = driver.findElements(By.xpath("//table[@id='MainContent_GridNow']//tr/td[3]"));
		List<String> adminEmailText = new ArrayList(); 
		for(WebElement email : adminEmails) {
			adminEmailText.add(email.getText());
		}
		System.out.println(adminEmailText);
		for(int i =0; i< adminEmailText.size(); i++) {
			if(adminEmailText.get(i).equals(System.getProperty("username"))) {
				correctSearchResDisp = true;
				logger.info("Only details corresponding to" + System.getProperty("username") + "are displayed");
			}
		}
		
		if(correctTimeFrameOptions && correctSearchResDisp) {
			System.out.println("Audit Log filter is displayed");
			isAuditLogFilterCorrect = true;
		}
		return isAuditLogFilterCorrect;
	}
	
	public boolean verifyAuditLogContainsFilter() throws InterruptedException {
		boolean isContainFilterCorrect = false;
		boolean srchRes1 = false;
		boolean srchRes2 = false;
		boolean srchRes3 = false;
		String searchText = driver.findElement(By.xpath("//table[@id='MainContent_GridNow']//tr[2]/td[4]")).getText()
				.substring(3);
		System.out.println("search text" + searchText);
		containsTextBox.clear();
		containsTextBox.sendKeys(searchText);
		searchLogButton.click();
		Thread.sleep(1000);

		// checking on first page
		List<WebElement> information1 = driver.findElements(By.xpath("//table[@id='MainContent_GridNow']//tr/td[4]"));
		List<String> informationText1 = new ArrayList();
		try {
			for (WebElement infText1 : information1) {
				informationText1.add(infText1.getText());
			}
		} catch (Exception e) {
			logger.info("Couldn't convert list of webelements to list of Strings");
			logger.info(e.getMessage());
		}
		for (int i = 0; i < informationText1.size(); i++) {
			try {
				if (informationText1.get(i).contains(searchText)) {
					logger.info("All the searched entries are containing the searched pattern on first page");
					srchRes1 = true;
				}
			} catch (Exception e) {
				logger.info("One or more entries are displayed incorrectly");
			}
		}

		// checking on 2nd page
		//WebElement secondPageLink = driver.findElement(By.xpath("//tr[contains(@class,'pager')]//table//tr/td[2]"));

		try {
			if (secondPageLink.isEnabled()) {
				secondPageLink.click();
				Thread.sleep(1000);
				List<WebElement> information2 = driver
						.findElements(By.xpath("//table[@id='MainContent_GridNow']//tr/td[4]"));
				List<String> informationText2 = new ArrayList();
				try {
					for (WebElement infText2 : information2) {
						informationText2.add(infText2.getText());
					}
				} catch (Exception e) {
					logger.info("Couldn't convert list of webelements to list of Strings");
					logger.info(e.getMessage());
				}
				for (int i = 0; i < informationText2.size(); i++) {
					if (informationText2.get(i).contains(searchText)) {
						logger.info(i + "th entry on 2nd page is containing the searched pattern.");
						srchRes2 = true;
					}
				}
			}
		} catch (Exception e) {
			logger.info("No second page is present to check.");
			srchRes2 = true;
		}

		// checking on last page
		try {
			if (navigateToLastPageBtn.isDisplayed()) {
				navigateToLastPageBtn.click();
				Thread.sleep(1000);
				List<WebElement> information3 = driver
						.findElements(By.xpath("//table[@id='MainContent_GridNow']//tr/td[4]"));
				List<String> informationText3 = new ArrayList();
				try {
					for (WebElement infText3 : information3) {
						informationText3.add(infText3.getText());
					}
				} catch (Exception e) {
					logger.info("Couldn't convert list of webelements to list of Strings");
					logger.info(e.getMessage());
				}
				for (int i = 0; i < informationText3.size(); i++) {
					if (informationText3.get(i).contains(searchText)) {
						logger.info("All the searched entries are containing the searched pattern on last page");
						srchRes3 = true;
					}
				}
			}
		} catch (Exception e) {
			logger.info("No last page is present to check.");
			srchRes3 = true;
		}

		if (srchRes1 && srchRes2 && srchRes3) {
			isContainFilterCorrect = true;
		}
		return isContainFilterCorrect;
	}
	
	public boolean verifyAuditLogTimeFilter() throws InterruptedException {
		boolean isTimeFilterCorrect = false;
		boolean srchRes1 = false;
		boolean srchRes2 = false;
		boolean srchRes3 = false;

		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("EDT"));
		long edtTime = calendar.getTimeInMillis();
		System.out.println("Current EDT time in long " + edtTime);
		calendar.add(Calendar.DATE, -30);
		Long date30DaysBack = calendar.getTimeInMillis();
		System.out.println("TIME BEFORE 30 DAYS " + date30DaysBack);
		Select timeFrame = new Select(timeFrameDropdown);
		timeFrame.selectByVisibleText("Past 30 days");
		searchLogButton.click();
		Thread.sleep(1000);

		List<WebElement> timeDisplayed1 = driver.findElements(By.xpath("//table[@id='MainContent_GridNow']//tr/td[2]"));
		List<String> timeDispString1 = new ArrayList();

		for (WebElement time : timeDisplayed1) {
			timeDispString1.add(time.getText());
		}
		List<Long> longTime1 = new ArrayList();
		for (int i = 0; i < timeDispString1.size(); i++) {
			longTime1.add(i, EmployeesPage.getLongFromUTC(timeDispString1.get(i)));
			System.out.println(timeDispString1.get(i) + "in UTC" + longTime1.get(i));
			if (System.currentTimeMillis() >= longTime1.get(i) && longTime1.get(i) >= date30DaysBack) {
				System.out.println(i + "th entry is within the specified time range");
				srchRes1 = true;
			}
		}
		// check on 2nd page
		try {
			if (secondPageLink.isEnabled()) {
				secondPageLink.click();
				Thread.sleep(1000);
				List<WebElement> timeDisplayed2 = driver
						.findElements(By.xpath("//table[@id='MainContent_GridNow']//tr/td[2]"));
				List<String> timeDispString2 = new ArrayList();

				for (WebElement time : timeDisplayed2) {
					timeDispString2.add(time.getText());
				}
				List<Long> longTime2 = new ArrayList();
				for (int i = 0; i < timeDispString2.size(); i++) {
					longTime2.add(i, EmployeesPage.getLongFromUTC(timeDispString2.get(i)));
					System.out.println(timeDispString2.get(i) + "in UTC" + longTime2.get(i));
					if (System.currentTimeMillis() >= longTime2.get(i) && longTime2.get(i) >= date30DaysBack) {
						System.out.println(i + "th entry is within the specified time range");
						srchRes2 = true;
					}
				}
			}
		} catch (Exception e) {
			
			System.out.println("No second page displayed to search");
			srchRes2 = true;
		}
		// 2nd page check completed

		// Last page check
		try {
			if (navigateToLastPageBtn.isEnabled()) {
				navigateToLastPageBtn.click();
				Thread.sleep(1000);
				List<WebElement> timeDisplayed3 = driver
						.findElements(By.xpath("//table[@id='MainContent_GridNow']//tr/td[2]"));
				List<String> timeDispString3 = new ArrayList();

				for (WebElement time : timeDisplayed3) {
					timeDispString3.add(time.getText());
				}
				List<Long> longTime3 = new ArrayList();
				for (int i = 0; i < timeDispString3.size(); i++) {
					longTime3.add(i, EmployeesPage.getLongFromUTC(timeDispString3.get(i)));
					System.out.println(timeDispString3.get(i) + "in UTC" + longTime3.get(i));
					if (System.currentTimeMillis() >= longTime3.get(i) && longTime3.get(i) >= date30DaysBack) {
						System.out.println(i + "th entry is within the specified time range");
						srchRes3 = true;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("No last page displayed to search");
			srchRes3 = true;
		}
		// Last page check completed
		
		

		if (srchRes1 && srchRes2 && srchRes3) {
			isTimeFilterCorrect = true;
		}
		return isTimeFilterCorrect;
	}
	
	//clear filter
	public boolean clearAuditLogFilter() throws InterruptedException {
		boolean isClearFilterWorking = false;
		boolean adminSrchRes = false;
		boolean containsSrchRes = false;
		boolean timeSrchRes = false;
		boolean timeSrchResPostReset = false;
		boolean containsSrchResPostReset = false;
		boolean adminSrchResPostReset = false;
		String searchText = driver.findElement(By.xpath("//table[@id='MainContent_GridNow']//tr[2]/td[4]")).getText()
				.substring(3);
		Select administrator = new Select(administratorDropdown);
		System.out.println("search text" + searchText);
		containsTextBox.clear();
		containsTextBox.sendKeys(searchText);
		administrator.selectByVisibleText(System.getProperty("username"));
		// administrator.selectByVisibleText("gordon.lu@smarsh.com");
		Select timeFrame = new Select(timeFrameDropdown);
		timeFrame.selectByVisibleText("Past 30 days");
		searchLogButton.click();
		Thread.sleep(2000);

		// checking for admin based search
		List<WebElement> adminEmails = driver.findElements(By.xpath("//table[@id='MainContent_GridNow']//tr/td[3]"));
		List<String> adminEmailText = new ArrayList();
		for (WebElement email : adminEmails) {
			adminEmailText.add(email.getText());
		}
		System.out.println(adminEmailText);
		for (int i = 0; i < adminEmailText.size(); i++) {
			if (adminEmailText.get(i).equals(/* "Gordon.Lu@smarsh.com")) */System.getProperty("username"))) {
				adminSrchRes = true;
				logger.info("Only details corresponding to" + System.getProperty("username") + "are displayed");
			}
		}

		// end checking for admin based

		// check for contains
		List<WebElement> information1 = driver.findElements(By.xpath("//table[@id='MainContent_GridNow']//tr/td[4]"));
		List<String> informationText1 = new ArrayList();
		try {
			for (WebElement infText1 : information1) {
				informationText1.add(infText1.getText());
			}
		} catch (Exception e) {
			logger.info("Couldn't convert list of webelements to list of Strings");
			logger.info(e.getMessage());
		}
		for (int i = 0; i < informationText1.size(); i++) {
			try {
				if (informationText1.get(i).contains(searchText)) {
					logger.info("All the searched entries are containing the searched pattern on first page");
					containsSrchRes = true;
				}
			} catch (Exception e) {
				logger.info("One or more entries are displayed incorrectly");
			}
		}
		// end checking for contains

		// checking for time filter

		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("EDT"));
		long edtTime = calendar.getTimeInMillis();
		System.out.println("Current EDT time in long " + edtTime);
		calendar.add(Calendar.DATE, -30);
		Long date30DaysBack = calendar.getTimeInMillis();
		System.out.println("TIME BEFORE 30 DAYS " + date30DaysBack);
		List<WebElement> timeDisplayed1 = driver.findElements(By.xpath("//table[@id='MainContent_GridNow']//tr/td[2]"));
		List<String> timeDispString1 = new ArrayList();

		for (WebElement time : timeDisplayed1) {
			timeDispString1.add(time.getText());
		}
		List<Long> longTime1 = new ArrayList();
		for (int i = 0; i < timeDispString1.size(); i++) {
			longTime1.add(i, EmployeesPage.getLongFromUTC(timeDispString1.get(i)));
			System.out.println(timeDispString1.get(i) + "in UTC" + longTime1.get(i));
			if (System.currentTimeMillis() >= longTime1.get(i) && longTime1.get(i) >= date30DaysBack) {
				System.out.println(i + "th entry is within the specified time range");
				timeSrchRes = true;
			}
		}

		int numOfRows = 0;
		int pages = 0;
		int totalNumOfLogEntries = 0;
		List<WebElement> PagesDisp = driver.findElements(By.xpath("//tr[contains(@class,'pager')]//table//tr//td"));
		int numberOfPagesDisp = PagesDisp.size();
		try {
			if (navigateToLastPageBtn.isEnabled()) {
				navigateToLastPageBtn.click();
				String lastPageNum = lastPageLink.getText();
				pages = Integer.parseInt(lastPageNum);
				System.out.println("Total number of pages is " + pages);
				lastPageLink.click();
				List<WebElement> rowsInLastPage = driver
						.findElements(By.xpath("//table[@id='MainContent_GridNow']//tr[1]/following-sibling::tr"));
				int numOfRowsInLastPage = rowsInLastPage.size() - 1;
				totalNumOfLogEntries = (pages - 1) * 25 + numOfRowsInLastPage;
				System.out.println("Total entries = " + totalNumOfLogEntries);

			}
		} catch (Exception e) {

			String lastPageNum = lastPageLink.getText();
			pages = Integer.parseInt(lastPageNum);
			System.out.println("Total number of pages is " + pages);
			lastPageLink.click();
			List<WebElement> rowsInLastPage = driver
					.findElements(By.xpath("//table[@id='MainContent_GridNow']//tr[1]/following-sibling::tr"));
			int numOfRowsInLastPage = rowsInLastPage.size() - 1;
			totalNumOfLogEntries = (pages - 1) * 25 + numOfRowsInLastPage;
			System.out.println("Total entries = " + totalNumOfLogEntries);
			// System.out.println("no last page displayed");
		}
		// end checking for time filter

		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

		// Reset done
		Thread.sleep(1000);
		clearLogFilter.click();
		Thread.sleep(1000);
		String defaultTimeFrame = timeFrame.getFirstSelectedOption().getText();
		String defaultcontainsText = containsTextBox.getText();
		String defaultAdmin = administrator.getFirstSelectedOption().getText();
		System.out.println(
				"Time Frame = " + defaultTimeFrame + "contains = " + defaultcontainsText + "admin = " + defaultAdmin);
		Thread.sleep(2000);
		// ..............................................................................

		int numOfRowsPostReset = 0;
		int pagesPostReset = 0;
		int totalNumOfLogEntriesPostReset = 0;
		List<WebElement> PagesDispPostReset = driver
				.findElements(By.xpath("//tr[contains(@class,'pager')]//table//tr//td"));
		int numberOfPagesDispPostReset = PagesDispPostReset.size();
		try {
			if (navigateToLastPageBtn.isEnabled()) {
				navigateToLastPageBtn.click();
				String lastPageNumPostReset = lastPageLink.getText();
				pagesPostReset = Integer.parseInt(lastPageNumPostReset);
				System.out.println("Total number of pages is " + pages);
				lastPageLink.click();
				List<WebElement> rowsInLastPagePostReset = driver
						.findElements(By.xpath("//table[@id='MainContent_GridNow']//tr[1]/following-sibling::tr"));
				int numOfRowsInLastPagePostReset = rowsInLastPagePostReset.size() - 1;
				totalNumOfLogEntriesPostReset = (pages - 1) * 25 + numOfRowsInLastPagePostReset;
				System.out.println("Total entries = " + totalNumOfLogEntriesPostReset);

			}
		} catch (Exception e) {

			String lastPageNumPostReset = lastPageLink.getText();
			pages = Integer.parseInt(lastPageNumPostReset);
			System.out.println("Total number of pages is " + pages);
			lastPageLink.click();
			List<WebElement> rowsInLastPagePostReset = driver
					.findElements(By.xpath("//table[@id='MainContent_GridNow']//tr[1]/following-sibling::tr"));
			int numOfRowsInLastPagePostReset = rowsInLastPagePostReset.size() - 1;
			totalNumOfLogEntriesPostReset = (pages - 1) * 25 + numOfRowsInLastPagePostReset;
			System.out.println("Total entries = " + totalNumOfLogEntriesPostReset);
			// System.out.println("no last page displayed");
		}
		// ...................................................................................................

		if (defaultTimeFrame.equals("Any") && defaultcontainsText.equals("") && defaultAdmin.equals("All")
				&& totalNumOfLogEntriesPostReset >= totalNumOfLogEntries) {
			System.out.println("Clar filter is working properly");
			isClearFilterWorking = true;
		}
		return isClearFilterWorking;

	}

	// end clear filter
	
	public boolean verifyAuditLogPageNavigation() throws InterruptedException {

		boolean isPaginationCorrect = false;
		boolean secondPageDisp = false;
		boolean thirdPageDisp = false;
		boolean lastPageDisp = false;
		boolean firstPageDisp = false;
		
		if (pageNavigation.isDisplayed()) {
			System.out.println("Pagination tab is displayed");
			String lastLogID = driver.findElement(By.xpath("//table[@id = 'MainContent_GridNow']//tr[last()-1]/td[1]"))
					.getText();
			System.out.println("Log ID" + lastLogID);
			driver.findElement(By.xpath("//tr[contains(@class,'pager')]//table//tr/td[2]")).click();
			Thread.sleep(2000);
			String firstLogID = driver.findElement(By.xpath("//table[@id = 'MainContent_GridNow']//tr[2]/td[1]"))
					.getText();
			String secondPageLastLogID = driver
					.findElement(By.xpath("//table[@id = 'MainContent_GridNow']//tr[last()-1]/td[1]")).getText();
			int firstPageLastLogID = Integer.parseInt(lastLogID);
			int secondPageFirstLogID = Integer.parseInt(firstLogID);
			int secondPageLastID = Integer.parseInt(secondPageLastLogID);
			if (firstPageLastLogID > secondPageFirstLogID) {
				System.out.println("User has navigated to second page");
				secondPageDisp = true;

			} else {
				System.out.println("Navigation failed from first page to second page");
			}

			driver.findElement(By.xpath("//tr[contains(@class,'pager')]//table//tr/td[1]")).click();
			Thread.sleep(2000);
			if (firstPageLastLogID > secondPageFirstLogID) {
				System.out.println("User has navigated back to first page");
				firstPageDisp = true;
			} else {
				System.out.println("Navigation from second page back to first page is displayed");
			}

			WebElement thirdPage = driver.findElement(By.xpath("//tr[contains(@class,'pager')]//table//tr/td[3]"));
			if (thirdPage.isDisplayed()) {
				thirdPage.click();
				String thirdPageLogId = driver
						.findElement(By.xpath("//table[@id = 'MainContent_GridNow']//tr[2]/td[1]")).getText();
				int thirdPageFirstLogId = Integer.parseInt(thirdPageLogId);
				if (secondPageLastID > thirdPageFirstLogId) {
					System.out.println("Navigated back to third page");
					thirdPageDisp = true;
				}
			}
			try {
			if (navigateToLastPageBtn.isDisplayed()) {
				navigateToLastPageBtn.click();
				Thread.sleep(2000);
				System.out.println("Navigated to last page");
				lastPageDisp = true;
				navigateToFirstPageBtn.click();
				Thread.sleep(2000);
				System.out.println("Navigated back to first page");

			}} catch(Exception e) {
				lastPageDisp = true;
				System.out.println("No button to navigate to last page");
			}
		 
		} else {
			System.out.println("No page navigation bar is present");
		}
		if (firstPageDisp && secondPageDisp && thirdPageDisp && lastPageDisp) {
			isPaginationCorrect = true;
		}
		return isPaginationCorrect;
	}
	
	public boolean verifyContacts() throws InterruptedException {
		boolean isContactCountCorrect = false;
		boolean isContactsDetails = false;
		boolean isContacts = false;
		WebDriverWait wait = new WebDriverWait(driver, 60);
		srchPhoneNumberTextBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_EntForm_EmployeePhoneMatch")));
		srchPhoneNumberTextBox.sendKeys(getObject("phoneNum"));
		searchBtn.click();
		Thread.sleep(1000);
		String empEmail = driver.findElement(By.xpath("//table[@id='MainContent_GridNow']//tr[2]//td[3]")).getText();
		
		db.verifyNumOfContacts(empEmail,stmt);
		System.out.println("Emp email is " + empEmail);
		driver.findElement(By.xpath(
				"//table[@id='MainContent_GridNow']//tr[2]//i[contains(@class,'fa fa-eye fa-2x fa-actionlink')]"))
				.click();
		Thread.sleep(1000);
		String numOfContacts = contactsCount.getText();
		int initialNumOfContacts = Integer.parseInt(numOfContacts);
		System.out.println("number of contacts = " + numOfContacts);
		// verify contacts displayed
		List<WebElement> phoneNumsElements = driver
				.findElements(By.xpath("//div[@id='MainContent_EmpCont_SectionContent']//tr/td[1]"));
		List<String> observedPhoneNums = new ArrayList();
		for (WebElement phone : phoneNumsElements) {
			observedPhoneNums.add(phone.getText());
		}
		System.out.println("Observed phone numbers from UI are " + observedPhoneNums);
		int finalNumOfContact = 0;
		if (observedPhoneNums.size() > 0) {
			Thread.sleep(1000);
			deleteContactbtn.click();
			Thread.sleep(1000);
			cancelContactDeleteBtn.click();
			Thread.sleep(1000);
			deleteContactbtn.click();
			Thread.sleep(1000);
			confirmContactDeleteBtn.click();
			String numberOfContactsPostDelete = contactsCount.getText();
			finalNumOfContact = Integer.parseInt(numberOfContactsPostDelete);
			if ((initialNumOfContacts - 1) == finalNumOfContact) {
				System.out.println("One contact has been deleted");
			}
		} else {
			System.out.println("No contacts to delete");
		}
		
		int contactsCountFromDB = db.verifyNumOfContacts(empEmail, stmt);
		System.out.println("Contacts count from DB = " + contactsCountFromDB);
				
		List<String> contactsFromDB = db.verifyContactLists(empEmail, stmt);
		System.out.println("Phone numbers from database are: " + contactsFromDB);
		
		if(observedPhoneNums.contains(contactsFromDB)) {
			System.out.println("Contact contents are correct");
			isContactsDetails = true;			
		} else {
			System.out.println("Mismatch in contact contents between UI and DB");
		}
		
		if(contactsCountFromDB == finalNumOfContact) {
			System.out.println("Correct number of contacts is displayed.");
			isContactCountCorrect = true;
		} else {
			System.out.println("Mismatch in the number of contacts");
		}
		if(isContactsDetails && isContactCountCorrect) {
			isContacts = true;
		} 		
		return isContacts;
	}
	
	public boolean verifyNumOfMessages() throws InterruptedException {
		List<Integer> msgCountFromDB =  new ArrayList();
		boolean isCountOfMsgsCorrect = false;
		WebDriverWait wait = new WebDriverWait(driver, 60);
		srchPhoneNumberTextBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_EntForm_EmployeePhoneMatch")));
		srchPhoneNumberTextBox.sendKeys(getObject("phoneNum"));
		searchBtn.click();
		Thread.sleep(1000);
		String empEmail = driver.findElement(By.xpath("//table[@id='MainContent_GridNow']//tr[2]//td[3]")).getText();
		
		Thread.sleep(1000);
		viewEmpIcon.click();
		
		int dispNumOfTotalMsgs = Integer.parseInt(numOfTotalMsgsText.getText());
		int dispNumOfMsgsInCurrMonth = Integer.parseInt(numOfMsgsInThisMonth.getText());
		int dispNumOfMsgsToday = Integer.parseInt(numOfMsgsToday.getText());
		int dispNumOfMsgsInCurrHour = Integer.parseInt(numOfMsgsInThisHour.getText());
		msgCountFromDB = db.verifyNumOfMsgs(empEmail,stmt);
		
		if(dispNumOfTotalMsgs == msgCountFromDB.get(0) && dispNumOfMsgsInCurrMonth == msgCountFromDB.get(1) && 
				dispNumOfMsgsToday == msgCountFromDB.get(2) && dispNumOfMsgsInCurrHour == msgCountFromDB.get(3)) {
			System.out.println("The displayed number of messages are correct");
			isCountOfMsgsCorrect = true;
		} else {
			System.out.println("Mismatch in number of messages displayed");
		}
		
		return isCountOfMsgsCorrect;
		
	}
	//download audit Log search
	
	public void downloadAuditSearch() {
		downloadLogSearch.click();
	}

	// vaildating the downloaded CSV Header  => To be edited
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

	
	//............end..............................
	
}
