package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    public WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By cartPageName = By.cssSelector("span[class='title']");
    private By checkoutButton = By.xpath("//button[@id='checkout']");



    public WebElement getCartPageName(){
        return driver.findElement(cartPageName);
    }


    public WebElement getCheckoutButton(){
        return driver.findElement(checkoutButton);
    }

    public void clickCheckout(){
        getCheckoutButton().click();
    }
}

