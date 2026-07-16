package com.sgplus.erp.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DowntimeTarget {
	private WebDriver driver;

	// Constructor
	public DowntimeTarget(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/* ================= DASHBOARD ================= */

// WebElements - identified using @FindBy
	@FindBy(xpath = "//div[@title=\"Downtime Target\"]")
	private WebElement DowntimeTargetPage;

	/* ================= FILTER ================= */

	

	

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getDowntimeTargetPage() {
		return DowntimeTargetPage;
	}

	public WebElement getDowntimeTargetTextFeild() {
		return DowntimeTargetTextFeild;
	}

	@FindBy(xpath = "//i[@class='fa fa-filter']")
	private WebElement FilterButton;

	public WebElement getFilterButton() {
		return FilterButton;
	}

	public void setFilterButton(WebElement filterButton) {
		FilterButton = filterButton;
	}

	/* ================= BU ================= */

	@FindBy(xpath = "//select[@class=\"form-control\"]")
	private WebElement BUDropDown;

	public WebElement getBUDropDown() {
		return BUDropDown;
	}

	public WebElement getAreaDropDown() {
		return AreaDropDown;
	}

	public WebElement getGroupDropDown() {
		return GroupDropDown;
	}

	@FindBy(xpath = "//select[@class=\"form-control  \"]")
	private WebElement AreaDropDown;

	@FindBy(xpath = "//select[@class='form-control ']")
	private WebElement GroupDropDown;

	/* ================= APPLY FILTER ================= */

	@FindBy(xpath = "//button[text()=\"Apply Filter\"]")
	private WebElement ApplyFilter;

	public WebElement getApplyFilter() {
		return ApplyFilter;
	}
	/* ================= VALIDATION ================= */

	public WebElement getExportButton() {
		return ExportButton;
	}

	@FindBy(xpath = "//button[@title=\"Export\"]")
	private WebElement ExportButton;

	@FindBy(xpath = "//div[@aria-labelledby=\"depts-action\"]")
	private WebElement EditButton;

	public WebElement getUpdateButton() {
		return UpdateButton;
	}

	public WebElement getCancelButton() {
		return CancelButton;
	}

	

	public WebElement getCheckBOx() {
		return CheckBOx;
	}

	public WebElement getCloseBulkLinkButton() {
		return CloseBulkLinkButton;
	}

	@FindBy(xpath = "//input[@placeholder=\"Loss Percentage\"]")
	private WebElement DowntimeTargetTextFeild;


	public WebElement getOEETargetTextFeild() {
		return DowntimeTargetTextFeild;
	}

	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement UpdateButton;

	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement CancelButton;

	@FindBy(xpath = "//button[@title=\"Bulk Link\"]")
	private WebElement BulkButton;
	
	public WebElement getBulkButton2() {
		return BulkButton2;
	}

	@FindBy(xpath = "//button[text()=\"Bulk Link\"]")
	private WebElement BulkButton2;

	public WebElement getBulkButton() {
		return BulkButton;
	}

	@FindBy(xpath = "//input[@type=\"checkbox\"]")
	private WebElement CheckBOx;

	@FindBy(xpath = "//button[@title=\"Close Bulk Linking\"]")
	private WebElement CloseBulkLinkButton;

	public WebElement getDots3Button() {
		return Dots3Button;
	}

	@FindBy(xpath = "//button[@id=\"depts-action\"]")
	private WebElement Dots3Button;
	
	public WebElement getSaveChangesBtn() {
		return SaveChangesBtn;
	}

	@FindBy(xpath = "//button[text()=\"SAVE CHANGES\"]")
	private WebElement 	SaveChangesBtn;

	public WebElement getEditButton() {
		return EditButton;
	}
}