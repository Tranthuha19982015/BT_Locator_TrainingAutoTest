package com.hatester.pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
