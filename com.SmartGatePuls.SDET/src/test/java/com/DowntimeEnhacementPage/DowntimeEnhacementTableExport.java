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

public class DowntimeEnhacementTableExport extends BaseClass {

    // Test annotation indicates that this method is a TestNG test method
    @Test
    public void DowntimeEnhacementTableExport() throws InterruptedException {

        // Creates instance of WebDriverUtility for reusable methods (e.g., waitAndClick, select, etc.)
        WebDriverUtility we = new WebDriverUtility(); 

        // Initializes HomePage object to interact with elements on the Home Page
        HomePage hm = new HomePage(driver);

        // Initializes DowntimeEnhacement object to interact with elements on the Downtime Enhancement page
        DowntimeEnhacement de = new DowntimeEnhacement(driver);

        // Waits for and clicks the "DownTime" button on the Home Page
        we.waitAndClick(hm.getDownTime());

        // Waits for and clicks the "Enhancement Module" button on the Downtime Enhancement page
        we.waitAndClick(de.getEnhacementModule());

        // Waits for and clicks the "Filter" button on the Downtime Enhancement page
        we.waitAndClick(de.getFilterButton());

        // Waits for and clicks the "Business Unit" dropdown, then selects "BU3" from the dropdown
        we.waitAndClick(de.getBUDropDown());
     
        we.select(de.getBUDropDown(), "BU3");

        // Waits for and clicks the "Area" dropdown, then selects "All" from the dropdown
        we.waitAndClick(de.getAreaDropDown());
        we.select(de.getAreaDropDown(), "All");

        // Waits for and clicks the "Group" dropdown, then selects "All" from the dropdown
        we.waitAndClick(de.getGroupDropDown());
        we.select(de.getGroupDropDown(), "All");

        // Waits for and clicks the "Equipment" dropdown
        we.waitAndClick(de.getEquipementDropDown());

        // Waits for and clicks the checkbox for the equipment selection
        we.waitAndClick(de.getCheckBoxEquipements());

        // Clears any existing text in the "From Date" input field
        driver.findElement(By.xpath("//input[@class=\"form-control\"]")).clear(); 

        // Inputs the date "01-01-2025" into the "From Date" field
        driver.findElement(By.xpath("//input[@class=\"form-control\"]")).sendKeys("01-01-2025");

        // Waits for and clicks the "Apply Filter" button to apply the selected filters
        we.waitAndClick(de.getApplyFilter());

        // Waits for and clicks the table to ensure it's loaded or interactable
        we.waitAndClick(de.getTable());

        // Waits for and clicks the "Export" button to export the table data
        we.waitAndClick(de.getExportbutton());
    }
}