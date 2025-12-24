package com.hatester.models;

public class TaskData {
    private int isCheckedCheckbox;
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
    private int flagEdit;
    private int typeConfirm;

    public int getCheckedCheckbox() {
        return isCheckedCheckbox;
    }

    public void setCheckedCheckbox(int isCheckedCheckbox) {
        this.isCheckedCheckbox = isCheckedCheckbox;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(String hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getRepeatEvery() {
        return repeatEvery;
    }

    public void setRepeatEvery(String repeatEvery) {
        this.repeatEvery = repeatEvery;
    }

    public String getTypeRepeatEveryCustom() {
        return typeRepeatEveryCustom;
    }

    public void setTypeRepeatEveryCustom(String typeRepeatEveryCustom) {
        this.typeRepeatEveryCustom = typeRepeatEveryCustom;
    }

    public String getNumberRepeatEveryCustom() {
        return numberRepeatEveryCustom;
    }

    public void setNumberRepeatEveryCustom(String numberRepeatEveryCustom) {
        this.numberRepeatEveryCustom = numberRepeatEveryCustom;
    }

    public String getTotalCycles() {
        return totalCycles;
    }

    public void setTotalCycles(String totalCycles) {
        this.totalCycles = totalCycles;
    }

    public String getRelateTo() {
        return relateTo;
    }

    public void setRelateTo(String relateTo) {
        this.relateTo = relateTo;
    }

    public String getTypeRelateTo() {
        return typeRelateTo;
    }

    public void setTypeRelateTo(String typeRelateTo) {
        this.typeRelateTo = typeRelateTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getFlagEdit() {
        return flagEdit;
    }

    public void setFlagEdit(int flagEdit) {
        this.flagEdit = flagEdit;
    }

    public int getTypeConfirm() {
        return typeConfirm;
    }

    public void setTypeConfirm(int typeConfirm) {
        this.typeConfirm = typeConfirm;
    }
}
