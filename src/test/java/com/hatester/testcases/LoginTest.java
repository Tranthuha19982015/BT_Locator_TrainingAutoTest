package com.hatester.testcases;

import com.hatester.helpers.ExcelHelper;
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

        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile("src/test/resources/datatest/dataCRM.xlsx", "Login");
        loginPage.loginCRM(excel.getCellData("EMAIL",1), excel.getCellData("PASSWORD",1));

        loginPage.verifyLoginSuccess();
    }

    @Test(priority = 2)
    public void testLoginFailedWithEmailRequired() throws InterruptedException {
        loginPage = new LoginPage();
        loginPage.navigateToCRM();
        loginPage.verifyHeaderLogin();

        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile("src/test/resources/datatest/dataCRM.xlsx", "Login");
        loginPage.loginCRM(excel.getCellData("EMAIL",2), excel.getCellData("PASSWORD",2));

        loginPage.verifyLoginFailedWithEmailRequired();
    }

    @Test(priority = 3)
    public void testLoginFailedWithPasswordRequired() throws InterruptedException {
        loginPage = new LoginPage();
        loginPage.navigateToCRM();
        loginPage.verifyHeaderLogin();

        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile("src/test/resources/datatest/dataCRM.xlsx", "Login");
        loginPage.loginCRM(excel.getCellData("EMAIL",3), excel.getCellData("PASSWORD",3));

        loginPage.verifyLoginFailedWithPasswordRequired();
    }

    @Test(priority = 4)
    public void testLoginFailedWithEmailInvalid() throws InterruptedException {
        loginPage = new LoginPage();
        loginPage.navigateToCRM();
        loginPage.verifyHeaderLogin();

        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile("src/test/resources/datatest/dataCRM.xlsx", "Login");
        loginPage.loginCRM(excel.getCellData("EMAIL",4), excel.getCellData("PASSWORD",4));

        loginPage.verifyLoginFailedWithEmailInvalid();
    }

    @Test(priority = 5)
    public void testLoginFailedWithPasswordInvalid() throws InterruptedException {
        loginPage = new LoginPage();
        loginPage.navigateToCRM();
        loginPage.verifyHeaderLogin();

        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile("src/test/resources/datatest/dataCRM.xlsx", "Login");
        loginPage.loginCRM(excel.getCellData("EMAIL",5), excel.getCellData("PASSWORD",5));

        loginPage.verifyLoginFailedWithPasswordInvalid();
    }
}
