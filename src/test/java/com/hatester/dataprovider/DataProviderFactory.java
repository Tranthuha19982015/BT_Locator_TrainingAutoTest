package com.hatester.dataprovider;

import com.hatester.helpers.ExcelHelper;
import com.hatester.projects.mappers.LeadDataMapper;
import com.hatester.projects.mappers.LoginDataMapper;
import com.hatester.projects.mappers.TaskDataMapper;
import com.hatester.projects.models.LeadData;
import com.hatester.projects.models.LoginData;
import com.hatester.projects.models.TaskData;
import org.testng.annotations.DataProvider;

import java.util.Map;

public class DataProviderFactory {
    //----------------------------------- Login -----------------------------------------------/
    @DataProvider(name = "loginData", parallel = false)
    public Object[][] getLoginData() {
        ExcelHelper excel = new ExcelHelper();

        Object[][] excelDataMap = excel.getDataMap("src/test/resources/datatest/dataCRM.xlsx", "Login", 1, 5);

        Object[][] finalData = new Object[excelDataMap.length][1];

        for (int i = 0; i < excelDataMap.length; i++) {
            Map<String, String> row = (Map<String, String>) excelDataMap[i][0];
            LoginData login = LoginDataMapper.loginMapper(row);
            finalData[i][0] = login;
        }
        return finalData;
    }


    //----------------------------------- Leads -----------------------------------------------/
    //DataProvider là ENTRY POINT (Entry point = điểm BẮT ĐẦU mà hệ thống gọi vào để chạy code)
    //Object[][] {
    // {leadData1} ,
    // {leadData2}
    // }
    @DataProvider(name = "addLeadData")
    public Object[][] getLeadDataAdd() {
        ExcelHelper excel = new ExcelHelper();
        Object[][] excelDataMap = excel.getDataMap("src/test/resources/datatest/dataCRM.xlsx", "Leads", 1, 1);

        Object[][] finalData = new Object[excelDataMap.length][1]; //[1] là số lượng cột

        for (int i = 0; i < excelDataMap.length; i++) {
            Map<String, String> row = (Map<String, String>) excelDataMap[i][0]; //[0] là index của cột
            LeadData leadData = LeadDataMapper.leadMapper(row);
            finalData[i][0] = leadData;
        }
        return finalData;
    }

    //DataProvider cung cấp nhiều cặp dữ liệu add - edit cho TCs
    //Object[][] {
    //   { addLeadData1 , editLeadData1 },
    //   { addLeadData2 , editLeadData2 }
    //}
    @DataProvider(name = "editLeadData")
    public Object[][] editLeadData() {
        ExcelHelper excel = new ExcelHelper();

        //đọc dữ liệu excel từ dòng 1 đến dòng 2 => có 2 dòng dữ liệu
        //rawData[0][0] = Map (ADD TC01)
        //rawData[1][0] = Map (EDIT TC01)
        Object[][] excelDataMap = excel.getDataMap("src/test/resources/datatest/dataCRM.xlsx", "Leads", 1, 2);

        int totalRows = excelDataMap.length; //tổng số lượng hàng (TH này là 2)
        int totalTestCases = totalRows / 2;  //tổng số TCs (TH này là 1)

        //mảng 2 chiều để lưu trữ kết quả cuối cùng (trong TH này là [1][2])
        //Mảng 2 chiều có 1 dòng dữ liệu và 2 cột (tương ứng với 2 tham số: 1 tham số là addLead, 1 tham số là editLead)
        //index	    result[index][0]	result[index][1]
        //0	        ADD TC01	        EDIT TC01
        Object[][] result = new Object[totalTestCases][2]; //cố định là 2 tham số - 2 cột

        int index = 0; //đại diện cho TCs hiện tại (index = 0 → TC01)

        for (int i = 0; i < totalRows; i += 2) {
            Map<String, String> addMap = (Map<String, String>) excelDataMap[i][0];
            Map<String, String> editMap = (Map<String, String>) excelDataMap[i + 1][0];

            LeadData addLead = LeadDataMapper.leadMapper(addMap);
            LeadData editLead = LeadDataMapper.leadMapper(editMap);

            //cùng 1 TCs nên có cùng index, chỉ khác số cột: 0 - addLead, 1 - editLead
            result[index][0] = addLead;
            result[index][1] = editLead;

            index++;
        }
        return result;
    }

    @DataProvider(name = "addTaskData")
    public Object[][] getAddTaskData() {
        ExcelHelper excel = new ExcelHelper();
        Object[][] excelDataMap = excel.getDataMap("src/test/resources/datatest/dataCRM.xlsx", "Tasks", 1, 1);

        Object[][] finalData = new Object[excelDataMap.length][1];

        for (int i = 0; i < excelDataMap.length; i++) {
            Map<String, String> row = (Map<String, String>) excelDataMap[i][0];
            TaskData task = TaskDataMapper.taskMapper(row);
            finalData[i][0] = task;
        }
        return finalData;
    }

    @DataProvider(name = "editTaskData")
    public Object[][] getEditTaskData() {
        ExcelHelper excel = new ExcelHelper();
        Object[][] excelTaskMap = excel.getDataMap("src/test/resources/datatest/dataCRM.xlsx", "Tasks", 1, 2);

        int totalRows = excelTaskMap.length;
        int totalTestcase = totalRows / 2;

        Object[][] finalData = new Object[totalTestcase][2];

        int index = 0;

        for (int i = 0; i < totalRows; i += 2) {
            Map<String, String> addRow = (Map<String, String>) excelTaskMap[i][0];
            Map<String, String> editRow = (Map<String, String>) excelTaskMap[i + 1][0];

            TaskData addTask = TaskDataMapper.taskMapper(addRow);
            TaskData editTask = TaskDataMapper.taskMapper(editRow);

            finalData[index][0] = addTask;
            finalData[index][1] = editTask;
        }
        return finalData;
    }
}
