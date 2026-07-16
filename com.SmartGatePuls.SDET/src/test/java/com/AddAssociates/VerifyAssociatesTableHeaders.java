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

public class VerifyAssociatesTableHeaders extends BaseClass {

	@Test
	public void VerifyAssociatesTableHeaders() throws Throwable {

		// Create WebDriverUtility object for handling waits and actions
		WebDriverUtility we = new WebDriverUtility();

		// Create HomePage object to access home page elements
		HomePage hm = new HomePage(driver);

		AddAssociates ad = new AddAssociates(driver);

		we.waitAndClick(hm.getSettings());

		we.waitAndClick(ad.getAddAssociatesPage());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		String[] expectedHeaders = { "Sno", "Name", "Sap Code", "Area", "Udaan/Batch No.", "Mobile", "Status",
				"Created At", "Action" };

		// Wait until all table headers are visible
		List<WebElement> actualHeaders = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table/thead/tr/th")));

		// Print all headers
		System.out.println("Actual Table Headers:");
		for (int i = 0; i < actualHeaders.size(); i++) {
			System.out.println("Header " + (i + 1) + " : " + actualHeaders.get(i).getText().trim());
		}

	}
}