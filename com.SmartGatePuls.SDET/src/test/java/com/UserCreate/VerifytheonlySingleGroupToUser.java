package com.UserCreate;

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
import com.sgplus.erp.pomRepository.UserCreate;

public class VerifytheonlySingleGroupToUser extends BaseClass{

	@Test
	public void VerifytheonlySingleGroupToUser() throws Throwable {

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

		UserCreate us = new UserCreate(driver);

		// Generate a random number to make department group name unique
		int intRanNum = jlib.getRandomNumber();

		// Read base group name from Excel and append random number
		String username = elib.getDataFromExcel("Sheet1", 1, 3) + intRanNum;

		String userID = elib.getDataFromExcel("Sheet1", 1, 5) + intRanNum;

		String password = elib.getDataFromExcel("Sheet1", 1, 4) + intRanNum;
		// String email = elib.getDataFromExcel("Sheet1", 1, 6) + intRanNum;
		// Click on Settings menu from home page
		we.waitAndClick(hm.getSettings());

		we.waitAndClick(us.getUsermodule());

		we.waitAndClick(us.getAdduserbutton());

		we.waitAndClick(us.getNamefield());

		us.getNamefield().sendKeys(username);

		we.waitAndClick(us.getUserID());

		us.getUserID().sendKeys(userID);

		we.waitAndClick(us.getPassword());

		us.getPassword().sendKeys(password);

		we.waitAndClick(us.getMobileno());

		us.getMobileno().sendKeys("9087654321");

		we.waitAndClick(us.getRoledropdown());

		we.select(us.getRoledropdown(), "AutomationAdmin");

		we.waitAndClick(us.getPlantAcheckbox());

		we.waitAndClick(us.getBU1checkbox());

		we.waitAndClick(us.getMixingAreaCheckbox());
		
		we.waitAndClick(us.getFinalMixerboxGroupCheckbox());

		we.waitAndClick(us.getSubmitbutton());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));

		String actualMsg = toast.getText();

		// Print the message in Console
		System.out.println("Success Message: " + actualMsg);

		// Verify the message
		Assert.assertTrue(actualMsg.contains("User created successfully"),
				"User created failed. Actual message: " + actualMsg);
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait until toast disappears
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(
		        By.cssSelector(".Toastify__toast-body")));

	}
}
