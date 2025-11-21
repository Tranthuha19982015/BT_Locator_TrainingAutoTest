package com.hatester.thuc_hanh;

import com.hatester.bt_locators.LocatorLeadPage;
import com.hatester.bt_locators.LocatorLoginPage;
import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestCaseLead extends BaseTest {
    public void clickMenuLead() throws InterruptedException {
        driver.findElement(By.xpath(LocatorLeadPage.menuLead)).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorLeadPage.iconLeadsSummary)).click();
        Thread.sleep(2000);

        Assert.assertTrue(checkExistsElement(LocatorLeadPage.headerLeadsSummary), "Chưa chuyển hướng tới menu Lead");
    }

    public void clickButtonNewLead() throws InterruptedException {
        driver.findElement(By.xpath(LocatorLeadPage.buttonNewLead)).click();
        Thread.sleep(1000);

        Assert.assertTrue(checkExistsElement(LocatorLeadPage.headerAddNewLead), "Mở popup Add New Lead không thành công");
    }

    public void testAddNewLead(String status, String source, String assigned, String tag, String name, String position, String city, String emailAddress, String state, String website, String country, String phone, String zipCode, String leadValue, String language, String company, String description, String dateContacted, int flag) throws InterruptedException {
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

    public void clickIconClosePopupLeadDetail(String name) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", driver.findElement(By.xpath(LocatorLeadPage.iconClosePopupLeadDetail(name))));
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorLeadPage.iconClosePopupLeadDetail(name))).click();
        Thread.sleep(1000);
    }

    public void verifyAfterAddNewLead(String name) throws InterruptedException {
        driver.findElement(By.xpath(LocatorLeadPage.inputSearchLeads)).sendKeys(name);
        Thread.sleep(1000);
        Assert.assertTrue(checkExistsElement(LocatorLeadPage.getFirstRowItemLeadName(name)), "Không đúng giá trị Lead vừa thêm mới");
        Thread.sleep(2000);
    }

    public void verifyCheckboxSelected(String checkbox) {
        boolean checked = driver.findElement(By.xpath(checkbox)).isSelected();
        if (checked) {
            System.out.println("Checkbox đã tích chọn: " + checked);
        } else {
            System.out.println("Checkbox không tích chọn: " + checked);
        }
    }

    public void clickButtonEdit(String leadName) throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(LocatorLeadPage.getFirstRowItemLeadName(leadName)))).perform();
        driver.findElement(By.xpath(LocatorLeadPage.buttonEdit(leadName))).click();
        Thread.sleep(2000);
    }

    public void verifyNewLeadInEditPopup(String leadName, String status, String source, String assigned, String tag, String name,
                                         String position, String city, String emailAddress, String state, String website, String country,
                                         String phone, String zipCode, String leadValue, String language, String company, String description,
                                         String dateContacted) throws InterruptedException {

        boolean containsStatus = (driver.findElement(By.xpath(LocatorLeadPage.dropdownStatus)).getText()).contains(status);
        Assert.assertTrue(containsStatus, "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorLeadPage.dropdownSource)).getText(), source,
                "Không đúng giá trị đã thêm mới");
        boolean containsAssigned = driver.findElement(By.xpath(LocatorLeadPage.dropdownAssigned)).getText().contains(assigned);
        Assert.assertTrue(containsAssigned, "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorLeadPage.inputTagsEdit)).getAttribute("value").toLowerCase(), tag,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorLeadPage.inputName)).getAttribute("value"), name,
                "Không đúng giá trị đã thêm mới");
//        Assert.assertEquals(driver.findElement(By.xpath(LocatorLeadPage.inputAddress)).getAttribute("value"), address,
//        "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorLeadPage.inputPosition)).getAttribute("value"), position,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorLeadPage.inputCity)).getAttribute("value"), city,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorLeadPage.inputEmailAddress)).getAttribute("value"), emailAddress,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorLeadPage.inputState)).getAttribute("value"), state,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorLeadPage.inputWebsite)).getAttribute("value"), website,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorLeadPage.dropdownCountry)).getText(), country,
                "Không đúng giá trị đã thêm mới");

        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(LocatorLeadPage.buttonSave)));

        Assert.assertEquals(driver.findElement(By.xpath(LocatorLeadPage.inputPhone)).getAttribute("value"), phone,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorLeadPage.inputZipcode)).getAttribute("value"), zipCode,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorLeadPage.inputLeadValue)).getAttribute("value"), leadValue,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorLeadPage.dropdownDefaultLanguage)).getText(), language,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorLeadPage.inputCompany)).getAttribute("value"), company,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorLeadPage.inputDescription)).getAttribute("value"), description,
                "Không đúng giá trị đã thêm mới");
        boolean containsLastContact = driver.findElement(By.xpath(LocatorLeadPage.inputLastContact)).getAttribute("value").contains(dateContacted);
        Assert.assertTrue(containsLastContact, "Không đúng giá trị đã thêm mới");
        Assert.assertFalse(checkExistsElement(LocatorLeadPage.checkboxContactedToday), "Không ẩn checkbox trên màn hình Edit");
        Assert.assertTrue(driver.findElement(By.xpath(LocatorLeadPage.checkboxPublic)).isSelected(), "Không tích chọn checkbox");
    }

    @Test
    public void testAddAndCheckNewLead() throws InterruptedException {
        String leadName = "[htest]lead" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        String status = "Customer";
        String source = "Facebook";
        String assigned = "Anh Tester";
        String tag = "htest";
        String position = "Tester";
        String city = "Việt Nam";
        String emailAddress = "htest" + new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()) + "@gmail.com";
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

        clickMenuLead();
        clickButtonNewLead();
        testAddNewLead(status, source, assigned, tag, leadName, position, city, emailAddress, state, website, country, phone, zipCode, leadValue, language, company, description, lastContacted, 1);
        clickIconClosePopupLeadDetail(leadName);
        verifyAfterAddNewLead(leadName);
        clickButtonEdit(leadName);
        verifyNewLeadInEditPopup(leadName, status, source, assigned, tag, leadName, position, city, emailAddress, state, website, country, phone, zipCode, leadValue + ".00", language, company, description, lastContacted);
    }
}
