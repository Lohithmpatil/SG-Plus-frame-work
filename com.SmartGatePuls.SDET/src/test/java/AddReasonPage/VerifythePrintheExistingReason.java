package AddReasonPage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.ExcelUtility;
import com.sgplus.erp.genericutility.FileUtility;
import com.sgplus.erp.genericutility.JavaUtility;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.HomePage;
import com.sgplus.erp.pomRepository.ReasonMaster;

public class VerifythePrintheExistingReason extends BaseClass {

	@Test
	public void VerifythePrintheExistingReason() throws Throwable {

		// Create WebDriverUtility object (custom utility for wait, click, etc.)
		WebDriverUtility wb = new WebDriverUtility();

		// Create JavaUtility object (used for generating random numbers)
		JavaUtility jlib = new JavaUtility();

		// Create FileUtility object (used for reading data from property file if
		// needed)
		FileUtility flib = new FileUtility();

		// Create ExcelUtility object (used to read test data from Excel file)
		ExcelUtility elib = new ExcelUtility();

		// Create HomePage object (POM class for Home Page elements)
		HomePage hm = new HomePage(driver);

		// Generate random number to avoid duplicate Reason Name
		int intRanNum = jlib.getRandomNumber();

		// Read Reason Name from Excel and append random number
		String ReasonName = elib.getDataFromExcel("Sheet1", 1, 2) + intRanNum;

		// Read SAP Code from Excel and append random number
		String Sapcode = elib.getDataFromExcel("Sheet1", 1, 1) + intRanNum;

		// Create ReasonMaster page object
		ReasonMaster rm = new ReasonMaster(driver);

		// Wait until complete page is loaded
		wb.waitUntilPageLoad(driver);

		// Wait until DOM is fully ready
		wb.waitForElementInDOM(driver);

		// Click on Settings menu from home page
		wb.waitAndClick(hm.getSettings());

		// Click on Reason Dashboard
		wb.waitAndClick(rm.getReasondashboard());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Wait until table rows are visible
		List<WebElement> rows = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table/tbody/tr")));

		Assert.assertTrue(rows.size() > 0, "No records found in the table.");

		System.out.println("Total Records: " + rows.size());

		// Print table data
		for (int i = 0; i < rows.size(); i++) {

			List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));

			System.out.print("Row " + (i + 1) + " : ");

			for (WebElement column : columns) {
				System.out.print(column.getText().trim() + " | ");
			}

			System.out.println();

		}

	}
}
