package com.hatester.bt_locators;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestCaseTask extends BaseTest {

    public void testAddNewLead(String status, String source, String assigned, String tag, String name, String country, String language) throws InterruptedException {
        //click menu Lead
        driver.findElement(By.xpath(LocatorLeadPage.menuLead)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorLeadPage.iconLeadsSummary)).click();
        Thread.sleep(1000);
        boolean checkMenuLeadDisplay = driver.findElement(By.xpath(LocatorLeadPage.headerLeadsSummary)).isDisplayed();
        if (checkMenuLeadDisplay) {
            System.out.println("Đã tới trang Leads");
        } else {
            System.out.println("FAILED!!! Không truy cập được vào trang Leads");
        }

        //click button New Lead
        driver.findElement(By.xpath(LocatorLeadPage.buttonNewLead)).click();
        Thread.sleep(1000);
        boolean checkPopupAddNewDisplay = driver.findElement(By.xpath(LocatorLeadPage.headerAddNewLead)).isDisplayed();
        if (checkPopupAddNewDisplay) {
            System.out.println("Mở pop-up Add new lead thành công");
        } else {
            System.out.println("FAILED!!! Không mở được pop-up Add new lead");
        }

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
        driver.findElement(By.xpath(LocatorLeadPage.inputPosition)).sendKeys("Thường Tín");
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLeadPage.inputCity)).sendKeys("Hà Nội");
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLeadPage.inputEmailAddress)).sendKeys("htest@gmail.com");
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLeadPage.inputState)).sendKeys("htest state");
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLeadPage.inputWebsite)).sendKeys("htestwebsite.vn");
        Thread.sleep(500);

        //country
        driver.findElement(By.xpath(LocatorLeadPage.dropdownCountry)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLeadPage.inputSearchCountry)).sendKeys(country);
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorLeadPage.getValueCountry(country))).click();
        Thread.sleep(500);

        //input
        driver.findElement(By.xpath(LocatorLeadPage.inputPhone)).sendKeys("0965898998");
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLeadPage.inputZipcode)).sendKeys("00012");
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLeadPage.inputLeadValue)).sendKeys("123");
        Thread.sleep(500);

        //Default Language
        driver.findElement(By.xpath(LocatorLeadPage.dropdownDefaultLanguage)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLeadPage.inputSearchDefaultLanguage)).sendKeys(language);
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorLeadPage.getValueDefaultLanguage(language))).click();
        Thread.sleep(1000);

        //input
        driver.findElement(By.xpath(LocatorLeadPage.inputCompany)).sendKeys("NDJSC");
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLeadPage.inputDescription)).sendKeys("test add new lead");
        Thread.sleep(500);

        //checkbox
        driver.findElement(By.xpath(LocatorLeadPage.checkboxPublic)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLeadPage.checkboxContactedToday)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLeadPage.inputDateContacted)).sendKeys("06-11-2025");
        Thread.sleep(500);

        //save
        driver.findElement(By.xpath(LocatorLeadPage.buttonSave)).click();
        Thread.sleep(1000);
    }

    public void verifyAfterAddNewLead(String name) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", driver.findElement(By.xpath(LocatorLeadPage.buttonClosePopupDetail(name))));
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorLeadPage.buttonClosePopupDetail(name))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorLeadPage.inputSearchLeads)).sendKeys(name);
        Thread.sleep(1000);

        boolean check = driver.findElement(By.xpath(LocatorLeadPage.getFirstRowItemLeadName(name))).isDisplayed();
        if (check) {
            System.out.println("Thêm mới Lead thành công! Lead mới: " + name);
        } else {
            System.out.println("FAILED!!! Thêm mới Lead không thành công!!!");
        }
        Thread.sleep(2000);
    }

    public static void main(String[] args) throws InterruptedException {
        TestCaseLogin login = new TestCaseLogin();
        TestCaseTask tcAddLead = new TestCaseTask();
        String name = "htest" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());

        tcAddLead.createDriver();
        login.loginCRM();
        tcAddLead.testAddNewLead("Customer", "Facebook", "Anh Tester", "htest", name, "Vietnam", "Vietnamese");
        tcAddLead.verifyAfterAddNewLead(name);
        tcAddLead.closeDriver();
    }
}
