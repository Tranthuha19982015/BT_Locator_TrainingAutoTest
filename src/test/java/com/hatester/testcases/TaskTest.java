package com.hatester.testcases;

import com.hatester.dataprovider.DataProviderFactory;
import com.hatester.helpers.ExcelHelper;
import com.hatester.models.TaskData;
import com.hatester.pages.DashboardPage;
import com.hatester.pages.LeadPage;
import com.hatester.pages.LoginPage;
import com.hatester.pages.TaskPage;
import com.hatester.common.BaseTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private LeadPage leadPage;
    private TaskPage taskPage;

    @Test(dataProvider = "addTaskData", dataProviderClass = DataProviderFactory.class)
    public void testAddNewTask(TaskData taskData) {
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
        taskPage.clickClosePopupTaskDetail(taskData.getTaskName());
        taskPage.searchTask(taskData.getTaskName());
        taskPage.verifyTaskExists(taskData.getTaskName());
        taskPage.clickButtonEdit(taskData.getTaskName());
        taskPage.verifyNewTaskInTaskEdit(taskData);
    }

    @Test(dataProvider = "editTaskData", dataProviderClass = DataProviderFactory.class)
    public void testEditTask(TaskData taskAddData, TaskData taskDataEdit) {
        String dateTimeAdd = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        taskAddData.setTaskName(taskAddData.getTaskName() + dateTimeAdd);

        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        taskPage = dashboardPage.clickMenuTask();
        taskPage.verifyTaskPageDisplayed();
        taskPage.clickButtonNewTask();
        taskPage.fillDataNewTask(taskAddData);
        taskPage.clickButtonSave();
        taskPage.verifyAddTaskSuccessMessage();
        taskPage.clickIconCloseAddTaskMessage();
        taskPage.clickClosePopupTaskDetail(taskAddData.getTaskName());
        taskPage.searchTask(taskAddData.getTaskName());
        taskPage.verifyTaskExists(taskAddData.getTaskName());

        taskPage.clickButtonEdit(taskAddData.getTaskName());
        taskPage.verifyNewTaskInTaskEdit(taskAddData);

        String dateTimeEdit = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        taskDataEdit.setTaskName(taskDataEdit.getTaskName() + dateTimeEdit);

        taskPage.fillDataEdit(taskDataEdit);
        taskPage.clickButtonSave();
        taskPage.verifyUpdateTaskSuccessMessage();
        taskPage.clickIconCloseUpdateTaskMessage();
        taskPage.clickClosePopupTaskDetail(taskDataEdit.getTaskName());
        taskPage.searchTask(taskDataEdit.getTaskName());
        taskPage.verifyTaskExists(taskDataEdit.getTaskName());
    }

    @Test(dataProvider = "addTaskData", dataProviderClass = DataProviderFactory.class)
    public void testDeleteTask(TaskData taskData) {
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
        taskPage.clickClosePopupTaskDetail(taskData.getTaskName());
        taskPage.searchTask(taskData.getTaskName());
        taskPage.verifyTaskExists(taskData.getTaskName());

        taskPage.clickButtonDelete(taskData.getTaskName());
        taskPage.confirmAlertDelete(taskData.getTypeConfirm());
        taskPage.verifyDeleteTaskSuccessMessage(taskData.getTypeConfirm());
        taskPage.clickIconCloseDeleteTaskMessage(taskData.getTypeConfirm());
        taskPage.searchTask(taskData.getTaskName());
        taskPage.verifyAfterDeleteTask(taskData.getTaskName(), taskData.getTypeConfirm());
    }

//    @Test(dataProvider = "leadData", dataProviderClass = DataProviderFactory.class)
//    public void testLeadAndTaskManagementFlow(LeadData leadData) {
//        loginPage = new LoginPage();
//        dashboardPage = loginPage.loginCRM();
//        leadPage = dashboardPage.clickMenuLead();
//
//        String dateTimeLeadAdd = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
//        leadData.setLeadName(leadData.getLeadName() + dateTimeLeadAdd);
//        leadData.setEmailAddress(leadData.getEmailAddress() + dateTimeLeadAdd + "@gmail.com");
//
//        leadPage.clickIconLeadsSummary();
//        leadPage.verifyLeadSummaryDisplay();
//        leadPage.clickButtonNewLead();
//        leadPage.fillDataLead(leadData);
//        leadPage.clickButtonSave();
//        leadPage.verifyAddLeadSuccessMessage();
//        leadPage.clickIconClosePopupLeadDetail(leadData.getLeadName());
//        leadPage.searchLead(leadData.getLeadName());
//        leadPage.checkLeadsExists(leadData.getLeadName());
//        leadPage.clickButtonEdit(leadData.getLeadName());
//        leadPage.verifyNewLeadInEditPopup(leadData);
//
//        LeadData leadDataEdit = new LeadTest().getLeadDataFromExcel(2);
//        String dateTimeLeadEdit = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
//
//        leadDataEdit.setLeadName(leadDataEdit.getLeadName() + dateTimeLeadEdit);
//        leadDataEdit.setTag(leadDataEdit.getTag() + dateTimeLeadEdit);
//        leadDataEdit.setEmailAddress(leadDataEdit.getEmailAddress() + dateTimeLeadEdit + "@gmail.com");
//
//        leadPage.fillDataLead(leadDataEdit);
//        leadPage.clickButtonSave();
//        leadPage.verifyUpdateLeadSuccessMessage();
//        leadPage.clickIconClosePopupLeadDetail(leadDataEdit.getLeadName());
//        leadPage.searchLead(leadDataEdit.getLeadName());
//        leadPage.checkLeadsExists(leadDataEdit.getLeadName());
//
//        taskPage = leadPage.clickMenuTask();
//
//        TaskData taskData = getDataFromExcel(1);
//        String dateTimeTaskAdd = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
//        taskData.setTaskName(taskData.getTaskName() + dateTimeTaskAdd);
//        taskData.setTypeRelateTo(leadDataEdit.getLeadName());
//
//        taskPage.verifyTaskPageDisplayed();
//        taskPage.clickButtonNewTask();
//        taskPage.fillDataNewTask(taskData);
//        taskPage.clickButtonSave();
//        taskPage.verifyAddTaskSuccessMessage();
//        taskPage.clickIconCloseAddTaskMessage();
//        taskPage.clickClosePopupTaskDetail(taskData.getTaskName(), taskData.getFlagEdit());
//        taskPage.searchTask(taskData.getTaskName());
//        taskPage.verifyTaskExists(taskData.getTaskName());
//
//        taskPage.clickButtonEdit(taskData.getTaskName());
//        taskPage.verifyNewTaskInTaskEdit(taskData);
//
//        TaskData taskDataEdit = getDataFromExcel(2);
//        String dateTimeTaskEdit = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
//        taskDataEdit.setTaskName(taskDataEdit.getTaskName() + dateTimeTaskEdit);
//
//        taskPage.fillDataEdit(taskDataEdit);
//        taskPage.clickButtonSave();
//        taskPage.verifyUpdateTaskSuccessMessage();
//        taskPage.clickIconCloseUpdateTaskMessage();
//        taskPage.clickClosePopupTaskDetail(taskDataEdit.getTaskName(), taskDataEdit.getFlagEdit());
//        taskPage.searchTask(taskDataEdit.getTaskName());
//        taskPage.verifyTaskExists(taskDataEdit.getTaskName());
//    }
}
