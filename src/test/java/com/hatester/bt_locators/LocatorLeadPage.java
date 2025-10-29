package com.hatester.bt_locators;

public class LocatorLeadPage {
    //locator menu Lead
    public static String menuLead = "//ul[@id='side-menu']//span[normalize-space()='Leads' and @class='menu-text']";

    //Locator Lead Page
    public static String buttonNewLead = "//a[normalize-space()='New Lead']";
    public static String iconLeadsSummary = "//a[@data-title='Leads Summary']";
    public static String iconSwitchToKanban = "//a[@data-title='Switch to Kanban']";
    public static String inputSearchLeads = "//div[@id='leads_filter']//input[@type='search']";

    public static String getFirstRowItemLeadName(String leadName) {
        String xpath = "//table[@id='leads']//a[normalize-space()='" + leadName + "']";
        return xpath;
    }

    //Locator Add New Lead
    //dropdown Status
    public static String dropdownStatus = "//button[@data-id='status']";
    public static String inputSearchStatus = "//button[@data-id='status']/following-sibling::div//input[@type='search']";
    public static String iconAddStatus = "//label[@for='status']/following-sibling::div/div[@class='input-group-btn']";

    public static String getValueStatus(String status) {
        String xpath = "//button[@data-id='status']/following-sibling::div//span[normalize-space()='" + status + "']";
        return xpath;
    }

    //dropdown Source
    public static String dropdownSource = "//button[@data-id='source']";
    public static String inputSearchSource = "//button[@data-id='source']/following-sibling::div//input[@type='search']";
    public static String iconAddSource = "//label[@for='source']/following-sibling::div/div[@class='input-group-btn']";

    public static String getValueSource(String source) {
        String xpath = "//button[@data-id='source']/following-sibling::div//span[normalize-space()='" + source + "']";
        return xpath;
    }

    //dropdown Assigned
    public static String dropdownAssigned = "//button[@data-id='assigned']";
    public static String inputSearchAssigned = "//button[@data-id='assigned']/following-sibling::div//input[@type='search']";

    public static String getValueAssigned(String assigned) {
        String xpath = "//button[@data-id='assigned']/following-sibling::div//span[normalize-space()='" + assigned + "']";
        return xpath;
    }

    //input
    public static String inputTags = "//input[@id='tags']/following-sibling::ul//input[@placeholder='Tag']";
    public static String inputName = "//input[@id='name']";
    public static String inputAddress = "//textarea[@id='address']";
    public static String inputPosition = "//input[@id='title']";
    public static String inputCity = "//input[@id='city']";
    public static String inputEmailAddress = "//input[@id='email']";
    public static String inputState = "//input[@id='state']";
    public static String inputWebsite = "//input[@id='website']";

    //dropdown Country
    public static String dropdownCountry = "//button[@data-id='country']";
    public static String inputSearchCountry = "//button[@data-id='country']/following-sibling::div//input[@type='search']";

    public static String getValueCountry(String country) {
        String xpath = "//button[@data-id='country']/following-sibling::div//span[normalize-space()='" + country + "']";
        return xpath;
    }

    //input
    public static String inputPhone = "//input[@id='phonenumber']";
    public static String inputZipcode = "//input[@id='zip']";
    public static String inputLeadValue = "//input[@name='lead_value']";

    //dropdown Default Language
    public static String dropdownDefaultLanguage = "//button[@data-id='default_language']";
    public static String inputSearchDefaultLanguage = "//button[@data-id='default_language']/following-sibling::div//input[@type='search']";

    public static String getValueDefaultLanguage(String language) {
        String xpath = "//button[@data-id='default_language']/following-sibling::div//span[normalize-space()='" + language + "']";
        return xpath;
    }

    //input
    public static String inputCompany = "//input[@id='company']";
    public static String inputDescription = "//textarea[@id='description']";

    //checkbox
    public static String checkboxPublic = "//input[@id='lead_public']";
    public static String checkboxContactedToday = "//input[@id='contacted_today']";

    //button
    public static String buttonClose = "//div[@class='lead-edit']/button[normalize-space()='Close']";
    public static String buttonSave = "//button[normalize-space()='Save' and @id='lead-form-submit']";
}
