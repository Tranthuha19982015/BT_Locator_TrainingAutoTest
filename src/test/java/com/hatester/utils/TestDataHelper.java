package com.hatester.utils;

import com.hatester.models.LeadData;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDataHelper {

    //Tạo ra 1 bản dữ liệu Lead MỚI, KHÔNG BỊ TRÙNG, dựa trên dữ liệu gốc từ Excel.
//    leadData là data DataProvider cấp
//    Có thể bị dùng lại ở test khác
//    Debug khó
//    Data bị “bẩn”
    public static LeadData prepareUniqueLead(LeadData source) {
        String dateTime = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());

        LeadData target = new LeadData();
        target.setLeadName(source.getLeadName() + dateTime);
        target.setEmailAddress(source.getEmailAddress() + dateTime + "@gmail.com");

        return target;
    }
}
