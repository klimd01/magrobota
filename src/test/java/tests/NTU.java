package tests;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Main;
import pages.WebBrowserSettings;
import ui.configs.ConfigProvider;
import org.testng.annotations.Test;


public class NTU extends WebBrowserSettings {
    //1
    @Test(priority=10)
    public void ChangeLanguage() {
        Main main = PageFactory.initElements(driver, Main.class);
        driver.get(ConfigProvider.BASE_URL);
        main.maxSize();
        main.getLanguageChange();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,ConfigProvider.EN_URL);
        driver.get(ConfigProvider.BASE_URL);
    }
    //2
    @Test(priority=2)
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
    @Test(priority=3)
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
    }
    //4
    @Test(priority=4)
    public void Payment() {
        Main main = PageFactory.initElements(driver, Main.class);
        driver.get(ConfigProvider.BASE_URL);
        main.maxSize();
        By findPayment = By.xpath("//*[@id=\"widget-rmenu\"]/div[2]/div/h4[2]/b/a");
        driver.findElement(findPayment).click();
        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,ConfigProvider.PAYMENT_URL);
    }
    //5
    @Test(priority=5)
    public void PaymentRec() {
        Main main = PageFactory.initElements(driver, Main.class);
        driver.get(ConfigProvider.BASE_URL);
        main.maxSize();
        By findPaymentRec = By.xpath("//*[@id=\"menu-item-4350\"]/a");
        driver.findElement(findPaymentRec).click();
        By findPaymentRah = By.xpath("//*[@id=\"post-4343\"]/div/table/tbody/tr[2]/td[3]/span");
        String paymentRecString = driver.findElement(findPaymentRah).getText();
        Assert.assertTrue(paymentRecString.contains(ConfigProvider.PAYMENT_RAH));
    }
    //6
    @Test(priority=6)
    public void Search() {
        Main main = PageFactory.initElements(driver, Main.class);
        driver.get(ConfigProvider.BASE_URL);
        main.maxSize();
        By findSearch = By.xpath("//*[@id=\"widget-search\"]/div/form/label/input");
        driver.findElement(findSearch).sendKeys(ConfigProvider.SEARCH_CHECK);
        String str = "news";
        Assert.assertEquals(str, ConfigProvider.SEARCH_CHECK);
    }
    //7
    @Test(priority=7)
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
    @Test(priority=8)
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
    @Test(priority=9)
    public void Faculties() {
        Main main = PageFactory.initElements(driver, Main.class);
        driver.get(ConfigProvider.BASE_URL);
        main.maxSize();
        By findFaculties = By.xpath("//*[@id=\"menu-item-215\"]/a");
        driver.findElement(findFaculties).click();
        By chooseFaculty = By.xpath("//*[@id=\"post-97\"]/div/p[5]/a");
        driver.findElement(chooseFaculty).click();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,ConfigProvider.TEACHERS_URL);
    }
    //10
    @Test(priority=1)
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
