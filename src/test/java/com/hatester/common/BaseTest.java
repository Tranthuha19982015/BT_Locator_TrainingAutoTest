package com.hatester.common;

import com.hatester.drivers.DriverManager;
import com.hatester.pages.LoginPage;
import com.hatester.keywords.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BaseTest {
    public SoftAssert softAssert;

    @Parameters("browser")
    @BeforeMethod
    public void createDriver(@Optional("chrome") String browserName) {
        // Khởi tạo driver cục bộ và khởi tạo giá trị cho driver đó
        WebDriver driver;
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                System.out.println("Launching Chrome browser...");
                driver = new ChromeDriver();
                break;
            case "edge":
                System.out.println("Launching Edge browser...");
                driver = new EdgeDriver();
                break;
            case "firefox":
                System.out.println("Launching Firefox browser...");
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = new ChromeDriver();
        }

        //Set driver vào thread
        DriverManager.setDriver(driver);

        //Sử dụng driver thì phải lấy ra để dùng - Tự động truy xuất driver theo từng thread
        DriverManager.getDriver().manage().window().maximize();
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void closeDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.quitDriver();
        }
        softAssert.assertAll();
    }
}
