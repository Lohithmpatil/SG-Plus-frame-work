package com.DowntimeEnhacementPage;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.DowntimeEnhacement;
import com.sgplus.erp.pomRepository.HomePage;

public class DowntimeEnhacementTableExportTest extends BaseClass {

	// Test annotation indicates that this method is a TestNG test method
	@Test
	public void DowntimeEnhacementTableExport() throws Throwable {

		// Creates instance of WebDriverUtility for reusable methods (e.g.,
		// waitAndClick, select, etc.)
		WebDriverUtility we = new WebDriverUtility();

		// Initializes HomePage object to interact with elements on the Home Page
		HomePage hm = new HomePage(driver);

		// Initializes DowntimeEnhacement object to interact with elements on the
		// Downtime Enhancement page
		DowntimeEnhacement de = new DowntimeEnhacement(driver);

		// Waits for and clicks the "DownTime" button on the Home Page
		we.waitAndClick(hm.getDownTime());

		// Waits for and clicks the "Enhancement Module" button on the Downtime
		// Enhancement page
		we.waitAndClick(de.getEnhacementModule());

		// Waits for and clicks the "Filter" button on the Downtime Enhancement page
		we.waitAndClick(de.getFilterButton());

		// Waits for and clicks the "Business Unit" dropdown, then selects "BU3" from
		// the dropdown
		we.waitAndClick(de.getBUDropDown());

		we.waitAndClick(de.getBu3checkbox());

		we.waitAndClick(de.getCollpaseBUdropdown());

		we.waitAndClick(de.getAreaDropDown());

		we.waitAndClick(de.getAreaCheckox());
		
		we.waitAndClick(de.getCollpaseAreadropdown());

		we.waitAndClick(de.getGroupDropDown());

		we.waitAndClick(de.getGroupCheckbox());

		we.waitAndClick(de.getCollpaseGroupdropdown());
		
		we.waitAndClick(de.getEquipementDropDown());

		we.waitAndClick(de.getEquipementCheckbox());

		we.waitAndClick(de.getCollpaseEquipementsdropdown());
		
		
	     // Clears any existing text in the "From Date" input field (likely used for filtering data by date)
        driver.findElement(By.xpath("//label[text()='From Dates ']/following-sibling::input]")).clear(); 

        // Inputs the date "01-01-2025" into the "From Date" field to filter the data starting from this date
        driver.findElement(By.xpath("//label[text()='From Dates ']/following-sibling::input")).sendKeys("01-01-2025");

		we.waitAndClick(de.getFromdateSelection());
		
		de.getFromdateSelection().clear();

		de.getFromdateSelection().sendKeys("01-01-2025");

		we.waitAndClick(de.getTodateSelection());

		de.getTodateSelection().clear();
		
		de.getTodateSelection().sendKeys("30-01-2025");

		we.waitAndClick(de.getApplyFilter());
		// Waits for and clicks the table to ensure it's loaded or interactable
		we.waitAndClick(de.getTable());

		//Waits for and clicks the "Export" button to export the table data
		// we.waitAndClick(de.getExportbutton());
	}
}