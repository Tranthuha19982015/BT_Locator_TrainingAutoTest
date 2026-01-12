package com.hatester.models;

public class LoginData {
    String email;
    String password;
    String expectedResult;

    //TestNG + Allure KHÔNG biết DTO là gì
    //vì DTO là object → phải dạy Java cách “in nó ra”
    //DTO dùng cho: DataProvider, logging, reporting => BẮT BUỘC override toString()
    //Không override toString() thì mỗi lần này nó sẽ hiển thị kiểu này: LoginData@55f54852
    //Có override toString(): testLogin[admin@example.com | password:123456 | expectedResult:success]
    /**
     * RẤT QUAN TRỌNG:
     * - Dùng cho Allure
     * - Dùng cho log
     * - KHÔNG in plain password
     */
    @Override
    public String toString() {
        return String.format("email: %s | password: %s | expectedResult: %s", email, password, expectedResult);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }
}
