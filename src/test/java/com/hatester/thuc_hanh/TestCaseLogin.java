package com.hatester.thuc_hanh;

import com.hatester.bt_locators.LocatorLoginPage;
import com.hatester.keywords.WebUI;
import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseLogin extends BaseTest {
    public void navigateToCRM() {
        WebUI.openURL(driver, LocatorLoginPage.url);
    }

    public void verifyHeaderLogin() {
        Assert.assertTrue(WebUI.checkExistsElement(driver, LocatorLoginPage.headerLoginPage), "The header Login is not display.");
    }

    public void enterEmail(String email) {
        WebUI.setTextElement(driver, LocatorLoginPage.inputEmail, email);
    }

    public void enterPassword(String password) {
        WebUI.setTextElement(driver, LocatorLoginPage.inputPassword, password);
    }

    public void clickButtonLogin() {
        WebUI.clickElement(driver, LocatorLoginPage.buttonLogin);
    }

    public void loginCRM(String email, String password) throws InterruptedException {
        enterEmail(email);
        enterPassword(password);
        clickButtonLogin();
    }

    public void loginCRM() throws InterruptedException {
        navigateToCRM();
        verifyHeaderLogin();
        enterEmail("admin@example.com");
        enterPassword("123456");
        clickButtonLogin();
        verifyLoginSuccess();
    }

    public void verifyLoginSuccess() throws InterruptedException {
        Thread.sleep(1000);
        String actualCurrentURL = WebUI.getCurrentURL(driver);
        String expectedURL = "https://crm.anhtester.com/admin/";

        Assert.assertTrue((WebUI.checkExistsElement(driver, LocatorLoginPage.menuDashboard) && actualCurrentURL.equals(expectedURL)),
                "Login failed!");
    }

    public void verifyLoginFailedWithEmailRequired() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(WebUI.checkExistsElement(driver, LocatorLoginPage.errorMessageEmailRequired),
                "The email required error message is not displayed");
    }

    public void verifyLoginFailedWithPasswordRequired() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(WebUI.checkExistsElement(driver, LocatorLoginPage.errorMessagePasswordRequired),
                "The password required error message is not displayed.");
    }

    public void verifyLoginFailedWithEmailInvalid() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(WebUI.checkExistsElement(driver, LocatorLoginPage.errorMessageInvalidEmailOrPassword),
                "The invalid email error message is not displayed.");
    }

    public void verifyLoginFailedWithPasswordInvalid() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(WebUI.checkExistsElement(driver, LocatorLoginPage.errorMessageInvalidEmailOrPassword),
                "The invalid password error message is not displayed.");
    }

    @Test(priority = 1)
    public void testLoginSuccess() throws InterruptedException {
        navigateToCRM();
        verifyHeaderLogin();
        loginCRM("admin@example.com", "123456");
        verifyLoginSuccess();
    }

    @Test(priority = 2)
    public void testLoginFailedWithEmailRequired() throws InterruptedException {
        navigateToCRM();
        verifyHeaderLogin();
        loginCRM("", "123456");
        verifyLoginFailedWithEmailRequired();
    }

    @Test(priority = 3)
    public void testLoginFailedWithPasswordRequired() throws InterruptedException {
        navigateToCRM();
        verifyHeaderLogin();
        loginCRM("admin@example.com", "");
        verifyLoginFailedWithPasswordRequired();
    }

    @Test(priority = 4)
    public void testLoginFailedWithEmailInvalid() throws InterruptedException {
        navigateToCRM();
        verifyHeaderLogin();
        loginCRM("admin12@example.com", "123456");
        verifyLoginFailedWithEmailInvalid();
    }

    @Test(priority = 5)
    public void testLoginFailedWithPasswordInvalid() throws InterruptedException {
        navigateToCRM();
        verifyHeaderLogin();
        loginCRM("admin@example.com", "12345678");
        verifyLoginFailedWithPasswordInvalid();
    }
}
