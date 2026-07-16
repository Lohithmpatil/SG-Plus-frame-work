package com.AddAssociates;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.AddAssociates;
import com.sgplus.erp.pomRepository.HomePage;

public class VerifyAssociatesTableContainsData extends BaseClass {

	@Test
	public void VerifyAssociatesTableContainsData() throws Throwable {

		// Create WebDriverUtility object for handling waits and actions
		WebDriverUtility we = new WebDriverUtility();

		// Create HomePage object to access home page elements
		HomePage hm = new HomePage(driver);

		AddAssociates ad = new AddAssociates(driver);

		we.waitAndClick(hm.getSettings());

		we.waitAndClick(ad.getAddAssociatesPage());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Wait until all table headers are visible
		List<WebElement> rows = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table/thead/tr/th")));

		Assert.assertTrue(rows.size() > 0, "No records found in table.");

		System.out.println("Total Rows : " + rows.size());
	}
}
