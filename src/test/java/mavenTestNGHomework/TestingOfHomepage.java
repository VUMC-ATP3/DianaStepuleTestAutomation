package mavenTestNGHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestingOfHomepage {

    WebDriver chromeBrowser;

    @BeforeMethod

    public void openBrowser() {
        this.chromeBrowser = new ChromeDriver();
    }

    @AfterMethod

    public void quitBrowser() {
        chromeBrowser.quit();
    }


    @Test
    public void testPageTitleOne() {
        chromeBrowser.navigate().to("https://www.madaracosmetics.com/lv/");
        chromeBrowser.manage().window().maximize();
        String expectedTitle = "MÁDARA Organic Skincare";
        String actualTitle = chromeBrowser.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testPageTitleTwo() {
        chromeBrowser.navigate().to("https://www.dinozoo.lv/");
        chromeBrowser.manage().window().maximize();
        String expectedTitle = "DINO ZOO – viss nepieciešamais Tavam mīlulim | DINO ZOO";
        String actualTitle = chromeBrowser.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }





}
