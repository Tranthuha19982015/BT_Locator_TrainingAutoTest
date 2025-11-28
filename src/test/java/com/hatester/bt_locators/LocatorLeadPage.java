package com.hatester.bt_locators;

import org.openqa.selenium.By;

public class LocatorLeadPage {
    //locator menu Lead
    public static By menuLead = By.xpath("//ul[@id='side-menu']//span[normalize-space()='Leads' and @class='menu-text']");

    //Locator Lead Page
    public static By buttonNewLead = By.xpath("//a[normalize-space()='New Lead']");
    public static By iconLeadsSummary = By.xpath("//a[@data-title='Leads Summary']");
    public static By iconSwitchToKanban = By.xpath("//a[@data-title='Switch to Kanban']");
    public static By iconFilter = By.xpath("//div[@id='vueApp']/div[@data-title='Filter by']");

    //label lead overview
    public static By headerLeadsSummary = By.xpath("//h4[normalize-space()='Leads Summary']");
    public static By labelActive = By.xpath("//span[normalize-space()='Active']/preceding-sibling::span");
    public static By lableCustomer = By.xpath("//span[normalize-space()='Customer']/preceding-sibling::span");

    //button
    public static By dropdownDatatableLeadsLength = By.xpath("//div[@id='leads_length']//descendant::select");
    public static By buttonExport = By.xpath("//div[@id='leads_length']/following-sibling::div/button[normalize-space()='Export']");
    public static By buttonBulkActions = By.xpath("//div[@id='leads_length']/following-sibling::div/button[normalize-space()='Bulk Actions']");
    public static By buttonReload = By.xpath("//div[@id='leads_length']/following-sibling::div/button[@data-original-title='Reload']");

    //input search
    public static By inputSearchLeads = By.xpath("//div[@id='leads_filter']//input[@type='search']");

    //table
    public static By checkboxCheckAll = By.xpath("//table[@id='leads']/thead/descendant::input[@id='mass_select_all']");
    public static By headerNumber = By.xpath("//table[@id='leads']/thead/descendant::th[@id='th-number']");
    public static By headerName = By.xpath("//table[@id='leads']/thead/descendant::th[@id='th-name']");
    public static By headerCompany = By.xpath("//table[@id='leads']/thead/descendant::th[@id='th-company']");
    public static By headerEmail = By.xpath("//table[@id='leads']/thead/descendant::th[@id='th-email']");
    public static By headerPhone = By.xpath("//table[@id='leads']/thead/descendant::th[@id='th-phone']");
    public static By headerValue = By.xpath("//table[@id='leads']/thead/descendant::th[@id='th-lead-value']");
    public static By headerTags = By.xpath("//table[@id='leads']/thead/descendant::th[@id='th-tags']");
    public static By headerAssigned = By.xpath("//table[@id='leads']/thead/descendant::th[@id='th-assigned']");
    public static By headerStatus = By.xpath("//table[@id='leads']/thead/descendant::th[@id='th-status']");
    public static By headerSource = By.xpath("//table[@id='leads']/thead/descendant::th[@id='th-source']");
    public static By headerLastContact = By.xpath("//table[@id='leads']/thead/descendant::th[@id='th-last-contact']");
    public static By headerCreated = By.xpath("//table[@id='leads']/thead/descendant::th[@id='th-date-created']");


    public static By getFirstRowItemLeadName(String leadName) {
        By xpath = By.xpath("//table[@id='leads']//a[normalize-space()='" + leadName + "']");
        return xpath;
    }

    public static By buttonView(String leadName) {
        By xpath = By.xpath("//table[@id='leads']//a[normalize-space()='" + leadName + "']/following-sibling::div/a[normalize-space()='View']");
        return xpath;
    }

    public static By buttonEdit(String leadName) {
        By xpath = By.xpath("//table[@id='leads']//a[normalize-space()='" + leadName + "']/following-sibling::div/a[normalize-space()='Edit']");
        return xpath;
    }

    public static By buttonDelete(String leadName) {
        By xpath = By.xpath("//table[@id='leads']//a[normalize-space()='" + leadName + "']/following-sibling::div/a[normalize-space()='Delete']");
        return xpath;
    }

    public static By labelLeadInfo = By.xpath("//div[@id='leads_info']");
    public static By buttonPrevious = By.xpath("//div[@id='leads_paginate']/descendant::li[@id='leads_previous']");

    public static By buttonNumberOfPage(String number) {
        By xpath = By.xpath("//div[@id='leads_paginate']/descendant::a[normalize-space()='" + number + "']");
        return xpath;
    }

    public static By buttonNext = By.xpath("//div[@id='leads_paginate']/descendant::li[@id='leads_next']");

    //Locator Add New Lead
    //dropdown Status
    public static By headerAddNewLead = By.xpath("//h4[normalize-space()='Add new lead']");

    public static By iconClosePopupLeadDetail(String headerLeadDetail) {
        By xpath = By.xpath("//h4[contains(normalize-space(),'" + headerLeadDetail + "')]/preceding-sibling::button[@aria-label='Close']");
        return xpath;
    }

    public static By dropdownStatus = By.xpath("//button[@data-id='status']");
    public static By inputSearchStatus = By.xpath("//button[@data-id='status']/following-sibling::div//input[@type='search']");
    public static By iconAddStatus = By.xpath("//label[@for='status']/following-sibling::div/div[@class='input-group-btn']");

    public static By getValueStatus(String status) {
        By xpath = By.xpath("//button[@data-id='status']/following-sibling::div//span[contains(normalize-space(),'" + status + "')]");
        return xpath;
    }

    //dropdown Source
    public static By dropdownSource = By.xpath("//button[@data-id='source']");
    public static By inputSearchSource = By.xpath("//button[@data-id='source']/following-sibling::div//input[@type='search']");
    public static By iconAddSource = By.xpath("//label[@for='source']/following-sibling::div/div[@class='input-group-btn']");

    public static By getValueSource(String source) {
        By xpath = By.xpath("//button[@data-id='source']/following-sibling::div//span[contains(normalize-space(),'" + source + "')]");
        return xpath;
    }

    //dropdown Assigned
    public static By dropdownAssigned = By.xpath("//button[@data-id='assigned']");
    public static By inputSearchAssigned = By.xpath("//button[@data-id='assigned']/following-sibling::div//input[@type='search']");

    public static By getValueAssigned(String assigned) {
        By xpath = By.xpath("//button[@data-id='assigned']/following-sibling::div//span[contains(normalize-space(),'" + assigned + "')]");
        return xpath;
    }

    //input
    public static By labelTags = By.xpath("//label[normalize-space()='Tags']");
    public static By inputTags = By.xpath("//label[@for='tags']/following-sibling::ul//input[@placeholder='Tag']");
    public static By inputTagsEdit = By.xpath("(//input[@id='tags']/following-sibling::ul)/descendant::span[@class='tagit-label']");
    public static By iconCloseTag = By.xpath("//a[@class='tagit-close' and normalize-space()='×']");

    public static By inputName = By.xpath("//div[@id='inputTagsWrapper']/following::div[@app-field-wrapper='name']/input[@id='name']");
    public static By inputAddress = By.xpath("//textarea[@id='address']");
    public static By inputPosition = By.xpath("//input[@id='title']");
    public static By inputCity = By.xpath("//input[@id='city']");
    public static By inputEmailAddress = By.xpath("//input[@id='email']");
    public static By inputState = By.xpath("//input[@id='state']");
    public static By inputWebsite = By.xpath("//input[@id='website']");

    //dropdown Country
    public static By dropdownCountry = By.xpath("//button[@data-id='country']");
    public static By inputSearchCountry = By.xpath("//button[@data-id='country']/following-sibling::div//input[@type='search']");

    public static By getValueCountry(String country) {
        By xpath = By.xpath("//button[@data-id='country']/following-sibling::div//span[contains(normalize-space(),'" + country + "')]");
        return xpath;
    }

    //input
    public static By labelPhone = By.xpath("//input[@id='phonenumber']/preceding-sibling::label[@for='phonenumber']");
    public static By inputPhone = By.xpath("//input[@id='phonenumber']");
    public static By inputZipcode = By.xpath("//input[@id='zip']");
    public static By inputLeadValue = By.xpath("//input[@name='lead_value']");

    //dropdown Default Language
    public static By dropdownDefaultLanguage = By.xpath("//button[@data-id='default_language']");
    public static By inputSearchDefaultLanguage = By.xpath("//button[@data-id='default_language']/following-sibling::div//input[@type='search']");

    public static By getValueDefaultLanguage(String language) {
        By xpath = By.xpath("//button[@data-id='default_language']/following-sibling::div//span[contains(normalize-space(),'" + language + "')]");
        return xpath;
    }

    //input
    public static By inputCompany = By.xpath("//input[@id='company']");
    public static By inputDescription = By.xpath("//textarea[@id='description']");
    public static By inputDateContacted = By.xpath("//input[@id='custom_contact_date']");
    public static By inputLastContact = By.xpath("//input[@id='lastcontact']");
    public static By iconDateContactedCalendar = By.xpath("//input[@id='custom_contact_date']/following-sibling::div");

    //checkbox
    public static By checkboxPublic = By.xpath("//input[@id='lead_public']");
    public static By labelCheckboxPublic = By.xpath("//label[@for='lead_public']");
    public static By checkboxContactedToday = By.xpath("//input[@id='contacted_today']");
    public static By labelCheckboxContactedToday = By.xpath("//label[normalize-space()='Contacted Today']");

    //button
    public static By buttonClose = By.xpath("//div[@class='lead-edit']/button[normalize-space()='Close']");
    public static By buttonSave = By.xpath("//button[normalize-space()='Save' and @id='lead-form-submit']");

    //message
    public static By addLeadSuccessMessage = By.xpath("//span[@class='alert-title' and normalize-space()='Lead added successfully.']/parent::div");
    public static By updateLeadSuccessMessage = By.xpath("//span[@class='alert-title' and normalize-space()='Lead updated successfully.']/parent::div");
    public static By deleteLeadSuccessMessage = By.xpath("//span[@class='alert-title' and normalize-space()='Lead deleted']/parent::div");
}
