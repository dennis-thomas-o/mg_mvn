package com.smarsh.ccm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends TestBase {

	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "EntForm_EmailAddress")
	WebElement emailIdTextBox;
    
	@FindBy(id = "EntForm_SubmitButton")
	WebElement submitBtn;
	
	@FindBy(id = "EntForm_ErrMsg")
	WebElement errorBar;
	
/*	@FindBy(xpath = "//p[contains(text(),'Please enter a valid email address')]")
	WebElement blankEmailErrorMsg;
	
	@FindBy(xpath = "//p[contains(text(),'Unable to send password reset email.')]")
	WebElement invalidEmailErrorMsg1;
	
	@FindBy(id = "MainContent_SentMsg")
	WebElement successMessage;*/
	
	
	public boolean emptyEmail() {
		boolean resetPasswdFailed1 = false;
		emailIdTextBox.clear();
		emailIdTextBox.sendKeys(" ");
		submitBtn.click();
/*		if(errorBar.isDisplayed() && blankEmailErrorMsg.isDisplayed()) {
			System.out.println("Email textbox is empty");
			resetPasswdFailed1 = true;
		}*/
		if(errorBar.isDisplayed()) {
			if(errorBar.getText().equals("Please enter your email address.")) {
				resetPasswdFailed1 = true;
			}
		}
		 return resetPasswdFailed1;
	}
	
	public boolean invalidEmailFormat() {
		boolean resetPasswdFailed2 = false;
		emailIdTextBox.clear();
		emailIdTextBox.sendKeys("abc");
		submitBtn.click();
/*		if(errorBar.isDisplayed() && blankEmailErrorMsg.isDisplayed()) {
			System.out.println("Eneterd email is invalid");
			resetPasswdFailed2 = true;
		}*/
		
		if(errorBar.isDisplayed()) {
			if(errorBar.getText().equals("Please enter a valid email address.")) {
				resetPasswdFailed2 = true;
			}
		}
		 return resetPasswdFailed2;
	}
	
/*	public boolean invalidEmailAddress() {
		boolean resetPasswdFailed3 = false;
		emailIdTextBox.clear();
		emailIdTextBox.sendKeys("abcdefgh@smarsh.com");
		searchBtn.click();
		if(errorBar.isDisplayed() && invalidEmailErrorMsg1.isDisplayed()) {
			System.out.println("Eneterd email is invalid");
			resetPasswdFailed3 = true;
		}
		 return resetPasswdFailed3;
	}*/
	
	public boolean resetPassword() {
		boolean resetPasswdSuccess = false;
		emailIdTextBox.clear();
		emailIdTextBox.sendKeys(System.getProperty("username"));
		submitBtn.click();
		String successMessageText = errorBar.getText();
		System.out.println(successMessageText);
		if(errorBar.isDisplayed()) {
			
			if(successMessageText.equals
					("Your email submission has been received. If this is a valid email with an active account on this system, an email will be received at that address with instructions for resetting your password."));
			{
			System.out.println("Password reset link has been sent to your email id");
			resetPasswdSuccess = true;
			}
		}
		return resetPasswdSuccess;
	}
	
}
