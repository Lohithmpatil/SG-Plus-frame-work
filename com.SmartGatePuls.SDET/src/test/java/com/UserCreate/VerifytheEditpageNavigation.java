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

public class VerifytheEditpageNavigation extends BaseClass {

	@Test
	public void VerifytheEditpageNavigation() throws Throwable {

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

		we.waitAndClick(us.getDots3());

		we.waitAndClick(us.getEditButton());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement viewText = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='edit']")));

		Assert.assertTrue(viewText.isDisplayed());
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait until toast disappears
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(
		        By.cssSelector(".Toastify__toast-body")));

	}
}
