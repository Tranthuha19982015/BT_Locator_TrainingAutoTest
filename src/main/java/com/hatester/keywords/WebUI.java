package com.hatester.keywords;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class WebUI {
    private static WebDriver driver;
    private static int WAIT_TIMEOUT = 10;
    private static double STEP_TIME = 0.5;
    private static int PAGE_LOAD_TIMEOUT = 20;

    public WebUI(WebDriver driver) {
        WebUI.driver = driver;
    }

    public static void sleep(double second) {
        try {
            Thread.sleep((long) second * 1000);
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }
    }

    public static void highlightElement(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red';", getWebElement(by));
    }

    public static void highlightElement(By by, String color) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid " + color + "';", getWebElement(by));
    }

    public static void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red';", element);
    }

    public static void highlightElement(WebElement element, String color) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid " + color + "';", element);
    }

    public static WebElement waitForElementVisible(By by) {
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT), Duration.ofMillis(500));
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            highlightElement(element);
            return element;
        } catch (Throwable error) {
            System.out.println("Timeout waiting for the element Visible. " + by.toString());
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
        }
        return element;
    }

    public static WebElement waitForElementVisible(By by, int seconds) {
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds), Duration.ofMillis(500));
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            highlightElement(element);
            return element;
        } catch (Throwable error) {
            System.out.println("Timeout waiting for the element Visible. " + by.toString());
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
        }
        return element;
    }

    public static List<WebElement> waitForAllElementsVisible(By by) {
        List<WebElement> element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT), Duration.ofMillis(500));
            element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
            highlightElement(by);
            return element;
        } catch (Throwable error) {
            System.out.println("Timeout waiting for all elements to be visible. " + by.toString());
            Assert.fail("Timeout waiting for all elements to be visible. " + by.toString());
        }
        return element;
    }

    public static List<WebElement> waitForAllElementsVisible(By by, int seconds) {
        List<WebElement> element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds), Duration.ofMillis(500));
            element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
            highlightElement(by);
            return element;
        } catch (Throwable error) {
            System.out.println("Timeout waiting for all elements to be visible. " + by.toString());
            Assert.fail("Timeout waiting for all elements to be visible. " + by.toString());
        }
        return element;
    }

    public static void waitForElementNotVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
            highlightElement(by);
        } catch (Throwable error) {
            System.out.println("Timeout waiting for the element Not Visible. " + by.toString());
            Assert.fail("Timeout waiting for the element Not Visible. " + by.toString());
        }
    }

    public static WebElement waitForElementPresent(By by) {
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT), Duration.ofMillis(500));
            element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
            highlightElement(element);
            return element;
        } catch (Throwable error) {
            System.out.println("Timeout waiting for the element Not Visible. " + by.toString());
            Assert.fail("Timeout waiting for the element Not Visible. " + by.toString());
        }
        return element;
    }

    public static WebElement waitForElementToBeClickable(By by) {
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT), Duration.ofMillis(500));
            element = wait.until(ExpectedConditions.elementToBeClickable(by));
            highlightElement(element);
            return element;
        } catch (Throwable error) {
            System.out.println("Timeout waiting for the element To Be Clickable. " + by.toString());
            Assert.fail("Timeout waiting for the element To Be Clickable. " + by.toString());
        }
        return element;
    }

    public static WebElement waitForElementToBeClickable(By by, int seconds) {
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds), Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(by));
            highlightElement(element);
            return element;
        } catch (Throwable error) {
            System.out.println("Timeout waiting for the element To Be Clickable. " + by.toString());
            Assert.fail("Timeout waiting for the element To Be Clickable. " + by.toString());
        }
        return element;
    }

    public static void switchToFrame(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
        } catch (Throwable error) {
            System.out.println("Timeout waiting for Switch To Frame. " + by.toString());
            Assert.fail("Timeout waiting for Switch To Frame. " + by.toString());
        }
    }

    public static void switchToParentFrame(WebDriver driver) {
        driver.switchTo().parentFrame();
    }

    public static void switchToDefaultContentFrame(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public static WebElement getWebElement(By by) {
        return driver.findElement(by);
    }

    public static List<WebElement> getWebElements(By by) {
        return driver.findElements(by);
    }

    public static boolean checkElementExist(By by) {
        List<WebElement> element = getWebElements(by);
        if (element.size() > 0) {
            System.out.println("Phần tử tồn tại: true " + by);
            return true;
        } else {
            System.out.println("Phần tử không tồn tại: false " + by);
            return false;
        }
    }

    public static boolean checkElementExist(By by, int seconds) {
        List<WebElement> element = waitForAllElementsVisible(by, seconds);
        if (element.size() > 0) {
            System.out.println("Phần tử tồn tại: true " + by);
            return true;
        } else {
            System.out.println("Phần tử không tồn tại: false " + by);
            return false;
        }
    }

    //Hàm kiểm tra hiển  với WebDriverWait - tương ứng driver.findElement(By).isDisplayed()
    public static boolean checkElementDisplay(By by, int timeoutSeconds) {
        try {
            WebElement element = waitForElementVisible(by, timeoutSeconds);
            highlightElement(element);
            System.out.println("Element found: " + by.toString() + " within " + timeoutSeconds + " seconds.");
            return true;
        } catch (TimeoutException e) {
            System.out.println("Element not found: " + by.toString() + " within " + timeoutSeconds + " seconds.");
            return false;
        }
    }


    public static boolean checkSeletedElement(By by) {
        WebElement element = waitForElementPresent(by);
        if (element.isSelected()) {
            System.out.println("Phần tử đã tích chọn: true " + by);
            return true;
        } else {
            System.out.println("Phần tử không tích chọn: false " + by);
            return false;
        }
    }

    public static void openURL(String url) {
        sleep(STEP_TIME);
        driver.get(url);
        System.out.println("Open URL: " + url);
    }

    public static String getCurrentURL(WebDriver driver) {
        sleep(STEP_TIME);
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        return currentUrl;
    }

    public static void clearTextElement(By by) {
        sleep(STEP_TIME);
        waitForElementVisible(by).clear();
        System.out.println("Clear text on element:" + by.toString());
    }

    public static void setTextElement(By by, String text) {
        sleep(STEP_TIME);
        waitForElementVisible(by).sendKeys(text);
        System.out.println("Set text " + text + " on element: " + by.toString());
    }

    public static void setTextAndKeyElement(By by, String text, Keys key) {
        sleep(STEP_TIME);
        waitForElementVisible(by).sendKeys(text, key);
        System.out.println("Set text and key " + text + " on element: " + by.toString());
    }

    public static void clickElement(By by) {
        sleep(STEP_TIME);
        waitForElementToBeClickable(by).click();
        System.out.println("Click to element: " + by);
    }

    public static String getElementText(By by) {
        sleep(STEP_TIME);
        WebElement element = waitForElementVisible(by);
        System.out.println("Get text on element: " + by.toString());
        String text = element.getText();
        System.out.println("==> TEXT: " + text);
        return text;
    }

    public static String getElementAttribute(By by, String attribute) {
        sleep(STEP_TIME);
        WebElement element = waitForElementVisible(by);
        System.out.println("Get attribute on element: " + by);
        String textAttribute = element.getAttribute(attribute);
        System.out.println("==> Attribute: " + textAttribute);
        return textAttribute;
    }

    public static void scrollAtTop(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(by));
    }

    public static void scrollAtBottom(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", getWebElement(by));
    }
}
