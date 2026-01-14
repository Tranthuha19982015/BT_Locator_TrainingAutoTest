package com.hatester.projects.testcases;

import com.hatester.common.BaseTest;
import com.hatester.projects.pages.DashboardPage;
import com.hatester.projects.pages.LeadPage;
import com.hatester.projects.pages.LoginPage;
import com.hatester.projects.pages.TaskPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private LeadPage leadPage;
    private TaskPage taskPage;

    @Test
    public void testLabelConvertedLeadOnDashboard() throws InterruptedException {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        dashboardPage.verifyDashboardPageDisplayed();

        String totalCustomerLeadOnDashboard = dashboardPage.getTotalConvertedLeads();

        leadPage = dashboardPage.clickMenuLead();

        leadPage.clickIconLeadsSummary();
        leadPage.verifyLeadSummaryDisplay();

        Assert.assertEquals(totalCustomerLeadOnDashboard, leadPage.getTotalStatusCustomer() + " / " + leadPage.getTotalStatusLead(),
                "The number of “Customer” statuses on the Dashboard does not match the number in the Lead menu");
    }

    @Test
    public void testLabelTasksNotFinishedOnDashboard() throws InterruptedException {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        dashboardPage.verifyDashboardPageDisplayed();

        String totalTasksNotFinishedOnDashboard = dashboardPage.getTotalTasksNotFinished();

        taskPage = dashboardPage.clickMenuTask();

        taskPage.verifyTaskPageDisplayed();

        Assert.assertEquals(totalTasksNotFinishedOnDashboard, taskPage.getTotalStatusesNotComplete() + " / " + taskPage.getTotalTaskStatuses(),
                "The number of Not Finished statuses on the Dashboard does not match the number in the Task menu");
    }
}
