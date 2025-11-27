package com.hatester.keywords;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebUI {

    public static void highlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red';", element);
    }

    public static void highlightElement(WebDriver driver, WebElement element, String color) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid " + color + "';", element);
    }

    public static boolean checkExistsElement(WebDriver driver, String xpathElement) {
        List<WebElement> element = driver.findElements(By.xpath(xpathElement));
        if (element.size() > 0) {
            System.out.println("Phần tử tồn tại: true" + xpathElement);
            return true;
        } else {
            System.out.println("Phần tử không tồn tại: false" + xpathElement);
            return false;
        }
    }
}
