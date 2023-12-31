package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Main;
import pages.WebBrowserSettings;
import ui.configs.ConfigProvider;
import ui.configs.ConfigTestLink;

import java.io.File;

public class UniversalLinkTests extends WebBrowserSettings {

    @Test(dataProvider = "data-provider")
    public void UniversalTest(String fileName) {
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

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(){
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
}
