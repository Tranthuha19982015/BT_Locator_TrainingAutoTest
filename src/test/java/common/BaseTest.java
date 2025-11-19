package common;

import com.hatester.bt_locators.LocatorLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class BaseTest {
    public WebDriver driver;
    public SoftAssert softAssert;

    public boolean checkExistsElement(String xpathElement) {
        List<WebElement> element = driver.findElements(By.xpath(xpathElement));
        if (element.size() > 0) {
            System.out.println("Phần tử tồn tại: true" + xpathElement);
            return true;
        } else {
            System.out.println("Phần tử không tồn tại: false" + xpathElement);
            return false;
        }
    }

    public void loginCRM() throws InterruptedException {
        driver.get(LocatorLoginPage.url);
        Thread.sleep(500);

        driver.findElement(By.xpath(LocatorLoginPage.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorLoginPage.inputEmail)).sendKeys("admin@example.com");
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLoginPage.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorLoginPage.inputPassword)).sendKeys("123456");
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorLoginPage.buttonLogin)).click();
        Thread.sleep(1000);

        Assert.assertTrue(checkExistsElement(LocatorLoginPage.menuDashboard),"Đăng nhập không thành công!");
    }

    @BeforeMethod
    public void createDriver() throws InterruptedException {
        System.out.println("Khởi tạo trình duyệt Chrome");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        softAssert = new SoftAssert();
        loginCRM();
    }

    @AfterMethod
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
            System.out.println("Đóng trình duyệt");
        }
        softAssert.assertAll();
    }
}
