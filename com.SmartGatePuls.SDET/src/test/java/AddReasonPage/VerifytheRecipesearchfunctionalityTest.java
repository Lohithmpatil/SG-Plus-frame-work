package AddReasonPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import com.sgplus.erp.pomRepository.DepartmentGroup;
import com.sgplus.erp.pomRepository.HomePage;
import com.sgplus.erp.pomRepository.ReasonMaster;

public class VerifytheRecipesearchfunctionalityTest extends BaseClass {
	// TestNG test method
		@Test
		public void VerifytheRecipesearchfunctionalityTest() throws Throwable {

			// Create WebDriverUtility object (custom utility for wait, click, etc.)
			WebDriverUtility wb = new WebDriverUtility();

			// Create JavaUtility object (used for generating random numbers)
			JavaUtility jlib = new JavaUtility();

			// Create FileUtility object (used for reading data from property file if needed)
			FileUtility flib = new FileUtility();

			// Create ExcelUtility object (used to read test data from Excel file)
			ExcelUtility elib = new ExcelUtility();

			// Create HomePage object (POM class for Home Page elements)
			HomePage hm = new HomePage(driver);

			// Generate random number to avoid duplicate Reason Name
			int intRanNum = jlib.getRandomNumber();

			// Read Reason Name from Excel and append random number
			String ReasonName = elib.getDataFromExcel("Sheet1", 1, 1) + intRanNum;

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
			
			// Locate search field
			WebElement searchField = rm.getSearchfield();

			// Enter search text
			// searchField.clear();
			searchField.clear();
			searchField.sendKeys("AutomatonTest748");
			searchField.sendKeys(Keys.ENTER);

			// Wait for table to update
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='AutomatonTest748']")));

			// Fetch table result
			WebElement resultName = driver.findElement(By.xpath("//td[text()='AutomatonTest748']"));

			// Validation
			Assert.assertEquals(resultName.getText(), "AutomatonTest748");
	
	
		}

}
