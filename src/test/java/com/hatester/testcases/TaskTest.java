package com.hatester.testcases;

import com.hatester.pages.DashboardPage;
import com.hatester.pages.LeadPage;
import com.hatester.pages.LoginPage;
import com.hatester.pages.TaskPage;
import com.hatester.common.BaseTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class TaskTest extends BaseTest {
    String taskName = "[htest]task add" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date()),
            hourlyRate = "8.00",
            startDate = "08-12-2025",
            dueDate = "12-12-2025",
            priority = "High",
            repeatEvery = "Week",
            numberRepeatEveryCustom = "5",
            typeRepeatEveryCutom = "Week(s)",
            totalCycles = "6",
            relateTo = "Lead",
            typeRelateTo = "[htest]lead",
            assignee = "Admin Anh Tester",
            follower = "Admin Example",
            tag = "htest",
            description = "htest switch to frame description";
    int flag = 0;

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private LeadPage leadPage;
    private TaskPage taskPage;

    @Test
    public void testAddNewTask() throws AWTException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        // Ngày bắt đầu (hôm nay)
        Date start = new Date();
        // Cộng thêm 6 ngày
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        cal.add(Calendar.DAY_OF_MONTH, 6);
        startDate = sdf.format(start);
        dueDate = sdf.format(cal.getTime());

        TaskTest taskTest = new TaskTest();
        taskTest.taskName = taskName + new Random().nextInt(1000);

        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        taskPage = dashboardPage.clickMenuTask();
        taskPage.verifyTaskPageDisplayed();
        taskPage.clickButtonNewTask();
        taskPage.fillDataNewTask(taskTest.taskName, hourlyRate, startDate, dueDate, priority, repeatEvery,
                numberRepeatEveryCustom, typeRepeatEveryCutom, totalCycles, relateTo, typeRelateTo,
                assignee, follower, tag, description, flag);
        taskPage.clickButtonSave();
        taskPage.verifyAddTaskSuccessMessage();
        taskPage.clickIconCloseAddTaskMessage();
        taskPage.clickClosePopupTaskDetail(taskTest.taskName, 0);
        taskPage.searchTask(taskTest.taskName);
        taskPage.verifyTaskExists(taskTest.taskName);
        taskPage.clickButtonEdit(taskTest.taskName);
        taskPage.verifyNewTaskInTaskEdit(taskTest.taskName, hourlyRate, startDate, dueDate, priority,
                repeatEvery, numberRepeatEveryCustom, typeRepeatEveryCutom, totalCycles, relateTo,
                typeRelateTo, tag, description, flag);
    }

    @Test
    public void testEditTask() throws InterruptedException, AWTException {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        taskPage = dashboardPage.clickMenuTask();

        TaskTest taskTest = new TaskTest();
        taskTest.taskName = taskName + new Random().nextInt(1000);
        taskPage.verifyTaskPageDisplayed();
        taskPage.clickButtonNewTask();
        taskPage.fillDataNewTask(taskTest.taskName, hourlyRate, startDate, dueDate, priority, repeatEvery,
                numberRepeatEveryCustom, typeRepeatEveryCutom, totalCycles, relateTo, typeRelateTo,
                assignee, follower, tag, description, flag);
        taskPage.clickButtonSave();
        taskPage.verifyAddTaskSuccessMessage();
        taskPage.clickIconCloseAddTaskMessage();
        taskPage.clickClosePopupTaskDetail(taskTest.taskName, 0);
        taskPage.searchTask(taskTest.taskName);
        taskPage.verifyTaskExists(taskTest.taskName);
        taskPage.clickButtonEdit(taskTest.taskName);
        taskPage.verifyNewTaskInTaskEdit(taskTest.taskName, hourlyRate, startDate, dueDate, priority,
                repeatEvery, numberRepeatEveryCustom, typeRepeatEveryCutom, totalCycles, relateTo,
                typeRelateTo, tag, description, flag);

        TaskTest taskEdit = new TaskTest();
        taskEdit.taskName = "[htest]task edit" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());

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
        taskPage.searchTask(taskEdit.taskName);
        taskPage.verifyTaskExists(taskEdit.taskName);
    }

    @Test
    public void testDeleteTask() throws AWTException {
        TaskTest taskTest = new TaskTest();
        taskTest.taskName = taskName + new Random().nextInt(1000);
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
        taskPage.fillDataNewTask(taskTest.taskName, hourlyRate, startDate, dueDate, priority, repeatEvery,
                numberRepeatEveryCustom, typeRepeatEveryCutom, totalCycles, relateTo, typeRelateTo,
                assignee, follower, tag, description, flag);
        taskPage.clickButtonSave();
        taskPage.verifyAddTaskSuccessMessage();
        taskPage.clickIconCloseAddTaskMessage();
        taskPage.clickClosePopupTaskDetail(taskTest.taskName, 0);
        taskPage.searchTask(taskTest.taskName);
        taskPage.verifyTaskExists(taskTest.taskName);
        taskPage.clickButtonDelete(taskTest.taskName);
        taskPage.confirmAlertDelete(1);
        taskPage.verifyDeleteTaskSuccessMessage(1);
        taskPage.clickIconCloseDeleteTaskMessage(1);
        taskPage.searchTask(taskTest.taskName);
        taskPage.verifyAfterDeleteTask(taskTest.taskName, 1);
    }

    @Test
    public void testLeadAndTaskManagementFlow() throws AWTException {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        leadPage = dashboardPage.clickMenuLead();

        LeadTest leadTest = new LeadTest();
        leadTest.leadName = leadTest.leadName + new Random().nextInt(1000);
        leadTest.emailAddress = leadTest.emailAddress + new Random().nextInt(1000) + "@gmail.com";
        leadPage.clickIconLeadsSummary();
        leadPage.verifyLeadSummaryDisplay();
        leadPage.clickButtonNewLead();
        leadPage.fillDataLead(leadTest.status, leadTest.source, leadTest.assigned, leadTest.tag, leadTest.leadName,
                leadTest.position, leadTest.city, leadTest.emailAddress, leadTest.state, leadTest.website, leadTest.country,
                leadTest.phone, leadTest.zipCode, leadTest.leadValue, leadTest.language, leadTest.company,
                leadTest.description, leadTest.lastContacted, leadTest.flag, leadTest.flagEdit);
        leadPage.clickButtonSave();
        leadPage.verifyAddLeadSuccessMessage();
        leadPage.clickIconClosePopupLeadDetail(leadTest.leadName, 0);
        leadPage.searchAndCheckLeads(leadTest.leadName);
        leadPage.clickButtonEdit(leadTest.leadName);
        leadPage.verifyNewLeadInEditPopup(leadTest.leadName, leadTest.status, leadTest.source, leadTest.assigned, leadTest.tag,
                leadTest.leadName, leadTest.position, leadTest.city, leadTest.emailAddress, leadTest.state, leadTest.website,
                leadTest.country, leadTest.phone, leadTest.zipCode, leadTest.leadValue + ".00",
                leadTest.language, leadTest.company, leadTest.description, leadTest.lastContacted);

        LeadTest leadEdit = new LeadTest();
        leadEdit.leadName = "[htest]lead edit" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        leadEdit.source = "Google";
        leadEdit.assigned = "Example";
        leadEdit.tag += "edit" + new SimpleDateFormat("HHmmss").format(new Date());
        leadEdit.phone = "0965898980";
        leadEdit.zipCode += "1";
        leadEdit.leadValue += "6";
        leadEdit.description = "htest edit new lead";
        leadEdit.lastContacted = "24-11-2025";
        leadEdit.flag = 0;
        leadEdit.flagEdit = 1;

        leadPage.fillDataLead(leadTest.status, leadEdit.source, leadEdit.assigned, leadEdit.tag, leadEdit.leadName,
                leadTest.position, leadTest.city, leadTest.emailAddress, leadTest.state, leadTest.website, leadTest.country,
                leadEdit.phone, leadEdit.zipCode, leadEdit.leadValue, leadTest.language, leadTest.company,
                leadEdit.description, leadEdit.lastContacted, leadEdit.flag, leadEdit.flagEdit);
        leadPage.clickButtonSave();
        leadPage.verifyUpdateLeadSuccessMessage();
        leadPage.clickIconClosePopupLeadDetail(leadEdit.leadName, 1);
        leadPage.searchAndCheckLeads(leadEdit.leadName);

        taskPage = leadPage.clickMenuTask();
        TaskTest taskTest = new TaskTest();
        taskTest.taskName = taskName + new Random().nextInt(1000);
        taskTest.typeRelateTo = leadEdit.leadName;
        taskPage.verifyTaskPageDisplayed();
        taskPage.clickButtonNewTask();
        taskPage.fillDataNewTask(taskTest.taskName, hourlyRate, startDate, dueDate, priority, repeatEvery,
                numberRepeatEveryCustom, typeRepeatEveryCutom, totalCycles, relateTo, taskTest.typeRelateTo,
                assignee, follower, tag, description, flag);
        taskPage.clickButtonSave();
        taskPage.verifyAddTaskSuccessMessage();
        taskPage.clickIconCloseAddTaskMessage();
        taskPage.clickClosePopupTaskDetail(taskTest.taskName, 0);
        taskPage.searchTask(taskTest.taskName);
        taskPage.verifyTaskExists(taskTest.taskName);
        taskPage.clickButtonEdit(taskTest.taskName);
        taskPage.verifyNewTaskInTaskEdit(taskTest.taskName, hourlyRate, startDate, dueDate, priority,
                repeatEvery, numberRepeatEveryCustom, typeRepeatEveryCutom, totalCycles, relateTo,
                typeRelateTo, tag, description, flag);

        TaskTest taskEdit = new TaskTest();
        taskEdit.taskName = "[htest]task edit" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());

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
        taskEdit.flag = 1;

        taskPage.fillDataEdit(taskEdit.taskName, hourlyRate, taskEdit.startDate, taskEdit.dueDate, taskEdit.priority, taskEdit.repeatEvery,
                numberRepeatEveryCustom, typeRepeatEveryCutom, taskEdit.totalCycles, taskEdit.relateTo,
                taskTest.typeRelateTo, assignee, follower, taskEdit.tag, description, flag);
        taskPage.clickButtonSave();
        taskPage.verifyUpdateTaskSuccessMessage();
        taskPage.clickIconCloseUpdateTaskMessage();
        taskPage.clickClosePopupTaskDetail(taskEdit.taskName, 1);
        taskPage.searchTask(taskEdit.taskName);
        taskPage.verifyTaskExists(taskEdit.taskName);
    }
}
