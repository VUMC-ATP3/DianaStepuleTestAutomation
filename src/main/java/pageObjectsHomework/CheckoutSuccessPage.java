package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutSuccessPage {

        public WebDriver driver;

        public CheckoutSuccessPage(WebDriver driver) {
        this.driver = driver;
        }


        private By ThankYouText = By.xpath("//h2[@class='complete-header']");
        private By backHomeButton = By.id("back-to-products");


        public WebElement getThankYouText(){

            return driver.findElement(ThankYouText);
        }

        public WebElement getBackHomeButton(){

            return driver.findElement(backHomeButton);
        }

        public void backHomeButton (){
        getBackHomeButton().click();
        }
}
