package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.configs.ConfigProvider;

public class Main {
    private WebDriver driver;
    private WebDriverWait wait;

    public Main(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void maxSize() {
        driver.manage().window().maximize();
    }

    private By findLanguage = By.xpath("//*[@id=\"qtranslate-2-chooser\"]/li[2]/a");
    private By waitForLanguage = By.xpath("//*[@id=\"content\"]/p");

    public void getLanguageChange() {
        driver.findElement(findLanguage).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitForLanguage));
    }

}
