package com.hatester.pages;

import com.hatester.keywords.WebUI;
import com.hatester.common.BasePage;
import com.hatester.models.LeadData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LeadPage extends BasePage {
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

    public void fillDataLead(LeadData lead, boolean isEdit) {
        //status
        WebUI.clickElement(dropdownStatus);
        WebUI.setTextElement(inputSearchStatus, lead.getStatus());
        WebUI.clickElement(getValueStatus(lead.getStatus()));

        //source
        WebUI.clickElement(dropdownSource);
        WebUI.setTextElement(inputSearchSource, lead.getSource());
        WebUI.clickElement(getValueSource(lead.getSource()));

        //assigned
        WebUI.clickElement(dropdownAssigned);
        WebUI.setTextElement(inputSearchAssigned, lead.getAssigned());
        WebUI.clickElement(getValueAssigned(lead.getAssigned()));

        //input
        if (isEdit) {
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

        WebUI.setTextAndKey(inputTags, lead.getTag(), Keys.ENTER);
        WebUI.clickElement(labelTags);
        WebUI.clickElement(labelTags);

        WebUI.setTextElement(inputName, lead.getLeadName());
//        WebUI.setTextElement(LocatorinputAddress, "");

        WebUI.setTextElement(inputPosition, lead.getPosition());
        WebUI.setTextElement(inputCity, lead.getCity());
        WebUI.setTextElement(inputEmailAddress, lead.getEmailAddress());
        WebUI.setTextElement(inputState, lead.getState());
        WebUI.setTextElement(inputWebsite, lead.getWebsite());

        //country
        WebUI.clickElement(dropdownCountry);
        WebUI.setTextElement(inputSearchCountry, lead.getCountry());
        WebUI.clickElement(getValueCountry(lead.getCountry()));

        //input
        WebUI.setTextElement(inputPhone, lead.getPhone());
        WebUI.setTextElement(inputZipcode, lead.getZipCode());
        WebUI.setTextElement(inputLeadValue, lead.getLeadValue());

        //Default Language
        WebUI.clickElement(dropdownDefaultLanguage);
        WebUI.setTextElement(inputSearchDefaultLanguage, lead.getLanguage());
        WebUI.clickElement(getValueDefaultLanguage(lead.getLanguage()));

        //input
        WebUI.setTextElement(inputCompany, lead.getCompany());
        WebUI.setTextElement(inputDescription, lead.getDescription());

        //checkbox
        WebUI.clickElement(labelCheckboxPublic);

        if (lead.getCheckedCheckbox() == 0) {
            if (!isEdit) {
                WebUI.clickElement(labelCheckboxContactedToday);
                WebUI.setTextElement(inputDateContacted, lead.getLastContacted());
            } else {
                WebUI.setTextElement(inputLastContact, lead.getLastContacted());
            }
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

    public void clickIconClosePopupLeadDetail(String name) {
        WebUI.scrollToElementAtTop(iconClosePopupLeadDetail(name));
        WebUI.clickElement(iconClosePopupLeadDetail(name));
        WebUI.sleep(1);
    }

    public void searchLead(String name) {
        WebUI.refreshPage();
        WebUI.waitForPageLoaded();
        WebUI.setTextElement(inputSearchLeads, name);
        WebUI.sleep(1);
    }

    public void checkLeadsExists(String name) {
        Assert.assertTrue(WebUI.checkElementExist(getFirstRowItemLeadName(name)), "Không đúng giá trị Lead vừa thêm mới");
    }

    public void verifyQuantityStatusAfterAdd(String status, int quantityActiveAfter, int quantityActiveBefore,
                                             int quantityCustomerAfter, int quantityCustomerBefore) {
        WebUI.waitForPageLoaded();
        if (status.equals("Active")) {
            Assert.assertEquals(quantityActiveAfter, quantityActiveBefore + 1, "Số lượng status Active không khớp");
            Assert.assertEquals(quantityCustomerAfter, quantityCustomerBefore, "Số lượng status Customer không khớp");
        } else {
            Assert.assertEquals(quantityActiveAfter, quantityActiveBefore, "Số lượng status Active không khớp");
            Assert.assertEquals(quantityCustomerAfter, quantityCustomerBefore + 1, "Số lượng status Customer không khớp");
        }
    }

    public void clickButtonEdit(String leadName) {
        WebUI.moveToElement(getFirstRowItemLeadName(leadName));
        WebUI.clickElement(buttonEdit(leadName));
    }

    public void verifyNewLeadInEditPopup(LeadData lead) {
        boolean containsStatus = WebUI.getTextElement(dropdownStatus).contains(lead.getStatus());
        Assert.assertTrue(containsStatus, "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getTextElement(dropdownSource), lead.getSource(),
                "Không đúng giá trị đã thêm mới");
        boolean containsAssigned = WebUI.getTextElement(dropdownAssigned).contains(lead.getAssigned());
        Assert.assertTrue(containsAssigned, "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getTextElement(inputTagsEdit).toLowerCase(), lead.getTag().toLowerCase(),
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getAttributeElement(inputName, "value"), lead.getLeadName(),
                "Không đúng giá trị đã thêm mới");
//        Assert.assertEquals(WebUI.getElementAttribute(driver,LocatorinputAddress,"value"), address,
//        "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getAttributeElement(inputPosition, "value"), lead.getPosition(),
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getAttributeElement(inputCity, "value"), lead.getCity(),
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getAttributeElement(inputEmailAddress, "value"), lead.getEmailAddress(),
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getAttributeElement(inputState, "value"), lead.getState(),
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getAttributeElement(inputWebsite, "value"), lead.getWebsite(),
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getTextElement(dropdownCountry), lead.getCountry(),
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getAttributeElement(inputPhone, "value"), lead.getPhone(),
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getAttributeElement(inputZipcode, "value"), lead.getZipCode(),
                "Không đúng giá trị đã thêm mới");

        boolean containsLeadValue = WebUI.getAttributeElement(inputLeadValue, "value").contains(lead.getLeadValue());
        Assert.assertTrue(containsLeadValue, "Không đúng giá trị đã thêm mới");

        Assert.assertEquals(WebUI.getTextElement(dropdownDefaultLanguage), lead.getLanguage(),
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getAttributeElement(inputCompany, "value"), lead.getCompany(),
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getAttributeElement(inputDescription, "value"), lead.getDescription(),
                "Không đúng giá trị đã thêm mới");

        if (lead.getCheckedCheckbox() == 0) {
            boolean containsLastContact = WebUI.getAttributeElement(inputLastContact, "value").contains(lead.getLastContacted());
            Assert.assertTrue(containsLastContact, "Không đúng giá trị đã thêm mới");
        } else {
            String today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            boolean containsLastContact = WebUI.getAttributeElement(inputLastContact, "value").contains(today);
            Assert.assertTrue(containsLastContact, "Không đúng giá trị đã thêm mới");
        }

        Assert.assertFalse(WebUI.checkElementExist(checkboxContactedToday), "Không ẩn checkbox trên màn hình Edit");
        Assert.assertTrue(WebUI.checkElementSeleted(checkboxPublic), "Không tích chọn checkbox");
        WebUI.sleep(1);
    }

    public void clickButtonDelete(String leadName) {
        WebUI.moveToElement(getFirstRowItemLeadName(leadName));
        WebUI.clickElement(buttonDelete(leadName));
    }

    public void confirmAlertDelete(int typeConfirm) {
        WebUI.sleep(1);
        if (typeConfirm == 1) {
            WebUI.acceptAlert();
        } else {
            WebUI.dismissAlert();
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
        if (typeConfirm == 1) {
            Assert.assertFalse(WebUI.checkElementExist(getFirstRowItemLeadName(name)), "Xóa Lead không thành công");
        } else {
            Assert.assertTrue(WebUI.checkElementExist(getFirstRowItemLeadName(name)), "Hủy xóa Lead không thành công");
        }
        WebUI.sleep(1);
    }
}
