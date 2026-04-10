package com.RecipeMasterPage;

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
import com.sgplus.erp.pomRepository.HomePage;
import com.sgplus.erp.pomRepository.MasterRecipe;

public class VerifyRecipeCodeFieldInputTest extends BaseClass {
	
	// TestNG test method annotation
		@Test
		public void VerifyRecipeCodeFieldInputTest() throws Throwable {

			// Create WebDriverUtility object for waits, clicks, dropdown handling
			WebDriverUtility we = new WebDriverUtility();

			// Create JavaUtility object to generate random numbers
			// Used to avoid duplicate department names
			JavaUtility jlib = new JavaUtility();

			// Create FileUtility object (used for property file reading if required)
			FileUtility flib = new FileUtility();

			// Create ExcelUtility object to read test data from Excel sheet
			ExcelUtility elib = new ExcelUtility();

			// Create HomePage POM object to access home page elements
			HomePage hm = new HomePage(driver);

			// Create Recipe POM object to access department-related elements
			MasterRecipe re = new MasterRecipe(driver);

			// Generate a random number to make the department name unique
			int intRanNum = jlib.getRandomNumber();

			// Read department base name from Excel (Sheet1, Row 2, Column 2)
			// Append random number to avoid duplication
			String Departmentname = elib.getDataFromExcel("Sheet1", 1, 1) + intRanNum;

			// Wait until all DOM elements are loaded
			we.waitForElementInDOM(driver);

			// Wait until the page is fully loaded
			we.waitUntilPageLoad(driver);

			// Click on the Settings menu from the Home page
			we.waitAndClick(hm.getSettings());

			// Click on the Departments option under Settings
			we.waitAndClick(re.getRecipedashboard());

			we.waitAndClick(re.getEdit3Dots());

			we.waitAndClick(re.getEditbutton());
			
			we.waitAndClick(re.getRecipecodeFiled());
			
			re.getRecipecodeFiled().clear();

			re.getRecipecodeFiled().sendKeys("EditRecipe1");

		   we.waitAndClick(re.getSubmitbutton());
			// Create explicit wait to wait for success toast message
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Wait until the success message is visible on the UI
			WebElement toastMsg = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Recipe updated successfully')]")));

			// Capture the actual success message text
			String actualMessage = toastMsg.getText();

			// Assert that the success message contains expected text
			Assert.assertTrue(actualMessage.contains("Recipe updated successfully"),
					"Recipe update success message is NOT displayed");

			// Print the success message in console for verification
			System.out.println("SUCCESS MESSAGE VERIFIED: " + actualMessage);

			we.waitAndClick(re.getSucessPopupmessageClose());  
		}
	}