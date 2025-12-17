package com.hatester.testcases;

import com.hatester.pages.LoginPage;
import com.hatester.common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @Test(priority = 1)
    public void testLoginSuccess() throws InterruptedException {
        loginPage = new LoginPage();
        loginPage.navigateToCRM();
        loginPage.verifyHeaderLogin();
        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
    }

    @Test(priority = 2)
    public void testLoginFailedWithEmailRequired() throws InterruptedException {
        loginPage = new LoginPage();
        loginPage.navigateToCRM();
        loginPage.verifyHeaderLogin();
        loginPage.loginCRM("", "123456");
        loginPage.verifyLoginFailedWithEmailRequired();
    }

    @Test(priority = 3)
    public void testLoginFailedWithPasswordRequired() throws InterruptedException {
        loginPage = new LoginPage();
        loginPage.navigateToCRM();
        loginPage.verifyHeaderLogin();
        loginPage.loginCRM("admin@example.com", "");
        loginPage.verifyLoginFailedWithPasswordRequired();
    }

    @Test(priority = 4)
    public void testLoginFailedWithEmailInvalid() throws InterruptedException {
        loginPage = new LoginPage();
        loginPage.navigateToCRM();
        loginPage.verifyHeaderLogin();
        loginPage.loginCRM("admin12@example.com", "123456");
        loginPage.verifyLoginFailedWithEmailInvalid();
    }

    @Test(priority = 5)
    public void testLoginFailedWithPasswordInvalid() throws InterruptedException {
        loginPage = new LoginPage();
        loginPage.navigateToCRM();
        loginPage.verifyHeaderLogin();
        loginPage.loginCRM("admin@example.com", "12345678");
        loginPage.verifyLoginFailedWithPasswordInvalid();
    }
}
