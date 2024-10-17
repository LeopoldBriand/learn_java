package beginner;

import org.junit.Assert;
import org.junit.Test;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class HelloWorldTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Test
    public void appHasAGreeting() {
        System.setOut(new PrintStream(outputStreamCaptor));
        HelloWorld classUnderTest = new HelloWorld();
        classUnderTest.print();
        Assert.assertEquals("Hello world", outputStreamCaptor.toString().trim());
    }
}
