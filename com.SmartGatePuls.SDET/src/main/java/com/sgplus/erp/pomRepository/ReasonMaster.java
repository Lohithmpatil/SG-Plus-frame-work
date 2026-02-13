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

	@FindBy(xpath = "//label[text()='Area']/following::div[contains(@class,'dropdown-container')][1]")
	private WebElement Areadropdown;

	@FindBy(xpath = "//label[text()='Equipment']/following::div[contains(@class,'dropdown-container')][1]")
	private WebElement Equipementsdropdown;

	@FindBy(xpath = "//label[text()='Department']/following::div[contains(@class,'dropdown-container')][1]")
	private WebElement Departmentdropdown;

	@FindBy(xpath = "//button[text()=\"Submit\"]")
	private WebElement Submitbutton;

	@FindBy(xpath = "//button[text()=\"Cancel\"]")
	private WebElement Cancelbutton;

	@FindBy(xpath = "//input[@placeholder=\"Search\"]")
	private WebElement searchfield;

	@FindBy(xpath = "//a[text()=\" View\"]")
	private WebElement Viewbutton;

	@FindBy(xpath = "//a[text()=\" Edit\"]")
	private WebElement Editbutton;

	@FindBy(xpath = "//a[text()=\" Delete\"]")
	private WebElement Deletebutton;
	
	@FindBy(xpath = "//span[text()=\"TBM-PCR\"]")
	private WebElement AreaCheckbox;
	
	public WebElement getAreaCheckbox() {
		return AreaCheckbox;
	}

	public WebElement getEquipementsCheckbox() {
		return EquipementsCheckbox;
	}

	@FindBy(xpath = "//span[text()=\"All items are selected.\"]")
	private WebElement EquipementsCheckbox;
	

}
