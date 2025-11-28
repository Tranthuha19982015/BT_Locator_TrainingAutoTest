package com.hatester.bt_locators;

import org.openqa.selenium.By;

public class LocatorLoginPage {

    public static String url = "https://crm.anhtester.com/admin/authentication";
    //Locator Login Page
    public static By headerLoginPage = By.xpath("//h1[normalize-space()='Login']");
    public static By inputEmail = By.xpath("//input[@id='email']");
    public static By inputPassword = By.xpath("//input[@id='password']");
    public static By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    public static By checkboxRememberMe = By.xpath("//input[@id='remember']");
    public static By linkForgotPassword = By.xpath("//a[normalize-space()='Forgot Password?']");
    public static By errorMessageInvalidEmailOrPassword = By.xpath("//div[@id='alerts']/div[normalize-space()='Invalid email or password']");
    public static By errorMessageEmailRequired = By.xpath("//div[text()='The Email Address field is required.' and contains(@class,'alert-danger')]");
    public static By errorMessagePasswordRequired = By.xpath("//div[text()='The Password field is required.' and contains(@class,'alert-danger')]");

    //locator Menu Dashboard
    public static By menuDashboard = By.xpath("//ul[@id='side-menu']//span[normalize-space()='Dashboard' and @class='menu-text']");


}
