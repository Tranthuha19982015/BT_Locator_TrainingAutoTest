package com.hatester.bt_locators;

import org.openqa.selenium.By;

public class LocatorTaskPage {
    //Locator menu Tasks
    public static By menuTasks = By.xpath("//ul[@id='side-menu']//span[normalize-space()='Tasks' and @class='menu-text']");

    //Locator Tasks Page
    public static By buttonNewTask = By.xpath("//a[normalize-space()='New Task']");
    public static By buttonTasksOverview = By.xpath("//a[normalize-space()='Tasks Overview']");
    public static By iconFilter = By.xpath("//div[@id='vueApp']/div[@data-title='Filter by']");
    public static By iconSwitchToKanban = By.xpath("//a[normalize-space()='New Task']/following-sibling::a[@data-title='Switch to Kanban']");
    public static By headerTasksSummary = By.xpath("//span[normalize-space()='Tasks Summary']");

    //label status of task
    public static By labelNotStarted = By.xpath("//span[normalize-space()='Not Started']/preceding-sibling::span");
    public static By labelInProgress = By.xpath("//span[normalize-space()='In Progress']/preceding-sibling::span");
    public static By labelTesting = By.xpath("//span[normalize-space()='Testing']/preceding-sibling::span");
    public static By labelAwaitingFeedback = By.xpath("//span[normalize-space()='Awaiting Feedback']/preceding-sibling::span");
    public static By labelComplete = By.xpath("//span[normalize-space()='Complete']/preceding-sibling::span");

    //button
    public static By dropdownDatatableTasksLength = By.xpath("//div[@id='tasks_length']/descendant::select");
    public static By buttonExport = By.xpath("//div[@id='tasks_length']/following-sibling::div/button[normalize-space()='Export']");
    public static By buttonBulkActions = By.xpath("//div[@id='tasks_length']/following-sibling::div/button[normalize-space()='Bulk Actions']");
    public static By buttonReload = By.xpath("//div[@id='tasks_length']/following-sibling::div/button[contains(@class,'btn-dt-reload')]");

    //input search
    public static By inputSearchTasks = By.xpath("//div[@id='tasks_filter']/descendant::input[@type='search']");

    //table
    public static By checkboxCheckAll = By.xpath("//table[@id='tasks']/thead//input[@id='mass_select_all']");
    public static By headerId = By.xpath("//table[@id='tasks']/thead//th[normalize-space()='#']");
    public static By headerName = By.xpath("//table[@id='tasks']/thead//th[normalize-space()='Name']");
    public static By headerStatus = By.xpath("//table[@id='tasks']/thead//th[normalize-space()='Status']");
    public static By headerStartDate = By.xpath("//table[@id='tasks']/thead//th[normalize-space()='Start Date']");
    public static By headerDueDate = By.xpath("//table[@id='tasks']/thead//th[normalize-space()='Due Date']");
    public static By headerAssignedTo = By.xpath("//table[@id='tasks']/thead//th[normalize-space()='Assigned to']");
    public static By headerTags = By.xpath("//table[@id='tasks']/thead//th[normalize-space()='Tags']");
    public static By headerPriority = By.xpath("//table[@id='tasks']/thead//th[normalize-space()='Priority']");

    public static By getFirstRowItemTaskName(String taskName) {
        By xpath = By.xpath("//table[@id='tasks']/descendant::a[normalize-space()='" + taskName + "']");
        return xpath;
    }

    //button
    public static By buttonStartTimer(String tasksName) {
        By xpath = By.xpath("//table[@id='tasks']/descendant::a[normalize-space()='" + tasksName + "']/following-sibling::div//a[normalize-space()='Start Timer']");
        return xpath;
    }

    public static By buttonEdit(String tasksName) {
        By xpath = By.xpath("//table[@id='tasks']/descendant::a[normalize-space()='" + tasksName + "']/following-sibling::div//a[normalize-space()='Edit']");
        return xpath;
    }

    public static By buttonDelete(String tasksName) {
        By xpath = By.xpath("//table[@id='tasks']/descendant::a[normalize-space()='" + tasksName + "']/following-sibling::div//a[normalize-space()='Delete']");
        return xpath;
    }

    public static By labelTasksInfo = By.xpath("//div[@id='tasks_info']");
    public static By buttonPrevious = By.xpath("//div[@id='tasks_paginate']//li[@id='tasks_previous']");

    public static By buttonNumberOfPage(String number) {
        By xpath = By.xpath("//div[@id='tasks_paginate']/descendant::a[normalize-space()='" + number + "']");
        return xpath;
    }

    public static By buttonNext = By.xpath("//div[@id='tasks_paginate']//li[@id='tasks_next']");
    public static By dropdownNumberOfPage = By.xpath("//div[@id='colvis']/following-sibling::div/select[@id='dt-page-jump-tasks']");

    //Locator Add New Task
    public static By headerAddNewTask = By.xpath("//h4[@id='myModalLabel']");
    //checkbox
    public static By checkboxPublic = By.xpath("//input[@id='task_is_public']");
    public static By labelCheckboxPublic = By.xpath("//label[normalize-space()='Public']");
    public static By checkboxBillable = By.xpath("//input[@id='task_is_billable']");
    public static By labelCheckboxBillable = By.xpath("//label[@for='task_is_billable']");
    //attach files
    public static By textlinkAttachFiles = By.xpath("//a[normalize-space()='Attach Files']");
    public static By iconAddMoreFileAttachment = By.xpath("//div[@id='new-task-attachments']/descendant::button[contains(@class,'add_more_attachments')]");

    public static By inputChooseFile(String number) {
        By xpath = By.xpath("//div[@id='new-task-attachments']/descendant::input[@type='file' and @name='attachments[" + number + "]']");
        return xpath;
    }

    public static By iconDeleteFileAttachment(String number) {
        By xpath = By.xpath("//input[@type='file' and @name='attachments[" + number + "]']/following-sibling::span/button[contains(@class,'remove_attachment')]");
        return xpath;
    }

    //input
    public static By inputSubject = By.xpath("//input[@id='name']");
    public static By inputHourlyRate = By.xpath("//input[@id='hourly_rate']");
    public static By inputStartDate = By.xpath("//input[@id='startdate']");
    public static By inputDueDate = By.xpath("//input[@id='duedate']");
    //dropdown Priority
    public static By dropdownPriority = By.xpath("//button[@data-id='priority']");

    public static By getValuePriority(String priority) {
        By xpath = By.xpath("//button[@data-id='priority']/following-sibling::div/descendant::span[contains(normalize-space(),'" + priority + "')]");
        return xpath;
    }

    //dropdown Repeat every
    public static By dropdownRepeatEvery = By.xpath("//button[@data-id='repeat_every']");

    public static By getValueRepeatEvery(String repeatEvery) {
        By xpath = By.xpath("//button[@data-id='repeat_every']/following-sibling::div/descendant::span[contains(normalize-space(),'" + repeatEvery + "')]");
        return xpath;
    }

    public static By inputRepeatEveryCustom = By.xpath("//input[@id='repeat_every_custom']");
    public static By dropdownRepeatEveryCustom = By.xpath("//button[@data-id='repeat_type_custom']");

    public static By getValueRepeatEveryCustom(String repeatEveryCustom) {
        By xpath = By.xpath("//button[@data-id='repeat_type_custom']/following-sibling::div/descendant::span[contains(normalize-space(),'" + repeatEveryCustom + "')]");
        return xpath;
    }

    //input Total Cycles
    public static By inputTotalCycles = By.xpath("//input[@id='cycles']");
    public static By checkboxInfinity = By.xpath("//input[@id='cycles']/following-sibling::div/descendant::label[@for='unlimited_cycles']");

    //dropdown Related To
    public static By dropdownRelatedTo = By.xpath("//button[@data-id='rel_type']");

    public static By getValueRelatedTo(String relatedTo) {
        By xpath = By.xpath("//button[@data-id='rel_type']/following-sibling::div/descendant::span[contains(normalize-space(),'" + relatedTo + "')]");
        return xpath;
    }

    public static By dropdownTypeRelatedTo = By.xpath("//button[@data-id='rel_id']");
    public static By inputSearchTypeRelatedTo = By.xpath("//button[@data-id='rel_id']/following-sibling::div/descendant::input[@type='search']");

    public static By getValueTypeRelatedTo(String valueTypeRelatedTo) {
        By xpath = By.xpath("//button[@data-id='rel_id']/following-sibling::div/descendant::a[contains(normalize-space(),'" + valueTypeRelatedTo + "')]");
        return xpath;
    }

    //dropdown Assignees
    public static By dropdownAssignees = By.xpath("//button[@data-id='assignees']");
    public static By inputSearchAssignees = By.xpath("//button[@data-id='assignees']/following-sibling::div//input[@type='search']");

    public static By getValueAssignees(String assignee) {
        By xpath = By.xpath("//button[@data-id='assignees']/following-sibling::div/descendant::span[contains(normalize-space(),'" + assignee + "')]");
        return xpath;
    }

    //dropdown Followers
    public static By dropdownFollowers = By.xpath("//button[contains(@data-id,'followers')]");
    public static By inputSearchFollowers = By.xpath("//button[contains(@data-id,'followers')]/following-sibling::div/descendant::input[@type='search']");

    public static By getValueFollowers(String follower) {
        By xpath = By.xpath("//button[contains(@data-id,'followers')]/following-sibling::div/descendant::span[contains(normalize-space(),'" + follower + "')]");
        return xpath;
    }

    //input
    public static By labelTags = By.xpath("//label[normalize-space()='Tags']");
    public static By inputTags = By.xpath("//div[@id='inputTagsWrapper']/descendant::input[@placeholder='Tag']");
    public static By inputTagsEdit = By.xpath("(//input[@id='tags']/following-sibling::ul)/descendant::span[@class='tagit-label']");
    public static By iconCloseTag = By.xpath("//input[@id='tags']/following-sibling::ul/descendant::span[normalize-space()='×']");

    public static By inputDescription = By.xpath("//textarea[@id='description']");
    public static By iframeDescription = By.xpath("//iframe[@id='description_ifr']");
    public static By inputDescriptionFrame = By.xpath("//body[@id='tinymce']/p");

    //button
    public static By buttonClose = By.xpath("//div[contains(@id,'task_modal')]/descendant::button[normalize-space()='Close']");
    public static By buttonSave = By.xpath("//div[contains(@id,'task_modal')]/descendant::button[normalize-space()='Save']");

    //icon close popup
    public static By iconClosePopupTaskDetail(String headerTaskDetail) {
        By xpath = By.xpath("//h4[contains(normalize-space(),'" + headerTaskDetail + "')]/preceding-sibling::button[@aria-label='Close']");
        return xpath;
    }

}
