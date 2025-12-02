package com.hatester.testcases;

import com.hatester.pages.DashboardPage;
import com.hatester.pages.LoginPage;
import com.hatester.pages.TaskPage;
import com.hatester.keywords.WebUI;
import common.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TaskTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(TaskTest.class);
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

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private TaskPage taskPage;

    @Test
    public void testAddNewTask() throws InterruptedException, AWTException {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        taskPage = dashboardPage.clickMenuTask();

        TaskTest taskAdd = new TaskTest();
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

        taskPage.verifyMenuTaskDisplay();
        taskPage.clickButtonNewTask();
        taskPage.fillDataNewTask(taskAdd.taskName, taskAdd.hourlyRate, taskAdd.startDate, taskAdd.dueDate, taskAdd.priority, taskAdd.repeatEvery,
                taskAdd.numberRepeatEveryCustom, taskAdd.typeRepeatEveryCutom, taskAdd.totalCycles, taskAdd.relateTo, taskAdd.typeRelateTo,
                taskAdd.assignee, taskAdd.follower, taskAdd.tag, taskAdd.description, taskAdd.flag);
        taskPage.clickButtonSave();
        taskPage.clickClosePopupTaskDetail(taskAdd.taskName);
        taskPage.searchAndCheckTask(taskAdd.taskName);
        taskPage.clickButtonEdit(taskAdd.taskName);
        taskPage.verifyNewTaskInTaskEdit(taskAdd.taskName, taskAdd.taskName, taskAdd.hourlyRate, taskAdd.startDate, taskAdd.dueDate, taskAdd.priority,
                taskAdd.repeatEvery, taskAdd.numberRepeatEveryCustom, taskAdd.typeRepeatEveryCutom, taskAdd.totalCycles, taskAdd.relateTo,
                taskAdd.typeRelateTo, taskAdd.tag, taskAdd.description, taskAdd.flag);
    }

    @Test
    public void testEditTask() throws InterruptedException, AWTException {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        taskPage = dashboardPage.clickMenuTask();

        TaskTest taskEdit = new TaskTest();
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

        taskPage.verifyMenuTaskDisplay();
        taskPage.clickButtonNewTask();
        taskPage.fillDataNewTask(taskEdit.taskName, taskEdit.hourlyRate, taskEdit.startDate, taskEdit.dueDate, taskEdit.priority, taskEdit.repeatEvery,
                taskEdit.numberRepeatEveryCustom, taskEdit.typeRepeatEveryCutom, taskEdit.totalCycles, taskEdit.relateTo, taskEdit.typeRelateTo,
                taskEdit.assignee, taskEdit.follower, taskEdit.tag, taskEdit.description, taskEdit.flag);
        taskPage.clickButtonSave();
        taskPage.clickClosePopupTaskDetail(taskEdit.taskName);
        taskPage.searchAndCheckTask(taskEdit.taskName);
        taskPage.clickButtonEdit(taskEdit.taskName);
        taskPage.verifyNewTaskInTaskEdit(taskEdit.taskName, taskEdit.taskName, taskEdit.hourlyRate, taskEdit.startDate, taskEdit.dueDate, taskEdit.priority,
                taskEdit.repeatEvery, taskEdit.numberRepeatEveryCustom, taskEdit.typeRepeatEveryCutom, taskEdit.totalCycles, taskEdit.relateTo,
                taskEdit.typeRelateTo, taskEdit.tag, taskEdit.description, taskEdit.flag);

        taskEdit.taskName = "A[htest]task edit" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        taskEdit.priority = "Medium";
        taskEdit.repeatEvery = "1 Month";
        taskEdit.totalCycles = "3";
        taskEdit.typeRelateTo = "[htest]lead";
        taskEdit.flag = 1;

        taskPage.fillDataEdit(taskEdit.taskName, taskEdit.hourlyRate, taskEdit.startDate, taskEdit.dueDate, taskEdit.priority, taskEdit.repeatEvery,
                taskEdit.numberRepeatEveryCustom, taskEdit.typeRepeatEveryCutom, taskEdit.totalCycles, taskEdit.relateTo,
                taskEdit.typeRelateTo, taskEdit.assignee, taskEdit.follower, taskEdit.tag, taskEdit.description, taskEdit.flag);
        taskPage.clickButtonSave();
        taskPage.clickClosePopupTaskDetail(taskEdit.taskName);
        taskPage.searchAndCheckTask(taskEdit.taskName);
    }

    @Test
    public void testDeleteTask() throws InterruptedException, AWTException {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        taskPage = dashboardPage.clickMenuTask();

        TaskTest taskDelete = new TaskTest();
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

        taskPage.verifyMenuTaskDisplay();
        taskPage.clickButtonNewTask();
        taskPage.fillDataNewTask(taskDelete.taskName, taskDelete.hourlyRate, taskDelete.startDate, taskDelete.dueDate, taskDelete.priority, taskDelete.repeatEvery,
                taskDelete.numberRepeatEveryCustom, taskDelete.typeRepeatEveryCutom, taskDelete.totalCycles, taskDelete.relateTo, taskDelete.typeRelateTo,
                taskDelete.assignee, taskDelete.follower, taskDelete.tag, taskDelete.description, taskDelete.flag);
        taskPage.clickButtonSave();
        taskPage.clickClosePopupTaskDetail(taskDelete.taskName);
        taskPage.searchAndCheckTask(taskDelete.taskName);
        taskPage.clickButtonDelete(taskDelete.taskName);
        taskPage.confirmAcceptAlertDelete();
        taskPage.verifyAfterDeleteLead(taskDelete.taskName);
    }
}
