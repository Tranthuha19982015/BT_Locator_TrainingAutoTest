package com.hatester.projects.mappers;

import com.hatester.projects.models.LoginData;

import java.util.Map;

public class LoginDataMapper {
    public static LoginData loginMapper(Map<String, String> map) {
        LoginData login = new LoginData();
        login.setEmail(map.get("EMAIL"));
        login.setPassword(map.get("PASSWORD"));
        login.setExpectedResult(map.get("EXPECTED_RESULT"));
        return login;
    }
}
