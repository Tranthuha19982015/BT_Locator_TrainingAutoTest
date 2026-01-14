package com.hatester.projects.models;

import lombok.Data;

//@Data sinh ra những gì cho class này?
//Tương đương với việc Lombok tự sinh:
    //getter()/setter()
    //toString()
    //equals() / hashCode()
    //Constructor với field final
//👉 Test, Mapper, PageObject vẫn dùng bình thường.

@Data
public class LeadData {
    private String leadName;
    private String status;
    private String source;
    private String assigned;
    private String tag;
    private String position;
    private String city;
    private String emailAddress;
    private String state;
    private String website;
    private String country;
    private String phone;
    private String zipCode;
    private String leadValue;
    private String language;
    private String company;
    private String description;
    private String lastContacted;

    //👉 Lombok (@Data) sẽ sinh ra:
    //    public boolean isCheckedCheckbox();      // getter
    //    public void setCheckedCheckbox(boolean); // setter
    //    Theo Java Bean Specification:
        //    boolean → getter phải là isXxx()
        //    Boolean → getter là getXxx()
    private boolean checkedCheckbox;
    private String testType;
    private int typeConfirm;
}
