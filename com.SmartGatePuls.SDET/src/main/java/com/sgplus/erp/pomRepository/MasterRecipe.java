package com.sgplus.erp.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MasterRecipe {

	WebDriver driver;

	public MasterRecipe(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	@FindBy(xpath = "//div[@title=\"Recipe\"]")
	private WebElement Recipedashboard;

	public WebElement getRecipedashboard() {
		return Recipedashboard;
	}

	public WebElement getAddRecipeButton() {
		return AddRecipeButton;
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

	public WebElement getRecipecodeFiled() {
		return RecipecodeFiled;
	}

	public WebElement getSapcode() {
		return Sapcode;
	}

	public WebElement getCycletimefield() {
		return Cycletimefield;
	}

	public WebElement getProductionTypedropdown() {
		return ProductionTypedropdown;
	}

	public WebElement getAreadropdown() {
		return Areadropdown;
	}

	public WebElement getEquipementdropdown() {
		return Equipementdropdown;
	}

	public WebElement getCycleqtyfield() {
		return Cycleqtyfield;
	}

	public WebElement getSubmitbutton() {
		return Submitbutton;
	}

	public WebElement getAreaChekbox() {
		return AreaChekbox;
	}

	public WebElement getAreadropdowncollapse() {
		return Areadropdowncollapse;
	}

	public WebElement getBulklinkButton() {
		return BulklinkButton;
	}

	public WebElement getExportbutton() {
		return Exportbutton;
	}

	@FindBy(xpath = "//button[text()=\"Add Recipe\"]")
	private WebElement AddRecipeButton;

	@FindBy(xpath = "//button[text()=\"Cancel\"]")
	private WebElement Cancelbutton;

	@FindBy(xpath = "//input[@placeholder=\"Search\"]")
	private WebElement searchfield;

	@FindBy(xpath = "//a[text()=\" View\"]")
	private WebElement Viewbutton;

	@FindBy(xpath = "//a[text()=\" Edit\"]")
	private WebElement Editbutton;

	@FindBy(xpath = "//input[@name=\"recipeCode\"]")
	private WebElement RecipecodeFiled;

	@FindBy(xpath = "//input[@name=\"sapCode\"]")
	private WebElement Sapcode;

	@FindBy(xpath = "//input[@name=\"cycleTime\"]")
	private WebElement Cycletimefield;

	@FindBy(xpath = "//select[@name=\"groupId\"]")
	private WebElement ProductionTypedropdown;

	@FindBy(xpath = "//div[@aria-labelledby=\"Select\"]")
	private WebElement Areadropdown;

	@FindBy(xpath = "//select[@name=\"selectedEquipments\"]")
	private WebElement Equipementdropdown;

	@FindBy(xpath = "//input[@placeholder=\" Cycle Quantity \"]")
	private WebElement Cycleqtyfield;

	@FindBy(xpath = "//button[text()=\"Submit\"]")
	private WebElement Submitbutton;

	@FindBy(xpath = "//span[text()=\"Mixing\"]")
	private WebElement AreaChekbox;

	@FindBy(xpath = "//div[@aria-labelledby=\"Select\"]")
	private WebElement Areadropdowncollapse;

	@FindBy(xpath = "//button[@title=\"Bulk Addition\"]")
	private WebElement BulklinkButton;

	@FindBy(xpath = "//button[@title=\"Download Format\"]")
	private WebElement Exportbutton;

}
