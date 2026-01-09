package com.hatester.mappers;

import com.hatester.models.TaskData;

import java.util.Map;

public class TaskDataMapper {
    public static TaskData taskMapper(Map<String, String> map) {
        TaskData taskData = new TaskData();
        taskData.setCheckedCheckbox(Integer.parseInt(map.get("CHECKED")));
        taskData.setTaskName(map.get("TASK_NAME"));
        taskData.setHourlyRate(map.get("HOURLY_RATE"));
        taskData.setStartDate(map.get("START_DATE"));
        taskData.setDueDate(map.get("DUE_DATE"));
        taskData.setPriority(map.get("PRIORITY"));
        taskData.setRepeatEvery(map.get("REPEAT_EVERY"));
        taskData.setNumberRepeatEveryCustom(map.get("NUMBER_REPEAT_EVERY_CUSTOM"));
        taskData.setTypeRepeatEveryCustom(map.get("TYPE_REPEAT_EVERY_CUSTOM"));
        taskData.setTotalCycles(map.get("TOTAL_CYCLES"));
        taskData.setRelateTo(map.get("RELATED_TO"));
        taskData.setTypeRelateTo(map.get("TYPE_RELATED_TO"));
        taskData.setAssignee(map.get("ASSIGNEE"));
        taskData.setFollower(map.get("FOLLOWER"));
        taskData.setTag(map.get("TAG"));
        taskData.setDescription(map.get("DESCRIPTION"));
        taskData.setTestType(map.get("TEST_TYPE"));
        taskData.setTypeConfirm(Integer.parseInt(map.get("TYPE_CONFIRM")));
        return taskData;
    }
}
