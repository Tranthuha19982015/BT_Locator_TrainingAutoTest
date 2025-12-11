package com.hatester.pages;

import com.hatester.common.BasePage;
import com.hatester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
        new WebUI(driver);
    }

    private By buttonDashboardOptions = By.xpath("//div[normalize-space()='Dashboard Options']");
    private By labelTotalInvoicesAwaitingPayment = By.xpath("(//span[normalize-space()='Invoices Awaiting Payment']/parent::div)/following-sibling::span");
    private By labelTotalConvertedLeads = By.xpath("(//span[normalize-space()='Converted Leads']/parent::div)/following-sibling::span");
    private By labelTotalProjectsInProgress = By.xpath("(//span[normalize-space()='Projects In Progress']/parent::div)/following-sibling::span");
    private By labelTotalTasksNotFinished = By.xpath("(//span[normalize-space()='Tasks Not Finished']/parent::div)/following-sibling::span");

    public void verifyDashboardPageDisplayed() {
        Assert.assertTrue(WebUI.checkElementExist(buttonDashboardOptions), "Dashboard page is not displayed.");
    }

    public String getTotalInvoicesAwaitingPayment() {
        String totalInvoicesAwaiting = WebUI.getTextElement(labelTotalInvoicesAwaitingPayment);
        return totalInvoicesAwaiting;
    }

    public String getTotalConvertedLeads() {
        String totalConvertedLeads = WebUI.getTextElement(labelTotalConvertedLeads);
        return totalConvertedLeads;
    }

    public String getTotalProjectsInProgress() {
        String totalProjectsInProgress = WebUI.getTextElement(labelTotalProjectsInProgress);
        return totalProjectsInProgress;
    }

    public String getTotalTasksNotFinished() {
        String totalTasksNotFinished = WebUI.getTextElement(labelTotalTasksNotFinished);
        return totalTasksNotFinished;
    }
}
