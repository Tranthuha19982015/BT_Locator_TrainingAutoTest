package com.hatester.common;

import com.hatester.drivers.DriverManager;
import com.hatester.helpers.PropertiesHelper;
import com.hatester.listeners.TestListener;
import com.hatester.utils.LogUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {
    public SoftAssert softAssert;

    @BeforeSuite
    public void setupLoadProperties() {
        PropertiesHelper.loadAllFiles();
    }

    @Parameters("browser")
    @BeforeMethod
    public void createDriver(@Optional("browser") String browserName) {
        // Khởi tạo driver cục bộ và khởi tạo giá trị cho driver đó
        WebDriver driver;

        if (PropertiesHelper.getValue("BROWSER") != null && !PropertiesHelper.getValue("BROWSER").isBlank()) {
            browserName = PropertiesHelper.getValue("BROWSER");
        }

        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                LogUtils.info("Launching Chrome browser...");

                ChromeOptions options = new ChromeOptions();
                if (PropertiesHelper.getValue("HEADLESS").equalsIgnoreCase("true")) {
                    options.addArguments("--headless=new");
                    options.addArguments("--window-size=" + PropertiesHelper.getValue("WINDOW_SIZE"));
                }

                driver = new ChromeDriver(options);
                break;
            case "edge":
                LogUtils.info("Launching Edge browser...");
                driver = new EdgeDriver();
                break;
            case "firefox":
                LogUtils.info("Launching Firefox browser...");
                driver = new FirefoxDriver();
                break;
            default:
                LogUtils.info("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = new ChromeDriver();
        }

        //Set driver vào thread
        DriverManager.setDriver(driver);

        //Sử dụng driver thì phải lấy ra để dùng - Tự động truy xuất driver theo từng thread
        if (PropertiesHelper.getValue("HEADLESS").equalsIgnoreCase("false")) {
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
