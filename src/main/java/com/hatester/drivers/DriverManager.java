package com.hatester.drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();  //final định nghĩa hằng, hằng thì không thể gán lại giá trị

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        return driver.get(); //lấy driver theo từng luồng
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver.set(driver); //set driver theo đúng luồng
    }

    public static void quitDriver() {
        driver.get().quit();  //tắt driver, reset giá trị driver = null, quit() thuộc Selenium
        driver.remove();  //xóa luồng, xóa luôn vùng nhớ trong bộ nhớ máy tính, remove() thuộc ThreadLocal
    }
}
