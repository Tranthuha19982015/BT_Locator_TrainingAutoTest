package com.hatester.pages;

import com.hatester.keywords.WebUI;
import com.hatester.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class LeadPage extends BasePage {

    private WebDriver driver;

    public LeadPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //Locator Lead Page
    private By buttonNewLead = By.xpath("//a[normalize-space()='New Lead']");
    private By iconLeadsSummary = By.xpath("//a[@data-title='Leads Summary']");
    private By iconSwitchToKanban = By.xpath("//a[@data-title='Switch to Kanban']");
    private By iconFilter = By.xpath("//div[@id='vueApp']/div[@data-title='Filter by']");

    //label lead overview
    private By headerLeadsSummary = By.xpath("//h4[normalize-space()='Leads Summary']");
    private By labelTotalStatusActive = By.xpath("//span[normalize-space()='Active']/preceding-sibling::span");
    private By lableTotalStatusCustomer = By.xpath("//span[normalize-space()='Customer']/preceding-sibling::span");

    //button
    private By dropdownDatatableLeadsLength = By.xpath("//div[@id='leads_length']//descendant::select");
    private By buttonExport = By.xpath("//div[@id='leads_length']/following-sibling::div/button[normalize-space()='Export']");
    private By buttonBulkActions = By.xpath("//div[@id='leads_length']/following-sibling::div/button[normalize-space()='Bulk Actions']");
    private By buttonReload = By.xpath("//div[@id='leads_length']/following-sibling::div/button[@data-original-title='Reload']");

    //input search
    private By inputSearchLeads = By.xpath("//div[@id='leads_filter']//input[@type='search']");

    //table
    private By checkboxCheckAll = By.xpath("//table[@id='leads']/thead/descendant::input[@id='mass_select_all']");
    private By headerNumber = By.xpath("//table[@id='leads']/thead/descendant::th[@id='th-number']");
    private By headerName = By.xpath("//table[@id='leads']/thead/descendant::th[@id='th-name']");
    private By headerCompany = By.xpath("//table[@id='leads']/thead/descendant::th[@id='th-company']");
    private By headerEmail = By.xpath("//table[@id='leads']/thead/descendant::th[@id='th-email']");
    private By headerPhone = By.xpath("//table[@id='leads']/thead/descendant::th[@id='th-phone']");
    private By headerValue = By.xpath("//table[@id='leads']/thead/descendant::th[@id='th-lead-value']");
    private By headerTags = By.xpath("//table[@id='leads']/thead/descendant::th[@id='th-tags']");
    private By headerAssigned = By.xpath("//table[@id='leads']/thead/descendant::th[@id='th-assigned']");
    private By headerStatus = By.xpath("//table[@id='leads']/thead/descendant::th[@id='th-status']");
    private By headerSource = By.xpath("//table[@id='leads']/thead/descendant::th[@id='th-source']");
    private By headerLastContact = By.xpath("//table[@id='leads']/thead/descendant::th[@id='th-last-contact']");
    private By headerCreated = By.xpath("//table[@id='leads']/thead/descendant::th[@id='th-date-created']");


    private By getFirstRowItemLeadName(String leadName) {
        By xpath = By.xpath("//table[@id='leads']//a[normalize-space()='" + leadName + "']");
        return xpath;
    }

    private By buttonView(String leadName) {
        By xpath = By.xpath("//table[@id='leads']//a[normalize-space()='" + leadName + "']/following-sibling::div/a[normalize-space()='View']");
        return xpath;
    }

    private By buttonEdit(String leadName) {
        By xpath = By.xpath("//table[@id='leads']//a[normalize-space()='" + leadName + "']/following-sibling::div/a[normalize-space()='Edit']");
        return xpath;
    }

    private By buttonDelete(String leadName) {
        By xpath = By.xpath("//table[@id='leads']//a[normalize-space()='" + leadName + "']/following-sibling::div/a[normalize-space()='Delete']");
        return xpath;
    }

    private By labelLeadInfo = By.xpath("//div[@id='leads_info']");
    private By buttonPrevious = By.xpath("//div[@id='leads_paginate']/descendant::li[@id='leads_previous']");

    private By buttonNumberOfPage(String number) {
        By xpath = By.xpath("//div[@id='leads_paginate']/descendant::a[normalize-space()='" + number + "']");
        return xpath;
    }

    private By buttonNext = By.xpath("//div[@id='leads_paginate']/descendant::li[@id='leads_next']");

    //Locator Add New Lead
    //dropdown Status
    private By headerAddNewLead = By.xpath("//h4[normalize-space()='Add new lead']");

    private By iconClosePopupLeadDetail(String headerLeadDetail) {
        By xpath = By.xpath("//h4[contains(normalize-space(),'" + headerLeadDetail + "')]/preceding-sibling::button[@aria-label='Close']");
        return xpath;
    }

    private By dropdownStatus = By.xpath("//button[@data-id='status']");
    private By inputSearchStatus = By.xpath("//button[@data-id='status']/following-sibling::div//input[@type='search']");
    private By iconAddStatus = By.xpath("//label[@for='status']/following-sibling::div/div[@class='input-group-btn']");

    private By getValueStatus(String status) {
        By xpath = By.xpath("//button[@data-id='status']/following-sibling::div//span[contains(normalize-space(),'" + status + "')]");
        return xpath;
    }

    //dropdown Source
    private By dropdownSource = By.xpath("//button[@data-id='source']");
    private By inputSearchSource = By.xpath("//button[@data-id='source']/following-sibling::div//input[@type='search']");
    private By iconAddSource = By.xpath("//label[@for='source']/following-sibling::div/div[@class='input-group-btn']");

    private By getValueSource(String source) {
        By xpath = By.xpath("//button[@data-id='source']/following-sibling::div//span[contains(normalize-space(),'" + source + "')]");
        return xpath;
    }

    //dropdown Assigned
    private By dropdownAssigned = By.xpath("//button[@data-id='assigned']");
    private By inputSearchAssigned = By.xpath("//button[@data-id='assigned']/following-sibling::div//input[@type='search']");

    private By getValueAssigned(String assigned) {
        By xpath = By.xpath("//button[@data-id='assigned']/following-sibling::div//span[contains(normalize-space(),'" + assigned + "')]");
        return xpath;
    }

    //input
    private By labelTags = By.xpath("//label[normalize-space()='Tags']");
    private By inputTags = By.xpath("//label[@for='tags']/following-sibling::ul//input[@placeholder='Tag']");
    private By inputTagsEdit = By.xpath("(//input[@id='tags']/following-sibling::ul)/descendant::span[@class='tagit-label']");
    private By iconCloseTag = By.xpath("//a[@class='tagit-close' and normalize-space()='×']");

    private By inputName = By.xpath("//div[@id='inputTagsWrapper']/following::div[@app-field-wrapper='name']/input[@id='name']");
    private By inputAddress = By.xpath("//textarea[@id='address']");
    private By inputPosition = By.xpath("//input[@id='title']");
    private By inputCity = By.xpath("//input[@id='city']");
    private By inputEmailAddress = By.xpath("//input[@id='email']");
    private By inputState = By.xpath("//input[@id='state']");
    private By inputWebsite = By.xpath("//input[@id='website']");

    //dropdown Country
    private By dropdownCountry = By.xpath("//button[@data-id='country']");
    private By inputSearchCountry = By.xpath("//button[@data-id='country']/following-sibling::div//input[@type='search']");

    private By getValueCountry(String country) {
        By xpath = By.xpath("//button[@data-id='country']/following-sibling::div//span[contains(normalize-space(),'" + country + "')]");
        return xpath;
    }

    //input
    private By labelPhone = By.xpath("//input[@id='phonenumber']/preceding-sibling::label[@for='phonenumber']");
    private By inputPhone = By.xpath("//input[@id='phonenumber']");
    private By inputZipcode = By.xpath("//input[@id='zip']");
    private By inputLeadValue = By.xpath("//input[@name='lead_value']");

    //dropdown Default Language
    private By dropdownDefaultLanguage = By.xpath("//button[@data-id='default_language']");
    private By inputSearchDefaultLanguage = By.xpath("//button[@data-id='default_language']/following-sibling::div//input[@type='search']");

    private By getValueDefaultLanguage(String language) {
        By xpath = By.xpath("//button[@data-id='default_language']/following-sibling::div//span[contains(normalize-space(),'" + language + "')]");
        return xpath;
    }

    //input
    private By inputCompany = By.xpath("//input[@id='company']");
    private By inputDescription = By.xpath("//textarea[@id='description']");
    private By inputDateContacted = By.xpath("//input[@id='custom_contact_date']");
    private By inputLastContact = By.xpath("//input[@id='lastcontact']");
    private By iconDateContactedCalendar = By.xpath("//input[@id='custom_contact_date']/following-sibling::div");

    //checkbox
    private By checkboxPublic = By.xpath("//input[@id='lead_public']");
    private By labelCheckboxPublic = By.xpath("//label[@for='lead_public']");
    private By checkboxContactedToday = By.xpath("//input[@id='contacted_today']");
    private By labelCheckboxContactedToday = By.xpath("//label[normalize-space()='Contacted Today']");

    //button
    private By buttonClose = By.xpath("//div[@class='lead-edit']/button[normalize-space()='Close']");
    private By buttonSave = By.xpath("//button[normalize-space()='Save' and @id='lead-form-submit']");

    //message
    private By addLeadSuccessMessage = By.xpath("//span[@class='alert-title' and normalize-space()='Lead added successfully.']/parent::div");
    private By updateLeadSuccessMessage = By.xpath("//span[@class='alert-title' and normalize-space()='Lead updated successfully.']/parent::div");
    private By deleteLeadSuccessMessage = By.xpath("//span[@class='alert-title' and normalize-space()='Lead deleted']/parent::div");

    public void clickIconLeadsSummary() throws InterruptedException {
        WebUI.clickElement(driver, iconLeadsSummary);
        Thread.sleep(2000);
    }

    public void verifyLeadSummaryDisplay() throws InterruptedException {
        String actualCurrentUrl = WebUI.getCurrentURL(driver);
        String expectedUrl = "https://crm.anhtester.com/admin/leads";

        Assert.assertTrue((WebUI.checkExistsElement(driver, headerLeadsSummary) && actualCurrentUrl.equals(expectedUrl)),
                "Failed to navigate to the Lead menu");
    }

    public String getTotalStatusActive() {
        WebUI.waitForElementVisible(driver, labelTotalStatusActive);
        String totalStatusActive = WebUI.getElementText(driver, labelTotalStatusActive);
        return totalStatusActive;
    }

    public String getTotalStatusCustomer() {
        WebUI.waitForElementVisible(driver, lableTotalStatusCustomer);
        String totalStatusCustomer = WebUI.getElementText(driver, lableTotalStatusCustomer);
        return totalStatusCustomer;
    }

    public String getTotalStatusLead() {
        String totalStatusCustomerLead = getTotalStatusCustomer();
        String totalStatusActiveLead = getTotalStatusActive();

        int totalStatusLead = Integer.parseInt(totalStatusActiveLead) + Integer.parseInt(totalStatusCustomerLead);
        return Integer.toString(totalStatusLead);
    }

    public void clickButtonNewLead() throws InterruptedException {
        WebUI.clickElement(driver, buttonNewLead);
        Thread.sleep(1000);

        Assert.assertTrue(WebUI.checkExistsElement(driver, headerAddNewLead), "Failed to open the “Add New Lead” popup");
    }

    public void fillDataLead(String status, String source, String assigned, String tag, String name, String position,
                             String city, String emailAddress, String state, String website, String country, String phone,
                             String zipCode, String leadValue, String language, String company, String description,
                             String dateContacted, int flag, int flagEdit) throws InterruptedException {
        //status
        WebUI.clickElement(driver, dropdownStatus);
        WebUI.setTextElement(driver, inputSearchStatus, status);
        WebUI.clickElement(driver, getValueStatus(status));

        //source
        WebUI.clickElement(driver, dropdownSource);
        WebUI.setTextElement(driver, inputSearchSource, source);
        WebUI.clickElement(driver, getValueSource(source));

        //assigned
        WebUI.clickElement(driver, dropdownAssigned);
        WebUI.setTextElement(driver, inputSearchAssigned, assigned);
        WebUI.clickElement(driver, getValueAssigned(assigned));

        //input
        if (flagEdit == 1) {
            WebUI.clickElement(driver, iconCloseTag);
            WebUI.clearTextElement(driver, inputName);
//            WebUI.clearElementText(driver,LocatorinputAddress);
            WebUI.clearTextElement(driver, inputPosition);
            WebUI.clearTextElement(driver, inputCity);
            WebUI.clearTextElement(driver, inputEmailAddress);
            WebUI.clearTextElement(driver, inputState);
            WebUI.clearTextElement(driver, inputWebsite);
            WebUI.clearTextElement(driver, inputPhone);
            WebUI.clearTextElement(driver, inputZipcode);
            WebUI.clearTextElement(driver, inputLeadValue);
            WebUI.clearTextElement(driver, inputCompany);
            WebUI.clearTextElement(driver, inputDescription);
            WebUI.clearTextElement(driver, inputLastContact);

            WebUI.clickElement(driver, labelPhone);
            WebUI.clickElement(driver, labelPhone);

            WebUI.scrollAtBottom(driver, dropdownStatus);

            WebUI.clickElement(driver, inputTags);
        }

        WebUI.setTextAndKeyElement(driver, inputTags, tag, Keys.ENTER);
        WebUI.clickElement(driver, labelTags);
        WebUI.clickElement(driver, labelTags);

        WebUI.setTextElement(driver, inputName, name);
//        WebUI.setTextElement(driver, LocatorinputAddress, "");

        WebUI.setTextElement(driver, inputPosition, position);
        WebUI.setTextElement(driver, inputCity, city);
        WebUI.setTextElement(driver, inputEmailAddress, emailAddress);
        WebUI.setTextElement(driver, inputState, state);
        WebUI.setTextElement(driver, inputWebsite, website);

        //country
        WebUI.clickElement(driver, dropdownCountry);
        WebUI.setTextElement(driver, inputSearchCountry, country);
        WebUI.clickElement(driver, getValueCountry(country));

        //input
        WebUI.setTextElement(driver, inputPhone, phone);
        WebUI.setTextElement(driver, inputZipcode, zipCode);
        WebUI.setTextElement(driver, inputLeadValue, leadValue);

        //Default Language
        WebUI.clickElement(driver, dropdownDefaultLanguage);
        WebUI.setTextElement(driver, inputSearchDefaultLanguage, language);
        WebUI.clickElement(driver, getValueDefaultLanguage(language));

        //input
        WebUI.setTextElement(driver, inputCompany, company);
        WebUI.setTextElement(driver, inputDescription, description);

        //checkbox
        WebUI.clickElement(driver, labelCheckboxPublic);

        if (flagEdit == 0) {
            WebUI.clickElement(driver, labelCheckboxContactedToday);
            WebUI.setTextElement(driver, inputDateContacted, dateContacted);
            WebUI.clickElement(driver, labelPhone);
            WebUI.clickElement(driver, labelPhone);
        } else {
            WebUI.clearTextElement(driver, inputLastContact);
            WebUI.setTextElement(driver, inputLastContact, dateContacted);
            WebUI.clickElement(driver, labelPhone);
            WebUI.clickElement(driver, labelPhone);
        }
    }

    public void clickButtonSave() throws InterruptedException {
        WebUI.clickElement(driver, buttonSave);
        Thread.sleep(1000);
    }

    public void verifyAddLeadSuccessMessage() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertTrue(WebUI.checkExistsElement(driver, addLeadSuccessMessage),
                "The success message for adding a lead is not displayed");
    }

    public void verifyUpdateLeadSuccessMessage() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertTrue(WebUI.checkExistsElement(driver, updateLeadSuccessMessage),
                "The success message for updating a lead is not displayed");
    }

    public void clickIconClosePopupLeadDetail(String name, int flagEdit) throws InterruptedException {
        if (flagEdit == 0) {
            WebUI.waitForElementNotVisible(driver, addLeadSuccessMessage);
        } else {
            WebUI.waitForElementNotVisible(driver, updateLeadSuccessMessage);
        }
        WebUI.scrollAtTop(driver, iconClosePopupLeadDetail(name));
//        Thread.sleep(1000);
        WebUI.clickElement(driver, iconClosePopupLeadDetail(name));
        Thread.sleep(1000);
    }

    public void searchAndCheckLeads(String name) throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(1000);
        WebUI.setTextElement(driver, inputSearchLeads, name);
        WebUI.waitForElementVisible(driver, getFirstRowItemLeadName(name));
        Assert.assertTrue(WebUI.checkExistsElement(driver, getFirstRowItemLeadName(name)), "Không đúng giá trị Lead vừa thêm mới");
        Thread.sleep(1000);
    }

    public void clickButtonEdit(String leadName) throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(WebUI.getWebElement(driver, getFirstRowItemLeadName(leadName))).perform();
        WebUI.clickElement(driver, buttonEdit(leadName));
    }

    public void verifyNewLeadInEditPopup(String leadName, String status, String source, String assigned, String tag, String name,
                                         String position, String city, String emailAddress, String state, String website, String country,
                                         String phone, String zipCode, String leadValue, String language, String company, String description,
                                         String dateContacted) throws InterruptedException {
        Thread.sleep(1000);
        boolean containsStatus = WebUI.getElementText(driver, dropdownStatus).contains(status);
        Assert.assertTrue(containsStatus, "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementText(driver, dropdownSource), source,
                "Không đúng giá trị đã thêm mới");
        boolean containsAssigned = WebUI.getElementText(driver, dropdownAssigned).contains(assigned);
        Assert.assertTrue(containsAssigned, "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementText(driver, inputTagsEdit).toLowerCase(), tag,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementAttribute(driver, inputName, "value"), name,
                "Không đúng giá trị đã thêm mới");
//        Assert.assertEquals(WebUI.getElementAttribute(driver,LocatorinputAddress,"value"), address,
//        "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementAttribute(driver, inputPosition, "value"), position,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementAttribute(driver, inputCity, "value"), city,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementAttribute(driver, inputEmailAddress, "value"), emailAddress,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementAttribute(driver, inputState, "value"), state,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementAttribute(driver, inputWebsite, "value"), website,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementText(driver, dropdownCountry), country,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementAttribute(driver, inputPhone, "value"), phone,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementAttribute(driver, inputZipcode, "value"), zipCode,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementAttribute(driver, inputLeadValue, "value"), leadValue,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementText(driver, dropdownDefaultLanguage), language,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementAttribute(driver, inputCompany, "value"), company,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementAttribute(driver, inputDescription, "value"), description,
                "Không đúng giá trị đã thêm mới");
        boolean containsLastContact = WebUI.getElementAttribute(driver, inputLastContact, "value").contains(dateContacted);
        Assert.assertTrue(containsLastContact, "Không đúng giá trị đã thêm mới");
        Assert.assertFalse(WebUI.checkExistsElement(driver, checkboxContactedToday), "Không ẩn checkbox trên màn hình Edit");
        Assert.assertTrue(WebUI.checkSeletedElement(driver, checkboxPublic), "Không tích chọn checkbox");
        Thread.sleep(1000);
    }

    public void clickButtonDelete(String leadName) {
        Actions action = new Actions(driver);
        action.moveToElement(WebUI.getWebElement(driver, getFirstRowItemLeadName(leadName))).perform();
        WebUI.clickElement(driver, buttonDelete(leadName));
    }

    public void confirmAlertDelete() throws InterruptedException {
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
    }

    public void verifyDeleteLeadSuccessMessage() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertTrue(WebUI.checkExistsElement(driver, deleteLeadSuccessMessage),
                "The success message for deleting a lead is not displayed");
    }

    public void verifyAfterDeleteLead(String name) throws InterruptedException {
        Thread.sleep(1000);
        WebUI.setTextElement(driver, inputSearchLeads, name);
        Assert.assertFalse(WebUI.checkExistsElement(driver, getFirstRowItemLeadName(name)), "Xóa Lead không thành công");
        Thread.sleep(1000);
    }
}
