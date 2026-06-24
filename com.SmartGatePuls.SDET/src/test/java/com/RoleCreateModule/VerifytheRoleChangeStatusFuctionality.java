package com.RoleCreateModule;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.ExcelUtility;
import com.sgplus.erp.genericutility.FileUtility;
import com.sgplus.erp.genericutility.JavaUtility;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.HomePage;
import com.sgplus.erp.pomRepository.RoleCreate;

public class VerifytheRoleChangeStatusFuctionality extends BaseClass {
	
	@Test
	public void VerifytheRoleChangeStatusFuctionality() throws Throwable {

		// Create WebDriverUtility object for custom wait and click operations
		WebDriverUtility we = new WebDriverUtility();

		// Create JavaUtility object to generate random numbers
		JavaUtility jlib = new JavaUtility();

		// Create FileUtility object to read data from property files (if needed)
		FileUtility flib = new FileUtility();

		// Create ExcelUtility object to read test data from Excel sheet
		ExcelUtility elib = new ExcelUtility();

		// Create HomePage object to interact with home page elements
		HomePage hm = new HomePage(driver);

		RoleCreate rl = new RoleCreate(driver);

		// Generate a random number to make department group name unique
		int intRanNum = jlib.getRandomNumber();

		// Read base group name from Excel and append random number

		String rolename = elib.getDataFromExcel("Sheet1", 1, 7) + intRanNum;
		// Click on Settings menu from home page
		we.waitAndClick(hm.getSettings());

		we.waitAndClick(rl.getRolemoduleNavigation());

		we.waitAndClick(rl.getDots3Button());
		
		we.waitAndClick(rl.getChangeStatusButton());
		
        we.waitAndClick(rl.getYesStatuschangesBtn());
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));

		String actualMsg = toast.getText();

		// Print the message in Console
		System.out.println("Success Message: " + actualMsg);

		// Verify the message
		Assert.assertTrue(actualMsg.contains("role status changed"),
				"Role Change status failed. Actual message: " + actualMsg);

		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Wait until toast disappears
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(
		        By.cssSelector(".Toastify__toast-body")));
	}

}
