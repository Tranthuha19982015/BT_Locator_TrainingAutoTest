package com.hatester.common;

import com.hatester.drivers.DriverManager;
import com.hatester.helpers.PropertiesHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BaseTest {
    public SoftAssert softAssert;

    @BeforeSuite
    public void setupLoadProperties() {
        PropertiesHelper.loadAllFiles();
    }

    @Parameters("browser")
    @BeforeMethod
    public void createDriver(@Optional("chrome") String browserName) {
        // Khởi tạo driver cục bộ và khởi tạo giá trị cho driver đó
        WebDriver driver;

        if (PropertiesHelper.getValue("browser") != null && !PropertiesHelper.getValue("browser").isBlank()) {
            browserName = PropertiesHelper.getValue("browser");
        }

        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                System.out.println("Launching Chrome browser...");

                ChromeOptions options = new ChromeOptions();
                if (PropertiesHelper.getValue("headless").equalsIgnoreCase("true")) {
                    options.addArguments("--headless=new");
                    options.addArguments("--window-size=" + PropertiesHelper.getValue("window_size"));
                }

                driver = new ChromeDriver(options);
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
        if (PropertiesHelper.getValue("headless").equalsIgnoreCase("false")) {
            DriverManager.getDriver().manage().window().maximize();
        }
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
