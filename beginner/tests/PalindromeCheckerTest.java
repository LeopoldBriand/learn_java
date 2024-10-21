import org.junit.Assert;
import org.junit.Test;

public class PalindromeCheckerTest {
    @Test
    public void palindromeWithEvenNumberOfChars() {
        boolean result = PalindromeChecker.checker("noon");
        Assert.assertTrue(result);
    }

    @Test
    public void palindromeWithOddNumberOfChars() {
        boolean result = PalindromeChecker.checker("level");
        Assert.assertTrue(result);
    }

    @Test
    public void notPalindrome() {
        boolean result = PalindromeChecker.checker("palindrome");
        Assert.assertFalse(result);
    }

    @Test
    public void palindromeWithSpaces() {
        boolean result = PalindromeChecker.checker("never odd or even");
        Assert.assertTrue(result);
    }

    @Test
    public void palindromeWithPunctuationAndUpperCase() {
        boolean result = PalindromeChecker.checker("A man, a plan, a canal, Panama!");
        Assert.assertTrue(result);
    }
}
