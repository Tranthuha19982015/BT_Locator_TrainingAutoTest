package com.hatester.testcases;

import com.hatester.common.BaseTest;
import com.hatester.pages.CustomerPage;
import com.hatester.pages.DashboardPage;
import com.hatester.pages.LoginPage;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private CustomerPage customerPage;

    String company, vat, phone, website, group, currency, language, address, city, state, zip, country;

    @Test
    public void testDeleteManyCustomer() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        dashboardPage.verifyDashboardPageDisplayed();
        customerPage = dashboardPage.clickMenuCustomer();

        company = "Đồ Án Tốt Nghiệp";

        for (int i = 0; i < 100; i++) {
            customerPage.searchCustomers(company);
            customerPage.moveToCustomerName(company);
            customerPage.clickButtonDelete(company);
            customerPage.confirmDeleteAlert(company, 1);
        }
    }
}
