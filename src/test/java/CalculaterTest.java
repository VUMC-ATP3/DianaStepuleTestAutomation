import ClassroomSix.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculaterTest {

    private Calculator calculator;

    @Test
    public void testSum(){
        System.out.println("Test sum");
        Calculator calculator = new Calculator();
        int actualResult = calculator.sum(5,3);
        int expectedResult = 8;
        Assert.assertEquals(actualResult,expectedResult);
        Assert.assertEquals (calculator.sum(5,3),8);
        Assert.assertEquals (calculator.sum(-5,-3),-8);
        Assert.assertEquals (calculator.sum(2,0),2);
        System.out.println("This is my first test");

    }

    @Test
    public void dalihanaTest(){
        System.out.println("Dalishanas sum");
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.dal(8.2,2.0),4.1);
    }

    @Test
    public void izteiksmesTest(){
        System.out.println("Test izteiksmes");
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.dal(8.2,2.0) + calculator.sum(1,2),7.1);
    }

    @BeforeClass
    public void  beforeClass(){
        System.out.println("Izpildas before class");
        this.calculator = new Calculator();
    }

    @BeforeMethod
      public void beforeTest(){
        System.out.println("Izpildas before test");
    }
}
