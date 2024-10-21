import org.junit.Assert;
import org.junit.Test;

public class FactorialCalculationTest {
    @Test
    public void factorial() {
        FactorialCalculation classUnderTest = new FactorialCalculation();
        Integer expected = 40320;
        Integer result = classUnderTest.factorial(8);
        Assert.assertEquals(expected, result);
    }
}
