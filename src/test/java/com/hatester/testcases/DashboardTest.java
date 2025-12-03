package com.hatester.testcases;

import com.hatester.common.BaseTest;
import com.hatester.pages.DashboardPage;
import com.hatester.pages.LeadPage;
import com.hatester.pages.LoginPage;
import com.hatester.pages.TaskPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private LeadPage leadPage;
    private TaskPage taskPage;

    @Test
    public void testTotalStatusCustomerLeadsOnDashboard() throws InterruptedException {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        leadPage = dashboardPage.clickMenuLead();

        leadPage.clickIconLeadsSummary();
        leadPage.verifyLeadSummaryDisplay();
        String totalStatusCustomerLead = leadPage.getTotalStatusCustomer();
        String totalStatusLead = leadPage.getTotalStatusLead();

        dashboardPage = leadPage.clickMenuDashboard();
        String totalStatusCustomerOnDashboard = dashboardPage.getTotalConvertedLeads();

        Assert.assertEquals(totalStatusCustomerOnDashboard, totalStatusCustomerLead + " / " + totalStatusLead,
                "Không khớp số lượng status Customer trên Dashboard và số lượng trong menu Lead.");
    }
}
