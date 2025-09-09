package com.ReasonLinkingPage; // Define package for reason linking test cases

// Import required Java and Selenium classes
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

// Import custom utility and page object classes
import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.HomePage;

public class ReasonLinkingCombinedExportTest extends BaseClass { // Test class extending BaseClass

	@Test
	public void Reasonlinkingpage() throws InterruptedException {

		// Create instance of WebDriver utility for custom methods
		WebDriverUtility we = new WebDriverUtility();

		// Initialize HomePage POM
		HomePage hm = new HomePage(driver);

		// Initialize ReasonLinking POM
		com.sgplus.erp.pomRepository.ReasonLinking rs = new com.sgplus.erp.pomRepository.ReasonLinking(driver);

		// Click on the "Downtime" menu on the home page
		we.waitAndClick(hm.getDownTime());

		// Click on the "Reason Linking" option from the menu
		we.waitAndClick(rs.getReasonLinking());

		// Click on BU dropdown
		we.waitAndClick(rs.getBUDropDown());

		// Select "BU3" from the BU dropdown
		we.select(rs.getBUDropDown(), "BU3");

		// Click on the Equipment dropdown
		we.waitAndClick(rs.getEquipmentDropDown());

		// Select a checkbox from the equipment list
		we.waitAndClick(rs.getEquipmentCheckbox());

		// Click on From Date input
		we.waitAndClick(rs.getFromDate());

		// Wait for the From Date element to be visible
		we.waitForElement(driver, rs.getFromDate());

		// Clear the From Date field and enter new date
		driver.findElement(By.xpath("//input[@class=\"form-control\"]")).clear();
		driver.findElement(By.xpath("//input[@class=\"form-control\"]")).sendKeys("01-01-2025");

		// Click on To Date input
		we.waitAndClick(rs.getToDate());

		// Clear the To Date field and enter new date
		driver.findElement(By.xpath("//input[@id=\"formGridToDate\"]")).clear();
		driver.findElement(By.xpath("//input[@id=\"formGridToDate\"]")).sendKeys("01-01-2025");

		// Select "All" from Link dropdown (includes Linked + Unlinked)
		we.waitAndClick(rs.getLinkDropDown());
		we.select(rs.getLinkDropDown(), "All");

		// Click on Search to apply filters and load data
		we.waitAndClick(rs.getSearchButton());

		// Click on Export button to export the filtered data
		we.waitAndClick(rs.getExportButton());

		// Wait and click on export success toast (if clickable)
		we.waitAndClick(rs.getSuccessfullyExported());

		// Capture the toast message WebElement
		WebElement successToast = rs.getSuccessfullyExported();

		// Assert that the export success toast is displayed
		Assert.assertTrue(successToast.isDisplayed(), "Export success message not displayed!");

	}
}