package com.ReasonLinkingPage;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.HomePage;

public class CheckReasonUnlikedData extends BaseClass {
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

		// Get all rows (excluding header)
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='expanded-table']/tbody/tr"));
		System.out.println("Total Rows: " + rows.size());

		// Get all columns (header cells)
		List<WebElement> cols = driver.findElements(By.xpath("//table[@id='expanded-table']/thead/tr/th"));
		System.out.println("Total Columns: " + cols.size());

		boolean found = false;
		for (WebElement row : rows) {
			if (row.getText().contains("UnLinked")) { // e.g. checking "linked" text
				found = true;
				break;
			}
		}
		if (found) {
			System.out.println("UnLinked record found!");
		} else {
			System.out.println("No Unlinked record found.");
		}

	}

}
