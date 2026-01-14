package com.hatester.projects.models;

import lombok.Data;

@Data
public class TaskData {
    private boolean checkedCheckbox;
    private String taskName;
    private String hourlyRate;
    private String startDate;
    private String dueDate;
    private String priority;
    private String repeatEvery;
    private String numberRepeatEveryCustom;
    private String typeRepeatEveryCustom;
    private String totalCycles;
    private String relateTo;
    private String typeRelateTo;
    private String assignee;
    private String follower;
    private String tag;
    private String description;
    private String testType;
    private int typeConfirm;
}
