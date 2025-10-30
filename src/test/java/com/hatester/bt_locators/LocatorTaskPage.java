package com.hatester.bt_locators;

public class LocatorTaskPage {
    //Locator menu Tasks
    public static String menuTasks = "//ul[@id='side-menu']//span[normalize-space()='Tasks' and @class='menu-text']";

    //Locator Tasks Page
    public static String buttonNewTask = "//a[normalize-space()='New Task']";
    public static String iconSwitchToKanban = "//a[normalize-space()='New Task']/following-sibling::a[@data-title='Switch to Kanban']";
    public static String headerTasksSummary = "//span[normalize-space()='Tasks Summary']";

    public static String labelNotStarted = "//span[normalize-space()='Not Started']/preceding-sibling::span";
    public static String labelInProgress = "//span[normalize-space()='In Progress']/preceding-sibling::span";
    public static String labelTesting = "//span[normalize-space()='Testing']/preceding-sibling::span";
    public static String labelAwaitingFeedback = "//span[normalize-space()='Awaiting Feedback']/preceding-sibling::span";
    public static String labelComplete = "//span[normalize-space()='Complete']/preceding-sibling::span";

    public static String inputSearchTasks = "//div[@id='tasks_filter']/descendant::input[@type='search']";

    public static String getFirstRowItemTaskName(String taskName) {
        String xpath = "//table[@id='tasks']/descendant::a[normalize-space()='" + taskName + "']";
        return xpath;
    }

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
