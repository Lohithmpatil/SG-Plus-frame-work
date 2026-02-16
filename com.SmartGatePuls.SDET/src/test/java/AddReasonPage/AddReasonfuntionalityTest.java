package AddReasonPage;   // Package name where this test class belongs

// Importing required Java and Selenium libraries
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

// Importing your framework utility classes
import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.ExcelUtility;
import com.sgplus.erp.genericutility.FileUtility;
import com.sgplus.erp.genericutility.JavaUtility;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.DepartmentGroup;
import com.sgplus.erp.pomRepository.HomePage;
import com.sgplus.erp.pomRepository.ReasonMaster;

// Test class extending BaseClass (BaseClass handles browser setup, login, teardown etc.)
public class AddReasonfuntionalityTest extends BaseClass {

	// TestNG test method
	@Test
	public void AddReasonfuctionalityTest() throws Throwable {

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

		// Click on Add Reason button
		wb.waitAndClick(rm.getAddReasonButton());

		// Click on Reason Name field
		wb.waitAndClick(rm.getReasonNamefield());

		// Enter generated Reason Name
		rm.getReasonNamefield().sendKeys(ReasonName);

		// Click Description field
		wb.waitAndClick(rm.getReasonsDescriptionfield());

		// Enter Description text
		rm.getReasonsDescriptionfield().sendKeys("Add reason for automation test");

		// Click SAP Code field
		wb.waitAndClick(rm.getSAPcodefield());

		// Enter generated SAP Code
		rm.getSAPcodefield().sendKeys(Sapcode);

		// Click Area dropdown
		wb.waitAndClick(rm.getAreadropdown());

		// Select Area checkbox option
		wb.waitAndClick(rm.getAreaCheckbox());

		// Collapse Area dropdown
		wb.waitAndClick(rm.getCollpaseAreadropdown());

		// Click Equipment dropdown
		wb.waitAndClick(rm.getEquipementsdropdown());

		// Select Equipment option
		wb.waitAndClick(rm.getEquipementsCheckbox());

		// Collapse Equipment dropdown
		wb.waitAndClick(rm.getCollpaseEquipementdropdown());

		// Click Department dropdown
		wb.waitAndClick(rm.getDepartmentdropdown());

		// Select Department option
		wb.waitAndClick(rm.getDepartmentCheckbox());

		// Collapse Department dropdown
		wb.waitAndClick(rm.getCollapseDepartmentdropdown());

		// Click Submit button to create Reason
		wb.waitAndClick(rm.getSubmitbutton());

		// Create explicit wait (maximum 10 seconds)
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait until success toast message is visible
		WebElement toastMsg = wait.until(
			ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(text(),'Reason created successfully')]")
			)
		);

		// Capture actual success message text
		String actualMessage = toastMsg.getText();

		// Validate success message using TestNG assertion
		Assert.assertTrue(
			actualMessage.contains("Reason created successfully"),
			"Reason creation success message is NOT displayed"
		);

		// Print success message in console
		System.out.println("SUCCESS MESSAGE VERIFIED: " + actualMessage);
	}
}
