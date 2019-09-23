package com.smarsh.ccm.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.smarsh.ccm.testEmployees.MGBasicTests;
import com.smarsh.ccm.utils.EmployeesGetSet;

public class AddNewEmpPage extends TestBase {
	protected static Logger
	logger = LogManager.getLogger(AddNewEmpPage.class);

	WebDriver driver;
	
	public AddNewEmpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id = "MainContent_DialogTitle")
	WebElement addEmpSection;
	
	@FindBy(id = "MainContent_EmpForm_EmployeeID")
	WebElement idTextBox;
	
	@FindBy(id = "MainContent_EmpForm_DeviceAssociatedID")
	WebElement associatedDevIDTextBox;
	
	@FindBy(id = "MainContent_EmpForm_Name")
	WebElement nameTextBox;
	
	@FindBy(id = "MainContent_EmpForm_Email")
	WebElement emailTextBox;
	
	@FindBy(id = "MainContent_EmpForm_Department")
	WebElement departmentDropDown;
	
	@FindBy(id = "MainContent_EmpForm_Status")
	WebElement regStatusDropDown;
	
	@FindBy(id = "MainContent_EmpForm_CreateNetGuardDevice")
	WebElement netGuardDeviceDropDown;
	
	@FindBy(id = "MainContent_EmpForm_VzwSettingId")
	WebElement verizonSettDropdown;
	
	@FindBy(id = "MainContent_EmpForm_SubmitButton")
	WebElement addButton;
	
	@FindBy(id = "MainContent_EmpForm_CancelButton")
	WebElement cancelBtn;
	
	@FindBy(id = "MainContent_Label5")
	WebElement addNewEmpParentLink;
	
	@FindBy(id = "MainContent_EntForm_Match")
	WebElement searchEmailTextBox;
	
	@FindBy(id = "MainContent_EmpForm_ErrMsg")
	WebElement addEmpErrorMsg;
	
	@FindBy(xpath = "//span[@id = 'MainContent_EmpForm_ErrMsg']//p[contains(text(),'blank')]")
	WebElement errorMsg;
	
	@FindBy(xpath = "//span[@id = 'MainContent_EmpForm_ErrMsg']//p[contains(text(),'already')]")
	WebElement errorMsg1;
	
	@FindBy(xpath = "//span[@id = 'MainContent_EmpForm_ErrMsg']//p[contains(text(),'Associated Device ID.')]")
	WebElement errorMsg2;
	
	@FindBy(id = "MainContent_Label5")
	WebElement addNewEmpLink;
	
	@FindBy(id = "MainContent_EntForm_Match")
	WebElement searchEmail;
	
	@FindBy(id = "MainContent_GridNow")
	WebElement empGrid;
	
	@FindBy(id = "MainContent_EntForm_SubmitButton")
	WebElement searchBtn;
	
	@FindBy(xpath = "//table[@id = 'MainContent_GridNow']//tbody//tr[2]//td//p")
	WebElement empSrchRes;
	
	
	public boolean verifyAddEmpPage() {
		boolean isCorrectPageDisp = addEmpSection.isDisplayed();
		return isCorrectPageDisp;
	}
	
	public void addAnEmp(EmployeesGetSet employee) throws InterruptedException {
		
		Thread.sleep(1000);
		idTextBox.sendKeys(employee.getId());
		
		associatedDevIDTextBox.sendKeys(employee.getAssDevID());
		
		nameTextBox.sendKeys(employee.getName());
		
		emailTextBox.sendKeys(employee.getEmail());

		Select dept = new Select(departmentDropDown);
		dept.selectByVisibleText(employee.getDepartment());
		
		Select regStatus = new Select(regStatusDropDown);
		regStatus.selectByVisibleText(employee.getRegStatus());
		
		Select netGuardDev = new Select(netGuardDeviceDropDown);
		netGuardDev.selectByVisibleText(employee.getNetGuardDev());
		
		Select vzwSettings = new Select(verizonSettDropdown);
		vzwSettings.selectByVisibleText(employee.getVerizonSet());
		
		addButton.click();

	}
	
	public void addToEditEmp() {
		idTextBox.sendKeys("74");
		associatedDevIDTextBox.sendKeys("74");
		nameTextBox.sendKeys("AddEmp");
		emailTextBox.sendKeys("addemp74@smarsh.com");
		Select department = new Select(departmentDropDown);
		department.selectByVisibleText("QA");
		Select registrationStatus = new Select(regStatusDropDown);
		registrationStatus.selectByVisibleText("Created");
		Select netGuard = new Select(netGuardDeviceDropDown);
		netGuard.selectByVisibleText("AT&T");
		Select verizonSett = new Select(verizonSettDropdown);
		verizonSett.selectByVisibleText("-- SELECT ONE --");
		addButton.click();
	
	}
	
	public boolean addEmpWithoutEmail() {
		
		boolean correctErrorMsg = false;
		
		idTextBox.sendKeys("01010101");
		associatedDevIDTextBox.sendKeys("0101001001");
		nameTextBox.sendKeys("NoEmailEmp");
		emailTextBox.sendKeys("");
		Select department = new Select(departmentDropDown);
		department.selectByVisibleText("QA");
		Select registrationStatus = new Select(regStatusDropDown);
		registrationStatus.selectByVisibleText("Registered");
		Select netGuard = new Select(netGuardDeviceDropDown);
		netGuard.selectByVisibleText("AT&T");
		Select verizonSett = new Select(verizonSettDropdown);
		verizonSett.selectByVisibleText("-- SELECT ONE --");
		addButton.click();
		
		if(addEmpErrorMsg.isDisplayed()) {
			
			String errorMessage = errorMsg.getText();
			
			if(errorMessage.equals("Employee email address cannot be blank.")) {
				logger.debug("AAAAAA");
				logger.info("'Employee email address cannot be blank' error message displayed for leaving email field empty");
				System.out.println("'Employee email address cannot be blank' error message displayed for leaving email field empty");
				correctErrorMsg = true;
			}
		}
		return correctErrorMsg;
	}
	// Change the parameter values in config.properties file, Update email id and associated device id
	
	public boolean addEmpWithDuplicateEmailOrDev() throws InterruptedException {
		
		boolean empNotAdded = false;
		boolean empWithDupEmails = false;
		boolean empWithDupDevId = false;
		
		//Emp addition
		emailTextBox.clear();
		emailTextBox.sendKeys(getObject("empEmail1"));
		logger.info(getObject("empEmail1"));
		
		associatedDevIDTextBox.clear();
		associatedDevIDTextBox.sendKeys(getObject("deviceId1"));
		addButton.click();
		Thread.sleep(2000);
		addNewEmpLink.click();
		
		//Emp addition failure due to duplicate email
		emailTextBox.clear();
		emailTextBox.sendKeys(getObject("empEmail1"));
		associatedDevIDTextBox.clear();
		associatedDevIDTextBox.sendKeys(getObject("deviceId2"));
		addButton.click();
		Thread.sleep(2000);
		
		if(addEmpErrorMsg.isDisplayed()) {
			String errorMessage1 = errorMsg1.getText();
			if(errorMessage1.equals("Employee already exists.")) {
				System.out.println("Correct error message displayed for duplicate emails");
				empWithDupEmails = true;
			} 
			else {
				System.out.println("Excepted error message not seen");
			}
		}
		
		//Emp addition failure due to duplicate device id
		emailTextBox.clear();
		emailTextBox.sendKeys(getObject("empEmail2"));
		associatedDevIDTextBox.clear();
		associatedDevIDTextBox.sendKeys(getObject("deviceId1"));
		addButton.click();
		Thread.sleep(2000);
		String errorMessage2 = errorMsg2.getText();
		System.out.println(errorMessage2);
		if(errorMessage2.contains("An employee") && errorMessage2.contains("already exists with")
				&& errorMessage2.contains("for the Associated Device ID.")) {
			System.out.println("Correct error message displayed for duplicate device id");
			empWithDupDevId = true;
		} else {  
			System.out.println("Correct error messages not displayed for duplicate device id");
		}
		if(empWithDupEmails && empWithDupDevId) {
			empNotAdded = true;
			System.out.println("Employe has not been added and correct error message encountered");
		} else {
			System.out.println("Correct error messages not displayed");
		}
		return empNotAdded;
	}
	
	
	public boolean cancelAddEmp() throws InterruptedException {
		boolean empNotAdded = false;
		emailTextBox.clear();
		emailTextBox.sendKeys(getObject("cancelEmpEmail"));
		//System.out.println(" ");
		//System.out.println(getObject("cancelEmpEmail"));
		associatedDevIDTextBox.clear();
		associatedDevIDTextBox.sendKeys(getObject("cancelEmpDeviceId3"));
		cancelBtn.click();
		Thread.sleep(1000);
		searchEmail.clear();
		searchEmail.sendKeys(getObject("cancelEmpEmail"));
		searchBtn.click();
		String resFound = empSrchRes.getText();
		if(resFound.equals("No Results Found")) {
			System.out.println("Employee has not been added after clicking on cancel button");
			empNotAdded = true;
		} else {
			System.out.println("Employee cancellation failed");
		}
		return empNotAdded;
	}
}
