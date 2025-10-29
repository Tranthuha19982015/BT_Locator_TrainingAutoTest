package com.hatester.bt_locators;

public class Locator_LoginPage {
    //Locator Login Page
    public static String headerLoginPage = "//h1[normalize-space()='Login']";
    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String buttonLogin = "//button[normalize-space()='Login']";
    public static String checkboxRememberMe = "//input[@id='remember']";
    public static String linkForgotPassword = "//a[normalize-space()='Forgot Password?']";
    public static String errorMessageInvalidEmailOrPassword = "//div[@id='alerts']/div[normalize-space()='Invalid email or password']";
    public static String errorMessageEmailIsNull = "//div[text()='The Email Address field is required.' and contains(@class,'alert-danger')]";
    public static String errorMessagePasswordIsNull = "//div[text()='The Password field is required.' and contains(@class,'alert-danger')]";

    //locator Menu Dashboard
    public static String menuDashboard = "//ul[@id='side-menu']//span[normalize-space()='Dashboard' and @class='menu-text']]";
}
