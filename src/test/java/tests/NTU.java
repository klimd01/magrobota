package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.Main;
import pages.WebBrowserSettings;
import ui.configs.ConfigProvider;

public class NTU extends WebBrowserSettings {
    //1
    @Test
    public void ChangeLanguage() {
        Main main = PageFactory.initElements(driver, Main.class);
        driver.get(ConfigProvider.BASE_URL);
        main.maxSize();
        main.getLanguageChange();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,ConfigProvider.EN_URL);
    }
    //2
    @Test
    public void BaseInformation() {
        Main main = PageFactory.initElements(driver, Main.class);
        driver.get(ConfigProvider.BASE_URL);
        main.maxSize();
        By findPhoneNumber = By.xpath("/html/body/footer/div/div/div/address");
        String phonenumberString = driver.findElement(findPhoneNumber).getText();
        Assert.assertTrue(phonenumberString.contains(ConfigProvider.UNI_PHONENUMBER));
        //Assert.assertTrue(phonenumberString.contentEquals(ConfigProvider.UNI_PHONENUMBER));
        //By findAddress = By.xpath("/html/body/footer/div/div/div/address");
        //String actualString = driver.findElement(findAddress).getText();
        //Assert.assertTrue(actualString.contains(ConfigProvider.UNI_ADDRESS));
    }
    //3
    @Test
    public void Schedule() {
        Main main = PageFactory.initElements(driver, Main.class);
        driver.get(ConfigProvider.BASE_URL);
        main.maxSize();
        By findSchedule = By.xpath("//*[@id=\"menu-menu-left-1\"]/li[2]/a");
        driver.findElement(findSchedule).click();
        By findMag = By.xpath("//*[@id=\"post-50\"]/div/table[1]/tbody/tr[5]/td[4]/a");
        driver.findElement(findMag).click();
        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,ConfigProvider.SCHEDULE_URL);
        //By findCS = By.xpath("//*[@id=\"post-50\"]/div/table[1]/tbody/tr[5]/td[4]/a");
        //String actualString = driver.findElement(ConfigProvider.FINAL_F).getText();
        //Assert.assertTrue(actualString.contains(ConfigProvider.FINAL_F));
    }
    //4
    @Test
    public void Payment() {
        Main main = PageFactory.initElements(driver, Main.class);
        driver.get(ConfigProvider.BASE_URL);
        main.maxSize();
        By findPayment = By.xpath("//*[@id=\"widget-rmenu\"]/div[2]/div/h4[2]/b/a");
        driver.findElement(findPayment).click();
        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
        //By findPaymentMenu = By.xpath("//*[@id=\"app\"]/div[2]/section/div/div/div[3]/div/div[1]/div/div[1]/h3");
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,ConfigProvider.PAYMENT_URL);
        //String actualString = driver.findElement(findPaymentMenu).getText();
        //Assert.assertTrue(actualString.contains(ConfigProvider.FINAL_PM));
    }
    //5
    @Test
    public void PaymentRec() {
        Main main = PageFactory.initElements(driver, Main.class);
        driver.get(ConfigProvider.BASE_URL);
        main.maxSize();
        By findPaymentRec = By.xpath("//*[@id=\"menu-item-4350\"]/a");
        driver.findElement(findPaymentRec).click();
        By findPaymentRah = By.xpath("//*[@id=\"post-4343\"]/div/table/tbody/tr[2]/td[3]/span");
        String paymentRecString = driver.findElement(findPaymentRah).getText();
        Assert.assertTrue(paymentRecString.contains(ConfigProvider.PAYMENT_RAH));
        //main.getMapOpen();
        //String URL = driver.getCurrentUrl();
        //Assert.assertEquals(URL, ConfigProvider.FINAL_MAP);
    }
    //6
    @Test
    public void Search() {
        Main main = PageFactory.initElements(driver, Main.class);
        driver.get(ConfigProvider.BASE_URL);
        main.maxSize();
        By findSearch = By.xpath("//*[@id=\"widget-search\"]/div/form/label/input");
        driver.findElement(findSearch).sendKeys(ConfigProvider.SEARCH_CHECK);
        //String str = "розклад";
        //Assert.assertEquals(str, ConfigProvider.SEARCH_CHECK);
        //By findSearchResult = By.xpath("//*[@id=\"content\"]/div/header");
        //wait.until(ExpectedConditions.visibilityOfElementLocated(findSearchResult));
        //String actualString = driver.findElement(findSearchResult).getText();
        //Assert.assertTrue(actualString.contains(ConfigProvider.SEARCH_CHECK));
    }
    //7
    @Test
    public void Img() {
        Main main = PageFactory.initElements(driver, Main.class);
        driver.get(ConfigProvider.BASE_URL);
        main.maxSize();
        int width=driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/img")).getSize().getWidth();
        int height=driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/img")).getSize().getHeight();
        String w=Integer.toString(width);
        String h=Integer.toString(height);
        Assert.assertEquals(h,ConfigProvider.FINAL_HEIGHT);
        Assert.assertEquals(w,ConfigProvider.FINAL_WIDTH);
    }
    //8
    @Test
    public void restyp() {
        Main main = PageFactory.initElements(driver, Main.class);
        //WebDriver driver = new ChromeDriver();
        driver.get(ConfigProvider.BASE_URL);
        main.maxSize();
        By findStydentiv = By.xpath("//*[@id=\"menu-item-4291\"]/a");
        driver.findElement(findStydentiv).click();
        By findFaculty = By.xpath("//*[@id=\"post-4283\"]/div/p[5]/a");
        driver.findElement(findFaculty).click();
        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
        //WebElement e = driver.findElement(By.xpath("//*[text()='науки']"));
        //String actualString = driver.findElement(findSpecialty).getText();
        //Assert.assertTrue(e.equals(ConfigProvider.SPECIALTY_SEARCH));
    }
    //9
    @Test
    public void Faculties() {
        Main main = PageFactory.initElements(driver, Main.class);
        //WebDriver driver = new ChromeDriver();
        driver.get(ConfigProvider.BASE_URL);
        main.maxSize();
        By findFaculties = By.xpath("//*[@id=\"menu-item-215\"]/a");
        driver.findElement(findFaculties).click();
        By chooseFaculty = By.xpath("//*[@id=\"post-97\"]/div/p[5]/a");
        driver.findElement(chooseFaculty).click();
        By findTeacher = By.xpath("//*[@id=\"post-363\"]/div/p[2]");
        String actualString = driver.findElement(findTeacher).getText();
        //Assert.assertTrue(actualString.contains(ConfigProvider.TEACHER_SEARCH));
    }
    //10
    @Test
    public void Specialties() {
        Main main = PageFactory.initElements(driver, Main.class);
        //WebDriver driver = new ChromeDriver();
        driver.get(ConfigProvider.BASE_URL);
        main.maxSize();
        By findSpecialties = By.xpath("//*[@id=\"menu-item-231\"]/a");
        driver.findElement(findSpecialties).click();
        By findSpecialty = By.xpath("//*[@id=\"post-176\"]/div/table/tbody/tr[41]/td[1]/a");
        driver.findElement(findSpecialty).click();
        By findpr = By.xpath("//*[@id=\"post-176\"]/div/p[100]/strong/a");
        driver.findElement(findpr).click();
        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
        //By chooseFaculty = By.xpath("//*[@id=\"post-97\"]/div/p[5]/a");
        //driver.findElement(chooseFaculty).click();
        //By findTeacher = By.xpath("//*[@id=\"post-363\"]/div/p[2]");
        //String actualString = driver.findElement(findTeacher).getText();
        //Assert.assertTrue(actualString.contains(ConfigProvider.TEACHER_SEARCH));
    }
}
