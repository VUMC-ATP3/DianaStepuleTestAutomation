package mavenTestNGHomework;


import calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;


public class TestingOfCalculater {

   Calculator calculator = new Calculator();

//    private Calculator calculator;
//    @BeforeClass
//    public void beforeClass(){
//        this.calculator = new Calculator();
//    }


    @BeforeMethod
    public void beforeMethod(){

        System.out.println("Tests ir sācies");
    }

    @AfterMethod

    public void afterMethod(){
        System.out.println("Tests ir beidzies");

    }
    @AfterTest
    public void AfterTest() {
        System.out.println("Visi testi ir pabeigti");
    }



    @Test
    public void testSum(){
        System.out.println("Summas tests");
        Assert.assertEquals (calculator.add(14,12),26);
    }


    @Test
    public void testMinus(){
        System.out.println("Dalīšanas tests");
        Assert.assertEquals (calculator.substract(79,12),67);
    }


    @Test
    public void testMultiply(){
        System.out.println("Reizināšanas tests");
        Assert.assertEquals (calculator.multiply(34,2),68);
    }


    @Test
    public void testDevide(){
        System.out.println("Dalīšanas tests");
        Assert.assertEquals (calculator.divide(88,4),22);
    }




}
