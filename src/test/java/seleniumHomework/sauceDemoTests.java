package seleniumHomework;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjectsHomework.*;

public class sauceDemoTests {


        WebDriver driver;
        private final String SWAGLABS_URL = "https://www.saucedemo.com/";


        @BeforeMethod(alwaysRun = true)
        public void openBrowser() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        }

        @AfterMethod(alwaysRun = true)
        public void closeBrowser(){
            driver.quit();
        }



        //1.scenārijs

        @Test
        public void loginWithCorrectName() throws InterruptedException {

            driver.get(SWAGLABS_URL);
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("standard_user", "secret_sauce");
            InventoryPage inventoryPage = new InventoryPage(driver);
            Assert.assertEquals(inventoryPage.getTitle().getText(),"PRODUCTS");
            System.out.println(inventoryPage.getTitle());
            inventoryPage.addToCart();
            inventoryPage.openCart();
            CartPage cartPage = new CartPage(driver);
            Assert.assertEquals(cartPage.getCartPageName().getText(), "YOUR CART");
            cartPage.clickCheckout();
            CheckoutPage checkoutPage = new CheckoutPage(driver);
            checkoutPage.loginCheckoutPage("Diāna", "Stepule", "LV-1082");
            checkoutPage.getContinueButton().click();
            CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
            Assert.assertEquals(checkoutOverviewPage.getItemName().getText(), "Sauce Labs Backpack");
            Assert.assertEquals(checkoutOverviewPage.getPrice().getText(), "$29.99");
            checkoutOverviewPage.finishButton();
            Thread.sleep(5000);
        }

    }





