package com.sgplus.erp.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReasonMaster {
	WebDriver driver;

	public ReasonMaster(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getReasondashboard() {
		return Reasondashboard;
	}

	public WebElement getAddReasonButton() {
		return AddReasonButton;
	}

	public WebElement getReasonNamefield() {
		return ReasonNamefield;
	}

	public WebElement getReasonsDescriptionfield() {
		return ReasonsDescriptionfield;
	}

	public WebElement getSAPcodefield() {
		return SAPcodefield;
	}

	public WebElement getAreadropdown() {
		return Areadropdown;
	}

	public WebElement getEquipementsdropdown() {
		return Equipementsdropdown;
	}

	public WebElement getDepartmentdropdown() {
		return Departmentdropdown;
	}

	public WebElement getSubmitbutton() {
		return Submitbutton;
	}

	public WebElement getCancelbutton() {
		return Cancelbutton;
	}

	public WebElement getSearchfield() {
		return searchfield;
	}

	public WebElement getViewbutton() {
		return Viewbutton;
	}

	public WebElement getEditbutton() {
		return Editbutton;
	}

	public WebElement getDeletebutton() {
		return Deletebutton;
	}

	@FindBy(xpath = "//div[@title=\"Reason\"]")
	private WebElement Reasondashboard;

	@FindBy(xpath = "//button[text()=\"Add Reasons\"]")
	private WebElement AddReasonButton;

	@FindBy(xpath = "//input[@id=\"formReasonsName\"]")
	private WebElement ReasonNamefield;

	@FindBy(xpath = "//textarea[@id=\"formReasonsDescription\"]")
	private WebElement ReasonsDescriptionfield;

	@FindBy(xpath = "//input[@id=\"formReasonsSapCode\"]")
	private WebElement SAPcodefield;

	@FindBy(xpath = "//label[contains(text(),'Area')]/following::div[@class='dropdown-heading'][1]")
	private WebElement Areadropdown;

	@FindBy(xpath = "//label[contains(text(),'Equipment')]/following::div[@class='dropdown-heading'][1]")
	private WebElement Equipementsdropdown;

	@FindBy(xpath = "//label[contains(text(),'Department')]/following::div[@class='dropdown-heading'][1]")
	private WebElement Departmentdropdown;

	@FindBy(xpath = "//button[text()=\"Submit\"]")
	private WebElement Submitbutton;

	@FindBy(xpath = "//button[text()=\"Cancel\"]")
	private WebElement Cancelbutton;

	@FindBy(xpath = "//input[@placeholder=\"Search reasons...\"]")
	private WebElement searchfield;

	@FindBy(xpath = "//a[text()=\" View\"]")
	private WebElement Viewbutton;

	@FindBy(xpath = "//a[text()=\" Edit\"]")
	private WebElement Editbutton;

	@FindBy(xpath = "//a[text()=\" Delete\"]")
	private WebElement Deletebutton;

	@FindBy(xpath = "//span[text()=\"TBM-PCR\"]")
	private WebElement AreaCheckbox;

	@FindBy(xpath = "//button[normalize-space()='Search']")
	private WebElement SearchBtn;

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public WebElement getAreaCheckbox() {
		return AreaCheckbox;
	}

	public WebElement getEquipementsCheckbox() {
		return EquipementsCheckbox;
	}

	@FindBy(xpath = "//span[text()=\"SCPTBD05\"]")
	private WebElement EquipementsCheckbox;

	@FindBy(xpath = "//label[contains(text(),'Area')]/following::div[@class='dropdown-heading'][1]")
	private WebElement CollpaseAreadropdown;

	public WebElement getCollpaseEquipementdropdown() {
		return CollpaseEquipementdropdown;
	}

	@FindBy(xpath = "//label[contains(text(),'Equipment')]/following::div[@class='dropdown-heading'][1]")
	private WebElement CollpaseEquipementdropdown;

	public WebElement getDepartmentCheckbox() {
		return DepartmentCheckbox;
	}

	public WebElement getCollapseDepartmentdropdown() {
		return CollapseDepartmentdropdown;
	}

	@FindBy(xpath = "//span[text()=\"Electrical\"]")
	private WebElement DepartmentCheckbox;

	@FindBy(xpath = "//label[contains(text(),'Department')]/following::div[@class='dropdown-heading'][1]")
	private WebElement CollapseDepartmentdropdown;

	public WebElement getEdit3Dots() {
		return Edit3Dots;
	}

	@FindBy(xpath = "//button[@aria-haspopup=\"true\"]")
	private WebElement Edit3Dots;

	public WebElement getEditEquipementsCheckbox() {
		return EditEquipementsCheckbox;
	}

	@FindBy(xpath = "//span[text()=\"SCPTBD06\"]")
	private WebElement EditEquipementsCheckbox;

	public WebElement getCollpaseAreadropdown() {
		return CollpaseAreadropdown;
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

	/* ================= APPLY FILTER ================= */

	@FindBy(xpath = "//button[text()=\"Apply Filter\"]")
	private WebElement ApplyFilter;

	public WebElement getApplyFilter() {
		return ApplyFilter;
	}

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement EquipementCheckbox;

	@FindBy(xpath = "//div[@aria-labelledby=\"Equipments\"]")
	private WebElement CollpaseEquipementsdropdown;

	@FindBy(xpath = "//select[option[normalize-space()='Select Department Group']]")
	private WebElement DepertmentGroupDown;

	public WebElement getDepertmentGroupDown() {
		return DepertmentGroupDown;
	}



	public WebElement getExportBtn() {
		return ExportBtn;
	}

	public WebElement getDeartmentDropDown1() {
		return DeartmentDropDown1;
	}

	@FindBy(xpath = "//select[option[normalize-space()='Select Department']]")
	private WebElement DeartmentDropDown1;

	@FindBy(xpath = "//button[@title=\"Export\"]")
	private WebElement ExportBtn;

}
