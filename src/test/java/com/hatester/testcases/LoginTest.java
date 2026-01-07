package com.hatester.testcases;

import com.hatester.dataprovider.DataProviderFactory;
import com.hatester.helpers.ExcelHelper;
import com.hatester.pages.LoginPage;
import com.hatester.common.BaseTest;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @Test(priority = 1, dataProvider = "loginData", dataProviderClass = DataProviderFactory.class)
    public void testLoginSuccess(Map<String, String> map) {
        loginPage = new LoginPage();
        loginPage.loginCRM(map.get("EMAIL"), map.get("PASSWORD"));
        loginPage.verifyLoginSuccess();
    }

    @Test(priority = 2, dataProvider = "loginData", dataProviderClass = DataProviderFactory.class)
    public void testLoginFailedWithEmailRequired(Map<String, String> map) {
        loginPage = new LoginPage();
        loginPage.loginCRM(map.get("EMAIL"), map.get("PASSWORD"));
        loginPage.verifyLoginFailedWithEmailRequired();
    }

    @Test(priority = 3, dataProvider = "loginData", dataProviderClass = DataProviderFactory.class)
    public void testLoginFailedWithPasswordRequired(Map<String, String> map) {
        loginPage = new LoginPage();
        loginPage.loginCRM(map.get("EMAIL"), map.get("PASSWORD"));
        loginPage.verifyLoginFailedWithPasswordRequired();
    }

    @Test(priority = 4, dataProvider = "loginData", dataProviderClass = DataProviderFactory.class)
    public void testLoginFailedWithEmailInvalid(Map<String, String> map) {
        loginPage = new LoginPage();
        loginPage.loginCRM(map.get("EMAIL"), map.get("PASSWORD"));
        loginPage.verifyLoginFailedWithEmailInvalid();
    }

    @Test(priority = 5, dataProvider = "loginData", dataProviderClass = DataProviderFactory.class)
    public void testLoginFailedWithPasswordInvalid(Map<String, String> map) {
        loginPage = new LoginPage();
        loginPage.loginCRM(map.get("EMAIL"), map.get("PASSWORD"));
        loginPage.verifyLoginFailedWithPasswordInvalid();
    }
}
