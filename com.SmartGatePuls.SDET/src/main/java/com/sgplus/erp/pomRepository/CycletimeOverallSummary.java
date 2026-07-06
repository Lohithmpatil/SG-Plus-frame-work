package com.sgplus.erp.pomRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CycletimeOverallSummary {
	private WebDriver driver;

	// Constructor
	public CycletimeOverallSummary(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/* =================DASHBOARD================= */

	// WebElements - identified using @FindBy
	@FindBy(xpath = "//div[@title=\"Overall Summary\"]")
	private WebElement OverallSummarypageNavigation;

	/* ================= FILTER ================= */

	public WebElement getOverallSummarypageNavigation() {
		return OverallSummarypageNavigation;
	}

	public WebDriver getDriver() {
		return driver;
	}

	@FindBy(xpath = "//i[@class='fa fa-filter']")
	private WebElement FilterButton;

	public WebElement getFilterButton() {
		return FilterButton;
	}

	public void setFilterButton(WebElement filterButton) {
		FilterButton = filterButton;
	}

	/* ===================== BU ===================== */

	@FindBy(xpath = "//select[@class='form-control']")
	private WebElement BUDropDown;

	public WebElement getBUDropDown() {
		return BUDropDown;
	}

	/* ===================== AREA ===================== */

	@FindBy(xpath = "//select[@class='form-control  ']")
	private WebElement AreaDropDown;

	public WebElement getAreaDropDown() {
		return AreaDropDown;
	}

	/* ===================== GROUP ===================== */

	@FindBy(xpath = "//select[@class='form-control ']")
	private WebElement GroupDropDown;

	public WebElement getGroupDropDown() {
		return GroupDropDown;
	}

	/* ===================== SHIFT ===================== */

	@FindBy(xpath = "//label[text()='Shift ']/following-sibling::select")
	private WebElement ShiftDropDown;

	public WebElement getShiftDropDown() {
		return ShiftDropDown;
	}

	/* ===================== EQUIPMENT ===================== */

	@FindBy(css = "[aria-labelledby='Equipments']")
	private WebElement EquipementDropDown;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement EquipementCheckbox;

	@FindBy(xpath = "//div[@aria-labelledby='Equipments']")
	private WebElement CollpaseEquipementsdropdown;

	public WebElement getEquipementDropDown() {
		return EquipementDropDown;
	}

	public WebElement getEquipementCheckbox() {
		return EquipementCheckbox;
	}

	public WebElement getCollpaseEquipementsdropdown() {
		return CollpaseEquipementsdropdown;
	}

	/* ===================== PERIOD ===================== */

	@FindBy(xpath = "//select[@class='form-control w-100']")
	private WebElement PeriodDropDown;

	public WebElement getPeriodDropDown() {
		return PeriodDropDown;
	}

	/* ===================== FROM DATE ===================== */

	@FindBy(xpath = "//label[text()='From Dates ']/following-sibling::input")
	private WebElement FromdateSelection;

	public WebElement getFromdateSelection() {
		return FromdateSelection;
	}

	/* ===================== TO DATE ===================== */

	@FindBy(xpath = "//label[text()='To Date ']/following-sibling::input")
	private WebElement TodateSelection;

	public WebElement getTodateSelection() {
		return TodateSelection;
	}

	/* ===================== RECIPE ===================== */

	@FindBy(xpath = "//label[normalize-space()='Recipes']/following-sibling::div//div[@tabindex='0']")
	private WebElement RecipeDropDown;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement RecipeDropDownCheckbox;

	@FindBy(xpath = "//label[normalize-space()='Recipes']/following-sibling::div//div[@tabindex='0']")
	private WebElement CollapseRecipedropdown;

	public WebElement getRecipeDropDown() {
		return RecipeDropDown;
	}

	public WebElement getRecipeDropDownCheckbox() {
		return RecipeDropDownCheckbox;
	}

	public WebElement getCollapseRecipedropdown() {
		return CollapseRecipedropdown;
	}

	/* ===================== APPLY FILTER ===================== */

	@FindBy(xpath = "//button[text()='Apply Filter']")
	private WebElement ApplyFilter;

	public WebElement getApplyFilter() {
		return ApplyFilter;
	}

	/* ===================== EXPORT ===================== */

	@FindBy(xpath = "//button[@title='Export']")
	private WebElement ExportButton;

	public WebElement getExportButton() {
		return ExportButton;

	}

	@FindBy(xpath = "//div[contains(.,'OVERALL PRODUCTION LOSS')]")
	private WebElement overallProductionLossCard;

	@FindBy(xpath = "//div[contains(.,'OVERALL PRODUCTION LOSS')]//div[contains(@class,'row')]//a")
	private List<WebElement> overallProductionLossLabels;

	@FindBy(xpath = "//div[contains(.,'OVERALL PRODUCTION LOSS')]//div[contains(@class,'text-right')]")
	private List<WebElement> overallProductionLossValues;

	public WebElement getOverallProductionLossCard() {
		return overallProductionLossCard;
	}

	public List<WebElement> getOverallProductionLossLabels() {
		return overallProductionLossLabels;
	}

	public List<WebElement> getOverallProductionLossValues() {
		return overallProductionLossValues;
	}
	
	public WebElement getViewdetailsTogglebutton() {
		return ViewdetailsTogglebutton;
	}

	@FindBy(xpath = "//input[@id=\"custom-switch\"]")
	private WebElement ViewdetailsTogglebutton;
}