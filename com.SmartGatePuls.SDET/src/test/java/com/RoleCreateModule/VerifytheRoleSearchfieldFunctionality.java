package com.RoleCreateModule;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class VerifytheRoleSearchfieldFunctionality extends BaseClass{
	
	@Test
	public void VerifytheRoleSearchfieldFunctionality() throws Throwable {

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

		we.waitAndClick(rl.getSearchRolefield());

		rl.getSearchRolefield().sendKeys("AutomationAdmin");
		
		rl.getSearchRolefield().sendKeys(Keys.ENTER);

		String expectedRoleName = "AutomationAdmin";

		// Verify user is displayed in the table
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement userRecord = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + expectedRoleName + "')]")));

		String actualRoleName = userRecord.getText();

		System.out.println("Expected User Name : " + expectedRoleName);
		System.out.println("Actual User Name   : " + actualRoleName);

		Assert.assertEquals(actualRoleName, expectedRoleName);

		System.out.println("Role displayed successfully in Role List");
		

	}
}
