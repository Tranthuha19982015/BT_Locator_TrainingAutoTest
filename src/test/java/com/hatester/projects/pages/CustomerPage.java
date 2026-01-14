package com.hatester.projects.pages;

import com.hatester.common.BasePage;
import com.hatester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class CustomerPage extends BasePage {
    //button
    private By buttonNewCustomer = By.xpath("//div[@class='_buttons']/descendant::a[normalize-space()='New Customer']");
    private By buttonImportCustomers = By.xpath("//div[@class='_buttons']/descendant::a[normalize-space()='Import Customers']");
    private By buttonContacts = By.xpath("//div[@class='_buttons']/descendant::a[normalize-space()='Contacts']");

    //summary
    private By headerCustomersSummary = By.xpath("//span[normalize-space()='Customers Summary']");
    private By labelTotalCustomers = By.xpath("//span[text()='Total Customers']/preceding-sibling::span");
    private By labelActiveCustomers = By.xpath("//span[text()='Active Customers']/preceding-sibling::span");
    private By labelInactiveCustomers = By.xpath("//span[text()='Inactive Customers']/preceding-sibling::span");
    private By labelActiveContacts = By.xpath("//span[text()='Active Contacts']/preceding-sibling::span");
    private By labelInactiveContacts = By.xpath("//span[text()='Inactive Contacts']/preceding-sibling::span");
    private By labelContactsLoggedInToday = By.xpath("//span[normalize-space()='Contacts Logged In Today']/preceding-sibling::span");

    //table
    private By inputSearchCustomers = By.xpath("//div[@id='clients_filter']/descendant::input[@type='search']");

    private By getFirstRowCustomersName(String customerName) {
        By firstRowName = By.xpath("//table[@id='clients']/descendant::td[contains(normalize-space(),'" + customerName + "')]");
        return firstRowName;
    }

    private By buttonView(String customerName) {
        By buttonView = By.xpath("//table[@id='clients']/descendant::td[contains(normalize-space(),'" + customerName + "')]/descendant::a[normalize-space()='View']");
        return buttonView;
    }

    private By buttonContacts(String customerName) {
        By buttonContacts = By.xpath("//table[@id='clients']/descendant::td[contains(normalize-space(),'" + customerName + "')]/descendant::a[normalize-space()='Contacts']");
        return buttonContacts;
    }

    private By buttonDelete(String customerName) {
        By buttonDelete = By.xpath("//table[@id='clients']/descendant::td[contains(normalize-space(),'" + customerName + "')]/descendant::a[normalize-space()='Delete']");
        return buttonDelete;
    }

    //pop-up Add new customer
    //tab Customer Details
    private By headerCustomerDetailsTab = By.xpath("//a[normalize-space()='Customer Details']");
    private By headerBillingAndShipping = By.xpath("//a[normalize-space()='Billing & Shipping']");

    //input
    private By inputCompany = By.xpath("//input[@id='company']");
    private By inputVatNumber = By.xpath("//input[@id='vat']");
    private By inputPhone = By.xpath("//input[@id='phonenumber']");
    private By inputWebsite = By.xpath("//input[@id='website']");

    //groups
    private By dropdownGroups = By.xpath("//button[contains(@data-id,'groups_in')]");
    private By inputSearchGroup = By.xpath("(//button[contains(@data-id,'groups_in')]/following-sibling::div)/descendant::input[@type='search']");

    private By getValueGroup(String group) {
        By valueGroup = By.xpath("(//button[contains(@data-id,'groups_in')]/following-sibling::div)/descendant::span[text()='" + group + "']");
        return valueGroup;
    }

    //currency
    private By dropdownCurrency = By.xpath("//button[@data-id='default_currency']");
    private By inputSearchCurrency = By.xpath("(//button[@data-id='default_currency']/following-sibling::div)/descendant::input[@type='search']");

    private By getValueCurrency(String currency) {
        By valueCurrency = By.xpath("(//button[@data-id='default_currency']/following-sibling::div)/descendant::span[text()='" + currency + "']");
        return valueCurrency;
    }

    //default language
    private By dropdownDefaultLanguage = By.xpath("//button[contains(@data-id,'default_language')]");

    private By getValueDefaultLanguage(String language) {
        By valueLanguage = By.xpath("(//button[contains(@data-id,'default_language')]/following-sibling::div)/descendant::span[text()='" + language + "']");
        return valueLanguage;
    }

    //input
    private By inputAddress = By.xpath("//textarea[@id='address']");
    private By inputCity = By.xpath("//input[@id='city']");
    private By inputState = By.xpath("//input[@id='state']");
    private By inputZipCode = By.xpath("//input[@id='zip']");

    //country
    private By dropdownCountry = By.xpath("//button[@data-id='country']");
    private By inputSearchCountry = By.xpath("(//button[@data-id='country']/following-sibling::div)/descendant::input[@type='search']");

    private By getValueCountry(String country) {
        By valueCountry = By.xpath("(//button[@data-id='country']/following-sibling::div)/descendant::span[text()='" + country + "']");
        return valueCountry;
    }

    //button
    private By buttonSaveAndCreateContact = By.xpath("//div[@id='profile-save-section']/button[normalize-space()='Save and create contact']");
    private By buttonSave = By.xpath("//div[@id='profile-save-section']/button[normalize-space()='Save']");

    //message
    private By addCustomerMessage = By.xpath("//span[@class='alert-title' and text()='Customer added successfully.']");
    private By iconCloseAddCustomerMessage = By.xpath("//span[@class='alert-title' and text()='Customer added successfully.']/preceding-sibling::button[@class='close']");
    private By updateCustomerMessage = By.xpath("//span[@class='alert-title' and text()='Customer updated successfully.']");
    private By iconCloseUpdateCustomerMessage = By.xpath("//span[@class='alert-title' and text()='Customer updated successfully.']/preceding-sibling::button[@class='close']");
    private By deleteCustomerMessage = By.xpath("//span[@class='alert-title' and text()='Customer deleted']");
    private By iconCloseDeleteCustomerMessage = By.xpath("//span[@class='alert-title' and text()='Customer deleted']/preceding-sibling::button[@class='close']");

    //functions
    public void verifyHeaderCustomersSummaryDisplayed() {
        Assert.assertTrue(WebUI.checkElementExist(headerCustomersSummary));
    }

    public void clickButtonAddCustomer() {
        WebUI.clickElement(buttonNewCustomer);
    }

    public void verifyHeaderCustomerDetailsTabDisplayed() {
        Assert.assertTrue(WebUI.checkElementExist(headerCustomerDetailsTab));
    }

    public void fillDataCustomer(String company, String vatNumber, String phone, String website, String group, String currency,
                                 String defaultLanguage, String address, String city, String state, String zipCode, String country, int flagEdit) {

        if (flagEdit == 1) {
            WebUI.clearTextElement(inputCompany);
            WebUI.clearTextElement(inputVatNumber);
            WebUI.clearTextElement(inputPhone);
            WebUI.clearTextElement(inputWebsite);
            WebUI.clearTextElement(inputAddress);
            WebUI.clearTextElement(inputCity);
            WebUI.clearTextElement(inputState);
            WebUI.clearTextElement(inputZipCode);
        }

        WebUI.setTextElement(inputCompany, company);
        WebUI.setTextElement(inputVatNumber, vatNumber);
        WebUI.setTextElement(inputPhone, phone);
        WebUI.setTextElement(inputWebsite, website);

        WebUI.clickElement(dropdownGroups);
        WebUI.setTextElement(inputSearchGroup, group);
        WebUI.clickElement(getValueGroup(group));

        WebUI.clickElement(dropdownCurrency);
        WebUI.setTextElement(inputSearchCurrency, currency);
        WebUI.clickElement(getValueCurrency(currency));

        WebUI.clickElement(dropdownDefaultLanguage);
        WebUI.clickElement(getValueDefaultLanguage(defaultLanguage));

        WebUI.setTextElement(inputAddress, address);
        WebUI.setTextElement(inputCity, city);
        WebUI.setTextElement(inputState, state);
        WebUI.setTextElement(inputZipCode, zipCode);

        WebUI.clickElement(dropdownCountry);
        WebUI.setTextElement(inputSearchCountry, country);
        WebUI.clickElement(getValueCountry(country));
    }

    public void clickButtonSaveAndCreateContact() {
        WebUI.clickElement(buttonSaveAndCreateContact);
    }

    public void clickButtonSave() {
        WebUI.clickElement(buttonSave);
    }

    public void searchAndCheckCustomer(String customerName) {
        WebUI.setTextElement(inputSearchCustomers, customerName);
        WebUI.waitForElementVisible(getFirstRowCustomersName(customerName));
        Assert.assertTrue(WebUI.checkElementExist(getFirstRowCustomersName(customerName)),
                "Không đúng giá trị Customer vừa thêm mới");
    }

    public void searchCustomers(String customerName) {
        WebUI.sleep(0.5);
        WebUI.setTextElement(inputSearchCustomers, customerName);
    }

    public void moveToCustomerName(String customerName) {
        WebUI.waitForElementVisible(getFirstRowCustomersName(customerName));
        WebUI.sleep(0.5);
        WebUI.moveToElement(getFirstRowCustomersName(customerName));
        WebUI.sleep(0.5);
    }

    public void clickButtonDelete(String customerName) {
        WebUI.clickElement(buttonDelete(customerName));
        WebUI.sleep(0.5);
    }

    public void confirmDeleteAlert(String customerName, int typeConfirm) {
        if (typeConfirm == 1) {
            WebUI.acceptAlert();
        } else {
            WebUI.dismissAlert();
        }
        WebUI.waitForElementNotVisible(deleteCustomerMessage);
    }
}
