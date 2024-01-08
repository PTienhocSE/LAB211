package excute;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Counter {
    private Map<Character, Integer> charCount = new HashMap<>();
    private Map<String, Integer> wordCount = new HashMap<>();

    public void wordCounter(String content) {
        StringTokenizer tokenizer = new StringTokenizer(content);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!wordCount.containsKey(token)) {
                wordCount.put(token, 1);
            } else {
                wordCount.put(token, wordCount.get(token) + 1);
            }
        }
    }

    public void charCounter(String content) {
        content = content.toLowerCase();
        for (char ch : content.toCharArray()) {
            if (!Character.isSpaceChar(ch)) {
                charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
            }
        }
    }

    public Map<String, Integer> getWordCount() {
        return wordCount;
    }

    public Map<Character, Integer> getCharCount() {
        return charCount;
    }
}