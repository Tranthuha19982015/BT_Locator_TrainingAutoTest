package com.hatester.testcases;

import com.hatester.dataprovider.DataProviderFactory;
import com.hatester.helpers.ExcelHelper;
import com.hatester.models.LeadData;
import com.hatester.pages.DashboardPage;
import com.hatester.pages.LeadPage;
import com.hatester.pages.LoginPage;
import com.hatester.common.BaseTest;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LeadTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private LeadPage leadPage;

    @Test(dataProvider = "leadData", dataProviderClass = DataProviderFactory.class)
    public void testAddNewLead(LeadData leadData) {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        leadPage = dashboardPage.clickMenuLead();

        String dateTimeAdd = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        leadData.setLeadName(leadData.getLeadName() + dateTimeAdd);
        leadData.setEmailAddress(leadData.getEmailAddress() + dateTimeAdd + "@gmail.com");
        boolean isEdit = leadData.getTestType().equals("EDIT");

        leadPage.clickIconLeadsSummary();
        leadPage.verifyLeadSummaryDisplay();
        leadPage.clickButtonNewLead();
        leadPage.fillDataLead(leadData, isEdit);
        leadPage.clickButtonSave();
        leadPage.verifyAddLeadSuccessMessage();
        leadPage.clickIconClosePopupLeadDetail(leadData.getLeadName());
        leadPage.searchLead(leadData.getLeadName());
        leadPage.checkLeadsExists(leadData.getLeadName());
        leadPage.clickButtonEdit(leadData.getLeadName());
        leadPage.verifyNewLeadInEditPopup(leadData);

    }

    @Test(dataProvider = "editLeadData", dataProviderClass = DataProviderFactory.class)
    public void testEditNewLead(LeadData leadDataAdd, LeadData leadDataEdit) {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        leadPage = dashboardPage.clickMenuLead();

        String dateTimeAdd = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        leadDataAdd.setLeadName(leadDataAdd.getLeadName() + dateTimeAdd);
        leadDataAdd.setEmailAddress(leadDataAdd.getEmailAddress() + dateTimeAdd + "@gmail.com");
        boolean isEdit = leadDataAdd.getTestType().equals("EDIT");

        leadPage.clickIconLeadsSummary();
        leadPage.verifyLeadSummaryDisplay();
        leadPage.clickButtonNewLead();
        leadPage.fillDataLead(leadDataAdd, isEdit);
        leadPage.clickButtonSave();
        leadPage.verifyAddLeadSuccessMessage();
        leadPage.clickIconClosePopupLeadDetail(leadDataAdd.getLeadName());
        leadPage.searchLead(leadDataAdd.getLeadName());
        leadPage.checkLeadsExists(leadDataAdd.getLeadName());
        leadPage.clickButtonEdit(leadDataAdd.getLeadName());
        leadPage.verifyNewLeadInEditPopup(leadDataAdd);

        String dateTimeEdit = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        leadDataEdit.setLeadName(leadDataEdit.getLeadName() + dateTimeEdit);
        leadDataEdit.setTag(leadDataEdit.getTag() + dateTimeEdit);
        leadDataEdit.setEmailAddress(leadDataEdit.getEmailAddress() + dateTimeEdit + "@gmail.com");
        isEdit = leadDataAdd.getTestType().equals("ADD");

        leadPage.fillDataLead(leadDataEdit, isEdit);
        leadPage.clickButtonSave();
        leadPage.verifyUpdateLeadSuccessMessage();
        leadPage.clickIconClosePopupLeadDetail(leadDataEdit.getLeadName());
        leadPage.searchLead(leadDataEdit.getLeadName());
        leadPage.checkLeadsExists(leadDataEdit.getLeadName());
    }

    @Test(dataProvider = "leadData", dataProviderClass = DataProviderFactory.class)
    public void testDeleteNewLead(LeadData leadData) {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        leadPage = dashboardPage.clickMenuLead();

        String dateTimeAdd = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        leadData.setLeadName(leadData.getLeadName() + dateTimeAdd);
        leadData.setEmailAddress(leadData.getEmailAddress() + dateTimeAdd + "@gmail.com");
        boolean isEdit = leadData.getTestType().equals("EDIT");

        leadPage.clickIconLeadsSummary();
        leadPage.verifyLeadSummaryDisplay();
        leadPage.clickButtonNewLead();
        leadPage.fillDataLead(leadData, isEdit);
        leadPage.clickButtonSave();
        leadPage.verifyAddLeadSuccessMessage();
        leadPage.clickIconClosePopupLeadDetail(leadData.getLeadName());
        leadPage.searchLead(leadData.getLeadName());
        leadPage.checkLeadsExists(leadData.getLeadName());

        leadPage.clickButtonDelete(leadData.getLeadName());
        leadPage.confirmAlertDelete(leadData.getTypeConfirm());
        leadPage.verifyDeleteLeadSuccessMessage(leadData.getTypeConfirm());
        leadPage.searchLead(leadData.getLeadName());
        leadPage.verifyAfterDeleteLead(leadData.getLeadName(), leadData.getTypeConfirm());
    }

    @Test(dataProvider = "leadData", dataProviderClass = DataProviderFactory.class)
    public void testLeadCountByStatus(LeadData leadData) {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        dashboardPage.verifyDashboardPageDisplayed();
        leadPage = dashboardPage.clickMenuLead();

        leadPage.clickIconLeadsSummary();
        leadPage.verifyLeadSummaryDisplay();

        int totalActiveBeforeAdd = Integer.parseInt(leadPage.getTotalStatusActive());
        int totalCustomerBeforeAdd = Integer.parseInt(leadPage.getTotalStatusCustomer());

        String dateTimeAdd = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        leadData.setLeadName(leadData.getLeadName() + dateTimeAdd);
        leadData.setEmailAddress(leadData.getEmailAddress() + dateTimeAdd + "@gmail.com");
        boolean isEdit = leadData.getTestType().equals("EDIT");

        leadPage.clickButtonNewLead();
        leadPage.fillDataLead(leadData, isEdit);
        leadPage.clickButtonSave();
        leadPage.verifyAddLeadSuccessMessage();
        leadPage.clickIconClosePopupLeadDetail(leadData.getLeadName());
        leadPage.searchLead(leadData.getLeadName());
        leadPage.checkLeadsExists(leadData.getLeadName());
        leadPage.clickIconLeadsSummary();
        leadPage.verifyLeadSummaryDisplay();

        int totalActiveAfterAdd = Integer.parseInt(leadPage.getTotalStatusActive());
        int totalCustomerAfterAdd = Integer.parseInt(leadPage.getTotalStatusCustomer());

        leadPage.verifyQuantityStatusAfterAdd(leadData.getStatus(), totalActiveAfterAdd, totalActiveBeforeAdd,
                totalCustomerAfterAdd, totalCustomerBeforeAdd);
    }
}
