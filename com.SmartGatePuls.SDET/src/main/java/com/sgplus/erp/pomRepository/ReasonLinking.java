package com.sgplus.erp.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReasonLinking {

	WebDriver driver;
	public ReasonLinking(WebDriver driver) {
	
		this. driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@title=\"Reason Linking\"]")
    private WebElement ReasonLinking ;
	
	public WebElement getReasonLinking() {
		return ReasonLinking;
	}

	@FindBy(xpath= "//select[@class='form-control custom-width']")
	private WebElement BUDropDown;
	
	public WebElement getBUDropDown() {
		return BUDropDown;
	}

	public WebElement getAreadropDown() {
		return AreadropDown;
	}

	public WebElement getEquipemetsDropDown() {
		return EquipemetsDropDown;
	}

	@FindBy(xpath= "//select[@class=\"form-control custom-width\"]")
	private WebElement AreadropDown;
	
	@FindBy(xpath= "//div[@class=\"dropdown-heading-value\"]")
	private WebElement EquipemetsDropDown;
	
	public WebElement getFromDate() {
		return FromDate;
	}

	public void setFromDate(WebElement fromDate) {
		FromDate = fromDate;
	}

	@FindBy(xpath= "//input[@class=\"form-control\"]")
	private WebElement FromDate;
	
	@FindBy(xpath= "//button[@title=\"Search\"]")
	private WebElement SearchButton;
	
	
	public WebElement getSearchButton() {
		return SearchButton;
	}

	public WebElement getLinkDropDown() {
		return LinkDropDown;
	}

	@FindBy(xpath= "//select[@class=\"form-control custom-width ml-0\"]")
	private WebElement LinkDropDown;
	
	public WebElement getEqCheckBox() {
		return EqCheckBox;
	}

	@FindBy(xpath= "//input[@type='checkbox']")
	private WebElement EqCheckBox;
	
	@FindBy(xpath= "//button[@title=\"Export\"]")
	private WebElement ExportButton;
	
	
	
	
	
	
	
	
	
}
