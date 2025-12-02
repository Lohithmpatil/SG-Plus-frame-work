package com.DowntimeShiftview;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.DowntimeShiftview;
import com.sgplus.erp.pomRepository.HomePage;

public class VerifyShiftViewPageDataTest extends BaseClass {

	// Test method to verify the navigation to Shift View page
	@Test
	public void VerifyShiftViewPageDataTest() throws Throwable {

		

		// Create utility object for custom WebDriver actions like waits and dropdowns
		WebDriverUtility we = new WebDriverUtility();

		// Initialize HomePage object to interact with home screen elements (menu, etc.)
		HomePage hm = new HomePage(driver);

		// Initialize DowntimeShiftview object to interact with elements specific to the
		// Downtime Shiftview page
		DowntimeShiftview ds = new DowntimeShiftview(driver);
		
		we.waitForElementInDOM(driver);

		// Wait for the 'DownTime' menu item to be clickable and then click it
		we.waitAndClick(hm.getDownTime());

		// Wait for the 'Shiftview Dashboard' button to be clickable and then click it
		we.waitAndClick(ds.getShiftviewDashboard());

		// Wait for the 'Filter' button to be clickable and then click it
		we.waitAndClick(ds.getFilterButton());

		// Wait for the 'BU Dropdown' to be clickable and then click it
		we.waitAndClick(ds.getBUDropDown());

		// Select "BU3" from the Business Unit dropdown
		we.select(ds.getBUDropDown(), "BU3");

		// Wait for the 'Area Dropdown' to be clickable and then click it
		we.waitAndClick(ds.getAreaDropDown());

		// Select "TBM-PCR" from the Area dropdown
		we.select(ds.getAreaDropDown(), "TBM-PCR");

		// Wait for the 'Group Dropdown' to be clickable and then click it
		we.waitAndClick(ds.getGroupDropDown());

		// Select "Unistage" from the Group dropdown
		we.select(ds.getGroupDropDown(), "Unistage");

		// Commented out code: Wait and select an Equipment dropdown option (not being
		// used)
		// we.waitAndClick(ds.getEquipementDropDown());
		// we.select(ds.getEquipementDropDown(), "PTBS01");

		// Wait for the 'Shift Dropdown' to be clickable and then click it
		we.waitAndClick(ds.getShiftDropDown());

		// Clears any existing text in the "From Date" input field (ensuring clean
		// input)
		driver.findElement(By.xpath("//input[@class=\"form-control\"]")).clear();

		// Inputs the date "01-01-2025" into the "From Date" field
		driver.findElement(By.xpath("//input[@class=\"form-control\"]")).sendKeys("01-01-2025");

		// Select "A" shift from the Shift dropdown
		we.select(ds.getShiftDropDown(), "A");

		// Wait for the 'Apply Filter' button to be clickable and then click it
		we.waitAndClick(ds.getApplyFilter());

		// Retrieve the page header text from the Downtime Shiftview page to confirm the
		// page we navigated to
		WebElement pageHeader = ds.getHeadertext();

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("path/to/save/screenshot.png"));

	}
}

