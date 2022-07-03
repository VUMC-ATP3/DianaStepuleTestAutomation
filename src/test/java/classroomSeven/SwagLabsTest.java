package classroomSeven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

import java.util.List;

public class SwagLabsTest {

    WebDriver driver;
    private final String SWAGLABS_URL = "https://www.saucedemo.com/";
    private final String LOCAL_URL = "file://C:\\Users\\Indiana\\OneDrive\\Desktop\\DianaStepuleTestAutomation\\target\\elements.html";

    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){
        //atveram browseri
       driver = new ChromeDriver();
       driver.manage().window().maximize();


    }



    @Test
    public void testErrorMessage()  throws InterruptedException {
        //veiksim visas darbibas, lai notestetu error message

        driver.get(SWAGLABS_URL);
        WebElement userNameInputField = driver.findElement(By.id("user-name")); //atrast elementu pec selektora id #.....
        userNameInputField.sendKeys("standard_user"); //ievadit datus fieldaa
        WebElement userPasswordInputField = driver.findElement(By.name("password"));
        userPasswordInputField.sendKeys("");
        //atradisim LOGIN pogu BY CSS SELEKTORS
        WebElement loginButton = driver.findElement(By.cssSelector("input#login-button")); //csselektors input,  input[ = '']
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "Epic sadface: Password is required";

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);

        // test iztiram login




        Thread.sleep(5000); //pauze un 5 sekundem
    }

    @Test
    public void testSuccessfullLogin() throws InterruptedException {
        driver.get(SWAGLABS_URL);
        WebElement userNameInputField = driver.findElement(By.id("user-name")); //atrast elementu pec selektora id #.....
        userNameInputField.sendKeys("standard_user"); //ievadit datus fieldaa
        WebElement userPasswordInputField = driver.findElement(By.name("password"));
        userPasswordInputField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("input#login-button"));
        loginButton.click();

        WebElement titleText = driver.findElement(By.cssSelector("span[class='title'"));
        Assert.assertEquals(titleText.getText(),"PRODUCTS");

        WebElement linkedInLink = driver.findElement(By.cssSelector("li[class='social_linkedin']>a"));
        linkedInLink.click();

        Select sortDropDown = new Select(driver.findElement(By.className("product_sort_container")));
        sortDropDown.selectByValue("hilo");

        WebElement addFleeceJacketToCardButtons = driver.findElement(By.xpath(//button[@id='add-to-cart-sauce-labs-fleece-jacket']));


        Thread.sleep(5000); //pauze un 5 sekundem




    }


//    @Test
//
//    public void testSamplePage() throws InterruptedException {
//        driver.get(LOCAL_URL);
//        WebElement vards = driver.findElement(By.id("fNameID"));
//        vards.sendKeys("Diana");
//        WebElement uzvards = driver.findElement(By.id("lNameID"));
//        uzvards.sendKeys("Stepule");
//        WebElement informacija = driver.findElement(By.name("description"));
//        informacija.clear();
//        informacija.sendKeys("Si ir info par mani");
//        WebElement studentCheckBox = driver.findElement(By.id("studentID"));
//        studentCheckBox.click();
//        WebElement radioButtonJava = driver.findElement(By.id("javaID"));
//        System.out.println(radioButtonJava.isSelected());
//        radioButtonJava.click();
//        System.out.println(radioButtonJava.isSelected());
//        radioButtonJava.isSelected();
//        Select milakaKrasaDropdown = new Select(driver.findElement(By.id("colorsID")));
//        milakaKrasaDropdown.selectByIndex(0);
//        milakaKrasaDropdown.selectByIndex(1);
//
//        List<WebElement> saraksts = milakaKrasaDropdown.getOptions();
//        for (int i = 0; i < saraksts.size(); i++){
//            System.out.println(saraksts.get(i).getText());
//        }
//
//        Thread.sleep(5000);
//    }

    @Test
    public void testErrorMessageWithPOM(){
        driver.get(SWAGLABS_URL);

        LoginPage loginPage = new LoginPage(driver);
        LoginPage getUsernameField().sendKeys("");
    }



    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        //aizveram browseri
        driver.quit();
    }
}
