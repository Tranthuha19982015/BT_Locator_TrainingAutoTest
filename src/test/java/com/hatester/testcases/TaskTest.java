package com.hatester.testcases;

import com.hatester.pages.DashboardPage;
import com.hatester.pages.LoginPage;
import com.hatester.pages.TaskPage;
import com.hatester.common.BaseTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TaskTest extends BaseTest {
    String taskName = "A[htest]task add" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date()),
            hourlyRate = "8.00",
            startDate = "08-12-2025",
            dueDate = "12-12-2025",
            priority = "High",
            repeatEvery = "Week",
            numberRepeatEveryCustom = "5",
            typeRepeatEveryCutom = "Week(s)",
            totalCycles = "6",
            relateTo = "Lead",
            typeRelateTo = "Giang Chan",
            assignee = "Admin Anh Tester",
            follower = "Admin Example",
            tag = "htest",
            description = "htest switch to frame description";
    int flag = 0;


    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private TaskPage taskPage;

    @Test
    public void testAddNewTask() throws InterruptedException, AWTException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        // Ngày bắt đầu (hôm nay)
        Date start = new Date();
        // Cộng thêm 6 ngày
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        cal.add(Calendar.DAY_OF_MONTH, 6);
        startDate = sdf.format(start);
        dueDate = sdf.format(cal.getTime());

        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        taskPage = dashboardPage.clickMenuTask();
        taskPage.verifyTaskPageDisplayed();
        taskPage.clickButtonNewTask();
        taskPage.fillDataNewTask(taskName, hourlyRate, startDate, dueDate, priority, repeatEvery,
                numberRepeatEveryCustom, typeRepeatEveryCutom, totalCycles, relateTo, typeRelateTo,
                assignee, follower, tag, description, flag);
        taskPage.clickButtonSave();
        taskPage.verifyAddTaskSuccessMessage();
        taskPage.clickIconCloseAddTaskMessage();
        taskPage.clickClosePopupTaskDetail(taskName, 0);
        taskPage.searchAndCheckTask(taskName);
        taskPage.clickButtonEdit(taskName);
        taskPage.verifyNewTaskInTaskEdit(taskName, taskName, hourlyRate, startDate, dueDate, priority,
                repeatEvery, numberRepeatEveryCustom, typeRepeatEveryCutom, totalCycles, relateTo,
                typeRelateTo, tag, description, flag);
    }

    @Test
    public void testEditTask() throws InterruptedException, AWTException {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        taskPage = dashboardPage.clickMenuTask();

        taskPage.verifyTaskPageDisplayed();
        taskPage.clickButtonNewTask();
        taskPage.fillDataNewTask(taskName, hourlyRate, startDate, dueDate, priority, repeatEvery,
                numberRepeatEveryCustom, typeRepeatEveryCutom, totalCycles, relateTo, typeRelateTo,
                assignee, follower, tag, description, flag);
        taskPage.clickButtonSave();
        taskPage.verifyAddTaskSuccessMessage();
        taskPage.clickIconCloseAddTaskMessage();
        taskPage.clickClosePopupTaskDetail(taskName, 0);
        taskPage.searchAndCheckTask(taskName);
        taskPage.clickButtonEdit(taskName);
        taskPage.verifyNewTaskInTaskEdit(taskName, taskName, hourlyRate, startDate, dueDate, priority,
                repeatEvery, numberRepeatEveryCustom, typeRepeatEveryCutom, totalCycles, relateTo,
                typeRelateTo, tag, description, flag);

        TaskTest taskEdit = new TaskTest();
        taskEdit.taskName = "A[htest]task edit" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        // Ngày bắt đầu (hôm nay)
        Date start = new Date();
        // Cộng thêm 6 ngày
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        cal.add(Calendar.DAY_OF_MONTH, 3);
        taskEdit.startDate = sdf.format(start);
        taskEdit.dueDate = sdf.format(cal.getTime());

        taskEdit.priority = "Medium";
        taskEdit.repeatEvery = "1 Month";
        taskEdit.totalCycles = "3";
        taskEdit.typeRelateTo = "[htest]lead";
        taskEdit.flag = 1;

        taskPage.fillDataEdit(taskEdit.taskName, hourlyRate, taskEdit.startDate, taskEdit.dueDate, taskEdit.priority, taskEdit.repeatEvery,
                numberRepeatEveryCustom, typeRepeatEveryCutom, taskEdit.totalCycles, taskEdit.relateTo,
                typeRelateTo, assignee, follower, taskEdit.tag, description, flag);
        taskPage.clickButtonSave();
        taskPage.verifyUpdateTaskSuccessMessage();
        taskPage.clickIconCloseUpdateTaskMessage();
        taskPage.clickClosePopupTaskDetail(taskEdit.taskName, 1);
        taskPage.searchAndCheckTask(taskEdit.taskName);
    }

    @Test
    public void testDeleteTask() throws InterruptedException, AWTException {
        TaskTest taskDelete = new TaskTest();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        // Ngày bắt đầu (hôm nay)
        Date start = new Date();
        // Cộng thêm 6 ngày
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        cal.add(Calendar.DAY_OF_MONTH, 6);
        startDate = sdf.format(start);
        dueDate = sdf.format(cal.getTime());

        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        taskPage = dashboardPage.clickMenuTask();

        taskPage.verifyTaskPageDisplayed();
        taskPage.clickButtonNewTask();
        taskPage.fillDataNewTask(taskName, hourlyRate, startDate, dueDate, priority, repeatEvery,
                numberRepeatEveryCustom, typeRepeatEveryCutom, totalCycles, relateTo, typeRelateTo,
                assignee, follower, tag, description, flag);
        taskPage.clickButtonSave();
        taskPage.verifyAddTaskSuccessMessage();
        taskPage.clickIconCloseAddTaskMessage();
        taskPage.clickClosePopupTaskDetail(taskName, 0);
        taskPage.searchAndCheckTask(taskName);
        taskPage.clickButtonDelete(taskName);
        taskPage.confirmAlertDelete(1);
        taskPage.verifyDeleteTaskSuccessMessage(1);
        taskPage.clickIconCloseDeleteTaskMessage(1);
        taskPage.verifyAfterDeleteTask(taskName, 1);
    }
}
