package com.hatester.testcases;

import com.hatester.pages.DashboardPage;
import com.hatester.pages.LeadPage;
import com.hatester.pages.LoginPage;
import com.hatester.common.BaseTest;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LeadTest extends BaseTest {
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

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private LeadPage leadPage;

    @Test
    public void testAddNewLead() throws InterruptedException {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        leadPage = dashboardPage.clickMenuLead();

        LeadTest leadAdd = new LeadTest();
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

        leadPage.clickIconLeadsSummary();
        leadPage.verifyLeadSummaryDisplay();
        leadPage.clickButtonNewLead();
        leadPage.fillDataLead(leadAdd.status, leadAdd.source, leadAdd.assigned, leadAdd.tag, leadAdd.leadName, leadAdd.position, leadAdd.city, leadAdd.emailAddress,
                leadAdd.state, leadAdd.website, leadAdd.country, leadAdd.phone, leadAdd.zipCode, leadAdd.leadValue, leadAdd.language, leadAdd.company,
                leadAdd.description, leadAdd.lastContacted, leadAdd.flag, leadAdd.flagEdit);
        leadPage.clickButtonSave();
        leadPage.verifyAddLeadSuccessMessage();
        leadPage.clickIconClosePopupLeadDetail(leadAdd.leadName, 0);
        leadPage.searchAndCheckLeads(leadAdd.leadName);
        leadPage.clickButtonEdit(leadAdd.leadName);
        leadPage.verifyNewLeadInEditPopup(leadAdd.leadName, leadAdd.status, leadAdd.source, leadAdd.assigned, leadAdd.tag, leadAdd.leadName, leadAdd.position,
                leadAdd.city, leadAdd.emailAddress, leadAdd.state, leadAdd.website, leadAdd.country, leadAdd.phone, leadAdd.zipCode,
                leadAdd.leadValue + ".00", leadAdd.language, leadAdd.company, leadAdd.description, leadAdd.lastContacted);
    }

    @Test
    public void testEditNewLead() throws InterruptedException {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        leadPage = dashboardPage.clickMenuLead();

        LeadTest leadEdit = new LeadTest();
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

        leadPage.clickIconLeadsSummary();
        leadPage.verifyLeadSummaryDisplay();
        leadPage.clickButtonNewLead();
        leadPage.fillDataLead(leadEdit.status, leadEdit.source, leadEdit.assigned, leadEdit.tag, leadEdit.leadName, leadEdit.position, leadEdit.city,
                leadEdit.emailAddress, leadEdit.state, leadEdit.website, leadEdit.country, leadEdit.phone, leadEdit.zipCode, leadEdit.leadValue,
                leadEdit.language, leadEdit.company, leadEdit.description, leadEdit.lastContacted, leadEdit.flag, leadEdit.flagEdit);
        leadPage.clickButtonSave();
        leadPage.verifyAddLeadSuccessMessage();
        leadPage.clickIconClosePopupLeadDetail(leadEdit.leadName, 1);
        leadPage.searchAndCheckLeads(leadEdit.leadName);
        leadPage.clickButtonEdit(leadEdit.leadName);
        leadPage.verifyNewLeadInEditPopup(leadEdit.leadName, leadEdit.status, leadEdit.source, leadEdit.assigned, leadEdit.tag, leadEdit.leadName,
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

        leadPage.fillDataLead(leadEdit.status, leadEdit.source, leadEdit.assigned, leadEdit.tag, leadEdit.leadName, leadEdit.position, leadEdit.city,
                leadEdit.emailAddress, leadEdit.state, leadEdit.website, leadEdit.country, leadEdit.phone, leadEdit.zipCode, leadEdit.leadValue,
                leadEdit.language, leadEdit.company, leadEdit.description, leadEdit.lastContacted, leadEdit.flag, leadEdit.flagEdit);
        leadPage.clickButtonSave();
        leadPage.verifyUpdateLeadSuccessMessage();
        leadPage.clickIconClosePopupLeadDetail(leadEdit.leadName, 1);
        leadPage.searchAndCheckLeads(leadEdit.leadName);
    }

    @Test
    public void testDeleteNewLead() throws InterruptedException {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        leadPage = dashboardPage.clickMenuLead();

        LeadTest leadDelete = new LeadTest();
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

        leadPage.clickIconLeadsSummary();
        leadPage.verifyLeadSummaryDisplay();
        leadPage.clickButtonNewLead();
        leadPage.fillDataLead(leadDelete.status, leadDelete.source, leadDelete.assigned, leadDelete.tag, leadDelete.leadName, leadDelete.position, leadDelete.city,
                leadDelete.emailAddress, leadDelete.state, leadDelete.website, leadDelete.country, leadDelete.phone, leadDelete.zipCode, leadDelete.leadValue,
                leadDelete.language, leadDelete.company, leadDelete.description, leadDelete.lastContacted, leadDelete.flag, leadDelete.flagEdit);
        leadPage.clickButtonSave();
        leadPage.clickIconClosePopupLeadDetail(leadDelete.leadName, 0);
        leadPage.searchAndCheckLeads(leadDelete.leadName);
        leadPage.clickButtonDelete(leadDelete.leadName);
        leadPage.confirmAlertDelete(1);
        leadPage.verifyDeleteLeadSuccessMessage(1);
        leadPage.verifyAfterDeleteLead(leadDelete.leadName, 1);
    }
}
