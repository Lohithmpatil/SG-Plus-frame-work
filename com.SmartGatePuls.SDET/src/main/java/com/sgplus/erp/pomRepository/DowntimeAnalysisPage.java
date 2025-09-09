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

	public WebElement getBUDropDown() {
		return BUDropDown;
	}

	public WebElement getAreaDropDown() {
		return AreaDropDown;
	}

	public WebElement getGroupDropDown() {
		return GroupDropDown;
	}

	public WebElement getDowntimeAnalysis() {
		return DowntimeAnalysis;
	}

	public WebElement getEquipementDropDown() {
		return EquipementDropDown;
	}

	public WebElement getFilterButton() {
		return FilterButton;
	}

	public WebElement getMontwisebarchart() {
		return Montwisebarchart;
	}

	public WebElement getApplyFilter() {
		return ApplyFilter;
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

	public WebElement getCheckBoxEquipements() {
		return CheckBoxEquipements;
	}

	public WebElement getCheckBoxEquipementsSelect() {
		return CheckBoxEquipementsSelect;
	}

	@FindBy(xpath = "//select[@class=\"form-control\"]")
	private WebElement BUDropDown;

	@FindBy(xpath = "//button[text()=\"Apply Filter\"]")
	private WebElement ApplyFilter;

	@FindBy(xpath = "//i[@class='fa fa-filter']")
	private WebElement FilterButton;

	@FindBy(xpath = "//select[@class=\"form-control  \"]")
	private WebElement AreaDropDown;

	@FindBy(xpath = "//select[@class='form-control ']")
	private WebElement GroupDropDown;

	@FindBy(xpath = "//div[@class=\"dropdown-heading-value\"]")
	private WebElement EquipementDropDown;

	@FindBy(xpath = "//span[text()='Analysis']")
	private WebElement DowntimeAnalysis;

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

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement CheckBoxEquipements;

	@FindBy(css = "[class=\"dropdown-heading-dropdown-arrow gray\"]")
	private WebElement CheckBoxEquipementsSelect;

}
