package com.hatester.testcases;

import com.hatester.pages.DashboardPage;
import com.hatester.pages.LeadPage;
import com.hatester.pages.LoginPage;
import com.hatester.common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LeadTest extends BaseTest {
    String leadName = "[htest]lead add" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date()),
            status = "Customer",
            source = "Facebook",
            assigned = "Anh Tester",
            tag = "htest",
            position = "Tester",
            city = "Việt Nam",
            emailAddress = "htest" + new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()) + "@gmail.com",
            state = "htest state",
            website = "htester.com.vn",
            country = "Vietnam",
            phone = "0965898989",
            zipCode = "0001",
            leadValue = "12345",
            language = "Vietnamese",
            company = "NDJSC",
            description = "htest add new lead",
            lastContacted = "10-11-2025";
    int flag = 1, flagEdit = 0;

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private LeadPage leadPage;

    @Test
    public void testAddNewLead() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        leadPage = dashboardPage.clickMenuLead();

        leadPage.clickIconLeadsSummary();
        leadPage.verifyLeadSummaryDisplay();
        leadPage.clickButtonNewLead();
        leadPage.fillDataLead(status, source, assigned, tag, leadName, position, city, emailAddress,
                state, website, country, phone, zipCode, leadValue, language, company,
                description, lastContacted, flag, flagEdit);
        leadPage.clickButtonSave();
        leadPage.verifyAddLeadSuccessMessage();
        leadPage.clickIconClosePopupLeadDetail(leadName, 0);
        leadPage.searchAndCheckLeads(leadName);
        leadPage.clickButtonEdit(leadName);
        leadPage.verifyNewLeadInEditPopup(leadName, status, source, assigned, tag, leadName, position,
                city, emailAddress, state, website, country, phone, zipCode,
                leadValue + ".00", language, company, description, lastContacted);
    }

    @Test
    public void testEditNewLead() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        leadPage = dashboardPage.clickMenuLead();

        leadPage.clickIconLeadsSummary();
        leadPage.verifyLeadSummaryDisplay();
        leadPage.clickButtonNewLead();
        leadPage.fillDataLead(status, source, assigned, tag, leadName, position, city,
                emailAddress, state, website, country, phone, zipCode, leadValue,
                language, company, description, lastContacted, flag, flagEdit);
        leadPage.clickButtonSave();
        leadPage.verifyAddLeadSuccessMessage();
        leadPage.clickIconClosePopupLeadDetail(leadName, 0);
        leadPage.searchAndCheckLeads(leadName);
        leadPage.clickButtonEdit(leadName);
        leadPage.verifyNewLeadInEditPopup(leadName, status, source, assigned, tag, leadName,
                position, city, emailAddress, state, website, country, phone,
                zipCode, leadValue + ".00", language, company, description, lastContacted);

        LeadTest leadEdit = new LeadTest();
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

        leadPage.fillDataLead(status, leadEdit.source, leadEdit.assigned, leadEdit.tag, leadEdit.leadName, position, city,
                emailAddress, state, website, country, leadEdit.phone, leadEdit.zipCode, leadEdit.leadValue,
                language, company, leadEdit.description, leadEdit.lastContacted, leadEdit.flag, leadEdit.flagEdit);
        leadPage.clickButtonSave();
        leadPage.verifyUpdateLeadSuccessMessage();
        leadPage.clickIconClosePopupLeadDetail(leadEdit.leadName, 1);
        leadPage.searchAndCheckLeads(leadEdit.leadName);
    }

    @Test
    public void testDeleteNewLead() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        leadPage = dashboardPage.clickMenuLead();

        leadPage.clickIconLeadsSummary();
        leadPage.verifyLeadSummaryDisplay();
        leadPage.clickButtonNewLead();
        leadPage.fillDataLead(status, source, assigned, tag, leadName, position, city,
                emailAddress, state, website, country, phone, zipCode, leadValue,
                language, company, description, lastContacted, flag, flagEdit);
        leadPage.clickButtonSave();
        leadPage.clickIconClosePopupLeadDetail(leadName, 0);
        leadPage.searchAndCheckLeads(leadName);
        leadPage.clickButtonDelete(leadName);
        leadPage.confirmAlertDelete(1);
        leadPage.verifyDeleteLeadSuccessMessage(1);
        leadPage.verifyAfterDeleteLead(leadName, 1);
    }

    @Test
    public void testLeadCountByStatus() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        dashboardPage.verifyDashboardPageDisplayed();
        leadPage = dashboardPage.clickMenuLead();

        leadPage.clickIconLeadsSummary();
        leadPage.verifyLeadSummaryDisplay();

        int totalActiveBeforeAdd = Integer.parseInt(leadPage.getTotalStatusActive());
        int totalCustomerBeforeAdd = Integer.parseInt(leadPage.getTotalStatusCustomer());

        leadPage.clickButtonNewLead();
        leadPage.fillDataLead(status, source, assigned, tag, leadName, position, city, emailAddress,
                state, website, country, phone, zipCode, leadValue, language, company,
                description, lastContacted, flag, flagEdit);
        leadPage.clickButtonSave();
        leadPage.verifyAddLeadSuccessMessage();
        leadPage.clickIconClosePopupLeadDetail(leadName, 0);
        leadPage.searchAndCheckLeads(leadName);
        leadPage.clickIconLeadsSummary();
        leadPage.verifyLeadSummaryDisplay();

        int totalActiveAfterAdd = Integer.parseInt(leadPage.getTotalStatusActive());
        int totalCustomerAfterAdd = Integer.parseInt(leadPage.getTotalStatusCustomer());

        if (status.equals("Active")) {
            Assert.assertEquals(totalActiveAfterAdd, totalActiveBeforeAdd + 1,
                    "Số lượng status Active không khớp");
            Assert.assertEquals(totalCustomerAfterAdd, totalCustomerBeforeAdd,
                    "Số lượng status Customer không khớp");
        } else {
            Assert.assertEquals(totalActiveAfterAdd, totalActiveBeforeAdd,
                    "Số lượng status Active không khớp");
            Assert.assertEquals(totalCustomerAfterAdd, totalCustomerBeforeAdd + 1,
                    "Số lượng status Customer không khớp");
        }
    }
}
