import org.junit.Assert;
import org.junit.Test;

public class SingletonTest {
    @Test
    public void singleton() {
        Singleton classUnderTest = Singleton.getInstance();
        classUnderTest.testField = 8;
        Singleton classUnderTest2 = Singleton.getInstance();
        Assert.assertTrue(classUnderTest2.testField == 8);
        classUnderTest2.testField = 4;
        Assert.assertTrue(classUnderTest.testField == 4);
    }
}
