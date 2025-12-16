package com.hatester.testcases;

import com.hatester.pages.DashboardPage;
import com.hatester.pages.LeadPage;
import com.hatester.pages.LoginPage;
import com.hatester.common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class LeadTest extends BaseTest {
    String leadName = "[htest]lead add" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date()),
            status = "Customer",
            source = "Facebook",
            assigned = "Anh Tester",
            tag = "htest",
            position = "Tester",
            city = "Việt Nam",
            emailAddress = "htest" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date()),
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

        LeadTest leadTest = new LeadTest();
        leadTest.leadName = leadName + new Random().nextInt(1000);
        leadTest.emailAddress = emailAddress + new Random().nextInt(1000) + "@gmail.com";
        leadPage.clickIconLeadsSummary();
        leadPage.verifyLeadSummaryDisplay();
        leadPage.clickButtonNewLead();
        leadPage.fillDataLead(status, source, assigned, tag, leadTest.leadName, position, city, leadTest.emailAddress,
                state, website, country, phone, zipCode, leadValue, language, company,
                description, lastContacted, flag, flagEdit);
        leadPage.clickButtonSave();
        leadPage.verifyAddLeadSuccessMessage();
        leadPage.clickIconClosePopupLeadDetail(leadTest.leadName, 0);
        leadPage.searchAndCheckLeads(leadTest.leadName);
        leadPage.clickButtonEdit(leadTest.leadName);
        leadPage.verifyNewLeadInEditPopup(leadTest.leadName, status, source, assigned, tag, leadTest.leadName, position,
                city, leadTest.emailAddress, state, website, country, phone, zipCode,
                leadValue + ".00", language, company, description, lastContacted);
    }

    @Test
    public void testEditNewLead() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        leadPage = dashboardPage.clickMenuLead();

        LeadTest leadTest = new LeadTest();
        leadTest.leadName = leadName + new Random().nextInt(1000);
        leadTest.emailAddress = emailAddress + new Random().nextInt(1000) + "@gmail.com";
        leadPage.clickIconLeadsSummary();
        leadPage.verifyLeadSummaryDisplay();
        leadPage.clickButtonNewLead();
        leadPage.fillDataLead(status, source, assigned, tag, leadTest.leadName, position, city, leadTest.emailAddress,
                state, website, country, phone, zipCode, leadValue, language, company,
                description, lastContacted, flag, flagEdit);
        leadPage.clickButtonSave();
        leadPage.verifyAddLeadSuccessMessage();
        leadPage.clickIconClosePopupLeadDetail(leadTest.leadName, 0);
        leadPage.searchAndCheckLeads(leadTest.leadName);
        leadPage.clickButtonEdit(leadTest.leadName);
        leadPage.verifyNewLeadInEditPopup(leadTest.leadName, status, source, assigned, tag, leadTest.leadName,
                position, city, leadTest.emailAddress, state, website, country, phone,
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
                leadTest.emailAddress, state, website, country, leadEdit.phone, leadEdit.zipCode, leadEdit.leadValue,
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

        LeadTest leadTest = new LeadTest();
        leadTest.leadName = leadName + new Random().nextInt(1000);
        leadTest.emailAddress = emailAddress + new Random().nextInt(1000) + "@gmail.com";
        leadPage.clickIconLeadsSummary();
        leadPage.verifyLeadSummaryDisplay();
        leadPage.clickButtonNewLead();
        leadPage.fillDataLead(status, source, assigned, tag, leadTest.leadName, position, city,
                leadTest.emailAddress, state, website, country, phone, zipCode, leadValue,
                language, company, description, lastContacted, flag, flagEdit);
        leadPage.clickButtonSave();
        leadPage.clickIconClosePopupLeadDetail(leadTest.leadName, 0);
        leadPage.searchAndCheckLeads(leadTest.leadName);
        leadPage.clickButtonDelete(leadTest.leadName);
        leadPage.confirmAlertDelete(1);
        leadPage.verifyDeleteLeadSuccessMessage(1);
        leadPage.verifyAfterDeleteLead(leadTest.leadName, 1);
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

        LeadTest leadTest = new LeadTest();
        leadTest.leadName = leadName + new Random().nextInt(1000);
        leadTest.emailAddress = emailAddress + new Random().nextInt(1000) + "@gmail.com";
        leadPage.clickButtonNewLead();
        leadPage.fillDataLead(status, source, assigned, tag, leadTest.leadName, position, city, leadTest.emailAddress,
                state, website, country, phone, zipCode, leadValue, language, company,
                description, lastContacted, flag, flagEdit);
        leadPage.clickButtonSave();
        leadPage.verifyAddLeadSuccessMessage();
        leadPage.clickIconClosePopupLeadDetail(leadTest.leadName, 0);
        leadPage.searchAndCheckLeads(leadTest.leadName);
        leadPage.clickIconLeadsSummary();
        leadPage.verifyLeadSummaryDisplay();

        int totalActiveAfterAdd = Integer.parseInt(leadPage.getTotalStatusActive());
        int totalCustomerAfterAdd = Integer.parseInt(leadPage.getTotalStatusCustomer());

        leadPage.verifyQuantityStatusAfterAdd(status, totalActiveAfterAdd, totalActiveBeforeAdd,
                totalCustomerAfterAdd, totalCustomerBeforeAdd);
    }
}
