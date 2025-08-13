package com.ERP.LoginPage.java;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.DowntiemDashboard;
import com.sgplus.erp.pomRepository.HomePage;

public class DowntimeDashboardTest extends BaseClass {
@Test
	public void Homepage() throws Throwable {
		WebDriverUtility we = new WebDriverUtility();
		Loginpage lp = new Loginpage();
		
             HomePage hm=new HomePage(driver);

		DowntiemDashboard dt=new DowntiemDashboard(driver);
		
	we.waitUntilPageLoad(driver);
	we.waitForElementInDOM(driver);
	

		// Wait for page to load
		we.waitAndClick(hm.getDownTime());

		// Open the down time dash board page
		we.waitAndClick(hm.getDowntimeDashboard());

		we.waitAndClick(dt.getFilterButton());

		we.waitAndClick(dt.getBUDropDown());
		
		
		we.select(dt.getBUDropDown(), "BU3");
		
		we.waitAndClick(dt.getAreaDropDown());

		we.select(dt.getAreaDropDown(), "TBM-PCR");
		
		we.waitAndClick(dt.getGroupDropDown());

		we.select(dt.getGroupDropDown(), "Unistage");
		
		we.waitAndClick(dt.getEquipementDropDown());
		
		
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
		driver.findElement(By.cssSelector("[class=\"dropdown-heading-dropdown-arrow gray\"]")).click();
	
		
		we.waitAndClick(dt.getPeriodDropDown());

		we.select(dt.getPeriodDropDown(), "Year");
		
		we.waitAndClick(dt.getShiftDropDown());
		
		we.select(dt.getShiftDropDown(), "All");
		

		we.waitAndClick(dt.getApplyFilter());
		
		//we.waitForElementInDOM(driver);
		//we.waitForElement(driver, null);
		
		// Verify TOTAL DOWNTIME
	//	we.wait(100);
		
	//	WebElement totalDowntime = driver.findElement(By.xpath("//div[@class='total-downtime']"));
	//	Assert.assertTrue(totalDowntime.isDisplayed(), "Total Downtime is not displayed");
	//	Assert.assertTrue(totalDowntime.getText().matches("\\d{1,3}(,\\d{3})*(\\.\\d+)?"), "Total Downtime format mismatch");


	}
}