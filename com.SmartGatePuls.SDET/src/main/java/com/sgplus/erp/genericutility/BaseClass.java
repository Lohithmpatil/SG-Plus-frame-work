package com.sgplus.erp.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.sgplus.erp.pomRepository.HomePage;
import com.sgplus.erp.pomRepository.LoginPage;

public class BaseClass {

	public static WebDriver driver;

	/* Object Creation for Lib */
	public WebDriverUtility wLib = new WebDriverUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();

	// @BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void configBS() {

		System.out.println("========================connect to DB========================");
	}

	@Parameters("BROWSER")

	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void configBC() {
		System.out.println("=============Launch the Browser=======");
		driver = new ChromeDriver();
		wLib.waitUntilPageLoad(driver);
		driver.manage().window().maximize();
	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void configBM() throws Throwable {
		/* common Data */
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String URL = fLib.getPropertyKeyValue("url");
		String BROWSER = fLib.getPropertyKeyValue("browser");

		/* Navigate to app */
		driver.get(URL);

		/* step 1 : login */
		LoginPage lp = new LoginPage(driver);
		lp.logintoApp(USERNAME, PASSWORD);
		
		System.out.println("=============Succesfully Login to the SmartGate application=======");
	}

	//@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void configAM() {
		// step 6 : logout
		HomePage homePage = new HomePage(driver);
		homePage.getLogOut().click();
		System.out.println("=============Succesfully Logout to the SmartGate application=======");
		
	}

	 //@AfterClass(groups={"smokeTest","regressionTest"})
	public void configAC() {
		System.out.println("=============Close the Browser=======");
		driver.quit();
	}

	// @AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void configAS() {
		System.out.println("========================close DB========================");

	}

}
