package com.hatester.pages;

import com.hatester.keywords.WebUI;
import com.hatester.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class LeadPage extends BasePage {
    public LeadPage(WebDriver driver) {
        super(driver);
        new WebUI(driver);
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
    private String addLeadSuccessMessage = "Lead added successfully.";
    private String updateLeadSuccessMessage = "Lead updated successfully.";
    private String deleteLeadSuccessMessage = "Lead deleted";

    private By getDeleteLeadSuccessMessage() {
        String xpathDeleteLeadMessage = "//div[@id='alert_float_1']/descendant::span[@class='alert-title' and normalize-space()='" + deleteLeadSuccessMessage + "']";
        return By.xpath(xpathDeleteLeadMessage);
    }

    public void clickIconLeadsSummary() {
        WebUI.clickElement(iconLeadsSummary);
        WebUI.sleep(2);
    }

    public void verifyLeadSummaryDisplay() {
        String actualCurrentUrl = WebUI.getCurrentURL();
        String expectedUrl = "https://crm.anhtester.com/admin/leads";

        Assert.assertTrue((WebUI.checkElementExist(headerLeadsSummary) && actualCurrentUrl.equals(expectedUrl)),
                "Failed to navigate to the Lead menu");
    }

    public String getTotalStatusActive() {
        WebUI.waitForElementVisible(labelTotalStatusActive);
        String totalStatusActive = WebUI.getTextElement(labelTotalStatusActive);
        return totalStatusActive;
    }

    public String getTotalStatusCustomer() {
        WebUI.waitForElementVisible(lableTotalStatusCustomer);
        String totalStatusCustomer = WebUI.getTextElement(lableTotalStatusCustomer);
        return totalStatusCustomer;
    }

    public String getTotalStatusLead() {
        String totalStatusCustomerLead = getTotalStatusCustomer();
        String totalStatusActiveLead = getTotalStatusActive();

        int totalStatusLead = Integer.parseInt(totalStatusActiveLead) + Integer.parseInt(totalStatusCustomerLead);
        return Integer.toString(totalStatusLead);
    }

    public void clickButtonNewLead() {
        WebUI.clickElement(buttonNewLead);
        WebUI.sleep(1);

        Assert.assertTrue(WebUI.checkElementExist(headerAddNewLead), "Failed to open the “Add New Lead” popup");
    }

    public void fillDataLead(String status, String source, String assigned, String tag, String name, String position,
                             String city, String emailAddress, String state, String website, String country, String phone,
                             String zipCode, String leadValue, String language, String company, String description,
                             String dateContacted, int flag, int flagEdit) {
        //status
        WebUI.clickElement(dropdownStatus);
        WebUI.setTextElement(inputSearchStatus, status);
        WebUI.clickElement(getValueStatus(status));

        //source
        WebUI.clickElement(dropdownSource);
        WebUI.setTextElement(inputSearchSource, source);
        WebUI.clickElement(getValueSource(source));

        //assigned
        WebUI.clickElement(dropdownAssigned);
        WebUI.setTextElement(inputSearchAssigned, assigned);
        WebUI.clickElement(getValueAssigned(assigned));

        //input
        if (flagEdit == 1) {
            WebUI.clickElement(iconCloseTag);
            WebUI.clearTextElement(inputName);
//            WebUI.clearElementText(driver,LocatorinputAddress);
            WebUI.clearTextElement(inputPosition);
            WebUI.clearTextElement(inputCity);
            WebUI.clearTextElement(inputEmailAddress);
            WebUI.clearTextElement(inputState);
            WebUI.clearTextElement(inputWebsite);
            WebUI.clearTextElement(inputPhone);
            WebUI.clearTextElement(inputZipcode);
            WebUI.clearTextElement(inputLeadValue);
            WebUI.clearTextElement(inputCompany);
            WebUI.clearTextElement(inputDescription);
            WebUI.clearTextElement(inputLastContact);

            WebUI.clickElement(labelPhone);
            WebUI.clickElement(labelPhone);

            WebUI.scrollToElementAtBottom(dropdownStatus);

            WebUI.clickElement(inputTags);
        }

        WebUI.setTextAndKey(inputTags, tag, Keys.ENTER);
        WebUI.clickElement(labelTags);
        WebUI.clickElement(labelTags);

        WebUI.setTextElement(inputName, name);
//        WebUI.setTextElement(LocatorinputAddress, "");

        WebUI.setTextElement(inputPosition, position);
        WebUI.setTextElement(inputCity, city);
        WebUI.setTextElement(inputEmailAddress, emailAddress);
        WebUI.setTextElement(inputState, state);
        WebUI.setTextElement(inputWebsite, website);

        //country
        WebUI.clickElement(dropdownCountry);
        WebUI.setTextElement(inputSearchCountry, country);
        WebUI.clickElement(getValueCountry(country));

        //input
        WebUI.setTextElement(inputPhone, phone);
        WebUI.setTextElement(inputZipcode, zipCode);
        WebUI.setTextElement(inputLeadValue, leadValue);

        //Default Language
        WebUI.clickElement(dropdownDefaultLanguage);
        WebUI.setTextElement(inputSearchDefaultLanguage, language);
        WebUI.clickElement(getValueDefaultLanguage(language));

        //input
        WebUI.setTextElement(inputCompany, company);
        WebUI.setTextElement(inputDescription, description);

        //checkbox
        WebUI.clickElement(labelCheckboxPublic);

        if (flagEdit == 0) {
            WebUI.clickElement(labelCheckboxContactedToday);
            WebUI.setTextElement(inputDateContacted, dateContacted);
            WebUI.clickElement(labelPhone);
            WebUI.clickElement(labelPhone);
        } else {
            WebUI.clearTextElement(inputLastContact);
            WebUI.setTextElement(inputLastContact, dateContacted);
            WebUI.clickElement(labelPhone);
            WebUI.clickElement(labelPhone);
        }
    }

    public void clickButtonSave() {
        WebUI.clickElement(buttonSave);
        WebUI.sleep(1);
    }

    public void verifyAddLeadSuccessMessage() {
        verifyAlertMessageSuccessDisplayed(addLeadSuccessMessage);
    }

    public void verifyUpdateLeadSuccessMessage() {
        verifyAlertMessageSuccessDisplayed(updateLeadSuccessMessage);
    }

    public void clickIconClosePopupLeadDetail(String name, int flagEdit) {
        WebUI.scrollToElementAtTop(iconClosePopupLeadDetail(name));
        WebUI.clickElement(iconClosePopupLeadDetail(name));
        WebUI.sleep(1);
    }

    public void searchAndCheckLeads(String name) {
        driver.navigate().refresh();
        WebUI.sleep(1);
        WebUI.setTextElement(inputSearchLeads, name);
        Assert.assertTrue(WebUI.checkElementExist(getFirstRowItemLeadName(name)), "Không đúng giá trị Lead vừa thêm mới");
        WebUI.sleep(1);
    }

    public void clickButtonEdit(String leadName) {
        WebUI.moveToElement(getFirstRowItemLeadName(leadName));
        WebUI.clickElement(buttonEdit(leadName));
    }

    public void verifyNewLeadInEditPopup(String leadName, String status, String source, String assigned, String tag, String name,
                                         String position, String city, String emailAddress, String state, String website, String country,
                                         String phone, String zipCode, String leadValue, String language, String company, String description,
                                         String dateContacted) {
        boolean containsStatus = WebUI.getTextElement(dropdownStatus).contains(status);
        Assert.assertTrue(containsStatus, "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getTextElement(dropdownSource), source,
                "Không đúng giá trị đã thêm mới");
        boolean containsAssigned = WebUI.getTextElement(dropdownAssigned).contains(assigned);
        Assert.assertTrue(containsAssigned, "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getTextElement(inputTagsEdit).toLowerCase(), tag,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getAttributeElement(inputName, "value"), name,
                "Không đúng giá trị đã thêm mới");
//        Assert.assertEquals(WebUI.getElementAttribute(driver,LocatorinputAddress,"value"), address,
//        "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getAttributeElement(inputPosition, "value"), position,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getAttributeElement(inputCity, "value"), city,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getAttributeElement(inputEmailAddress, "value"), emailAddress,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getAttributeElement(inputState, "value"), state,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getAttributeElement(inputWebsite, "value"), website,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getTextElement(dropdownCountry), country,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getAttributeElement(inputPhone, "value"), phone,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getAttributeElement(inputZipcode, "value"), zipCode,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getAttributeElement(inputLeadValue, "value"), leadValue,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getTextElement(dropdownDefaultLanguage), language,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getAttributeElement(inputCompany, "value"), company,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getAttributeElement(inputDescription, "value"), description,
                "Không đúng giá trị đã thêm mới");
        boolean containsLastContact = WebUI.getAttributeElement(inputLastContact, "value").contains(dateContacted);
        Assert.assertTrue(containsLastContact, "Không đúng giá trị đã thêm mới");
        Assert.assertFalse(WebUI.checkElementExist(checkboxContactedToday), "Không ẩn checkbox trên màn hình Edit");
        Assert.assertTrue(WebUI.checkSeletedElement(checkboxPublic), "Không tích chọn checkbox");
        WebUI.sleep(1);
    }

    public void clickButtonDelete(String leadName) {
        WebUI.moveToElement(getFirstRowItemLeadName(leadName));
        WebUI.clickElement(buttonDelete(leadName));
    }

    public void confirmAlertDelete(int typeConfirm) {
        WebUI.sleep(1);
        if (typeConfirm == 1) {
            driver.switchTo().alert().accept();
        } else {
            driver.switchTo().alert().dismiss();
        }
    }

    public void verifyDeleteLeadSuccessMessage(int typeConfirm) {
        if (typeConfirm == 1) {
            Assert.assertTrue(WebUI.checkElementExist(getDeleteLeadSuccessMessage()),
                    "The success message for deleting a lead is not displayed");
        } else {
            Assert.assertFalse(WebUI.checkElementExist(getDeleteLeadSuccessMessage()),
                    "The success message for deleting a lead is displayed");
        }
    }

    public void verifyAfterDeleteLead(String name, int typeConfirm) {
        WebUI.sleep(1);
        WebUI.setTextElement(inputSearchLeads, name);
        if (typeConfirm == 1) {
            Assert.assertFalse(WebUI.checkElementExist(getFirstRowItemLeadName(name)), "Xóa Lead không thành công");
        } else {
            Assert.assertTrue(WebUI.checkElementExist(getFirstRowItemLeadName(name)), "Hủy xóa Lead không thành công");
        }
        WebUI.sleep(1);
    }
}
