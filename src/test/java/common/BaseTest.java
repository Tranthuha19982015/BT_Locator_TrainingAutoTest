package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;

    public void createDriver() {
        System.out.println("Khởi tạo trình duyệt Chrome");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
            System.out.println("Đóng trình duyệt");
        }
    }
}
