package com.hatester.projects.testcases;

import com.hatester.common.BaseTest;
import com.hatester.helpers.ExcelHelper;
import com.hatester.projects.pages.CustomerPage;
import com.hatester.projects.pages.DashboardPage;
import com.hatester.projects.pages.LoginPage;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private CustomerPage customerPage;

    String company, vat, phone, website, group, currency, language, address, city, state, zip, country;

    @Test
    public void testDeleteManyCustomer() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        dashboardPage.verifyDashboardPageDisplayed();
        customerPage = dashboardPage.clickMenuCustomer();

        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile("src/test/resources/datatest/dataCRM.xlsx", "Customers");
        company = excel.getCellData("CUSTOMER_NAME",1);

        for (int i = 0; i < 100; i++) {
            customerPage.searchCustomers(company);
            customerPage.moveToCustomerName(company);
            customerPage.clickButtonDelete(company);
            customerPage.confirmDeleteAlert(company, 1);
        }
    }
}
