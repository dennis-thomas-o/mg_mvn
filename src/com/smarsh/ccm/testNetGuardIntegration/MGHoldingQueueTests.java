package com.smarsh.ccm.testNetGuardIntegration;

import java.io.File;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.smarsh.ccm.pages.EmployeeViewPage;
import com.smarsh.ccm.pages.HoldingQueuePages;
import com.smarsh.ccm.pages.TestBase;

public class MGHoldingQueueTests extends TestBase {
	
		protected static HoldingQueuePages holdingQueuePage;
		protected static Logger
		logger = LogManager.getLogger(MGHoldingQueueTests.class);
		String userDirPath = System.getProperty("user.dir");
		File downloadPath =new File(userDirPath+"\\Downloads");
		

		@BeforeClass
		public void beforeTest() throws InterruptedException {
			
			mobileGuardLogin();
			System.out.println("Logged in successfully ");
			holdingQueuePage = new HoldingQueuePages(driver);
		
		}
		
		@Test(priority = 1, enabled = true)
		public void verifyTMOHoldingQueue() throws InterruptedException {
			holdingQueuePage.navigateToHoldingQueue();
			boolean isTMOQueueLengthCorrect = holdingQueuePage.verifyLengthOfHoldingQueue();
			boolean isTMOQueueSearchCorrect = holdingQueuePage.verifyDateSearch();
			Assert.assertTrue(isTMOQueueLengthCorrect);
			Assert.assertTrue(isTMOQueueSearchCorrect);
		}
		
		@Test(priority = 2, enabled = true)
		public void verifyAtnTHoldingQueue() throws InterruptedException {
			holdingQueuePage.navigateToATnTHoldingQueue();
			//holdingQueuePage.verifyATnTHoldingQueue();
			boolean isATnTQueueLengthCorrect = holdingQueuePage.verifyLengthOfHoldingQueue();
			boolean isATnTQueueSearchCorrect = holdingQueuePage.verifyDateSearch();
			Assert.assertTrue(isATnTQueueLengthCorrect);
			Assert.assertTrue(isATnTQueueSearchCorrect);
		}
		
		@Test(priority =3, enabled = true)
		public void verifyDocLinks() throws InterruptedException {
			boolean isDocsHyperlink1 = homePage.verifyDocLinks();
			Assert.assertTrue(isDocsHyperlink1);
		}
		
		@Test(priority = 4, enabled = true)
		public void verifyCenLinks() throws InterruptedException {
			boolean isDocsHyperlink2 = homePage.verifySmarshCenLink();
			Assert.assertTrue(isDocsHyperlink2);
		}
		
}
