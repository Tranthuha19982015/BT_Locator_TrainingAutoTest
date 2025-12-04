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
    public void testLabelConvertedLeadOnDashboard() throws InterruptedException {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        dashboardPage.verifyDashboardPageDisplayed();
        leadPage = dashboardPage.clickMenuLead();

        leadPage.clickIconLeadsSummary();
        leadPage.verifyLeadSummaryDisplay();
        String totalStatusesCustomerLead = leadPage.getTotalStatusCustomer();
        String totalLeadStatuses = leadPage.getTotalStatusLead();

        dashboardPage = leadPage.clickMenuDashboard();
        dashboardPage.verifyDashboardPageDisplayed();
        String totalCustomerLeadOnDashboard = dashboardPage.getTotalConvertedLeads();

        Assert.assertEquals(totalCustomerLeadOnDashboard, totalStatusesCustomerLead + " / " + totalLeadStatuses,
                "The number of “Customer” statuses on the Dashboard does not match the number in the Lead menu");
    }

    @Test
    public void testLabelTasksNotFinishedOnDashboard() throws InterruptedException {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        dashboardPage.verifyDashboardPageDisplayed();
        taskPage = dashboardPage.clickMenuTask();

        taskPage.verifyMenuTaskDisplay();
        String totalStatusesNotComplete = taskPage.getTotalStatusesNotComplete();
        String totalTaskStatuses = taskPage.getTotalTaskStatuses();

        dashboardPage = taskPage.clickMenuDashboard();
        dashboardPage.verifyDashboardPageDisplayed();
        String totalTasksNotFinishedOnDashboard = dashboardPage.getTotalTasksNotFinished();

        Assert.assertEquals(totalTasksNotFinishedOnDashboard, totalStatusesNotComplete + " / " + totalTaskStatuses,
                "The number of Not Finished statuses on the Dashboard does not match the number in the Task menu");
    }
}
