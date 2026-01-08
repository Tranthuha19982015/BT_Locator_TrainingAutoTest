package com.hatester.testcases;

import com.hatester.dataprovider.DataProviderFactory;
import com.hatester.enums.ExpectedResult;
import com.hatester.pages.LoginPage;
import com.hatester.common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @Test(dataProvider = "getLoginData", dataProviderClass = DataProviderFactory.class)
    public void testLogin(Map<String, String> map) {
        loginPage = new LoginPage();
        loginPage.loginCRM(map.get("EMAIL"), map.get("PASSWORD"));

        //Chuyển String → enum bằng valueOf()
        ExpectedResult expectedResult = ExpectedResult.valueOf(map.get("EXPECTED_RESULT").toUpperCase());

        switch (expectedResult) {
            case SUCCESS:
                loginPage.verifyLoginSuccess();
                break;
            case EMAIL_REQUIRED:
                loginPage.verifyLoginFailedWithEmailRequired();
                break;
            case PASSWORD_REQUIRED:
                loginPage.verifyLoginFailedWithPasswordRequired();
                break;
            case EMAIL_INVALID:
                loginPage.verifyLoginFailedWithEmailInvalid();
                break;
            case PASSWORD_INVALID:
                loginPage.verifyLoginFailedWithPasswordInvalid();
                break;
            default:
                Assert.fail("Unsupported EXPECTED_RESULT: " + map.get("EXPECTED_RESULT"));
        }
    }

//    @Test(priority = 2, dataProvider = "loginData", dataProviderClass = DataProviderFactory.class)
//    public void testLoginFailedWithEmailRequired(Map<String, String> map) {
//        loginPage = new LoginPage();
//        loginPage.loginCRM(map.get("EMAIL"), map.get("PASSWORD"));
//        loginPage.verifyLoginFailedWithEmailRequired();
//    }
//
//    @Test(priority = 3, dataProvider = "loginData", dataProviderClass = DataProviderFactory.class)
//    public void testLoginFailedWithPasswordRequired(Map<String, String> map) {
//        loginPage = new LoginPage();
//        loginPage.loginCRM(map.get("EMAIL"), map.get("PASSWORD"));
//        loginPage.verifyLoginFailedWithPasswordRequired();
//    }
//
//    @Test(priority = 4, dataProvider = "loginData", dataProviderClass = DataProviderFactory.class)
//    public void testLoginFailedWithEmailInvalid(Map<String, String> map) {
//        loginPage = new LoginPage();
//        loginPage.loginCRM(map.get("EMAIL"), map.get("PASSWORD"));
//        loginPage.verifyLoginFailedWithEmailInvalid();
//    }
//
//    @Test(priority = 5, dataProvider = "loginData", dataProviderClass = DataProviderFactory.class)
//    public void testLoginFailedWithPasswordInvalid(Map<String, String> map) {
//        loginPage = new LoginPage();
//        loginPage.loginCRM(map.get("EMAIL"), map.get("PASSWORD"));
//        loginPage.verifyLoginFailedWithPasswordInvalid();
//    }
}
