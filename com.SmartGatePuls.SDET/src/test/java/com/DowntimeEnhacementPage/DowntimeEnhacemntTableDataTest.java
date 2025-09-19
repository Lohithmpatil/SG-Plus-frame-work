package com.DowntimeEnhacementPage;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.DowntimeEnhacement;
import com.sgplus.erp.pomRepository.HomePage;

public class DowntimeEnhacemntTableDataTest extends BaseClass {

    // The @Test annotation marks this method as a TestNG test case
    @Test
    public void DowntimeEnhacemntTableDataTest() throws InterruptedException {

        // Creating an instance of WebDriverUtility for reusable helper methods (e.g., waitAndClick, select)
        WebDriverUtility we = new WebDriverUtility(); 

        // Initializes HomePage object to interact with elements on the Home Page
        HomePage hm = new HomePage(driver); 

        // Initializes DowntimeEnhacement object to interact with elements on the Downtime Enhancement page
        DowntimeEnhacement de = new DowntimeEnhacement(driver);

        // Waits for and clicks the "DownTime" link or button on the HomePage
        we.waitAndClick(hm.getDownTime());

        // Waits for and clicks the "Enhancement Module" link or button on the Downtime Enhancement page
        we.waitAndClick(de.getEnhacementModule());

        // Waits for and clicks the "Filter" button on the Downtime Enhancement page to open the filter options
        we.waitAndClick(de.getFilterButton());

        // Waits for and clicks the "Business Unit" dropdown and selects "BU3" from the dropdown
        we.waitAndClick(de.getBUDropDown());
        we.select(de.getBUDropDown(), "BU3");

        // Waits for and clicks the "Area" dropdown and selects "All" from the dropdown (for all areas)
        we.waitAndClick(de.getAreaDropDown());
        we.select(de.getAreaDropDown(), "All");

        // Waits for and clicks the "Group" dropdown and selects "All" from the dropdown (for all groups)
        we.waitAndClick(de.getGroupDropDown());
        we.select(de.getGroupDropDown(), "All");

        // Waits for and clicks the "Equipment" dropdown to expand the equipment options
        we.waitAndClick(de.getEquipementDropDown());

        // Waits for and clicks the checkbox for selecting equipment in the dropdown
        we.waitAndClick(de.getCheckBoxEquipements());

        // Clears any existing text in the "From Date" input field (likely used for filtering data by date)
        driver.findElement(By.xpath("//input[@class=\"form-control\"]")).clear(); 

        // Inputs the date "01-01-2025" into the "From Date" field to filter the data starting from this date
        driver.findElement(By.xpath("//input[@class=\"form-control\"]")).sendKeys("01-01-2025");

        // Waits for and clicks the "Apply Filter" button to apply all selected filters and display the relevant data
        we.waitAndClick(de.getApplyFilter());

        // Waits for and clicks the table to ensure it's loaded or interacts with the table for further actions
        we.waitAndClick(de.getTable());
        
        WebElement table = de.getTable();
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        Assert.assertTrue(rows.size() > 1, "Table has no rows or header row is missing.");

        // Verifying column count (example: 5 columns in total, including Machine, Total Occ, Linked, Compliance)
        List<WebElement> headerColumns = table.findElements(By.xpath("//table//th"));
        Assert.assertTrue(headerColumns.size() > 5, "Column count mismatch in table");

    }
}