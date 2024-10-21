import java.util.HashMap;

public class WordFrequencyCounter {
    public static HashMap<String, Integer> count(String data) {
        HashMap<String, Integer> wordHashMap = new HashMap<String, Integer>();
        String[] wordArray = data.replaceAll("[^\sa-zA-Z0-9]", "").toLowerCase().split(" ");
        for (String word : wordArray) {
            if (wordHashMap.containsKey(word)) {
                wordHashMap.put(word, wordHashMap.get(word) + 1);
            } else {
                wordHashMap.put(word, 1);
            }
        }
        return wordHashMap;
    }
}
