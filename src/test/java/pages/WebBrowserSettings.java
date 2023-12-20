package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebBrowserSettings {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeTest
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/ui/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Test start");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void close() {
        System.out.println("Test end");
        driver.quit();
    }

}
