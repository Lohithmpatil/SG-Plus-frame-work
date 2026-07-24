package com.AddAssociates;

import java.time.Duration;
import java.util.List;

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
import com.sgplus.erp.pomRepository.AddAssociates;
import com.sgplus.erp.pomRepository.HomePage;

public class VerifytheAddAssocoiateCancelFunctionality extends BaseClass {

	@Test
	public void VerifytheAddAssocoiateCancelFunctionality() throws Throwable {

		// Create WebDriverUtility object for handling waits and actios
		WebDriverUtility we = new WebDriverUtility();

		// Create JavaUtility object to generate random numbers
		JavaUtility jlib = new JavaUtility();

		// Create FileUtility object to read data from property files (if needed)
		FileUtility flib = new FileUtility();

		// Create ExcelUtility object to read test data from Excel sheet
		ExcelUtility elib = new ExcelUtility();

		// Create HomePage object to access home page elements
		HomePage hm = new HomePage(driver);

		AddAssociates ad = new AddAssociates(driver);

		// Generate a random number to make department group name unique
		int intRanNum = jlib.getRandomNumber();

		// Read base group name from Excel and append random number

		String associatesname = elib.getDataFromExcel("Sheet1", 1, 8) + intRanNum;

		String sapcode = elib.getDataFromExcel("Sheet1", 2, 8) + intRanNum;

		String udanno = elib.getDataFromExcel("Sheet1", 3, 8) + intRanNum;

		we.waitAndClick(hm.getSettings());

		we.waitAndClick(ad.getAddAssociatesPage());

		we.waitAndClick(ad.getAddAssociatesBtn());

		we.waitAndClick(ad.getAddAssociatesNameField());

		ad.getAddAssociatesNameField().sendKeys(associatesname);

		we.waitAndClick(ad.getSapcodeField());

		ad.getSapcodeField().sendKeys(sapcode);

		we.waitAndClick(ad.getMobieNoField());

		ad.getMobieNoField().sendKeys("1234567891");

		we.waitAndClick(ad.getAreaDropdown());

		we.waitAndClick(ad.getAreaCheckBox());

		we.waitAndClick(ad.getCollapseAreadropdown());

		we.waitAndClick(ad.getUdanNO());

		ad.getUdanNO().sendKeys(udanno);

		we.waitAndClick(ad.getCancelBtn());
		// we.waitAndClick(ad.getSubmitBtn());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		// Verify popup is closed
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal-content']")));

		List<WebElement> popupAfterCancel = driver.findElements(By.xpath("//div[@class='modal-content']"));

		Assert.assertTrue(popupAfterCancel.isEmpty() || !popupAfterCancel.get(0).isDisplayed(),
				"Popup is still displayed after clicking Cancel.");

		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait until toast disappears
		wait3.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".Toastify__toast-body")));
	}
}
