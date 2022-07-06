package classroomEight;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.acodemyShop.MainPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AcodemyShopTest {

    WebDriver driver;
    WebDriverWait wait;


    @BeforeMethod
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void testSearch() throws InterruptedException {
        driver.get("http://shop.acodemy.lv");
        MainPage mainPage = new MainPage(driver);
        mainPage.searchProduct("Beanie");
        mainPage.searchProduct("T-shirt");
        Assert.assertEquals(mainPage.getSearchResultText(), "Showing all 3 results");
        Thread.sleep(5000);
        mainPage.searchProduct("Hoodie");
        Assert.assertEquals(mainPage.getSearchResult().size(), 3);
        Thread.sleep(5000);

        List<WebElement> results = mainPage.getSearchResult();
        for (int i = 0; i < results.size(); i++) {
            System.out.println("###############");
            System.out.println(results.get(i).findElement(By.cssSelector("span.woocommerce-Price-amount")).getText());
        }
    }



    @Test
    public void tesSwithcTab() throws InterruptedException {
        driver.get("http://shop.acodemy.lv");
        System.out.println("Tabu skaits: " + driver.getWindowHandles().size());
        driver.findElement(By.cssSelector("div[class='site-info'] a")).click();
        System.out.println(driver.getTitle());
        System.out.println("Tabu skaits: " + driver.getWindowHandles().size());

        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getTitle());
        driver.switchTo().window(tabs.get(0));
        System.out.println(driver.getTitle());
        driver.close();
        tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
    }

    @Test
    public void testJavascript() throws InterruptedException {
        driver.get("http://shop.acodemy.lv");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("alert('AUAU')");
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.cssSelector("li.post-18"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(4000);

    }

    @Test
    public void mouseActionsTest() throws InterruptedException {
        driver.get("https://www.w3schools.com/howto/howto_css_dropdown.asp");
        driver.findElement(By.id("accept-choices")).click();
        Actions actions = new Actions(driver);
        WebElement hoverMeButton = driver.findElement(By.xpath("//button[text()='Hover Me']"));
        actions.moveToElement(hoverMeButton).perform();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Link 1")).click();
        Thread.sleep(2000);
    }

    @Test     public void keyBoardActionTest() throws InterruptedException {
        driver.get("https://www.selenium.dev/documentation/webdriver/actions_api/keyboard/");
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("k").perform(); //simulacija Cntr+k nosiesshana
        Thread.sleep(5000);
    }

    @Test
    public void mous() throws InterruptedException {
        driver.get("https://www.selenium.dev/downloads");

    }


    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }

}
