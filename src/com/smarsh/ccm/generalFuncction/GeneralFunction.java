package com.smarsh.ccm.generalFuncction;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GeneralFunction {
WebDriver driver;
	
	public GeneralFunction(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void takeScreenShot(WebDriver driver) {
		File src=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		try {
			String fileLocation = "screenshots/.png";
			FileUtils.copyFile(src, new File(fileLocation));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	

}
