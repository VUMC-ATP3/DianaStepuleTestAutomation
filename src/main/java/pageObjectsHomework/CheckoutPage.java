package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

        public WebDriver driver;
        public CheckoutPage(WebDriver driver) {
            this.driver = driver;
        }


        private By firstName = By.id("first-name");
        private By lastName = By.id("last-name");
        private By zipCode = By.id("postal-code");
        private By continueButton = By.xpath("//input[@id='continue']");
        private By errorMessage = By.cssSelector("h3[data-test='error']");


        public void loginCheckoutPage(String firstName, String lastName, String zipCode){
        getFirstName().sendKeys(firstName);
        getLastName().sendKeys(lastName);
        getZipCode().sendKeys(zipCode);
    }

        public WebElement getFirstName(){
        return driver.findElement(firstName);
        }

        public WebElement getLastName(){
        return driver.findElement(lastName);
        }

        public WebElement getZipCode(){
        return driver.findElement(zipCode);
        }

        public WebElement getErrorMessage(){
        return driver.findElement(errorMessage);
        }

        public WebElement getContinueButton() {
        return driver.findElement(continueButton);
        }


}

