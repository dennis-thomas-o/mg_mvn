package com.smarsh.ccm.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage extends TestBase {

	WebDriver driver;
	
	@FindBy(name = "Username")
	WebElement usernameTextBox;
	
	@FindBy(name = "Password")
	WebElement passwordTextBox;
	
	
	@FindBy(name = "DoSubmit")
	WebElement submitBtn;
	
	
	/*@FindBy(xpath = "//td[contains(text(),'Connected Capture Mobile')]")
	WebElement copyRightInfo;*/
	
	@FindBy(xpath = "//div[contains(@class,'login-page__footer')]")
	WebElement copyRightFooter;
	
	@FindBy(id = "VersionInfo")
	WebElement versionDetails;
	
	@FindBy(id = "UsernameLabel")
	WebElement usernameLabel;
	
	@FindBy(id = "PasswordLabel")
	WebElement passwordLabel;
	
	@FindBy(id = "GoForgot")
	WebElement paswdresetLink;
	
	@FindBy(id = "RememberMe")
	WebElement rememberMeChkBox;
	
	@FindBy(xpath = "//*[contains(text(),'Remember Email Address')]")
	WebElement rememberMeLabel;
	
	@FindBy(xpath = "//table[@id = 'Controls']//tbody//tr[1]")
	WebElement smarshLogo;
	


	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyLoginPage() throws InterruptedException {
		
		boolean loginPageCorrectlyDisplayed = false;
		boolean logoPresent = smarshLogo.isDisplayed();
		boolean correctTexts = false;
		boolean defStatus = true;
		boolean elelemntsEnabled = false;
		String usrNameText = usernameLabel.getText();
		String paswdText = passwordLabel.getText();
		String resetPaswdLink = paswdresetLink.getText();
		if(usrNameText.equals("Username") && paswdText.equals("Password") && 
				resetPaswdLink.equals("Forgot Password?"))
		{
			correctTexts = true;
			System.out.println("All the labels are displayed correctly.");
		}
		else 
			System.out.println("Labels are not diplayed correctly");
		
		if(!rememberMeChkBox.isSelected()) {
			defStatus = false;
			System.out.println("By default remember me check box is not selected");
		}
		if(rememberMeChkBox.isEnabled() && paswdresetLink.isEnabled()) {
			System.out.println("Remember Me check box and Forgot Password links are enabled");
			elelemntsEnabled = true;
		}
		else
			System.out.println("Remember Me check box and Forgot Password links are disabled");
		if(logoPresent && correctTexts && elelemntsEnabled && !defStatus) {
			loginPageCorrectlyDisplayed = true;
		}
		return loginPageCorrectlyDisplayed;
	}
	
	public boolean verifyCopyRightOnLogin() {
		
		boolean copyRightInfoCorrect = false;
		if(copyRightFooter.isDisplayed()) {
			System.out.println("Copy right section is displayed");
		}
			String copyRightText = copyRightFooter.getText();
			System.out.println("Copy right states" + copyRightText);
			String versionNumber = versionDetails.getText();
			System.out.println("Version number = " + versionNumber);
			if(copyRightText.equalsIgnoreCase(System.getProperty("copyright"))){
				System.out.println("Copy right text is displayed correctly");
			}
			else {
				System.out.println("Copy right text is wrong");
				
			}
			if(versionNumber.equalsIgnoreCase(System.getProperty("version"))) {
				System.out.println("Version number is displayed correctly");
			} 
			else {
				System.out.println("Verison is wrong");
			}
		
			if(copyRightFooter.isDisplayed() && copyRightText.trim().equalsIgnoreCase(System.getProperty("copyright"))
					&& versionNumber.trim().equalsIgnoreCase(System.getProperty("version"))) {
				copyRightInfoCorrect = true;
			}
			
		return copyRightInfoCorrect;
			
	}
	
	public void wrongUserID() throws IOException, InterruptedException{
		
		usernameTextBox.sendKeys("abcd");
		passwordTextBox.sendKeys(System.getProperty("password"));
		submitBtn.click();		
	}
	
	public void wrongPassword() throws IOException, InterruptedException{
		
		usernameTextBox.clear();
		passwordTextBox.clear();
		usernameTextBox.sendKeys(System.getProperty("username"));
		passwordTextBox.sendKeys("ab");
		submitBtn.click();		
	}
	
	public void emptyUserID() throws IOException, InterruptedException{
		
		usernameTextBox.clear();
		passwordTextBox.clear();
		usernameTextBox.sendKeys("");
		passwordTextBox.sendKeys(System.getProperty("password"));
		submitBtn.click();	
	}
	
	public void emptyPassword() throws IOException, InterruptedException{
		
		usernameTextBox.clear();
		passwordTextBox.clear();
		usernameTextBox.sendKeys(System.getProperty("username"));
		passwordTextBox.sendKeys("");
		submitBtn.click();	
	}
	
	public boolean loginMG() throws IOException, InterruptedException {
		boolean isDashboardDisp = false;
		usernameTextBox.clear();
		passwordTextBox.clear();
		usernameTextBox.sendKeys(System.getProperty("username"));
		passwordTextBox.sendKeys(System.getProperty("password"));
		submitBtn.click();
		Thread.sleep(2000);
		String currURL = driver.getCurrentUrl();
		System.out.println(currURL);
		logger.info(currURL);
		try {
		isDashboardDisp = currURL.equals(System.getProperty("url") + "dashboard");
		logger.info(isDashboardDisp);
		}
		catch(Exception e) {
			logger.info(e.getMessage());
		}
		return isDashboardDisp;
	}
	
	public boolean verifyForgotPasswordPage() {
		
		paswdresetLink.click();
		String pageTitle = driver.getTitle();
		System.out.println("Page title is " + pageTitle);
			String correctPageTitle = "Forgot Password";
			boolean correctTitle = false;
			if(pageTitle.equals(correctPageTitle)) {
				System.out.println("Title for Forgot password page is displayed correctly");
				correctTitle = true;
		}
			return correctTitle;
	}
	


}
	
	


