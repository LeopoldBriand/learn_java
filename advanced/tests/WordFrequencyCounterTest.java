import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class WordFrequencyCounterTest {
    @Test
    public void counter() {
        HashMap<String, Integer> words = WordFrequencyCounter.count(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, Lorem ipsum dolor sit amet, consectetur adipiscing elit, Lorem ipsum dolor ");
        Assert.assertTrue(words.containsKey("lorem"));
        Assert.assertTrue(words.get("lorem") == 3);
        Assert.assertTrue(words.containsKey("ipsum"));
        Assert.assertTrue(words.get("ipsum") == 3);
        Assert.assertTrue(words.containsKey("dolor"));
        Assert.assertTrue(words.get("dolor") == 3);
        Assert.assertTrue(words.containsKey("sit"));
        Assert.assertTrue(words.get("sit") == 2);
        Assert.assertTrue(words.containsKey("amet"));
        Assert.assertTrue(words.get("amet") == 2);
        Assert.assertTrue(words.containsKey("consectetur"));
        Assert.assertTrue(words.get("consectetur") == 2);
        Assert.assertTrue(words.containsKey("adipiscing"));
        Assert.assertTrue(words.get("adipiscing") == 2);
        Assert.assertTrue(words.containsKey("elit"));
        Assert.assertTrue(words.get("elit") == 2);
        Assert.assertTrue(words.size() == 8);
    }
}
