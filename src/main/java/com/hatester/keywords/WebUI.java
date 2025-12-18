package com.hatester.keywords;

import com.hatester.drivers.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class WebUI {
    private static int WAIT_TIMEOUT = 10;
    private static double STEP_TIME = 0.5;
    private static int PAGE_LOAD_TIMEOUT = 20;

    public static void sleep(double second) {
        try {
            Thread.sleep((long) second * 1000);
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }
    }

    public static WebElement waitForElementVisible(By by) {
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_TIMEOUT), Duration.ofMillis(500));
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
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds), Duration.ofMillis(500));
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            highlightElement(element);
            return element;
        } catch (Throwable error) {
            System.out.println("Timeout waiting for the element Visible with " + seconds + "s : " + by.toString());
            Assert.fail("Timeout waiting for the element Visible with " + seconds + "s : " + by.toString());
        }
        return element;
    }

    public static List<WebElement> waitForAllElementsVisible(By by) {
        List<WebElement> element = null;
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_TIMEOUT), Duration.ofMillis(500));
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
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds), Duration.ofMillis(500));
            element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
            highlightElement(by);
            return element;
        } catch (Throwable error) {
            System.out.println("Timeout waiting for all elements Visible with " + seconds + "s : " + by.toString());
            Assert.fail("Timeout waiting for all elements Visible with " + seconds + "s : " + by.toString());
        }
        return element;
    }

    public static void waitForElementNotVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
            highlightElement(by);
        } catch (Throwable error) {
            System.out.println("Timeout waiting for the element Not Visible. " + by.toString());
            Assert.fail("Timeout waiting for the element Not Visible. " + by.toString());
        }
    }

    public static void waitForElementNotVisible(By by, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds), Duration.ofMillis(500));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
            highlightElement(by);
        } catch (Throwable error) {
            System.out.println("Timeout waiting for the element not Visible with " + seconds + "s : " + by.toString());
            Assert.fail("Timeout waiting for the element not Visible with " + seconds + "s : " + by.toString());
        }
    }

    public static WebElement waitForElementPresent(By by) {
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_TIMEOUT), Duration.ofMillis(500));
            element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
            highlightElement(element);
            return element;
        } catch (Throwable error) {
            System.out.println("Element not exist. " + by.toString());
            Assert.fail("Element not exist. " + by.toString());
        }
        return element;
    }

    public static WebElement waitForElementPresent(By by, int seconds) {
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds), Duration.ofMillis(500));
            element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
            highlightElement(element);
            return element;
        } catch (Throwable error) {
            System.out.println("Element not exist with " + seconds + "s : " + by.toString());
            Assert.fail("Element not exist with " + seconds + "s : " + by.toString());
        }
        return element;
    }

    public static WebElement waitForElementToBeClickable(By by) {
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_TIMEOUT), Duration.ofMillis(500));
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
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds), Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(by));
            highlightElement(element);
            return element;
        } catch (Throwable error) {
            System.out.println("Timeout waiting for the element To Be Clickable with " + seconds + "s : " + by.toString());
            Assert.fail("Timeout waiting for the element To Be Clickable with " + seconds + "s : " + by.toString());
        }
        return element;
    }

    //Chờ đợi trang load xong mới thao tác
    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

        // wait for Javascript to loaded
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) DriverManager.getDriver()).executeScript("return document.readyState")
                .toString().equals("complete");

        //Check JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            //System.out.println("Javascript is NOT Ready.");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("FAILED. Timeout waiting for page load.");
            }
        }
    }

    public static void switchToFrame(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
        } catch (Throwable error) {
            System.out.println("Timeout waiting for Switch To Frame. " + by.toString());
            Assert.fail("Timeout waiting for Switch To Frame. " + by.toString());
        }
    }

    public static void switchToFrame(By by, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds), Duration.ofMillis(500));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
        } catch (Throwable error) {
            System.out.println("Timeout waiting for switch to Frame with " + seconds + "s : " + by.toString());
            Assert.fail("Timeout waiting for switch to Frame with " + seconds + "s : " + by.toString());
        }
    }

    public static void switchToParentFrame() {
        DriverManager.getDriver().switchTo().parentFrame();
    }

    public static void switchToDefaultContentFrame() {
        DriverManager.getDriver().switchTo().defaultContent();
    }

    public static void acceptAlert() {
        DriverManager.getDriver().switchTo().alert().accept();
    }

    public static void dismissAlert() {
        DriverManager.getDriver().switchTo().alert().dismiss();
    }

    public static WebElement getWebElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }

    public static List<WebElement> getWebElements(By by) {
        return DriverManager.getDriver().findElements(by);
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

    // Hàm kiểm tra sự tồn tại của phần tử với lặp lại nhiều lần
    public static boolean checkElementExist(By by, int maxRetries, int waitTimeMillis) {
        int retryCount = 0;

        while (retryCount < maxRetries) {
            try {
                WebElement element = getWebElement(by);
                if (element != null) {
                    System.out.println("Tìm thấy phần tử ở lần thử thứ " + (retryCount + 1));
                    return true; // Phần tử được tìm thấy
                }
            } catch (NoSuchElementException e) {
                System.out.println("Không tìm thấy phần tử. Thử lại lần " + (retryCount + 1));
                retryCount++;
                try {
                    Thread.sleep(waitTimeMillis); // Chờ trước khi thử lại
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }

        // Trả về false nếu không tìm thấy phần tử sau maxRetries lần
        System.out.println("Không tìm thấy phần tử sau " + maxRetries + " lần thử.");
        return false;
    }

    //Hàm kiểm tra hiển thị với WebDriverWait - tương ứng driver.findElement(By).isDisplayed()
    public static boolean checkElementDisplay(By by, int seconds) {
        try {
            WebElement element = waitForElementVisible(by, seconds);
            highlightElement(element);
            System.out.println("Element found: " + by.toString() + " within " + seconds + " seconds.");
            return true;
        } catch (TimeoutException e) {
            System.out.println("Element not found: " + by.toString() + " within " + seconds + " seconds.");
            return false;
        }
    }

    public static boolean checkElementSeleted(By by) {
        WebElement element = waitForElementPresent(by);
        if (element.isSelected()) {
            System.out.println("Phần tử đã tích chọn: true " + by);
            return true;
        } else {
            System.out.println("Phần tử không tích chọn: false " + by);
            return false;
        }
    }

    public static void refreshPage() {
        DriverManager.getDriver().navigate().refresh();
    }

    public static void openURL(String url) {
        sleep(STEP_TIME);
        DriverManager.getDriver().get(url);
        System.out.println("Open URL: " + url);
    }

    public static String getCurrentURL() {
        sleep(STEP_TIME);
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        return currentUrl;
    }

    public static void clearTextElement(By by) {
        sleep(STEP_TIME);
        waitForElementVisible(by).clear();
        System.out.println("Clear text on element:" + by.toString());
    }

    public static void clearTextElement(By by, int seconds) {
        sleep(STEP_TIME);
        waitForElementVisible(by, seconds).clear();
        System.out.println("Clear text on element:" + by.toString() + " within " + seconds + " seconds.");
    }

    public static void setTextElement(By by, String text) {
        sleep(STEP_TIME);
        waitForElementVisible(by).sendKeys(text);
        System.out.println("Set text " + text + " on element: " + by.toString());
    }

    public static void setTextElement(By by, String text, int seconds) {
        sleep(STEP_TIME);
        waitForElementVisible(by, seconds).sendKeys(text);
        System.out.println("Set text " + text + " on element: " + by.toString() + " within " + seconds + " seconds.");
    }

    public static void setTextAndKey(By by, String text, Keys key) {
        sleep(STEP_TIME);
        waitForElementVisible(by).sendKeys(text, key);
        System.out.println("Set text and key " + text + " on element: " + by.toString());
    }

    public static void setTextAndKey(By by, String text, Keys key, int seconds) {
        sleep(STEP_TIME);
        waitForElementVisible(by, seconds).sendKeys(text, key);
        System.out.println("Set text and key " + text + " on element: " + by.toString() + " within " + seconds + " seconds.");
    }

    public static void clickElement(By by) {
        sleep(STEP_TIME);
        waitForElementToBeClickable(by).click();
        System.out.println("Click to element: " + by.toString());
    }

    public static void clickElement(By by, int seconds) {
        sleep(STEP_TIME);
        waitForElementToBeClickable(by, seconds).click();
        System.out.println("Click to element: " + by.toString() + " within " + seconds + " seconds.");
    }


    public static String getTextElement(By by) {
        sleep(STEP_TIME);
        WebElement element = waitForElementVisible(by);
        System.out.println("Get text on element: " + by.toString());
        String text = element.getText();
        System.out.println("==> TEXT: " + text);
        return text;
    }

    public static String getTextElement(By by, int seconds) {
        sleep(STEP_TIME);
        WebElement element = waitForElementVisible(by, seconds);
        System.out.println("Get text on element: " + by.toString() + " within " + seconds + " seconds.");
        String text = element.getText();
        System.out.println("==> TEXT: " + text);
        return text;
    }

    public static String getAttributeElement(By by, String attribute) {
        sleep(STEP_TIME);
        WebElement element = waitForElementVisible(by);
        System.out.println("Get attribute on element: " + by.toString());
        String textAttribute = element.getAttribute(attribute);
        System.out.println("==> Attribute: " + textAttribute);
        return textAttribute;
    }

    public static String getAttributeElement(By by, String attribute, int seconds) {
        sleep(STEP_TIME);
        WebElement element = waitForElementVisible(by);
        System.out.println("Get attribute on element: " + by.toString() + " within " + seconds + " seconds.");
        String textAttribute = element.getAttribute(attribute);
        System.out.println("==> Attribute: " + textAttribute);
        return textAttribute;
    }

    public static String getCssValueElement(By by, String cssPropertyName) {
        sleep(STEP_TIME);
        WebElement element = waitForElementVisible(by);
        System.out.println("Get CSS value " + cssPropertyName + " of element " + by.toString());
        String value = element.getCssValue(cssPropertyName);
        System.out.println("==> CSS value: " + value);
        return value;
    }

    public static String getCssValueElement(By by, String cssPropertyName, int seconds) {
        sleep(STEP_TIME);
        WebElement element = waitForElementVisible(by);
        System.out.println("Get CSS value " + cssPropertyName + " of element " + by.toString() + " within " + seconds + " seconds.");
        String value = element.getCssValue(cssPropertyName);
        System.out.println("==> CSS value: " + value);
        return value;
    }

    public static boolean moveToElement(By by) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveToElement(getWebElement(by)).perform();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean moveToOffset(int X, int Y) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveByOffset(X, Y).build().perform();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean hoverElement(By by) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveToElement(getWebElement(by)).perform();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean mouseHover(By by) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveToElement(getWebElement(by)).perform();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean dragAndDrop(By fromElement, By toElement) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.dragAndDrop(getWebElement(fromElement), getWebElement(toElement)).perform();
            //action.clickAndHold(getWebElement(fromElement)).moveToElement(getWebElement(toElement)).release(getWebElement(toElement)).build().perform();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean dragAndDropElement(By fromElement, By toElement) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.clickAndHold(getWebElement(fromElement)).moveToElement(getWebElement(toElement)).release(getWebElement(toElement)).build().perform();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean dragAndDropOffset(By fromElement, int X, int Y) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            //Tính từ vị trí click chuột đầu tiên (clickAndHold)
            action.clickAndHold(getWebElement(fromElement)).pause(1).moveByOffset(X, Y).release().build().perform();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Actions actionClickBase(By by, Keys key, String text) {
        WebElement element = waitForElementVisible(by);
        Actions action = new Actions(DriverManager.getDriver()).moveToElement(element).click();

        if (key != null) {
            action.sendKeys(key);
        }

        if (text != null && !text.isEmpty()) {
            action.sendKeys(text);
        }

        return action;
    }

    public static Actions actionClick(By by) {
        return actionClickBase(by, null, null);
    }

    public static Actions actionClickAndSetText(By by, String text) {
        return actionClickBase(by, null, text);
    }

    public static Actions actionClickAndSetKeys(By by, Keys key) {
        return actionClickBase(by, key, null);
    }

    public static Actions actionClickAndClear(By by) {
        return actionClickBase(by, null, null)
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .keyDown(Keys.DELETE).keyUp(Keys.DELETE);
    }

    public static boolean pressENTER() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean pressESC() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean pressF11() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_F11);
            robot.keyRelease(KeyEvent.VK_F11);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void highlightElement(By by) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].style.border='3px solid red';", getWebElement(by));
    }

    public static void highlightElement(By by, String color) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].style.border='3px solid " + color + "';", getWebElement(by));
    }

    public static void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].style.border='3px solid red';", element);
    }

    public static void highlightElement(WebElement element, String color) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].style.border='3px solid " + color + "';", element);
    }

    public static void scrollToElementAtTop(By by) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(by));
    }

    public static void scrollToElementAtBottom(By by) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", getWebElement(by));
    }

    public static void scrollToPosition(int X, int Y) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.scrollTo(" + X + "," + Y + ");");
    }

    public static boolean verifyEquals(Object actual, Object expected) {
        waitForPageLoaded();
        System.out.println("Verify equals: " + actual + " and " + expected);
        boolean check = actual.equals(expected);
        return check;
    }

    public static void assertEquals(Object actual, Object expected, String message) {
        waitForPageLoaded();
        System.out.println("Assert equals: " + actual + " and " + expected);
        Assert.assertEquals(actual, expected, message);
    }

    public static boolean verifyContains(String actual, String expected) {
        waitForPageLoaded();
        System.out.println("Verify contains: " + actual + " and " + expected);
        boolean check = actual.contains(expected);
        return check;
    }

    public static void assertContains(String actual, String expected, String message) {
        waitForPageLoaded();
        System.out.println("Assert contains: " + actual + " and " + expected);
        boolean check = actual.contains(expected);
        Assert.assertTrue(check, message);
    }
}
