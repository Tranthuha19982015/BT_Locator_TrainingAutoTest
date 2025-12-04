package com.hatester.common;

import com.hatester.keywords.WebUI;
import com.hatester.pages.DashboardPage;
import com.hatester.pages.LeadPage;
import com.hatester.pages.LoginPage;
import com.hatester.pages.TaskPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
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

    public DashboardPage clickMenuDashboard() {
        WebUI.clickElement(driver, menuDashboard);
        return new DashboardPage(driver);
    }

    public LeadPage clickMenuLead() {
        WebUI.clickElement(driver, menuLead);
        return new LeadPage(driver);
    }

    public TaskPage clickMenuTask() {
        WebUI.clickElement(driver, menuTasks);
        return new TaskPage(driver);
    }

    public LoginPage clickLogout() {
        WebUI.clickElement(driver, iconProfile);
        WebUI.clickElement(driver, linkLogout);
        return new LoginPage(driver);
    }
}
