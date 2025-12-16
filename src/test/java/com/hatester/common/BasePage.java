package com.hatester.common;

import com.hatester.keywords.WebUI;
import com.hatester.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver);
    }

    //menu
    public By menuDashboard = By.xpath("//ul[@id='side-menu']//span[normalize-space()='Dashboard' and @class='menu-text']");
    public By menuCustomers = By.xpath("//ul[@id='side-menu']//span[normalize-space()='Customers' and @class='menu-text']");
    public By menuProjects = By.xpath("//ul[@id='side-menu']//span[normalize-space()='Projects' and @class='menu-text']");
    public By menuLead = By.xpath("//ul[@id='side-menu']//span[normalize-space()='Leads' and @class='menu-text']");
    public By menuTasks = By.xpath("//ul[@id='side-menu']//span[normalize-space()='Tasks' and @class='menu-text']");

    //header
    public By iconProfile = By.xpath("//div[@id='header']/descendant::li[contains(@class,'header-user-profile')]");
    public By linkMyProfile = By.xpath("//div[@id='header']/descendant::a[text()='My Profile']");
    public By linkEditProfile = By.xpath("//div[@id='header']/descendant::a[text()='Edit Profile']");
    public By linkLogout = By.xpath("//div[@id='header']/descendant::a[text()='Logout']");
    public By alertMessage = By.xpath("//div[@id='alert_float_1']/descendant::span[@class='alert-title']");

    public DashboardPage clickMenuDashboard() {
        WebUI.clickElement(menuDashboard);
        return new DashboardPage(driver);
    }

    public CustomerPage clickMenuCustomer() {
        WebUI.clickElement(menuCustomers);
        return new CustomerPage(driver);
    }

    public LeadPage clickMenuLead() {
        WebUI.clickElement(menuLead);
        return new LeadPage(driver);
    }

    public TaskPage clickMenuTask() {
        WebUI.clickElement(menuTasks);
        return new TaskPage(driver);
    }

    public LoginPage clickLogout() {
        WebUI.clickElement(iconProfile);
        WebUI.clickElement(linkLogout);
        return new LoginPage(driver);
    }

    public void verifyAlertMessageSuccessDisplayed(String expectedMessage) {
        WebUI.sleep(0.5);
        String actualMessage = WebUI.getTextElement(alertMessage);
        Assert.assertTrue(WebUI.checkElementExist(alertMessage), "The alert message is not displayed");
        Assert.assertEquals(actualMessage, expectedMessage, "Alert message does not match!");
    }
}
