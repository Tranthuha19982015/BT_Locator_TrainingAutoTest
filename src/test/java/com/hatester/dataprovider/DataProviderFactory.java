package com.hatester.dataprovider;

import com.hatester.helpers.ExcelHelper;
import com.hatester.mappers.LeadDataMapper;
import com.hatester.models.LeadData;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.Map;

public class DataProviderFactory {
    //----------------------------------- Login -----------------------------------------------/
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        ExcelHelper excel = new ExcelHelper();
        Object[][] data = excel.getDataMap("src/test/resources/datatest/dataCRM.xlsx", "Login", 1,5);
        return data;
    }


    //----------------------------------- Leads -----------------------------------------------/
    //DataProvider là ENTRY POINT (Entry point = điểm BẮT ĐẦU mà hệ thống gọi vào để chạy code)
    @DataProvider(name = "addLeadData")
    public Object[][] addLeadData() {
        ExcelHelper excel = new ExcelHelper();
        Object[][] rawData = excel.getDataMap("src/test/resources/datatest/dataCRM.xlsx", "Leads", 1, 1);

        Object[][] finalData = new Object[rawData.length][1];

        for (int i = 0; i < rawData.length; i++) {
            Map<String, String> rowData = (Map<String, String>) rawData[i][0];
            LeadData leadData = LeadDataMapper.fromMap(rowData);
            finalData[i][0] = leadData;
        }
        return finalData;
    }

    //DataProvider cung cấp nhiều cặp dữ liệu add - edit cho TCs
    @DataProvider(name = "editLeadData")
    public Object[][] editLeadData() {
        ExcelHelper excelHelper = new ExcelHelper();

        //đọc dữ liệu excel từ dòng 1 đến dòng 2 => có 2 dòng dữ liệu
        Object[][] rawData = excelHelper.getDataMap("src/test/resources/datatest/dataCRM.xlsx", "Leads", 1, 2);

        int totalRows = rawData.length; //tổng số lượng hàng (TH này là 2)
        int totalTestCases = totalRows / 2;  //tổng số TCs (TH này là 1

        //mảng 2 chiều để lưu trữ kết quả cuối cùng (trong TH này là [1][2])
        //Mảng 2 chiều có 1 dòng dữ liệu và 2 cột (tương ứng với 2 tham số: 1 tham số là addLead, 1 tham số là editLead)
        Object[][] result = new Object[totalTestCases][2];

        int index = 0;

        for (int i = 0; i < totalRows; i += 2) {

            Map<String, String> addMap = (Map<String, String>) rawData[i][0];

            Map<String, String> editMap = (Map<String, String>) rawData[i + 1][0];

            LeadData addLead = LeadDataMapper.fromMap(addMap);
            LeadData editLead = LeadDataMapper.fromMap(editMap);

            result[index][0] = addLead;
            result[index][1] = editLead;

            index++;
        }
        return result;
    }
}
