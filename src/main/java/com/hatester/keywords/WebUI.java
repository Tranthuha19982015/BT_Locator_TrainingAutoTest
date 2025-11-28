package com.hatester.keywords;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebUI {

    private static int WAIT_TIMEOUT = 10;

    public static void highlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red';", element);
    }

    public static void highlightElement(WebDriver driver, WebElement element, String color) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid " + color + "';", element);
    }

    public static void waitForElementVisible(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT), Duration.ofMillis(500));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementVisible(WebDriver driver, By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds), Duration.ofMillis(500));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementPresent(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT), Duration.ofMillis(500));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitForElementToBeClickable(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT), Duration.ofMillis(500));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitForElementToBeClickable(WebDriver driver, By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds), Duration.ofMillis(500));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void switchToFrame(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }

    public static void switchToParentFrame(WebDriver driver) {
        driver.switchTo().parentFrame();
    }

    public static void switchToDefaultContentFrame(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public static WebElement getWebElement(WebDriver driver, By by) {
        return driver.findElement(by);
    }

    public static List<WebElement> getWebElements(WebDriver driver, By by) {
        return driver.findElements(by);
    }

    public static boolean checkExistsElement(WebDriver driver, By by) {
        List<WebElement> element = getWebElements(driver, by);
        if (element.size() > 0) {
            System.out.println("Phần tử tồn tại: true " + by);
            return true;
        } else {
            System.out.println("Phần tử không tồn tại: false " + by);
            return false;
        }
    }

    public static boolean checkSeletedElement(WebDriver driver, By by) {
        waitForElementPresent(driver, by);
        WebElement element = getWebElement(driver, by);
        if (element.isSelected()) {
            System.out.println("Phần tử đã tích chọn: true " + by);
            return true;
        } else {
            System.out.println("Phần tử không tích chọn: false " + by);
            return false;
        }
    }

    public static void openURL(WebDriver driver, String url) {
        driver.get(url);
        System.out.println("Open URL: " + url);
    }

    public static String getCurrentURL(WebDriver driver) {
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        return currentUrl;
    }

    public static void clearTextElement(WebDriver driver, By by) {
        waitForElementVisible(driver, by);
        getWebElement(driver, by).clear();
        System.out.println("Clear text on element:" + by);
    }

    public static void setTextElement(WebDriver driver, By by, String text) {
        waitForElementVisible(driver, by);
        getWebElement(driver, by).sendKeys(text);
        System.out.println("Set text " + text + " on element: " + by);
    }

    public static void setTextAndKeyElement(WebDriver driver, By by, String text, Keys key) {
        waitForElementVisible(driver, by);
        getWebElement(driver, by).sendKeys(text, key);
        System.out.println("Set text and key " + text + " on element: " + by);
    }

    public static void clickElement(WebDriver driver, By by) {
        waitForElementToBeClickable(driver, by);
        getWebElement(driver, by).click();
        System.out.println("Click to element: " + by);
    }

    public static String getElementText(WebDriver driver, By by) {
        waitForElementVisible(driver, by);
        WebElement element = getWebElement(driver, by);
        System.out.println("Get text on element: " + by);
        String text = element.getText();

        System.out.println("==> TEXT: " + text);
        return text;
    }

    public static String getElementAttribute(WebDriver driver, By by, String attribute) {
        waitForElementVisible(driver, by);
        WebElement element = getWebElement(driver, by);
        System.out.println("Get attribute on element: " + by);
        String textAttribute = element.getAttribute(attribute);
        System.out.println("==> Attribute: " + textAttribute);
        return textAttribute;
    }

    public static void scrollAtTop(WebDriver driver, By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, by));
    }

    public static void scrollAtBottom(WebDriver driver, By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, by));
    }
}
