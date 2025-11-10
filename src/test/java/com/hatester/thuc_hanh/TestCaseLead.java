package com.hatester.thuc_hanh;

import com.hatester.bt_locators.LocatorLeadPage;
import com.hatester.bt_locators.LocatorLoginPage;
import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestCaseLead extends BaseTest {
    public void verifyDisplay(String field, String messageTrue, String messageFalse) {
        boolean check = driver.findElement(By.xpath(field)).isDisplayed();
        if (check) {
            System.out.println(messageTrue);
        } else {
            System.out.println(messageFalse);
        }
    }

    public void loginCRM() throws InterruptedException {
        driver.get(LocatorLoginPage.url);
        Thread.sleep(500);

        driver.findElement(By.xpath(LocatorLoginPage.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorLoginPage.inputEmail)).sendKeys("admin@example.com");
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLoginPage.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorLoginPage.inputPassword)).sendKeys("123456");
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLoginPage.buttonLogin)).click();
        Thread.sleep(1000);

        verifyDisplay(LocatorLoginPage.menuDashboard, "Đăng nhập CRM thành công!", "FAILED!!! Đăng nhập không thành công!");
    }

    public void testAddNewLead(String status, String source, String assigned, String tag, String name, String position,
                               String city, String emailAddress, String state, String website, String country, String phone, String zipCode,
                               String leadValue, String language, String company, String description, String dateContacted, int flag) throws InterruptedException {
        //click menu Lead
        driver.findElement(By.xpath(LocatorLeadPage.menuLead)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorLeadPage.iconLeadsSummary)).click();
        Thread.sleep(2000);

        verifyDisplay(LocatorLeadPage.headerLeadsSummary, "Đã tới trang Leads", "FAILED!!! Không truy cập được vào trang Leads");

        //click button New Lead
        driver.findElement(By.xpath(LocatorLeadPage.buttonNewLead)).click();
        Thread.sleep(1000);

        verifyDisplay(LocatorLeadPage.headerAddNewLead, "Mở pop-up Add new lead thành công", "FAILED!!! Không mở được pop-up Add new lead");

        //status
        driver.findElement(By.xpath(LocatorLeadPage.dropdownStatus)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLeadPage.inputSearchStatus)).sendKeys(status);
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorLeadPage.getValueStatus(status))).click();
        Thread.sleep(500);

        //source
        driver.findElement(By.xpath(LocatorLeadPage.dropdownSource)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLeadPage.inputSearchSource)).sendKeys(source);
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorLeadPage.getValueSource(source))).click();
        Thread.sleep(500);

        //assigned
        driver.findElement(By.xpath(LocatorLeadPage.dropdownAssigned)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLeadPage.inputSearchAssigned)).sendKeys(assigned);
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorLeadPage.getValueAssigned(assigned))).click();
        Thread.sleep(500);

        //input
        driver.findElement(By.xpath(LocatorLeadPage.inputTags)).sendKeys(tag);
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLeadPage.labelTags)).click();
        driver.findElement(By.xpath(LocatorLeadPage.labelTags)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLeadPage.inputName)).sendKeys(name);
        Thread.sleep(500);
//        driver.findElement(By.xpath(LocatorLeadPage.inputAddress)).sendKeys("Gia Khánh");
//        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLeadPage.inputPosition)).sendKeys(position);
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLeadPage.inputCity)).sendKeys(city);
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLeadPage.inputEmailAddress)).sendKeys(emailAddress);
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLeadPage.inputState)).sendKeys(state);
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLeadPage.inputWebsite)).sendKeys(website);
        Thread.sleep(500);

        //country
        driver.findElement(By.xpath(LocatorLeadPage.dropdownCountry)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLeadPage.inputSearchCountry)).sendKeys(country);
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorLeadPage.getValueCountry(country))).click();
        Thread.sleep(500);

        //input
        driver.findElement(By.xpath(LocatorLeadPage.inputPhone)).sendKeys(phone);
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLeadPage.inputZipcode)).sendKeys(zipCode);
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLeadPage.inputLeadValue)).sendKeys(leadValue);
        Thread.sleep(500);

        //Default Language
        driver.findElement(By.xpath(LocatorLeadPage.dropdownDefaultLanguage)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLeadPage.inputSearchDefaultLanguage)).sendKeys(language);
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorLeadPage.getValueDefaultLanguage(language))).click();
        Thread.sleep(1000);

        //input
        driver.findElement(By.xpath(LocatorLeadPage.inputCompany)).sendKeys(company);
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLeadPage.inputDescription)).sendKeys(description);
        Thread.sleep(500);

        //checkbox
        driver.findElement(By.xpath(LocatorLeadPage.checkboxPublic)).click();
        Thread.sleep(500);
        if (flag == 1) {
            driver.findElement(By.xpath(LocatorLeadPage.checkboxContactedToday)).click();
            Thread.sleep(500);
            driver.findElement(By.xpath(LocatorLeadPage.inputDateContacted)).sendKeys(dateContacted);
            Thread.sleep(500);
        }

        //save
        driver.findElement(By.xpath(LocatorLeadPage.buttonSave)).click();
        Thread.sleep(3000);
    }

    public void verifyAfterAddNewLead(String name) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", driver.findElement(By.xpath(LocatorLeadPage.iconClosePopupLeadDetail(name))));
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorLeadPage.iconClosePopupLeadDetail(name))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorLeadPage.inputSearchLeads)).sendKeys(name);
        Thread.sleep(1000);

        verifyDisplay(LocatorLeadPage.getFirstRowItemLeadName(name), "Thêm mới Lead thành công! Lead mới: " + name,
                "FAILED!!! Thêm mới Lead không thành công!!!");
        Thread.sleep(2000);
    }

    public void compareFieldTextEquals(String field, String expectedValue) {
        String actualValue = driver.findElement(By.xpath(field)).getText().trim();
        if (actualValue.equalsIgnoreCase(expectedValue)) {
            System.out.println("Đúng giá trị đã thêm mới: " + expectedValue);
        } else {
            System.out.println("Không phải giá trị vừa thêm mới: " + expectedValue);
        }
    }

    public void compareFieldTextContains(String field, String expectedValue) {
        String actualValue = driver.findElement(By.xpath(field)).getText().trim().toLowerCase();
        if (actualValue.contains(expectedValue.toLowerCase())) {
            System.out.println("Đúng giá trị đã thêm mới: " + expectedValue);
        } else {
            System.out.println("Không phải giá trị vừa thêm mới: " + expectedValue);
        }
    }

    public void compareFieldAttribute(String field, String attribute, String expectedValue) {
        String actualValue = driver.findElement(By.xpath(field)).getAttribute(attribute).trim();
        if (actualValue.equalsIgnoreCase(expectedValue)) {
            System.out.println("Đúng giá trị đã thêm mới: " + expectedValue);
        } else {
            System.out.println("Không phải giá trị vừa thêm mới: " + expectedValue);
        }
    }

    public void compareFieldAttributeSubstring(String field, String attribute, String expectedValue) {
        String actualValue = driver.findElement(By.xpath(field)).getAttribute(attribute).trim().substring(0,10);
        if (actualValue.equalsIgnoreCase(expectedValue)) {
            System.out.println("Đúng giá trị đã thêm mới: " + expectedValue);
        } else {
            System.out.println("Không phải giá trị vừa thêm mới: " + expectedValue);
        }
    }

    public void verifyCheckboxSelectedAndExist(String checkbox) {
        List<WebElement> element = driver.findElements(By.xpath(checkbox));
        if (element.size() > 0) {
            System.out.println("Checkbox is selected: true");
        } else {
            System.out.println("Checkbox is selected: false");
        }
    }

    public void verifyCheckboxSelected(String checkbox) {
        boolean checked = driver.findElement(By.xpath(checkbox)).isSelected();
        if (checked) {
            System.out.println("Checkbox is selected: " + checked);
        } else {
            System.out.println("Checkbox is selected: " + checked);

        }
    }

    public void verifyNewLeadInEditPopup(String leadName, String status, String source, String assigned, String tag, String name, String position,
                                         String city, String emailAddress, String state, String website, String country, String phone, String zipCode,
                                         String leadValue, String language, String company, String description, String dateContacted) throws InterruptedException {

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(LocatorLeadPage.getFirstRowItemLeadName(leadName)))).perform();
        driver.findElement(By.xpath(LocatorLeadPage.buttonEdit(leadName))).click();
        Thread.sleep(2000);

        compareFieldTextContains(LocatorLeadPage.dropdownStatus, status);
        compareFieldTextEquals(LocatorLeadPage.dropdownSource, source);
        compareFieldTextContains(LocatorLeadPage.dropdownAssigned, assigned);
        compareFieldAttribute(LocatorLeadPage.inputTagsEdit, "value", tag);
        compareFieldAttribute(LocatorLeadPage.inputName, "value", name);
//        compareFieldAttribute(LocatorLeadPage.inputAddress,"value",address);
        compareFieldAttribute(LocatorLeadPage.inputPosition, "value", position);
        compareFieldAttribute(LocatorLeadPage.inputCity, "value", city);
        compareFieldAttribute(LocatorLeadPage.inputEmailAddress, "value", emailAddress);
        compareFieldAttribute(LocatorLeadPage.inputState, "value", state);
        compareFieldAttribute(LocatorLeadPage.inputWebsite, "value", website);
        compareFieldTextEquals(LocatorLeadPage.dropdownCountry, country);
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(LocatorLeadPage.buttonSave)));
        compareFieldAttribute(LocatorLeadPage.inputPhone, "value", phone);
        compareFieldAttribute(LocatorLeadPage.inputZipcode, "value", zipCode);
        compareFieldAttribute(LocatorLeadPage.inputLeadValue, "value", leadValue);
        compareFieldTextEquals(LocatorLeadPage.dropdownDefaultLanguage, language);
        compareFieldAttribute(LocatorLeadPage.inputCompany, "value", company);
        compareFieldAttribute(LocatorLeadPage.inputDescription, "value", description);
        compareFieldAttributeSubstring(LocatorLeadPage.inputLastContact, "value", dateContacted);
        verifyCheckboxSelectedAndExist(LocatorLeadPage.checkboxContactedToday);
        verifyCheckboxSelected(LocatorLeadPage.checkboxPublic);
    }

    public static void main(String[] args) throws InterruptedException {
        TestCaseLead lead1 = new TestCaseLead();
        String leadName = "lead_htest" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        String status = "Customer";
        String source = "Facebook";
        String assigned = "Anh Tester";
        String tag = "htest";
        String position = "Tester";
        String city = "Việt Nam";
        String emailAddress = "hatest" + new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()) + "@gmail.com";
        String state = "htest state";
        String website = "htester.com.vn";
        String country = "Vietnam";
        String phone = "0965898989";
        String zipCode = "0001";
        String leadValue = "12345";
        String language = "Vietnamese";
        String company = "NDJSC";
        String description = "htest add new lead";
        String lastContacted = "10-11-2025";

        lead1.createDriver();
        lead1.loginCRM();
        lead1.testAddNewLead(status, source, assigned, tag, leadName, position, city, emailAddress, state, website, country, phone, zipCode,
                leadValue, language, company, description, lastContacted, 1);
        lead1.verifyAfterAddNewLead(leadName);
        lead1.verifyNewLeadInEditPopup(leadName, status, source, assigned, tag, leadName, position, city, emailAddress, state, website, country, phone, zipCode,
                leadValue + ".00", language, company, description, lastContacted);
        lead1.closeDriver();
    }
}
