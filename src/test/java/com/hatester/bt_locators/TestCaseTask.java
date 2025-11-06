package com.hatester.bt_locators;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestCaseTask extends BaseTest {
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
    public void testAddNewTask(String subject, String startDate, String dueDate, String priority, String typeRepeatEvery, String relatedTo, String typeRelatedTo, String assignee, String follower) throws InterruptedException, AWTException {
        //click menu Task
        driver.findElement(By.xpath(LocatorTaskPage.menuTasks)).click();
        Thread.sleep(2000);
        boolean checkMenuTaskDisplay = driver.findElement(By.xpath(LocatorTaskPage.headerTasksSummary)).isDisplayed();
        if (checkMenuTaskDisplay) {
            System.out.println("Đã tới trang Tasks");
        } else {
            System.out.println("FAILED!!! Không truy cập được vào trang Tasks");
        }

        //click button New Task
        driver.findElement(By.xpath(LocatorTaskPage.buttonNewTask)).click();
        Thread.sleep(1000);
        boolean checkPopupAddNewDisplay = driver.findElement(By.xpath(LocatorTaskPage.headerAddNewTask)).isDisplayed();
        if (checkPopupAddNewDisplay) {
            System.out.println("Mở pop-up Add new task thành công");
        } else {
            System.out.println("FAILED!!! Không mở được pop-up Add new task");
        }

        //checkbox
        driver.findElement(By.xpath(LocatorTaskPage.checkboxPublic)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorTaskPage.checkboxBillable)).click();
        Thread.sleep(500);

        //input
        driver.findElement(By.xpath(LocatorTaskPage.inputSubject)).sendKeys(subject);
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorTaskPage.inputHourlyRate)).clear();
        driver.findElement(By.xpath(LocatorTaskPage.inputHourlyRate)).sendKeys("8");
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorTaskPage.inputStartDate)).clear();
        driver.findElement(By.xpath(LocatorTaskPage.inputStartDate)).sendKeys(startDate);
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorTaskPage.inputDueDate)).clear();
        driver.findElement(By.xpath(LocatorTaskPage.inputDueDate)).sendKeys(dueDate);
        Thread.sleep(500);

        //Priority
        driver.findElement(By.xpath(LocatorTaskPage.dropdownPriority)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorTaskPage.getValuePriority(priority))).click();
        Thread.sleep(1000);

        //Repeat every
        driver.findElement(By.xpath(LocatorTaskPage.dropdownRepeatEvery)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorTaskPage.getValueRepeatEvery(typeRepeatEvery))).click();
        Thread.sleep(500);
        if (typeRepeatEvery.equals("Custom")) {
            driver.findElement(By.xpath(LocatorTaskPage.inputRepeatEveryCustom)).clear();
            driver.findElement(By.xpath(LocatorTaskPage.inputRepeatEveryCustom)).sendKeys("4");
            Thread.sleep(500);
            driver.findElement(By.xpath(LocatorTaskPage.dropdownRepeatEveryCustom)).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath(LocatorTaskPage.getValueRepeatEveryCustom("Week"))).click();
            Thread.sleep(500);
        } else if (typeRepeatEvery.equals("Weeks") || typeRepeatEvery.equals("2 Weeks")
                || typeRepeatEvery.equals("1 Months") || typeRepeatEvery.equals("2 Months") || typeRepeatEvery.equals("3 Months") || typeRepeatEvery.equals("6 Months")
                || typeRepeatEvery.equals("1 Year")) {
            driver.findElement(By.xpath(LocatorTaskPage.checkboxInfinity)).click();
            Thread.sleep(500);
            driver.findElement(By.xpath(LocatorTaskPage.inputTotalCycles)).clear();
            driver.findElement(By.xpath(LocatorTaskPage.inputTotalCycles)).sendKeys("2");
            Thread.sleep(500);
        } else {
            System.out.println("Không tồn tại Type Repeat Every đã nhập");
        }

        //Related To
        driver.findElement(By.xpath(LocatorTaskPage.dropdownRelatedTo)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorTaskPage.getValueRelatedTo(relatedTo))).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorTaskPage.dropdownTypeRelatedTo)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorTaskPage.inputSearchTypeRelatedTo)).sendKeys(typeRelatedTo);
        Thread.sleep(1000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorTaskPage.getValueTypeRelatedTo(typeRelatedTo))).click();
        Thread.sleep(500);

        //Assignees
        driver.findElement(By.xpath(LocatorTaskPage.dropdownAssignees)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorTaskPage.inputSearchAssignees)).sendKeys(assignee);
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorTaskPage.getValueAssignees(assignee))).click();
        Thread.sleep(500);

        //Followers
        driver.findElement(By.xpath(LocatorTaskPage.dropdownFollowers)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorTaskPage.inputSearchFollowers)).sendKeys(follower);
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorTaskPage.getValueFollowers(follower))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorTaskPage.dropdownFollowers)).click();
        Thread.sleep(500);

        //input
        driver.findElement(By.xpath(LocatorTaskPage.inputTags)).sendKeys("htest");
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorTaskPage.labelTags)).click();
        driver.findElement(By.xpath(LocatorTaskPage.labelTags)).click();
        Thread.sleep(500);

        //checkbox
//        driver.findElement(By.xpath(LocatorTaskPage.inputDescription)).click();
//        Thread.sleep(500);

        //save
        driver.findElement(By.xpath(LocatorTaskPage.buttonSave)).click();
        Thread.sleep(2000);
    }

    public void verifyAfterAddNewTask(String taskName) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", driver.findElement(By.xpath(LocatorTaskPage.iconClosePopupTaskDetail(taskName))));
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorTaskPage.iconClosePopupTaskDetail(taskName))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorTaskPage.inputSearchTasks)).sendKeys(taskName);
        Thread.sleep(1000);

        boolean check = driver.findElement(By.xpath(LocatorTaskPage.getFirstRowItemTaskName(taskName))).isDisplayed();
        if (check) {
            System.out.println("Thêm mới Task thành công! Task mới: " + taskName);
        } else {
            System.out.println("FAILED!!! Thêm mới Task không thành công!!!");
        }
        Thread.sleep(2000);
    }

    public static void main(String[] args) throws InterruptedException, AWTException {
        TestCaseTask task1 = new TestCaseTask();
        String taskName = "task_htest" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        task1.createDriver();
        task1.loginCRM();
        task1.testAddNewTask(taskName, "06-11-2025", "06-01-2026", "Medium", "Custom", "Lead", "lead_htest", "Anh Tester", "Example");
        task1.verifyAfterAddNewTask(taskName);
        task1.closeDriver();
    }
}
