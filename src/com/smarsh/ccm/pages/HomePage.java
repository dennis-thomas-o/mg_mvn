package com.smarsh.ccm.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends TestBase {

	WebDriver driver;

	// Smarsh logo
	/*
	 * @FindBy(linkText = "dashboard") WebElement smarshLogo;
	 */

	// Menu links
	@FindBy(id = "Home")
	WebElement homeLink;

	@FindBy(id = "PnlNavSearch")
	WebElement searchDropdownLink;

	@FindBy(id = "Employees")
	WebElement employeeLink;

	@FindBy(id = "Reports")
	WebElement reportsDropdownLink;

	@FindBy(id = "Messages")
	WebElement messagesLink;

	@FindBy(id = "Calls")
	WebElement callsLink;

	@FindBy(id = "Administrators")
	WebElement administratorsLink;

	@FindBy(id = "Alerts")
	WebElement policyAlertsDropdownLink;

	@FindBy(id = "Integrations")
	WebElement integrationsLink;

	@FindBy(id = "DoAdmin")
	WebElement settingsDropdownLink;

	@FindBy(id = "DoSuper")
	WebElement adminDropdownLink;

	@FindBy(id = "UserInfo")
	WebElement userInfoDropdownLink;

	@FindBy(id = "CallInfo")
	WebElement callDetails;

	@FindBy(id = "SupportLink")
	WebElement supportLink;

	// Search section
	@FindBy(id = "MainContent_ContentTitle")
	WebElement searchSection;

	@FindBy(xpath = "//span[.='Search employees in the system by name or email.']")
	WebElement searchSecText;

	@FindBy(id = "MainContent_SearchForm_SearchText")
	WebElement searchTextBox;

	@FindBy(id = "MainContent_SearchForm_SubmitButton")
	WebElement submitBtn;

	@FindBy(id = "MainContent_SearchForm_CancelButton")
	WebElement cancelBtn;

	@FindBy(xpath = "//a[.='List All Employees']")
	WebElement listEmpLink;

	@FindBy(xpath = "//a[contains(text(),'Update Employees')]")
	WebElement updateEmpLink;

	@FindBy(linkText = "List All Administrators")
	WebElement administratorsLinkinSearch;

	@FindBy(partialLinkText = "Export Settings")
	WebElement smtpExportSettingsLink;

	@FindBy(partialLinkText = "SMTP Export Log")
	WebElement exportLogLink;

	// Administrators section
	@FindBy(id = "MainContent_ctl00_Label1")
	WebElement administratorsSection;

	@FindBy(id = "MainContent_ctl00_PAHIcon")
	WebElement administratorAvatarLink;

	@FindBy(id = "MainContent_ctl00_SettingLink")
	WebElement settingsAdminIcon;

	@FindBy(id = "MainContent_ctl00_LinkTo")
	WebElement expandAdminIcon;

	// Policy Alerts section
	@FindBy(id = "MainContent_ctl01_PAHTitle")
	WebElement policyAlertsSection;

	@FindBy(id = "MainContent_ctl01_PAHIcon")
	WebElement alertIcon;

	@FindBy(id = "MainContent_ctl01_SettingLink")
	WebElement settingsPolicyAlertIcon;

	@FindBy(id = "MainContent_ctl01_LinkTo")
	WebElement expandPoliyAlertsIcon;

	// Employees section
	@FindBy(id = "MainContent_ctl02_ContentTitle")
	WebElement employeesSection;

	@FindBy(id = "MainContent_ctl02_SettingLink")
	WebElement empSettingsIcon;

	@FindBy(id = "MainContent_ctl02_LinkTo")
	WebElement expandEmpIcon;

	// Recent Messages section
	@FindBy(id = "MainContent_ctl03_PAHTitle")
	WebElement recentMsgsSection;

	@FindBy(id = "MainContent_ctl03_LinkTo")
	WebElement recentMsgsExpandIcon;

	// Mobile Devices section
	@FindBy(id = "MainContent_ctl04_ContentTitle")
	WebElement mobileDevicesSection;

	@FindBy(id = "MainContent_ctl04_SettingLink")
	WebElement mobDevicesSettingsIcon;

	@FindBy(id = "MainContent_ctl04_DeviceLogLink")
	WebElement mobDevicesExpandIcon;

	// Voice Calls
	@FindBy(id = "MainContent_ctl05_PAHTitle")
	WebElement voiceCallsSection;

	@FindBy(id = "MainContent_ctl05_LinkTo")
	WebElement voiceCallsExpandIcon;

	// Reports section
	@FindBy(id = "MainContent_ctl06_ContentTitle")
	WebElement reportsSection;

	@FindBy(id = "MainContent_ctl06_LinkTo")
	WebElement expandReportsIcon;

	@FindBy(xpath = "//div[contains(text(),'MobileGuard')]")
	WebElement cpyRightText;

	@FindBy(id = "VersionInfo")
	WebElement versionNum;

	@FindBy(id = "OpenSourceAttribution")
	WebElement openSrcLink;

	@FindBy(id = "NavSearchEmployees")
	WebElement searchEmployees;

	@FindBy(id = "NavSearchDevices")
	WebElement searchDevices;

	@FindBy(id = "NavSearchMessages")
	WebElement searchMsgs;

	@FindBy(id = "ui-id-1")
	WebElement searchPage;

	@FindBy(xpath = "//li[@aria-controls='EmployeeSearch']")
	WebElement employeesTab;

	@FindBy(xpath = "//li[@aria-controls='DeviceSearch']")
	WebElement devicesTab;

	@FindBy(xpath = "//li[@aria-controls='MessageSearch']")
	WebElement msgsTab;

	@FindBy(id = "EmployeeSearch")
	WebElement employeeGrid;

	@FindBy(xpath = "//button/span[1][contains(text(),'Close')]")
	WebElement closeBtn;

	@FindBy(id = "DeviceSearch")
	WebElement deviceGrid;

	@FindBy(id = "MessageSearch")
	WebElement msgsGrid;

	@FindBy(id = "NavCallReports")
	WebElement callReportsSubMenu;

	@FindBy(id = "NavCustomReports")
	WebElement customReportsSubMenu;

	@FindBy(id = "NavDeviceReports")
	WebElement deviceReportsSubMenu;

	@FindBy(id = "NavEmployeeReports")
	WebElement empReportsSubMenu;

	@FindBy(id = "NavMessageDownload")
	WebElement msgDwnldReportSubMenu;

	@FindBy(id = "NavMessageReports")
	WebElement msgReportsSubMenu;

	@FindBy(id = "NavSystemReports")
	WebElement sysReportsSubMenu;

	@FindBy(id = "MainContent_Label4")
	WebElement msgDownloadReportsSection;

	@FindBy(id = "MainContent_DataGrid")
	WebElement callReportGrid;

	@FindBy(id = "MainContent_GridNow")
	WebElement customReportGrid;

	@FindBy(id = "MainContent_DataGrid")
	WebElement devReportGrid;

	@FindBy(id = "MainContent_DataGrid")
	WebElement empReportGrid;

	@FindBy(id = "MainContent_DataGrid")
	WebElement msgReportGrid;

	@FindBy(id = "MainContent_DataGrid")
	WebElement sysReportGrid;

	@FindBy(id = "MainContent_FilterForm")
	WebElement customReportFilterSection;

	@FindBy(id = "MainContent_Label2")
	WebElement closeReportLink;

	@FindBy(id = "MainContent_Label4")
	WebElement callReportsSec;

	@FindBy(id = "MainContent_Label3")
	WebElement custReportsSec;

	@FindBy(xpath = "//span[contains(text(),'Message Reports')]")
	WebElement messageReportSection;

	@FindBy(xpath = "//span[contains(text(),'Device Reports')]")
	WebElement devReportSection;

	@FindBy(id = "NavAlertSettings")
	WebElement alertSetting;

	@FindBy(id = "NavAlertView")
	WebElement alertView;

	@FindBy(id = "NavSystemSettings")
	WebElement sysSettSubMenu;

	@FindBy(id = "NavCarrierSettings")
	WebElement carrierSettSubMenu;

	@FindBy(id = "NavEmployeeSettings")
	WebElement empSettSubMenu;

	@FindBy(id = "NavDeviceSettings")
	WebElement devSettSubMenu;

	@FindBy(id = "MainContent_Label13")
	WebElement atnTSection;

	@FindBy(id = "MainContent_ContentTitle")
	WebElement vodafoneSection;

	@FindBy(id = "MainContent_HutchLabel")
	WebElement hutchSection;

	@FindBy(id = "MainContent_TruphoneLabel")
	WebElement truePhoneSection;

	@FindBy(id = "MainContent_RogersLabel")
	WebElement rogersSection;

	@FindBy(id = "MainContent_UsccLabel")
	WebElement usCellularSection;

	@FindBy(id = "MainContent_Label6")
	WebElement verizonSection;

	@FindBy(id = "MainContent_Word_SectionContainer")
	WebElement wordPolicySection;

	@FindBy(id = "MainContent_Phrase_SectionContainer")
	WebElement phrasePolicySection;

	@FindBy(id = "MainContent_Pattern_SectionContainer")
	WebElement patternPolicySection;

	@FindBy(id = "MainContent_Manual_SectionContainer")
	WebElement manualPolicySection;

	@FindBy(id = "MainContent_SectionContainer")
	WebElement viewAlertGrid;

	@FindBy(id = "MainContent_DataPoint")
	WebElement alertGridContents;

	@FindBy(xpath = "//a[contains(text(),'AirWatch')]")
	WebElement devBar1;

	@FindBy(xpath = "//a[contains(text(),'MobileIron')]")
	WebElement devBar2;

	@FindBy(xpath = "//a[contains(text(),'XenMobile')]")
	WebElement devBar3;

	@FindBy(id = "MainContent_SettingPanel")
	WebElement sysSettingsSection;

	@FindBy(id = "MainContent_OneLoginSAMLPanel")
	WebElement samlSettingsSection;

	@FindBy(id = "MainContent_ActiveDirectorySettingsPanel")
	WebElement activeDirSettingsSection;

	@FindBy(id = "MainContent_DeviceGuardPanel")
	WebElement devGuardSettingsSection;

	@FindBy(id = "MainContent_Panel1")
	WebElement proxSettingsSection;

	@FindBy(id = "MainContent_Panel4")
	WebElement ftpSettingsSection;

	@FindBy(id = "MainContent_DialogTitle")
	WebElement empRegSectionHeading;

	@FindBy(id = "MainContent_SectionContent")
	WebElement empRegSectionBody;

	@FindBy(xpath = "//span[contains(text(),'LDAP Integration')]")
	WebElement ldapIntegSettSectionHeading;

	@FindBy(id = "MainContent_Panel6")
	WebElement ldapIntegSettSectionBody;

	@FindBy(id = "MainContent_PanelWebServiceEmailPhoneNumberMapping")
	WebElement crmIntegSection;

	@FindBy(id = "MainContent_Label1")
	WebElement heartbeatSectionHeading;

	@FindBy(id = "MainContent_PingForm")
	WebElement heartbeatSectionBody;

	@FindBy(id = "MainContent_Panel9")
	WebElement convThreadSection;

	@FindBy(xpath = "//span[contains(text(),'Heartbeat')]")
	WebElement heartbeatSection;

	@FindBy(id = "MainContent_DialogTitle")
	WebElement mobClientUninstallSectionHeading;

	@FindBy(id = "MainContent_EntForm")
	WebElement mobClientUninstallSectionBody;

	@FindBy(id = "//span[contains(text(),'iPhone Settings')]")
	WebElement iPhoneSettSectionHeading;

	@FindBy(id = "MainContent_IPhone")
	WebElement iphoneSettSectionBody;

	@FindBy(xpath = "//span[contains(text(),'Mobile Support Information')]")
	WebElement mobSupInfoSectionHeading;

	@FindBy(id = "MainContent_SupportForm")
	WebElement mobSupInfoSectionBody;

	@FindBy(id = "NavSystemLogs")
	WebElement sysLogsLink;

	@FindBy(id = "NavSystemTools")
	WebElement sysToolsLink;

	@FindBy(id = "MainContent_SyslogPanel")
	WebElement sysLogPanel;

	@FindBy(xpath = "//span[@id = 'MainContent_DialogTitle']")
	WebElement filterSecHeading;

	@FindBy(id = "MainContent_FilterForm_SubmitButton")
	WebElement submitFilterBtn;

	@FindBy(id = "MainContent_FilterForm_CancelButton")
	WebElement cancelFilterBtn;

	@FindBy(id = "MainContent_FilterForm_DoDownload_Click")
	WebElement downloadLogBtn;

	@FindBy(xpath = "//span[contains(text(),'System Log')]")
	WebElement sysLogSecHeading;

	@FindBy(id = "MainContent_GridNow")
	WebElement logGrid;

	@FindBy(xpath = "//span[contains(text(),'System Tools')]")
	WebElement sysToolsSectionHeading;

	@FindBy(id = "MainContent_DoMarkup")
	WebElement markupBtn;

	@FindBy(id = "MainContent_DoLDAPCheck")
	WebElement ldapCheckbtn;

	@FindBy(id = "MainContent_DoRunMsgEx")
	WebElement msgExportBtn;

	@FindBy(id = "MainContent_DoMIProcess")
	WebElement mobileIronServBtn;

	@FindBy(xpath = "//span[contains(text(),'Enable Ghost Admin')]")
	WebElement ghostAdminBtn;

	@FindBy(xpath = "//span[contains(text(),'Enable Delete Report')]")
	WebElement deleteReportBtn;

	@FindBy(id = "MainContent_DoGenerateSystemHealthReport")
	WebElement sysHealthReportBtn;

	@FindBy(id = "MainContent_DoStatisticServiceRunNow")
	WebElement staticServBtn;

	@FindBy(id = "MainContent_DoUpdateDatabase")
	WebElement updateDBBtn;

	@FindBy(id = "MainContent_DoAttProcessRestartNow")
	WebElement restartAtnTBtn;

	@FindBy(id = "MainContent_DoSubmitVMAPForm")
	WebElement submitVMAPBtn;

	@FindBy(id = "MainContent_DoVzwProcessRestartNow")
	WebElement restartVerizonBtn;

	@FindBy(id = "VzwDownloadRunNow")
	WebElement dwnldVzwBtn;

	@FindBy(id = "MainContent_DoVzwImportAndMapNow")
	WebElement vzwImporterBtn;

	@FindBy(id = "MainContent_DoQueryExecutor")
	WebElement queryExecBtn;

	@FindBy(xpath = "//span[contains(text(),'Mobile Application Configuration")
	WebElement mobAppConfigSectionHeading;

	@FindBy(id = "MainContent_MobileAppConfigForm_ConfigXML")
	WebElement mobAppConfigTextArea;

	@FindBy(xpath = "//span[contains(text(),'Data Encryption')]")
	WebElement dataEncryptSectionHeading;

	@FindBy(xpath = "//span[contains(text(),'AES 256 is used to encrypt')]")
	WebElement encryptText;

	@FindBy(id = "MainContent_EncryptionKeyForm_SubmitButton")
	WebElement encryptBtn;

	@FindBy(id = "MainContent_EncryptionKeyForm_CancelButton")
	WebElement encryptCancelBtn;
	// new add frm sagar

	@FindBy(id = "OpenSourceAttribution")
	WebElement openSrchLink;

	@FindBy(id = "MainContent_EmojiOne")
	WebElement emojiOneLink;

	@FindBy(id = "MainContent_Twemoji")
	WebElement twitterEmojiLink;

	@FindBy(id = "MainContent_MaterialIcon")
	WebElement designIconLink;

	@FindBy(xpath = "//div[@id='UserIcon']")
	WebElement userIcon;

	@FindBy(id = "MGDocLink")
	WebElement mgDocLink;

	@FindBy(id = "SmarshCentralLink")
	WebElement smarshCenLink;

	// new add frm sagar
	
	@FindBy(id = "versiondialog")
	WebElement releaseNotesDialogue;
	
	@FindBy(xpath ="//a[contains(text(),'Do not show again')]")
    WebElement versiondialog_donotshow;
	
	@FindBy(xpath = "//div[contains(@class,'versiondialog_button button--primary data_button')]")
	WebElement closeRelNoteButton;
	
	@FindBy(xpath = "//a[contains(@class,'versiondialog_url')]")
	WebElement doNotShowRelNoteButton;
	
	@FindBy(id = "SignOut")
	WebElement signOutButton;
	
	@FindBy(id = "UserIcon")
	WebElement userAvatar; 

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//new test case for CCM-1151
	
	public boolean verifyReleaseNotification() throws InterruptedException {
		boolean relNoteDisp = false;
		if(releaseNotesDialogue.isDisplayed()) {
			System.out.println("Release Notification dialogue box is displayed.");
			closeRelNoteButton.click();
			Actions action = new Actions(driver);

			WebDriverWait wait = new WebDriverWait(driver, 60);
			Thread.sleep(1000);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("UserIcon")));
			action.moveToElement(userAvatar).perform();
			Thread.sleep(1000);
			action.moveToElement(signOutButton).click().perform();
			
			Thread.sleep(2000);
			driver.close();
					mobileGuardLogin();
					if(releaseNotesDialogue.isDisplayed()) {
						System.out.println("Release notification appeared again");
						doNotShowRelNoteButton.click();	
						action.moveToElement(userAvatar).perform();
						action.moveToElement(signOutButton).click().perform();
						mobileGuardLogin();
						if(releaseNotesDialogue.isDisplayed()) {
							System.out.println("Release notification appeared even Do not show was selected");
						} else {
							System.out.println("Release notification not displayed");
						}
						
					} else {
						System.out.println("Release notification didn't re-appear");
					}
			}
				
				
			
			
		 else {
			System.out.println("Release notification dialogue box is not displayed.");
		}
				
		
		return true;
	}

	public boolean verifyDashboard() {

		boolean dasboardIntact = false;
		String pageTitle = driver.getTitle();
		boolean correctTitle = pageTitle.equals("Dashboard");

		boolean searchPresent = searchDropdownLink.isDisplayed();
		if (!searchPresent) {
			System.out.println("Search option not present");
		}
		boolean employeesPresent = employeeLink.isDisplayed();
		if (!employeesPresent) {
			System.out.println("Employee option not present");
		}
		boolean reportsPresent = reportsDropdownLink.isDisplayed();
		if (!reportsPresent) {
			System.out.println("Reports option not present");
		}
		boolean messagesPresent = messagesLink.isDisplayed();
		if (!messagesPresent) {
			System.out.println("Messages options not present");
		}
		boolean callsPresent = callsLink.isDisplayed();
		if (!callsPresent) {
			System.out.println("Calls option is not present");
		}
		boolean administratorsPresent = administratorsLink.isDisplayed();
		if (!administratorsPresent) {
			System.out.println("Administrators option not present");
		}
		boolean alertsPresent = policyAlertsDropdownLink.isDisplayed();
		if (!alertsPresent) {
			System.out.println("Policy Alerts option not present");
		}
		boolean integrationsPresent = integrationsLink.isDisplayed();
		if (!integrationsPresent) {
			System.out.println("Integrations link not present");
		}
		boolean settingsPresent = settingsDropdownLink.isDisplayed();
		if (!settingsPresent) {
			System.out.println("Settings options not present");
		}
		boolean adminPresent = adminDropdownLink.isDisplayed();
		if (!adminPresent) {
			System.out.println("Admin options not present");
		}
		boolean userInfoPresent = userInfoDropdownLink.isDisplayed();
		if (!userInfoPresent) {
			System.out.println("User info details not present");
		}
		boolean callDetailsPresent = callDetails.isDisplayed();
		if (!callDetailsPresent) {
			System.out.println("Support call details not present");
		}
		boolean supportLinkPresent = supportLink.isDisplayed();
		if (!supportLinkPresent) {
			System.out.println("Support link not present");
		}
		boolean searchSecPresent = searchSection.isDisplayed();
		if (!searchSecPresent) {
			System.out.println("Search section not present");
		}
		boolean searchSecTextPresent = searchSecText.isDisplayed();
		if (!searchSecTextPresent) {
			System.out.println("Search text not present");
		}
		if (searchPresent && employeesPresent && reportsPresent && messagesPresent && callsPresent
				&& administratorsPresent && alertsPresent && integrationsPresent && settingsPresent && adminPresent
				&& userInfoPresent && callDetailsPresent && supportLinkPresent && searchSecPresent
				&& searchSecTextPresent && correctTitle) {
			dasboardIntact = true;
		}

		return dasboardIntact;
	}

	public void clickHome() {
		homeLink.click();
	}

	public void empSearch() throws InterruptedException {
		Thread.sleep(4000);
		searchTextBox.sendKeys("Sagar");
		submitBtn.click();
	}

	public void goToEmployees() {
		employeeLink.click();
	}

	public boolean verifyCopyRightDetailsOnDashboard() {

		boolean copyRightDetailsOnHome = false;

		String copyRightTextOnHome = cpyRightText.getText();
		System.out.println("Copy right text on home is " + copyRightTextOnHome);
		String verOnHome = versionNum.getText();
		String srcLink = openSrcLink.getText();
		/*
		 * String trimmedcopyRightTextOnHome = copyRightTextOnHome.substring(0,
		 * copyRightTextOnHome.); System.out.println("trimmed copy right details = " +
		 * trimmedcopyRightTextOnHome);
		 */

		if (copyRightTextOnHome.contains(System.getProperty("copyright"))) {

			System.out.println("Copy right is correctly displayed on home page");
		} else {
			System.out.println("Copy right text is not displayed correctly on home page");
			System.out.println("Copy right text should be " + System.getProperty("copyright"));
		}
		if (verOnHome.equalsIgnoreCase(System.getProperty("version"))) {
			System.out.println("Version number is correctly displayed on home page");
		} else {
			System.out.println("Version number is wrong on home page");
		}
		if (srcLink.equalsIgnoreCase("Open Source Attribution")) {
			System.out.println("Open source link is correctly displayed ");
		} else {
			System.out.println("Open source link is correctly displayed ");
		}
		if (copyRightTextOnHome.contains(System.getProperty("copyright"))
				&& verOnHome.equalsIgnoreCase(System.getProperty("version"))
				&& srcLink.equalsIgnoreCase("Open Source Attribution")) {
			copyRightDetailsOnHome = true;
		}
		return copyRightDetailsOnHome;
	}

	public boolean verifySrchWithMouseHovers() throws InterruptedException {

		boolean srchSubMenu = false;
		boolean srchEmp = false;
		Actions action = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, 60);
		int i = 0;
		while (true) {
			try {
				Thread.sleep(5000);
				System.out.println("Attempt : " + ++i);
				action.moveToElement(searchDropdownLink).perform();
				action.moveToElement(searchEmployees).click().perform();
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			break;
		}

		do {
			employeeGrid = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("EmployeeSearch")));
		} while (!employeeGrid.isDisplayed());

		String empSelectedAttribute = employeesTab.getAttribute("aria-selected");
		String empExpandedAttribute = employeesTab.getAttribute("aria-expanded");
		System.out.println("Emp tab selected" + empSelectedAttribute);
		System.out.println("Emp tab expanded" + empExpandedAttribute);
		boolean empTab1 = employeesTab.isDisplayed();
		System.out.println("emp tab displayed" + empTab1);
		boolean devTab1 = devicesTab.isDisplayed();
		System.out.println("device tab displayed" + devTab1);
		boolean msgTab1 = msgsTab.isDisplayed();
		System.out.println("Message tab displayed" + msgTab1);
		boolean employeeGrid1 = employeeGrid.isDisplayed();
		System.out.println("Employee grid" + employeeGrid1);
		boolean closeBtn1 = closeBtn.isDisplayed();
		System.out.println("Close button displayed" + closeBtn1);

		if (empSelectedAttribute.equalsIgnoreCase("true") && empExpandedAttribute.equalsIgnoreCase("true")
				&& employeeGrid.isDisplayed() && employeesTab.isDisplayed() && devicesTab.isDisplayed()
				&& msgsTab.isDisplayed() && closeBtn.isDisplayed()) {
			System.out.println("Search employee page is displayed after clicking on Employees option in Search navbar");
			srchEmp = true;
			closeBtn.click();
			Thread.sleep(2000);
			homeLink.click();
			Thread.sleep(2000);
		} else {
			System.out.println("Search Employee page is not displayed");
		}

		boolean srchDev = false;
		Thread.sleep(5000);
		i = 0;
		while (true) {
			try {
				Thread.sleep(5000);
				System.out.println("Attempt : " + ++i);
				action.moveToElement(searchDropdownLink).perform();
				// wait.until(ExpectedConditions.presenceOfElementLocated(By.id("NavSearchDevices")));
				action.moveToElement(searchDevices).click().perform();
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			break;
		}

		do {
			deviceGrid = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("DeviceSearch")));
		} while (!deviceGrid.isDisplayed());

		String devSelectedAttribute = devicesTab.getAttribute("aria-selected");
		String devExpandedAttribute = devicesTab.getAttribute("aria-expanded");
		if (devSelectedAttribute.equalsIgnoreCase("true") && devExpandedAttribute.equalsIgnoreCase("true")
				&& employeesTab.isDisplayed() && devicesTab.isDisplayed() && msgsTab.isDisplayed()
				&& deviceGrid.isDisplayed() && closeBtn.isDisplayed()) {
			System.out.println("Search device page is displayed after clicking on Devices option in Search navbar");
			srchDev = true;

			closeBtn.click();
			Thread.sleep(2000);
			homeLink.click();
			Thread.sleep(2000);
		} else {
			System.out.println("Search Device page is not displayed");
		}

		boolean srchMsgs = false;
		Thread.sleep(1000);

		i = 0;
		while (true) {
			try {
				Thread.sleep(5000);
				System.out.println("Attempt : " + ++i);
				action.moveToElement(searchDropdownLink).perform();
				action.moveToElement(searchMsgs).click().perform();
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			break;
		}

		do {
			msgsGrid = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MessageSearch")));
		} while (!msgsGrid.isDisplayed());

		String msgsSelectedAttribute = msgsTab.getAttribute("aria-selected");
		String msgsExpandedAttribute = msgsTab.getAttribute("aria-expanded");

		System.out.println("Msg tab selected" + msgsSelectedAttribute);
		System.out.println("Msg tab expanded" + msgsExpandedAttribute);
		boolean empTab2 = employeesTab.isDisplayed();
		System.out.println("emp tab displayed" + empTab2);
		boolean devTab2 = devicesTab.isDisplayed();
		System.out.println("device tab displayed" + devTab2);
		boolean msgTab2 = msgsTab.isDisplayed();
		System.out.println("Message tab displayed" + msgTab2);
		boolean msgGrid2 = msgsGrid.isDisplayed();
		System.out.println("Message grid displayed " + msgGrid2);
		boolean closeBtn2 = closeBtn.isDisplayed();
		System.out.println("Close button displayed" + closeBtn2);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MessageSearch")));
		if (msgsSelectedAttribute.equalsIgnoreCase("true") && msgsExpandedAttribute.equalsIgnoreCase("true")
				&& employeesTab.isDisplayed() && devicesTab.isDisplayed() && msgsTab.isDisplayed()
				&& msgsGrid.isDisplayed() && closeBtn.isDisplayed()) {
			System.out.println("Search msgs page is displayed after clicking on Devices option in Search navbar");
			srchMsgs = true;

			closeBtn.click();
			Thread.sleep(2000);
			homeLink.click();
			Thread.sleep(2000);
		} else {
			System.out.println("Search message page is not displayed");
		}
		if (srchEmp && srchDev && srchMsgs) {
			System.out.println("All the child pages are displayed correctly");
			srchSubMenu = true;
		}
		return srchSubMenu;
	}

	// Reports drop down nav bar

	// Call Reports

	public boolean verifyRreportsWithmouseHover() throws InterruptedException {

		boolean reportSubMenu = false;
		boolean callReports = false;
		Thread.sleep(1000);

		Actions action = new Actions(driver);
		/* action.moveToElement(reportsDropdownLink).perform(); */
		WebDriverWait wait = new WebDriverWait(driver, 60);
		int i = 0;
		while (true) {
			try {
				Thread.sleep(5000);
				System.out.println("Attempt : " + ++i);
				action.moveToElement(reportsDropdownLink).perform();
				action.moveToElement(callReportsSubMenu).click().perform();
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			break;
		}

		Thread.sleep(2000);
		String dispURL = driver.getCurrentUrl();
		System.out.println("url = " + dispURL);
		if (dispURL.equals("https://qa.mobileguard.com/reporting/call")) {
			System.out.println("On Call Reports page");
			callReports = true;
		} else {
			System.out.println("Nvaigated to wrong page");
		}

		/*do {
			callReportGrid = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_DataGrid")));
		} while (!callReportGrid.isDisplayed());*/

		String pageTitle1 = driver.getTitle();
		System.out.println("Page title is " + pageTitle1);
		if (pageTitle1.equals("Call Reports")) {
			System.out.println("On Call Reports page");
			callReports = true;
		} else {
			System.out.println("Call Reports page not displayed");
		}
		reportsDropdownLink.click();

		// Custom Reports..................................................

		boolean cutsomReports = false;
		Thread.sleep(1000);
		/*
		 * action.moveToElement(reportsDropdownLink).perform();
		 * action.moveToElement(customReportsSubMenu).click().perform();
		 */
		i = 0;
		while (true) {
			try {
				Thread.sleep(5000);
				System.out.println("Attempt : " + ++i);
				action.moveToElement(reportsDropdownLink).perform();
				action.moveToElement(customReportsSubMenu).click().perform();
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			break;
		}
/*
		do {
			customReportFilterSection = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_FilterForm")));
		} while (!customReportFilterSection.isDisplayed());*/
		Thread.sleep(2000);
		String pageTitle2 = driver.getTitle();
		System.out.println("Page title is " + pageTitle2);
		if (pageTitle2.equals("Custom Reports")) {
			System.out.println("On custom reports page");
			cutsomReports = true;
		} else {
			System.out.println("Custom Reports page not displayed");
		}
		reportsDropdownLink.click();
		// Device reports.............................................

		boolean devReports = false;
		Thread.sleep(1000);
		/*
		 * action.moveToElement(reportsDropdownLink).perform();
		 * action.moveToElement(deviceReportsSubMenu).click().perform();
		 */
		i = 0;
		while (true) {
			try {
				Thread.sleep(5000);
				System.out.println("Attempt : " + ++i);
				action.moveToElement(reportsDropdownLink).perform();
				action.moveToElement(deviceReportsSubMenu).click().perform();
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			break;
		}

		/*do {
			devReportSection = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Device Reports')]")));
		} while (!devReportSection.isDisplayed());*/
		Thread.sleep(2000);
		String pageTitle3 = null;
		int count = 0;
		do {
			pageTitle3 = driver.getTitle().trim();
			Thread.sleep(1000);
			System.out.println("re-attempt : " + count++);
		} while (pageTitle3.length() == 0);

		pageTitle3 = driver.getTitle();
		System.out.println("Page title is " + pageTitle3);
		if (pageTitle3.equals("Device Reports")) {
			System.out.println("On Device Reports page");
			devReports = true;
		} else {
			System.out.println("Device Reports page not displayed");
		}

		reportsDropdownLink.click();
		// Employee Reports...................................

		boolean empReports = false;
		Thread.sleep(1000);
		/*
		 * action.moveToElement(reportsDropdownLink).perform();
		 * action.moveToElement(empReportsSubMenu).click().perform();
		 */
		i = 0;
		while (true) {
			try {
				Thread.sleep(5000);
				System.out.println("Attempt : " + ++i);
				action.moveToElement(reportsDropdownLink).perform();
				action.moveToElement(empReportsSubMenu).click().perform();
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			break;
		}

	/*	do {
			empReportGrid = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_DataGrid")));
		} while (!empReportGrid.isDisplayed());*/
		Thread.sleep(2000);
		String pageTitle4 = driver.getTitle();
		System.out.println("Page title is " + pageTitle4);
		if (pageTitle4.equals("Employee Reports")) {
			System.out.println("On Employee Reports page");
			empReports = true;
		} else {
			System.out.println("Employee Reports page not displayed");
		}
		reportsDropdownLink.click();
		// Msg download report.......................

		boolean msgDwnldReports = false;
		Thread.sleep(1000);
		/*
		 * action.moveToElement(reportsDropdownLink).perform();
		 * action.moveToElement(msgDwnldReportSubMenu).click().perform();
		 */
		i = 0;
		while (true) {
			try {
				Thread.sleep(5000);
				System.out.println("Attempt : " + ++i);
				action.moveToElement(reportsDropdownLink).perform();
				action.moveToElement(msgDwnldReportSubMenu).click().perform();
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			break;
		}

		/*do {
			msgDownloadReportsSection = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_Label4")));
		} while (!msgDownloadReportsSection.isDisplayed());*/
		Thread.sleep(2000);
		String pageURL = driver.getCurrentUrl();
		if(pageURL.contains("messagedownload")) 

		/*if (msgDownloadReportsSection.isDisplayed())*/ {
			System.out.println("On Message download Reports page");
			msgDwnldReports = true;
		} else {
			System.out.println("Message download Reports page not displayed");
		}

		// Message Reports..............................

		boolean msgReports = false;
		Thread.sleep(1000);
		/*
		 * action.moveToElement(reportsDropdownLink).perform();
		 * action.moveToElement(msgReportsSubMenu).click().perform();
		 */
		i = 0;
		while (true) {
			try {
				Thread.sleep(5000);
				System.out.println("Attempt : " + ++i);
				action.moveToElement(reportsDropdownLink).perform();
				action.moveToElement(msgReportsSubMenu).click().perform();
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			break;
		}

		/*do {
			msgReportGrid = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_DataGrid")));
		} while (!msgReportGrid.isDisplayed());*/

		String pageTitle5 = null;
		count = 0;
		do {
			pageTitle5 = driver.getTitle().trim();
			Thread.sleep(1000);
			System.out.println("re-attempt : " + count++);
		} while (pageTitle5.length() == 0);

		System.out.println("Page title is " + pageTitle5);
		if (pageTitle5.equalsIgnoreCase("Message Reports")) {
			System.out.println("On Message Reports page");
			msgReports = true;
		} else {
			System.out.println("Message Reports page not displayed");
		}
		reportsDropdownLink.click();
		// System Reports...............................

		boolean systemReports = false;
		Thread.sleep(1000);
		/*
		 * action.moveToElement(reportsDropdownLink).perform();
		 * action.moveToElement(sysReportsSubMenu).click().perform();
		 */
		i = 0;
		while (true) {
			try {
				Thread.sleep(5000);
				System.out.println("Attempt : " + ++i);
				action.moveToElement(reportsDropdownLink).perform();
				action.moveToElement(sysReportsSubMenu).click().perform();
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			break;
		}

		/*do {
			sysReportGrid = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_DataGrid")));
		} while (!sysReportGrid.isDisplayed());*/
		Thread.sleep(2000);
		String pageTitle6 = driver.getTitle();
		System.out.println("Page title is " + pageTitle6);
		if (pageTitle6.equals("System Reports")) {
			System.out.println("On System Reports page");
			systemReports = true;
		} else {
			System.out.println("System Reports page not displayed");
		}
		reportsDropdownLink.click();
		if (callReports && cutsomReports && devReports && empReports && msgDwnldReports && msgReports
				&& systemReports) {
			System.out.println("All reports sub pages are displayed correctly");
			reportSubMenu = true;
		}
		return reportSubMenu;
	}

	// Alerts....................
	public boolean verifyAlertsWithMouseHover() throws InterruptedException {

		boolean alertsSubMenu = false;
		boolean alertSettingsSubMenu = false;
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Actions action = new Actions(driver);
		policyAlertsDropdownLink.click();
		int i = 0;
		while (true) {
			try {
				Thread.sleep(5000);
				System.out.println("Attempt : " + ++i);
				action.moveToElement(policyAlertsDropdownLink).perform();
				action.moveToElement(alertSetting).click().perform();
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			break;
		}
		i = 0;
		do {
			wordPolicySection = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_Word_SectionContainer")));
			phrasePolicySection = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_Phrase_SectionContainer")));
			patternPolicySection = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_Pattern_SectionContainer")));
			manualPolicySection = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_Manual_SectionContainer")));
			if (i++ == 20) {
				System.out.println("Max attempts reached and page could not be found");
				break;
			}
		} while (!(wordPolicySection.isDisplayed() && phrasePolicySection.isDisplayed()
				&& patternPolicySection.isDisplayed() && manualPolicySection.isDisplayed()));

		if (wordPolicySection.isDisplayed() && phrasePolicySection.isDisplayed() && patternPolicySection.isDisplayed()
				&& manualPolicySection.isDisplayed()) {
			alertSettingsSubMenu = true;
			System.out.println("On Policy Alert Settings page");
		} else {
			System.out.println("Policy Alert Settings page not displayed");
		}

		policyAlertsDropdownLink.click();

		boolean alertsViewSubMenu = false;
		action.moveToElement(policyAlertsDropdownLink).perform();
		i = 0;
		while (true) {
			try {
				Thread.sleep(5000);
				System.out.println("Attempt : " + ++i);
				action.moveToElement(policyAlertsDropdownLink).perform();
				action.moveToElement(alertView).click().perform();
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			break;
		}
		i = 0;
		do {
			viewAlertGrid = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_SectionContainer")));
			alertGridContents = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_DataPoint")));
			if (i++ == 20) {
				System.out.println("Max attempts reached and page could not be found");
				break;
			}
		} while (!(viewAlertGrid.isDisplayed() && alertGridContents.isDisplayed()));

		if (viewAlertGrid.isDisplayed() && alertGridContents.isDisplayed()) {
			System.out.println("On View Alerts page");
			alertsViewSubMenu = true;
		} else {
			System.out.println("View Alerts page not displayed");
		}

		if (alertSettingsSubMenu && alertsViewSubMenu) {
			System.out.println("Alerts sub menu are displayed");
			alertsSubMenu = true;
		} else {
			System.out.println("Alerts sub menu are not displayed");
		}
		return alertsSubMenu;
	}
	// Max attempt method........................
	/*
	 * public void maxAttempts() throws InterruptedException { int attempt = 0;
	 * Thread.sleep(1000); System.out.println("re-attempt : " + attempt++);
	 * if(attempt++ == 20) {
	 * System.out.println("Max attempts reached and page has not loaded properly");
	 * } }
	 */

	// Settings......................................
	// .................System Settings...........................
	public boolean verifySettingsWithMouseHover() throws InterruptedException {
		boolean settingsSubMenu = false;
		boolean systemSettings = false;
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Actions action = new Actions(driver);
		settingsDropdownLink.click();
		int i = 0;
		while (true) {
			try {
				Thread.sleep(5000);
				System.out.println("Attempt : " + ++i);
				action.moveToElement(settingsDropdownLink).perform();
				action.moveToElement(sysSettSubMenu).click().perform();
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			break;
		}
		i = 0;
		do {
			sysSettingsSection = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_SettingPanel")));
			samlSettingsSection = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_OneLoginSAMLPanel")));
			activeDirSettingsSection = wait.until(
					ExpectedConditions.presenceOfElementLocated(By.id("MainContent_ActiveDirectorySettingsPanel")));
			// devGuardSettingsSection =
			// wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_DeviceGuardPanel")));
			proxSettingsSection = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_Panel1")));
			ftpSettingsSection = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_Panel4")));
			if (i++ == 20) {
				System.out.println("Max attempts reached and page could not be found");
				break;
			}
		} while (!(sysSettingsSection.isDisplayed() && samlSettingsSection.isDisplayed()
				&& activeDirSettingsSection.isDisplayed() && /* devGuardSettingsSection.isDisplayed() && */
				proxSettingsSection.isDisplayed() && ftpSettingsSection.isDisplayed()));

		if (sysSettingsSection.isDisplayed() && samlSettingsSection.isDisplayed()
				&& activeDirSettingsSection.isDisplayed() && /* devGuardSettingsSection.isDisplayed() && */
				proxSettingsSection.isDisplayed() && ftpSettingsSection.isDisplayed()) {
			System.out.println("On System settings page");
			systemSettings = true;
		}
		settingsDropdownLink.click();

		// ....... Carrier settings..........................
		boolean carrierSettings = false;
		settingsDropdownLink.click();
		i = 0;
		while (true) {
			try {
				Thread.sleep(5000);
				System.out.println("Attempt : " + ++i);
				action.moveToElement(settingsDropdownLink).perform();
				action.moveToElement(carrierSettSubMenu).click().perform();
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			break;
		}
		i = 0;
		do {
			atnTSection = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_Label13")));
			vodafoneSection = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_ContentTitle")));
			hutchSection = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_HutchLabel")));
			truePhoneSection = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_TruphoneLabel")));
			rogersSection = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_RogersLabel")));
			usCellularSection = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_UsccLabel")));
			verizonSection = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_Label6")));
			if (i++ == 20) {
				System.out.println("Max attempts reached and page could not be found");
				break;
			}
		} while (!(atnTSection.isDisplayed() && vodafoneSection.isDisplayed() && hutchSection.isDisplayed()
				&& truePhoneSection.isDisplayed() && rogersSection.isDisplayed() && usCellularSection.isDisplayed()
				&& verizonSection.isDisplayed()));

		if (atnTSection.isDisplayed() && vodafoneSection.isDisplayed() && hutchSection.isDisplayed()
				&& truePhoneSection.isDisplayed() && rogersSection.isDisplayed() && usCellularSection.isDisplayed()
				&& verizonSection.isDisplayed()) {
			System.out.println("On Carrier settings page");
			carrierSettings = true;
		} else {
			System.out.println("Carrier settings page not displayed");
		}
		settingsDropdownLink.click();

		// ...................Employee settings........................

		boolean empSettings = false;
		settingsDropdownLink.click();

		i = 0;
		while (true) {
			try {
				Thread.sleep(5000);
				System.out.println("Attempt : " + ++i);
				action.moveToElement(settingsDropdownLink).perform();
				action.moveToElement(empSettSubMenu).click().perform();
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			break;
		}
		i = 0;
		int numOfElemInHeartbeat = 0;
		do {
			List<WebElement> heartbeatSectionElements = wait.until(ExpectedConditions
					.presenceOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'Heartbeat')]")));
			numOfElemInHeartbeat = heartbeatSectionElements.size();
			empRegSectionHeading = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_DialogTitle")));
			empRegSectionBody = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_SectionContent")));
			ldapIntegSettSectionHeading = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//span[contains(text(),'LDAP Integration')]")));
			ldapIntegSettSectionBody = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_Panel6")));
			crmIntegSection = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.id("MainContent_PanelWebServiceEmailPhoneNumberMapping")));
			convThreadSection = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_Panel9")));
			if (i++ == 20) {
				System.out.println("Max attempts reached and page could not be found");
				break;
			}
		} while (!(empRegSectionHeading.isDisplayed() && empRegSectionBody.isDisplayed()
				&& ldapIntegSettSectionHeading.isDisplayed() && ldapIntegSettSectionBody.isDisplayed()
				&& crmIntegSection.isDisplayed() && convThreadSection.isDisplayed() && (numOfElemInHeartbeat == 0)));

		if (empRegSectionHeading.isDisplayed() && empRegSectionBody.isDisplayed()
				&& ldapIntegSettSectionHeading.isDisplayed() && ldapIntegSettSectionBody.isDisplayed()
				&& crmIntegSection.isDisplayed() && convThreadSection.isDisplayed() && (numOfElemInHeartbeat == 3)) {
			System.out.println("Employee settings page is displayed");
			empSettings = true;
		} else {
			System.out.println("Employee setting page is not displayed");
		}
		settingsDropdownLink.click();

		// ..........Device settings...........
		boolean devSettings = false;
		settingsDropdownLink.click();

		i = 0;
		while (true) {
			try {
				Thread.sleep(5000);
				System.out.println("Attempt : " + ++i);
				action.moveToElement(settingsDropdownLink).perform();
				action.moveToElement(devSettSubMenu).click().perform();
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			break;
		}

		i = 0;
		do {
			mobClientUninstallSectionHeading = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_DialogTitle")));
			mobClientUninstallSectionBody = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_EntForm")));
			iPhoneSettSectionHeading = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//span[contains(text(),'iPhone Settings')]")));
			iphoneSettSectionBody = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_IPhone")));
			mobSupInfoSectionHeading = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//span[contains(text(),'Mobile Support Information')]")));
			mobSupInfoSectionBody = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_SupportForm")));
			if (i++ == 20) {
				System.out.println("Max attempts reached and page could not be found");
				break;
			}
		} while (!(mobClientUninstallSectionHeading.isDisplayed() && mobClientUninstallSectionBody.isDisplayed()
				&& iPhoneSettSectionHeading.isDisplayed() && iphoneSettSectionBody.isDisplayed()
				&& mobSupInfoSectionHeading.isDisplayed() && mobSupInfoSectionBody.isDisplayed()));

		if (mobClientUninstallSectionHeading.isDisplayed() && mobClientUninstallSectionBody.isDisplayed()
				&& iPhoneSettSectionHeading.isDisplayed() && iphoneSettSectionBody.isDisplayed()
				&& mobSupInfoSectionHeading.isDisplayed() && mobSupInfoSectionBody.isDisplayed()) {
			devSettings = true;
			System.out.println("Device settings page displayed");
		} else {
			System.out.println("Device settings page not displayed");
		}
		settingsDropdownLink.click();

		if (systemSettings && carrierSettings && empSettings && devSettings) {
			settingsSubMenu = true;
			System.out.println("All settings submenu are displayed");
		} else {
			System.out.println("Settings sub menu pages are not displayed");
		}
		return settingsSubMenu;
	}

	// ...................Admin...................................
	public boolean verifyAdminWithMouseHover() {
		boolean adminSubMenu = false;
		boolean sysLogs = false;
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Actions action = new Actions(driver);

		adminDropdownLink.click();
		int i = 0;
		while (true) {
			try {
				Thread.sleep(5000);
				System.out.println("Attempt : " + ++i);
				action.moveToElement(adminDropdownLink).perform();
				action.moveToElement(sysLogsLink).click().perform();
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			break;
		}
		i = 0;
		do {
			sysLogPanel = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_SyslogPanel")));
			filterSecHeading = wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id = 'MainContent_DialogTitle']")));
			submitFilterBtn = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_FilterForm_SubmitButton")));
			cancelFilterBtn = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_FilterForm_CancelButton")));
			downloadLogBtn = wait.until(
					ExpectedConditions.presenceOfElementLocated(By.id("MainContent_FilterForm_DoDownload_Click")));
			sysLogSecHeading = wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'System Log')]")));
			logGrid = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_GridNow")));
			if (i++ == 20) {
				System.out.println("Max attempts reached and page could not be found");
				break;
			}
		} while (!(sysLogPanel.isDisplayed() && filterSecHeading.isDisplayed() && submitFilterBtn.isDisplayed()
				&& cancelFilterBtn.isDisplayed() && downloadLogBtn.isDisplayed() && sysLogSecHeading.isDisplayed()
				&& logGrid.isDisplayed()));

		if (sysLogPanel.isDisplayed() && filterSecHeading.isDisplayed() && submitFilterBtn.isDisplayed()
				&& cancelFilterBtn.isDisplayed() && downloadLogBtn.isDisplayed() && sysLogSecHeading.isDisplayed()
				&& logGrid.isDisplayed()) {
			sysLogs = true;
			System.out.println("System Logs page displayed");
		} else {
			System.out.println("System logs page not displayed");
		}
		adminDropdownLink.click();
		// ....................System tools.....................
		boolean sysTools = false;
		adminDropdownLink.click();
		i = 0;
		while (true) {
			try {
				Thread.sleep(5000);
				System.out.println("Attempt : " + ++i);
				action.moveToElement(adminDropdownLink).perform();
				action.moveToElement(sysToolsLink).click().perform();
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			break;
		}
		i = 0;
		do {
			markupBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_DoMarkup")));
			ldapCheckbtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_DoLDAPCheck")));
			ghostAdminBtn = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//span[contains(text(),'Enable Ghost Admin')]")));
			restartAtnTBtn = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_DoAttProcessRestartNow")));
			mobAppConfigSectionHeading = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//span[contains(text(),'Mobile Application Configuration')]")));
			mobAppConfigTextArea = wait.until(
					ExpectedConditions.presenceOfElementLocated(By.id("MainContent_MobileAppConfigForm_ConfigXML")));
			dataEncryptSectionHeading = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//span[contains(text(),'Data Encryption')]")));
			encryptText = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//span[contains(text(),'AES 256 is used to encrypt')]")));
			encryptBtn = wait.until(
					ExpectedConditions.presenceOfElementLocated(By.id("MainContent_EncryptionKeyForm_SubmitButton")));
			if (i++ == 20) {
				System.out.println("Max attempts reached and page could not be found");
				break;
			}
		} while (!(markupBtn.isDisplayed() && ldapCheckbtn.isDisplayed() && ghostAdminBtn.isDisplayed()
				&& restartAtnTBtn.isDisplayed() && mobAppConfigSectionHeading.isDisplayed()
				&& mobAppConfigTextArea.isDisplayed() && dataEncryptSectionHeading.isDisplayed()
				&& encryptText.isDisplayed() && encryptBtn.isDisplayed()));

		if (markupBtn.isDisplayed() && ldapCheckbtn.isDisplayed() && ghostAdminBtn.isDisplayed()
				&& restartAtnTBtn.isDisplayed() && mobAppConfigSectionHeading.isDisplayed()
				&& mobAppConfigTextArea.isDisplayed() && dataEncryptSectionHeading.isDisplayed()
				&& encryptText.isDisplayed() && encryptBtn.isDisplayed() && msgExportBtn.isDisplayed()
				&& mobileIronServBtn.isDisplayed() && sysHealthReportBtn.isDisplayed() && staticServBtn.isDisplayed()
				&& updateDBBtn.isDisplayed() && submitVMAPBtn.isDisplayed() && restartVerizonBtn.isDisplayed()
				&& dwnldVzwBtn.isDisplayed() && vzwImporterBtn.isDisplayed() && queryExecBtn.isDisplayed()
				&& encryptCancelBtn.isDisplayed()) {
			sysTools = true;
			System.out.println("System tools page is displayed");
		} else {
			System.out.println("System tools page is not diaplayed");
		}

		if (sysLogs && sysTools) {
			System.out.println("Admin sub menu pages are displayed");
			adminSubMenu = true;
		} else {
			System.out.println("Admin sub menu pages are not displayed");
		}
		return adminSubMenu;
	}

	public boolean verifyNavBarNavigations() {

		boolean correctNavigation = false;

		homeLink.click();
		String homeTitle = driver.getTitle();
		searchDropdownLink.click();
		String homeTitle1 = driver.getTitle();
		employeeLink.click();
		String empPageTitle = driver.getTitle();
		reportsDropdownLink.click();
		String reportsPageTitle = driver.getTitle();
		messagesLink.click();
		String msgsagesPageTitle = driver.getTitle();
		callsLink.click();
		String callsPagesTitle = driver.getTitle();
		administratorsLink.click();
		String administratorPageTitle = driver.getTitle();
		policyAlertsDropdownLink.click();
		String alertsPageTitle = driver.getTitle();
		integrationsLink.click();
		String integrationPageTitle = driver.getTitle();
		settingsDropdownLink.click();
		String settingsPageTitle = driver.getTitle();
		adminDropdownLink.click();
		String adminPageTitle = driver.getTitle();

		if (homeTitle.equals("Dashboard") && homeTitle1.equals("Dashboard") && empPageTitle.equals("Employees")
				&& reportsPageTitle.equals("Reports") && msgsagesPageTitle.equals("Messages")
				&& callsPagesTitle.equals("Calls") && administratorPageTitle.equals("Administrators")
				&& alertsPageTitle.equals("View Alerts") && integrationPageTitle.equals("Integrations")
				&& settingsPageTitle.equals("System Settings") && adminPageTitle.equals("Admin")) {
			correctNavigation = true;
			System.out.println("All navigations from dashboard using the navbar options are correct");
		} else {
			System.out.println("Navigations are broken");
		}
		return correctNavigation;

	}

	// new sagar function

	// 06th Aug New code to be merged with Chandan's code

	public boolean verifyOpenSrcLinks() throws InterruptedException {
		boolean thirdPartyLinksIntact = false;
		if (openSrchLink.isDisplayed()) {
			openSrchLink.click();
			
			String firstParentWindow = driver.getWindowHandle();
			openSrchLink.click();
			Thread.sleep(2000);
			ArrayList tabs = new ArrayList(driver.getWindowHandles());
			System.out.println(tabs.size());
			driver.switchTo().window((String) tabs.get(1));		
			
			Thread.sleep(2000);
			String curURL = driver.getCurrentUrl();
			if (curURL.equals(System.getProperty("url") + "attribution")) {
				System.out.println("Attribution page successfully opened.");
				if (emojiOneLink.isEnabled() && twitterEmojiLink.isEnabled() && designIconLink.isEnabled()) {
					System.out.println("All the attribution links are displayed properly");
					String parentWindow = driver.getWindowHandle();
					emojiOneLink.click();
					Thread.sleep(3000);
					/*
					 * ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
					 * driver.switchTo().window(tabs2.get(1)); driver.close();
					 * driver.switchTo().window(tabs2.get(0));
					 */

					System.out.println("Parent window handle is " + parentWindow);

					Set<String> openWindows = driver.getWindowHandles();
					String newWindow = "";
					for (String element : openWindows) {
						if (!element.equals(parentWindow)) {
							newWindow = element;
						}
					}

					driver.switchTo().window(newWindow);

					System.out.println(driver.getTitle());
					String url1 = driver.getCurrentUrl();
					System.out.println(url1);
					System.out.println(driver.getWindowHandle());
					driver.close();
					Thread.sleep(2000);
					driver.switchTo().window(parentWindow);
					System.out.println(driver.getCurrentUrl());
					twitterEmojiLink.click();
					Thread.sleep(3000);
					openWindows = driver.getWindowHandles();
					newWindow = "";
					for (String element : openWindows) {
						if (!element.equals(parentWindow)) {
							newWindow = element;
						}
					}

					driver.switchTo().window(newWindow);

					System.out.println(driver.getTitle());
					String url2 = driver.getCurrentUrl();
					System.out.println(url2);
					System.out.println(driver.getWindowHandle());
					driver.close();
					Thread.sleep(2000);
					driver.switchTo().window(parentWindow);
					System.out.println(driver.getCurrentUrl());
					designIconLink.click();
					Thread.sleep(3000);
					openWindows = driver.getWindowHandles();
					newWindow = "";
					for (String element : openWindows) {
						if (!element.equals(parentWindow)) {
							newWindow = element;
						}
					}

					driver.switchTo().window(newWindow);

					System.out.println(driver.getTitle());
					String url3 = driver.getCurrentUrl();
					System.out.println(url3);
					System.out.println(driver.getWindowHandle());
					driver.close();
					Thread.sleep(2000);
					driver.switchTo().window(parentWindow);
					System.out.println(driver.getCurrentUrl());
					if (url1.equals("https://www.joypixels.com/") && url2.equals("https://github.com/twitter/twemoji")
							&& url3.equals("https://material.io/resources/icons/?style=baseline")) {
						System.out.println("All the third party links are intact");
						thirdPartyLinksIntact = true;
					}
				}
			}
		}

		return thirdPartyLinksIntact;
	}
	// .............................END...............................................

	// new sagar function

	public boolean verifyDocLinks() throws InterruptedException {
		boolean isDocLinksCorrect = false;
		Actions action = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, 60);
		Thread.sleep(5000);
		// System.out.println("Attempt : " + ++i);
		action.moveToElement(userIcon).perform();
		action.moveToElement(mgDocLink).click().perform();

		String parentWindow = driver.getWindowHandle();
		Thread.sleep(2000);
		// driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		ArrayList tabs = new ArrayList(driver.getWindowHandles());
		System.out.println(tabs.size());
		driver.switchTo().window((String) tabs.get(1));
		String currURL1 = driver.getCurrentUrl();
		System.out.println("Current url 1 = " + currURL1);
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(parentWindow);
		String mainWinURl = driver.getCurrentUrl();
		System.out.println(mainWinURl);
		Thread.sleep(2000);
		//driver.close();
		

		if (currURL1.equals("https://docs.smarsh.com/")) {
			System.out.println("navigated to correct links");
			isDocLinksCorrect = true;
		}

		return isDocLinksCorrect;

	}
	public boolean verifySmarshCenLink() throws InterruptedException {
		boolean isCentralLinksCorrect = false;
		
		Actions action = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, 60);
		Thread.sleep(5000);
		// System.out.println("Attempt : " + ++i);
		action.moveToElement(userIcon).perform();
		action.moveToElement(smarshCenLink).click().perform();

		String parentWindow = driver.getWindowHandle();
		Thread.sleep(2000);
		// driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		ArrayList tabs = new ArrayList(driver.getWindowHandles());
		System.out.println(tabs.size());
		
		driver.switchTo().window((String) tabs.get(1));
		Thread.sleep(2000);
		String currURL2 = driver.getCurrentUrl();
		System.out.println("Current url 1 = " + currURL2);
		//driver.close();
		
		 if(currURL2.equals("https://central.smarsh.com/s/")) {
			 System.out.println("navigated to correct links");
				isCentralLinksCorrect = true;
			}

			return isCentralLinksCorrect;
		 }
	

}
