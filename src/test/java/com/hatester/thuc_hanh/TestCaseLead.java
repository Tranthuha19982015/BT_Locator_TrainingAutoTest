package com.hatester.thuc_hanh;

import com.hatester.bt_locators.LocatorLeadPage;
import com.hatester.keywords.WebUI;
import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestCaseLead extends BaseTest {
    String leadName;
    String status;
    String source;
    String assigned;
    String tag;
    String position;
    String city;
    String emailAddress;
    String state;
    String website;
    String country;
    String phone;
    String zipCode;
    String leadValue;
    String language;
    String company;
    String description;
    String lastContacted;
    int flag;
    int flagEdit;

    public void clickMenuLead() throws InterruptedException {
        driver.findElement(By.xpath(LocatorLeadPage.menuLead)).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorLeadPage.iconLeadsSummary)).click();
        Thread.sleep(2000);

        Assert.assertTrue(WebUI.checkExistsElement(driver, LocatorLeadPage.headerLeadsSummary), "Chưa chuyển hướng tới menu Lead");
    }

    public void clickButtonNewLead() throws InterruptedException {
        driver.findElement(By.xpath(LocatorLeadPage.buttonNewLead)).click();
        Thread.sleep(1000);

        Assert.assertTrue(WebUI.checkExistsElement(driver, LocatorLeadPage.headerAddNewLead), "Mở popup Add New Lead không thành công");
    }

    public void fillDataLead(String status, String source, String assigned, String tag, String name, String position,
                             String city, String emailAddress, String state, String website, String country, String phone,
                             String zipCode, String leadValue, String language, String company, String description,
                             String dateContacted, int flag, int flagEdit) throws InterruptedException {
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
        if (flagEdit == 1) {
            driver.findElement(By.xpath(LocatorLeadPage.iconCloseTag)).click();
            driver.findElement(By.xpath(LocatorLeadPage.inputName)).clear();
//            driver.findElement(By.xpath(LocatorLeadPage.inputAddress)).clear();
            driver.findElement(By.xpath(LocatorLeadPage.inputPosition)).clear();
            driver.findElement(By.xpath(LocatorLeadPage.inputCity)).clear();
            driver.findElement(By.xpath(LocatorLeadPage.inputEmailAddress)).clear();
            driver.findElement(By.xpath(LocatorLeadPage.inputState)).clear();
            driver.findElement(By.xpath(LocatorLeadPage.inputWebsite)).clear();
            driver.findElement(By.xpath(LocatorLeadPage.inputPhone)).clear();
            driver.findElement(By.xpath(LocatorLeadPage.inputZipcode)).clear();
            driver.findElement(By.xpath(LocatorLeadPage.inputLeadValue)).clear();
            driver.findElement(By.xpath(LocatorLeadPage.inputCompany)).clear();
            driver.findElement(By.xpath(LocatorLeadPage.inputDescription)).clear();
            driver.findElement(By.xpath(LocatorLeadPage.inputLastContact)).clear();

            driver.findElement(By.xpath(LocatorLeadPage.labelPhone)).click();
            driver.findElement(By.xpath(LocatorLeadPage.labelPhone)).click();
            Thread.sleep(1000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(false);", driver.findElement(By.xpath(LocatorLeadPage.dropdownStatus)));
            Thread.sleep(1000);
            driver.findElement(By.xpath(LocatorLeadPage.inputTags)).click();

        }

        driver.findElement(By.xpath(LocatorLeadPage.inputTags)).sendKeys(tag, Keys.ENTER);
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

        if (flagEdit == 0) {
            driver.findElement(By.xpath(LocatorLeadPage.checkboxContactedToday)).click();
            Thread.sleep(500);
            driver.findElement(By.xpath(LocatorLeadPage.inputDateContacted)).sendKeys(dateContacted);
            Thread.sleep(500);
        } else {
            driver.findElement(By.xpath(LocatorLeadPage.inputLastContact)).clear();
            driver.findElement(By.xpath(LocatorLeadPage.inputLastContact)).sendKeys(dateContacted);
            Thread.sleep(500);
        }
    }

    public void clickButtonSave() throws InterruptedException {
        driver.findElement(By.xpath(LocatorLeadPage.buttonSave)).click();
        Thread.sleep(3000);
    }

    public void clickIconClosePopupLeadDetail(String name) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(LocatorLeadPage.iconClosePopupLeadDetail(name))));
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorLeadPage.iconClosePopupLeadDetail(name))).click();
        Thread.sleep(1000);
    }

    public void searchAndCheckLeads(String name) throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorLeadPage.inputSearchLeads)).sendKeys(name);
        Thread.sleep(1000);
        Assert.assertTrue(WebUI.checkExistsElement(driver, LocatorLeadPage.getFirstRowItemLeadName(name)), "Không đúng giá trị Lead vừa thêm mới");
        Thread.sleep(2000);
    }

    public void clickButtonEdit(String leadName) throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(LocatorLeadPage.getFirstRowItemLeadName(leadName)))).perform();
        driver.findElement(By.xpath(LocatorLeadPage.buttonEdit(leadName))).click();
    }

    public void verifyNewLeadInEditPopup(String leadName, String status, String source, String assigned, String tag, String name,
                                         String position, String city, String emailAddress, String state, String website, String country,
                                         String phone, String zipCode, String leadValue, String language, String company, String description,
                                         String dateContacted) throws InterruptedException {
        Thread.sleep(1000);
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
        Assert.assertFalse(WebUI.checkExistsElement(driver, LocatorLeadPage.checkboxContactedToday), "Không ẩn checkbox trên màn hình Edit");
        Assert.assertTrue(driver.findElement(By.xpath(LocatorLeadPage.checkboxPublic)).isSelected(), "Không tích chọn checkbox");
        Thread.sleep(1000);
    }

    public void clickButtonDelete(String leadName) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(LocatorLeadPage.getFirstRowItemLeadName(leadName)))).perform();
        driver.findElement(By.xpath(LocatorLeadPage.buttonDelete(leadName))).click();
    }

    public void confirmAlertDelete() throws InterruptedException {
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
    }

    public void verifyAfterDeleteLead(String name) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorLeadPage.inputSearchLeads)).sendKeys(name);
        Thread.sleep(1000);
        Assert.assertFalse(WebUI.checkExistsElement(driver, LocatorLeadPage.getFirstRowItemLeadName(name)), "Xóa Lead không thành công");
        Thread.sleep(1000);
    }


    @Test
    public void testAddNewLead() throws InterruptedException {
        TestCaseLead leadAdd = new TestCaseLead();
        leadAdd.leadName = "[htest]lead add" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        leadAdd.status = "Customer";
        leadAdd.source = "Facebook";
        leadAdd.assigned = "Anh Tester";
        leadAdd.tag = "htest";
        leadAdd.position = "Tester";
        leadAdd.city = "Việt Nam";
        leadAdd.emailAddress = "htest" + new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()) + "@gmail.com";
        leadAdd.state = "htest state";
        leadAdd.website = "htester.com.vn";
        leadAdd.country = "Vietnam";
        leadAdd.phone = "0965898989";
        leadAdd.zipCode = "0001";
        leadAdd.leadValue = "12345";
        leadAdd.language = "Vietnamese";
        leadAdd.company = "NDJSC";
        leadAdd.description = "htest add new lead";
        leadAdd.lastContacted = "10-11-2025";
        leadAdd.flag = 1;
        leadAdd.flagEdit = 0;

        clickMenuLead();
        clickButtonNewLead();
        fillDataLead(leadAdd.status, leadAdd.source, leadAdd.assigned, leadAdd.tag, leadAdd.leadName, leadAdd.position, leadAdd.city, leadAdd.emailAddress,
                leadAdd.state, leadAdd.website, leadAdd.country, leadAdd.phone, leadAdd.zipCode, leadAdd.leadValue, leadAdd.language, leadAdd.company,
                leadAdd.description, leadAdd.lastContacted, leadAdd.flag, leadAdd.flagEdit);
        clickButtonSave();
        clickIconClosePopupLeadDetail(leadAdd.leadName);
        searchAndCheckLeads(leadAdd.leadName);
        clickButtonEdit(leadAdd.leadName);
        verifyNewLeadInEditPopup(leadAdd.leadName, leadAdd.status, leadAdd.source, leadAdd.assigned, leadAdd.tag, leadAdd.leadName, leadAdd.position,
                leadAdd.city, leadAdd.emailAddress, leadAdd.state, leadAdd.website, leadAdd.country, leadAdd.phone, leadAdd.zipCode,
                leadAdd.leadValue + ".00", leadAdd.language, leadAdd.company, leadAdd.description, leadAdd.lastContacted);
    }

    @Test
    public void testEditNewLead() throws InterruptedException {
        TestCaseLead leadEdit = new TestCaseLead();
        leadEdit.leadName = "[htest]lead add" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        leadEdit.status = "Customer";
        leadEdit.source = "Facebook";
        leadEdit.assigned = "Anh Tester";
        leadEdit.tag = "htest";
        leadEdit.position = "Tester";
        leadEdit.city = "Việt Nam";
        leadEdit.emailAddress = "htest" + new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()) + "@gmail.com";
        leadEdit.state = "htest state";
        leadEdit.website = "htester.com.vn";
        leadEdit.country = "Vietnam";
        leadEdit.phone = "0965898989";
        leadEdit.zipCode = "0001";
        leadEdit.leadValue = "12345";
        leadEdit.language = "Vietnamese";
        leadEdit.company = "NDJSC";
        leadEdit.description = "htest add new lead";
        leadEdit.lastContacted = "10-11-2025";
        leadEdit.flag = 1;
        leadEdit.flagEdit = 0;

        clickMenuLead();
        clickButtonNewLead();
        fillDataLead(leadEdit.status, leadEdit.source, leadEdit.assigned, leadEdit.tag, leadEdit.leadName, leadEdit.position, leadEdit.city,
                leadEdit.emailAddress, leadEdit.state, leadEdit.website, leadEdit.country, leadEdit.phone, leadEdit.zipCode, leadEdit.leadValue,
                leadEdit.language, leadEdit.company, leadEdit.description, leadEdit.lastContacted, leadEdit.flag, leadEdit.flagEdit);
        clickButtonSave();
        clickIconClosePopupLeadDetail(leadEdit.leadName);
        searchAndCheckLeads(leadEdit.leadName);
        clickButtonEdit(leadEdit.leadName);
        verifyNewLeadInEditPopup(leadEdit.leadName, leadEdit.status, leadEdit.source, leadEdit.assigned, leadEdit.tag, leadEdit.leadName,
                leadEdit.position, leadEdit.city, leadEdit.emailAddress, leadEdit.state, leadEdit.website, leadEdit.country, leadEdit.phone,
                leadEdit.zipCode, leadEdit.leadValue + ".00", leadEdit.language, leadEdit.company, leadEdit.description, leadEdit.lastContacted);

        leadEdit.leadName = "[htest]lead edit" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        leadEdit.source = "Google";
        leadEdit.assigned = "Example";
        leadEdit.tag += "edit" + new SimpleDateFormat("HHmmss").format(new Date());
        leadEdit.phone = "0965898980";
        leadEdit.zipCode += "1";
        leadEdit.leadValue += "6";
        leadEdit.description = "htest edit new lead";
        leadEdit.lastContacted = "24-11-2025";
        leadEdit.flag = 0;
        leadEdit.flagEdit = 1;

        fillDataLead(leadEdit.status, leadEdit.source, leadEdit.assigned, leadEdit.tag, leadEdit.leadName, leadEdit.position, leadEdit.city,
                leadEdit.emailAddress, leadEdit.state, leadEdit.website, leadEdit.country, leadEdit.phone, leadEdit.zipCode, leadEdit.leadValue,
                leadEdit.language, leadEdit.company, leadEdit.description, leadEdit.lastContacted, leadEdit.flag, leadEdit.flagEdit);
        clickButtonSave();
        clickIconClosePopupLeadDetail(leadEdit.leadName);
        searchAndCheckLeads(leadEdit.leadName);
    }

    @Test
    public void testDeleteNewLead() throws InterruptedException {
        TestCaseLead leadDelete = new TestCaseLead();
        leadDelete.leadName = "[htest]lead delete" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        leadDelete.status = "Customer";
        leadDelete.source = "Facebook";
        leadDelete.assigned = "Anh Tester";
        leadDelete.tag = "htest";
        leadDelete.position = "Tester";
        leadDelete.city = "Việt Nam";
        leadDelete.emailAddress = "htest" + new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()) + "@gmail.com";
        leadDelete.state = "htest state";
        leadDelete.website = "htester.com.vn";
        leadDelete.country = "Vietnam";
        leadDelete.phone = "0965898989";
        leadDelete.zipCode = "0001";
        leadDelete.leadValue = "12345";
        leadDelete.language = "Vietnamese";
        leadDelete.company = "NDJSC";
        leadDelete.description = "htest add new lead";
        leadDelete.lastContacted = "10-11-2025";
        leadDelete.flag = 1;
        leadDelete.flagEdit = 0;

        clickMenuLead();
        clickButtonNewLead();
        fillDataLead(leadDelete.status, leadDelete.source, leadDelete.assigned, leadDelete.tag, leadDelete.leadName, leadDelete.position, leadDelete.city,
                leadDelete.emailAddress, leadDelete.state, leadDelete.website, leadDelete.country, leadDelete.phone, leadDelete.zipCode, leadDelete.leadValue,
                leadDelete.language, leadDelete.company, leadDelete.description, leadDelete.lastContacted, leadDelete.flag, leadDelete.flagEdit);
        clickButtonSave();
        clickIconClosePopupLeadDetail(leadDelete.leadName);
        searchAndCheckLeads(leadDelete.leadName);
        clickButtonDelete(leadDelete.leadName);
        confirmAlertDelete();
        verifyAfterDeleteLead(leadDelete.leadName);
    }
}
