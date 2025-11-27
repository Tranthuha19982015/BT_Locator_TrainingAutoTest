package com.hatester.thuc_hanh;

import com.hatester.bt_locators.LocatorLeadPage;
import com.hatester.keywords.WebUI;
import common.BaseTest;
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
        WebUI.clickElement(driver, LocatorLeadPage.menuLead);
        WebUI.clickElement(driver, LocatorLeadPage.iconLeadsSummary);
        Thread.sleep(2000);

        Assert.assertTrue(WebUI.checkExistsElement(driver, LocatorLeadPage.headerLeadsSummary), "Chưa chuyển hướng tới menu Lead");
    }

    public void clickButtonNewLead() throws InterruptedException {
        WebUI.clickElement(driver, LocatorLeadPage.buttonNewLead);
        Thread.sleep(1000);

        Assert.assertTrue(WebUI.checkExistsElement(driver, LocatorLeadPage.headerAddNewLead), "Mở popup Add New Lead không thành công");
    }

    public void fillDataLead(String status, String source, String assigned, String tag, String name, String position,
                             String city, String emailAddress, String state, String website, String country, String phone,
                             String zipCode, String leadValue, String language, String company, String description,
                             String dateContacted, int flag, int flagEdit) throws InterruptedException {
        //status
        WebUI.clickElement(driver, LocatorLeadPage.dropdownStatus);
        WebUI.setTextElement(driver, LocatorLeadPage.inputSearchStatus, status);
        WebUI.clickElement(driver, LocatorLeadPage.getValueStatus(status));

        //source
        WebUI.clickElement(driver, LocatorLeadPage.dropdownSource);
        WebUI.setTextElement(driver, LocatorLeadPage.inputSearchSource, source);
        WebUI.clickElement(driver, LocatorLeadPage.getValueSource(source));

        //assigned
        WebUI.clickElement(driver, LocatorLeadPage.dropdownAssigned);
        WebUI.setTextElement(driver, LocatorLeadPage.inputSearchAssigned, assigned);
        WebUI.clickElement(driver, LocatorLeadPage.getValueAssigned(assigned));

        //input
        if (flagEdit == 1) {
            WebUI.clickElement(driver, LocatorLeadPage.iconCloseTag);
            WebUI.clearTextElement(driver, LocatorLeadPage.inputName);
//            WebUI.clearElementText(driver,LocatorLeadPage.inputAddress);
            WebUI.clearTextElement(driver, LocatorLeadPage.inputPosition);
            WebUI.clearTextElement(driver, LocatorLeadPage.inputCity);
            WebUI.clearTextElement(driver, LocatorLeadPage.inputEmailAddress);
            WebUI.clearTextElement(driver, LocatorLeadPage.inputState);
            WebUI.clearTextElement(driver, LocatorLeadPage.inputWebsite);
            WebUI.clearTextElement(driver, LocatorLeadPage.inputPhone);
            WebUI.clearTextElement(driver, LocatorLeadPage.inputZipcode);
            WebUI.clearTextElement(driver, LocatorLeadPage.inputLeadValue);
            WebUI.clearTextElement(driver, LocatorLeadPage.inputCompany);
            WebUI.clearTextElement(driver, LocatorLeadPage.inputDescription);
            WebUI.clearTextElement(driver, LocatorLeadPage.inputLastContact);

            WebUI.clickElement(driver, LocatorLeadPage.labelPhone);
            WebUI.clickElement(driver, LocatorLeadPage.labelPhone);

            WebUI.scrollAtBottom(driver, LocatorLeadPage.dropdownStatus);

            WebUI.clickElement(driver, LocatorLeadPage.inputTags);
        }

        WebUI.setTextAndKeyElement(driver, LocatorLeadPage.inputTags, tag, Keys.ENTER);
        WebUI.clickElement(driver, LocatorLeadPage.labelTags);
        WebUI.clickElement(driver, LocatorLeadPage.labelTags);

        WebUI.setTextElement(driver, LocatorLeadPage.inputName, name);
//        WebUI.setTextElement(driver, LocatorLeadPage.inputAddress, "");

        WebUI.setTextElement(driver, LocatorLeadPage.inputPosition, position);
        WebUI.setTextElement(driver, LocatorLeadPage.inputCity, city);
        WebUI.setTextElement(driver, LocatorLeadPage.inputEmailAddress, emailAddress);
        WebUI.setTextElement(driver, LocatorLeadPage.inputState, state);
        WebUI.setTextElement(driver, LocatorLeadPage.inputWebsite, website);

        //country
        WebUI.clickElement(driver, LocatorLeadPage.dropdownCountry);
        WebUI.setTextElement(driver, LocatorLeadPage.inputSearchCountry, country);
        WebUI.clickElement(driver, LocatorLeadPage.getValueCountry(country));

        //input
        WebUI.setTextElement(driver, LocatorLeadPage.inputPhone, phone);
        WebUI.setTextElement(driver, LocatorLeadPage.inputZipcode, zipCode);
        WebUI.setTextElement(driver, LocatorLeadPage.inputLeadValue, leadValue);

        //Default Language
        WebUI.clickElement(driver, LocatorLeadPage.dropdownDefaultLanguage);
        WebUI.setTextElement(driver, LocatorLeadPage.inputSearchDefaultLanguage, language);
        WebUI.clickElement(driver, LocatorLeadPage.getValueDefaultLanguage(language));

        //input
        WebUI.setTextElement(driver, LocatorLeadPage.inputCompany, company);
        WebUI.setTextElement(driver, LocatorLeadPage.inputDescription, description);

        //checkbox
        WebUI.clickElement(driver, LocatorLeadPage.labelCheckboxPublic);

        if (flagEdit == 0) {
            WebUI.clickElement(driver, LocatorLeadPage.labelCheckboxContactedToday);
            WebUI.setTextElement(driver, LocatorLeadPage.inputDateContacted, dateContacted);
        } else {
            WebUI.clearTextElement(driver, LocatorLeadPage.inputLastContact);
            WebUI.setTextElement(driver, LocatorLeadPage.inputLastContact, dateContacted);
        }
    }

    public void clickButtonSave() throws InterruptedException {
        WebUI.clickElement(driver, LocatorLeadPage.buttonSave);
        Thread.sleep(2000);
    }

    public void clickIconClosePopupLeadDetail(String name) throws InterruptedException {
        WebUI.scrollAtTop(driver, LocatorLeadPage.iconClosePopupLeadDetail(name));
//        Thread.sleep(1000);
        WebUI.clickElement(driver, LocatorLeadPage.iconClosePopupLeadDetail(name));
        Thread.sleep(1000);
    }

    public void searchAndCheckLeads(String name) throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(1000);
        WebUI.setTextElement(driver, LocatorLeadPage.inputSearchLeads, name);

        Assert.assertTrue(WebUI.checkExistsElement(driver, LocatorLeadPage.getFirstRowItemLeadName(name)), "Không đúng giá trị Lead vừa thêm mới");
        Thread.sleep(1000);
    }

    public void clickButtonEdit(String leadName) throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(WebUI.getWebElement(driver, LocatorLeadPage.getFirstRowItemLeadName(leadName))).perform();
        WebUI.clickElement(driver, LocatorLeadPage.buttonEdit(leadName));
    }

    public void verifyNewLeadInEditPopup(String leadName, String status, String source, String assigned, String tag, String name,
                                         String position, String city, String emailAddress, String state, String website, String country,
                                         String phone, String zipCode, String leadValue, String language, String company, String description,
                                         String dateContacted) throws InterruptedException {
        Thread.sleep(1000);
        boolean containsStatus = WebUI.getElementText(driver, LocatorLeadPage.dropdownStatus).contains(status);
        Assert.assertTrue(containsStatus, "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementText(driver, LocatorLeadPage.dropdownSource), source,
                "Không đúng giá trị đã thêm mới");
        boolean containsAssigned = WebUI.getElementText(driver, LocatorLeadPage.dropdownAssigned).contains(assigned);
        Assert.assertTrue(containsAssigned, "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementText(driver, LocatorLeadPage.inputTagsEdit).toLowerCase(), tag,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementAttribute(driver, LocatorLeadPage.inputName, "value"), name,
                "Không đúng giá trị đã thêm mới");
//        Assert.assertEquals(WebUI.getElementAttribute(driver,LocatorLeadPage.inputAddress,"value"), address,
//        "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementAttribute(driver, LocatorLeadPage.inputPosition, "value"), position,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementAttribute(driver, LocatorLeadPage.inputCity, "value"), city,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementAttribute(driver, LocatorLeadPage.inputEmailAddress, "value"), emailAddress,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementAttribute(driver, LocatorLeadPage.inputState, "value"), state,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementAttribute(driver, LocatorLeadPage.inputWebsite, "value"), website,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementText(driver, LocatorLeadPage.dropdownCountry), country,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementAttribute(driver, LocatorLeadPage.inputPhone, "value"), phone,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementAttribute(driver, LocatorLeadPage.inputZipcode, "value"), zipCode,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementAttribute(driver, LocatorLeadPage.inputLeadValue, "value"), leadValue,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementText(driver, LocatorLeadPage.dropdownDefaultLanguage), language,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementAttribute(driver, LocatorLeadPage.inputCompany, "value"), company,
                "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementAttribute(driver, LocatorLeadPage.inputDescription, "value"), description,
                "Không đúng giá trị đã thêm mới");
        boolean containsLastContact = WebUI.getElementAttribute(driver, LocatorLeadPage.inputLastContact, "value").contains(dateContacted);
        Assert.assertTrue(containsLastContact, "Không đúng giá trị đã thêm mới");
        Assert.assertFalse(WebUI.checkExistsElement(driver, LocatorLeadPage.checkboxContactedToday), "Không ẩn checkbox trên màn hình Edit");
        Assert.assertTrue(WebUI.checkSeletedElement(driver, LocatorLeadPage.checkboxPublic), "Không tích chọn checkbox");
        Thread.sleep(1000);
    }

    public void clickButtonDelete(String leadName) {
        Actions action = new Actions(driver);
        action.moveToElement(WebUI.getWebElement(driver, LocatorLeadPage.getFirstRowItemLeadName(leadName))).perform();
        WebUI.clickElement(driver, LocatorLeadPage.buttonDelete(leadName));
    }

    public void confirmAlertDelete() throws InterruptedException {
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
    }

    public void verifyAfterDeleteLead(String name) throws InterruptedException {
        Thread.sleep(1000);
        WebUI.setTextElement(driver, LocatorLeadPage.inputSearchLeads, name);
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
