package com.AddAssociates;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.AddAssociates;
import com.sgplus.erp.pomRepository.HomePage;

public class PrintAllAssociatesTableData extends BaseClass {

	@Test
	public void PrintAllAssociatesTableData() throws Throwable {

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
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table/tbody/tr")));

		// List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

		for (WebElement row : rows) {

			List<WebElement> cols = row.findElements(By.tagName("td"));

			for (WebElement col : cols) {
				System.out.print(col.getText() + " | ");
			}

			System.out.println();
		}
	}
}
