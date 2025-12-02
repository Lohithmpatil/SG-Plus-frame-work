package com.OEEDashBoard;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.HomePage;
import com.sgplus.erp.pomRepository.OEEdashboard;

public class wait extends BaseClass {
	@Test
	public void ProductionCapacitylossgraphTest() throws Throwable {

		HomePage hm = new HomePage(driver);
		OEEdashboard oe = new OEEdashboard(driver);
		WebDriverUtility we = new WebDriverUtility();

		we.waitForElementInDOM(driver);
		hm.getOEE().click();
		oe.getOEEdashboard().click();
		oe.getFilterButton().click();
		oe.getBUDropDown().click();
		we.select(oe.getBUDropDown(), "BU3");
		oe.getAreaDropDown().click();
		we.select(oe.getAreaDropDown(), "TBM-PCR");
		oe.getGroupDropDown().click();
		we.select(oe.getGroupDropDown(), "Unistage");
		oe.getEquipementDropDown().click();
		oe.getEquipemntCheckBox().click();
		driver.findElement(By.cssSelector("[class=\"dropdown-heading-dropdown-arrow gray\"]")).click();
		oe.getPeriodDropDown().click();
		we.select(oe.getPeriodDropDown(), "Year");
		oe.getShiftDropDown().click();
		we.select(oe.getShiftDropDown(), "All");
		oe.getApplyFilter().click();
		oe.getVeiwDetailsToggleButton().click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		WebElement graph = driver.findElement(By.xpath("//label[text()=\"PRODUCTION CAPACITY LOSS\"]"));
		Assert.assertTrue(graph.isDisplayed(), "Production Capacity Loss graph is not displayed");
	}

}
