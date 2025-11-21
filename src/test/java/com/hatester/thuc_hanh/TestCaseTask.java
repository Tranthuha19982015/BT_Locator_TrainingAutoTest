package com.hatester.thuc_hanh;

import com.hatester.bt_locators.LocatorTaskPage;
import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestCaseTask extends BaseTest {
    public void clickMenuTask() throws InterruptedException {
        driver.findElement(By.xpath(LocatorTaskPage.menuTasks)).click();
        Thread.sleep(2000);

        Assert.assertTrue(checkExistsElement(LocatorTaskPage.headerTasksSummary), "Không mở được Menu Task");
    }

    public void clickButtonNewTask() throws InterruptedException {
        driver.findElement(By.xpath(LocatorTaskPage.buttonNewTask)).click();
        Thread.sleep(1000);

        Assert.assertTrue(checkExistsElement(LocatorTaskPage.headerAddNewTask), "Không mở được pop-up Add Task");
    }

    public void fillDataNewTask(String subject, String hourlyRate, String startDate, String dueDate, String priority, String repeatEvery,
                                String numberRepeatEveryCustom, String typeRepeatEveryCustom, String totalCycles, String relatedTo,
                                String typeRelatedTo, String assignee, String follower, String tag, int flag) throws InterruptedException, AWTException {
        //checkbox
        if (flag == 1) {
            driver.findElement(By.xpath(LocatorTaskPage.checkboxPublic)).click();
            Thread.sleep(500);
        }
        if (flag == 0) {
            driver.findElement(By.xpath(LocatorTaskPage.checkboxBillable)).click();
            Thread.sleep(500);
        }

        //input
        driver.findElement(By.xpath(LocatorTaskPage.inputSubject)).sendKeys(subject);
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorTaskPage.inputHourlyRate)).clear();
        driver.findElement(By.xpath(LocatorTaskPage.inputHourlyRate)).sendKeys(hourlyRate);
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
        driver.findElement(By.xpath(LocatorTaskPage.getValueRepeatEvery(repeatEvery))).click();
        Thread.sleep(500);
        if (repeatEvery.equals("Custom")) {
            driver.findElement(By.xpath(LocatorTaskPage.inputRepeatEveryCustom)).clear();
            driver.findElement(By.xpath(LocatorTaskPage.inputRepeatEveryCustom)).sendKeys(numberRepeatEveryCustom);
            Thread.sleep(500);
            driver.findElement(By.xpath(LocatorTaskPage.dropdownRepeatEveryCustom)).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath(LocatorTaskPage.getValueRepeatEveryCustom(typeRepeatEveryCustom))).click();
            Thread.sleep(500);
        } else if (repeatEvery.equals("Week") || repeatEvery.equals("2 Weeks")
                || repeatEvery.equals("1 Months") || repeatEvery.equals("2 Months") || repeatEvery.equals("3 Months") || repeatEvery.equals("6 Months")
                || repeatEvery.equals("1 Year")) {
            driver.findElement(By.xpath(LocatorTaskPage.checkboxInfinity)).click();
            Thread.sleep(500);
            driver.findElement(By.xpath(LocatorTaskPage.inputTotalCycles)).clear();
            driver.findElement(By.xpath(LocatorTaskPage.inputTotalCycles)).sendKeys(totalCycles);
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
        driver.findElement(By.xpath(LocatorTaskPage.inputTags)).sendKeys(tag);
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorTaskPage.labelTags)).click();
        driver.findElement(By.xpath(LocatorTaskPage.labelTags)).click();
        Thread.sleep(500);

        //checkbox
//        driver.findElement(By.xpath(LocatorTaskPage.inputDescription)).click();
//        Thread.sleep(500);
    }

    public void clickButtonSave() throws InterruptedException {
        driver.findElement(By.xpath(LocatorTaskPage.buttonSave)).click();
        Thread.sleep(2000);
    }

    public void clickClosePopupTaskDetail(String taskName) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", driver.findElement(By.xpath(LocatorTaskPage.iconClosePopupTaskDetail(taskName))));
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorTaskPage.iconClosePopupTaskDetail(taskName))).click();
        Thread.sleep(1000);
    }


    public void searchAndCheckTask(String taskName) throws InterruptedException {
        driver.findElement(By.xpath(LocatorTaskPage.inputSearchTasks)).sendKeys(taskName);
        Thread.sleep(1000);

        Assert.assertTrue(checkExistsElement(LocatorTaskPage.getFirstRowItemTaskName(taskName)), "Không đúng giá trị vừa thêm mới");
    }

    public void clickButtonEdit(String taskName) throws InterruptedException {
        Thread.sleep(500);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(LocatorTaskPage.getFirstRowItemTaskName(taskName)))).perform();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorTaskPage.buttonEdit(taskName))).click();
        Thread.sleep(500);
    }

    public void verifyNewTaskInTaskEdit(String taskName, String subject, String hourlyRate, String startDate, String dueDate, String priority,
                                        String repeatEvery, String numberRepeatEveryCustom, String typeRepeatEveryCustom, String totalCycles,
                                        String relatedTo, String typeRelatedTo, String tag, int flag) throws InterruptedException {
        if (flag == 1) {
            Assert.assertTrue(driver.findElement(By.xpath(LocatorTaskPage.checkboxPublic)).isSelected(), "Checkbox không được chọn");
            Assert.assertTrue(driver.findElement(By.xpath(LocatorTaskPage.checkboxBillable)).isSelected(), "Checkbox không được chọn");
        }
        if (flag == 0) {
            Assert.assertFalse(driver.findElement(By.xpath(LocatorTaskPage.checkboxPublic)).isSelected(), "Checkbox được tích chọn");
            Assert.assertFalse(driver.findElement(By.xpath(LocatorTaskPage.checkboxBillable)).isSelected(), "Checkbox được tích chọn");
        }
        Assert.assertEquals(driver.findElement(By.xpath(LocatorTaskPage.inputSubject)).getAttribute("value").trim(),
                subject, "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorTaskPage.inputStartDate)).getAttribute("value").trim(),
                startDate, "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorTaskPage.inputDueDate)).getAttribute("value").trim(),
                dueDate, "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorTaskPage.dropdownPriority)).getText().trim(),
                priority, "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorTaskPage.dropdownRepeatEvery)).getText().trim(),
                repeatEvery, "Không đúng giá trị đã thêm mới");
        if (repeatEvery.equals("Custom")) {
            Assert.assertEquals(driver.findElement(By.xpath(LocatorTaskPage.inputRepeatEveryCustom)).getAttribute("value").trim(),
                    numberRepeatEveryCustom, "Không đúng giá trị đã thêm mới");
            Assert.assertEquals(driver.findElement(By.xpath(LocatorTaskPage.dropdownRepeatEveryCustom)).getText().trim(),
                    typeRepeatEveryCustom, "Không đúng giá trị đã thêm mới");
        } else if (repeatEvery.equals("Week") || repeatEvery.equals("2 Weeks")
                || repeatEvery.equals("1 Months") || repeatEvery.equals("2 Months") || repeatEvery.equals("3 Months") || repeatEvery.equals("6 Months")
                || repeatEvery.equals("1 Year")) {
            Assert.assertFalse(driver.findElement(By.xpath(LocatorTaskPage.checkboxInfinity)).isSelected(), "Checkbox không được chọn");
            Assert.assertEquals(driver.findElement(By.xpath(LocatorTaskPage.inputTotalCycles)).getAttribute("value").trim(),
                    totalCycles, "Không đúng giá trị đã thêm mới");
        } else {
            System.out.println("Không tồn tại Type Repeat Every đã nhập");
        }
        Assert.assertEquals(driver.findElement(By.xpath(LocatorTaskPage.dropdownRelatedTo)).getText().trim(), relatedTo,
                "Không đúng giá trị đã thêm mới");
        boolean containsTypeRelatedTo = (driver.findElement(By.xpath(LocatorTaskPage.dropdownTypeRelatedTo)).getText()).contains(typeRelatedTo);
        Assert.assertTrue(containsTypeRelatedTo, "Không đúng giá trị đã thêm mới");
        Assert.assertFalse(checkExistsElement(LocatorTaskPage.dropdownAssignees), "Không đúng giá trị đã thêm mới");
        Assert.assertFalse(checkExistsElement(LocatorTaskPage.dropdownFollowers), "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorTaskPage.inputTagsEdit)).getAttribute("value").trim().toLowerCase(), tag,
                "Không đúng giá trị đã thêm mới");
    }

    public void fillDataEdit(String subject, String hourlyRate, String startDate, String dueDate, String priority, String repeatEvery,
                             String numberRepeatEveryCustom, String typeRepeatEveryCustom, String totalCycles, String relatedTo,
                             String typeRelatedTo, String assignee, String follower, String tag, int flag) throws InterruptedException, AWTException {
        Actions actions = new Actions(driver);
        Robot robot = new Robot();
        //checkbox
        if (flag == 1) {
            actions.click(driver.findElement(By.xpath(LocatorTaskPage.checkboxPublic))).perform();
            Thread.sleep(500);
        }
        if (flag == 0) {
            actions.click(driver.findElement(By.xpath(LocatorTaskPage.checkboxBillable))).perform();
            Thread.sleep(500);
        }

        //input
        actions.sendKeys(driver.findElement(By.xpath(LocatorTaskPage.inputSubject)), subject).perform();
        Thread.sleep(500);

        WebElement elementHourlyRate = driver.findElement(By.xpath(LocatorTaskPage.inputHourlyRate));
        actions.click(elementHourlyRate).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
        actions.sendKeys(elementHourlyRate, hourlyRate).perform();
        Thread.sleep(500);

        WebElement elementStartDate = driver.findElement(By.xpath(LocatorTaskPage.inputStartDate));
        actions.click(elementStartDate).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
        actions.sendKeys(elementStartDate, startDate).perform();
        Thread.sleep(500);

        WebElement elementDueDate = driver.findElement(By.xpath(LocatorTaskPage.inputDueDate));
        actions.click(elementDueDate).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
        actions.sendKeys(elementDueDate, dueDate).perform();
        Thread.sleep(500);

        //Priority
        actions.click(driver.findElement(By.xpath(LocatorTaskPage.dropdownPriority))).perform();
        Thread.sleep(500);
        actions.click(driver.findElement(By.xpath(LocatorTaskPage.getValuePriority(priority)))).perform();
        Thread.sleep(1000);

        //Repeat every
        actions.click(driver.findElement(By.xpath(LocatorTaskPage.dropdownRepeatEvery))).perform();
        Thread.sleep(1000);
        actions.click(driver.findElement(By.xpath(LocatorTaskPage.getValueRepeatEvery(repeatEvery)))).perform();
        Thread.sleep(500);
        if (repeatEvery.equals("Custom")) {
            WebElement elementRepeatEveryCustom = driver.findElement(By.xpath(LocatorTaskPage.inputRepeatEveryCustom));
            actions.click(elementRepeatEveryCustom).perform();
            actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
            actions.sendKeys(elementRepeatEveryCustom, numberRepeatEveryCustom).perform();
            Thread.sleep(500);
            actions.click(driver.findElement(By.xpath(LocatorTaskPage.dropdownRepeatEveryCustom))).perform();
            Thread.sleep(1000);
            actions.click(driver.findElement(By.xpath(LocatorTaskPage.getValueRepeatEveryCustom(typeRepeatEveryCustom)))).perform();
            Thread.sleep(500);
        } else if (repeatEvery.equals("Week") || repeatEvery.equals("2 Weeks")
                || repeatEvery.equals("1 Months") || repeatEvery.equals("2 Months") || repeatEvery.equals("3 Months") || repeatEvery.equals("6 Months")
                || repeatEvery.equals("1 Year")) {
            actions.click(driver.findElement(By.xpath(LocatorTaskPage.checkboxInfinity))).perform();
            Thread.sleep(500);

            WebElement elementTotalCycles = driver.findElement(By.xpath(LocatorTaskPage.inputTotalCycles));
            actions.click(elementTotalCycles).perform();
            actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
            actions.sendKeys(elementTotalCycles, totalCycles).perform();
            Thread.sleep(500);
        } else {
            System.out.println("Không tồn tại Type Repeat Every đã nhập");
        }

        //Related To
        actions.click(driver.findElement(By.xpath(LocatorTaskPage.dropdownRelatedTo))).perform();
        Thread.sleep(1000);
        actions.click(driver.findElement(By.xpath(LocatorTaskPage.getValueRelatedTo(relatedTo)))).perform();
        Thread.sleep(500);
        actions.click(driver.findElement(By.xpath(LocatorTaskPage.dropdownTypeRelatedTo))).perform();
        Thread.sleep(500);
        actions.sendKeys(driver.findElement(By.xpath(LocatorTaskPage.inputSearchTypeRelatedTo)), typeRelatedTo).perform();
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(1000);
        actions.click(driver.findElement(By.xpath(LocatorTaskPage.getValueTypeRelatedTo(typeRelatedTo)))).perform();
        Thread.sleep(500);

        //Assignees
        actions.click(driver.findElement(By.xpath(LocatorTaskPage.dropdownAssignees))).perform();
        Thread.sleep(500);
        actions.sendKeys(driver.findElement(By.xpath(LocatorTaskPage.inputSearchAssignees)), assignee).perform();
        Thread.sleep(1000);
        actions.click(driver.findElement(By.xpath(LocatorTaskPage.getValueAssignees(assignee)))).perform();
        Thread.sleep(500);

        //Followers
        actions.click(driver.findElement(By.xpath(LocatorTaskPage.dropdownFollowers))).perform();
        Thread.sleep(500);
        actions.sendKeys(driver.findElement(By.xpath(LocatorTaskPage.inputSearchFollowers)), follower).perform();
        Thread.sleep(1000);
        actions.click(driver.findElement(By.xpath(LocatorTaskPage.getValueFollowers(follower)))).perform();
        Thread.sleep(1000);
        actions.click(driver.findElement(By.xpath(LocatorTaskPage.dropdownFollowers))).perform();
        Thread.sleep(500);

        //input
        actions.sendKeys(driver.findElement(By.xpath(LocatorTaskPage.inputTags)), tag).perform();
        Thread.sleep(500);
        actions.click(driver.findElement(By.xpath(LocatorTaskPage.labelTags))).perform();
        actions.click(driver.findElement(By.xpath(LocatorTaskPage.labelTags))).perform();
        Thread.sleep(500);
    }

    @Test
    public void testAddNewTaskAndVerify() throws InterruptedException, AWTException {
        String hourlyRate = "8";

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        // Ngày bắt đầu (hôm nay)
        Date start = new Date();
        // Cộng thêm 6 ngày
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        cal.add(Calendar.DAY_OF_MONTH, 6);

        String startDate = sdf.format(start);
        String dueDate = sdf.format(cal.getTime());
        String priority = "High";
        String repeatEvery = "Week";
        String numberRepeatEveryCustom = "5";
        String typeRepeatEveryCutom = "Week(s)";
        String totalCycles = "6";
        String relateTo = "Lead";
        String typeRelateTo = "Giang Chan";
        String assignee = "Admin Anh Tester";
        String follower = "Admin Example";
        String tag = "htest";
        int flag = 0;
        String taskName = "[htest]task" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());

        clickMenuTask();
        clickButtonNewTask();
        fillDataNewTask(taskName, hourlyRate, startDate, dueDate, priority, repeatEvery, numberRepeatEveryCustom,
                typeRepeatEveryCutom, totalCycles, relateTo, typeRelateTo, assignee, follower, tag, flag);
        clickButtonSave();
        clickClosePopupTaskDetail(taskName);
        searchAndCheckTask(taskName);
        clickButtonEdit(taskName);
        verifyNewTaskInTaskEdit(taskName, taskName, hourlyRate, startDate, dueDate, priority, repeatEvery,
                numberRepeatEveryCustom, typeRepeatEveryCutom, totalCycles, relateTo, typeRelateTo, tag, flag);
    }
}
