package com.sgplus.erp.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DowntimeAnalysisPage {

	WebDriver driver;

	public DowntimeAnalysisPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Analysis']")
	private WebElement DowntimeAnalysis;

	/* ================= DASHBOARD ================= */

	public WebElement getDowntimeAnalysis() {
		return DowntimeAnalysis;
	}
	/* ================= FILTER ================= */

	@FindBy(xpath = "//i[@class='fa fa-filter']")
	private WebElement FilterButton;

	public WebElement getFilterButton() {
		return FilterButton;
	}

	public void setFilterButton(WebElement filterButton) {
		FilterButton = filterButton;
	}

	/* ================= BU ================= */

	@FindBy(xpath = "//div[@aria-labelledby=\"Bu\"]")
	private WebElement BUDropDown;

	@FindBy(xpath = "//span[text()='BU3']")
	private WebElement Bu3checkbox;

	@FindBy(xpath = "//div[@aria-labelledby=\"Bu\"]")
	private WebElement CollpaseBUdropdown;

	public WebElement getBUDropDown() {
		return BUDropDown;
	}

	public WebElement getBu3checkbox() {
		return Bu3checkbox;
	}

	public WebElement getCollpaseBUdropdown() {
		return CollpaseBUdropdown;
	}

	/* ================= AREA ================= */

	@FindBy(xpath = "//div[@aria-labelledby=\"Area\"]")
	private WebElement AreaDropDown;

	@FindBy(xpath = "//span[text()='TBM-PCR']")
	private WebElement AreaCheckox;

	@FindBy(xpath = "//div[@aria-labelledby=\"Area\"]")
	private WebElement CollpaseAreadropdown;

	public WebElement getAreaDropDown() {
		return AreaDropDown;
	}

	public void setAreaDropDown(WebElement areaDropDown) {
		AreaDropDown = areaDropDown;
	}

	public WebElement getAreaCheckox() {
		return AreaCheckox;
	}

	public WebElement getCollpaseAreadropdown() {
		return CollpaseAreadropdown;
	}

	/* ================= GROUP ================= */

	@FindBy(xpath = "//div[@aria-labelledby=\"Group\"]")
	private WebElement GroupDropDown;

	@FindBy(xpath = "//span[text()='Unistage']")
	private WebElement GroupCheckbox;

	@FindBy(xpath = "//div[@aria-labelledby=\"Group\"]")
	private WebElement CollpaseGroupdropdown;

	public WebElement getGroupDropDown() {
		return GroupDropDown;
	}

	public void setGroupDropDown(WebElement groupDropDown) {
		GroupDropDown = groupDropDown;
	}

	public WebElement getGroupCheckbox() {
		return GroupCheckbox;
	}

	public WebElement getCollpaseGroupdropdown() {
		return CollpaseGroupdropdown;
	}

	/* ================= EQUIPMENT ================= */

	@FindBy(xpath = "//div[@aria-labelledby=\"Equipments\"]")
	private WebElement EquipementDropDown;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement EquipementCheckbox;

	@FindBy(xpath = "//div[@aria-labelledby=\"Equipments\"]")
	private WebElement CollpaseEquipementsdropdown;

	public WebElement getEquipementDropDown() {
		return EquipementDropDown;
	}

	public void setEquipementDropDown(WebElement equipementDropDown) {
		EquipementDropDown = equipementDropDown;
	}

	public WebElement getEquipementCheckbox() {
		return EquipementCheckbox;
	}

	public WebElement getCollpaseEquipementsdropdown() {
		return CollpaseEquipementsdropdown;
	}

	/* ================= APPLY FILTER ================= */

	@FindBy(xpath = "//button[text()=\"Apply Filter\"]")
	private WebElement ApplyFilter;

	public WebElement getApplyFilter() {
		return ApplyFilter;
	}

	public void setApplyFilter(WebElement applyFilter) {
		ApplyFilter = applyFilter;
	}

	/* ================= VALIDATION ================= */

	@FindBy(css = "[aria-label=\"2025-04, 1,218.84. Actual.\"]")
	private WebElement Montwisebarchart;

	@FindBy(css = "[aria-label=\"2024, 5,998.37. 2024.\"]")
	private WebElement Yearlywisebarchart;

	@FindBy(xpath = "//select[@name=\"department_grp_id\"]")
	private WebElement DepartmentGroupDropdown;

	@FindBy(xpath = "//select[@name=\"dept_id\"]")
	private WebElement DepartmentDropdown;

	@FindBy(xpath = "//button[text()=\"Go\"]")
	private WebElement GoButton;

	public WebElement getMontwisebarchart() {
		return Montwisebarchart;
	}

	public WebElement getYearlywisebarchart() {
		return Yearlywisebarchart;
	}

	public WebElement getDepartmentGroupDropdown() {
		return DepartmentGroupDropdown;
	}

	public WebElement getDepartmentDropdown() {
		return DepartmentDropdown;
	}

	public WebElement getGoButton() {
		return GoButton;
	}

}
