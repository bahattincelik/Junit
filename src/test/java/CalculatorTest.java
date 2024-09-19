import org.example.Calculator;
import org.junit.*;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class CalculatorTest {
    private Calculator calculator;

    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Setting up test class...");
    }

    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setting up test...");
    }

    @Test
    public void testAdd() {
        assertEquals(7, calculator.add(3, 4));
    }

    @Test
    public void testSubtract() {
        assertEquals(-1, calculator.subtract(3, 4));
    }

    @Test
    public void testMultiply() {
        assertEquals(12, calculator.multiply(3, 4));
    }


    @Test
    @Parameters({"0", "1", "1000"})
    public void testDivide(int a, int b, double expected) {
        double result = calculator.divide(a, b);
        Assert.assertEquals(expected, result, 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        calculator.divide(1, 0);
    }

    @Test
    public void testDivideByZeroWithRule() {
        try {
            calculator.divide(1, 0);
            Assert.fail("Expected ArithmeticException to be thrown");
        }catch (ArithmeticException e) {
            // Test passed
        }
    }

    @Ignore("This test is not implemented yet")
    @Test
    public void ignoreTest() {
        Assert.fail("This test is not implemented yet");
    }
    @After
    public void tearDown() {
        System.out.println("Tearing down test...");
    }
    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("Tearing down test class...");
    }

}
