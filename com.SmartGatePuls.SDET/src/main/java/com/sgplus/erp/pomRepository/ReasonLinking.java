package com.sgplus.erp.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReasonLinking {

    WebDriver driver;

    public ReasonLinking(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Navigation
    @FindBy(xpath = "//div[@title='Reason Linking']")
    private WebElement reasonLinking;

    public WebElement getReasonLinking() {
        return reasonLinking;
    }

    // Filters
    @FindBy(xpath = "//select[@class='form-control custom-width']")
    private WebElement buDropDown;

    @FindBy(xpath = "//select[@class='form-control custom-width']")
    private WebElement areaDropDown;

    @FindBy(xpath = "//div[@class='dropdown-heading-value']")
    private WebElement equipmentDropDown;

    @FindBy(xpath = "//input[@class='form-control']")
    private WebElement fromDate;

    @FindBy(xpath = "//input[@id='formGridToDate']")
    private WebElement toDate;

    @FindBy(xpath = "//button[@title='Search']")
    private WebElement searchButton;

    public WebElement getBUDropDown() {
        return buDropDown;
    }

    public WebElement getAreaDropDown() {
        return areaDropDown;
    }

    public WebElement getEquipmentDropDown() {
        return equipmentDropDown;
    }

    public WebElement getFromDate() {
        return fromDate;
    }

    public WebElement getToDate() {
        return toDate;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    // Link Dropdown
    @FindBy(xpath = "//select[@class='form-control custom-width ml-0']")
    private WebElement linkDropDown;

    public WebElement getLinkDropDown() {
        return linkDropDown;
    }

    // Department Dropdowns
    @FindBy(id = "formReasonId")
    private WebElement departmentGroupDropdown;

    @FindBy(xpath = "//select[@name='dept_id']")
    private WebElement departmentDropdown;

    public WebElement getDepartmentGroupDropdown() {
        return departmentGroupDropdown;
    }

    public WebElement getDepartmentDropdown() {
        return departmentDropdown;
    }

    // Reason Selection
    @FindBy(xpath = "//input[@id='react-select-3-input']")
    private WebElement reason;

    @FindBy(xpath = "//div[text()='AUTO MANUAL SWITCH NOT WORKING-']")
    private WebElement reasonOption;

    public WebElement getReason() {
        return reason;
    }

    public WebElement getReasonOption() {
        return reasonOption;
    }

    // Comment and Save
    @FindBy(xpath = "//textarea[@name='comment']")
    private WebElement commentField;

    @FindBy(xpath = "//button[text()='Save']")
    private WebElement saveButton;

    public WebElement getCommentField() {
        return commentField;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    // Success Message
    @FindBy(xpath = "//div[contains(text(),'Reason(s) linked to downtime successfully')]")
    private WebElement successMsg;

    public WebElement getSuccessMsg() {
        return successMsg;
    }

    // Data Source Validations
    @FindBy(xpath = "//table//td[contains(text(),'HandlingTime')]")
    private WebElement handlingSourceTimeData;

    @FindBy(xpath = "//table//td[contains(text(),'CycleTime')]")
    private WebElement cycleTimeSourceData;

    public WebElement getHandlingSourceTimeData() {
        return handlingSourceTimeData;
    }

    public WebElement getCycleTimeSourceData() {
        return cycleTimeSourceData;
    }

    // Equipment Checkbox
    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement equipmentCheckbox;

    public WebElement getEquipmentCheckbox() {
        return equipmentCheckbox;
    }

    // Export & Link
    @FindBy(xpath = "//button[@title='Export']")
    private WebElement exportButton;

    @FindBy(xpath = "//div[@class='text-center reason-action-cell']")
    private WebElement linkButton;

    public WebElement getExportButton() {
        return exportButton;
    }

    public WebElement getLinkButton() {
        return linkButton;
    }

    // Bulk Link Section
    @FindBy(xpath = "//button[@title='Bulk Link']")
    private WebElement bulkLinkButton;

    @FindBy(xpath = "//button[text()='Bulk Link']")
    private WebElement bulkLinkButton1;

    @FindBy(xpath = "//select[@name='department_id']")
    private WebElement bulkDepartmentDropdown;

    @FindBy(xpath = "//input[@title='Toggle All Rows Selected']")
    private WebElement checkBoxForBulkLink;

    @FindBy(xpath = "(//select[@id='formReasonId'])[3]")
    private WebElement reasonDropdownForBulkLink;

    @FindBy(xpath = "//div[@class='Toastify__toast-body' and text()='Successfully Updated!']")
    private WebElement bulkLinkUpdatedSuccessfully;

    @FindBy(xpath = "//button[text()='OK']")
    private WebElement okForBulkLink;

    @FindBy(xpath = "//div[@class='modal-footer']//button[@class='btn btn-secondary'][text()='Cancel']//button[text()='OK']")
    private WebElement cancelForBulkLink;

    @FindBy(xpath = "//label[text()='Source']/following-sibling::select")
    private WebElement sourceDropDown;

    @FindBy(xpath = "//div[text()='Successfully exported']")
    private WebElement successfullyExported;

    public WebElement getBulkLinkButton() {
        return bulkLinkButton;
    }

    public WebElement getBulkLinkButton1() {
        return bulkLinkButton1;
    }

    public WebElement getBulkDepartmentDropdown() {
        return bulkDepartmentDropdown;
    }

    public WebElement getCheckBoxForBulkLink() {
        return checkBoxForBulkLink;
    }

    public WebElement getReasonDropdownForBulkLink() {
        return reasonDropdownForBulkLink;
    }

    public WebElement getBulkLinkUpdatedSuccessfully() {
        return bulkLinkUpdatedSuccessfully;
    }

    public WebElement getOkForBulkLink() {
        return okForBulkLink;
    }

    public WebElement getCancelForBulkLink() {
        return cancelForBulkLink;
    }

    public WebElement getSourceDropDown() {
        return sourceDropDown;
    }

    public WebElement getSuccessfullyExported() {
        return successfullyExported;
    }
}