package com.hatester.pages;

import com.hatester.keywords.WebUI;
import com.hatester.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.awt.*;

public class TaskPage extends BasePage {
    public TaskPage(WebDriver driver) {
        super(driver);
        new WebUI(driver);
    }

    //Locator Tasks Page
    private By buttonNewTask = By.xpath("//a[normalize-space()='New Task']");
    private By buttonTasksOverview = By.xpath("//a[normalize-space()='Tasks Overview']");
    private By iconFilter = By.xpath("//div[@id='vueApp']/div[@data-title='Filter by']");
    private By iconSwitchToKanban = By.xpath("//a[normalize-space()='New Task']/following-sibling::a[@data-title='Switch to Kanban']");
    private By headerTasksSummary = By.xpath("//span[normalize-space()='Tasks Summary']");

    //label status of task
    private By labelTaskTotalNotStarted = By.xpath("//span[normalize-space()='Not Started']/preceding-sibling::span");
    private By labelTaskTotalInProgress = By.xpath("//span[normalize-space()='In Progress']/preceding-sibling::span");
    private By labelTaskTotalTesting = By.xpath("//span[normalize-space()='Testing']/preceding-sibling::span");
    private By labelTaskTotalAwaitingFeedback = By.xpath("//span[normalize-space()='Awaiting Feedback']/preceding-sibling::span");
    private By labelTaskTotalComplete = By.xpath("//span[normalize-space()='Complete']/preceding-sibling::span");

    //button
    private By dropdownDatatableTasksLength = By.xpath("//div[@id='tasks_length']/descendant::select");
    private By buttonExport = By.xpath("//div[@id='tasks_length']/following-sibling::div/button[normalize-space()='Export']");
    private By buttonBulkActions = By.xpath("//div[@id='tasks_length']/following-sibling::div/button[normalize-space()='Bulk Actions']");
    private By buttonReload = By.xpath("//div[@id='tasks_length']/following-sibling::div/button[contains(@class,'btn-dt-reload')]");

    //input search
    private By inputSearchTasks = By.xpath("//div[@id='tasks_filter']/descendant::input[@type='search']");

    //table
    private By checkboxCheckAll = By.xpath("//table[@id='tasks']/thead//input[@id='mass_select_all']");
    private By headerId = By.xpath("//table[@id='tasks']/thead//th[normalize-space()='#']");
    private By headerName = By.xpath("//table[@id='tasks']/thead//th[normalize-space()='Name']");
    private By headerStatus = By.xpath("//table[@id='tasks']/thead//th[normalize-space()='Status']");
    private By headerStartDate = By.xpath("//table[@id='tasks']/thead//th[normalize-space()='Start Date']");
    private By headerDueDate = By.xpath("//table[@id='tasks']/thead//th[normalize-space()='Due Date']");
    private By headerAssignedTo = By.xpath("//table[@id='tasks']/thead//th[normalize-space()='Assigned to']");
    private By headerTags = By.xpath("//table[@id='tasks']/thead//th[normalize-space()='Tags']");
    private By headerPriority = By.xpath("//table[@id='tasks']/thead//th[normalize-space()='Priority']");

    private By getFirstRowItemTaskName(String taskName) {
        By xpath = By.xpath("//table[@id='tasks']/descendant::a[normalize-space()='" + taskName + "']");
        return xpath;
    }

    //button
    private By buttonStartTimer(String tasksName) {
        By xpath = By.xpath("//table[@id='tasks']/descendant::a[normalize-space()='" + tasksName + "']/following-sibling::div//a[normalize-space()='Start Timer']");
        return xpath;
    }

    private By buttonEdit(String tasksName) {
        By xpath = By.xpath("//table[@id='tasks']/descendant::a[normalize-space()='" + tasksName + "']/following-sibling::div//a[normalize-space()='Edit']");
        return xpath;
    }

    private By buttonDelete(String tasksName) {
        By xpath = By.xpath("//table[@id='tasks']/descendant::a[normalize-space()='" + tasksName + "']/following-sibling::div//a[normalize-space()='Delete']");
        return xpath;
    }

    private By labelTasksInfo = By.xpath("//div[@id='tasks_info']");
    private By buttonPrevious = By.xpath("//div[@id='tasks_paginate']//li[@id='tasks_previous']");

    private By buttonNumberOfPage(String number) {
        By xpath = By.xpath("//div[@id='tasks_paginate']/descendant::a[normalize-space()='" + number + "']");
        return xpath;
    }

    private By buttonNext = By.xpath("//div[@id='tasks_paginate']//li[@id='tasks_next']");
    private By dropdownNumberOfPage = By.xpath("//div[@id='colvis']/following-sibling::div/select[@id='dt-page-jump-tasks']");

    //Locator Add New Task
    private By headerAddNewTask = By.xpath("//h4[@id='myModalLabel']");
    //checkbox
    private By checkboxPublic = By.xpath("//input[@id='task_is_public']");
    private By labelCheckboxPublic = By.xpath("//label[normalize-space()='Public']");
    private By checkboxBillable = By.xpath("//input[@id='task_is_billable']");
    private By labelCheckboxBillable = By.xpath("//label[@for='task_is_billable']");
    //attach files
    private By textlinkAttachFiles = By.xpath("//a[normalize-space()='Attach Files']");
    private By iconAddMoreFileAttachment = By.xpath("//div[@id='new-task-attachments']/descendant::button[contains(@class,'add_more_attachments')]");

    private By inputChooseFile(String number) {
        By xpath = By.xpath("//div[@id='new-task-attachments']/descendant::input[@type='file' and @name='attachments[" + number + "]']");
        return xpath;
    }

    private By iconDeleteFileAttachment(String number) {
        By xpath = By.xpath("//input[@type='file' and @name='attachments[" + number + "]']/following-sibling::span/button[contains(@class,'remove_attachment')]");
        return xpath;
    }

    //input
    private By inputSubject = By.xpath("//input[@id='name']");
    private By inputHourlyRate = By.xpath("//input[@id='hourly_rate']");
    private By inputStartDate = By.xpath("//input[@id='startdate']");
    private By inputDueDate = By.xpath("//input[@id='duedate']");
    //dropdown Priority
    private By dropdownPriority = By.xpath("//button[@data-id='priority']");

    private By getValuePriority(String priority) {
        By xpath = By.xpath("//button[@data-id='priority']/following-sibling::div/descendant::span[contains(normalize-space(),'" + priority + "')]");
        return xpath;
    }

    //dropdown Repeat every
    private By dropdownRepeatEvery = By.xpath("//button[@data-id='repeat_every']");

    private By getValueRepeatEvery(String repeatEvery) {
        By xpath = By.xpath("//button[@data-id='repeat_every']/following-sibling::div/descendant::span[contains(normalize-space(),'" + repeatEvery + "')]");
        return xpath;
    }

    private By inputRepeatEveryCustom = By.xpath("//input[@id='repeat_every_custom']");
    private By dropdownRepeatEveryCustom = By.xpath("//button[@data-id='repeat_type_custom']");

    private By getValueRepeatEveryCustom(String repeatEveryCustom) {
        By xpath = By.xpath("//button[@data-id='repeat_type_custom']/following-sibling::div/descendant::span[contains(normalize-space(),'" + repeatEveryCustom + "')]");
        return xpath;
    }

    //input Total Cycles
    private By inputTotalCycles = By.xpath("//input[@id='cycles']");
    private By checkboxInfinity = By.xpath("//input[@id='cycles']/following-sibling::div/descendant::label[@for='unlimited_cycles']");

    //dropdown Related To
    private By dropdownRelatedTo = By.xpath("//button[@data-id='rel_type']");

    private By getValueRelatedTo(String relatedTo) {
        By xpath = By.xpath("//button[@data-id='rel_type']/following-sibling::div/descendant::span[contains(normalize-space(),'" + relatedTo + "')]");
        return xpath;
    }

    private By dropdownTypeRelatedTo = By.xpath("//button[@data-id='rel_id']");
    private By inputSearchTypeRelatedTo = By.xpath("//button[@data-id='rel_id']/following-sibling::div/descendant::input[@type='search']");

    private By getValueTypeRelatedTo(String valueTypeRelatedTo) {
        By xpath = By.xpath("//button[@data-id='rel_id']/following-sibling::div/descendant::a[contains(normalize-space(),'" + valueTypeRelatedTo + "')]");
        return xpath;
    }

    //dropdown Assignees
    private By dropdownAssignees = By.xpath("//button[@data-id='assignees']");
    private By inputSearchAssignees = By.xpath("//button[@data-id='assignees']/following-sibling::div//input[@type='search']");

    private By getValueAssignees(String assignee) {
        By xpath = By.xpath("//button[@data-id='assignees']/following-sibling::div/descendant::span[contains(normalize-space(),'" + assignee + "')]");
        return xpath;
    }

    //dropdown Followers
    private By dropdownFollowers = By.xpath("//button[contains(@data-id,'followers')]");
    private By inputSearchFollowers = By.xpath("//button[contains(@data-id,'followers')]/following-sibling::div/descendant::input[@type='search']");

    private By getValueFollowers(String follower) {
        By xpath = By.xpath("//button[contains(@data-id,'followers')]/following-sibling::div/descendant::span[contains(normalize-space(),'" + follower + "')]");
        return xpath;
    }

    //input
    private By labelTags = By.xpath("//label[normalize-space()='Tags']");
    private By inputTags = By.xpath("//div[@id='inputTagsWrapper']/descendant::input[@placeholder='Tag']");
    private By inputTagsEdit = By.xpath("(//input[@id='tags']/following-sibling::ul)/descendant::span[@class='tagit-label']");
    private By iconCloseTag = By.xpath("//input[@id='tags']/following-sibling::ul/descendant::span[normalize-space()='×']");

    private By inputDescription = By.xpath("//textarea[@id='description']");
    private By iframeDescription = By.xpath("//iframe[@id='description_ifr']");
    private By inputDescriptionFrame = By.xpath("//body[@id='tinymce']/p");

    //button
    private By buttonClose = By.xpath("//div[contains(@id,'task_modal')]/descendant::button[normalize-space()='Close']");
    private By buttonSave = By.xpath("//div[contains(@id,'task_modal')]/descendant::button[normalize-space()='Save']");

    //icon close popup
    private By iconClosePopupTaskDetail(String headerTaskDetail) {
        By xpath = By.xpath("//h4[contains(normalize-space(),'" + headerTaskDetail + "')]/preceding-sibling::button[@aria-label='Close']");
        return xpath;
    }

    //messsage
    private String addTaskSuccessMessage = "Task added successfully.";
    private String updateTaskSuccessMessage = "Task updated successfully.";
    private String deleteTaskSuccessMessage = "Task deleted";

    private By getDeleteTaskSuccessMessage() {
        String xpathDeleteTaskMessage = "//div[@id='alert_float_1']/descendant::span[@class='alert-title' and normalize-space()='" + deleteTaskSuccessMessage + "']";
        return By.xpath(xpathDeleteTaskMessage);
    }

    private By iconCloseAddTaskSuccessMessage = By.xpath("//span[@class='alert-title' and text()='Task added successfully.']/preceding-sibling::button[@class='close']");
    private By iconCloseUpdateTaskSuccessMessage = By.xpath("//span[@class='alert-title' and text()='Task updated successfully.']/preceding-sibling::button[@class='close']");
    private By iconCloseDeleteTaskSuccessMessage = By.xpath("//span[@class='alert-title' and text()='Task deleted']/preceding-sibling::button[@class='close']");

    public void verifyTaskPageDisplayed() {
        String actualCurrentUrl = WebUI.getCurrentURL();
        String expectUrl = "https://crm.anhtester.com/admin/tasks";

        Assert.assertTrue((WebUI.checkElementExist(headerTasksSummary) && actualCurrentUrl.equals(expectUrl)),
                "Failed to navigate to the Task menu.");
    }

    public String getTotalNotStartedTasks() {
        String statusNotStarted = WebUI.getElementText(labelTaskTotalNotStarted);
        return statusNotStarted;
    }

    public String getTotalInProgressTasks() {
        String statusInProgress = WebUI.getElementText(labelTaskTotalInProgress);
        return statusInProgress;
    }

    public String getTotalTestingTasks() {
        String statusTesting = WebUI.getElementText(labelTaskTotalTesting);
        return statusTesting;
    }

    public String getTotalAwaitingFeedbackTasks() {
        String statusAwaitingFeedback = WebUI.getElementText(labelTaskTotalAwaitingFeedback);
        return statusAwaitingFeedback;
    }

    public String getTotalCompleteTasks() {
        String statusComplete = WebUI.getElementText(labelTaskTotalComplete);
        return statusComplete;
    }

    public String getTotalStatusesNotComplete() {
        return Integer.toString(Integer.parseInt(getTotalNotStartedTasks())
                + Integer.parseInt(getTotalInProgressTasks())
                + Integer.parseInt(getTotalTestingTasks())
                + Integer.parseInt(getTotalAwaitingFeedbackTasks()));
    }

    public String getTotalTaskStatuses() {
        return Integer.toString(Integer.parseInt(getTotalNotStartedTasks())
                + Integer.parseInt(getTotalInProgressTasks())
                + Integer.parseInt(getTotalTestingTasks())
                + Integer.parseInt(getTotalAwaitingFeedbackTasks())
                + Integer.parseInt(getTotalCompleteTasks()));
    }

    public void clickButtonNewTask() {
        WebUI.clickElement(buttonNewTask);
        WebUI.sleep(1);
        Assert.assertTrue(WebUI.checkElementExist(headerAddNewTask), "Failed to open the Add Task popup");
    }

    public void fillDataNewTask(String subject, String hourlyRate, String startDate, String dueDate, String priority, String repeatEvery,
                                String numberRepeatEveryCustom, String typeRepeatEveryCustom, String totalCycles, String relatedTo,
                                String typeRelatedTo, String assignee, String follower, String tag, String description, int flag)
            throws AWTException {
        //checkbox
        if (flag == 1) {
            WebUI.clickElement(labelCheckboxPublic);
        }
        if (flag == 0) {
            WebUI.clickElement(labelCheckboxBillable);
        }

        //input
        WebUI.setTextElement(inputSubject, subject);
        WebUI.clearTextElement(inputHourlyRate);
        WebUI.setTextElement(inputHourlyRate, hourlyRate);
        WebUI.clearTextElement(inputStartDate);
        WebUI.setTextElement(inputStartDate, startDate);
        WebUI.clickElement(headerAddNewTask);
        WebUI.clearTextElement(inputDueDate);
        WebUI.setTextElement(inputDueDate, dueDate);
        WebUI.clickElement(headerAddNewTask);

        //Priority
        WebUI.clickElement(dropdownPriority);
        WebUI.clickElement(getValuePriority(priority));

        //Repeat every
        WebUI.clickElement(dropdownRepeatEvery);
        WebUI.clickElement(getValueRepeatEvery(repeatEvery));
        if (repeatEvery.equals("Custom")) {
            WebUI.clearTextElement(inputRepeatEveryCustom);
            WebUI.setTextElement(inputRepeatEveryCustom, numberRepeatEveryCustom);
            WebUI.clickElement(dropdownRepeatEveryCustom);
            WebUI.clickElement(getValueRepeatEveryCustom(typeRepeatEveryCustom));
        } else if (repeatEvery.equals("Week") || repeatEvery.equals("2 Weeks")
                || repeatEvery.equals("1 Months") || repeatEvery.equals("2 Months")
                || repeatEvery.equals("3 Months") || repeatEvery.equals("6 Months")
                || repeatEvery.equals("1 Year")) {
            WebUI.clickElement(checkboxInfinity);
            WebUI.clearTextElement(inputTotalCycles);
            WebUI.setTextElement(inputTotalCycles, totalCycles);
        } else {
            System.out.println("The Type Repeat Every is not exist.");
        }

        WebUI.scrollAtBottom(buttonSave);
        //Related To
        WebUI.clickElement(dropdownRelatedTo);
        WebUI.clickElement(getValueRelatedTo(relatedTo));
        WebUI.clickElement(dropdownTypeRelatedTo);
        WebUI.setTextElement(inputSearchTypeRelatedTo, typeRelatedTo);
        WebUI.sleep(1);
        Actions actions = new Actions(driver);
        actions.click(WebUI.getWebElement(inputSearchTypeRelatedTo)).sendKeys(" ").build().perform();
        WebUI.clickElement(getValueTypeRelatedTo(typeRelatedTo));

        //Assignees
        WebUI.clickElement(dropdownAssignees);
        WebUI.setTextElement(inputSearchAssignees, assignee);
        WebUI.clickElement(getValueAssignees(assignee));

        //Followers
        WebUI.clickElement(dropdownFollowers);
        WebUI.setTextElement(inputSearchFollowers, follower);
        WebUI.clickElement(getValueFollowers(follower));
        WebUI.clickElement(dropdownFollowers);

        //input
        WebUI.setTextAndKeyElement(inputTags, tag, Keys.ENTER);
        WebUI.clickElement(labelTags);
        WebUI.clickElement(labelTags);

        //iframe
        WebUI.clickElement(inputDescription);
        WebUI.switchToFrame(iframeDescription);
        WebUI.setTextElement(inputDescriptionFrame, description);
        WebUI.switchToParentFrame();
    }

    public void clickButtonSave() {
        WebUI.clickElement(buttonSave);
        WebUI.sleep(1);
    }

    public void verifyAddTaskSuccessMessage() {
        verifyAlertMessageSuccessDisplayed(addTaskSuccessMessage);
    }

    public void clickIconCloseAddTaskMessage() {
        WebUI.clickElement(iconCloseAddTaskSuccessMessage);
    }

    public void verifyUpdateTaskSuccessMessage() {
        verifyAlertMessageSuccessDisplayed(updateTaskSuccessMessage);
    }

    public void clickIconCloseUpdateTaskMessage() {
        WebUI.clickElement(iconCloseUpdateTaskSuccessMessage);
    }

    public void clickClosePopupTaskDetail(String taskName, int flagEdit) {
        WebUI.scrollAtTop(iconClosePopupTaskDetail(taskName));
        WebUI.clickElement(iconClosePopupTaskDetail(taskName));
    }


    public void searchAndCheckTask(String taskName) {
        driver.navigate().refresh();
        WebUI.sleep(1);
        WebUI.setTextElement(inputSearchTasks, taskName);
        WebUI.sleep(1);

        Assert.assertTrue(WebUI.checkElementExist(getFirstRowItemTaskName(taskName)),
                "Không đúng giá trị vừa thêm mới");
    }

    public void clickButtonEdit(String taskName) {
        WebUI.sleep(0.5);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(getFirstRowItemTaskName(taskName))).perform();
        WebUI.sleep(0.5);
        WebUI.clickElement(buttonEdit(taskName));
        WebUI.sleep(0.5);
    }

    public void verifyNewTaskInTaskEdit(String subject, String hourlyRate, String startDate, String dueDate, String priority,
                                        String repeatEvery, String numberRepeatEveryCustom, String typeRepeatEveryCustom, String totalCycles,
                                        String relatedTo, String typeRelatedTo, String tag, String description, int flag) {
        if (flag == 1) {
            Assert.assertTrue(WebUI.checkSeletedElement(checkboxPublic), "Checkbox không được chọn");
            Assert.assertTrue(WebUI.checkSeletedElement(checkboxBillable), "Checkbox không được chọn");
        }
        if (flag == 0) {
            Assert.assertFalse(WebUI.checkSeletedElement(checkboxPublic), "Checkbox được tích chọn");
            Assert.assertFalse(WebUI.checkSeletedElement(checkboxBillable), "Checkbox được tích chọn");
        }
        Assert.assertEquals(WebUI.getElementAttribute(inputSubject, "value").trim(),
                subject, "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementAttribute(inputStartDate, "value").trim(),
                startDate, "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementAttribute(inputDueDate, "value").trim(),
                dueDate, "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementText(dropdownPriority).trim(),
                priority, "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementText(dropdownRepeatEvery).trim(),
                repeatEvery, "Không đúng giá trị đã thêm mới");
        if (repeatEvery.equals("Custom")) {
            Assert.assertEquals(WebUI.getElementAttribute(inputRepeatEveryCustom, "value").trim(),
                    numberRepeatEveryCustom, "Không đúng giá trị đã thêm mới");
            Assert.assertEquals(WebUI.getElementText(dropdownRepeatEveryCustom).trim(),
                    typeRepeatEveryCustom, "Không đúng giá trị đã thêm mới");
        } else if (repeatEvery.equals("Week") || repeatEvery.equals("2 Weeks")
                || repeatEvery.equals("1 Months") || repeatEvery.equals("2 Months") || repeatEvery.equals("3 Months") || repeatEvery.equals("6 Months")
                || repeatEvery.equals("1 Year")) {
            Assert.assertFalse(WebUI.checkSeletedElement(checkboxInfinity), "Checkbox không được chọn");
            Assert.assertEquals(WebUI.getElementAttribute(inputTotalCycles, "value").trim(),
                    totalCycles, "Không đúng giá trị đã thêm mới");
        } else {
            System.out.println("Không tồn tại Type Repeat Every đã nhập");
        }
        Assert.assertEquals(WebUI.getElementText(dropdownRelatedTo).trim(), relatedTo,
                "Không đúng giá trị đã thêm mới");
        boolean containsTypeRelatedTo = WebUI.getElementText(dropdownTypeRelatedTo).contains(typeRelatedTo);
        Assert.assertTrue(containsTypeRelatedTo, "Không đúng giá trị đã thêm mới");
        Assert.assertFalse(WebUI.checkElementExist(dropdownAssignees), "Không đúng giá trị đã thêm mới");
        Assert.assertFalse(WebUI.checkElementExist(dropdownFollowers), "Không đúng giá trị đã thêm mới");
        Assert.assertEquals(WebUI.getElementText(inputTagsEdit).trim().toLowerCase(), tag,
                "Không đúng giá trị đã thêm mới");
        WebUI.switchToFrame(iframeDescription);
        Assert.assertEquals(WebUI.getElementText(inputDescriptionFrame).trim().toLowerCase(), description,
                "Không đúng giá trị đã thêm mới");
        driver.switchTo().parentFrame();
    }

    public void fillDataEdit(String subject, String hourlyRate, String startDate, String dueDate, String priority, String repeatEvery,
                             String numberRepeatEveryCustom, String typeRepeatEveryCustom, String totalCycles, String relatedTo,
                             String typeRelatedTo, String assignee, String follower, String tag, String description, int flag) throws AWTException {
        Actions actions = new Actions(driver);
        Robot robot = new Robot();
        WebUI.sleep(1);
        //checkbox
        if (flag == 1) {
            actions.click(WebUI.getWebElement(checkboxPublic)).perform();
            WebUI.sleep(0.5);
        }
        if (flag == 0) {
            actions.click(WebUI.getWebElement(checkboxBillable)).perform();
            WebUI.sleep(0.5);
        }

        //input
        WebElement elementSubject = WebUI.getWebElement(inputSubject);
        actions.click(elementSubject).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
        actions.sendKeys(elementSubject, subject).perform();
        WebUI.sleep(0.5);

        WebElement elementHourlyRate = WebUI.getWebElement(inputHourlyRate);
        actions.click(elementHourlyRate).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
        actions.sendKeys(elementHourlyRate, hourlyRate).perform();
        WebUI.sleep(0.5);

        WebElement elementStartDate = WebUI.getWebElement(inputStartDate);
        actions.click(elementStartDate).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
        actions.sendKeys(elementStartDate, startDate).perform();
        WebUI.sleep(0.5);

        WebElement elementDueDate = WebUI.getWebElement(inputDueDate);
        actions.click(elementDueDate).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
        actions.sendKeys(elementDueDate, dueDate).perform();
        WebUI.sleep(0.5);

        //Priority
        actions.click(WebUI.getWebElement(dropdownPriority)).perform();
        WebUI.sleep(0.5);
        actions.click(WebUI.getWebElement(getValuePriority(priority))).perform();
        WebUI.sleep(0.5);

        //Repeat every
        actions.click(WebUI.getWebElement(dropdownRepeatEvery)).perform();
        WebUI.sleep(1);
        actions.click(WebUI.getWebElement(getValueRepeatEvery(repeatEvery))).perform();
        WebUI.sleep(0.5);
        if (repeatEvery.equals("Custom")) {
            WebElement elementRepeatEveryCustom = WebUI.getWebElement(inputRepeatEveryCustom);
            actions.click(elementRepeatEveryCustom).perform();
            actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
            actions.sendKeys(elementRepeatEveryCustom, numberRepeatEveryCustom).perform();
            WebUI.sleep(0.5);
            actions.click(WebUI.getWebElement(dropdownRepeatEveryCustom)).perform();
            WebUI.sleep(1);
            actions.click(WebUI.getWebElement(getValueRepeatEveryCustom(typeRepeatEveryCustom))).perform();
            WebUI.sleep(0.5);
        } else if (repeatEvery.equals("Week") || repeatEvery.equals("2 Weeks")
                || repeatEvery.equals("1 Month") || repeatEvery.equals("2 Months") || repeatEvery.equals("3 Months") || repeatEvery.equals("6 Months")
                || repeatEvery.equals("1 Year")) {
            actions.click(WebUI.getWebElement(checkboxInfinity)).perform();
            WebUI.sleep(0.5);

            WebElement elementTotalCycles = WebUI.getWebElement(inputTotalCycles);
            actions.click(elementTotalCycles).perform();
            actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
            actions.sendKeys(elementTotalCycles, totalCycles).perform();
            WebUI.sleep(0.5);
        } else {
            System.out.println("Không tồn tại Type Repeat Every đã nhập");
        }

        WebUI.scrollAtBottom(buttonSave);
        //Related To
        actions.click(WebUI.getWebElement(dropdownRelatedTo)).perform();
        WebUI.sleep(1);
        actions.click(WebUI.getWebElement(getValueRelatedTo(relatedTo))).perform();
        WebUI.sleep(0.5);
        actions.click(WebUI.getWebElement(dropdownTypeRelatedTo)).perform();
        WebUI.sleep(0.5);
        actions.sendKeys(WebUI.getWebElement(inputSearchTypeRelatedTo), typeRelatedTo).perform();
        WebUI.sleep(1);
        actions.moveToElement(WebUI.getWebElement(getValueTypeRelatedTo(typeRelatedTo))).click().build().perform();
        WebUI.sleep(0.5);

        //input
        actions.moveToElement(WebUI.getWebElement(iconCloseTag)).click().build().perform();
        actions.sendKeys(WebUI.getWebElement(inputTags), tag).perform();
        WebUI.sleep(0.5);
        actions.click(WebUI.getWebElement(labelTags)).perform();
        actions.click(WebUI.getWebElement(labelTags)).perform();
        WebUI.sleep(0.5);

        //iframe
        actions.click(WebUI.getWebElement(inputDescription));
        WebUI.switchToFrame(iframeDescription);
        WebUI.sleep(0.5);
        actions.sendKeys(WebUI.getWebElement(inputDescriptionFrame), description);
        WebUI.sleep(0.5);
        WebUI.switchToParentFrame();
        WebUI.sleep(0.5);
    }

    public void clickButtonDelete(String taskName) {
        Actions action = new Actions(driver);
        action.moveToElement(WebUI.getWebElement(getFirstRowItemTaskName(taskName))).perform();
        WebUI.clickElement(buttonDelete(taskName));
    }

    public void confirmAlertDelete(int typeConfirm) {
        WebUI.sleep(0.5);
        if (typeConfirm == 1) {
            driver.switchTo().alert().accept();
        } else {
            driver.switchTo().alert().dismiss();
        }
    }

    public void verifyDeleteTaskSuccessMessage(int typeConfirm) {
        if (typeConfirm == 1) {
            Assert.assertTrue(WebUI.checkElementExist(getDeleteTaskSuccessMessage()),
                    "The success message for deleting a task is not displayed");
        } else {
            Assert.assertFalse(WebUI.checkElementExist(getDeleteTaskSuccessMessage()),
                    "The success message for deleting a task is not displayed");
        }
    }

    public void clickIconCloseDeleteTaskMessage(int typeConfirm) {
        if (typeConfirm == 1) {
            WebUI.sleep(1);
            WebUI.clickElement(iconCloseDeleteTaskSuccessMessage);
        }
    }

    public void verifyAfterDeleteTask(String taskName, int typeConfirm) {
        WebUI.sleep(0.5);
        WebUI.setTextElement(inputSearchTasks, taskName);
        if (typeConfirm == 1) {
            Assert.assertFalse(WebUI.checkElementExist(getFirstRowItemTaskName(taskName)), "Xóa Task không thành công");
        } else {
            Assert.assertTrue(WebUI.checkElementExist(getFirstRowItemTaskName(taskName)), "Huỷ xóa Task không thành công");
        }
    }
}
