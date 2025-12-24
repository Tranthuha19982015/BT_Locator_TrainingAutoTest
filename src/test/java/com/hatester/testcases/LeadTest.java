package com.hatester.testcases;

import com.hatester.helpers.ExcelHelper;
import com.hatester.models.LeadData;
import com.hatester.pages.DashboardPage;
import com.hatester.pages.LeadPage;
import com.hatester.pages.LoginPage;
import com.hatester.common.BaseTest;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LeadTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private LeadPage leadPage;

    LeadData getLeadDataFromExcel(int rowIndex) {

        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile("src/test/resources/datatest/dataCRM.xlsx", "Leads");

        LeadData lead = new LeadData();
        lead.setLeadName(excel.getCellData("LEAD_NAME", rowIndex));
        lead.setStatus(excel.getCellData("STATUS", rowIndex));
        lead.setSource(excel.getCellData("SOURCE", rowIndex));
        lead.setAssigned(excel.getCellData("ASSIGNED", rowIndex));
        lead.setTag(excel.getCellData("TAG", rowIndex));
        lead.setPosition(excel.getCellData("POSITION", rowIndex));
        lead.setCity(excel.getCellData("CITY", rowIndex));
        lead.setEmailAddress(excel.getCellData("EMAIL_ADDRESS", rowIndex));
        lead.setState(excel.getCellData("STATE", rowIndex));
        lead.setWebsite(excel.getCellData("WEBSITE", rowIndex));
        lead.setCountry(excel.getCellData("COUNTRY", rowIndex));
        lead.setPhone(excel.getCellData("PHONE", rowIndex));
        lead.setZipCode(excel.getCellData("ZIP_CODE", rowIndex));
        lead.setLeadValue(excel.getCellData("LEAD_VALUE", rowIndex));
        lead.setLanguage(excel.getCellData("LANGUAGE", rowIndex));
        lead.setCompany(excel.getCellData("COMPANY", rowIndex));
        lead.setDescription(excel.getCellData("DESCRIPTION", rowIndex));
        lead.setLastContacted(excel.getCellData("LAST_CONTACTED", rowIndex));
        lead.setCheckedCheckbox(Integer.parseInt(excel.getCellData("CHECKED", rowIndex)));
        lead.setFlagEdit(Integer.parseInt(excel.getCellData("FLAG_EDIT", rowIndex)));

        return lead;
    }

    @Test
    public void testAddNewLead() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        leadPage = dashboardPage.clickMenuLead();

        LeadData leadData = getLeadDataFromExcel(1);
        String dateTimeAdd = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        leadData.setLeadName(leadData.getLeadName() + dateTimeAdd);
        leadData.setEmailAddress(leadData.getEmailAddress() + dateTimeAdd + "@gmail.com");

        leadPage.clickIconLeadsSummary();
        leadPage.verifyLeadSummaryDisplay();
        leadPage.clickButtonNewLead();
        leadPage.fillDataLead(leadData);
        leadPage.clickButtonSave();
        leadPage.verifyAddLeadSuccessMessage();
        leadPage.clickIconClosePopupLeadDetail(leadData.getLeadName());
        leadPage.searchLead(leadData.getLeadName());
        leadPage.checkLeadsExists(leadData.getLeadName());
        leadPage.clickButtonEdit(leadData.getLeadName());
        leadPage.verifyNewLeadInEditPopup(leadData);
    }

    @Test
    public void testEditNewLead() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        leadPage = dashboardPage.clickMenuLead();

        LeadData leadData = getLeadDataFromExcel(1);
        String dateTimeAdd = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        leadData.setLeadName(leadData.getLeadName() + dateTimeAdd);
        leadData.setEmailAddress(leadData.getEmailAddress() + dateTimeAdd + "@gmail.com");

        leadPage.clickIconLeadsSummary();
        leadPage.verifyLeadSummaryDisplay();
        leadPage.clickButtonNewLead();
        leadPage.fillDataLead(leadData);
        leadPage.clickButtonSave();
        leadPage.verifyAddLeadSuccessMessage();
        leadPage.clickIconClosePopupLeadDetail(leadData.getLeadName());
        leadPage.searchLead(leadData.getLeadName());
        leadPage.checkLeadsExists(leadData.getLeadName());
        leadPage.clickButtonEdit(leadData.getLeadName());
        leadPage.verifyNewLeadInEditPopup(leadData);

        LeadData leadDataEdit = getLeadDataFromExcel(2);
        String dateTimeEdit = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());

        leadDataEdit.setLeadName(leadDataEdit.getLeadName() + dateTimeEdit);
        leadDataEdit.setTag(leadDataEdit.getTag() + dateTimeEdit);
        leadDataEdit.setEmailAddress(leadDataEdit.getEmailAddress() + dateTimeEdit + "@gmail.com");

        leadPage.fillDataLead(leadDataEdit);
        leadPage.clickButtonSave();
        leadPage.verifyUpdateLeadSuccessMessage();
        leadPage.clickIconClosePopupLeadDetail(leadDataEdit.getLeadName());
        leadPage.searchLead(leadDataEdit.getLeadName());
        leadPage.checkLeadsExists(leadDataEdit.getLeadName());
    }

    @Test
    public void testDeleteNewLead() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        leadPage = dashboardPage.clickMenuLead();

        LeadData leadData = getLeadDataFromExcel(1);
        String dateTimeAdd = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        leadData.setLeadName(leadData.getLeadName() + dateTimeAdd);
        leadData.setEmailAddress(leadData.getEmailAddress() + dateTimeAdd + "@gmail.com");

        leadPage.clickIconLeadsSummary();
        leadPage.verifyLeadSummaryDisplay();
        leadPage.clickButtonNewLead();
        leadPage.fillDataLead(leadData);
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

    @Test
    public void testLeadCountByStatus() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        dashboardPage.verifyDashboardPageDisplayed();
        leadPage = dashboardPage.clickMenuLead();

        leadPage.clickIconLeadsSummary();
        leadPage.verifyLeadSummaryDisplay();

        int totalActiveBeforeAdd = Integer.parseInt(leadPage.getTotalStatusActive());
        int totalCustomerBeforeAdd = Integer.parseInt(leadPage.getTotalStatusCustomer());

        LeadData leadData = getLeadDataFromExcel(1);
        String dateTimeAdd = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        leadData.setLeadName(leadData.getLeadName() + dateTimeAdd);
        leadData.setEmailAddress(leadData.getEmailAddress() + dateTimeAdd + "@gmail.com");

        leadPage.clickButtonNewLead();
        leadPage.fillDataLead(leadData);
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
