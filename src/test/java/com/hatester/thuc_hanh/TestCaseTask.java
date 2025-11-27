package com.hatester.thuc_hanh;

import com.hatester.bt_locators.LocatorLeadPage;
import com.hatester.bt_locators.LocatorTaskPage;
import com.hatester.keywords.WebUI;
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
    String taskName;
    String hourlyRate;
    String startDate;
    String dueDate;
    String priority;
    String repeatEvery;
    String numberRepeatEveryCustom;
    String typeRepeatEveryCutom;
    String totalCycles;
    String relateTo;
    String typeRelateTo;
    String assignee;
    String follower;
    String tag;
    int flag;
    String description;

    public void clickMenuTask() throws InterruptedException {
        driver.findElement(By.xpath(LocatorTaskPage.menuTasks)).click();
        Thread.sleep(2000);

        Assert.assertTrue(WebUI.checkExistsElement(driver, LocatorTaskPage.headerTasksSummary), "Không mở được Menu Task");
    }

    public void clickButtonNewTask() throws InterruptedException {
        driver.findElement(By.xpath(LocatorTaskPage.buttonNewTask)).click();
        Thread.sleep(1000);

        Assert.assertTrue(WebUI.checkExistsElement(driver, LocatorTaskPage.headerAddNewTask), "Không mở được pop-up Add Task");
    }

    public void fillDataNewTask(String subject, String hourlyRate, String startDate, String dueDate, String priority, String repeatEvery,
                                String numberRepeatEveryCustom, String typeRepeatEveryCustom, String totalCycles, String relatedTo,
                                String typeRelatedTo, String assignee, String follower, String tag, String description, int flag)
            throws InterruptedException, AWTException {
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
        driver.findElement(By.xpath(LocatorTaskPage.inputTags)).sendKeys(tag, Keys.ENTER);
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorTaskPage.labelTags)).click();
        driver.findElement(By.xpath(LocatorTaskPage.labelTags)).click();
        Thread.sleep(1000);

        //iframe
        driver.findElement(By.xpath(LocatorTaskPage.inputDescription)).click();
        Thread.sleep(500);
        driver.switchTo().frame(driver.findElement(By.xpath(LocatorTaskPage.iframeDescription)));
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorTaskPage.inputDescriptionFrame)).sendKeys(description);
        Thread.sleep(500);
        driver.switchTo().parentFrame();
        Thread.sleep(500);
    }

    public void clickButtonSave() throws InterruptedException {
        driver.findElement(By.xpath(LocatorTaskPage.buttonSave)).click();
        Thread.sleep(2000);
    }

    public void clickClosePopupTaskDetail(String taskName) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(LocatorTaskPage.iconClosePopupTaskDetail(taskName))));
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorTaskPage.iconClosePopupTaskDetail(taskName))).click();
        Thread.sleep(1000);
    }


    public void searchAndCheckTask(String taskName) throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorTaskPage.inputSearchTasks)).sendKeys(taskName);
        Thread.sleep(1000);

        Assert.assertTrue(WebUI.checkExistsElement(driver, LocatorTaskPage.getFirstRowItemTaskName(taskName)), "Không đúng giá trị vừa thêm mới");
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
                                        String relatedTo, String typeRelatedTo, String tag, String description, int flag) throws InterruptedException {
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
        Assert.assertFalse(WebUI.checkExistsElement(driver, LocatorTaskPage.dropdownAssignees), "Không đúng giá trị đã thêm mới");
        Assert.assertFalse(WebUI.checkExistsElement(driver, LocatorTaskPage.dropdownFollowers), "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorTaskPage.inputTagsEdit)).getAttribute("value").trim().toLowerCase(), tag,
                "Không đúng giá trị đã thêm mới");
        driver.switchTo().frame(driver.findElement(By.xpath(LocatorTaskPage.iframeDescription)));
        Assert.assertEquals(driver.findElement(By.xpath(LocatorTaskPage.inputDescriptionFrame)).getText().trim().toLowerCase(), description,
                "Không đúng giá trị đã thêm mới");
        driver.switchTo().parentFrame();
    }

    public void fillDataEdit(String subject, String hourlyRate, String startDate, String dueDate, String priority, String repeatEvery,
                             String numberRepeatEveryCustom, String typeRepeatEveryCustom, String totalCycles, String relatedTo,
                             String typeRelatedTo, String assignee, String follower, String tag, String description, int flag)
            throws InterruptedException, AWTException {
        Actions actions = new Actions(driver);
        Robot robot = new Robot();
        Thread.sleep(1500);
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
        WebElement elementSubject = driver.findElement(By.xpath(LocatorTaskPage.inputSubject));
        actions.click(elementSubject).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
        actions.sendKeys(elementSubject, subject).perform();
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
                || repeatEvery.equals("1 Month") || repeatEvery.equals("2 Months") || repeatEvery.equals("3 Months") || repeatEvery.equals("6 Months")
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
        Thread.sleep(2000);
        actions.moveToElement(driver.findElement(By.xpath(LocatorTaskPage.getValueTypeRelatedTo(typeRelatedTo)))).click().build().perform();
        Thread.sleep(500);

        //input
        actions.moveToElement(driver.findElement(By.xpath(LocatorTaskPage.iconCloseTag))).click().build().perform();
        actions.sendKeys(driver.findElement(By.xpath(LocatorTaskPage.inputTags)), tag).perform();
        Thread.sleep(500);
        actions.click(driver.findElement(By.xpath(LocatorTaskPage.labelTags))).perform();
        actions.click(driver.findElement(By.xpath(LocatorTaskPage.labelTags))).perform();
        Thread.sleep(500);

        //iframe
        actions.click(driver.findElement(By.xpath(LocatorTaskPage.inputDescription)));
        Thread.sleep(500);
        driver.switchTo().frame(driver.findElement(By.xpath(LocatorTaskPage.iframeDescription)));
        Thread.sleep(500);
        actions.sendKeys(driver.findElement(By.xpath(LocatorTaskPage.inputDescriptionFrame)), description);
        Thread.sleep(500);
        driver.switchTo().parentFrame();
        Thread.sleep(500);
    }

    public void clickButtonDelete(String taskName) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(LocatorTaskPage.getFirstRowItemTaskName(taskName)))).perform();
        driver.findElement(By.xpath(LocatorTaskPage.buttonDelete(taskName))).click();
    }

    public void confirmAcceptAlertDelete() throws InterruptedException {
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
    }

    public void confirmDismissAlertDelete() throws InterruptedException {
        Thread.sleep(1000);
        driver.switchTo().alert().dismiss();
    }

    public void verifyAfterDeleteLead(String taskName) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorTaskPage.inputSearchTasks)).sendKeys(taskName);
        Thread.sleep(1000);
        Assert.assertFalse(WebUI.checkExistsElement(driver, LocatorTaskPage.getFirstRowItemTaskName(taskName)), "Xóa Task không thành công");
        Thread.sleep(1000);
    }

    @Test
    public void testAddNewTask() throws InterruptedException, AWTException {
        TestCaseTask taskAdd = new TestCaseTask();
        taskAdd.taskName = "A[htest]task add" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        taskAdd.hourlyRate = "8";

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        // Ngày bắt đầu (hôm nay)
        Date start = new Date();
        // Cộng thêm 6 ngày
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        cal.add(Calendar.DAY_OF_MONTH, 6);

        taskAdd.startDate = sdf.format(start);
        taskAdd.dueDate = sdf.format(cal.getTime());
        taskAdd.priority = "High";
        taskAdd.repeatEvery = "Week";
        taskAdd.numberRepeatEveryCustom = "5";
        taskAdd.typeRepeatEveryCutom = "Week(s)";
        taskAdd.totalCycles = "6";
        taskAdd.relateTo = "Lead";
        taskAdd.typeRelateTo = "Giang Chan";
        taskAdd.assignee = "Admin Anh Tester";
        taskAdd.follower = "Admin Example";
        taskAdd.tag = "htest";
        taskAdd.flag = 0;
        taskAdd.description = "htest switch to frame description";

        clickMenuTask();
        clickButtonNewTask();
        fillDataNewTask(taskAdd.taskName, taskAdd.hourlyRate, taskAdd.startDate, taskAdd.dueDate, taskAdd.priority, taskAdd.repeatEvery,
                taskAdd.numberRepeatEveryCustom, taskAdd.typeRepeatEveryCutom, taskAdd.totalCycles, taskAdd.relateTo, taskAdd.typeRelateTo,
                taskAdd.assignee, taskAdd.follower, taskAdd.tag, taskAdd.description, taskAdd.flag);
        clickButtonSave();
        clickClosePopupTaskDetail(taskAdd.taskName);
        searchAndCheckTask(taskAdd.taskName);
        clickButtonEdit(taskAdd.taskName);
        verifyNewTaskInTaskEdit(taskAdd.taskName, taskAdd.taskName, taskAdd.hourlyRate, taskAdd.startDate, taskAdd.dueDate, taskAdd.priority,
                taskAdd.repeatEvery, taskAdd.numberRepeatEveryCustom, taskAdd.typeRepeatEveryCutom, taskAdd.totalCycles, taskAdd.relateTo,
                taskAdd.typeRelateTo, taskAdd.tag, taskAdd.description, taskAdd.flag);
    }

    @Test
    public void testEditTask() throws InterruptedException, AWTException {
        TestCaseTask taskEdit = new TestCaseTask();
        taskEdit.taskName = "A[htest]task add" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        taskEdit.hourlyRate = "8";

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        // Ngày bắt đầu (hôm nay)
        Date start = new Date();
        // Cộng thêm 6 ngày
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        cal.add(Calendar.DAY_OF_MONTH, 6);

        taskEdit.startDate = sdf.format(start);
        taskEdit.dueDate = sdf.format(cal.getTime());
        taskEdit.priority = "High";
        taskEdit.repeatEvery = "Week";
        taskEdit.numberRepeatEveryCustom = "5";
        taskEdit.typeRepeatEveryCutom = "Week(s)";
        taskEdit.totalCycles = "6";
        taskEdit.relateTo = "Lead";
        taskEdit.typeRelateTo = "Giang Chan";
        taskEdit.assignee = "Admin Anh Tester";
        taskEdit.follower = "Admin Example";
        taskEdit.tag = "htest";
        taskEdit.flag = 0;
        taskEdit.description = "htest switch to frame description";

        clickMenuTask();
        clickButtonNewTask();
        fillDataNewTask(taskEdit.taskName, taskEdit.hourlyRate, taskEdit.startDate, taskEdit.dueDate, taskEdit.priority, taskEdit.repeatEvery,
                taskEdit.numberRepeatEveryCustom, taskEdit.typeRepeatEveryCutom, taskEdit.totalCycles, taskEdit.relateTo, taskEdit.typeRelateTo,
                taskEdit.assignee, taskEdit.follower, taskEdit.tag, taskEdit.description, taskEdit.flag);
        clickButtonSave();
        clickClosePopupTaskDetail(taskEdit.taskName);
        searchAndCheckTask(taskEdit.taskName);
        clickButtonEdit(taskEdit.taskName);
        verifyNewTaskInTaskEdit(taskEdit.taskName, taskEdit.taskName, taskEdit.hourlyRate, taskEdit.startDate, taskEdit.dueDate, taskEdit.priority,
                taskEdit.repeatEvery, taskEdit.numberRepeatEveryCustom, taskEdit.typeRepeatEveryCutom, taskEdit.totalCycles, taskEdit.relateTo,
                taskEdit.typeRelateTo, taskEdit.tag, taskEdit.description, taskEdit.flag);

        taskEdit.taskName = "A[htest]task edit" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        taskEdit.priority = "Medium";
        taskEdit.repeatEvery = "1 Month";
        taskEdit.totalCycles = "3";
        taskEdit.typeRelateTo = "[htest]lead";
        taskEdit.flag = 1;

        fillDataEdit(taskEdit.taskName, taskEdit.hourlyRate, taskEdit.startDate, taskEdit.dueDate, taskEdit.priority, taskEdit.repeatEvery,
                taskEdit.numberRepeatEveryCustom, taskEdit.typeRepeatEveryCutom, taskEdit.totalCycles, taskEdit.relateTo,
                taskEdit.typeRelateTo, taskEdit.assignee, taskEdit.follower, taskEdit.tag, taskEdit.description, taskEdit.flag);
        clickButtonSave();
        clickClosePopupTaskDetail(taskEdit.taskName);
        searchAndCheckTask(taskEdit.taskName);
    }

    @Test
    public void testDeleteTask() throws InterruptedException, AWTException {
        TestCaseTask taskDelete = new TestCaseTask();
        taskDelete.taskName = "A[htest]task add" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        taskDelete.hourlyRate = "8";

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        // Ngày bắt đầu (hôm nay)
        Date start = new Date();
        // Cộng thêm 6 ngày
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        cal.add(Calendar.DAY_OF_MONTH, 6);

        taskDelete.startDate = sdf.format(start);
        taskDelete.dueDate = sdf.format(cal.getTime());
        taskDelete.priority = "High";
        taskDelete.repeatEvery = "Week";
        taskDelete.numberRepeatEveryCustom = "5";
        taskDelete.typeRepeatEveryCutom = "Week(s)";
        taskDelete.totalCycles = "6";
        taskDelete.relateTo = "Lead";
        taskDelete.typeRelateTo = "Giang Chan";
        taskDelete.assignee = "Admin Anh Tester";
        taskDelete.follower = "Admin Example";
        taskDelete.tag = "htest";
        taskDelete.flag = 0;
        taskDelete.description = "htest switch to frame description";

        clickMenuTask();
        clickButtonNewTask();
        fillDataNewTask(taskDelete.taskName, taskDelete.hourlyRate, taskDelete.startDate, taskDelete.dueDate, taskDelete.priority, taskDelete.repeatEvery,
                taskDelete.numberRepeatEveryCustom, taskDelete.typeRepeatEveryCutom, taskDelete.totalCycles, taskDelete.relateTo, taskDelete.typeRelateTo,
                taskDelete.assignee, taskDelete.follower, taskDelete.tag, taskDelete.description, taskDelete.flag);
        clickButtonSave();
        clickClosePopupTaskDetail(taskDelete.taskName);
        searchAndCheckTask(taskDelete.taskName);
        clickButtonDelete(taskDelete.taskName);
        confirmAcceptAlertDelete();
        verifyAfterDeleteLead(taskDelete.taskName);
    }
}
