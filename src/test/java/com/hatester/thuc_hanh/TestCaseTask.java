package com.hatester.thuc_hanh;

import com.hatester.bt_locators.LocatorTaskPage;
import com.hatester.keywords.WebUI;
import common.BaseTest;
import org.openqa.selenium.By;
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
        WebUI.clickElement(driver, LocatorTaskPage.menuTasks);
//        Thread.sleep(2000);

        Assert.assertTrue(WebUI.checkExistsElement(driver, LocatorTaskPage.headerTasksSummary), "Không mở được Menu Task");
    }

    public void clickButtonNewTask() throws InterruptedException {
        WebUI.clickElement(driver, LocatorTaskPage.buttonNewTask);
//        Thread.sleep(1000);

        Assert.assertTrue(WebUI.checkExistsElement(driver, LocatorTaskPage.headerAddNewTask), "Không mở được pop-up Add Task");
    }

    public void fillDataNewTask(String subject, String hourlyRate, String startDate, String dueDate, String priority, String repeatEvery,
                                String numberRepeatEveryCustom, String typeRepeatEveryCustom, String totalCycles, String relatedTo,
                                String typeRelatedTo, String assignee, String follower, String tag, String description, int flag)
            throws InterruptedException, AWTException {
        //checkbox
        if (flag == 1) {
            WebUI.clickElement(driver, LocatorTaskPage.labelCheckboxPublic);
        }
        if (flag == 0) {
            WebUI.clickElement(driver, LocatorTaskPage.labelCheckboxBillable);
        }

        //input
        WebUI.setTextElement(driver, LocatorTaskPage.inputSubject, subject);
        WebUI.clearTextElement(driver, LocatorTaskPage.inputHourlyRate);
        WebUI.setTextElement(driver, LocatorTaskPage.inputHourlyRate, hourlyRate);
        WebUI.clearTextElement(driver, LocatorTaskPage.inputStartDate);
        WebUI.setTextElement(driver, LocatorTaskPage.inputStartDate, startDate);
        WebUI.clickElement(driver, LocatorTaskPage.headerAddNewTask);
        WebUI.clearTextElement(driver, LocatorTaskPage.inputDueDate);
        WebUI.setTextElement(driver, LocatorTaskPage.inputDueDate, dueDate);
        WebUI.clickElement(driver, LocatorTaskPage.headerAddNewTask);

        //Priority
        WebUI.clickElement(driver, LocatorTaskPage.dropdownPriority);
        WebUI.clickElement(driver, LocatorTaskPage.getValuePriority(priority));

        //Repeat every
        WebUI.clickElement(driver, LocatorTaskPage.dropdownRepeatEvery);
        WebUI.clickElement(driver, LocatorTaskPage.getValueRepeatEvery(repeatEvery));
        if (repeatEvery.equals("Custom")) {
            WebUI.clearTextElement(driver, LocatorTaskPage.inputRepeatEveryCustom);
            WebUI.setTextElement(driver, LocatorTaskPage.inputRepeatEveryCustom, numberRepeatEveryCustom);
            WebUI.clickElement(driver, LocatorTaskPage.dropdownRepeatEveryCustom);
            WebUI.clickElement(driver, LocatorTaskPage.getValueRepeatEveryCustom(typeRepeatEveryCustom));
        } else if (repeatEvery.equals("Week") || repeatEvery.equals("2 Weeks")
                || repeatEvery.equals("1 Months") || repeatEvery.equals("2 Months") || repeatEvery.equals("3 Months") || repeatEvery.equals("6 Months")
                || repeatEvery.equals("1 Year")) {
            WebUI.clickElement(driver, LocatorTaskPage.checkboxInfinity);
            WebUI.clearTextElement(driver, LocatorTaskPage.inputTotalCycles);
            WebUI.setTextElement(driver, LocatorTaskPage.inputTotalCycles, totalCycles);
        } else {
            System.out.println("Không tồn tại Type Repeat Every đã nhập");
        }

        WebUI.scrollAtBottom(driver, LocatorTaskPage.buttonSave);
        //Related To
        WebUI.clickElement(driver, LocatorTaskPage.dropdownRelatedTo);
        WebUI.clickElement(driver, LocatorTaskPage.getValueRelatedTo(relatedTo));
        WebUI.clickElement(driver, LocatorTaskPage.dropdownTypeRelatedTo);
        WebUI.setTextElement(driver, LocatorTaskPage.inputSearchTypeRelatedTo, typeRelatedTo);
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.click(WebUI.getWebElement(driver, LocatorTaskPage.inputSearchTypeRelatedTo)).sendKeys(" ").build().perform();
        WebUI.clickElement(driver, LocatorTaskPage.getValueTypeRelatedTo(typeRelatedTo));

        //Assignees
        WebUI.clickElement(driver, LocatorTaskPage.dropdownAssignees);
        WebUI.setTextElement(driver, LocatorTaskPage.inputSearchAssignees, assignee);
        WebUI.clickElement(driver, LocatorTaskPage.getValueAssignees(assignee));

        //Followers
        WebUI.clickElement(driver, LocatorTaskPage.dropdownFollowers);
        WebUI.setTextElement(driver, LocatorTaskPage.inputSearchFollowers, follower);
        WebUI.clickElement(driver, LocatorTaskPage.getValueFollowers(follower));
        WebUI.clickElement(driver, LocatorTaskPage.dropdownFollowers);

        //input
        WebUI.setTextAndKeyElement(driver, LocatorTaskPage.inputTags, tag, Keys.ENTER);
        WebUI.clickElement(driver, LocatorTaskPage.labelTags);
        WebUI.clickElement(driver, LocatorTaskPage.labelTags);

        //iframe
        WebUI.clickElement(driver, LocatorTaskPage.inputDescription);
        WebUI.switchToFrame(driver, LocatorTaskPage.iframeDescription);
        WebUI.setTextElement(driver, LocatorTaskPage.inputDescriptionFrame, description);
        WebUI.switchToParentFrame(driver);
    }

    public void clickButtonSave() throws InterruptedException {
        WebUI.clickElement(driver, LocatorTaskPage.buttonSave);
        Thread.sleep(1000);
    }

    public void clickClosePopupTaskDetail(String taskName) throws InterruptedException {
        WebUI.scrollAtTop(driver, LocatorTaskPage.iconClosePopupTaskDetail(taskName));
        WebUI.clickElement(driver, LocatorTaskPage.iconClosePopupTaskDetail(taskName));
        Thread.sleep(1000);
    }


    public void searchAndCheckTask(String taskName) throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(1000);
        WebUI.setTextElement(driver, LocatorTaskPage.inputSearchTasks, taskName);
        Thread.sleep(1000);

        Assert.assertTrue(WebUI.checkExistsElement(driver, LocatorTaskPage.getFirstRowItemTaskName(taskName)), "Không đúng giá trị vừa thêm mới");
    }

    public void clickButtonEdit(String taskName) throws InterruptedException {
        Thread.sleep(500);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(LocatorTaskPage.getFirstRowItemTaskName(taskName))).perform();
        Thread.sleep(500);
        WebUI.clickElement(driver, LocatorTaskPage.buttonEdit(taskName));
        Thread.sleep(500);
    }

    public void verifyNewTaskInTaskEdit(String taskName, String subject, String hourlyRate, String startDate, String dueDate, String priority,
                                        String repeatEvery, String numberRepeatEveryCustom, String typeRepeatEveryCustom, String totalCycles,
                                        String relatedTo, String typeRelatedTo, String tag, String description, int flag) throws InterruptedException {
        if (flag == 1) {
            Assert.assertTrue(WebUI.checkSeletedElement(driver, LocatorTaskPage.checkboxPublic), "Checkbox không được chọn");
            Assert.assertTrue(WebUI.checkSeletedElement(driver, LocatorTaskPage.checkboxBillable), "Checkbox không được chọn");
        }
        if (flag == 0) {
            Assert.assertFalse(WebUI.checkSeletedElement(driver, LocatorTaskPage.checkboxPublic), "Checkbox được tích chọn");
            Assert.assertFalse(WebUI.checkSeletedElement(driver, LocatorTaskPage.checkboxBillable), "Checkbox được tích chọn");
        }
        Assert.assertEquals(WebUI.getElementAttribute(driver, LocatorTaskPage.inputSubject, "value").trim(),
                subject, "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementAttribute(driver, LocatorTaskPage.inputStartDate, "value").trim(),
                startDate, "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementAttribute(driver, LocatorTaskPage.inputDueDate, "value").trim(),
                dueDate, "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementText(driver, LocatorTaskPage.dropdownPriority).trim(),
                priority, "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementText(driver, LocatorTaskPage.dropdownRepeatEvery).trim(),
                repeatEvery, "Không đúng giá trị đã thêm mới");
        if (repeatEvery.equals("Custom")) {
            Assert.assertEquals(WebUI.getElementAttribute(driver, LocatorTaskPage.inputRepeatEveryCustom, "value").trim(),
                    numberRepeatEveryCustom, "Không đúng giá trị đã thêm mới");
            Assert.assertEquals(WebUI.getElementText(driver, LocatorTaskPage.dropdownRepeatEveryCustom).trim(),
                    typeRepeatEveryCustom, "Không đúng giá trị đã thêm mới");
        } else if (repeatEvery.equals("Week") || repeatEvery.equals("2 Weeks")
                || repeatEvery.equals("1 Months") || repeatEvery.equals("2 Months") || repeatEvery.equals("3 Months") || repeatEvery.equals("6 Months")
                || repeatEvery.equals("1 Year")) {
            Assert.assertFalse(WebUI.checkSeletedElement(driver, LocatorTaskPage.checkboxInfinity), "Checkbox không được chọn");
            Assert.assertEquals(WebUI.getElementAttribute(driver, LocatorTaskPage.inputTotalCycles, "value").trim(),
                    totalCycles, "Không đúng giá trị đã thêm mới");
        } else {
            System.out.println("Không tồn tại Type Repeat Every đã nhập");
        }
        Assert.assertEquals(WebUI.getElementText(driver, LocatorTaskPage.dropdownRelatedTo).trim(), relatedTo,
                "Không đúng giá trị đã thêm mới");
        boolean containsTypeRelatedTo = WebUI.getElementText(driver, LocatorTaskPage.dropdownTypeRelatedTo).contains(typeRelatedTo);
        Assert.assertTrue(containsTypeRelatedTo, "Không đúng giá trị đã thêm mới");
        Assert.assertFalse(WebUI.checkExistsElement(driver, LocatorTaskPage.dropdownAssignees), "Không đúng giá trị đã thêm mới");
        Assert.assertFalse(WebUI.checkExistsElement(driver, LocatorTaskPage.dropdownFollowers), "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementText(driver, LocatorTaskPage.inputTagsEdit).trim().toLowerCase(), tag,
                "Không đúng giá trị đã thêm mới");
        WebUI.switchToFrame(driver, LocatorTaskPage.iframeDescription);
        Assert.assertEquals(WebUI.getElementText(driver, LocatorTaskPage.inputDescriptionFrame).trim().toLowerCase(), description,
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
            actions.click(WebUI.getWebElement(driver, LocatorTaskPage.checkboxPublic)).perform();
            Thread.sleep(500);
        }
        if (flag == 0) {
            actions.click(WebUI.getWebElement(driver, LocatorTaskPage.checkboxBillable)).perform();
            Thread.sleep(500);
        }

        //input
        WebElement elementSubject = WebUI.getWebElement(driver, LocatorTaskPage.inputSubject);
        actions.click(elementSubject).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
        actions.sendKeys(elementSubject, subject).perform();
        Thread.sleep(500);

        WebElement elementHourlyRate = WebUI.getWebElement(driver, LocatorTaskPage.inputHourlyRate);
        actions.click(elementHourlyRate).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
        actions.sendKeys(elementHourlyRate, hourlyRate).perform();
        Thread.sleep(500);

        WebElement elementStartDate = WebUI.getWebElement(driver, LocatorTaskPage.inputStartDate);
        actions.click(elementStartDate).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
        actions.sendKeys(elementStartDate, startDate).perform();
        Thread.sleep(500);

        WebElement elementDueDate = WebUI.getWebElement(driver, LocatorTaskPage.inputDueDate);
        actions.click(elementDueDate).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
        actions.sendKeys(elementDueDate, dueDate).perform();
        Thread.sleep(500);

        //Priority
        actions.click(WebUI.getWebElement(driver, LocatorTaskPage.dropdownPriority)).perform();
        Thread.sleep(500);
        actions.click(WebUI.getWebElement(driver, LocatorTaskPage.getValuePriority(priority))).perform();
        Thread.sleep(1000);

        //Repeat every
        actions.click(WebUI.getWebElement(driver, LocatorTaskPage.dropdownRepeatEvery)).perform();
        Thread.sleep(1000);
        actions.click(WebUI.getWebElement(driver, LocatorTaskPage.getValueRepeatEvery(repeatEvery))).perform();
        Thread.sleep(500);
        if (repeatEvery.equals("Custom")) {
            WebElement elementRepeatEveryCustom = WebUI.getWebElement(driver, LocatorTaskPage.inputRepeatEveryCustom);
            actions.click(elementRepeatEveryCustom).perform();
            actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
            actions.sendKeys(elementRepeatEveryCustom, numberRepeatEveryCustom).perform();
            Thread.sleep(500);
            actions.click(WebUI.getWebElement(driver, LocatorTaskPage.dropdownRepeatEveryCustom)).perform();
            Thread.sleep(1000);
            actions.click(WebUI.getWebElement(driver, LocatorTaskPage.getValueRepeatEveryCustom(typeRepeatEveryCustom))).perform();
            Thread.sleep(500);
        } else if (repeatEvery.equals("Week") || repeatEvery.equals("2 Weeks")
                || repeatEvery.equals("1 Month") || repeatEvery.equals("2 Months") || repeatEvery.equals("3 Months") || repeatEvery.equals("6 Months")
                || repeatEvery.equals("1 Year")) {
            actions.click(WebUI.getWebElement(driver, LocatorTaskPage.checkboxInfinity)).perform();
            Thread.sleep(500);

            WebElement elementTotalCycles = WebUI.getWebElement(driver, LocatorTaskPage.inputTotalCycles);
            actions.click(elementTotalCycles).perform();
            actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
            actions.sendKeys(elementTotalCycles, totalCycles).perform();
            Thread.sleep(500);
        } else {
            System.out.println("Không tồn tại Type Repeat Every đã nhập");
        }

        WebUI.scrollAtBottom(driver,LocatorTaskPage.buttonSave);
        //Related To
        actions.click(WebUI.getWebElement(driver, LocatorTaskPage.dropdownRelatedTo)).perform();
        Thread.sleep(1000);
        actions.click(WebUI.getWebElement(driver, LocatorTaskPage.getValueRelatedTo(relatedTo))).perform();
        Thread.sleep(500);
        actions.click(WebUI.getWebElement(driver, LocatorTaskPage.dropdownTypeRelatedTo)).perform();
        Thread.sleep(500);
        actions.sendKeys(WebUI.getWebElement(driver, LocatorTaskPage.inputSearchTypeRelatedTo), typeRelatedTo).perform();
        Thread.sleep(1000);
        actions.moveToElement(WebUI.getWebElement(driver, LocatorTaskPage.getValueTypeRelatedTo(typeRelatedTo))).click().build().perform();
        Thread.sleep(500);

        //input
        actions.moveToElement(WebUI.getWebElement(driver, LocatorTaskPage.iconCloseTag)).click().build().perform();
        actions.sendKeys(WebUI.getWebElement(driver, LocatorTaskPage.inputTags), tag).perform();
        Thread.sleep(500);
        actions.click(WebUI.getWebElement(driver, LocatorTaskPage.labelTags)).perform();
        actions.click(WebUI.getWebElement(driver, LocatorTaskPage.labelTags)).perform();
        Thread.sleep(500);

        //iframe
        actions.click(WebUI.getWebElement(driver, LocatorTaskPage.inputDescription));
        WebUI.switchToFrame(driver, LocatorTaskPage.iframeDescription);
        Thread.sleep(500);
        actions.sendKeys(WebUI.getWebElement(driver, LocatorTaskPage.inputDescriptionFrame), description);
        Thread.sleep(500);
        WebUI.switchToParentFrame(driver);
        Thread.sleep(500);
    }

    public void clickButtonDelete(String taskName) {
        Actions action = new Actions(driver);
        action.moveToElement(WebUI.getWebElement(driver, LocatorTaskPage.getFirstRowItemTaskName(taskName))).perform();
        WebUI.clickElement(driver, LocatorTaskPage.buttonDelete(taskName));
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
        Thread.sleep(1000);
        WebUI.setTextElement(driver, LocatorTaskPage.inputSearchTasks, taskName);
        Assert.assertFalse(WebUI.checkExistsElement(driver, LocatorTaskPage.getFirstRowItemTaskName(taskName)), "Xóa Task không thành công");
        Thread.sleep(1000);
    }

    @Test
    public void testAddNewTask() throws InterruptedException, AWTException {
        TestCaseTask taskAdd = new TestCaseTask();
        taskAdd.taskName = "A[htest]task add" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        taskAdd.hourlyRate = "8.00";

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
