package com.hatester.testcases;

import com.hatester.helpers.ExcelHelper;
import com.hatester.models.LeadData;
import com.hatester.models.TaskData;
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
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private LeadPage leadPage;
    private TaskPage taskPage;

    TaskData getDataFromExcel(int rowIndex) {
        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile("src/test/resources/datatest/dataCRM.xlsx", "Tasks");

        TaskData taskData = new TaskData();
        taskData.setTaskName(excel.getCellData("TASK_NAME", rowIndex));
        taskData.setHourlyRate(excel.getCellData("HOURLY_RATE", rowIndex));
        taskData.setStartDate(excel.getCellData("START_DATE", rowIndex));
        taskData.setDueDate(excel.getCellData("DUE_DATE", rowIndex));
        taskData.setPriority(excel.getCellData("PRIORITY", rowIndex));
        taskData.setRepeatEvery(excel.getCellData("REPEAT_EVERY", rowIndex));
        taskData.setNumberRepeatEveryCustom(excel.getCellData("NUMBER_REPEAT_EVERY_CUSTOM", rowIndex));
        taskData.setTypeRepeatEveryCustom(excel.getCellData("TYPE_REPEAT_EVERY_CUSTOM", rowIndex));
        taskData.setTotalCycles(excel.getCellData("TOTAL_CYCLES", rowIndex));
        taskData.setRelateTo(excel.getCellData("RELATED_TO", rowIndex));
        taskData.setTypeRelateTo(excel.getCellData("TYPE_RELATED_TO", rowIndex));
        taskData.setAssignee(excel.getCellData("ASSIGNEE", rowIndex));
        taskData.setFollower(excel.getCellData("FOLLOWER", rowIndex));
        taskData.setTag(excel.getCellData("TAG", rowIndex));
        taskData.setDescription(excel.getCellData("DESCRIPTION", rowIndex));
        taskData.setFlagEdit(Integer.parseInt(excel.getCellData("FLAG_EDIT", rowIndex)));
        taskData.setTypeConfirm(Integer.parseInt(excel.getCellData("TYPE_CONFIRM", rowIndex)));

        return taskData;
    }

    @Test
    public void testAddNewTask() throws AWTException {
        TaskData taskData = getDataFromExcel(1);
        String dateTimeAdd = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        taskData.setTaskName(taskData.getTaskName() + dateTimeAdd);

        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        taskPage = dashboardPage.clickMenuTask();
        taskPage.verifyTaskPageDisplayed();
        taskPage.clickButtonNewTask();
        taskPage.fillDataNewTask(taskData);
        taskPage.clickButtonSave();
        taskPage.verifyAddTaskSuccessMessage();
        taskPage.clickIconCloseAddTaskMessage();
        taskPage.clickClosePopupTaskDetail(taskData.getTaskName(), taskData.getFlagEdit());
        taskPage.searchTask(taskData.getTaskName());
        taskPage.verifyTaskExists(taskData.getTaskName());
        taskPage.clickButtonEdit(taskData.getTaskName());
        taskPage.verifyNewTaskInTaskEdit(taskData);
    }

    @Test
    public void testEditTask() throws InterruptedException, AWTException {
        TaskData taskData = getDataFromExcel(1);
        String dateTimeAdd = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        taskData.setTaskName(taskData.getTaskName() + dateTimeAdd);

        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        taskPage = dashboardPage.clickMenuTask();
        taskPage.verifyTaskPageDisplayed();
        taskPage.clickButtonNewTask();
        taskPage.fillDataNewTask(taskData);
        taskPage.clickButtonSave();
        taskPage.verifyAddTaskSuccessMessage();
        taskPage.clickIconCloseAddTaskMessage();
        taskPage.clickClosePopupTaskDetail(taskData.getTaskName(), taskData.getFlagEdit());
        taskPage.searchTask(taskData.getTaskName());
        taskPage.verifyTaskExists(taskData.getTaskName());

        taskPage.clickButtonEdit(taskData.getTaskName());
        taskPage.verifyNewTaskInTaskEdit(taskData);

        TaskData taskDataEdit = getDataFromExcel(2);
        String dateTimeEdit = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        taskDataEdit.setTaskName(taskDataEdit.getTaskName() + dateTimeEdit);

        taskPage.fillDataEdit(taskDataEdit);
        taskPage.clickButtonSave();
        taskPage.verifyUpdateTaskSuccessMessage();
        taskPage.clickIconCloseUpdateTaskMessage();
        taskPage.clickClosePopupTaskDetail(taskDataEdit.getTaskName(), taskDataEdit.getFlagEdit());
        taskPage.searchTask(taskDataEdit.getTaskName());
        taskPage.verifyTaskExists(taskDataEdit.getTaskName());
    }

    @Test
    public void testDeleteTask() throws AWTException {
        TaskData taskData = getDataFromExcel(1);
        String dateTimeAdd = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        taskData.setTaskName(taskData.getTaskName() + dateTimeAdd);

        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        taskPage = dashboardPage.clickMenuTask();
        taskPage.verifyTaskPageDisplayed();
        taskPage.clickButtonNewTask();
        taskPage.fillDataNewTask(taskData);
        taskPage.clickButtonSave();
        taskPage.verifyAddTaskSuccessMessage();
        taskPage.clickIconCloseAddTaskMessage();
        taskPage.clickClosePopupTaskDetail(taskData.getTaskName(), taskData.getFlagEdit());
        taskPage.searchTask(taskData.getTaskName());
        taskPage.verifyTaskExists(taskData.getTaskName());

        taskPage.clickButtonDelete(taskData.getTaskName());
        taskPage.confirmAlertDelete(taskData.getTypeConfirm());
        taskPage.verifyDeleteTaskSuccessMessage(taskData.getTypeConfirm());
        taskPage.clickIconCloseDeleteTaskMessage(taskData.getTypeConfirm());
        taskPage.searchTask(taskData.getTaskName());
        taskPage.verifyAfterDeleteTask(taskData.getTaskName(), taskData.getTypeConfirm());
    }

    @Test
    public void testLeadAndTaskManagementFlow() throws AWTException {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        leadPage = dashboardPage.clickMenuLead();

        LeadData leadData = new LeadTest().getLeadDataFromExcel(1);
        String dateTimeLeadAdd = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        leadData.setLeadName(leadData.getLeadName() + dateTimeLeadAdd);
        leadData.setEmailAddress(leadData.getEmailAddress() + dateTimeLeadAdd + "@gmail.com");

        leadPage.clickIconLeadsSummary();
        leadPage.verifyLeadSummaryDisplay();
        leadPage.clickButtonNewLead();
        leadPage.fillDataLead(leadData);
        leadPage.clickButtonSave();
        leadPage.verifyAddLeadSuccessMessage();
        leadPage.clickIconClosePopupLeadDetail(leadData.getLeadName());
        leadPage.searchLead(leadData.getLeadName());
        leadPage.checkLeadsExists(leadData.getLeadName());
        leadPage.clickButtonEdit(leadData.getLeadName());
        leadPage.verifyNewLeadInEditPopup(leadData);

        LeadData leadDataEdit = new LeadTest().getLeadDataFromExcel(2);
        String dateTimeLeadEdit = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());

        leadDataEdit.setLeadName(leadDataEdit.getLeadName() + dateTimeLeadEdit);
        leadDataEdit.setTag(leadDataEdit.getTag() + dateTimeLeadEdit);
        leadDataEdit.setEmailAddress(leadDataEdit.getEmailAddress() + dateTimeLeadEdit + "@gmail.com");

        leadPage.fillDataLead(leadDataEdit);
        leadPage.clickButtonSave();
        leadPage.verifyUpdateLeadSuccessMessage();
        leadPage.clickIconClosePopupLeadDetail(leadDataEdit.getLeadName());
        leadPage.searchLead(leadDataEdit.getLeadName());
        leadPage.checkLeadsExists(leadDataEdit.getLeadName());

        taskPage = leadPage.clickMenuTask();

        TaskData taskData = getDataFromExcel(1);
        String dateTimeTaskAdd = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        taskData.setTaskName(taskData.getTaskName() + dateTimeTaskAdd);
        taskData.setTypeRelateTo(leadDataEdit.getLeadName());

        taskPage.verifyTaskPageDisplayed();
        taskPage.clickButtonNewTask();
        taskPage.fillDataNewTask(taskData);
        taskPage.clickButtonSave();
        taskPage.verifyAddTaskSuccessMessage();
        taskPage.clickIconCloseAddTaskMessage();
        taskPage.clickClosePopupTaskDetail(taskData.getTaskName(), taskData.getFlagEdit());
        taskPage.searchTask(taskData.getTaskName());
        taskPage.verifyTaskExists(taskData.getTaskName());

        taskPage.clickButtonEdit(taskData.getTaskName());
        taskPage.verifyNewTaskInTaskEdit(taskData);

        TaskData taskDataEdit = getDataFromExcel(2);
        String dateTimeTaskEdit = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        taskDataEdit.setTaskName(taskDataEdit.getTaskName() + dateTimeTaskEdit);

        taskPage.fillDataEdit(taskDataEdit);
        taskPage.clickButtonSave();
        taskPage.verifyUpdateTaskSuccessMessage();
        taskPage.clickIconCloseUpdateTaskMessage();
        taskPage.clickClosePopupTaskDetail(taskDataEdit.getTaskName(), taskDataEdit.getFlagEdit());
        taskPage.searchTask(taskDataEdit.getTaskName());
        taskPage.verifyTaskExists(taskDataEdit.getTaskName());
    }
}
