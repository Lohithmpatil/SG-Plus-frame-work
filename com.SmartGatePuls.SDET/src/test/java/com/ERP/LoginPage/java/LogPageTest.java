package com.ERP.LoginPage.java;

import org.testng.annotations.Test;

import com.sgplus.erp.genericutility.BaseClass;
import com.sgplus.erp.pomRepository.LoginPage;

public class LogPageTest extends BaseClass {

	@Test
	public void loginTest() {
		// Test login functionality here
		LoginPage lp = new LoginPage(driver);

	}
}
