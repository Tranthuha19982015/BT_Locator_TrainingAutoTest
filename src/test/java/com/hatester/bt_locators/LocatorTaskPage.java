package com.hatester.bt_locators;

public class LocatorTaskPage {
    //Locator menu Tasks
    public static String menuTasks = "//ul[@id='side-menu']//span[normalize-space()='Tasks' and @class='menu-text']";

    //Locator Tasks Page
    public static String buttonNewTask = "//a[normalize-space()='New Task']";
    public static String buttonTasksOverview = "//a[normalize-space()='Tasks Overview']";
    public static String iconFilter = "//div[@id='vueApp']/div[@data-title='Filter by']";
    public static String iconSwitchToKanban = "//a[normalize-space()='New Task']/following-sibling::a[@data-title='Switch to Kanban']";
    public static String headerTasksSummary = "//span[normalize-space()='Tasks Summary']";

    //label status of task
    public static String labelNotStarted = "//span[normalize-space()='Not Started']/preceding-sibling::span";
    public static String labelInProgress = "//span[normalize-space()='In Progress']/preceding-sibling::span";
    public static String labelTesting = "//span[normalize-space()='Testing']/preceding-sibling::span";
    public static String labelAwaitingFeedback = "//span[normalize-space()='Awaiting Feedback']/preceding-sibling::span";
    public static String labelComplete = "//span[normalize-space()='Complete']/preceding-sibling::span";

    //button
    public static String dropdownDatatableTasksLength = "//div[@id='tasks_length']/descendant::select";
    public static String buttonExport = "//div[@id='tasks_length']/following-sibling::div/button[text()='Export']";
    public static String buttonBulkActions = "//div[@id='tasks_length']/following-sibling::div/button[text()='Bulk Actions']";
    public static String buttonReload = "//div[@id='tasks_length']/following-sibling::div/button[contains(@class,'btn-dt-reload')]";

    //input search
    public static String inputSearchTasks = "//div[@id='tasks_filter']/descendant::input[@type='search']";

    //table
    public static String checkboxCheckAll = "//table[@id='tasks']/thead//input[@id='mass_select_all']";
    public static String headerId = "//table[@id='tasks']/thead//th[normalize-space()='#']";
    public static String headerName = "//table[@id='tasks']/thead//th[normalize-space()='Name']";
    public static String headerStatus = "//table[@id='tasks']/thead//th[normalize-space()='Status']";
    public static String headerStartDate = "//table[@id='tasks']/thead//th[normalize-space()='Start Date']";
    public static String headerDueDate = "//table[@id='tasks']/thead//th[normalize-space()='Due Date']";
    public static String headerAssignedTo = "//table[@id='tasks']/thead//th[normalize-space()='Assigned to']";
    public static String headerTags = "//table[@id='tasks']/thead//th[normalize-space()='Tags']";
    public static String headerPriority = "//table[@id='tasks']/thead//th[normalize-space()='Priority']";

    public static String getFirstRowItemTaskName(String taskName) {
        String xpath = "//table[@id='tasks']/descendant::a[normalize-space()='" + taskName + "']";
        return xpath;
    }

    //button
    public static String buttonStartTimer(String tasksName) {
        String xpath = "//table[@id='tasks']/descendant::a[normalize-space()='" + tasksName + "']/following-sibling::div//a[normalize-space()='Start Timer']";
        return xpath;
    }

    public static String buttonEdit(String tasksName) {
        String xpath = "//table[@id='tasks']/descendant::a[normalize-space()='" + tasksName + "']/following-sibling::div//a[normalize-space()='Edit']";
        return xpath;
    }

    public static String buttonDelete(String tasksName) {
        String xpath = "//table[@id='tasks']/descendant::a[normalize-space()='" + tasksName + "']/following-sibling::div//a[normalize-space()='Delete']";
        return xpath;
    }

    public static String labelTasksInfo = "//div[@id='tasks_info']";
    public static String buttonPrevious = "//div[@id='tasks_paginate']//li[@id='tasks_previous']";
    public static String buttonNext = "//div[@id='tasks_paginate']//li[@id='tasks_next']";
    public static String dropdownNumberOfPage = "//div[@id='colvis']/following-sibling::div/select[@id='dt-page-jump-tasks']";

    //Locator Add New Task
    //checkbox
    public static String checkboxPublic = "//input[@id='task_is_public']";
    public static String checkboxBillable = "//input[@id='task_is_billable']";
    //attach files
    public static String textlinkAttachFiles = "//a[normalize-space()='Attach Files']";
    public static String inputChooseFile = "//div[@id='new-task-attachments']/descendant::input[@type='file']";
    public static String iconAddMoreFileAttachment = "//div[@id='new-task-attachments']/descendant::button[contains(@class,'add_more_attachments')]";
    //input
    public static String inputSubject = "//input[@id='name']";
    public static String inputHourlyRate = "//input[@id='hourly_rate']";
    public static String inputStartDate = "//input[@id='startdate']";
    public static String inputDueDate = "//input[@id='duedate']";
    //dropdown Priority
    public static String dropdownPriority = "//button[@data-id='priority']";

    public static String getValuePriority(String priority) {
        String xpath = "//button[@data-id='priority']/following-sibling::div/descendant::span[normalize-space()='" + priority + "']";
        return xpath;
    }

    //dropdown Repeat every
    public static String dropdownRepeatEvery = "//button[@data-id='repeat_every']";

    public static String getValueRepeatEvery(String repeatEvery) {
        String xpath = "//button[@data-id='repeat_every']/following-sibling::div/descendant::span[normalize-space()='" + repeatEvery + "']";
        return xpath;
    }

    //input Total Cycles
    public static String inputTotalCycles = "//input[@id='cycles']";
    public static String checkboxInfinity = "//input[@id='cycles']/following-sibling::div/descendant::label[@for='unlimited_cycles']";

    //dropdown Related To
    public static String dropdownRelatedTo = "//button[@data-id='rel_type']";

    public static String getValueRelatedTo(String relatedTo) {
        String xpath = "//button[@data-id='rel_type']/following-sibling::div/descendant::span[normalize-space()='Invoice']";
        return xpath;
    }

    public static String dropdownRelatedToFollowingType = "//button[@data-id='rel_id']";
    public static String inputSearchRelatedToFollowingType = "//button[@data-id='rel_id']/following-sibling::div/descendant::input[@type='search']";

    //dropdown Assignees
    public static String dropdownAssignees = "//button[@data-id='assignees']";
    public static String inputSearchAssignees = "//button[@data-id='assignees']/following-sibling::div//input[@type='search']";

    public static String getValueAssignees(String assignee) {
        String xpath = "//button[@data-id='assignees']/following-sibling::div/descendant::span[normalize-space()='" + assignee + "']";
        return xpath;
    }

    //dropdown Followers
    public static String dropdownFollowers = "//button[contains(@data-id,'followers')]";
    public static String inputSearchFollowers = "//button[contains(@data-id,'followers')]/following-sibling::div/descendant::input[@type='search']";

    public static String getValueFollowers(String follower) {
        String xpath = "//button[contains(@data-id,'followers')]/following-sibling::div/descendant::span[normalize-space()='" + follower + "']";
        return xpath;
    }

    //input
    public static String inputTags = "//div[@id='inputTagsWrapper']/descendant::input";
    public static String inputDescription = "//body[@id='tinymce']/p";

    //button
    public static String buttonClose = "//div[contains(@id,'task_modal')]/descendant::button[normalize-space()='Close']";
    public static String buttonSave = "//div[contains(@id,'task_modal')]/descendant::button[normalize-space()='Save']";
}
