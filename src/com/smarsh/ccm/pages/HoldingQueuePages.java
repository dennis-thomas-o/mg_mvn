package com.smarsh.ccm.pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HoldingQueuePages extends TestBase {
	
	public HoldingQueuePages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;

	@FindBy(id = "NavCarrierSettings")
	WebElement carrierSettingsLink;

	@FindBy(xpath = "//a[@href = '/management/tmobileholdingqueue']")
	WebElement tmoHoldingQueueLink;

	@FindBy(id = "dtStart")
	WebElement startDateTextBox;

	@FindBy(id = "dtEnd")
	WebElement endDateTextBox;

	@FindBy(xpath = "//div[contains(text(),'Submit')]")
	WebElement submitQueueSearchBtn;

	@FindBy(xpath = "//div[contains(text(),'Clear Filter')]")
	WebElement resetQueueSearchBtn;

	@FindBy(id = "holdQueueMain")
	WebElement holdingQueueTable;

	@FindBy(xpath = "//select[@name='holdQueueMain_length']")
	WebElement holdingQueueLenDropdown;

	@FindBy(xpath = "//div[@id='holdQueueMain_paginate']//a[text()=2]")
	WebElement secondPageLink;
	
	@FindBy(xpath = "//a[@class='ui-state-default ui-state-highlight']")
	WebElement currDate;

	public void navigateToHoldingQueue() {
		driver.get(System.getProperty("url") + "management/tmobileholdingqueue");
	}

	public boolean verifyLengthOfHoldingQueue() throws InterruptedException {
		//navigateToHoldingQueue();
		boolean isHoldingQueueLengthCorrect = false;
		
		
		Select holdQueueLength = new Select(holdingQueueLenDropdown);
		/*WebElement defLength = holdQueueLength.getAllSelectedOptions().toString();
		System.out.println("Default length = " + defLength);*/
		
		List<WebElement> queuedDate1 = driver.findElements(By.xpath("//table[@id='holdQueueMain']//tr/td[6]"));
		int numOfRecordsDsip1 = queuedDate1.size();
		System.out.println("Number of records being displayed by default is " + numOfRecordsDsip1);

		holdQueueLength.selectByVisibleText("25");
		//System.out.println("Page length now is " + holdingQueueLenDropdown.getText());

		Thread.sleep(2000);
		List<WebElement> queuedDate2 = driver.findElements(By.xpath("//table[@id='holdQueueMain']//tr/td[6]"));
		int numOfRecordsDsip2 = queuedDate2.size();
		System.out.println("Number of records being displayed by default is " + numOfRecordsDsip2);

		holdQueueLength.selectByVisibleText("50");
		//System.out.println("Page length now is " + holdingQueueLenDropdown.getText());
		Thread.sleep(2000);
		List<WebElement> queuedDate3 = driver.findElements(By.xpath("//table[@id='holdQueueMain']//tr/td[6]"));
		int numOfRecordsDsip3 = queuedDate3.size();
		System.out.println("Number of records being displayed by default is " + numOfRecordsDsip3);

		holdQueueLength.selectByVisibleText("100");
		//System.out.println("Page length now is " + holdingQueueLenDropdown.getText());
		Thread.sleep(2000);
		List<WebElement> queuedDate4 = driver.findElements(By.xpath("//table[@id='holdQueueMain']//tr/td[6]"));
		int numOfRecordsDsip4 = queuedDate4.size();
		System.out.println("Number of records being displayed by default is " + numOfRecordsDsip4);

		if (numOfRecordsDsip1 == 10 && numOfRecordsDsip2 == 25 && numOfRecordsDsip3 == 50 && numOfRecordsDsip4 == 100) {
			System.out.println("Correct records as per chosen lenght are dispalyed");
			isHoldingQueueLengthCorrect = true;
		} else {
			System.out.println("Mismatch in chosen length and number of records being displayed");
		}
		return isHoldingQueueLengthCorrect;
	}

	public boolean verifyDateSearch() throws InterruptedException {
		boolean srchRes1 = false;
		boolean srchRes2 = false;
		boolean isDateFilterCorrect = false;
		startDateTextBox.sendKeys("01/01/2019");
		long startDate = 1546300800000L;
		
		/*long yourmilliseconds = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date resultdate = new Date();
		System.out.println(sdf.format(resultdate));		
		endDateTextBox.sendKeys(resultdate);*/
		
		 Date date = Calendar.getInstance().getTime();  
         SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");  
         String strDate = dateFormat.format(date);  
         System.out.println("Converted String: " + strDate);  
		
		endDateTextBox.sendKeys(strDate);
		long endDate = System.currentTimeMillis();
		submitQueueSearchBtn.click();
		Thread.sleep(2000);
		List<WebElement> queuedDate1 = driver.findElements(By.xpath("//table[@id='holdQueueMain']//tr/td[6]"));
		List<String> queuedDateInString1 = new ArrayList();
		for (WebElement dateRange1 : queuedDate1) {
			queuedDateInString1.add(dateRange1.getText());
			System.out.println("Dates in String format are" + queuedDateInString1);
		}
		List<Long> longTime1 = new ArrayList();
		for (int i = 0; i < queuedDateInString1.size(); i++) {
			longTime1.add(i, EmployeesPage.getLongFromUTC(queuedDateInString1.get(i)));
			System.out.println(queuedDateInString1.get(i) + "in UTC" + longTime1.get(i));
			if (endDate >= longTime1.get(i) && longTime1.get(i) >= startDate) {
				System.out.println(i + "th entry is within the specified time range");
				srchRes1 = true;
			}
		}
		try {
			if (secondPageLink.isEnabled()) {
				secondPageLink.click();
				Thread.sleep(1000);
				List<WebElement> queuedDate2 = driver.findElements(By.xpath("//table[@id='holdQueueMain']//tr/td[6]"));
				List<String> queuedDateInString2 = new ArrayList();
				for (WebElement dateRange2 : queuedDate2) {
					queuedDateInString2.add(dateRange2.getText());
					System.out.println("Dates in String format are" + queuedDateInString2);
				}
				List<Long> longTime2 = new ArrayList();
				for (int i = 0; i < queuedDateInString2.size(); i++) {
					longTime2.add(i, EmployeesPage.getLongFromUTC(queuedDateInString2.get(i)));
					System.out.println(queuedDateInString2.get(i) + "in UTC" + longTime2.get(i));
					if (endDate >= longTime2.get(i) && longTime2.get(i) >= startDate) {
						System.out.println(i + "th entry is within the specified time range");
						srchRes2 = true;
					}
				}
			}
		} catch (Exception e) {

			System.out.println("No second page displayed to search");
			srchRes2 = true;
		}

		if (srchRes1 && srchRes2) {
			System.out.println("Displayed entries are within searched date range");
			isDateFilterCorrect = true;
		} else {
			System.out.println("Mismatch in search result");
		}
		return isDateFilterCorrect;
	}

	public void navigateToATnTHoldingQueue() {
		driver.get(System.getProperty("url") + "management/atntholdingqueue");
		try {
			verifyLengthOfHoldingQueue();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			verifyDateSearch();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
