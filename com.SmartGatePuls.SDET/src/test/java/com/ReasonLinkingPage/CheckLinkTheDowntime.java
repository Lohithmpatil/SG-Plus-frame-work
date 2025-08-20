package com.ReasonLinkingPage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.HomePage;

public class CheckLinkTheDowntime extends BaseClass {
	@Test
	public void Reasonlinkingpage() throws InterruptedException {

		WebDriverUtility we = new WebDriverUtility();

		HomePage hm = new HomePage(driver);
		com.sgplus.erp.pomRepository.ReasonLinking rs = new com.sgplus.erp.pomRepository.ReasonLinking(driver);

		we.waitAndClick(hm.getDownTime());

		we.waitAndClick(rs.getReasonLinking());

		we.waitAndClick(rs.getBUDropDown());

		we.select(rs.getBUDropDown(), "BU3");

		we.waitAndClick(rs.getEquipemetsDropDown());

		we.waitAndClick(rs.getEqCheckBox());

		we.waitAndClick(rs.getFromDate());

		we.waitForElement(driver, rs.getFromDate());

		driver.findElement(By.xpath("//input[@class=\"form-control\"]")).clear();
		driver.findElement(By.xpath("//input[@class=\"form-control\"]")).sendKeys("14-01-2025");

		we.waitAndClick(rs.getLinkDropDown());
		we.select(rs.getLinkDropDown(), "Unlinked");

		we.waitAndClick(rs.getSearchButton());

		we.waitAndClick(rs.getLinkButton());

		we.waitAndClick(rs.getDepartmentGroupDropdown());

		we.select(rs.getDepartmentGroupDropdown(), 1);

		we.waitAndClick(rs.getDepartmentDropdown());

		we.select(rs.getDepartmentDropdown(), 1);

		// Click the dropdown to expand
		we.waitAndClick(rs.getReason());

		we.waitAndClick(rs.getReasonOption());

		we.waitAndClick(rs.getCommentField());

		rs.getCommentField().sendKeys("Automation test reason");

		we.waitAndClick(rs.getSaveButton());

		we.waitAndClick(rs.getSuccesMsg());

		String actualMsg = rs.getSuccesMsg().getText();

		String expectedMsg = "Reason(s) linked to downtime successfully";

		// Assertion
		Assert.assertTrue(actualMsg.contains(expectedMsg), "Expected success message not found! Actual: " + actualMsg);
	}

}
