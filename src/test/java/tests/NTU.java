package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Main;
import pages.WebBrowserSettings;
import ui.configs.ConfigProvider;
import ui.configs.ConfigTestImg;
import ui.configs.ConfigTestLink;
import ui.configs.ConfigTestSearch;
import java.io.File;




public class NTU extends WebBrowserSettings {

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

    @Test(priority=2)
    public void ContactInformation() {
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

    @Test(priority=5)
    public void Paymentdetails() {
        Main main = PageFactory.initElements(driver, Main.class);
        driver.get(ConfigProvider.BASE_URL);
        main.maxSize();
        By findPaymentDetailPage = By.xpath("//*[@id=\"menu-item-4350\"]/a");
        driver.findElement(findPaymentDetailPage).click();
        By findPaymentdetail = By.xpath("//*[@id=\"post-4343\"]/div/table/tbody/tr[2]/td[3]/span");
        String paymentRecString = driver.findElement(findPaymentdetail).getText();
        Assert.assertTrue(paymentRecString.contains(ConfigProvider.PAYMENT_DETAILS));
    }

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

    @Test(priority=1)
    public void Specialties() {
        Main main = PageFactory.initElements(driver, Main.class);
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

    @Test(dataProvider = "data-links")
    public void UniversalLinkTest(String fileName) {
        Main main = PageFactory.initElements(driver, Main.class);
        driver.get(ConfigProvider.BASE_URL);
        main.maxSize();
        ConfigTestLink configTestLink = new ConfigTestLink(fileName);
        By linkToPage = By.xpath(configTestLink.url_link_to_page);
        driver.findElement(linkToPage).click();
        SoftAssert softAssert = new SoftAssert();
        By linkOnPage = By.xpath(configTestLink.url_link_on_page);
        WebElement webElementLinkOnPage = driver.findElement(linkOnPage);
        String hrefLinkOnPage = webElementLinkOnPage.getAttribute("href");
        softAssert.assertEquals(hrefLinkOnPage, configTestLink.assert_link_on_page);
//        By textLinkOnPage = By.xpath(ConfigTestLink.text_link_on_page);
//        WebElement webElementTextLinkOnPage = driver.findElement(textLinkOnPage);
//        String testTextLinkOnPage = webElementLinkOnPage.getText();
//        softAssert.assertEquals(testTextLinkOnPage, ConfigTestLink.assert_text_link_on_page);
        softAssert.assertAll();
    }

    @Test(dataProvider = "data-imgs")
    public void UniversalImgTest(String fileName) {
        Main main = PageFactory.initElements(driver, Main.class);
        driver.get(ConfigProvider.BASE_URL);
        main.maxSize();
        ConfigTestImg configTestImg = new ConfigTestImg(fileName);
        By linkToPage = By.xpath(ConfigTestImg.url_link_to_page);
        driver.findElement(linkToPage).click();
        SoftAssert softAssert = new SoftAssert();
        By imgOnPage = By.xpath(ConfigTestImg.img_on_page);
        WebElement webElementImgOnPage = driver.findElement(imgOnPage);
        int testImgWidthOnPage = webElementImgOnPage.getSize().getWidth();
        int testImgHeightOnPage = webElementImgOnPage.getSize().getHeight();
        String w=Integer.toString(testImgWidthOnPage);
        String h=Integer.toString(testImgHeightOnPage);
        softAssert.assertEquals(w, ConfigTestImg.assert_img_weight_on_page);
        softAssert.assertEquals(h, ConfigTestImg.assert_img_height_on_page);
        softAssert.assertAll();
    }

    @Test(dataProvider = "data-searches")
    public void UniversalSearchTest(String fileName) {
        Main main = PageFactory.initElements(driver, Main.class);
        driver.get(ConfigProvider.BASE_URL);
        main.maxSize();
        ConfigTestSearch configTestSearch = new ConfigTestSearch(fileName);
        By linkToPage = By.xpath(ConfigTestSearch.url_link_to_page);
        driver.findElement(linkToPage).click();
        SoftAssert softAssert = new SoftAssert();
        By searchOnPage = By.xpath(ConfigTestSearch.search_on_page);
        WebElement webElementSearchOnPage = driver.findElement(searchOnPage);
        webElementSearchOnPage.sendKeys(ConfigTestSearch.word_on_page);
        webElementSearchOnPage.sendKeys(Keys.ENTER);
        By searchCheckOnPage = By.xpath(ConfigTestSearch.search_check_on_page);
        WebElement webElementEmptyOnPage = driver.findElement(searchCheckOnPage);
        String testSearchCheckOnPage = webElementEmptyOnPage.getText();
        softAssert.assertEquals(testSearchCheckOnPage, "Ви шукали – "+ConfigTestSearch.assert_search_on_page);
        softAssert.assertEquals(ConfigTestSearch.word_on_page, ConfigTestSearch.assert_search_on_page);
        softAssert.assertAll();
    }

    @DataProvider(name = "data-links")
    public Object[][] dataLinkProvider(){
        String path = "src/main/resources/link_tests";
        File dir = new File(path);
        String dirName = dir.getName();
        File[] arrFiles = dir.listFiles();
        String[][] arrFilesName = new String[arrFiles.length][1];
        int i = 0;
        for (File file : arrFiles)
        {
            arrFilesName[i][0] = dirName + "/" + file.getName();
            i++;
        }
        return arrFilesName;
    }

    @DataProvider(name = "data-imgs")
    public Object[][] dataImgProvider(){
        String path = "src/main/resources/img_tests";
        File dir = new File(path);
        String dirName = dir.getName();
        File[] arrFiles = dir.listFiles();
        String[][] arrFilesName = new String[arrFiles.length][1];
        int i = 0;
        for (File file : arrFiles)
        {
            arrFilesName[i][0] = dirName + "/" + file.getName();
            i++;
        }
        return arrFilesName;
    }

    @DataProvider(name = "data-searches")
    public Object[][] dataSearchProvider(){
        String path = "src/main/resources/search_tests";
        File dir = new File(path);
        String dirName = dir.getName();
        File[] arrFiles = dir.listFiles();
        String[][] arrFilesName = new String[arrFiles.length][1];
        int i = 0;
        for (File file : arrFiles)
        {
            arrFilesName[i][0] = dirName + "/" + file.getName();
            i++;
        }
        return arrFilesName;
    }

}
