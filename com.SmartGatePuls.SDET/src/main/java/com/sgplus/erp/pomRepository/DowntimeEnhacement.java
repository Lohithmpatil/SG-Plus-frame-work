package com.sgplus.erp.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DowntimeEnhacement {

	WebDriver driver;

	public DowntimeEnhacement(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/* ================= DASHBOARD ================= */

	@FindBy(xpath = "//span[text()='Enhancement']")
	private WebElement EnhacementModule;

	public WebElement getEnhacementModule() {
		return EnhacementModule;
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

	/* ================= PERIOD ================= */

	@FindBy(xpath = "//select[@class=\"form-control w-100\"]")
	private WebElement PeriodDropDown;

	public WebElement getPeriodDropDown() {
		return PeriodDropDown;
	}

	public void setPeriodDropDown(WebElement periodDropDown) {
		PeriodDropDown = periodDropDown;
	}

	/* ================= SHIFT ================= */

	@FindBy(xpath = "//label[text()='Shift ']/following-sibling::select")
	private WebElement ShiftDropDown;

	public WebElement getShiftDropDown() {
		return ShiftDropDown;
	}

	/* ================= DATE ================= */

	@FindBy(xpath = "//input[@class=\"form-control\"]")
	private WebElement FromdateSelection;

	@FindBy(xpath = "//label[text()='To Date ']/following-sibling::input")
	private WebElement TodateSelection;

	public WebElement getFromdateSelection() {
		return FromdateSelection;
	}

	public WebElement getTodateSelection() {
		return TodateSelection;
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

	@FindBy(xpath = "//div[@class=\"w-100  overflow-scroll mt-4\"]")
	private WebElement Table;

	@FindBy(xpath = "//span[text()=\"DOWNTIME DETAIL ENHANCEMENT\"]")
	private WebElement HeaderText;

	@FindBy(xpath = "//button[@title=\"Export\"]")
	private WebElement ExportButtton;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getExportButtton() {
		return ExportButtton;
	}

	public WebElement getHeaderText() {
		return HeaderText;
	}

	public WebElement getTable() {
		return Table;
	}

}
