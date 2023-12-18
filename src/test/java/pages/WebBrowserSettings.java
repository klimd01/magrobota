package pages;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebBrowserSettings {
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/ui/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Test start");
    }

    @After
    public void close() {
        System.out.println("Test end");
        driver.quit();
    }

}
