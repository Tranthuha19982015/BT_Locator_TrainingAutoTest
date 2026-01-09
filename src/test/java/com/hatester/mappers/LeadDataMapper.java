package com.hatester.mappers;

import com.hatester.models.LeadData;

import java.util.Map;

public class LeadDataMapper {
    public static LeadData leadMapper(Map<String, String> map) {
        LeadData lead = new LeadData();
        lead.setLeadName(map.get("LEAD_NAME"));
        lead.setStatus(map.get("STATUS"));
        lead.setSource(map.get("SOURCE"));
        lead.setAssigned(map.get("ASSIGNED"));
        lead.setTag(map.get("TAG"));
        lead.setPosition(map.get("POSITION"));
        lead.setCity(map.get("CITY"));
        lead.setEmailAddress(map.get("EMAIL_ADDRESS"));
        lead.setState(map.get("STATE"));
        lead.setWebsite(map.get("WEBSITE"));
        lead.setCountry(map.get("COUNTRY"));
        lead.setPhone(map.get("PHONE"));
        lead.setZipCode(map.get("ZIP_CODE"));
        lead.setLeadValue(map.get("LEAD_VALUE"));
        lead.setLanguage(map.get("LANGUAGE"));
        lead.setCompany(map.get("COMPANY"));
        lead.setDescription(map.get("DESCRIPTION"));
        lead.setLastContacted(map.get("LAST_CONTACTED"));
        lead.setCheckedCheckbox(Integer.parseInt(map.get("CHECKED")));
        lead.setTestType(map.get("TEST_TYPE"));
        lead.setTypeConfirm(Integer.parseInt(map.get("TYPE_CONFIRM")));

        return lead;
    }
}
