package com.hatester.pages;

import com.hatester.keywords.WebUI;
import com.hatester.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        new WebUI(driver);
    }

    private String url = "https://crm.anhtester.com/admin/authentication";

    private By headerLoginPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By checkboxRememberMe = By.xpath("//input[@id='remember']");
    private By linkForgotPassword = By.xpath("//a[normalize-space()='Forgot Password?']");
    private By errorMessageInvalidEmailOrPassword = By.xpath("//div[@id='alerts']/div[normalize-space()='Invalid email or password']");
    private By errorMessageEmailRequired = By.xpath("//div[text()='The Email Address field is required.' and contains(@class,'alert-danger')]");
    private By errorMessagePasswordRequired = By.xpath("//div[text()='The Password field is required.' and contains(@class,'alert-danger')]");

    public void navigateToCRM() {
        WebUI.openURL(url);
    }

    public void verifyHeaderLogin() {
        Assert.assertTrue(WebUI.checkElementExist(headerLoginPage), "The header Login is not display.");
    }

    private void enterEmail(String email) {
        WebUI.setTextElement(inputEmail, email);
    }

    private void enterPassword(String password) {
        WebUI.setTextElement(inputPassword, password);
    }

    private void clickButtonLogin() {
        WebUI.clickElement(buttonLogin);
    }

    public void loginCRM(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickButtonLogin();
    }

    public DashboardPage loginCRM() {
        navigateToCRM();
        verifyHeaderLogin();
        enterEmail("admin@example.com");
        enterPassword("123456");
        clickButtonLogin();
        verifyLoginSuccess();
        return new DashboardPage(driver);
    }

    public void verifyLoginSuccess() {
        WebUI.sleep(1);
        String actualCurrentURL = WebUI.getCurrentURL(driver);
        String expectedURL = "https://crm.anhtester.com/admin/";

        Assert.assertTrue((WebUI.checkElementExist(menuDashboard) && actualCurrentURL.equals(expectedURL)),
                "Login failed!");
    }

    public void verifyLoginFailedWithEmailRequired() {
        WebUI.sleep(1);
        Assert.assertTrue(WebUI.checkElementExist(errorMessageEmailRequired),
                "The email required error message is not displayed");
    }

    public void verifyLoginFailedWithPasswordRequired() {
        WebUI.sleep(1);
        Assert.assertTrue(WebUI.checkElementExist(errorMessagePasswordRequired),
                "The password required error message is not displayed.");
    }

    public void verifyLoginFailedWithEmailInvalid() {
        WebUI.sleep(1);
        Assert.assertTrue(WebUI.checkElementExist(errorMessageInvalidEmailOrPassword),
                "The invalid email error message is not displayed.");
    }

    public void verifyLoginFailedWithPasswordInvalid() {
        WebUI.sleep(1);
        Assert.assertTrue(WebUI.checkElementExist(errorMessageInvalidEmailOrPassword),
                "The invalid password error message is not displayed.");
    }
}
