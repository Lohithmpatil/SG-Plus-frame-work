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

public class VerifytherRoleChangeStatusCancelFunctionality extends BaseClass {

	@Test
	public void VerifytherRoleChangeStatusCancelFunctionality() throws Throwable {

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

		we.waitAndClick(rl.getNoStatuschangesBtn());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		boolean popupClosed = wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h4[contains(text(),'Change Status')]")));

		Assert.assertTrue(popupClosed, "Change role Status popup did not close after clicking Cancel");

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait until toast disappears
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".Toastify__toast-body")));
	}
}
