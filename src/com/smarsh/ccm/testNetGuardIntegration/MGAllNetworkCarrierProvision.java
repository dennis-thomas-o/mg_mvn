package com.smarsh.ccm.testNetGuardIntegration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.smarsh.ccm.pages.TestBase;
import com.smarsh.ccm.testEmployees.MGUploadEmployee;

public class MGAllNetworkCarrierProvision extends TestBase {
	protected static Logger
	logger = LogManager.getLogger(MGAllNetworkCarrierProvision.class);
	
	
	
	
	@BeforeClass
	public void beforeTest() throws InterruptedException {
		mobileGuardLogin();		
		System.out.println("Logined successfully ");
		
	}
	
	// 	Verify NetGuard Hutchison Provisioning 
	@Test(priority = 1, enabled = true)
	public void C2569010_HutchisonProvision() {
		logger.info("Started Hutchison carrier Provision");
		String Carriername="Hutchison";
		homePage.goToEmployees();
		empPage.search_EmailAddressContains("automation");
		Assert.assertEquals((empPage.provisionCarrier(Carriername)),("provisioned"));
		Assert.assertTrue(empPage.vaildateProvisionIconEnable(Carriername));
		logger.info("Succefully completed Hutchison carrier Provision");
		
	}
	//Verify NetGuard Rogers Provisioning
	@Test(priority = 2, enabled = true)
	public void C4343647_RogersProvision() {
		logger.info("Started Rogers carrier Provision");
		String Carriername="Rogers";
		homePage.goToEmployees();
		empPage.search_EmailAddressContains("automation");
		Assert.assertEquals((empPage.provisionCarrier(Carriername)),("provisioned"));
		Assert.assertTrue(empPage.vaildateProvisionIconEnable(Carriername));
		logger.info("Succefully completed Rogers carrier Provision");
		
	}
	//Verify NetGuard T-Mobile Provisioning
	@Test(priority = 3, enabled = true)
	public void C5472795_TMobileProvision() {
		logger.info("Started T-Mobile carrier Provision");
		String Carriername="T-Mobile";
		homePage.goToEmployees();
		empPage.search_EmailAddressContains("automation");
		Assert.assertEquals((empPage.provisionCarrier(Carriername)),("provisioned"));
		Assert.assertTrue(empPage.vaildateProvisionIconEnable(Carriername));
		logger.info("Succefully completed T-Mobile carrier Provision");
		
	}
	//Verify NetGuard Truphone Provisioning
	@Test(priority = 4, enabled = true)
	public void C5068278_TruphoneProvision() {
		logger.info("Started Truphone carrier Provision");
		String Carriername="Truphone";
		homePage.goToEmployees();
		empPage.search_EmailAddressContains("automation");
		Assert.assertEquals((empPage.provisionCarrier(Carriername)),("provisioned"));
		Assert.assertTrue(empPage.vaildateProvisionIconEnable(Carriername));
		logger.info("Succefully completed Truphone carrier Provision");

	}
	//Verify NetGuard US Cellular Provisioning
	@Test(priority = 5, enabled = true)
	public void C4343647_USCellularProvision() {
		logger.info("Started US Cellular carrier Provision");
		String Carriername="US Cellular";
		homePage.goToEmployees();
		empPage.search_EmailAddressContains("automation");
		Assert.assertEquals((empPage.provisionCarrier(Carriername)),("provisioned"));
		Assert.assertTrue(empPage.vaildateProvisionIconEnable(Carriername));
		logger.info("Succefully completed US Cellular carrier Provision");
		
	}
	
	
	//Verify NetGuard Vodafone Provisioning
	@Test(priority = 7, enabled = true)
	public void C2569010_VodafoneProvision() {
		logger.info("Started Vodafone carrier Provision");
		String Carriername="Vodafone";
		homePage.goToEmployees();
		empPage.search_EmailAddressContains("automation");
		Assert.assertEquals((empPage.provisionCarrier(Carriername)),("provisioned"));
		Assert.assertTrue(empPage.vaildateProvisionIconEnable(Carriername));
		logger.info("Succefully completed Vodafone carrier Provision");
		
	}
	
	//not verified issue
	//Verify NetGuard Verizon Provisioning
		@Test(priority = 6, enabled = true)
		public void C2312625_VerizonProvision() {
			logger.info("Started Verizon carrier Provision");
			String Carriername="Verizon";
			homePage.goToEmployees();
			empPage.search_EmailAddressContains("automation");
			Assert.assertEquals((empPage.provisionCarrier(Carriername)),("provisioned"));
			Assert.assertTrue(empPage.vaildateProvisionIconEnable(Carriername));
			logger.info("Succefully completed Verizon carrier Provision");
			
		}
		
	//not verified issue
	//Verify the Feature of Change Phone Number of VZW Device 
	@Test(priority = 8, enabled = true)
	public void C3519215_VerizonchangePhoneNumber() {
		logger.info("Started Verizon change phone number");
		String Carriername="Verizon";
		homePage.goToEmployees();
		empPage.search_EmailAddressContains("automation");
		Assert.assertEquals((empPage.provisionCarrier(Carriername)),("provisioned"));
		Assert.assertTrue(empPage.vaildateProvisionIconEnable(Carriername));
		logger.info("Succefully completed Vodafone carrier Provision");
		
	}
	
	
	
	
	// 	Verify Truphone Added in the Downloaded Employee File
	@Test(priority = 8, enabled = true)
	public void C5412014_VerfiyTruphoneInDowEmpFile() {
		logger.info("Started VerfiyTruphoneInDowEmpFile");
		String Carriername="Truphone";
		String empdetails="";
		homePage.goToEmployees();
		empPage.getFirstEmpDetailsAcc_Carrier(Carriername); 
		logger.info("Succefully completed VerfiyTruphoneInDowEmpFile");
	}
		
}
