package AddReasonPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.genericutility.ExcelUtility;
import com.sgplus.erp.genericutility.FileUtility;
import com.sgplus.erp.genericutility.JavaUtility;
import com.sgplus.erp.genericutility.WebDriverUtility;
import com.sgplus.erp.pomRepository.DepartmentGroup;
import com.sgplus.erp.pomRepository.HomePage;
import com.sgplus.erp.pomRepository.ReasonMaster;

public class AddReasonfuntionalityTest extends BaseClass {

	@Test
	public void AddReasonfuctionalityTest() throws Throwable {

		// Create WebDriverUtility object for custom wait and click operations
				WebDriverUtility wb = new WebDriverUtility();

				// Create JavaUtility object to generate random numbers
				JavaUtility jlib = new JavaUtility();

				// Create FileUtility object to read data from property files (if needed)
				FileUtility flib = new FileUtility();

				// Create ExcelUtility object to read test data from Excel sheet
				ExcelUtility elib = new ExcelUtility();

				// Create HomePage object to interact with home page elements
				HomePage hm = new HomePage(driver);

				// Create DepartmentGroup page object to interact with Department Group screen
				DepartmentGroup dg = new DepartmentGroup(driver);

				// Generate a random number to make department group name unique
				int intRanNum = jlib.getRandomNumber();

				// Read base group name from Excel and append random number
				String ReasonName = elib.getDataFromExcel("Sheet1", 1, 2) + intRanNum;

				String Sapcode = elib.getDataFromExcel("Sheet1", 2, 2) + intRanNum;
				
		ReasonMaster rm = new ReasonMaster(driver);

		wb.waitUntilPageLoad(driver);

		wb.waitForElementInDOM(driver);

		wb.waitAndClick(hm.getSettings());

		// driver.findElement(By.xpath(null))

		wb.waitAndClick(rm.getReasondashboard());

		wb.waitAndClick(rm.getAddReasonButton());

		wb.waitAndClick(rm.getReasonNamefield());

		rm.getReasonNamefield().sendKeys(ReasonName);
		
		wb.waitAndClick(rm.getReasonsDescriptionfield());
		
		rm.getReasonsDescriptionfield().sendKeys("Add reason for automation test");
		
		wb.waitAndClick(rm.getSAPcodefield());
		
		rm.getSAPcodefield().sendKeys(Sapcode);
		
		wb.waitAndClick(rm.getAreadropdown());
		
		wb.waitAndClick(rm.getAreaCheckbox());
		 
	}
	
	
	

}
