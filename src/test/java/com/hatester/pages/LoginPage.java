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
        WebUI.openURL(driver, url);
    }

    public void verifyHeaderLogin() {
        Assert.assertTrue(WebUI.checkExistsElement(driver, headerLoginPage), "The header Login is not display.");
    }

    public void enterEmail(String email) {
        WebUI.setTextElement(driver, inputEmail, email);
    }

    public void enterPassword(String password) {
        WebUI.setTextElement(driver, inputPassword, password);
    }

    public void clickButtonLogin() {
        WebUI.clickElement(driver, buttonLogin);
    }

    public void loginCRM(String email, String password) throws InterruptedException {
        enterEmail(email);
        enterPassword(password);
        clickButtonLogin();
    }

    public DashboardPage loginCRM() throws InterruptedException {
        navigateToCRM();
        verifyHeaderLogin();
        enterEmail("admin@example.com");
        enterPassword("123456");
        clickButtonLogin();
        verifyLoginSuccess();
        return new DashboardPage(driver);
    }

    public void verifyLoginSuccess() throws InterruptedException {
        Thread.sleep(1000);
        String actualCurrentURL = WebUI.getCurrentURL(driver);
        String expectedURL = "https://crm.anhtester.com/admin/";

        Assert.assertTrue((WebUI.checkExistsElement(driver, menuDashboard) && actualCurrentURL.equals(expectedURL)),
                "Login failed!");
    }

    public void verifyLoginFailedWithEmailRequired() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(WebUI.checkExistsElement(driver, errorMessageEmailRequired),
                "The email required error message is not displayed");
    }

    public void verifyLoginFailedWithPasswordRequired() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(WebUI.checkExistsElement(driver, errorMessagePasswordRequired),
                "The password required error message is not displayed.");
    }

    public void verifyLoginFailedWithEmailInvalid() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(WebUI.checkExistsElement(driver, errorMessageInvalidEmailOrPassword),
                "The invalid email error message is not displayed.");
    }

    public void verifyLoginFailedWithPasswordInvalid() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(WebUI.checkExistsElement(driver, errorMessageInvalidEmailOrPassword),
                "The invalid password error message is not displayed.");
    }
}
