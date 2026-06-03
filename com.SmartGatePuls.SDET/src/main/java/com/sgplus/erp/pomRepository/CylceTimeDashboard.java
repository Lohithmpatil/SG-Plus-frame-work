package com.sgplus.erp.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CylceTimeDashboard {
	private WebDriver driver;

	// Constructor
	public CylceTimeDashboard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

/* ================= DASHBOARD ================= */

// WebElements - identified using @FindBy
@FindBy(xpath = "//li[@class='nav-item hover-open']//span[text()='Dashboard']")
private WebElement CycleTimedashboard;


/* ================= FILTER ================= */

public WebDriver getDriver() {
	return driver;
}

public WebElement getCycleTimedashboard() {
	return CycleTimedashboard;
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

public WebElement getShiftDropDown() {
	return ShiftDropDown;
}

@FindBy(xpath = "//select[@class=\"form-control  \"]")
private WebElement AreaDropDown;

@FindBy(xpath = "//select[@class='form-control ']")
private WebElement GroupDropDown;



@FindBy(xpath = "//label[text()='Shift ']/following-sibling::select")
private WebElement ShiftDropDown;


@FindBy(css = "[aria-labelledby=\"Equipments\"]")
private WebElement EquipementDropDown;

public WebElement getEquipementDropDown() {
	return EquipementDropDown;
}

public WebElement getEquipementCheckbox() {
	return EquipementCheckbox;
}

public WebElement getCollpaseEquipementsdropdown() {
	return CollpaseEquipementsdropdown;
}

@FindBy(xpath = "//input[@type='checkbox']")
private WebElement EquipementCheckbox;

@FindBy(xpath = "//div[@aria-labelledby=\"Equipments\"]")
private WebElement CollpaseEquipementsdropdown;


public WebElement getPeriodDropDown() {
	return PeriodDropDown;
}

public WebElement getFromdateSelection() {
	return FromdateSelection;
}

public WebElement getTodateSelection() {
	return TodateSelection;
}

@FindBy(xpath = "//select[@class=\"form-control w-100\"]")
private WebElement PeriodDropDown;

@FindBy(xpath = "//label[text()='From Dates ']/following-sibling::input")
private WebElement FromdateSelection;

@FindBy(xpath = "//label[text()='To Date ']/following-sibling::input")
private WebElement TodateSelection;


/* ================= APPLY FILTER ================= */

@FindBy(xpath = "//button[text()=\"Apply Filter\"]")
private WebElement ApplyFilter;

public WebElement getApplyFilter() {
	return ApplyFilter;
}
/* ================= VALIDATION ================= */


@FindBy(xpath = "//select[@id=\"totalDowntimeUnitType\"]")
private WebElement unitdropdown;



public WebElement getUnitdropdown() {
	return unitdropdown;
}

public WebElement getRecipedropdown() {
	return Recipedropdown;
}

public WebElement getXaxisDropdown() {
	return XaxisDropdown;
}

@FindBy(xpath = "//div[@aria-labelledby=\"Select Recipes\"]")
private WebElement Recipedropdown;

@FindBy(xpath = "//select[@placeholder=\"Select\"]")
private WebElement XaxisDropdown;

public WebElement getExportButton() {
	return ExportButton;
}

@FindBy(xpath = "//button[@title=\"Export\"]")
private WebElement ExportButton;

}
