package com.DowntimeModule; 
// Package name where this test class is stored

// Static imports for assertion methods from TestNG
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

// Import for List interface
import java.util.List;

// Selenium imports
import org.openqa.selenium.By;                     // Used to locate elements
import org.openqa.selenium.JavascriptExecutor;    // Used to execute JavaScript in browser
import org.openqa.selenium.WebElement;            // Represents a web element
import org.openqa.selenium.interactions.Actions;  // Used for advanced user interactions
import org.openqa.selenium.support.ui.ExpectedConditions; // Used for wait conditions
import org.openqa.selenium.support.ui.WebDriverWait;     // Used for explicit waits

// TestNG imports
import org.testng.Assert;                         // Assertion class
import org.testng.annotations.Test;               // Used to mark test methods

// Base class and utility imports
import com.sgplus.erp.genericutility.BaseClass;          // Base class for setup & teardown
import com.sgplus.erp.genericutility.WebDriverUtility;  // Utility class for waits and actions
import com.sgplus.erp.pomRepository.DowntimeDashboardPage; // POM class for Downtime page
import com.sgplus.erp.pomRepository.HomePage;           // POM class for Home page

// Test class extending BaseClass to inherit WebDriver setup
public class DowntimeBestMachineTest extends BaseClass {

    // TestNG test method
    @Test
    public void DowntimeBestMachineTest() throws Throwable {

        // Create object of WebDriverUtility for common operations like wait and click
        WebDriverUtility we = new WebDriverUtility();

        // Create object of HomePage POM class
        HomePage hm = new HomePage(driver);

        // Create object of DowntimeDashboardPage POM class
        DowntimeDashboardPage dt = new DowntimeDashboardPage(driver);

        // Wait until the page is fully loaded
        we.waitUntilPageLoad(driver);

        // Wait until all elements are loaded in the DOM
        we.waitForElementInDOM(driver);

        // Click on Down Time module from home page
        we.waitAndClick(hm.getDownTime());

        // Click on Downtime Dashboard option
        we.waitAndClick(hm.getDowntimeDashboard());

        // Click on filter button
        we.waitAndClick(dt.getFilterButton());

        // Click on BU dropdown
        we.waitAndClick(dt.getBUDropDown());

        // Select BU3 checkbox
        we.waitAndClick(dt.getBu3checkbox());

        // Collapse BU dropdown
        we.waitAndClick(dt.getCollpaseBUdropdown());

        // Click on Area dropdown
        we.waitAndClick(dt.getAreaDropDown());

        // Select Area checkbox (TBM-PCR)
        we.waitAndClick(dt.getAreaCheckox());

        // Collapse Area dropdown
        we.waitAndClick(dt.getCollpaseAreadropdown());

        // Click on Group dropdown
        we.waitAndClick(dt.getGroupDropDown());

        // Select Group checkbox (Unistage)
        we.waitAndClick(dt.getGroupCheckbox());

        // Collapse Group dropdown
        we.waitAndClick(dt.getCollpaseGroupdropdown());

        // Click on Equipment dropdown
        we.waitAndClick(dt.getEquipementDropDown());

        // Select Equipment checkbox
        we.waitAndClick(dt.getEquipementCheckbox());

        // Collapse Equipment dropdown
        we.waitAndClick(dt.getCollpaseEquipementsdropdown());

        // Click on Period dropdown
        we.waitAndClick(dt.getPeriodDropDown());

        // Select "Range" option from Period dropdown
        we.select(dt.getPeriodDropDown(), "Range");

        // Click on From Date input field
        we.waitAndClick(dt.getFromdateSelection());

        // Enter From Date value
        dt.getFromdateSelection().sendKeys("01-01-2025");

        // Click on To Date input field
        we.waitAndClick(dt.getTodateSelection());

        // Enter To Date value
        dt.getTodateSelection().sendKeys("30-01-2025");

        // Click on Shift dropdown
        we.waitAndClick(dt.getShiftDropDown());

        // Select "All" from Shift dropdown
        we.select(dt.getShiftDropDown(), "All");

        // Click on Apply Filter button
        we.waitAndClick(dt.getApplyFilter());

        // Create JavaScriptExecutor object to scroll the page
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll to the bottom of the page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Click on Best Performing Machines section
        we.waitAndClick(dt.getBestPerfomingMachine());

        // Get all rows from Best Performing Machines table
        List<WebElement> bestRows = driver.findElements(
            By.xpath("//div[contains(text(),'BEST PERFORMING MACHINES')]/following::table[1]/tbody/tr")
        );

        // Verify that at least one row is present
        assertTrue(bestRows.size() > 0, "No best performing machines found");

        // Loop through each row in the table
        for (WebElement row : bestRows) {

            // Get all column cells (td) in the row
            List<WebElement> cols = row.findElements(By.tagName("td"));

            // Get machine name from first column
            String machineName = cols.get(0).getText().trim();

            // Get downtime value from second column
            String downtime = cols.get(1).getText().trim();

            // Validate machine name is not empty
            assertFalse(machineName.isEmpty(), "Machine name is empty");

            // Validate downtime format (example: 23.5 mins)
            assertTrue(downtime.matches("\\d+(\\.\\d+)? mins"),
                       "Invalid downtime format: " + downtime);
        }
    }
}
