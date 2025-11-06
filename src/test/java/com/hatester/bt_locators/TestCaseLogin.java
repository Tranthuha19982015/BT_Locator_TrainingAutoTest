package com.hatester.bt_locators;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestCaseLogin extends BaseTest {

    public void loginCRM() throws InterruptedException {
        driver.get(LocatorLoginPage.url);
        Thread.sleep(500);

        driver.findElement(By.xpath(LocatorLoginPage.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorLoginPage.inputEmail)).sendKeys("admin@example.com");
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLoginPage.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorLoginPage.inputPassword)).sendKeys("123456");
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLoginPage.buttonLogin)).click();
        Thread.sleep(1000);

        boolean check = driver.findElement(By.xpath(LocatorLoginPage.menuDashboard)).isDisplayed();
        if (check) {
            System.out.println("Đăng nhập CRM thành công!");
        } else {
            System.out.println("FAILED!!! Đăng nhập không thành công!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestCaseLogin login1 = new TestCaseLogin();
        login1.createDriver();
        login1.loginCRM();
        login1.closeDriver();
    }
}
