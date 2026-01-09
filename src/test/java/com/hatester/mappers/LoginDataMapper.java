package com.hatester.mappers;

import com.hatester.models.LoginData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
