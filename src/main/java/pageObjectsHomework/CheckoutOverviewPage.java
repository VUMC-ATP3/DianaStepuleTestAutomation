package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {
    public WebDriver driver;
    public CheckoutOverviewPage(WebDriver driver) { this.driver = driver;
    }

    private By itemName = By.xpath("//div[@class='inventory_item_name']");
    private By price = By.xpath("//div[@class='inventory_item_price']");
    private By finishButton = By.xpath("//button[@id='finish']");


    public WebElement getItemName(){
        return driver.findElement(itemName);
    }

    public WebElement getPrice(){
        return driver.findElement(price);
    }

    public WebElement getFinishButton(){
        return driver.findElement(finishButton);
    }

    public void finishButton (){
        getFinishButton().click();
    }




}
