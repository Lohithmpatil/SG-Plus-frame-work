package AddReasonPage;

import java.time.Duration;

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
import com.sgplus.erp.pomRepository.DepartmentGroup;
import com.sgplus.erp.pomRepository.HomePage;
import com.sgplus.erp.pomRepository.ReasonMaster;

public class VerifytheReasonEditfunctionalityTest extends BaseClass {

	@Test
	public void VerifytheReasonEditfunctionalityTest() throws Throwable {

		// Create WebDriverUtility object for custom wait and click operations
		WebDriverUtility we = new WebDriverUtility();

		// Create JavaUtility object to generate random numbers
		JavaUtility jlib = new JavaUtility();

		// Create FileUtility object to read data from property files (if needed)
		FileUtility flib = new FileUtility();

		// Create ExcelUtility object to read test data from Excel sheet
		ExcelUtility elib = new ExcelUtility();

		// Create HomePage object to interact with home page elements
		HomePage hm = new HomePage(driver);
		// Create ReasonMaster page object
		ReasonMaster rm = new ReasonMaster(driver);

		// Generate a random number to make department group name unique
		int intRanNum = jlib.getRandomNumber();

		// Read base group name from Excel and append random number
		String Groupname = elib.getDataFromExcel("Sheet1", 1, 2) + intRanNum;

		// Wait until DOM elements are loaded
		we.waitForElementInDOM(driver);

		// Wait until the page is completely loaded
		we.waitUntilPageLoad(driver);

		// Click on Settings menu from home page
		we.waitAndClick(hm.getSettings());

		// Click on Department Group option under Settings
		we.waitAndClick(rm.getReasondashboard());

		we.waitAndClick(rm.getEdit3Dots());

		we.waitAndClick(rm.getEditbutton());

		Thread.sleep(200);

		rm.getReasonNamefield().sendKeys("Edited");

		we.waitAndClick(rm.getEquipementsdropdown());

		we.waitAndClick(rm.getEditEquipementsCheckbox());

		we.waitAndClick(rm.getCollpaseEquipementdropdown());

		we.waitAndClick(rm.getDepartmentdropdown());

		we.waitAndClick(rm.getDepartmentCheckbox());

		we.waitAndClick(rm.getCollapseDepartmentdropdown());

		we.waitAndClick(rm.getSubmitbutton());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement successMsg = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Reason updated successfully')]")));

		String actualMsg = successMsg.getText();
		String expectedMsg = "Reason updated successfully";

		System.out.println("Toast Message: " + actualMsg);

		Assert.assertEquals(actualMsg, expectedMsg);

	}

}
