package com.hatester.dataprovider;

import com.hatester.helpers.ExcelHelper;
import com.hatester.mappers.LeadDataMapper;
import com.hatester.models.LeadData;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataProviderFactory {
    //DataProvider là ENTRY POINT (Entry point = điểm BẮT ĐẦU mà hệ thống gọi vào để chạy code)
    @DataProvider(name = "leadData")
    private Object[][] getLeadDataByType() {
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

    @DataProvider(name = "editLeadData")
    public Object[][] editLeadData() {
        ExcelHelper excelHelper = new ExcelHelper();

        Object[][] rawData = excelHelper.getDataMap("src/test/resources/datatest/dataCRM.xlsx", "Leads", 1, 2);

        int totalRows = rawData.length;
        int totalTestCases = totalRows / 2;

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
