package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {
    public WebDriver driver;

    public InventoryPage(WebDriver driver) {

        this.driver = driver;
    }

    private By title = By.cssSelector("span[class='title']");
    private By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By cartButton = By.xpath("//a[@class='shopping_cart_link']");


    public WebElement getTitle(){
        return driver.findElement(title);
    }

    public WebElement getAddToCartButton(){
        return driver.findElement(addToCartButton);
    }

    public WebElement getCartButton(){
        return driver.findElement(cartButton);
    }

    public void addToCart(){
        getAddToCartButton().click();
    }

    public void openCart(){
        getCartButton().click();
    }


}
